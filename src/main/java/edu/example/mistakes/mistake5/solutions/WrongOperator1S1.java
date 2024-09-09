package edu.example.mistakes.mistake5.solutions;

import edu.example.mistakes.mistake5.util.ProcessorService;
import edu.example.util.GenericUtils;
import reactor.core.publisher.Mono;

import java.util.UUID;

public class WrongOperator1S1 {

    public static void main(String[] args) {

        Mono.fromSupplier(UUID::randomUUID)
                .flatMap(ProcessorService::triggerProcess)
                .subscribe();

        GenericUtils.sleepSeconds(5);

    }

}
