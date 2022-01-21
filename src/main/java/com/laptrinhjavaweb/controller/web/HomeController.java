package com.laptrinhjavaweb.controller.web;


import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.entity.CartItemEntity;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.CartItemRepository;
import com.laptrinhjavaweb.repository.ProductRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.ICategoryService;


@Controller(value = "homeControllerOfWeb")
public class HomeController {
	@Autowired
	ICategoryService ICategoryService;
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	CartItemRepository cartItemRepo;
	@Autowired
	UserRepository userRepo;
	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage(ModelMap model, Principal principal) {
		ModelAndView mav = new ModelAndView("web/home");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null && auth.isAuthenticated()) {
			if(principal!=null) {
				String username = principal.getName();
				UserEntity user = userRepo.findOneByUserNameAndStatus(username, 1);
				float total = 0;
				List<CartItemEntity> list = cartItemRepo.findOneByUser_Id(user.getId());
				for(CartItemEntity item : list) {
					total += (item.getProduct().getPrice()*(1-item.getProduct().getDiscount())*item.getQuantity());
				}
				mav.addObject("cart", list);
				mav.addObject("cnt", cartItemRepo.countByUser_Id(user.getId()));
				mav.addObject("total",total);
			}
			else if(principal == null){	
				mav.addObject("cnt", 0);
				mav.addObject("total",0);
			}
		}
		long id = 5;
		long week = 4;
		long top = 16;
		List<ProductEntity> product = productRepo.findOneByCategory_id(id);
		mav.addObject("best", product);
		mav.addObject("week", productRepo.findOneByCategory_id(week));
		mav.addObject("top1", productRepo.findOne(top));
		return mav;
		
	}
	
	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView("login");
		return mav;	
	}
	
	@RequestMapping(value = "/thoat", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return new ModelAndView("redirect:/trang-chu");
	}
	
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		return new ModelAndView("redirect:/dang-nhap?accessDenied");
	}
	@RequestMapping("/category/{id}")
	public ModelAndView showListProduct(@PathVariable("id") Long id, Principal principal, @RequestParam(name = "price", required = false, defaultValue = "0") int price,@RequestParam("page") Optional<Integer> p) {
		ModelAndView mav = new ModelAndView("web/ListProducts");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null && auth.isAuthenticated()) {
			if(principal!=null) {
				String username = principal.getName();
				UserEntity user = userRepo.findOneByUserNameAndStatus(username, 1);
				float total = 0;
				List<CartItemEntity> list = cartItemRepo.findOneByUser_Id(user.getId());
				for(CartItemEntity item : list) {
					total += (item.getProduct().getPrice()*(1-item.getProduct().getDiscount())*item.getQuantity());
				}
				mav.addObject("cart", list);
				mav.addObject("cnt", cartItemRepo.countByUser_Id(user.getId()));
				mav.addObject("total",total);
			}
			else if(principal == null){	
				mav.addObject("cnt", 0);
				mav.addObject("total",0);
			}
		}
		if(price == 1) {
			mav.addObject("id", id);
			mav.addObject("price", price);
			Pageable page = new PageRequest(p.orElse(0), 6,new Sort(Sort.Direction.ASC, "price"));
			mav.addObject("product", productRepo.findOneByCategory_id(id,page));
		}else if(price == 2) {
			mav.addObject("id", id);
			mav.addObject("price", price);
			Pageable page = new PageRequest(p.orElse(0), 6,new Sort(Sort.Direction.DESC, "price"));
			mav.addObject("product", productRepo.findOneByCategory_id(id,page));
		}else{
			mav.addObject("id", id);
			mav.addObject("price", price);
			Pageable page = new PageRequest(p.orElse(0), 6);
			mav.addObject("product", productRepo.findOneByCategory_id(id,page));
		}
		
		return mav;
	}
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam("search") String search) {
		ModelAndView mav = new ModelAndView("web/ListProducts");
		Pageable page = new PageRequest(0, 10);
		mav.addObject("product", productRepo.search(search,page));
		return mav;
	}
	
	@ModelAttribute("category")
	public List<CategoryEntity> listCategory(){
		List<CategoryEntity> category = ICategoryService.findAll();
		return category;
	}
} 