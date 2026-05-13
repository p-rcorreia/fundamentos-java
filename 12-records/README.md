# 12 - Records

## Objetivo

Entender records como estrutura concisa e imutÃ¡vel para transportar dados.

## Checklist

- [x] O que sÃ£o records
- [x] Imutabilidade
- [x] Uso em DTOs
- [x] DiferenÃ§a entre record e class
- [x] Quando usar record em respostas de API
- [x] LimitaÃ§Ãµes de records

## O que Ã© um record?

`record` Ã© um recurso moderno do Java para criar tipos simples que carregam dados.

Ele Ã© Ãºtil quando vocÃª precisa representar uma estrutura com campos, mas nÃ£o quer escrever manualmente construtor, getters, `equals`, `hashCode` e `toString`.

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

Em records, os mÃ©todos de acesso tÃªm o nome do prÃ³prio campo:

```java
cliente.nome();
cliente.email();
```

NÃ£o usamos `getNome()` ou `getEmail()` por padrÃ£o.

## O que o Java gera automaticamente?

Para um record como este:

```java
public record ProdutoResumo(String nome, double preco) {
}
```

O Java gera automaticamente:

- construtor;
- mÃ©todos de acesso;
- `equals`;
- `hashCode`;
- `toString`.

Isso reduz bastante o cÃ³digo repetitivo.

## ComparaÃ§Ã£o com classe comum

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

- o objetivo principal Ã© transportar dados;
- os campos nÃ£o precisam mudar depois da criaÃ§Ã£o;
- vocÃª quer reduzir cÃ³digo repetitivo;
- a estrutura representa um DTO, response, request ou objeto de leitura.

## Quando evitar

Evite records quando:

- o objeto precisa mudar muito de estado;
- hÃ¡ muita regra de negÃ³cio interna;
- vocÃª precisa de heranÃ§a de classe;
- a estrutura representa uma entidade JPA mutÃ¡vel.

## Por que importa no backend?

Records sÃ£o Ãºteis para DTOs simples, respostas de API e objetos de leitura.

## PercepÃ§Ãµes

> Record Ã© uma forma compacta de representar dados imutÃ¡veis.
>
> Ele Ã© Ã³timo para DTOs e respostas de API, mas nÃ£o substitui toda classe do sistema.
