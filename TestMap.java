import java.io.Serializable;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Author: Sweetie77
 * Created: 2019/4/23
 */
public class TestMap {
    public static void main(String[] args) {
        Map<Person, String> map = new HashMap<>();
        map.put(new Person(15,"张三"),"zs");
        System.out.println(map.get(new Person(15,"张三")));
    }
}


class Person {
    private Integer age;
    private String name;

    public Person(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person)obj;
        return Objects.equals(age,person.age)&&
                Objects.equals(name,person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age,name);
    }
    /*@Override
    public String toString() {
        return "Person{" + "age=" + age + ",name='" + name + '\'' + '}';
    }
    */

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

