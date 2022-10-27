package src;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.BiFunction;
import java.util.Arrays;
import java.util.List;

public class ZipFuntion_example {
    public static void main(String[] args) {

        //Source data
        List<String> fruits     = Arrays.asList("Apple",   "Orange",   "Pear",   "Banana", "Strawberry", "Lemon");
        List<String> vegetables = Arrays.asList("Pumpkin", "Broccoli", "Tomato", "Carrot", "Lettuce",    "Onion", "Spinach");

        //Observer 1
        Observable obs1 = Observable.fromIterable(fruits);

        //Observer 2
        Observable obs2 = Observable.fromIterable(vegetables);

        //Observer 3
        Observable obs3 = Observable.zip(obs1, obs2, (BiFunction<String, String, String>)
                (s1, s2) -> String.format("(%s, %s)", s1, s2));

        //Subscriber
        obs3.subscribe(
                item -> System.out.println("I got a: " + item)
        );
    }
}
