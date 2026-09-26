# ADR-001: Deny with explanations

## Status

Accepted for the portfolio scope.

## Decision

Evaluate every policy and return all violations instead of stopping at the first one.

## Consequences

This improves auditability and diagnosis. Expensive or sensitive policies may require short-circuiting and filtering of reasons at the public boundary.
