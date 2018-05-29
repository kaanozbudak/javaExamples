package phoneGuide;

public class Person
{
    private String name;
    private String phoneNumber;

    public Person(String name,String phoneNumber)
    {
        this.name=name;
        this.phoneNumber=phoneNumber;
    }

    public String getName()
    {
        return name;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public static Person newPerson(String name,String phoneNumber)
    {
        return new Person(name,phoneNumber);
    }
}
