package dev.leandrojacome.policy.application;

import dev.leandrojacome.policy.domain.AccessContext;
import dev.leandrojacome.policy.domain.Decision;
import java.util.List;

public final class EvaluateAccess {
    private final List<Policy> policies;

    public EvaluateAccess(List<Policy> policies) { this.policies = List.copyOf(policies); }

    public Decision execute(AccessContext context) {
        var reasons = policies.stream().map(policy -> policy.violation(context)).flatMap(java.util.Optional::stream).toList();
        return new Decision(reasons.isEmpty(), reasons);
    }
}
