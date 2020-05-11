package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 流操作
 * @author milo
 */
public class ListMergeAndNoRepeatDemo {
    /**
     * 主程序
     * @param args
     */
    public static void main(String[] args){
        List<Person> personListA = new ArrayList<>();
        personListA.add(new Person("bob",66));
        personListA.add(new Person("lily",33));
        personListA.add(new Person("jenny",22));
        personListA.add(new Person("jack",44));
        List<Person> personListB = new ArrayList<>();
        personListB.add(new Person("bob",66));
        personListB.add(new Person("jone",11));
        personListB.add(new Person("danny",77));
        personListB.add(new Person("rose",55));
        personListB.add(new Person("jobs",88));
        personListA.addAll(personListB);
        // 去重以前
        System.out.println("去重排序前：");
        personListA.stream().forEach(System.out::println);
        System.out.println("去重排序后：");
        //去重排序以后
        List<Person> resolvedPersonList = personListA.stream().filter(person -> person.age > 10).distinct()
                .sorted((o1, o2) -> o2.age - o1.age).collect(Collectors.toList());
        resolvedPersonList.stream().forEach(System.out::println);
    }
}

/**
 * 人-对象类
 */
class Person{
    // 姓名
    String name;
    // 年龄
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
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
