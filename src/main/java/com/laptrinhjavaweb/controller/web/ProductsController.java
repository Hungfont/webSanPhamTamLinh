package com.laptrinhjavaweb.controller.web;


import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.entity.CartItemEntity;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.entity.ProductImage;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.CartItemRepository;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.repository.ProductImageRepository;
import com.laptrinhjavaweb.repository.ProductRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.ICategoryService;


@Controller
public class ProductsController {
	@Autowired
	ICategoryService ICategoryService;
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	CartItemRepository cartItemRepo;
	@Autowired
	UserRepository userRepo;
	@Autowired
	CategoryRepository categoryRepo;
	@Autowired
	ProductImageRepository productImageRepo;
	@RequestMapping("/product/{id}")
	public ModelAndView detailProduct(@PathVariable("id") Long id,Principal principal) {
		ModelAndView mav = new ModelAndView("web/DetailProduct/DetailProduct");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null && auth.isAuthenticated()) {
			if(principal!=null) {
				int maxItem = 0;
				String username = principal.getName();
				UserEntity user = userRepo.findOneByUserNameAndStatus(username, 1);
				float total = 0;
				List<CartItemEntity> list = cartItemRepo.findOneByUser_Id(user.getId());
				for(CartItemEntity item : list) {
					total += (item.getProduct().getPrice()*(1-item.getProduct().getDiscount())*item.getQuantity());
				}
				if(cartItemRepo.findOneByProduct_IdAndUser_Id(id, user.getId())!=null) {
					maxItem = productRepo.findOne(id).getQuantity() - cartItemRepo.findOneByProduct_IdAndUser_Id(id, user.getId()).getQuantity();
					mav.addObject("maxItem",maxItem);
				}else {
					maxItem = productRepo.findOne(id).getQuantity();
					mav.addObject("maxItem", maxItem);
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
		
		mav.addObject("category",ICategoryService.findAll());
		mav.addObject("detailProduct",productRepo.findOne(id));
		mav.addObject("listProduct", productRepo.findAll());
		return mav;
	}
	@ModelAttribute("category")
	public List<CategoryEntity> listCategory(){
		List<CategoryEntity> category = ICategoryService.findAll();
		return category;
	}
}
