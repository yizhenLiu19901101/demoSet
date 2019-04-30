package designPattern.createType.singleton.lazy;

import designPattern.utils.LoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 懒汉式，线程安全
 * @author liuyizhen
 *
 */
public class SafeThreadSingletonObject {

    /**
     * 私有成员变量
     */
    private static SafeThreadSingletonObject instance;

    /**
     * 无参构造器
     */
	private SafeThreadSingletonObject(){}

    /**
     * 实例化方法，加synchronized是为了同步控制
     * @return
     */
	public static synchronized SafeThreadSingletonObject getInstance() {
        if (instance == null) {  
            instance = new SafeThreadSingletonObject();
        }  
        return instance;  
    }

    /**
     * 展示信息
     */
    public void showMessage(){
        //打印信息
        LoggerUtil.info("this is safe thread singleton object");
	}
}
