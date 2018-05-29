package lab4MidTerm;

interface Animal
{
    void move ();
}

class Dog implements Animal
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
class Cat implements Animal
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
public class AnimalTest
{
    public static void main(String args[])
    {
        Animal[] animals = {new Dog(),new Cat()};
        for (Animal temp:animals)
        {
            temp.move();
        }
        System.out.println("");
        Animal o1 = new Dog();
        o1.move();

       // Cat o2 =(Cat) new Animal();
    }
}
