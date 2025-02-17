# Agenda
# Sistema de Agendamento Telefônico - Backend

## Visão Geral
Este é o backend do Sistema de Agendamento Telefônico, desenvolvido com **Java + Spring Boot** e **PostgreSQL**. Ele fornece uma API RESTful para gerenciar contatos, permitindo cadastro, edição, inativação e marcação de favoritos.

## Tecnologias Utilizadas
- **Java 23**
- **Spring Boot 3.4.2**
- **Spring Web** (para criação da API REST)
- **Spring Data JPA** (para interação com o banco de dados)
- **PostgreSQL** (banco de dados relacional)
- **Lombok** (para reduzir a verbosidade do código)

---

## Configuração do Projeto

### 1. Clonar o Repositório
```sh
git clone https://github.com/seu-usuario/sistema-agendamento-backend.git
cd sistema-agendamento-backend
```

### 2. Configurar o Banco de Dados

Crie um banco de dados PostgreSQL e um schema chamado `desafio`:
```sql
CREATE SCHEMA desafio;

CREATE TABLE desafio.contato (
    contato_id SERIAL PRIMARY KEY,
    contato_nome VARCHAR(100) NOT NULL,
    contato_email VARCHAR(255) UNIQUE,
    contato_celular VARCHAR(11) UNIQUE NOT NULL,
    contato_telefone VARCHAR(10),
    contato_sn_favorito CHAR(1) NOT NULL DEFAULT 'N',
    contato_sn_ativo CHAR(1) NOT NULL DEFAULT 'S',
    contato_dh_cad TIMESTAMP NOT NULL DEFAULT NOW()
);
```

### 3. Configurar o `application.properties`

Edite o arquivo `src/main/resources/application.properties` e defina as credenciais do banco:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/desafio
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 4. Executar o Projeto

Se estiver utilizando **Maven**, rode o seguinte comando na raiz do projeto:
```sh
mvn spring-boot:run
```

Caso esteja usando um ambiente de desenvolvimento como **IntelliJ IDEA** ou **VS Code**, basta rodar a classe principal `Application.java`.

---

## Endpoints da API

### **1. Listar Contatos**
**GET** `/api/contatos`

Retorna todos os contatos cadastrados.

### **2. Buscar Contato por ID**
**GET** `/api/contatos/{id}`

Retorna um contato específico pelo ID.

### **3. Criar um Novo Contato**
**POST** `/api/contatos`

#### **Exemplo de Requisição:**
```json
{
  "nome": "João Silva",
  "email": "joao@email.com",
  "celular": "11999999999",
  "telefone": "1122223333",
  "favorito": "N",
  "ativo": "S"
}
```

### **4. Atualizar um Contato**
**PUT** `/api/contatos/{id}`

Permite atualizar as informações de um contato.

### **5. Excluir um Contato**
**DELETE** `/api/contatos/{id}`

Remove um contato pelo ID.

---

## Estrutura do Projeto
```
/src
├── main/java/com/exemplo/desafio
│   ├── controller      # Controllers da API
│   ├── model           # Modelos (Entidades JPA)
│   ├── repository      # Interfaces de Repositório (Spring Data JPA)
│   ├── service         # Regras de negócio
│   └── Application.java # Classe principal do Spring Boot
├── main/resources
│   ├── application.properties  # Configurações do Spring Boot
├── pom.xml  # Dependências do projeto
```

---

## Melhorias Futuras
- Implementar autenticação com **Spring Security** e JWT.
- Criar paginação para a listagem de contatos.
- Implementar testes unitários e de integração.

---

## Contato
Se precisar de ajuda ou tiver sugestões, entre em contato! 😊

