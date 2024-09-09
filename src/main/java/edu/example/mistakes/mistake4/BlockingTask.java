package edu.example.mistakes.mistake4;

import edu.example.mistakes.mistake4.util.BlockingService;
import edu.example.util.GenericUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
public class BlockingTask {

    public static void main(String[] args) {

        UUID userId = UUID.randomUUID();

        BlockingService.fetchPersonName(userId)
                .subscribe(GenericUtils::onNextLog);

        log.info("No need to block main thread because it is blocked to finish the execution of fetchPersonName");

    }

}
