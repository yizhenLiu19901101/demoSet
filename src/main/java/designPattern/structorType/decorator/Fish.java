package designPattern.structorType.decorator;

/**
 * 具体装饰
 * @author liuyizhen
 *
 */
public class Fish extends Change {
    
    public Fish(TheGreatestStage sage) {
        super(sage);
    }

    @Override
    public void move() {
        // 代码
        System.out.println("Fish move");
    }
}
