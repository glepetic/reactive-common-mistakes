package edu.example.mistakes.mistake2.solutions;

import edu.example.mistakes.mistake2.util.AccountBuilderPipeline;
import edu.example.mistakes.mistake2.util.Account;
import edu.example.mistakes.mistake2.util.CreditCardService;
import edu.example.util.GenericUtils;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Slf4j
public class ChainedFlatMapS4 {

    public static void main(String[] args) {

        UUID userId = UUID.randomUUID();

        Mono.just(userId)
                .flatMap(ChainedFlatMapS4::initPipeline)
                .flatMap(ChainedFlatMapS4::preparePipeline)
                .map(ChainedFlatMapS4::buildAccount)
                .subscribe(GenericUtils::onNextLog);

        GenericUtils.sleepSeconds(5);

    }

    private static Mono<AccountBuilderPipeline> initPipeline(UUID userId) {
        return Mono.fromSupplier(() -> AccountBuilderPipeline.builder()
                .userId(userId)
                .build()
        );
    }

    private static Mono<AccountBuilderPipeline> preparePipeline(AccountBuilderPipeline pipeline) {
        return Mono.just(pipeline)
                .flatMap(p -> Mono.zip(
                        Mono.just(p),
                        CreditCardService.getAccountId(p.userId()),
                        (aPipeline, accId) -> aPipeline.toBuilder().accountId(accId).build()
                ))
                .flatMap(p -> Mono.zip(
                        Mono.just(p),
                        CreditCardService.getCardId(p.accountId()),
                        (aPipeline, cardId) -> aPipeline.toBuilder().cardId(cardId).build()
                ));
    }

    private static Account buildAccount(AccountBuilderPipeline pipeline) {
        return CreditCardService.buildAccount(pipeline.accountId(), pipeline.cardId());
    }

}
