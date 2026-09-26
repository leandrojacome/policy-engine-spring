package dev.leandrojacome.policy.config;

import dev.leandrojacome.policy.adapters.BusinessHoursPolicy;
import dev.leandrojacome.policy.adapters.RequiredRolePolicy;
import dev.leandrojacome.policy.application.EvaluateAccess;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PolicyConfiguration {
    @Bean EvaluateAccess evaluateAccess() {
        return new EvaluateAccess(java.util.List.of(new RequiredRolePolicy("operator"), new BusinessHoursPolicy(8, 18)));
    }
}
