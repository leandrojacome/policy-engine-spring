# Explainable Policy Engine with Spring Boot

A decision API that composes independent policies and returns auditable explanations. The example evaluates a required role and a time window while keeping the core independent of Spring.

## Architecture and patterns

- **Strategy:** each `Policy` encapsulates a replaceable rule.
- **Composite by composition:** the use case evaluates a policy collection and aggregates violations.
- **Dependency Inversion:** Spring and HTTP stay in adapters; domain and application are plain Java.
- **Pragmatic DDD:** the Access Decision bounded context uses immutable value objects and an explicit violation language.

## Run

```bash
mvn test
```

See [Architecture](docs/architecture.md) and [ADR-001](docs/adr/001-explainable-deny.md).

CI runs tests and scans dependencies with Trivy, failing on fixable high or critical vulnerabilities.

## Trade-offs

Policies are configured in code to favor typing and traceability. A DSL would increase operational autonomy but would also require parsing, versioning, sandboxing, and governance.

Chain of Responsibility was rejected because the domain must return every violation. Visitor adds no value to a homogeneous collection of Strategies.

## License

MIT
