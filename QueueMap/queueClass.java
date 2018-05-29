package QueueMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class queueClass
{
    public static void main(String args[]) throws FileNotFoundException
    {
        Queue<String> queue = new LinkedList<String>();
        queue.offer("kaan");
        queue.offer("eray");
        queue.offer("burak");

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        System.out.println("");

        Map< String, Integer> words = new TreeMap<String,Integer>();

        Scanner inFile = new Scanner(new File("story.txt"));


        while(inFile.hasNext())
        {
            String word = inFile.next();

            word = word.toLowerCase();
            word = word.replaceAll("[.;:%,]"," ");
            if (words.containsKey(word))
            {
                words.put(word, words.get(word)+1);
            }
            else
            {
                words.put(word,1);
            }
        }

        Set set = words.keySet();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext())
        {
            String key = iterator.next();
            System.out.println(key + " : " + words.get(key));
        }
    }
}
