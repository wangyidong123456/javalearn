package spring4_d02_c04;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//专门用来生成jdk的动态代理对象的-通用
public class JdkProxyFactory2{
	//成员变量
	private Object target;
	//注入target
	public JdkProxyFactory2(Object target) {
		this.target = target;
	}
	
	public Object getProxyObject(){
		//参数1：目标对象的类加载器
		//参数2：目标对象实现的接口
		//参数3：回调方法对象
		/**方案二：传递内部类的对象，指定内部类*/
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),new MyInvocationHandler());
	}
	
	//自己制定内部类:类的内部可以多次使用类型
	private class MyInvocationHandler implements InvocationHandler{

		public Object invoke(Object proxy, Method method, Object[] args)
				throws Throwable {
			//如果是保存的方法，执行记录日志操作
			if(method.getName().equals("save")){
				writeLog();
			}
			//目标对象原来的方法执行
			Object object = method.invoke(target, args);//调用目标对象的某个方法，并且返回目标对象
			return object;
		}
		
	}
	
	//记录日志
	private static void writeLog(){
		System.out.println("增强代码：写日志了。。。");
	}

}

