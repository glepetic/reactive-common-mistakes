package edu.example.mistakes.mistake4.util;

import edu.example.util.GenericUtils;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Slf4j
public class BlockingService {

    public static Mono<String> fetchPersonName(UUID userId) {
        return Mono.just(userId)
                .doOnNext(uuid -> log.info("Fetching name for user - [{}]", uuid))
                .flatMap(__ -> Mono.fromRunnable(() -> GenericUtils.sleepSeconds(5)))
                .thenReturn("John")
                .doOnNext(name ->  log.info("Fetched name for user [{} - name: [{}]]", userId, name));
    }

}
