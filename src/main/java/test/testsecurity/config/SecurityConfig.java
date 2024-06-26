package test.testsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http
				.authorizeHttpRequests((auth) -> auth
						.requestMatchers("/", "/join", "/joinProc", "/login", "/loginProc", "/userList").permitAll()
						.requestMatchers("/my/**").hasAnyRole("ADMIN", "USER")
						.requestMatchers("/admin").hasRole("ADMIN")
						.anyRequest().authenticated()
				);

		http
				.formLogin((auth) -> auth
						.loginPage("/login")
						.loginProcessingUrl("/loginProc")
						.permitAll()
				);

		http
				.logout((auth) -> auth
						.logoutUrl("/logout")
						.logoutSuccessUrl("/")
				);

		http
				.sessionManagement((session) -> session
						.sessionFixation((sessionFixation) -> sessionFixation
								.changeSessionId()
						)
				);

		http
				.sessionManagement((sessoin) -> sessoin
						.maximumSessions(1)
						.maxSessionsPreventsLogin(true)
				);

		return http.build();
	}
}
