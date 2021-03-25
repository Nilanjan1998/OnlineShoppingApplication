package com.cg.onlineshopping.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping.entities.User;
import com.cg.onlineshopping.exception.UserNotFoundException;
import com.cg.onlineshopping.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginRepository loginRepo;
	Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	@Override
	public User addUser(User user) {
		logger.info("User addUser()");
		if(user == null)
			throw new UserNotFoundException("User Not Found");
		else {
			loginRepo.save(user);
			return user;
		}
	}

	@Override
	public User removeUser(int userId) {
		logger.info("User removeUser()");
		Optional<User> user = loginRepo.findById(userId);
		if(!user.isPresent())
			throw new UserNotFoundException("User Not Found");
		else {
			loginRepo.delete(user.get());
			return user.get();
		}
	}

	@Override
	public User validateUser(int userId) {
		logger.info("User validateUser()");
		String pass = loginRepo.getPassword(userId);
		User u= loginRepo.findValidateUser(userId,pass);
		if(u==null)
			throw new UserNotFoundException("User Not Found");
		else
			return u;
	}

	@Override
	public User signOut(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
