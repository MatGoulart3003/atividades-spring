package br.edu.univas.si7.topicos.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.univas.si7.topicos.product.entities.ProductEntity;
import br.edu.univas.si7.topicos.product.repository.ProductRepository;
import br.edu.univas.si7.topicos.product.support.ObjectNotFoundException;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductRepository repo;
	
	@GetMapping("/v3")
	public ProductEntity helloProduct() {
	return new ProductEntity(1, "Product v3", 2.45f, true);
	}
	
	@GetMapping("v1")
 	public String hello() {
		return"Hello v1!";
	}
	
	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public List<ProductEntity> getAllProducts() {
		return repo.findAll();
	}
	
	@GetMapping("/{code}")
	public ProductEntity getProductById(@PathVariable Integer code) {
		Optional<ProductEntity> obj = repo.findById(code);
		if(obj.isPresent()) {
			return obj.get();
		}
		return obj.orElseThrow(() -> new ObjectNotFoundException("Product " + code + " not found"));
	}
	
	@GetMapping("/active")
	@ResponseStatus(HttpStatus.OK)
	public List<ProductEntity> getAllProductsActive() {
		return repo.findByActive(true);
	}
}
