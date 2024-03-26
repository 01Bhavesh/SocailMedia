package com.example.demo.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.UserService.CustomerUserDetailsService;
import com.example.demo.config.jwtProvider;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;


@RestController
@RequestMapping("/auth")
public class AuthController {

	
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private CustomerUserDetailsService customerUserDetailsService;
	
	@PostMapping("/api/user/data")
	private AuthResponse postUser(@RequestBody User user) throws Exception
	{
		User isExist = userRepo.findByGmail(user.getGmail());
		
		if(isExist != null)
		{
			throw new Exception("Email is already in used");
		}
		
		User newU = new User();
		newU.setFirstName(user.getFirstName());
		newU.setLastName(user.getLastName());
		newU.setGmail(user.getGmail());
		newU.setPassword(passwordEncoder.encode(user.getPassword()));
		newU.setGender(user.getGender());
		
		User saved = userRepo.save(newU);
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(saved.getGmail(), saved.getPassword());
		
		String token = jwtProvider.generateToken(authentication);
		
		AuthResponse res = new AuthResponse(token,"Register Success");
		return res;
	}
	
	@PostMapping("/signin")
	public AuthResponse signin(@RequestBody LoginRequest loginRequest)
	{
		Authentication authentication = authenticate(loginRequest.getGmail(),loginRequest.getPassword());
		String token = jwtProvider.generateToken(authentication);
		
		AuthResponse res = new AuthResponse(token,"Login Success");
		return res;
	}

	private Authentication authenticate(String gmail, String password) {
		UserDetails userDetails = customerUserDetailsService.loadUserByUsername(gmail);
		
		if(userDetails == null)
		{
			throw new BadCredentialsException("Invalid User...");
		}
		if(!password.equals(userDetails.getPassword()))
		{
			throw new BadCredentialsException("Invalid User....");
		}
		return new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
	}
}
