# 19 - Bibliotecas de produtividade

## Objetivo

Conhecer bibliotecas que reduzem código repetitivo, automatizam conversões e ajudam no dia a dia de projetos Java backend.

Esse tópico fica mais para frente de propósito. Antes de usar ferramentas que economizam código, é importante entender o código que elas estão escondendo.

## Checklist

- [ ] Lombok
- [ ] MapStruct
- [ ] Jackson
- [ ] Apache Commons
- [ ] Guava, noção
- [ ] Hibernate Validator
- [ ] SpringDoc OpenAPI
- [ ] Testcontainers, noção
- [ ] Quando usar biblioteca externa
- [ ] Riscos de dependências demais
- [ ] Custo de manutenção e atualização

## Por que importa no backend?

Projetos backend reais usam bibliotecas para acelerar desenvolvimento, padronizar tarefas comuns e reduzir código repetitivo.

O cuidado é não usar uma biblioteca como atalho para fugir dos fundamentos. Primeiro vem a base. Depois vêm as ferramentas.

## Lombok

**Lombok** é uma biblioteca que gera código repetitivo automaticamente em tempo de compilação.

Ela é muito usada para reduzir métodos como:

- getters;
- setters;
- construtores;
- `toString`;
- `equals`;
- `hashCode`;
- builders.

Exemplo sem Lombok:

```java
public class Cliente {
    private String nome;
    private String email;

    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
```

Exemplo com Lombok:

```java
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Cliente {
    private String nome;
    private String email;
}
```

Lombok ajuda bastante, mas pode esconder código importante de quem ainda está aprendendo. Por isso faz sentido estudar depois de entender bem classes, construtores, encapsulamento e métodos.

## MapStruct

**MapStruct** é uma biblioteca usada para converter objetos de um tipo para outro.

Ela aparece bastante em projetos backend para transformar:

- entidade em DTO;
- DTO em entidade;
- request em objeto de domínio;
- objeto interno em response de API.

Exemplo conceitual:

```java
public class Cliente {
    private String nome;
    private String email;
}

public record ClienteResponse(String nome, String email) {
}
```

Com MapStruct, a conversão entre `Cliente` e `ClienteResponse` pode ser gerada automaticamente.

```java
import org.mapstruct.Mapper;

@Mapper
public interface ClienteMapper {
    ClienteResponse toResponse(Cliente cliente);
}
```

MapStruct é útil porque evita conversões manuais repetitivas e reduz erro em código de mapeamento.

## Jackson

**Jackson** é uma biblioteca muito usada para trabalhar com JSON em Java.

Em projetos Spring Boot, ela costuma aparecer automaticamente para converter objetos Java em JSON e JSON em objetos Java.

Exemplo conceitual:

```java
public record ClienteResponse(String nome, String email) {
}
```

Esse objeto pode virar uma resposta JSON como:

```json
{
  "nome": "Ana",
  "email": "ana@email.com"
}
```

## Regra prática

Antes de adicionar uma biblioteca, pergunte:

- ela resolve um problema real?
- ela reduz repetição sem esconder regra importante?
- ela é bem mantida?
- ela é comum no mercado?
- ela aumenta muito a complexidade do projeto?

Biblioteca boa não substitui fundamento. Ela amplifica uma base bem construída.

## Percepções

> Lombok, MapStruct e bibliotecas parecidas são ferramentas de produtividade. Elas ajudam mais quando a base de Java, OO, DTOs e arquitetura já está firme.
