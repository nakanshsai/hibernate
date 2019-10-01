package com.zensar.services;

import java.util.List;

import com.zensar.entities.User;
import com.zensar.exception.ServiceExceptions;

/**
	 * @author nas
	 * @version 1.0
	 * @creation_date 21st sep 2019 5.29PM
	 * @modification_date 21st sep 2019 5.29PM
	 * @copyright Zensar Technologies. All rights reserved.
	 * @description:It is business service interface. It is used in business layer of application.
	 */

public interface UserService {
	
	void addUser(User user) throws ServiceExceptions;
	void updateUser(User user) throws ServiceExceptions;
	void removeUser(User user) throws ServiceExceptions;
	User findUserByUserName(String username) throws ServiceExceptions;
	List<User> findAllUsers() throws ServiceExceptions;
	
	boolean validateUser(User user) throws ServiceExceptions;
}
