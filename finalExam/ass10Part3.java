package finalExam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ass10Part3 {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        String name, surName, sclName;
        int age;

        System.out.println("Name: ");
        name = input.next();
        System.out.println("Surname: ");
        surName = input.next();
        System.out.println("Scl Name: ");
        sclName = input.next();

        try {
            RandomAccessFile raf = new RandomAccessFile(new File("write.txt"), "rw");
            Long FileSize = raf.length();
            raf.seek(FileSize);
            raf.writeUTF(name);
            for (int i = 0; i < 25 - name.length(); i++) {
                raf.writeByte(25);
            }
            for (int i = 0; i < 25 - surName.length(); i++) {
                raf.writeByte(25);
            }
            for (int i = 0; i < 25 - sclName.length(); i++) {
                raf.writeByte(25);
            }
            raf.close();

            String name1 = null, surName1 = null, sclName1 = null;
            int age1 = 0;

            RandomAccessFile raf1 = new RandomAccessFile(new File("write.txt"), "rw");
            Long FileSize1 = raf1.length();
            raf1.seek(0);
            long NUMRecords = FileSize1 / 79;
            for (int j = 0; j < NUMRecords; j++) {

                name1 = raf1.readUTF();
                for (int i = 0; i < 25 - name1.length(); i++) {
                    raf1.readByte();
                }

                surName1 = raf1.readUTF();
                for (int i = 0; i < 25 - surName1.length(); i++) {
                    raf1.readByte();
                }

                age1 = raf1.readInt();

                sclName1 = raf1.readUTF();
                for (int i = 0; i < 25 - sclName1.length(); i++) {
                    raf1.readByte();
                }
                System.out.println("Name: " + name1 + " Surname: " + surName1 + " Age : " + age1 + " SclName: " + sclName1);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
