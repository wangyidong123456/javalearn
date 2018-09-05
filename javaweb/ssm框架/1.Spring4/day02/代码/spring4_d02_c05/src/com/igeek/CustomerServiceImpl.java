package com.igeek;

public class CustomerServiceImpl implements ICustomerService {

	@Override
	public void save() {
		System.out.println("CustomerService save");
	}

	@Override
	public void find() {
		System.out.println("CustomerService find");
	}

}
