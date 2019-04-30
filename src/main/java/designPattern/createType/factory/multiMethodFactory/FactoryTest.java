package designPattern.createType.factory.multiMethodFactory;


import designPattern.createType.factory.abstractFactory.SendFactory;
import designPattern.createType.factory.plainFactory.Sender;

/**
 * 多方法工厂
 * @author  milo
 */
public class FactoryTest {
        /**
         * 程序入口
         * @param args
         */
        public static void main(String[] args) {
                SendFactory factory = new SendFactory();

                Sender sender = factory.produceMail();
                sender.send();

                sender = factory.produceSms();
                sender.send();
    }  
}
