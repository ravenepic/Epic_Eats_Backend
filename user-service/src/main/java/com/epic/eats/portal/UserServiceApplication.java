package com.epic.eats.portal;

import com.epic.eats.portal.dtos.RsaKeyConfigurationProperties;
import com.epic.eats.portal.entities.RoleEntity;
import com.epic.eats.portal.entities.UserEntity;
import com.epic.eats.portal.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyConfigurationProperties.class)
@EnableDiscoveryClient
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner initializeUser(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder){
		return args -> {
			UserEntity user = new UserEntity();
			user.setUsername("moopi");
			user.setCreate_at(LocalDateTime.now());
			user.setPassword(passwordEncoder.encode("moopi"));
			user.setRoles(List.of(new RoleEntity("USER")));
			//Save user
			userRepository.save(user);
		};
	}

}
