package com.zensar.daos;

import java.util.List;

import com.zensar.entities.User;
/**
* @author NAS
* @version 2.0
* @creation_date 21st sep 2019 5.29PM
* @modification_date 28th sep 2019 11.19AM
* @copyright Zensar technologies. All rights reserved
* @description it is data access object interface.
* 			   it is used in persistance layer of application.
*
*
*/

public interface UserDao {

	void insert(User user);
	void update(User user);
	void delete(User user);
	User getByUsername(String username);
	List<User>getAll();

}
