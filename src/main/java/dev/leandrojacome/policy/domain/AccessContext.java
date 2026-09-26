package dev.leandrojacome.policy.domain;

import java.time.Instant;
import java.util.Objects;
import java.util.Set;

public record AccessContext(String subject, String resource, Set<String> roles, Instant occurredAt) {
    public AccessContext {
        if (subject == null || subject.isBlank()) throw new IllegalArgumentException("subject is required");
        if (resource == null || resource.isBlank()) throw new IllegalArgumentException("resource is required");
        roles = Set.copyOf(Objects.requireNonNull(roles, "roles are required"));
        Objects.requireNonNull(occurredAt, "occurredAt is required");
    }
}
