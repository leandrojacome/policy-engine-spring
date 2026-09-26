# Architecture

## Domain model

The **Access Decision** bounded context models `AccessContext` and `Decision` as immutable value objects. Policies express violations in domain language. The central invariant is that access is allowed only when no policy reports a violation.

## Layers

- **Domain:** context and decision, without Spring.
- **Application:** `EvaluateAccess` evaluates the policy collection.
- **Infrastructure:** configured policies, Spring composition, and the HTTP controller.

## Patterns and alternatives

- **Strategy:** each `Policy` replaces a rule without changing the evaluator. A central `if/else` block was rejected because it concentrates unrelated reasons to change.
- **Composite by composition:** the use case treats Strategies uniformly and aggregates violations. Chain of Responsibility was rejected because short-circuiting would lose useful explanations.
- Visitor is not used because policies are operations, not a heterogeneous object structure.

Code-based policies favor typing and review. A DSL would add operational autonomy but would require a parser, sandbox, versioning, and governance.
