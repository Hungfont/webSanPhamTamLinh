package com.laptrinhjavaweb.controller.admin;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.entity.roleEntity;
import com.laptrinhjavaweb.repository.RoleRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.IUserService;



@Controller(value = "userControllerOfAdmin")
public class UserController {
	@Autowired 
	UserRepository userRepo;
	
	@Autowired
	RoleRepository roleRepo;
	
	@Autowired
	IUserService IUserService;
	
	@RequestMapping(value = "/admin/user/list", method = RequestMethod.GET)
	public ModelAndView listPage(@RequestParam("page") Optional<Integer> p,@RequestParam("keyword") Optional<String> s) {
		ModelAndView mav = new ModelAndView("admin/User/list");
		Sort sort = new Sort(Sort.Direction.DESC, "createdDate");
		Pageable page = new PageRequest(p.orElse(0), 6,sort);
		if(s.isPresent()) {
			mav.addObject("user",userRepo.search(s.get().trim(), page));
		}else {
			
			mav.addObject("user", userRepo.findAll(page));
		}
		return mav;
	}
	@RequestMapping("/admin/user/create")
	public ModelAndView addUser() {
		ModelAndView mav = new ModelAndView("admin/User/edit");
		mav.addObject("user",new UserDTO());
		return mav;
	}
	@RequestMapping("/admin/user/edit/{id}")
	public ModelAndView editUser(@PathVariable("id") Long id){
		ModelAndView mav = new ModelAndView("admin/User/edit");
		UserDTO user = IUserService.findById(id);
		mav.addObject("user", user);
		return mav;
	}
	@RequestMapping("/admin/user/save")
	public ModelAndView saveUser(@ModelAttribute("user") UserDTO user, BindingResult errors) {
		ModelAndView mav = new ModelAndView("redirect:/admin/user/list");
		if(user.getUserName().trim().length()== 0) {
			errors.rejectValue("userName","user", "Vui lòng nhập username!");
		}else if(userRepo.findOneByUserNameAndStatus(user.getUserName(), 1)!=null) {
			if(user.getId() == null) {
				errors.rejectValue("userName","user", "Username đã tồn tại!");
			}
		}
		if(user.getPassword().trim().length()== 0) {
			errors.rejectValue("password","user", "Vui lòng nhập password!");
		}
		if(user.getFullName().trim().length()== 0) {
			errors.rejectValue("fullName","user", "Vui lòng nhập họ tên!");
		}
		if(user.getEmail().trim().length()== 0) {
			errors.rejectValue("email","user", "Vui lòng nhập email!");
		}else if(userRepo.findOneByEmailAndStatus(user.getEmail(), 1) !=null){
			if(user.getId() == null) {
				errors.rejectValue("email","user", "Email đã tồn tại!");
			}
			
		}
		if(!errors.hasErrors()) {
			IUserService.save(user);			
		}else {
			mav.addObject("alert","danger");
			mav.addObject("message","Vui lòng nhập đúng!");
			return new ModelAndView("/admin/User/edit");
		}
		return mav;
	}
	@ModelAttribute("roles")
	public List<roleEntity> listRoles(){
		List<roleEntity> role = roleRepo.findAll();
		return role;
		
	}
}
