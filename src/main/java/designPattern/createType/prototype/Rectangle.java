package designPattern.createType.prototype;


import designPattern.utils.LoggerUtil;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 三角形类
 * @author  milo
 */
@Data
public class Rectangle extends ShapeObject{

    private String label;
    /**
     * 无参构造器
      */
    public Rectangle()
    {
        type = "Rectangle";
    }

    /**
     * 有参构造器
     * @param label
     */
     public Rectangle(String label) {
         this.label = label;
         type = "Rectangle";
     }

    @Override
     public void draw() {
         LoggerUtil.info("Inside Rectangle::draw() method.");
     }
}
