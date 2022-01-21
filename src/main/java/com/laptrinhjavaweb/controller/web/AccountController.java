package com.laptrinhjavaweb.controller.web;

import java.security.Principal;
import java.security.SecureRandom;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.IUserService;

@Controller
public class AccountController {
	@Autowired
	IUserService IUserService;
	@Autowired
	ICategoryService ICategoryService;
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	MailSender mailSender;
	
	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	public ModelAndView registerPage() {
		ModelAndView mav = new ModelAndView("Register");
		mav.addObject("user", new UserDTO());
		return mav;	
	}
	@RequestMapping("/register/save")
	public ModelAndView saveAccount(@ModelAttribute("user") UserDTO user, BindingResult errors) {
		ModelAndView mav = new ModelAndView("redirect:/dang-nhap");	
		if(user.getUserName().trim().length()==0) {
			errors.rejectValue("userName", "user", "Tên đăng nhập không được để trống!");
		}
		else if(userRepo.findOneByUserNameAndStatus(user.getUserName(), 1) != null) {
			errors.rejectValue("userName", "user", "Tên đăng nhập đã tồn tại!");
			
		}
		if(user.getPassword().trim().length()==0) {
			errors.rejectValue("password", "user", "Mật khẩu không được để trống!");
		}
		if(user.getFullName().trim().length()==0) {
			errors.rejectValue("fullName", "user", "Họ tên không được để trống!");
		}
		if(user.getEmail().trim().length()==0) {
			errors.rejectValue("email", "user", "email không được để trống!");
		}
		else if(userRepo.findOneByEmailAndStatus(user.getEmail(), 1) != null) {
			errors.rejectValue("email", "user", "email đã tồn tại!");
		}
		if(errors.hasErrors()) {
			mav.addObject("alert", "danger");
			mav.addObject("message","Vui lòng nhập đầy đủ!");
			System.out.println(1);
			return new ModelAndView("Register");
		}else {
			user.setRoleCode("USER");
			IUserService.save(user);
		}
		
		return mav;
	}
	@RequestMapping("/password/forget")
	public ModelAndView forgetPassword(Principal principal) {
		ModelAndView mav = new ModelAndView("Reset-Password");
		mav.addObject("user",new UserEntity());
		return mav;
	}
	@RequestMapping("/password/forget/save")
	public ModelAndView saveforgetPassword(Principal principal,@ModelAttribute("user") UserEntity user) {
			ModelAndView mav =new ModelAndView("redirect:/password/forget");	 
			UserEntity entity = userRepo.findOneByUserNameAndStatus(principal.getName(), 1);
			if(user.getPassword()== "") {
				mav.addObject("message", "Vui lòng nhập mật khẩu mới");		
			}else {
				entity.setPassword(BCrypt.hashpw(user.getPassword().trim(), BCrypt.gensalt(10)));
				userRepo.save(entity);
				return new ModelAndView("redirect:/dang-nhap");
			}
			
			return mav;
	}
	public void sendMail(String from, String to, String subject, String content){
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(from);
		mailMessage.setTo(to);
		mailMessage.setSubject(subject);
		mailMessage.setText(content);
		mailSender.send(mailMessage);
	}
	public String randomPassword() {
  
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
 
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 8; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
        return sb.toString();
	}
	@RequestMapping("/dang-nhap/email")
	public ModelAndView email() {
		ModelAndView mav = new ModelAndView("/forget_Password");
		return mav;
	}
	@RequestMapping("/reset-password")
	public ModelAndView resetPassword(@RequestParam("email") String email) {
		ModelAndView mav = new ModelAndView("redirect:/dang-nhap");	
		UserEntity user = userRepo.findOneByEmailAndStatus(email, 1);
		if(user != null) {
			String random = randomPassword();
			sendMail("hungshakugan@gmail.com", email, "Tâm Linh Số - Đổi mật khẩu", random);
			user.setPassword(BCrypt.hashpw(random, BCrypt.gensalt(10)));
			userRepo.save(user);
			mav.addObject("message","Vui lòng vào email để xem mật khẩu");	
		}else {
			ModelAndView mav1 = new ModelAndView("/forget_Password");
			mav.addObject("message", "Không tìm thấy email");
			return mav1;
		}
		
		return mav;
	}
	@RequestMapping("/user/information")
	public ModelAndView showInfo(Principal principal) {
		ModelAndView mav = new ModelAndView("/web/myinfo");
		mav.addObject("user", userRepo.findOneByUserNameAndStatus(principal.getName(), 1));
		return mav;
	}
	@ModelAttribute("category")
	public List<CategoryEntity> listCategory(){
		List<CategoryEntity> category = ICategoryService.findAll();
		return category;
	}
	
}
