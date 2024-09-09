package edu.example.mistakes.mistake1.util;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;

import static edu.example.util.GenericUtils.getRandomPositiveInt;

@Slf4j
public class NumberService {

    public static Flux<Integer> getValues() {
        return Flux.interval(Duration.ofSeconds(2))
                .map(Long::intValue)
                .doOnNext(i -> log.info("Emitting: {}", i))
                .take(10);
    }

    public static Flux<Integer> fallbackValue() {
        int defaultValue = getRandomPositiveInt();
        log.info("Returning default value >> {}", defaultValue);
        return Flux.just(defaultValue)
                .doOnNext(i -> log.info("Printed: {}", i))
                .publish()
                .autoConnect(0); // to simulate a hot publisher
    }

}
