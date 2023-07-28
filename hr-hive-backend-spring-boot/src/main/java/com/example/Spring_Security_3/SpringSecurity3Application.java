package com.example.Spring_Security_3;

import com.example.Spring_Security_3.config.AppConstant;
import com.example.Spring_Security_3.entity.Role;
import com.example.Spring_Security_3.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringSecurity3Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurity3Application.class, args);
	}

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void run(String... args) throws Exception {

		try{
			Role role = new Role();
			role.setId(AppConstant.ROLE_ADMIN);
			role.setName("ROLE_ADMIN");

			Role role1 = new Role();
			role1.setId(AppConstant.ROLE_NORMAL);
			role1.setName("ROLE_NORMAL");

			List<Role> roles = List.of(role, role1);
			List<Role> resultRoles = this.roleRepository.saveAll(roles);
			resultRoles.forEach(r->{
				System.out.println(r.getName());
			});
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
