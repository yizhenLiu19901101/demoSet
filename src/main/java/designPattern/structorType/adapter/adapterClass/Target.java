package designPattern.structorType.adapter.adapterClass;

/**
 * 目标类
 * @author liuyizhen
 *
 */
public interface Target {
	
	/**
     * 这是源类Adaptee也有的方法
     */
    public void sampleOperation1(); 
    
    /**
     * 这是源类Adapteee没有的方法
     */
    public void sampleOperation2(); 
}
