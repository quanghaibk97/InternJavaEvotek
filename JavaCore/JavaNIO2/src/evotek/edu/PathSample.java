package evotek.edu;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathSample {
    public static void main(String[] args) {
        Path path = Paths.get("D:/data");
        System.out.println(path.getFileName());
        System.out.println(path.toAbsolutePath());

        Path p1 = Paths.get("data");
        Path p2 = Paths.get("studen");
        System.out.println(p1.relativize(p2));
        System.out.println(p1.equals(p2));
    }
}
