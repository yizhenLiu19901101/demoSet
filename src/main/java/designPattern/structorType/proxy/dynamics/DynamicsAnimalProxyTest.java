package designPattern.structorType.proxy.dynamics;


import designPattern.structorType.proxy.entity.Animal;
import designPattern.structorType.proxy.entity.AnimalImpl;
import designPattern.structorType.proxy.entity.Dog;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 利用反射实现的代理，目标类需要基于统一的接口
 * @author Administrator
 *
 */
public class DynamicsAnimalProxyTest {
    /**
     * 程序入口
     * @param args
     */
    public static void main(String[] args) {
        Animal animal = new AnimalImpl();
        InvocationHandler h = new DynamicsAnimalProxy(animal);
        Animal proxy = (Animal) Proxy.newProxyInstance(Animal.class.getClassLoader(), new Class[]{Animal.class}, h);
        proxy.eat("香蕉");
        System.out.println("--------");
        Animal dog = new Dog();
        h = new DynamicsAnimalProxy(dog);
        proxy = (Animal) Proxy.newProxyInstance(Dog.class.getClassLoader(), new Class[]{Animal.class}, h);
        proxy.eat("骨头");
    }
}
