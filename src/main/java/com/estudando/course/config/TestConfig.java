package com.estudando.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.estudando.course.entities.Category;
import com.estudando.course.entities.Order;
import com.estudando.course.entities.OrderItem;
import com.estudando.course.entities.Product;
import com.estudando.course.entities.User;
import com.estudando.course.entities.enums.OrderStatus;
import com.estudando.course.repositories.CategoryRepository;
import com.estudando.course.repositories.OrderItemRepository;
import com.estudando.course.repositories.OrderRepository;
import com.estudando.course.repositories.ProductRepository;
import com.estudando.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		Category eletronics = new Category(null, "Electronics");
		Category books = new Category(null, "Books");
		Category computers = new Category(null, "Computers");

		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		categoryRepository.saveAll(Arrays.asList(eletronics, books, computers));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		eletronics.getProducts().add(p2);
		computers.getProducts().add(p2);
		books.getProducts().add(p1);
		computers.getProducts().add(p3);
		computers.getProducts().add(p4);
		books.getProducts().add(p5);
		
		categoryRepository.saveAll(Arrays.asList(eletronics, books, computers));
		

		User u1 = new User(null, "Lucas Aranha", "lucas@gmail.com", "2121221", "7654321");
		User u2 = new User(null, "Renato Aranha", "renato@gmail.com", "7657575", "126347");

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
	}

}
