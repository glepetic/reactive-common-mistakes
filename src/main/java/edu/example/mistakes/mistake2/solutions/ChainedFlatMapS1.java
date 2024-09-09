package edu.example.mistakes.mistake2.solutions;

import edu.example.mistakes.mistake2.util.Account;
import edu.example.mistakes.mistake2.util.CreditCardService;
import edu.example.util.GenericUtils;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Slf4j
public class ChainedFlatMapS1 {

    public static void main(String[] args) {

        UUID userId = UUID.randomUUID();

        CreditCardService.getAccountId(userId)
                .flatMap(ChainedFlatMapS1::getCardIdAndBuildAccount)
                .subscribe(acc -> log.info("Received: {}", acc));

        GenericUtils.sleepSeconds(5);

    }

    private static Mono<Account> getCardIdAndBuildAccount(int accId) {
        return Mono.just(accId)
                .flatMap(CreditCardService::getCardId)
                .map(cardId -> new Account(accId, cardId));
    }

}
