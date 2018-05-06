package com.chanhlt.springsecurity;

import java.io.InputStream;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	public FirebaseApp firebaseApp() throws Exception {
		if (FirebaseApp.getApps().size() > 0) {
			return FirebaseApp.getApps().get(0);
		}
		InputStream serviceAccount = new ClassPathResource("test-app-service-account.json").getInputStream();

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl("https://test-app-fd08f.firebaseio.com/").build();

		FirebaseApp.initializeApp(options);

		return FirebaseApp.getApps().get(0);
	}
}
