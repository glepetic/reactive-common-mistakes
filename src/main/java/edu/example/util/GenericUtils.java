package edu.example.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class GenericUtils {

    private static final Random rand = new Random();

    public static <T> void onNextLog(T next) {
        log.info("Received: {}", next);
    }

    public static void onErrorLog(Throwable thr) {
        log.error("Error class [{}] - error message [{}]", thr.getClass().getSimpleName(), thr.getMessage());
    }

    public static void onCompleteLog() {
        log.info("Completed!");
    }

    public static void sleepSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getRandomPositiveInt() {
        return rand.nextInt(0, 10000);
    }
}
