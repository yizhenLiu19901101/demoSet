package designPattern.createType.singleton;

import designPattern.createType.singleton.lazy.UnsafeThreadSingletonObject;
import designPattern.utils.LoggerUtil;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SingletonTest {

    /**
     * 测试懒汉式
     */
    @Test
    public void testUnSafeSingleton() {
        LoggerUtil.info("使用非线程安全的懒汉式单例模式创建对象");
        //获取单例对象
        UnsafeThreadSingletonObject object1 = UnsafeThreadSingletonObject.getInstance();
        //获取单例对象
        UnsafeThreadSingletonObject object2 = UnsafeThreadSingletonObject.getInstance();
        LoggerUtil.info("object1 `s hashCode: " + System.identityHashCode(object1)+","+"objectw `s hashCode: " + System.identityHashCode(object2));
        Assert.assertEquals(object1,object2);
    }

}
