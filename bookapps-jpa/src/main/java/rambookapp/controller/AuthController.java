package rambookapp.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import rambookapp.Form.Registrationform;
import rambookapp.Repository.UserRepository;
import rambookapp.model.Student;
import rambookapp.service.UserService;

@Controller
	@RequestMapping("auth")
	public class AuthController {
	
	@Autowired
	private UserService userService;
		private static final Logger LOGGER = Logger.getLogger(AuthController.class);
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
			return "redirect:../books";
		}
		else
		{
		return "fail";
	}
	}
	@GetMapping("/register")
	public String showRegsiter() {
		return "register";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute @Valid Registrationform user, BindingResult result,ModelMap modelMap, 
			HttpSession session) throws Exception {
		try {

			System.out.println("Registraion Form :" + user);
			
			if (result.hasErrors()) {
				System.out.println("fron end error");
				modelMap.addAttribute("errors", result.getAllErrors());
				modelMap.addAttribute("regFormData", user );
				return "register";
			}else {
				userService.register(user);
				
				return "redirect:../";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.addAttribute("regFormData", user );
			modelMap.addAttribute("ERROR_MESSAGE", e.getMessage());
			return "register";
		}

}
	@GetMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/";
		
	}

}




