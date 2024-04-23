package evotek.edu;


import java.io.*;

public class BufferedStreamSample {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        PrintWriter pw = null;

        try {
            br = new BufferedReader(new FileReader("D:/data/input.txt"));
            pw = new PrintWriter(new FileWriter("D:/data/output.txt"));
            String line = null;
            while ((line = br.readLine()) != null){
                System.out.println(line);
                pw.println(line);
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
