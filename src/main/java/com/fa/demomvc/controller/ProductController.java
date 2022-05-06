package com.fa.demomvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fa.demomvc.entity.Product;
import com.fa.demomvc.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping("/list")
	public String getAllProduct(Model model) {

		List<Product> products = productService.findAll();
		model.addAttribute("products", products);

		return "product-list";
	}

	@RequestMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("productForm", new Product());
		return "newProduct";
	}

	@PostMapping("/save")
	public String addNewProduct(@ModelAttribute(name = "productForm") @Valid Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "newProduct";
		}
		productService.saveOrUpdate(product);
		return "redirect:/product/list";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam(name = "id") long productId) {
		System.out.println("productId=" + productId);
		productService.delete(productId);
		return "redirect:/product/list";
	}

	@RequestMapping("/update/{id}")
	public String update(@PathVariable(name = "id") long productId, Model model) {
		Product product = productService.findById(productId);
		model.addAttribute("productForm", product);
		return "newProduct";
	}
}
