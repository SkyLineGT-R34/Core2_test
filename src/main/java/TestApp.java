import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestApp {
    public static void main(String[] args) {

        Integer [][] quadMass = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.deepToString(quadMass));
        System.out.println();

        Arrays.stream(quadMass)
                .map(x -> "элемент стрима " + Arrays.deepToString(x))
                .forEach(System.out::println);
        System.out.println();

        Arrays.stream(quadMass)
                .flatMap(Arrays::stream)
                .map(x -> "элемент стрима " + x.toString())
                .forEach(System.out::println);

        Arrays.stream(quadMass)
                .map(Arrays::stream)
                .forEach(System.out::println);
        System.out.println();

        Arrays.stream(quadMass)
                .flatMap(Arrays::stream)
                .forEach(System.out::println);
        System.out.println();

        Class s = String.class;
        Class e = Void.class;
        System.out.println(e.toString());
        System.out.println(s.toString());
    }
}
