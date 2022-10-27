package src;
import io.reactivex.rxjava3.core.Observable;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static java.lang.Thread.sleep;

public class Async_example {
    public static void main(String[] args) throws InterruptedException {

        //Source data
        List<String> fruits = Arrays.asList("Apple", "Orange", "Pear", "Banana", "Strawberry", "Lemon");

        //Observer with a timer: retrieves data each 1.5s
        Observable observer = Observable.fromIterable(fruits)
                        .concatMap(
                                item -> Observable.interval(1500, TimeUnit.MILLISECONDS)
                                .take(1)
                                .map(second -> item)
                        );

        System.out.println("I'm going to buy some fruits \n");

        //Subscriber
        observer.subscribe(
                item -> System.out.println("We got an: " + item)
        );

        System.out.println("I already made the order! \n");

        sleep(12000);
    }
}

