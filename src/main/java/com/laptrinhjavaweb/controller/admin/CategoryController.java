package com.laptrinhjavaweb.controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.converter.CategoryConverter;
import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.repository.ProductRepository;
import com.laptrinhjavaweb.service.ICategoryService;

@Controller
@RequestMapping("/admin/category/")
public class CategoryController {
	@Autowired
	ICategoryService ICategoryService;
	@Autowired
	CategoryRepository categoryRepo;
	
	@Autowired
	CategoryConverter categoryConverter;
	@Autowired
	ProductRepository productRepo;
	@RequestMapping("list")
	public ModelAndView showPage(@RequestParam("page") Optional<Integer> p,@RequestParam("keyword") Optional<String> s) {
		ModelAndView mav = new ModelAndView("admin/Category/list");
		Sort sort = new Sort(Sort.Direction.DESC, "createdDate");
		Pageable page = new PageRequest(p.orElse(0), 5,sort);
		if(s.isPresent()) {
			mav.addObject("category", categoryRepo.search(s.get(), page));
		}else {
			mav.addObject("category", categoryRepo.findAll(page));
		}
		
		return mav;
	}
	@RequestMapping("create")
	public ModelAndView showForm() {
		ModelAndView mav = new ModelAndView("admin/Category/edit");
		mav.addObject("category",new CategoryDTO());
		return mav;
	}
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ModelAndView saveCategory(@ModelAttribute("category") CategoryDTO category, BindingResult errors ){
		ModelAndView mav = new ModelAndView("redirect:/admin/category/list");	
		if(category.getName().trim() == "") {
			errors.rejectValue("name", "category", "Vui lòng nhập thể loại!");
			return new ModelAndView("admin/Category/edit");
		}
		if(!errors.hasErrors()) {
			ICategoryService.save(category);
		}
		return mav;
	}
	@RequestMapping(value ="edit/{id}")
	public ModelAndView editCategory(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView("admin/Category/edit");
		mav.addObject("category",categoryRepo.findById(id));
		return mav;
	}
	@RequestMapping(value = "delete/{id}")
	public ModelAndView deleteCategory(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView("redirect:/admin/category/list");
		if(productRepo.findOneByCategory_id(id).size() != 0) {
			mav.addObject("message", "Thể loại này đã có sản phẩm!");
		}else{
			categoryRepo.delete(id);
		}
		
		return mav;
	}
}
