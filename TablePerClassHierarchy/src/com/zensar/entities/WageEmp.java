package com.zensar.entities;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author akansh_sai
 * @version 1.0
 * @creation_date 27th sep 2019 11:50am
 * @modification_date 27th sep 2019 11:50am
 * @copyright Zensar technologies. All rights reserved
 *
 */
@Entity
@DiscriminatorValue("b")
public class WageEmp extends Employee {
	
private int hours;
private float rate;

public WageEmp() {
	// TODO Auto-generated constructor stub
}

public WageEmp(int empId, String name, LocalDate joinDate, double salary, int hours, float rate) {
	super(empId, name, joinDate, salary);
	this.hours = hours;
	this.rate = rate;
}

public int getHours() {
	return hours;
}

public void setHours(int hours) {
	this.hours = hours;
}

public float getRate() {
	return rate;
}

public void setRate(float rate) {
	this.rate = rate;
}

@Override
public String toString() {
	return "WageEmp [hours=" + hours + ", rate=" + rate + "]";
}






}
