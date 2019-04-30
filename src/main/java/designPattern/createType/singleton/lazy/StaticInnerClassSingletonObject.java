package designPattern.createType.singleton.lazy;

import designPattern.utils.LoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 登记式/静态内部类，懒汉式
 * @author liuyizhen
 *
 */
public class StaticInnerClassSingletonObject {
    /**
     * 单例类持有人
     */
    private static class SingletonHolder {
        private static final StaticInnerClassSingletonObject INSTANCE = new StaticInnerClassSingletonObject();
    }

    /**
     * 无参构造器
     */
    private StaticInnerClassSingletonObject(){
    }

    /**
     * 实例化方法
     * @return
     */
    public static final StaticInnerClassSingletonObject getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 展示信息
     */
    public void showMessage(){
        LoggerUtil.info("this is a static inner class singleton");
    }
}
