package test.testsecurity.repository;

import org.springframework.stereotype.Repository;
import test.testsecurity.entity.UserEntity;

import java.util.*;

@Repository
public class MemoryUserRepository implements UserRepository{

	Map<Long, UserEntity> store = new HashMap<>();
	long sequence = 0L;

	public boolean isExistUsername(String username) {
		Optional<UserEntity> userEntity = store.values().stream()
				.filter((user) -> user.getUsername().equals(username))
				.findAny();

		return userEntity.isPresent();
	}

	@Override
	public void save(UserEntity userEntity) {
		userEntity.setId(sequence++);
		store.put(userEntity.getId(), userEntity);
	}

	@Override
	public UserEntity findById(Long id) {
		return store.get(id);
	}

	@Override
	public UserEntity findByName(String name) {
		return store.values().stream()
				.filter((user) -> user.getUsername().equals(name))
				.findAny().get();
	}

	@Override
	public List<UserEntity> findUsers() {
		return new ArrayList<>(store.values());
	}
}
