package test.testsecurity.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserEntity {

	private long id;
	private String username;
	private String password;
	private String role;

	@Override
	public String toString() {
		return  "[id: " + id + ",username: " + username + ", password: " + password + ", role: " + role + "]";
	}
}
