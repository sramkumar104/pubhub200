package rambookapp.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import rambookapp.Repository.UserRepository;
import rambookapp.model.Student;

@Controller
	@RequestMapping("auth")
	public class AuthenticationController {
		private static final Logger LOGGER = Logger.getLogger(AuthenticationController.class);
	@Autowired
	private UserRepository userRepository;
	@PostMapping("/login")
	public String login(@RequestParam("email") String emailId, @RequestParam("password") String password, HttpSession session)
	{
		LOGGER.info("Entering Login");
		LOGGER.debug(new Object[] { emailId, password });
		Student user = userRepository.findByEmailAndPassword(emailId, password);
		if (user != null) {
			session.setAttribute("log_user", emailId);
			LOGGER.info("login sucess");
			return "success";
		}
		else
		{
		return "fail";
	}
	}
}


