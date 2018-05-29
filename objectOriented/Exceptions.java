package objectOriented;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Exceptions
{
    public static void main(String args[]) throws FileNotFoundException
    {
        try{
            FileOutputStream fos= new FileOutputStream("/home");
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }
}
