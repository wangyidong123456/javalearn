package spring4_d02_c04;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//ר����������jdk�Ķ�̬��������-ͨ��
public class JdkProxyFactory1{
	//��Ա����
	private Object target;
	//ע��targetĿ�����
	public JdkProxyFactory1(Object target) {
		this.target = target;
	}
	
	public Object getProxyObject(){
		//����1��Ŀ�������������
		//����2��Ŀ�����ʵ�ֵĽӿ�
		//����3���ص���������
		/**����һ�����ڲ�ʵ��new InvocationHandler()��ָ��������*/
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler(){

			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				//����Ǳ���ķ�����ִ�м�¼��־����
				if(method.getName().equals("save")){
					writeLog();
				}
				//Ŀ�����ԭ���ķ���ִ��
				Object object = method.invoke(target, args);//����Ŀ������ĳ�����������ҷ���Ŀ�����
				return object;
			}
			
		});
	}
	
	//��¼��־
	private static void writeLog(){
		System.out.println("��ǿ���룺д��־�ˡ�����");
	}

}
