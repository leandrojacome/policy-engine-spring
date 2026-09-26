package dev.leandrojacome.policy.domain;

import java.time.Instant;
import java.util.Set;

public record AccessContext(String subject, String resource, Set<String> roles, Instant occurredAt) {
    public AccessContext { roles = Set.copyOf(roles); }
}
