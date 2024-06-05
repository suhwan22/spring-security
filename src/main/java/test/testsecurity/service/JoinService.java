package test.testsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import test.testsecurity.dto.JoinDto;
import test.testsecurity.entity.UserEntity;
import test.testsecurity.repository.MemoryUserRepository;
import test.testsecurity.repository.UserRepository;

import java.util.List;

@Service
public class JoinService {

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	private final UserRepository userRepository = new MemoryUserRepository();

	/**
	 * 회원가입 로직
	 */
	public void joinProcess(JoinDto joinDto) {

		// 중복 이름 체크 로직 추가될 예정

		UserEntity userEntity = new UserEntity();

		userEntity.setUsername(joinDto.getUsername());
		userEntity.setPassword(bCryptPasswordEncoder.encode(joinDto.getPassword()));
		userEntity.setRole("ROLE_USER");

		userRepository.save(userEntity);
	}

	public List<UserEntity> findUsers() {
		return userRepository.findUsers();
	}
}
