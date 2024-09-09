package edu.example.mistakes.mistake2.solutions;

import edu.example.mistakes.mistake2.util.CreditCardService;
import edu.example.util.GenericUtils;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Slf4j
public class ChainedFlatMapS3 {

    public static void main(String[] args) {

        UUID userId = UUID.randomUUID();

        CreditCardService.getAccountId(userId)
                .flatMap(accId -> Mono.zip(Mono.just(accId), CreditCardService.getCardId(accId),
                        CreditCardService::buildAccount))
                .subscribe(GenericUtils::onNextLog);

        GenericUtils.sleepSeconds(5);

    }

}
