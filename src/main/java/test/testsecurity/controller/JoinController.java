package test.testsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import test.testsecurity.dto.JoinDto;
import test.testsecurity.entity.UserEntity;
import test.testsecurity.service.JoinService;

import java.util.List;

@Controller
public class JoinController {

	private final JoinService joinService;

	public JoinController(JoinService joinService) {
		this.joinService = joinService;
	}

	@GetMapping("/join")
	public String joinP() {
		return "join";
	}

	@PostMapping("/joinProc")
	public String joinProc(JoinDto joinDto) {

		System.out.println("joinDto = " + joinDto);

		// 추후 회원가입 실패 하는 경우에 대한 처리를 해줘야 함

		joinService.joinProcess(joinDto);

		return "redirect:/login";
	}

	@GetMapping("/userList")
	public String userListP(Model model) {
		List<UserEntity> users = joinService.findUsers();

		model.addAttribute("users", users);
		return "userList";
	}
}
