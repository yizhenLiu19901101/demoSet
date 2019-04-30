package designPattern.createType.singleton.lazy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 双重锁，懒汉式
 * @author liuyizhen
 *
 */
public class DoubleLockSingletonObject {

	/**
	 * 静态私有常量
	 */
	private static final Logger logger = LoggerFactory.getLogger(DoubleLockSingletonObject.class);

	/**
	 * 私有成员变量
	 */
	private volatile static DoubleLockSingletonObject singleton;

	/**
	 * 无参构造器
 	 */
    private DoubleLockSingletonObject(){
	}

	/**
	 * 实例化方法
	 * @return
	 */
    public static DoubleLockSingletonObject getSingleton() {
		if (singleton == null) {
			//同步块
			synchronized (DoubleLockSingletonObject.class) {
			    if (singleton == null) {  
			        singleton = new DoubleLockSingletonObject();
			    }  
		    }  
		}  
		return singleton;  
    }

	/**
	 * 展示信息
	 */
	public void showMessage(){
		logger.info("this is a double lock singleton");
	}
}
