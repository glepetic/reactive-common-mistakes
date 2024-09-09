package edu.example.mistakes.mistake2.util;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static edu.example.util.GenericUtils.getRandomPositiveInt;

@Slf4j
public class CreditCardService {

    public static Mono<Integer> getAccountId(UUID userId) {
        return Mono.just(userId)
                .doOnNext(uuid -> log.info("Fetching account id of user {}", uuid))
                .map(__ -> getRandomPositiveInt())
                .doOnNext(accId -> log.info("User [{}] has account id [{}]", userId, accId));
    }

    public static Mono<Integer> getCardId(int accountId) {
        return Mono.just(accountId)
                .doOnNext(accId -> log.info("Fetching card id of account {}", accId))
                .map(__ -> getRandomPositiveInt())
                .doOnNext(cardId -> log.info("Account [{}] has card id [{}]", accountId, cardId));
    }

    public static Account buildAccount(int accountId, int cardId) {
        return new Account(accountId, cardId);
    }

}
