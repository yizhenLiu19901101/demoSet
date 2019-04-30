package designPattern.createType.factory.plainFactory;

import designPattern.utils.LoggerUtil;

/**
 * 具体产品
 * @author liuyizhen
 */
public class MailSender implements Sender {

	public void send() {
		LoggerUtil.info("this is mail sender!");
	}
}
