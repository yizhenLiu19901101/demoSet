package designPattern.createType.builder;

/**
 * 具体建造者
 * @author liuyizhen
 *
 */
public class ConcreteBuilder implements Builder {

	private Product product = new Product();

	/**
	 * 产品零件-起名字
	 */
	public void buildName() {
		//创建产品编号
		product.setName("名称：螺丝刀");
	}

	/**
	 * 产品零件-写编号
	 */
	public void buildCode() {
		//创建产品名称
		product.setCode("编号：9527");
	}

	/**
	 * 得到产品
	 */
	public Product retrieveResult() {
		return product;
	}
}
