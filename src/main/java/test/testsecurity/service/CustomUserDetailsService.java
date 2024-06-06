package test.testsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import test.testsecurity.dto.CustomUserDetails;
import test.testsecurity.entity.UserEntity;
import test.testsecurity.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserEntity user = userRepository.findByName(username);
		System.out.println("user = " + user);

		if (user != null) {
			return new CustomUserDetails(user);
		}

		return null;
	}
}
