package prototype;

import designPattern.createType.prototype.Rectangle;
import designPattern.utils.LoggerUtil;
import org.junit.Assert;

/**
 * 原型模式测试类
 * @author  milo
 */
public class PrototypeTest {
	/**
	 * 程序入口
	 * @param args
	 */
	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle("红色的");
		for(int i = 0; i < 3; i++){
        	Rectangle cloneCp = (Rectangle) rectangle.clone();
			LoggerUtil.info("rectangle `s hashCode: " + System.identityHashCode(rectangle)+","+"cloneCp `s hashCode: " + System.identityHashCode(cloneCp));
			Assert.assertEquals(rectangle,cloneCp);
			cloneCp.draw();
        } 
	}
}
