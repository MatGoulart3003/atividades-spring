package br.edu.univas.si7.topicos.product;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.edu.univas.si7.topicos.product.controller.ProductController;
import br.edu.univas.si7.topicos.product.entities.ProductEntity;

public class HelloTest {
	
	ProductController controller = new ProductController();
	@Test
	public void testHello() {
	String resultado = controller.hello();
	assertEquals("Hello v1!", resultado);
	}
	
	@Test
	public void testProduct(){
		ProductEntity product = controller.helloProduct();
		assertEquals(product.getCode(),1);
		assertEquals(product.getName(),"Product v3");
		assertEquals(product.getPrice(),2.45f);
		assertEquals(product.isActive(),true);
	}
}
