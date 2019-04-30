package designPattern.createType.factory.abstractFactory;


import designPattern.createType.factory.plainFactory.Sender;

/**
 * 抽象工厂
 * @author liuyizhen
 *
 */
public interface Provider {
	/**
	 * 生产
 	 * @return
	 */
	Sender produce();
}
