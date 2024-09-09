package edu.example.mistakes.mistake5;

import edu.example.mistakes.mistake5.util.ProcessorService;
import edu.example.util.GenericUtils;
import reactor.core.publisher.Mono;

import java.util.UUID;

public class WrongOperator1 {

    public static void main(String[] args) {

        Mono.fromSupplier(UUID::randomUUID)
                .map(ProcessorService::triggerProcess)
                .subscribe();

        GenericUtils.sleepSeconds(5);

    }

}
