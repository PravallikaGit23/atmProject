package com.atm.service;

public interface AtmService {

	public int withDrawl(int accNo,double withdrawlAmount);

	public int deposit(int accNo,double deposit);

}
