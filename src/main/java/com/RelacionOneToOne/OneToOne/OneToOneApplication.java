package com.RelacionOneToOne.OneToOne;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.RelacionOneToOne.OneToOne.domain.Client;
import com.RelacionOneToOne.OneToOne.domain.User;
import com.RelacionOneToOne.OneToOne.repository.ClientRepository;
import com.RelacionOneToOne.OneToOne.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.processing.SupportedOptions;
import javax.xml.transform.Source;

@SpringBootApplication
public class OneToOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneToOneApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(
			UserRepository userRepository,
			ClientRepository clientRepository
	){
			return args -> {
				User user1 = userRepository.save(new User(null, "so","1234"));
				Client client1 = clientRepository.save(new Client(null, "Sofi Sosa",user1));
				System.out.println(client1.toString());
			};
	}
}
