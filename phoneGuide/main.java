package phoneGuide;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class main extends JFrame
{
    private MiddlePanel middlePanel;
    Scanner input=new Scanner(System.in);
    main()
    {


        /*  boolean exit=false;
        while(!exit)
        {
            System.out.println("Your choose:");
            Scanner input=new Scanner(System.in);
            int choosed=input.nextInt();
            switch (choosed)
            {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;

                default:
                    System.out.println("Wrong");
            }
        }
        */
        middlePanel=new MiddlePanel();
        JButton showList = new JButton("ShowList");
        JButton add = new JButton("Add New phoneGuide.Person");
        JButton check = new JButton("Check phoneGuide.Person");
        JButton delete = new JButton("Delete phoneGuide.Person");
        JButton fix = new JButton("Fix phoneGuide.Person");
        JButton showMenu = new JButton("Show Menu");

        showList.setPreferredSize(new Dimension(150,100));
        add.setPreferredSize(new Dimension(150,100));
        check.setPreferredSize(new Dimension(150,100));
        delete.setPreferredSize(new Dimension(150,100));
        fix.setPreferredSize(new Dimension(150,100));
        showMenu.setPreferredSize(new Dimension(150,100));

        showList.addActionListener(new ShowList(middlePanel));
        add.addActionListener(new Add(middlePanel));
        check.addActionListener(new Check(middlePanel));
        delete.addActionListener(new Delete(middlePanel));
        fix.addActionListener(new Fix(middlePanel));
        showMenu.addActionListener(new ShowMenu(middlePanel));

        //text area

        JPanel buttonsPanelNorth = new JPanel();
        JPanel buttonsPanelSouth=new JPanel();
        JPanel textPanel=new JPanel();
        JLabel textPanelCenter=new JLabel();
        JPanel smallTextPanel=new JPanel();


        Border blackLine;
        blackLine=BorderFactory.createLineBorder(Color.cyan);
        smallTextPanel.setBorder(blackLine);


        buttonsPanelNorth.add(showList);
        buttonsPanelNorth.add(add);
        buttonsPanelNorth.add(check);



        textPanel.add(textPanelCenter);
        textPanel.add(smallTextPanel);
        textPanelCenter.setText("will be text here");


        buttonsPanelSouth.add(delete);
        buttonsPanelSouth.add(fix);
        buttonsPanelSouth.add(showMenu);

        add(buttonsPanelNorth,BorderLayout.NORTH);
        add(buttonsPanelSouth,BorderLayout.SOUTH);
        add(textPanel,BorderLayout.CENTER);




        buttonsPanelNorth.setSize(150,150);
        buttonsPanelSouth.setSize(150,150);
        textPanel.setSize(500,200);

        buttonsPanelNorth.setBackground(Color.red);
        buttonsPanelSouth.setBackground(Color.red);
        textPanel.setBackground(Color.lightGray);
        textPanelCenter.setForeground(Color.MAGENTA);


        this.setSize(500, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String args[])
    {
        System.out.println("check");
        main window =new main();
    }
}

class ShowList implements ActionListener
{
    private MiddlePanel mp;

    ShowList(MiddlePanel mpp)
    {
        mp=mpp;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        mp.ShowList();
       // JOptionPane.showMessageDialog(null, "Showed");
    }
}
class Add implements ActionListener
{
    private MiddlePanel mp;
    Add(MiddlePanel mpp)
    {
        mp=mpp;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        mp.Add();
      //  JOptionPane.showMessageDialog(null, "Added");
    }
}
class Check implements ActionListener
{
    private MiddlePanel mp;
    Check(MiddlePanel mpp)
    {
        mp=mpp;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        mp.Check();
       // JOptionPane.showMessageDialog(null, "Checked");
    }
}
class Delete implements ActionListener
{
    private MiddlePanel mp;
    Delete(MiddlePanel mpp)
    {
        mp=mpp;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        mp.Delete();
        //JOptionPane.showMessageDialog(null, "Deleted");
    }
}
class Fix implements ActionListener
{
    private MiddlePanel mp;
    Fix(MiddlePanel mpp)
    {
        mp=mpp;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        mp.Fix();
       // JOptionPane.showMessageDialog(null, "Fixed");
    }
}
class ShowMenu implements ActionListener
{
    private MiddlePanel mp;
    ShowMenu(MiddlePanel mpp)
    {
        mp=mpp;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

        mp.ShowMenu();

        //JOptionPane.showMessageDialog(null, "Showed");
    }
}
class MiddlePanel extends JPanel
{
    Phone phone=new Phone("536 705 8205");
    Scanner input=new Scanner(System.in);
    void ShowList()
    {
        System.out.println("will show list");
        phone.allPersons();
    }
    void Add()
    {
        System.out.println("will add");
        phone.addNewPersonMethod();
        System.out.println("Added");
    }
    void Check()
    {
        System.out.println("will check");
        System.out.println("Give me name who wants to find:");
        String name=input.next();
        Person findPerson=phone.checkPerson(name);

        if(findPerson==null)
        {
            System.out.println("there is no one\n");
            return;
        }
        System.out.println("Found phoneGuide.Person: "+findPerson.getName()+" ->"+findPerson.getPhoneNumber());


    }
    void Delete()
    {
        System.out.println("will delete");
        System.out.println("Give me name who wants to delete:");
        String name=input.next();
        Person findPerson=phone.checkPerson(name);
        if(phone.deletePerson(findPerson))
        {
            System.out.println("Successful");
        }

    }
    void Fix()
    {
        System.out.println("will fix");
        System.out.println("Give me name who wants to fix:");
        String name=input.next();
        Person findPerson=phone.checkPerson(name);
        if(findPerson==null)
        {
            System.out.println("There is no one");
        }
        System.out.println("Give me new name");
        String newName=input.next();
        System.out.println("Give me new phone number");
        String newPhoneNumber=input.next();
        phone.fixPerson(findPerson,Person.newPerson(newName,newPhoneNumber));

    }
    void ShowMenu()
    {
        System.out.println("**********MENU**********" +
                "\n" +
                "1--Show List\n" +
                "2--Add new phoneGuide.Person\n" +
                "3--Check phoneGuide.Person\n" +
                "4--Delete phoneGuide.Person\n" +
                "5--Fix old phoneGuide.Person\n" +
                "6--Show Menu");
    }


    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
    }
}
