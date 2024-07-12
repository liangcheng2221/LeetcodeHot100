import java.util.*;  
  
class Person {  
    String name;  
    int age;  
  
    Person(String name, int age) {  
        this.name = name;  
        this.age = age;  
    }  
  
    // Getter 和 Setter 省略  
}  
  
public class Main {  
    public static void main(String[] args) {  
        List<Person> people = new ArrayList<>();  
        people.add(new Person("Alice", 30));  
        people.add(new Person("Bob", 20));  
  
        Collections.sort(people, new Comparator<Person>() {  
            @Override  
            public int compare(Person p1, Person p2) { // 正数就是放在前面，负数就是放在后面
                return Integer.compare(p1.age, p2.age);  
            }  
        });  
  
        // 输出排序后的结果  
        for (Person p : people) {  
            System.out.println(p.name + ": " + p.age);  
        }  
    }  
}