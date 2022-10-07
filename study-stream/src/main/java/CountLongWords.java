import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CountLongWords {
    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("file/aaa.txt")), StandardCharsets.UTF_8);
        // Split into words: nonletters are delimiters
        List<String> words = Arrays.asList(contents.split("\\PL+"));

        System.out.println(System.currentTimeMillis());
        long count = 0;
        for (String w : words) {
            if (w.length() > 12) {
                count++;
            }
        }
        System.out.println(count);

        System.out.println(System.currentTimeMillis());

        count = words.stream().filter(w -> w.length() > 12).count();
        System.out.println(count);

        System.out.println(System.currentTimeMillis());

        count = words.parallelStream().filter(w -> w.length() > 12).count();
        System.out.println(count);

        System.out.println(System.currentTimeMillis());
    }
}
