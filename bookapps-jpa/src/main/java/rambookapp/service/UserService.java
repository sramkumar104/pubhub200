package rambookapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rambookapp.Form.Registrationform;
import rambookapp.Repository.UserRepository;
import rambookapp.com.rambookapp.util.EmailUtil;
import rambookapp.model.Student;
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private EmailUtil emailUtil;
	public Student findByEmailAndPassword(String email, String password) {

		return userRepository.findByEmailAndPassword(email, password);
	}
	public Student findByEmail(String email)
	{
		return userRepository.findByEmail(email);
	}

	
	public void register(Registrationform regUserForm) throws Exception {

		Student user = userRepository.findByEmail(regUserForm.getEmail());
		System.out.println("Is email already exists? "+ user);
		if ( user != null) {
			throw new Exception ("Email already exists!!!");
		}
		Student userObj = new Student();
		userObj.setName(regUserForm.getName());
		userObj.setEmail(regUserForm.getEmail());
		userObj.setPassword(regUserForm.getPassword());
		
		
		userRepository.save(userObj);
		String subject = "Your account has been created";
		String body = "Welcome to Revature ! You can login to your account !";
		emailUtil.send(userObj.getEmail(),subject, body);
		

	}


	
	
}
