package edu.example.mistakes.mistake1;

import edu.example.mistakes.mistake1.util.NumberService;
import edu.example.util.GenericUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HotPublisher2 {

    public static void main(String[] args) {

        /*
         More on this
         -> https://stackoverflow.com/questions/57870706/whats-the-point-of-switchifempty-getting-evaluated-eagerly
         -> https://www.baeldung.com/java-mono-defer
         -> https://medium.com/@ranjeetk.developer/hot-cold-publishers-java-reactive-programming-5c057c091d63
         */

        NumberService.getValues()
                .thenMany(NumberService.fallbackValue())
                .subscribe();

        GenericUtils.sleepSeconds(30);

    }


}
