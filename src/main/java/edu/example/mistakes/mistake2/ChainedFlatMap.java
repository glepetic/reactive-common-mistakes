package edu.example.mistakes.mistake2;

import edu.example.mistakes.mistake2.util.CreditCardService;
import edu.example.util.GenericUtils;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Slf4j
public class ChainedFlatMap { static

    private record Account(int id, int cardId) {}

    public static void main(String[] args) {

        UUID userId = UUID.randomUUID();

        CreditCardService.getAccountId(userId)
                .flatMap(accId -> Mono.just(accId)
                        .flatMap(CreditCardService::getCardId)
                        .map(cardId -> new Account(accId, cardId))
                )
                .subscribe(acc -> log.info("Received: {}", acc));

        GenericUtils.sleepSeconds(5);

    }

}
