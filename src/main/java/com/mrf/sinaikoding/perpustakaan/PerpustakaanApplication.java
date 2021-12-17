package com.mrf.sinaikoding.perpustakaan;

import com.mrf.sinaikoding.perpustakaan.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootApplication
public class PerpustakaanApplication {

	public static void main(String[] args) {
		SpringApplication.run(PerpustakaanApplication.class, args);
	}

	public static User getCurrentUser() {
		try {
			Object pricipal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			if (pricipal != null && pricipal.getClass().equals(User.class)) {
				return (User) pricipal;
			}
		} catch (Exception ignore) {}

		return null;
	}

}
