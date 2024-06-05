package test.testsecurity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinDto {
	private String username;
	private String password;

	@Override
	public String toString() {
		return "[username: " + username + ", password: " + password + "]";
	}
}
