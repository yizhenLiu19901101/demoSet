package designPattern.createType.factory.abstractFactory;


import designPattern.createType.factory.plainFactory.MailSender;
import designPattern.createType.factory.plainFactory.Sender;

/**
 * 具体工厂
 * @author liuyizhen
 *
 */
public class SendMailFactory implements Provider{

	public Sender produce() {
		return new MailSender();
	}	
}
