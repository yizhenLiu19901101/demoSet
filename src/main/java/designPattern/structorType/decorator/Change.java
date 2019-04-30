package designPattern.structorType.decorator;

/**
 * 装饰器模式,抽象装饰
 * @author liuyizhen
 *
 */
public class Change implements TheGreatestStage {
    /**
     * 私有变量
     */
    private TheGreatestStage stage;

    /**
     * 构造器
     * @param stage
     */
    public Change(TheGreatestStage stage){
        this.stage = stage;
    }
    
    @Override
    public void move() {
        // 代码
        stage.move();
    }
}

