package edu.example.mistakes.mistake4.solutions;

import edu.example.mistakes.mistake4.util.BlockingService;
import edu.example.util.GenericUtils;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.UUID;

@Slf4j
public class BlockingTaskS1 {

    public static void main(String[] args) {

        UUID userId = UUID.randomUUID();

        fetchPersonName(userId)
                .subscribe(GenericUtils::onNextLog);

        log.info("Blocking/sleeping main thread while bounded elastic thread processes");

        GenericUtils.sleepSeconds(10);

    }

    private static Mono<String> fetchPersonName(UUID userId) {
        return BlockingService.fetchPersonName(userId)
                .subscribeOn(Schedulers.boundedElastic());
    }

}
