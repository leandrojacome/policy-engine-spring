package dev.leandrojacome.policy.adapters;

import dev.leandrojacome.policy.application.Policy;
import dev.leandrojacome.policy.domain.AccessContext;
import java.time.ZoneOffset;
import java.util.Optional;

public final class BusinessHoursPolicy implements Policy {
    private final int startInclusive;
    private final int endExclusive;
    public BusinessHoursPolicy(int startInclusive, int endExclusive) {
        this.startInclusive = startInclusive; this.endExclusive = endExclusive;
    }
    public Optional<String> violation(AccessContext context) {
        int hour = context.occurredAt().atZone(ZoneOffset.UTC).getHour();
        return hour >= startInclusive && hour < endExclusive ? Optional.empty() : Optional.of("outside_business_hours");
    }
}
