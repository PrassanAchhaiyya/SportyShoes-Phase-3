package com.shoestore;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.shoestore.domain.User;
import com.shoestore.domain.security.Role;
import com.shoestore.domain.security.UserRole;
import com.shoestore.service.UserService;
import com.shoestore.utility.SecurityUtility;

@SpringBootApplication
public class ShoestoreApplication implements CommandLineRunner {
	
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ShoestoreApplication.class, args);
	}
	
	@Override
	public void run(String...args) throws Exception{
		User user1=new User();
		user1.setFirstName("John");
		user1.setLastName("Doe");
		user1.setUsername("j");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user1.setEmail("1bm14is027@bmsce.ac.in");
		Set<UserRole> userRoles=new HashSet<>();
		Role role1=new Role();
		role1.setRoleId(1);
		role1.setName("ROLE_USER");
		userRoles.add(new UserRole(user1,role1));
		
		userService.createUser(user1,userRoles);
	}

}
