# 10 - Records

## Objetivo

Entender records como estrutura concisa e imutável para transportar dados.

## Checklist

- [x] O que são records
- [x] Imutabilidade
- [x] Uso em DTOs
- [x] Diferença entre record e class
- [x] Quando usar record em respostas de API
- [x] Limitações de records

## O que é um record?

`record` é um recurso moderno do Java para criar tipos simples que carregam dados.

Ele é útil quando você precisa representar uma estrutura com campos, mas não quer escrever manualmente construtor, getters, `equals`, `hashCode` e `toString`.

```java
public record ClienteResumo(String nome, String email) {
}
```

Esse record declara dois dados:

- `nome`;
- `email`.

## Como usar

```java
ClienteResumo cliente = new ClienteResumo("Ana", "ana@email.com");

System.out.println(cliente.nome());
System.out.println(cliente.email());
```

Em records, os métodos de acesso têm o nome do próprio campo:

```java
cliente.nome();
cliente.email();
```

Não usamos `getNome()` ou `getEmail()` por padrão.

## O que o Java gera automaticamente?

Para um record como este:

```java
public record ProdutoResumo(String nome, double preco) {
}
```

O Java gera automaticamente:

- construtor;
- métodos de acesso;
- `equals`;
- `hashCode`;
- `toString`.

Isso reduz bastante o código repetitivo.

## Comparação com classe comum

Uma classe comum equivalente seria bem mais verbosa:

```java
public class ProdutoResumo {
    private final String nome;
    private final double preco;

    public ProdutoResumo(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}
```

Com `record`, fica assim:

```java
public record ProdutoResumo(String nome, double preco) {
}
```

## Records em backend

Records aparecem bastante em backend para DTOs.

Exemplo de resposta de API:

```java
public record ClienteResponse(
        Long id,
        String nome,
        String email
) {
}
```

Exemplo de request:

```java
public record CriarClienteRequest(
        String nome,
        String email
) {
}
```

Esse tipo de estrutura combina bem com dados simples que entram ou saem da API.

## Quando usar

Use records quando:

- o objetivo principal é transportar dados;
- os campos não precisam mudar depois da criação;
- você quer reduzir código repetitivo;
- a estrutura representa um DTO, response, request ou objeto de leitura.

## Quando evitar

Evite records quando:

- o objeto precisa mudar muito de estado;
- há muita regra de negócio interna;
- você precisa de herança de classe;
- a estrutura representa uma entidade JPA mutável.

## Por que importa no backend?

Records são úteis para DTOs simples, respostas de API e objetos de leitura.

## Percepções

> Record é uma forma compacta de representar dados imutáveis.
>
> Ele é ótimo para DTOs e respostas de API, mas não substitui toda classe do sistema.
