package phoneGuide;

import java.util.ArrayList;
import java.util.Scanner;
//random access file
//startwith strong
//jlist

public class Phone
{
    private ArrayList<Person> guide;
    private String myNumber;
    Scanner input=new Scanner(System.in);

    public Phone(String myNumber)
    {
        this.myNumber=myNumber;
        this.guide=new ArrayList<>();
    }

    public boolean addNewPerson(Person newPerson)
    {
        if(findPerson(newPerson.getName())>=0)
        {
            System.out.println(newPerson.getName()+" added before by someone");
            return false;
        }
        this.guide.add(newPerson);
        return true;
    }

    public int findPerson(Person searchPerson)
    {
        return this.guide.indexOf(searchPerson);
    }
    public int findPerson(String name)
    {
        for(int i=0;i<this.guide.size();i++)
        {
           Person momentPerson=this.guide.get(i);
           if(momentPerson.getName().equals(name))
           {
               return i;
           }
        }
        return -1;
    }

    public void allPersons()
    {
        if(this.guide.size()==0)
        {
            System.out.println("There is no one\n\n");
        }
        System.out.println("**All Persons**\n");

        for(int i=0;i<this.guide.size();i++)
        {
            System.out.println((i+1)+"- "+guide.get(i).getName()+" -> "+guide.get(i).getPhoneNumber());
        }
    }
    public Person checkPerson(String name)
    {
        int position=findPerson(name);
        if(position>=0)
        {
            return guide.get(position);
        }
       return null;
    }
    public boolean deletePerson(Person deletePerson)
    {
        int position=findPerson(deletePerson);
        if(position<0)
        {
            System.out.println("There is no one");
            return false;
        }
        this.guide.remove(deletePerson);
        return true;

    }
    public boolean fixPerson(Person oldPerson,Person newPerson)
    {
        int findPosition=findPerson(oldPerson);
        if(findPosition<0)
        {
            System.out.println("There is no one");
            return false;
        }
        guide.set(findPosition,newPerson);
        System.out.println(oldPerson.getName()+" new person will be "+newPerson.getName()+" --> "+newPerson.getPhoneNumber());
        return true;

    }
    public void addNewPersonMethod()
    {
        System.out.println("Name:");
        String name=input.next();
        System.out.println("phoneGuide.Phone Number:");
        String phoneNumber=input.next();

        addNewPerson(Person.newPerson(name,phoneNumber));
    }

}
