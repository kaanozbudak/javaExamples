package ArrayList;

public class ArrayListClass
{
    public static void main(String [] args)
    {
        MyArrayList list = new MyArrayList();
        list.add("hello");
        list.add(4);
        list.add(new java.awt.Color(5, 90, 6));


        for(int i = 0;i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }
        list.remove(1);
        System.out.println("size: " + list.size());
        System.out.println("");

        Stack stack = new Stack();

        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println("");


        System.out.println("******SLL*****");
        SLL sll = new SLL();
        sll.add("hello");
        sll.add(4);
        sll.add(new java.awt.Color(77, 32, 52));
        sll.print();
        System.out.println();
        sll.remove(0);
        sll.remove(sll.size()-1);
        sll.print();
    }
}
class MyArrayList
{
    private Object[] list;
    private int index;

    MyArrayList()
    {
        list = new Object[16];
        index = 0;
    }

    public void add(Object o)
    {
        if (index >= list.length)
        {
            Object [] newList = new Object[list.length*2];
            System.arraycopy(list, 0, newList,
                    0, list.length);
            newList[index++] = o;
            list = newList;
        }
        else
        {
            list[index++] = o;
        }
    }
    public void add(Object o,int i)
    {
        if (i<0 || i>=list.length)
        {
            throw new ArrayIndexOutOfBoundsException();
        }
        list[i]=o;
    }
    public int size()
    {
        return index;
    }
    public Object get(int i)
    {
        if(i < 0 || i >= list.length)
        {
            throw new ArrayIndexOutOfBoundsException();
        }
        return list[i];
    }
    public Object remove(int i)
    {
        if(i < 0 || i >= index)
        {
            throw new ArrayIndexOutOfBoundsException();
        }
        int itemsToRemove = index - (i+1);
        Object temp = list [i];
        if (itemsToRemove > 0)
        {
            System.arraycopy(list,i+1,list,i,index-(i+1));
        }
        index--;
        return temp;
    }
}
class Stack
{
    private MyArrayList stack;
    private int top;
    Stack()
    {
        top=0;
        stack= new MyArrayList();
    }
    void push(Object o)
    {
        stack.add(o);
    }
    Object peek()
    {
        return stack.get(stack.size()-1);
    }
    Object pop()
    {
        return stack.remove(stack.size()-1);
    }
}
class Node
{
    Object data;
    Node next;
    Node(Object d)
    {
        data=d;
        next = null;
    }
}
class SLL
{
    private Node head;
    private int size;
    SLL()
    {
        head = null;
        size = 0;
    }
    int size()
    {
        return size;
    }
    void add(Object o)
    {
        Node temp = head;
        if (head==null)
        {
            head = new Node(o);
        }
        else
        {
            while (temp.next!=null)
            {
                temp=temp.next;
            }
            temp.next = new Node(o);
        }
        size++;
    }
    void print()
    {
        Node temp = head;
        if(head==null)
        {
            System.out.println("List is empty");
        }
        else
        {
            while (temp.next!=null)
            {
                System.out.println(temp.data+"-->");
                temp=temp.next;
            }
        }
    }
    Node remove(int i)
    {
        if (i<0 || i>=size)
        {
            throw new IllegalArgumentException();
        }
        Node temp = getData(i);
        Node temp2 = head;

        if (i == 0)
        {
            head = head.next;
        }
        else
        {
            for (int j=0;j<i-1;j++)
            {
                temp2 = temp2.next;
            }
            temp2.next = temp2.next.next;
        }
        size--;
        return temp;
    }
    Node getData(int index)
    {
        if (index<0||index>=size)
        {
            throw new IllegalArgumentException();
        }
        Node temp = head;
        for (int i=0;i<index;i++)
        {
            temp = temp.next;
        }
        return temp;
    }
}
