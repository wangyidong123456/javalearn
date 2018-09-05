package spring4_d02_c04;

import org.junit.Test;

public class SpringTest {
	@Test
	public void testJdkProxy(){
		//target��Ŀ�����
		ICustomerService target = new CustomerServiceImpl();
		//ʵ����ע��Ŀ�����
		JdkProxyFactory1 jdkProxyFactory = new JdkProxyFactory1(target);
		//��ȡProxy Object�������:����Ŀ��������͵Ľӿڵ����͵������͵Ķ���
		ICustomerService proxy = (ICustomerService)jdkProxyFactory.getProxyObject();
		//����Ŀ�����ķ���
		proxy.save();
		System.out.println("��������������������������������������������������������������������������������");
		proxy.find();
	}

}
