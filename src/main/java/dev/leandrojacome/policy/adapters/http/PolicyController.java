package dev.leandrojacome.policy.adapters.http;

import dev.leandrojacome.policy.application.EvaluateAccess;
import dev.leandrojacome.policy.domain.AccessContext;
import dev.leandrojacome.policy.domain.Decision;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Set;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/decisions")
public class PolicyController {
    private final EvaluateAccess useCase;
    public PolicyController(EvaluateAccess useCase) { this.useCase = useCase; }
    @PostMapping public Decision evaluate(@Valid @RequestBody Request request) {
        return useCase.execute(new AccessContext(request.subject(), request.resource(), request.roles(), request.occurredAt()));
    }
    public record Request(@NotBlank String subject, @NotBlank String resource, @NotNull Set<String> roles, @NotNull Instant occurredAt) {}
}
