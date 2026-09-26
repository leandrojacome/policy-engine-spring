# Arquitetura

## Contexto e linguagem

Bounded context **Decisão de Acesso**. `AccessContext` e `Decision` são value objects imutáveis; políticas expressam violações na linguagem do domínio. A invariante central é: uma decisão só é permitida quando nenhuma política relata violação.

## Fronteiras

- **Domínio:** contexto e decisão, sem Spring.
- **Aplicação:** `EvaluateAccess` avalia o conjunto de políticas.
- **Infraestrutura:** políticas configuradas, composição Spring e controller HTTP.

## Padrões e alternativas

- **Strategy:** cada `Policy` substitui uma regra sem alterar o avaliador. Um bloco de `if/else` central foi descartado por concentrar motivos de mudança.
- **Composite por composição:** o caso de uso trata várias Strategies uniformemente e agrega violações. Chain of Responsibility foi descartada porque short-circuit perderia explicações úteis.
- Visitor não foi usado: as políticas são operações, não uma estrutura heterogênea a percorrer.

As políticas em código favorecem tipagem e revisão. Uma DSL traria autonomia operacional, mas exigiria parser, sandbox, versionamento e governança.
