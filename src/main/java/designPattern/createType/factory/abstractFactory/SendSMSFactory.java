package designPattern.createType.factory.abstractFactory;


import designPattern.createType.factory.plainFactory.Sender;
import designPattern.createType.factory.plainFactory.SmsSender;

/**
 * 具体工厂
 * @author liuyizhen
 *
 */
public class SendSMSFactory implements Provider{

	public Sender produce() {
		return new SmsSender();
	}	
}
