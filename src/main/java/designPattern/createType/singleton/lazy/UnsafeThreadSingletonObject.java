package designPattern.createType.singleton.lazy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 懒汉式，非线程安全（非线程安全是指多线程操作同一个对象可能会出现问题，
 * 而线程安全则是多线程操作同一个对象不会有问题),用的时候才创建
 * @author liuyizhen
 *
 */
public class UnsafeThreadSingletonObject {

    /**
     * 静态私有常量
     */
    private static final Logger logger = LoggerFactory.getLogger(UnsafeThreadSingletonObject.class);
    /**
     * 私有静态变量
     */
    private static UnsafeThreadSingletonObject instance;
    /**
     * 无参构造器
     */
    private UnsafeThreadSingletonObject(){
    }

    /**
     * 实例化方法
     * @return
     */
    public static UnsafeThreadSingletonObject getInstance() {
        if (instance == null) {
            instance = new UnsafeThreadSingletonObject();
        }
        return instance;
    }

    /**
     * 展示信息
     */
    public void showMessage(){
        //打印信息
        logger.info("this is unsafe thread singleton object");
    }
}
