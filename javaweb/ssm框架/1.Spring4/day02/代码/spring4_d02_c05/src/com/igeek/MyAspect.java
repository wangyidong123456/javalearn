package com.igeek;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

//aspectj��advice֪ͨ��ǿ�࣬����ʵ���κνӿ�
public class MyAspect {	
	//ǰ��֪ͨ�ģ���������֮ǰ��ǿ
	//Ӧ�ã� Ȩ�޿��� ��Ȩ�޲��㣬�׳��쳣���� ��¼����������Ϣ��־ 
	//������org.aspectj.lang.JoinPoint
	//���������ӵ���󣨷����İ�װ����:������������Ŀ�����
	public void before(JoinPoint joinPoint){
		//�������׳��쳣���ص�
		//��ǰ��¼�û�
		String loginName = "admin";
		System.out.println("�������ƣ�"+joinPoint.getSignature().getName());
		System.out.println("Ŀ�����"+joinPoint.getTarget().getClass().getName());
		System.out.println("�������"+joinPoint.getThis().getClass().getName());
		//�жϵ�ǰ�û���û��ִ�з���Ȩ��
		if(joinPoint.getSignature().getName().equals("find")){
			if(!loginName.equals("admin")){
				//ֻ�г�������Աadmin��Ȩ�ޣ������˲���ִ��ĳ�������������ѯ����
				throw new RuntimeException("��û��Ȩ��ִ�з�����"+joinPoint.getSignature().getName()+"������Ϊ��"+joinPoint.getTarget().getClass().getName());
			}
		}
		
	}
	
	
	//Ӧ�ó�������ҵ����صģ�������Ӫҵ����ѯ�����Զ��·����š�
	//����֪ͨ������Ŀ�귽��ִ��֮�����֪ͨ������ǿ��
	//����1�����ӵ���󣨷����İ�װ����:������������Ŀ�����
	//����2��Ŀ�귽��ִ�к�ķ���ֵ,������object��������������㣬��Ҳ����̫��㣬һ��Ҫ����
	public void afterReturing(JoinPoint joinPoint,Object returnVal){
		//�·�����:���������̵Ľӿڣ�����è������
		System.out.println("-++++++++-����֪ͨ-��ǰ�·����ŵķ���"+"-�𾴵��û��������õķ����������Ϊ��"+returnVal);
		//ͬʱ���Կ������·��󣬼�¼��־��
		System.out.println("----��־��¼�����������ͣ�"+joinPoint.getTarget().getClass().getSimpleName()
				+"�������ķ�����"+joinPoint.getSignature().getName()
				);
	}
	
	
	//Ӧ�ó�������־�����桢Ȩ�ޡ����ܼ�ء��������
	//����֪ͨ����Ŀ����󷽷���ִ��ǰ+�󣬿�����ǿ
	//����������ִ�е����ӵ����ProcessdingJoinPoint�����������ص��ǵ���proceed()����������ʱ���ִ��Ŀ�����ķ������൱��Ŀ�����ķ���ִ���ˣ�
	//�����׳�һ��Throwable  
	public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		//Ŀ�꣺����Ŀ��ƣ�
		//��������
		System.out.println("-----���������񡣡���������������");
		//ִ����Ŀ�����ķ���
		Object resultObject = proceedingJoinPoint.proceed();
		//��������
		System.out.println("-----�ύ�����񡣡���������������");
		return resultObject;//Ŀ�����ִ�еĽ��
	}

	//���ã�Ŀ���������쳣��ִ֪ͨ�С���¼�쳣��־��֪ͨ����Ա�����š��ʼ���
	//ֻ��Ŀ����󷽷��׳��쳣��֪ͨ�Ż�ִ��
	//����1����̬���ӵ㣨��������
	//����2��Ŀ�귽���׳����쳣����������㣬��Ҳ����̫���
	public void afterThrowing(JoinPoint joinPoint,Throwable ex){
		//һ�������쳣�������ʼ����߶��Ÿ�����Ա
		System.out.println("++����Ա���ã�"+joinPoint.getTarget().getClass().getName()+"�ķ�����"
		+joinPoint.getSignature().getName()+"�������쳣���쳣Ϊ��"+ex.getMessage());
	}
	
	
	//����֪ͨ�������Ƿ����쳣����ִ��
	public void after(JoinPoint joinPoint){
		//�ͷ����ݿ�����
		System.out.println("���ݿ��connection���ͷ��ˡ���������,ִ�еķ����ǣ�"+joinPoint.getSignature().getName());
	}



}
