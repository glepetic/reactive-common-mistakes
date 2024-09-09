package edu.example.mistakes.mistake5.solutions;

import edu.example.util.GenericUtils;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Slf4j
public class WrongOperator2S1 {

    public static void main(String[] args) {

        Mono.just("John Doe")
                .mapNotNull(WrongOperator2S1::toNameSize)
                .subscribe(GenericUtils::onNextLog, GenericUtils::onErrorLog, GenericUtils::onCompleteLog);

        GenericUtils.sleepSeconds(5);

    }

    private static Integer toNameSize(String name) {
        return Objects.equals(name, "John Doe") ? null : name.length();
    }

}
