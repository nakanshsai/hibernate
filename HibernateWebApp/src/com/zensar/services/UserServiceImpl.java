package com.zensar.services;

import java.util.List;

import com.zensar.daos.UserDao;
import com.zensar.entities.User;
import com.zensar.exception.ServiceExceptions;
/**
* @author akansh_sai
* @version 2.0
* @creation_date 21st sep 2019 5.29PM
* @modification_date 28th sep 2019 11.47AM
* @copyright Zensar technologies. All rights reserved
* @description it is data access object interface.
* 			   it is used in persistance layer of application.
*
*
*/
public class UserServiceImpl implements UserService{

	private UserDao userdao;
	
	
	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}

	@Override 
	public void addUser(User user) throws ServiceExceptions {
		userdao.insert(user);
		
	}

	@Override
	public void updateUser(User user) throws ServiceExceptions {
	     userdao.update(user);
	     
		
	}

	@Override
	public void removeUser(User user) throws ServiceExceptions {
		userdao.delete(user);
	}

	@Override
	public User findUserByUserName(String username) throws ServiceExceptions {
		// TODO Auto-generated method stub
		User user;
		user = userdao.getByUsername(username);
		return user;
		
	}

	@Override
	public List<User> findAllUsers() throws ServiceExceptions {
		// TODO Auto-generated method stub
		try {
			return userdao.getAll();
		} catch (Exception e) {
			throw new ServiceExceptions(e.getMessage());
		}
		
	}

	@Override
	public boolean validateUser(User user) throws ServiceExceptions {
		// TODO Auto-generated method stub
		
		User dbUser= findUserByUserName(user.getUsername());
		
		if(dbUser!=null && dbUser.getPassword().equals(user.getPassword()))
			return true;
		else
		    return false;
	}
	
	

}
