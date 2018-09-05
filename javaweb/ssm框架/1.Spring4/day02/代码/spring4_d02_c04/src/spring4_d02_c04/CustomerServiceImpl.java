package spring4_d02_c04;

public class CustomerServiceImpl implements ICustomerService{

	@Override
	public void save() {
		System.out.println("CustomerServiceImpl save");
	}

	@Override
	public int find() {
		System.out.println("CustomerServiceImpl find");
		return 99;
	}

}
