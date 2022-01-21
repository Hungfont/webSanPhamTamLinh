package com.laptrinhjavaweb.controller.web;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.entity.CartItemEntity;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.HoaDonEntity;
import com.laptrinhjavaweb.entity.OrderItemEntity;
import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.CartItemRepository;
import com.laptrinhjavaweb.repository.OrderItemRepository;
import com.laptrinhjavaweb.repository.OrderRepository;
import com.laptrinhjavaweb.repository.ProductRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.IOrderService;



@Controller
public class CheckOutController {
	@Autowired
	UserRepository userRepo;
	@Autowired
	ICategoryService ICategoryService;
	@Autowired
	CartItemRepository cartItemRepo;
	
	@Autowired
	IOrderService IOrderService;
	
	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	OrderItemRepository orderItemRepo;
	
	@Autowired
	ProductRepository producRepo;
	@RequestMapping("/CheckOut")
	public ModelAndView showCheckout(Principal principal) {
		ModelAndView mav = new ModelAndView("web/CheckOut/CheckOut");
		if(principal.getName() == null) {
			return new ModelAndView("redirect:/dang-nhap");
		}else {
			UserEntity user=  userRepo.findOneByUserNameAndStatus(principal.getName(), 1);
			float total = 0;
			List<CartItemEntity> list = cartItemRepo.findOneByUser_Id(user.getId());
			for(CartItemEntity item : list) {
				total += (item.getProduct().getPrice()*(1-item.getProduct().getDiscount())*item.getQuantity());
			}
			mav.addObject("product", cartItemRepo.findOneByUser_Id(user.getId()));
			mav.addObject("total",total);
		}	
		return mav;
	}
	
	@RequestMapping("/save")	
	public ModelAndView save(Principal principal, @RequestParam("first_name") String firstName,
			@RequestParam("last_name") String lastName,
			@RequestParam("email") String email,
			@RequestParam("phone") String phone,
			@RequestParam("address") String address,
			@RequestParam("note") String note) {
		ModelAndView mav = new ModelAndView("web/CheckOut/Complete"); 
	
		if(principal.getName() != null) {
			if(firstName == "" || lastName == ""||phone == ""||address == "") {
				ModelAndView mav1 = new ModelAndView("redirect:/CheckOut");
				mav1.addObject("message", "Vui lòng nhập đầy đủ thông tin");
				return mav1; 
			}else {
				float total = 0;
				HoaDonEntity order = new HoaDonEntity();
				List<OrderItemEntity> listorderItem = new ArrayList<OrderItemEntity>();
				UserEntity user = userRepo.findOneByUserNameAndStatus(principal.getName(), 1);
				List<CartItemEntity> cartItem = cartItemRepo.findOneByUser_Id(user.getId());
				order.setFirstName(firstName);
				order.setLastName(lastName);
				order.setEmail(email);
				order.setPhone(phone);
				order.setAddress(address);
				order.setNote(note);
				for(CartItemEntity item: cartItem) {
					total += item.getQuantity()*item.getProduct().getPrice()*(1-item.getProduct().getDiscount());
				}
				order.setTotal(total);
				order.setStatus(true);
				order.setUser(user);
				orderRepo.save(order);
				for(CartItemEntity item: cartItem) {
					OrderItemEntity orderItem = new OrderItemEntity();
					orderItem.setQuantity(item.getQuantity());
					orderItem.setOrder(order);
					orderItem.setProduct(item.getProduct());
					
					ProductEntity product = producRepo.findOne(item.getProduct().getId());
					product.setQuantity(product.getQuantity()- item.getQuantity());
					
					orderItemRepo.save(orderItem);
					producRepo.save(product);
					cartItemRepo.delete(item.getId());
					
				}
			}
			
			
		}else {
			return new ModelAndView("redirect:/dang-nhap");
		}
		return mav;
	}
	@RequestMapping("/order")
	public ModelAndView listOrder(Principal principal) {
		ModelAndView mav = new ModelAndView("web/ListOrder");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null && auth.isAuthenticated()) {
			if(principal!=null) {
				String username = principal.getName();
				UserEntity user = userRepo.findOneByUserNameAndStatus(username, 1);;				
				List<HoaDonEntity> hoadon = orderRepo.findOneByUser_Id(user.getId());
				List<OrderItemEntity> orderItems = new ArrayList<OrderItemEntity>();
				for(HoaDonEntity item : hoadon) {
					List<OrderItemEntity> orderItem = orderItemRepo.findOneByOrder_Id(item.getId());
					for(OrderItemEntity items : orderItem) {
						orderItems.add(items);
					}
					
				}
				mav.addObject("order", orderItems);
				
			}
			else if(principal == null){	
				return new ModelAndView("redirect:/dang-nhap");
			}
		}
		return mav;
	}
	@RequestMapping("/list/order")
	public ModelAndView list(Principal principal) {
		ModelAndView mav = new ModelAndView("web/ListOrder");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null && auth.isAuthenticated()) {
			if(principal!=null) {
				String username = principal.getName();
				UserEntity user = userRepo.findOneByUserNameAndStatus(username, 1);
				Sort sort = new Sort(Sort.Direction.DESC, "createdDate");
				Pageable page  = new PageRequest(0, 10, sort);
				Page<HoaDonEntity> hoadon = orderRepo.findOneByUser_Id(user.getId(),page);
				mav.addObject("order", hoadon);			
			}
			else if(principal == null){	
				return new ModelAndView("redirect:/dang-nhap");
			}
		}
		
		return mav;
	}
	@ModelAttribute("category")
	public List<CategoryEntity> listCategory(){
		List<CategoryEntity> category = ICategoryService.findAll();
		return category;
	}
}
