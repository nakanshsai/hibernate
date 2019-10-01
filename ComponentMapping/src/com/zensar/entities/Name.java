package com.zensar.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author akansh_sai
 * @creation_date 26th sept 2019 14:50pm
 * @modification_date 26th sept 2019 14:50pm
 * @version 1.0
 * @copyright Zensar technologies. All rights reserved
 * @description this is component mapping
 *
 */
@Embeddable											//objects of name table will be persisted with table of customer
public class Name {
	@Column(name = "first",length = 30)
	private String firstName;
	@Column(name ="middle")
	private String middleName;
	private String lastName;

	public Name() {
		
	}
	public Name(String firstName, String middleName, String lastName) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "Name [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + "]";
	}
	

}
