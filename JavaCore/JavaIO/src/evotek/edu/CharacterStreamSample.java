package evotek.edu;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStreamSample {
    public static void main(String[] args) throws IOException {
        FileReader br = null;
        FileWriter pw = null;

        try {
            br = new FileReader("D:/data/input.txt");
            pw = new FileWriter("D:/data/input.txt");
            int c = 0;

            while ((c = br.read()) != -1) {
                pw.write(c);
            }
        } finally {
            if (br != null){
                br.close();
            }
            if (pw != null){
                pw.close();
            }
        }

    }
}
