package designPattern.createType.singleton;

import designPattern.createType.singleton.lazy.UnsafeThreadSingletonObject;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SingletonTest {
    /**
     * 静态私有常量
     */
    private static final Logger logger = LoggerFactory.getLogger(SingletonTest.class);

    /**
     * 测试懒汉式
     */
    @Test
    public  void testUnSafeSingleton() {
        logger.info("使用非线程安全的懒汉式单例模式创建对象");
        //获取单例对象
        UnsafeThreadSingletonObject object1 = UnsafeThreadSingletonObject.getInstance();
        //获取单例对象
        UnsafeThreadSingletonObject object2 = UnsafeThreadSingletonObject.getInstance();
        logger.info("object1 `s hashCode: " + System.identityHashCode(object1)+","+"objectw `s hashCode: " + System.identityHashCode(object2));
        Assert.assertEquals(object1,object2);
    }

}
