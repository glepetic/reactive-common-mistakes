package edu.example.mistakes.mistake3.solutions;

import edu.example.util.GenericUtils;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;

@Slf4j
public class OnErrorResumeS2 {

    public static void main(String[] args) {

        Flux.interval(Duration.ofSeconds(1))
                .flatMap(OnErrorResumeS2::generateValue)
                .subscribe(GenericUtils::onNextLog);

        GenericUtils.sleepSeconds(30);

    }

    private static Mono<BigDecimal> generateValue(long num) {
        return Mono.just(num)
                .map(BigDecimal::valueOf)
                .map(i -> BigDecimal.ONE.divide(BigDecimal.TEN.subtract(i), 2, RoundingMode.DOWN))
                .doOnError(err -> log.error("Encountered error: {}", err.getMessage()))
                .onErrorResume(err -> Mono.just(BigDecimal.valueOf(-500)));
    }

}
