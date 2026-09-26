package dev.leandrojacome.policy.adapters;

import dev.leandrojacome.policy.application.Policy;
import dev.leandrojacome.policy.domain.AccessContext;
import java.util.Optional;

public final class RequiredRolePolicy implements Policy {
    private final String requiredRole;
    public RequiredRolePolicy(String requiredRole) { this.requiredRole = requiredRole; }
    public Optional<String> violation(AccessContext context) {
        return context.roles().contains(requiredRole) ? Optional.empty() : Optional.of("missing_role:" + requiredRole);
    }
}
