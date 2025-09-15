# Job Vacancies API

## 📌 Visão Geral

Este projeto é o backend da **Job Vacancies API**, uma solução RESTful desenvolvida em **Java 21** com **Spring Boot 3**, **Spring Security**, **JWT**, **JPA/Hibernate** e banco de dados **PostgreSQL**. O objetivo é fornecer uma plataforma robusta para cadastro, autenticação e gerenciamento de vagas de emprego, empresas e candidatos, com foco em segurança, escalabilidade e boas práticas de arquitetura.

O sistema foi projetado para ser seguro, modular e facilmente extensível, utilizando autenticação JWT, validação de dados, tratamento global de exceções e separação clara de responsabilidades entre camadas (controllers, services, repositories, DTOs e handlers).

---

## 🗂️ Estrutura do Projeto

```
src/
  main/
    java/
      br/com/jobvacancies/main/job_vacancies/
        common/                # DTOs, exceptions, handlers e providers globais (ex: JWT)
        config/                # Configurações de segurança e JWT
        infrastructure/
          security/            # Filtros e configuração de segurança (Spring Security)
        modules/
          candidates/          # Modelos, controllers, services e repositórios de candidatos
          company/             # Modelos, controllers, services e repositórios de empresas
          jobs/                # Modelos, controllers, services, enums e handlers de vagas
    resources/
      application.properties   # Configurações da aplicação
.env                           # Variáveis de ambiente sensíveis (não versionadas)
```

---

## 🧩 Modelos Principais

- **CandidateModel**: Representa candidatos, com autenticação, perfil, currículo e timestamp de criação.
- **CompanyModel**: Representa empresas, incluindo CNPJ, descrição, site, autenticação e relacionamento com vagas.
- **JobsModel**: Representa vagas de emprego, com título, descrição, nível (enum), benefícios, empresa associada e timestamp.
- **Enums**: `JobLevelEnum` define os níveis aceitos para vagas (`JUNIOR`, `PLENO`, `SENIOR`).

---

## 🚀 Rotas e Funcionalidades

### 📋 Candidatos (`/candidates`)
- `POST /candidates/auth/register` — Cadastro de novo candidato.
- `POST /candidates/auth/login` — Login de candidato e geração de token JWT.
- `GET /candidates/profile` — Retorna o perfil do candidato autenticado (JWT obrigatório).

### 🏢 Empresas (`/companies`)
- `POST /companies/auth/register` — Cadastro de nova empresa.
- `POST /companies/auth/login` — Login de empresa e geração de token JWT.

### 💼 Vagas (`/jobs`)
- `POST /jobs/create` — Criação de vaga (empresa autenticada).
- `GET /jobs` — Lista todas as vagas cadastradas.
- `GET /jobs/{id}` — Detalhes de uma vaga específica.

### 🔒 Segurança & Autenticação
- **JWT**: Todas as rotas protegidas exigem o envio do token JWT no header `Authorization`.
- **Spring Security**: Configuração robusta para proteger endpoints e permitir acesso apenas a usuários autenticados.

---

## ⚙️ Principais Implementações e Boas Práticas

- **Autenticação JWT**: Tokens gerados e validados com claims customizadas (id, nome, email, role).
- **Validação de Dados**: Uso extensivo de anotações do Bean Validation (`@NotBlank`, `@Email`, `@Pattern`, `@Length`, `@NotNull`) para garantir integridade dos dados.
- **Tratamento Global de Erros**: Handlers globais para exceções de validação, entidades não encontradas, duplicidade e erros de padrão.
- **DTOs e Responses Customizadas**: Todas as respostas seguem um padrão consistente com mensagem, status e dados.
- **Relacionamentos JPA**: Mapeamento correto de chaves estrangeiras e relacionamentos entre entidades.
- **Segurança**: Filtros customizados para extração e validação do JWT, configuração detalhada do Spring Security.
- **Boas Práticas de Organização**: Separação clara de camadas, uso de Lombok para reduzir boilerplate, versionamento seguro (exclusão de arquivos sensíveis via `.gitignore`).

---

## 🔄 Fluxo de Funcionamento

1. **Cadastro e Login**: Usuários (candidatos/empresas) se cadastram e fazem login, recebendo um JWT.
2. **Acesso Protegido**: Endpoints sensíveis exigem JWT válido no header.
3. **Criação e Consulta**: Empresas criam vagas, candidatos consultam e visualizam detalhes.
4. **Validação e Segurança**: Todos os dados são validados e erros tratados de forma padronizada.

---

## 📚 O que aprendi com este projeto

- **Spring Boot Avançado**: Estruturação de projetos profissionais, uso de profiles, injeção de dependências e configuração avançada.
- **Segurança com JWT**: Implementação de autenticação e autorização robustas, proteção de rotas e manipulação segura de tokens.
- **Validação e Tratamento de Erros**: Aplicação de validação declarativa e tratamento global de exceções para APIs REST.
- **JPA/Hibernate**: Mapeamento de entidades, relacionamentos, uso de UUIDs e integração com PostgreSQL.
- **Boas Práticas de API REST**: Padrão de respostas, versionamento, organização modular e documentação de rotas.
- **Clean Code & Arquitetura**: Separação de responsabilidades, uso de DTOs, services, handlers e providers.
- **Exclusão de dados sensíveis do projeto base**: Configuração de variáveis de ambiente, uso de `.env` e práticas seguras para produção.

---

## 📝 Licença

[MIT](LICENSE)

---

**Desenvolvido com dedicação, foco em segurança e melhores práticas de backend moderno.**
