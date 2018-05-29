package midTermLab4;


class Animal
{
    public void move()
    {
        System.out.println("Animals are moving");
    }
}

class Dog extends Animal
{
    public void move()
    {
        System.out.println("Dogs are moving");
    }
    public void dogMethod()
    {
        System.out.println("This is actually a dog");
    }
}
class Cat extends Animal
{
    public void move()
    {
        System.out.println("Cats are moving");
    }
    public void catMethod()
    {
        System.out.println("This is actually a cat");
    }
}
public class AnimalTest2
{
    public static void main(String args[])
    {
        Animal[] animals = {new Dog(),new Cat()};
        for (Animal temp:animals)
        {
            temp.move();
        }
        System.out.println("");

        Animal animal1 = new Dog();      // animal <- dog upcasting
        animal1.move();

        Animal animal2 = new Cat();
        Cat cat = (Cat) animal2;        // cat <- animal // downcasting
        cat.move();
        System.out.println("");
        if( cat instanceof Animal)
        {
            System.out.println("true");
        }
        else
        {
            System.out.println("false");
        }
    }
}