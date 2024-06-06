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

	@Autowired
	private UserRepository userRepository;

	/**
	 * 회원가입 로직
	 */
	public void joinProcess(JoinDto joinDto) {

		boolean isExist = userRepository.isExistUsername(joinDto.getUsername());
		if (isExist) {
			System.out.println("JoinService.joinProcess: username already exists");
			return ;
		}

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
