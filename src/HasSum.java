import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class HasSum {
    public static boolean hasSum(int goal, String path){
        BufferedReader reader = openFile(path);
        Integer i = nextInt(reader);
        while (i != null) {
            // anderer Ansatz: zuerst Set daraus machen? oder ArrayList?
            BufferedReader reader2 = openFile(path);
            Integer j = nextInt(reader2);
            while(j != null && i + j != goal){
                j = nextInt(reader2);
            }
            if (j != null){
                return true;
            }
            i = nextInt(reader);
        }
        return false;
    }

    static BufferedReader openFile(String path) {
        try {
            return Files.newBufferedReader(Path.of(ClassLoader.getSystemResource(path).toURI()));
        } catch (Exception e) {
            throw new RuntimeException("Can't open file: " + path, e);
        }
    }

    static Integer nextInt(BufferedReader reader) {
        try {
            String line = reader.readLine();
            if (line != null) return Integer.parseInt(line);
            else return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        boolean result = hasSum(1234567, "numbers.txt");
        System.out.println(result);
    }
}