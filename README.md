# Gestão de Custo: Demonstração de Performance com Spring Boot

## Links do Projeto

| Recurso | Link |
| :--- | :--- |
| **GitHub** | [https://github.com/britolmbs/gestao-custo](https://github.com/britolmbs/gestao-custo) |
| **Deploy (Render)** | [https://deploy-do-java-gestao-custo.onrender.com](https://deploy-do-java-gestao-custo.onrender.com) |

Este projeto foi desenvolvido para demonstrar e comparar a performance de diferentes estratégias de consulta de dados em uma aplicação Java com Spring Boot, seguindo o padrão **MVC (Model-View-Controller)**. O foco principal é evidenciar o impacto positivo da **paginação** e do **cache** em endpoints REST.



## Tecnologias Utilizadas

O projeto é construído com base nas seguintes tecnologias e dependências:

- **Java**: Linguagem de programação principal.
- **Spring Boot**: Framework base para a criação da aplicação.
- **Spring Web**: Para a criação de controladores REST (`@RestController`) e a implementação do padrão **MVC (Model-View-Controller)**.
- **Spring Data JPA**: Para simplificar o acesso e a persistência de dados.
- **Spring Cache**: Para a implementação de cache em nível de método.
- **H2 Database**: Um banco de dados em memória para facilitar os testes e a execução do projeto sem a necessidade de configuração de um banco externo.

## Análise de Performance

O controlador `GestaoDespesaPerfomance` expõe diferentes endpoints para ilustrar como a abordagem na busca de dados afeta o tempo de resposta e a eficiência da aplicação.

### Endpoints

A seguir, uma tabela com a descrição de cada endpoint disponível para teste:

| Método | Endpoint | Descrição |
| --- | --- | --- |
| `GET` | `/gestao/performance/sem-paginacao` | Retorna **todas** as despesas do banco de dados em uma única requisição. Ineficiente para grandes volumes de dados. |
| `GET` | `/gestao/performance/com-paginacao` | Retorna as despesas de forma paginada. O cliente pode especificar o número da página e o tamanho. Ex: `?page=0&size=10`. |
| `GET` | `/gestao/performance/com-paginacao/{email}` | Retorna as despesas de um usuário específico (`email`) de forma paginada. |
| `GET` | `/gestao/performance/cache/{email}` | Similar ao anterior, mas utiliza o cache do Spring (`@Cacheable`). Na primeira requisição, o resultado é armazenado em memória. As chamadas subsequentes para o mesmo email e página retornam os dados do cache, resultando em um tempo de resposta drasticamente menor. |

### Como Testar

1.  **Inicie a aplicação.**
2.  Utilize uma ferramenta como `curl` ou Postman para fazer requisições aos endpoints.
3.  Observe o console da aplicação, onde o tempo de execução de cada requisição (em milissegundos) será impresso.

**Exemplo de Teste de Cache:**

- Faça uma primeira chamada para `/gestao/performance/cache/usuario@teste.com?page=0&size=5`.
- Observe o tempo de resposta impresso no log.
- Faça a mesma chamada novamente.
- Compare o tempo da segunda requisição com o da primeira. O tempo da segunda será próximo de zero, pois os dados foram servidos diretamente do cache.

## Estrutura do Projeto

O projeto segue uma estrutura de pacotes bem definida, aderindo aos princípios de organização de um projeto Spring Boot:

```
br.com.britolmbs.gestao_custo
├── controller
├── custom_messages
├── entity
├── performance
├── repository
└── useCases
```



## Como Executar o Projeto

Para executar este projeto localmente, siga os passos abaixo:

1.  Clone o repositório:
    ```bash
    git clone <url-do-seu-repositorio>
    ```
2.  Navegue até o diretório do projeto:
    ```bash
    cd <nome-do-projeto>
    ```
3.  Execute a aplicação usando o Maven Wrapper:
    ```bash
    ./mvnw spring-boot:run
    ```

A aplicação estará disponível em `http://localhost:8080`.
