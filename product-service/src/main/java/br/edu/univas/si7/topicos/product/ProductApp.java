package br.edu.univas.si7.topicos.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.univas.si7.topicos.product.entities.ProductEntity;
import br.edu.univas.si7.topicos.product.repository.ProductRepository;

@SpringBootApplication
public class ProductApp implements CommandLineRunner {
	
	@Autowired
	private ProductRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(ProductApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ProductEntity p1 = new ProductEntity(1, "Arroz", 7.30f, true);
		repo.save(p1);
		ProductEntity p2 = new ProductEntity(2, "Feijão", 2.45f, false);
		repo.save(p2);
	}

}
