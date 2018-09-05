package spring4_d02_c04;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//ר����������jdk�Ķ�̬��������-ͨ��
public class JdkProxyFactory implements InvocationHandler{
	//��Ա����
	private Object target;
	//ע��target
	public JdkProxyFactory(Object target) {
		this.target = target;
	}
	
	public Object getProxyObject(){
		//����1��Ŀ�������������
		//����2��Ŀ�����ʵ�ֵĽӿ�
		//����3���ص���������
		/**��������ֱ��ʹ�õ�������Ϊ�ӿ�ʵ���࣬ʵ��InvocationHandler�ӿ�*/
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
	}
	
	//��¼��־
	private static void writeLog(){
		System.out.println("��ǿ���룺д��־�ˡ�����");
	}

	//����1���������
	//����2��Ŀ��ķ�������
	//����3��Ŀ��ķ����Ĳ���
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

}
