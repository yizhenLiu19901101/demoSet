package designPattern.structorType.proxy.cglib;


import org.assertj.core.internal.cglib.proxy.Enhancer;
import org.assertj.core.internal.cglib.proxy.MethodInterceptor;
import org.assertj.core.internal.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;


/**
 * Cglib代理（长于执行代码）
 * @author Administrator
 *
 */
public class CglibProxy implements MethodInterceptor {
    private Enhancer enhancer = new Enhancer();
	public Object getProxy(Class clazz){  
		//设置需要创建子类的类  
		enhancer.setSuperclass(clazz);  
		enhancer.setCallback(this);
		//通过字节码技术动态创建子类实例  
		return enhancer.create();  
	}

	//实现MethodInterceptor接口方法
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
	    System.out.println("前置代理");  
	    //通过代理类调用父类中的方法  
	    Object result = proxy.invokeSuper(obj, args);  
	    System.out.println("后置代理");  
	    return result;  
	}  
}  
