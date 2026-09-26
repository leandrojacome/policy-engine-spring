# Policy Engine — Spring Boot

API de decisão que compõe políticas independentes e devolve explicações auditáveis. O exemplo avalia papel obrigatório e janela de horário, mas o núcleo não depende do Spring.

## Arquitetura e padrões

- **Strategy (GoF):** cada `Policy` encapsula uma regra substituível.
- **Composite por composição:** o caso de uso avalia um conjunto de políticas e agrega violações.
- **Dependency Inversion:** Spring e HTTP ficam nos adaptadores; domínio e aplicação são Java puro.
- **DDD proporcional:** bounded context de Decisão de Acesso, value objects imutáveis e linguagem explícita de violações.

```bash
mvn verify
mvn spring-boot:run
```

Veja [Arquitetura](docs/architecture.md) e [ADR-001](docs/adr/001-explainable-deny.md).

O CI executa auditoria de dependências com Trivy e falha para vulnerabilidades corrigíveis de severidade alta ou crítica.

## Trade-offs

As políticas são configuradas em código para privilegiar tipagem e rastreabilidade. Uma DSL aumentaria a autonomia operacional, mas também exigiria parser, versionamento, sandbox e governança.

Chain of Responsibility foi descartada porque o domínio precisa retornar todas as violações; Visitor não agregaria valor a uma lista homogênea de Strategies.

## Licença

MIT.
