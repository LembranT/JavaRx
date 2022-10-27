package src;
import io.reactivex.rxjava3.core.Observable;
import java.util.Arrays;
import java.util.List;

public class MapFunction_example {
    public static void main(String[] args) {

        //Source data
        List<String> fruits = Arrays.asList("Apple", "Orange", "Pear", "Banana", "Strawberry", "Lemon");

        //Observer 1
        Observable obs1 = Observable.fromIterable(fruits);

        //Observer 2
        Observable obs2 = obs1.map(item -> chopFruit(item));

        //Subscriber
        obs2.subscribe(
                item -> System.out.println("I got a: " + item)
        );

    }
    public static String chopFruit(Object fruit){
        return "chopped " + fruit.toString();
    }
}
