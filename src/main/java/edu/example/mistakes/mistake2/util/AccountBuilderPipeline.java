package edu.example.mistakes.mistake2.util;

import lombok.Builder;

import java.util.UUID;

@Builder(toBuilder = true)
public record AccountBuilderPipeline(UUID userId, Integer accountId, Integer cardId) {
}
