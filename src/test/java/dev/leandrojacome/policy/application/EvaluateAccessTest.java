package dev.leandrojacome.policy.application;

import static org.assertj.core.api.Assertions.assertThat;
import dev.leandrojacome.policy.adapters.BusinessHoursPolicy;
import dev.leandrojacome.policy.adapters.RequiredRolePolicy;
import dev.leandrojacome.policy.domain.AccessContext;
import java.time.Instant;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class EvaluateAccessTest {
    private final EvaluateAccess useCase = new EvaluateAccess(List.of(new RequiredRolePolicy("operator"), new BusinessHoursPolicy(8, 18)));
    @Test void allows_when_all_policies_pass() {
        var decision = useCase.execute(new AccessContext("ana", "report", Set.of("operator"), Instant.parse("2026-01-05T12:00:00Z")));
        assertThat(decision.allowed()).isTrue();
        assertThat(decision.reasons()).isEmpty();
    }
    @Test void explains_all_violations() {
        var decision = useCase.execute(new AccessContext("ana", "report", Set.of("viewer"), Instant.parse("2026-01-05T22:00:00Z")));
        assertThat(decision.allowed()).isFalse();
        assertThat(decision.reasons()).containsExactly("missing_role:operator", "outside_business_hours");
    }
}
