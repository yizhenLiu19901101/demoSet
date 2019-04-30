package designPattern.structorType.decorator;

/**
 * 具体装饰
 * @author liuyizhen
 *
 */
public class Bird extends Change {
    
    public Bird(TheGreatestStage sage) {
        super(sage);
    }

    @Override
    public void move() {
        // 代码
        System.out.println("Bird move");
    }
    
 
    public void fly() {
        // 代码
        System.out.println("Bird flying");
    }
}