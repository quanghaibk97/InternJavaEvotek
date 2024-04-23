package evotek.edu;

import java.io.File;
import java.io.IOException;

public class FileSample {
    public static void main(String[] args) throws IOException {
        File file = new File("D:/Data/input.txt");
        file.createNewFile();

        File dir = new File("D:/Data/tmp");
        dir.mkdir();

        System.out.println(file.exists());
        System.out.println(dir.exists());
        file.delete();
        System.out.println(file.exists());



    }
}
