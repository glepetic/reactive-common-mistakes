package edu.example.mistakes.mistake5;

import edu.example.util.GenericUtils;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

public class WrongOperator3 {

    public static void main(String[] args) {

        Mono.just(possiblyNullBigDecimal())
                .map(Object::toString)
                .subscribe(GenericUtils::onNextLog, GenericUtils::onErrorLog, GenericUtils::onCompleteLog);

        GenericUtils.sleepSeconds(5);

    }

    private static BigDecimal possiblyNullBigDecimal() {
        return null; // real logic here
    }

}
