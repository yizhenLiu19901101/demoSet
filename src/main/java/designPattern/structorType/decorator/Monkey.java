package designPattern.structorType.decorator;

/**
 * 具体构建
 * @author liuyizhen
 *
 */
public class Monkey implements TheGreatestStage {

	@Override
    public void move() {
        //代码
        System.out.println("Monkey Move");
    }


}
