import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreatingStreams {

    public static <T> void show(String title, Stream<T> stream){
        final int SIZE =10;
        List<T> firstElements = stream.limit(SIZE+1).collect(Collectors.toList());
    }
}
