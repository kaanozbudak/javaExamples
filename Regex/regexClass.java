package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regexClass
{
    public static void main (String args[])
    {
        System.out.println("Find phone number:\n");
        String text = "al furaji's phone number number is" +
                "216-412-4444. He lives in in Istanbul" +
                "Furkan Agca's phone is 216-834-4332";

        Pattern pattern1 = Pattern.compile("\\d{3}(-)\\d{3}\\1\\d{4}");  //find phone number
        Matcher matcher1 = pattern1.matcher(text);
        while(matcher1.find())
        {
            System.out.println("Found : " + text.substring(matcher1.start(),matcher1.end()));
            System.out.println(matcher1.group(0));
            System.out.println(matcher1.group(1));
        }
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("Find same word back to back");
        System.out.println("\n");
        Pattern pattern2 = Pattern.compile("(\\w+)\\s+\\1");        //find same word
        Matcher matcher2= pattern2.matcher(text);
        while(matcher2.find())
        {
            System.out.println("Found : " + text.substring(matcher2.start(),matcher2.end()));
            System.out.println(matcher2.group(0));
            System.out.println(matcher2.group(1));
        }

        System.out.println("\n\nChange same word");
        Pattern pattern3 = Pattern.compile("(\\w+)\\s+\\1");        //find same word
        Matcher matcher3= pattern3.matcher(text);
        String newText = null;
        while(matcher3.find())
        {
            newText = text.substring(0,text.indexOf(matcher3.group(1)))+
                    text.substring(text.indexOf(matcher3.group(1))+
            matcher3.group(1).length(),text.length());
        }
        System.out.println(newText);
    }
}
