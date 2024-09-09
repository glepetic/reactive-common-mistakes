package edu.example.mistakes.mistake5.util;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Slf4j
public class ProcessorService {

    public static Mono<Void> triggerProcess(UUID userId) {
        return Mono.just(userId)
                .doOnNext(uuid -> log.info("Triggering process for user: {}", uuid))
                .then();
    }

}
