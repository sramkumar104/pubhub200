package rambookapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rambookapp.Form.Registrationform;
import rambookapp.Repository.UserRepository;
import rambookapp.model.Student;
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	public Student findByEmailAndPassword(String email, String password) {

		return userRepository.findByEmailAndPassword(email, password);
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

	}
	
}
