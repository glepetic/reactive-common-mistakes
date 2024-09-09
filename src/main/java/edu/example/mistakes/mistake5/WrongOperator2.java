package edu.example.mistakes.mistake5;

import edu.example.util.GenericUtils;
import reactor.core.publisher.Mono;

import java.util.Objects;

public class WrongOperator2 {

    public static void main(String[] args) {

        Mono.just("John Doe")
                .map(WrongOperator2::toNameSize)
                .subscribe(GenericUtils::onNextLog);

        GenericUtils.sleepSeconds(5);

    }

    private static Integer toNameSize(String name) {
        return Objects.equals(name, "John Doe") ? null : name.length();
    }

}
