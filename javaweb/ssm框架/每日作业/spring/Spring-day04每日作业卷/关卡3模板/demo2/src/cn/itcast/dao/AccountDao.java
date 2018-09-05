package cn.itcast.dao;

public interface AccountDao {
	
	public void fromMoney(String from,double money);
	
	public void toMoney(String to,double money);

}
