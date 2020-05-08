package stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * 流操作
 * @author milo
 */
public class StreamDemo {
    /**
     * 主程序
     * @param args
     */
    public static void main(String[] args){
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("bob",11));
        persons.add(new Person("lily",33));
        persons.add(new Person("jenny",22));
        persons.add(new Person("jack",44));
        System.out.println(persons.stream().count());
        persons.stream().filter(person -> person.age > 10).distinct()
                .sorted((o1, o2) -> o2.age - o1.age).limit(5)
                .forEach(item -> System.out.println(item.getName()+" "+item.getAge()));
    }
}

/**
 * 内部对象类
 */
class Person{
    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
