import java.util.LinkedList;
import java.util.List;

/**
 * Created by Wei Shi on 4/10/17.
 */
abstract class Animal {
    private int order;
    private String name;
    public Animal(String name) {
        this.name = name;
    }
    public void setOrder(int order) {
        this.order = order;
    }
    public int getOrder() {
        return order;
    }
    public String getName() {
        return name;
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
}
class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}
class AnimalQueue {
    private int order;
    private LinkedList<Dog> dogs;
    private LinkedList<Cat> cats;
    public AnimalQueue() {
        order = 0;
        dogs = new LinkedList<Dog>();
        cats = new LinkedList<Cat>();
    }

    public void enqueue(Animal a) {
        a.setOrder(order++);
        if (a instanceof Dog) {
            dogs.addLast((Dog)a);
        } else {
            cats.addLast((Cat)a);
        }
    }

    public Animal getAny() {
        if (dogs.isEmpty() || cats.isEmpty()) {
            if (dogs.isEmpty() && cats.isEmpty()) {
                return null;
            } else if (dogs.isEmpty()) {
                return getCat();
            } else {
                return getDog();
            }
        }
        Dog d = dogs.getFirst();
        Cat c = cats.getFirst();
        if (d.getOrder() < c.getOrder()) {
            return getDog();
        } else {
            return getCat();
        }
    }

    public Dog getDog() {
        return dogs.removeFirst();
    }

    public Cat getCat() {
        return cats.removeFirst();
    }
}
public class P3_6 {
    public static void main(String[] args) {
        Dog a = new Dog("a");
        Dog b = new Dog("b");
        Dog c = new Dog("c");
        Dog d = new Dog("d");
        Cat e = new Cat("e");
        Cat f = new Cat("f");
        Cat g = new Cat("g");
        Cat h = new Cat("h");
        AnimalQueue aq = new AnimalQueue();
        aq.enqueue(a); // dog
        aq.enqueue(e); // cat
        aq.enqueue(b); // dog
        aq.enqueue(f); // cat
        aq.enqueue(c); // dog
        aq.enqueue(d); // dog
        aq.enqueue(g); // cat
        aq.enqueue(h); // dog
        System.out.println(aq.getAny().getName());
        System.out.println(aq.getDog().getName());
        System.out.println(aq.getDog().getName());
        System.out.println(aq.getCat().getName());
        System.out.println(aq.getAny().getName());
        System.out.println(aq.getAny().getName());
        System.out.println(aq.getAny().getName());
        System.out.println(aq.getAny().getName());
    }
}
