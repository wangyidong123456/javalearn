package spring4_d02_c04;

import org.junit.Test;

public class SpringTest {
	@Test
	public void testJdkProxy(){
		//target（目标对象）
		ICustomerService target = new CustomerServiceImpl();
		//实例化注入目标对象
		JdkProxyFactory1 jdkProxyFactory = new JdkProxyFactory1(target);
		//获取Proxy Object代理对象:基于目标对象类型的接口的类型的子类型的对象
		ICustomerService proxy = (ICustomerService)jdkProxyFactory.getProxyObject();
		//调用目标对象的方法
		proxy.save();
		System.out.println("————————————————————————————————————————");
		proxy.find();
	}

}
