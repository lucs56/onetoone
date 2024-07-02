package com.RelacionOneToOne.OneToOne;

import com.RelacionOneToOne.OneToOne.domain.Client;
import com.RelacionOneToOne.OneToOne.domain.Order;
import com.RelacionOneToOne.OneToOne.domain.User;
import com.RelacionOneToOne.OneToOne.repository.ClientRepository;
import com.RelacionOneToOne.OneToOne.repository.OrderRepository;
import com.RelacionOneToOne.OneToOne.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class OneToOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneToOneApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(
			UserRepository userRepository,
			ClientRepository clientRepository,
			OrderRepository orderRepository
	) {
		return args -> {
			User user1 = userRepository.save(new User(null, "so", "1234"));
			Client client1 = clientRepository.save(new Client(null, "Sofi Sosa", user1, null));

			Order order1 = new Order(null, "Order Details 1", client1);
			Order order2 = new Order(null, "Order Details 2", client1);

			client1.setOrders(Arrays.asList(order1, order2));

			orderRepository.save(order1);
			orderRepository.save(order2);

			System.out.println(client1.toString());
		};
	}
}

