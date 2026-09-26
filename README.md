# Policy Engine — Spring Boot

API de decisão que compõe políticas independentes e devolve explicações auditáveis. O exemplo avalia papel obrigatório e janela de horário, mas o núcleo não depende do Spring.

## Arquitetura e padrões

- **Strategy (GoF):** cada `Policy` encapsula uma regra substituível.
- **Composite por composição:** o caso de uso avalia um conjunto de políticas e agrega violações.
- **Dependency Inversion:** Spring e HTTP ficam nos adaptadores; domínio e aplicação são Java puro.

```bash
mvn verify
mvn org.owasp:dependency-check-maven:check
mvn spring-boot:run
```

Veja [Arquitetura](docs/architecture.md) e [ADR-001](docs/adr/001-explainable-deny.md).

## Trade-offs

As políticas são configuradas em código para privilegiar tipagem e rastreabilidade. Uma DSL aumentaria a autonomia operacional, mas também exigiria parser, versionamento, sandbox e governança.

## Licença

MIT.
