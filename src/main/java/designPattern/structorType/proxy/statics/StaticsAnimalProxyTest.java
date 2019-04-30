package designPattern.structorType.proxy.statics;

import designPattern.createType.factory.StaticsAnimalProxy;

/**
 * 静态代理测试类
 */
public class StaticsAnimalProxyTest {
	/**
	 * 程序入口
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * 代理类
		 */
		StaticsAnimalProxy proxy = new StaticsAnimalProxy();
		proxy.eat("苹果");
	}
}
