package test.testsecurity.repository;

import test.testsecurity.entity.UserEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryUserRepository implements UserRepository{

	Map<Long, UserEntity> store = new HashMap<>();
	long sequence = 0L;

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
