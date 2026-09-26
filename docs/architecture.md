# Arquitetura

O controller traduz HTTP para `AccessContext`. `EvaluateAccess` coordena portas `Policy`; implementações concretas vivem nos adaptadores. Spring aparece somente na inicialização e na borda HTTP.
