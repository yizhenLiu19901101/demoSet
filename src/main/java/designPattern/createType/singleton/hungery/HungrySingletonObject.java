package designPattern.createType.singleton.hungery;

import designPattern.createType.singleton.lazy.DoubleLockSingletonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 饿汉式，被推荐使用
 * @author liuyizhen
 *
 */
public class HungrySingletonObject {

    /**
     * 静态私有常量
     */
    private static final Logger logger = LoggerFactory.getLogger(HungrySingletonObject.class);
    /**
     * 静态的私有成员变量
     */
    private static HungrySingletonObject instance = new HungrySingletonObject();

    /**
     * 无参构造器
     */
    private HungrySingletonObject(){}

    /**
     * 实例化方法
     * @return
     */
    public static HungrySingletonObject getInstance() {
        return instance;
    }

    /**
     * 展示信息
     */
	public void showMessage(){
        logger.info("this is a hungry singleton");
	}
}
