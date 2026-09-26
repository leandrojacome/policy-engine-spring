package dev.leandrojacome.policy.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.time.Instant;
import java.util.Set;
import org.junit.jupiter.api.Test;

class AccessContextTest {
    @Test void rejects_missing_subject() {
        assertThatThrownBy(() -> new AccessContext(" ", "report", Set.of("operator"), Instant.now()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test void protects_roles_from_external_mutation() {
        var mutable = new java.util.HashSet<>(Set.of("operator"));
        var context = new AccessContext("ana", "report", mutable, Instant.now());
        mutable.clear();
        org.assertj.core.api.Assertions.assertThat(context.roles()).containsExactly("operator");
    }
}
