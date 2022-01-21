package com.laptrinhjavaweb.controller.admin;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.entity.HoaDonEntity;
import com.laptrinhjavaweb.entity.OrderItemEntity;
import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.entity.TransactionEntity;
import com.laptrinhjavaweb.repository.OrderItemRepository;
import com.laptrinhjavaweb.repository.OrderRepository;
import com.laptrinhjavaweb.repository.ProductRepository;
import com.laptrinhjavaweb.repository.TransactionRepository;
import com.laptrinhjavaweb.repository.UserRepository;

@Controller
public class OrderController {
	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	OrderItemRepository orderItemRepo;
	
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	TransactionRepository transactionRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@RequestMapping("/admin/order/list")
	public ModelAndView listOrder(@RequestParam(name = "status", defaultValue = "0" ) boolean status,
			@RequestParam("keyword") Optional<String> keyword,@RequestParam("page") Optional<Integer> p) {
		ModelAndView mav = new ModelAndView("admin/Order/list");
		Sort sort = new Sort(Sort.Direction.DESC, "createdDate");
		Pageable page = new PageRequest(p.orElse(0), 5,sort);
		if(keyword.isPresent()) {
			mav.addObject("order",orderRepo.search(keyword.get(), page));
		}
		else {
			if(status == true) {
				mav.addObject("order", orderRepo.findAllByStatus(true, page));
			}else {
				mav.addObject("order", orderRepo.findAllByStatus(false, page));
			}
		}
		return mav;
	}
	
	@RequestMapping("/admin/order/listItem/{id}")
	public ModelAndView listOrderItem(@PathVariable("id") Long orderId) {
		ModelAndView mav = new ModelAndView("admin/Order/list_Order_Item");
		mav.addObject("orderItem", orderItemRepo.findOneByOrder_Id(orderId));
		mav.addObject("order", orderRepo.findOne(orderId));
		return mav;
	}
	@RequestMapping("/admin/order/verifier/{id}")
	public ModelAndView verify(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView("redirect:/admin/order/list?status=1");
		HoaDonEntity order = orderRepo.findOne(id);
		order.setStatus(false);
		String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmmss"));
		TransactionEntity transaction = new TransactionEntity();
		transaction.setCode(date);
		transaction.setStatus(false);
		transaction.setOrder(order);
		transaction.setUser(userRepo.findOne(order.getUser().getId()));
		orderRepo.save(order);
		transactionRepo.save(transaction);
		return mav;
	}
	
	@RequestMapping("/admin/order/delete/{id}")
	public ModelAndView deleteOrder(@PathVariable("id") Long id) {
		ModelAndView mav;
		if(orderRepo.findOne(id).isStatus() == true) {
			mav = new ModelAndView("redirect:/admin/order/list?status=1");
		}else {
			mav = new ModelAndView("redirect:/admin/order/list?status=0");
		}
		if(orderRepo.findOne(id).isStatus() == true) {
			List<OrderItemEntity> orderItem = orderItemRepo.findOneByOrder_Id(id);
			for(OrderItemEntity item : orderItem) {
				ProductEntity product = productRepo.findOne(item.getProduct().getId());
				product.setQuantity(product.getQuantity() + item.getQuantity());
				productRepo.save(product);
				orderItemRepo.delete(item.getId());
			}
			orderRepo.delete(id);
			mav.addObject("message","xoá thành công");
		}else {
			TransactionEntity trans = transactionRepo.findOneByOrder_Id(id);
			if(trans.isStatus() == false) {
				List<OrderItemEntity> orderItem = orderItemRepo.findOneByOrder_Id(id);
				for(OrderItemEntity item : orderItem) {
					ProductEntity product = productRepo.findOne(item.getProduct().getId());
					product.setQuantity(product.getQuantity() + item.getQuantity());
					productRepo.save(product);
					orderItemRepo.delete(item.getId());
				}
				transactionRepo.delete(trans.getId());
				orderRepo.delete(id);	
			}else if(trans.isStatus() == true) {
				mav.addObject("message", "Hoá đơn đã thanh toán");
			}
		}
		
		return mav;
	}
	@RequestMapping("/admin/transaction/list")
	public ModelAndView transaction(@RequestParam(name = "status",	defaultValue = "0") int status,@RequestParam("search") Optional<String> keyword) {
		ModelAndView mav = new ModelAndView("/admin/listTransaction");
		Sort sort = new Sort(Sort.Direction.DESC, "createdDate");
		Pageable page = new PageRequest(0, 5,sort);		
		if(keyword.isPresent()){
			mav.addObject("transaction", transactionRepo.search(keyword.get().trim(), page));			
		}else {
			if(status == 1) {
				mav.addObject("transaction",transactionRepo.findAllByStatus(true, page));
			}else {
				mav.addObject("transaction", transactionRepo.findAllByStatus(false,page));
			}
		}
		
		
		return mav;
	}
	@RequestMapping("/admin/transaction/verify/{id}")
	public ModelAndView verifyTransaction(@PathVariable("id") Long id) {
		String url = "";
		TransactionEntity trans = transactionRepo.findOne(id);
		trans.setStatus(true);
		System.out.println(trans.isStatus());
		transactionRepo.save(trans);
		if(trans.isStatus() == true) {
			url = "redirect:/admin/transaction/list?status=1";
		}else {
			url = "redirect:/admin/transaction/list?status=0";
		}
		return new ModelAndView(url);
	}
}
