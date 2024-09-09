package edu.example.mistakes.mistake1.solutions;

import edu.example.mistakes.mistake1.util.NumberService;
import edu.example.util.GenericUtils;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class HotPublisher2S1 {

    public static void main(String[] args) {

        NumberService.getValues()
                .thenMany(Flux.defer(NumberService::fallbackValue))
                .subscribe();

        GenericUtils.sleepSeconds(30);

    }

}
