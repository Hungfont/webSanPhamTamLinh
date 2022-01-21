package com.laptrinhjavaweb.controller.admin;
import java.io.File;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.OrderItemEntity;
import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.entity.ProductImage;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.repository.OrderItemRepository;
import com.laptrinhjavaweb.repository.OrderRepository;
import com.laptrinhjavaweb.repository.ProductImageRepository;
import com.laptrinhjavaweb.repository.ProductRepository;
import com.laptrinhjavaweb.service.IProductImageService;
import com.laptrinhjavaweb.service.IProductService;
@Controller	
public class ProductController {
	@Autowired
	IProductService IProductService;
	@Autowired
	ProductRepository productRepo;
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	ProductImageRepository productImagesRepo; 
	@Autowired
	IProductImageService IProductImageService;
	@Autowired
	ServletContext context;
	@Autowired 
	OrderItemRepository orderItemRepo;
	private Long idProduct;
	@RequestMapping(value = "/admin/product/list")
	public ModelAndView listPage(@RequestParam("page") Optional<Integer> p, @RequestParam("keyword") Optional<String> s) {
		ModelAndView mav = new ModelAndView("admin/Product/list");
		Sort sort = new Sort(Sort.Direction.DESC, "createdDate");
		Pageable page = new PageRequest(p.orElse(0), 6,sort);
		if(s.isPresent()) {
//			mav.addObject("model", productRepo.findAllBySkuContaining(s.get(), page));
			mav.addObject("model", productRepo.search(s.get().trim(), page));
		}else {
			mav.addObject("model",productRepo.findAll(page));
		}
		
		return mav;
	}
	@RequestMapping("/admin/product/create")
	public ModelAndView showForm() {
		ModelAndView mav = new ModelAndView("admin/Product/edit");		
		mav.addObject("product", new ProductDTO());
//		mav.addObject("product",new ProductEntity());
		return mav;
	}
	@RequestMapping(value = "admin/product/save")
	public ModelAndView saveForm(@ModelAttribute("product") ProductDTO product,@RequestParam("image") MultipartFile images,BindingResult errors){
		ModelAndView mav = new ModelAndView("redirect:/admin/product/list");		
		if(product.getSku().trim().length()==0) {
			errors.rejectValue("sku", "product", "Vui lòng nhập mã sản phẩm");
		}else if(productRepo.findOneBySku(product.getSku().trim())!= null) {
			if(product.getId() == null) {				
				errors.rejectValue("sku", "product", "Mã sản phẩm đã tồn tại");
			}
		}
		if(product.getTitle().trim().length()==0) {
			errors.rejectValue("title", "product", "Vui lòng nhập tên sản phẩm");
		}else if(productRepo.findOneByTitle(product.getTitle().trim())!= null) {
			if(product.getId() == null) {				
				errors.rejectValue("title", "product", "Tên sản phẩm đã tồn tại");
			}
		}
		if(product.getMetatitle().trim().length()==0) {
			errors.rejectValue("metatitle", "product", "Vui lòng nhập tên hiển thị");
		}else if(productRepo.findOneByMetatitle(product.getMetatitle().trim())!= null) {
			if(product.getId() == null) {
				errors.rejectValue("metatitle", "product", "Tên hiển thị đã tồn tại");
			}
		}
		if(product.getQuantity() == 0) {
			errors.rejectValue("quantity", "product", "Vui lòng nhập số lượng sản phẩm");	
		}
		if(product.getQuantity() < 0) {
			errors.rejectValue("quantity", "product", " Số lượng không hợp lệ");	
		}
		if(product.getPrice() == 0) {
			errors.rejectValue("price", "product", "Vui lòng nhập tiền sản phẩm");	
		}
		if(product.getPrice() < 0) {
			errors.rejectValue("price", "product", "Số tiền không hợp lệ");	
		}
		if(product.getSummary().trim().length() == 0) {
			errors.rejectValue("summary", "product", "Vui lòng nhập mô tả sản phẩm");	
		}
		if(product.getDiscount() < 0 || product.getDiscount() > 1) {
			errors.rejectValue("discount", "product", "Giá trị phải lớn hơn 0 và nhỏ hơn 1 ");	
		}
		if(product.getCategoryId() == -1) {
			errors.rejectValue("categoryId", "product", "Vui lòng chọn thể loại ");	
		}
		if(images.getOriginalFilename()=="") {
			if(product.getId() == null) {
				errors.rejectValue("thumbnail", "product", "Vui lòng chọn hình ảnh ");	
			}else {
				ProductEntity oldProduct = productRepo.findOne(product.getId());
				product.setThumbnail(oldProduct.getThumbnail());
			}
		}else {
			try {
				String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss-"));
				String filename = date + images.getOriginalFilename();
				File file = new File("C:/Users/Admin/eclipse-workspace/spring-mvc/src/main/webapp/images/", filename);
				images.transferTo(file);
				product.setThumbnail(filename);
			}catch (Exception e) {
			}
		}			
		if(errors.hasErrors()) {
			return new ModelAndView("/admin/Product/edit");
		}else {
			IProductService.save(product);
		}

		return mav;
	}
	@RequestMapping(value = "/admin/product/{id}")
	public ModelAndView editProduct(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView("/admin/Product/edit");		
		mav.addObject("product", IProductService.findById(id));
		return mav;
	}
	@RequestMapping(value = "/admin/product/delete/{id}")
	public ModelAndView deleteForm(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView("redirect:/admin/product/list");
		if(orderItemRepo.findOneByProduct_Id(id).size() !=0) {
			mav.addObject("message","sản phẩm đã tồn tại trong hoá đơn" );
		}else {
			if(productImagesRepo.findOneByProduct_Id(id).size()==0) {
				productRepo.delete(id);
			}else {
				for(ProductImage images :productImagesRepo.findOneByProduct_Id(id)) {
					productImagesRepo.delete(images.getId());
				}
				productRepo.delete(id);
			}
		}
		
		return mav;
	}
	@RequestMapping(value ="/admin/product/listImage/{id}")
	public ModelAndView showpageImage(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView("admin/ProductImages/list");
		mav.addObject("productImages", IProductImageService.listAll(id));
		this.idProduct = id;
		return mav;
	}
	@RequestMapping(value ="/admin/product/addImg")
	public ModelAndView showFormImage() {
		ModelAndView mav = new ModelAndView("admin/ProductImages/edit");
		mav.addObject("image", new ProductImage());
		return mav;
	}
	@RequestMapping(value ="/admin/product/saveImg")
	public ModelAndView saveImage(@RequestParam("image") MultipartFile images,@ModelAttribute("image") ProductImage productImage, HttpServletRequest req,BindingResult errors) {
		String url = "redirect:/admin/product/listImage/"+this.idProduct;
		ModelAndView mav = new ModelAndView(url);//"admin/ProductImages/edit"
		try {
			String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss-"));
			String filename = date + images.getOriginalFilename();

			File file = new File("C:/Users/Admin/eclipse-workspace/spring-mvc/src/main/webapp/images/", filename);
			images.transferTo(file);
			productImage.setName(date + images.getOriginalFilename());
			productImage.setType(images.getContentType());
			productImage.setProduct(productRepo.findOne(this.idProduct));
			productImagesRepo.save(productImage);
			mav.addObject("message","upload file thành công");
		} catch (Exception e) {
			System.out.println(e);
			mav.addObject("message","upload file thất bại");
		}
		
		return mav;
	}
	@RequestMapping(value = "/admin/productImage/delete/{id}")
	public ModelAndView deleteListImage(@PathVariable("id") Long id) {
		String url = "redirect:/admin/product/listImage/"+this.idProduct;
		ModelAndView mav = new ModelAndView(url);
		IProductImageService.delete(id);
		return mav;
	}
	
//	@RequestMapping("/admin/product/search")
//	public ModelAndView productSearch(@RequestParam("keyword") String keyword) {
//		ModelAndView mav = new ModelAndView("redirect:/admin/product/list");
//		mav.addObject("model",productRepo.search(keyword));
//		return mav;
//	}
	@ModelAttribute("categories")
	public List<CategoryEntity> getList(){
		List<CategoryEntity> category  = categoryRepository.findAll();
		return category; 
	}
}
