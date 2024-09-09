package edu.example.mistakes.mistake5.solutions;

import edu.example.util.GenericUtils;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

public class WrongOperator3S1 {

    public static void main(String[] args) {

        Mono.justOrEmpty(possiblyNullBigDecimal())
                .map(Object::toString)
                .subscribe(GenericUtils::onNextLog, GenericUtils::onErrorLog, GenericUtils::onCompleteLog);

        GenericUtils.sleepSeconds(5);

    }

    private static BigDecimal possiblyNullBigDecimal() {
        return null; // real logic here
    }

}
