package edu.example.mistakes.mistake1.solutions;

import edu.example.mistakes.mistake1.util.NumberService;
import edu.example.util.GenericUtils;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class HotPublisher1S1 {

    public static void main(String[] args) {

        NumberService.getValues()
                .switchIfEmpty(Flux.defer(NumberService::fallbackValue))
                .doOnNext(i -> log.info("Received value {}", i))
                .subscribe();

        GenericUtils.sleepSeconds(30);

    }

}
