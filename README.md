# Sistema Bancário

Este é um projeto de exemplo para um sistema bancário desenvolvido utilizando Java Spring Boot. O projeto demonstra a implementação de diversas entidades e suas relações, como Cliente, Conta, Transacao, Endereco, Funcionario e Agencia.

## Estrutura do Projeto

### Entidades

1. **Cliente**
    - `Long id`
    - `String nome`
    - `String cpf`
    - `Endereco endereco`
    - `List<Conta> contas`

2. **Conta**
    - `Long id`
    - `String numero`
    - `BigDecimal saldo`
    - `TipoConta tipo`
    - `Cliente cliente`
    - `List<Transacao> transacoes`

3. **Transacao**
    - `Long id`
    - `LocalDateTime data`
    - `TipoTransacao tipo`
    - `BigDecimal valor`
    - `Conta conta`

4. **Endereco**
    - `Long id`
    - `String rua`
    - `String cidade`
    - `String estado`
    - `String cep`
    - `Cliente cliente`

5. **Funcionario**
    - `Long id`
    - `String nome`
    - `String cpf`
    - `Cargo cargo`
    - `Agencia agencia`

6. **Agencia**
    - `Long id`
    - `String numero`
    - `Endereco endereco`
    - `List<Funcionario> funcionarios`

7. **TipoConta** (enum)
    - `CORRENTE`
    - `POUPANCA`

8. **TipoTransacao** (enum)
    - `DEPOSITO`
    - `SAQUE`
    - `TRANSFERENCIA`

9. **Cargo** (enum)
    - `GERENTE`
    - `CAIXA`

## Configuração do Projeto

### Requisitos

- Java 17 ou superior
- Gradle
- Banco de dados H2 (pode ser facilmente configurado para outros bancos de dados, como MySQL ou PostgreSQL)

### Passos para Executar

1. Clone o repositório:
    ```sh
    git clone https://github.com/seu-usuario/sistema-bancario.git
    ```
2. Navegue até o diretório do projeto:
    ```sh
    cd sistema-bancario
    ```
3. Compile o projeto e resolva as dependências usando Gradle:
    ```sh
    ./gradlew build
    ```
4. Execute o projeto:
    ```sh
    ./gradlew bootRun
    ```

O projeto estará disponível em `http://localhost:8080`.

### Estrutura do Banco de Dados

O banco de dados H2 será configurado automaticamente e pode ser acessado via navegador em `http://localhost:8080/h2-console`. Use as seguintes configurações:

- JDBC URL: `jdbc:h2:mem:testdb`
- User Name: `sa`
- Password: `password`

## Endpoints da API

### Cliente

- **GET /clientes**: Retorna todos os clientes
- **GET /clientes/{id}**: Retorna um cliente específico
- **POST /clientes**: Cria um novo cliente
- **PUT /clientes/{id}**: Atualiza um cliente existente
- **DELETE /clientes/{id}**: Remove um cliente

### Conta

- **GET /contas**: Retorna todas as contas
- **GET /contas/{id}**: Retorna uma conta específica
- **POST /contas**: Cria uma nova conta
- **PUT /contas/{id}**: Atualiza uma conta existente
- **DELETE /contas/{id}**: Remove uma conta

### Transacao

- **GET /transacoes**: Retorna todas as transações
- **GET /transacoes/{id}**: Retorna uma transação específica
- **POST /transacoes**: Cria uma nova transação
- **PUT /transacoes/{id}**: Atualiza uma transação existente
- **DELETE /transacoes/{id}**: Remove uma transação

## Testes

O projeto inclui testes unitários e de integração utilizando JUnit e Mockito. Para executar os testes, use o seguinte comando:

```sh
./gradlew test
```
Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e enviar pull requests.

Licença
Este projeto está licenciado sob a Licença MIT - veja o arquivo LICENSE para mais detalhes.
