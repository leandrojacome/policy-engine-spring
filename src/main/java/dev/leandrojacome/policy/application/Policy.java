package dev.leandrojacome.policy.application;

import dev.leandrojacome.policy.domain.AccessContext;
import java.util.Optional;

public interface Policy {
    Optional<String> violation(AccessContext context);
}
