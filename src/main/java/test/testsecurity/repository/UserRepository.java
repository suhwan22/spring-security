package test.testsecurity.repository;

import test.testsecurity.entity.UserEntity;

import java.util.List;

public interface UserRepository {

	public void save(UserEntity userEntity);
	public UserEntity findById(Long id);
	public UserEntity findByName(String name);
	public List<UserEntity> findUsers();
}
