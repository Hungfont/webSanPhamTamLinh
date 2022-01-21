package com.laptrinhjavaweb.controller.web;

import java.security.Principal;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
import com.laptrinhjavaweb.service.IProductService;

@Controller
public class CartController {
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	IProductService IProductService;
	@Autowired
	ICategoryService ICategoryService;
	@Autowired
	UserRepository userRepo;
		
	@Autowired
	CartItemRepository cartItemRepo;
	
	@RequestMapping("/Cart")
	public ModelAndView showcart(Principal principal) {
		ModelAndView mav = new ModelAndView("web/ShoppingCart/ShopingCart");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null) {
			float total = 0;
			UserEntity user = userRepo.findOneByUserNameAndStatus(principal.getName(), 1);
			List<CartItemEntity> list = cartItemRepo.findOneByUser_Id(user.getId());
			for(CartItemEntity item : list) {
				total += (item.getProduct().getPrice()*(1-item.getProduct().getDiscount())*item.getQuantity());
			}
			mav.addObject("total",total);
			mav.addObject("cart",list);	
			mav.addObject("cnt", cartItemRepo.countByUser_Id(user.getId()));
		}
		
		mav.addObject("category",ICategoryService.findAll());
		return mav;
	}
	@RequestMapping("/addToCart/{id}")
	public ModelAndView addProductToCart(@PathVariable("id") Long productId,Principal principal, HttpSession session) {
		ModelAndView mav = new ModelAndView("redirect:/Cart");	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null && auth.isAuthenticated()) {
			if(principal !=null) {
				UserEntity userEntity = userRepo.findOneByUserNameAndStatus(principal.getName(), 1);
				CartItemEntity cartItemEntity = cartItemRepo.findOneByProduct_IdAndUser_Id(productId,userEntity.getId());
				ProductEntity product = productRepo.findOne(productId);
				String url = "redirect:/category/"+product.getCategory().getId();
				int quantity = product.getQuantity();
				CartItemEntity cartItem = new CartItemEntity();
				if(cartItemEntity == null) {
					cartItem.setProduct(product);
					cartItem.setUser(userEntity);
					cartItem.setQuantity(1);
					cartItemRepo.save(cartItem);
					return new ModelAndView(url);
				}else if(cartItemEntity!=null && cartItemEntity.getQuantity() < quantity){
					cartItemEntity.setQuantity(cartItemEntity.getQuantity()+1);
					cartItemEntity.setUser(userEntity);
					cartItemEntity.setProduct(product);
					cartItemRepo.save(cartItemEntity);
					return new ModelAndView(url);
				}
				if(cartItemEntity!=null && cartItemEntity.getQuantity() == quantity) {
					
					mav.addObject("annouce", product.getMetatitle());
					
				}
			}else {
				return new ModelAndView("redirect:/dang-nhap");
			}
				
		}
 		return mav;
	}
	@RequestMapping("/addtoCart/detailProduct/{id}/{quantity}")
	public ModelAndView addDetailToCart(@PathVariable("id")  Long productId,@PathVariable("quantity")  int quantity, Principal principal) {
		ModelAndView mav = new ModelAndView("redirect:/Cart");
		if(principal !=null) {
			UserEntity userEntity = userRepo.findOneByUserNameAndStatus(principal.getName(), 1);
			CartItemEntity cartItemEntity = cartItemRepo.findOneByProduct_IdAndUser_Id(productId,userEntity.getId());
			CartItemEntity cartItem = new CartItemEntity();
			ProductEntity product = productRepo.findOne(productId);
			String url = "redirect:/product/"+productId;
			int checkquantity = product.getQuantity();
			if(cartItemEntity == null) {
				cartItem.setProduct(product);
				cartItem.setQuantity(quantity);
				cartItem.setUser(userEntity);
				cartItemRepo.save(cartItem);
				return new ModelAndView(url);
			}else if(cartItemEntity!=null && cartItemEntity.getQuantity() < checkquantity){
				cartItemEntity.setQuantity(cartItemEntity.getQuantity()+quantity);
				cartItemEntity.setUser(userEntity);
				cartItemEntity.setProduct(product);
				cartItemRepo.save(cartItemEntity);
				return new ModelAndView(url);
			}
		}else {
			return new ModelAndView("redirect:/dang-nhap");
		}
		return mav;
	}
	@RequestMapping("/delete/CartItem/{id}")
	public ModelAndView deleteCartItem(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView("redirect:/Cart");
		cartItemRepo.delete(id);
		return mav;
	}
	@ModelAttribute("category")
	public List<CategoryEntity> listCategory(){
		List<CategoryEntity> category = ICategoryService.findAll();
		return category;
	}
}
