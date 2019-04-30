package demo;

import designPattern.utils.LoggerUtil;
import org.junit.Test;

/**
 * 知识测试
 */
public class KnowledgeTest {

    @Test
    public void testString(){
        //开辟内存空间
        String a = new String("123");
        //指向常量
        String b = "123";
        String d = "12";
        String e = "3";
        String c = d+e;
        LoggerUtil.info(System.identityHashCode(a)+"");
        LoggerUtil.info(System.identityHashCode(b)+"");
        LoggerUtil.info(System.identityHashCode(c)+"");
        LoggerUtil.info((a == b)+"");


    }
}
