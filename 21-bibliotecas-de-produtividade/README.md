# 21 - Bibliotecas de produtividade

## Objetivo

Conhecer bibliotecas que reduzem cÃ³digo repetitivo, automatizam conversÃµes e ajudam no dia a dia de projetos Java backend.

Esse tÃ³pico fica mais para frente de propÃ³sito. Antes de usar ferramentas que economizam cÃ³digo, Ã© importante entender o cÃ³digo que elas estÃ£o escondendo.

## Checklist

- [ ] Lombok
- [ ] MapStruct
- [ ] Jackson
- [ ] Apache Commons
- [ ] Guava, noÃ§Ã£o
- [ ] Hibernate Validator
- [ ] SpringDoc OpenAPI
- [ ] Testcontainers, noÃ§Ã£o
- [ ] Quando usar biblioteca externa
- [ ] Riscos de dependÃªncias demais
- [ ] Custo de manutenÃ§Ã£o e atualizaÃ§Ã£o

## Por que importa no backend?

Projetos backend reais usam bibliotecas para acelerar desenvolvimento, padronizar tarefas comuns e reduzir cÃ³digo repetitivo.

O cuidado Ã© nÃ£o usar uma biblioteca como atalho para fugir dos fundamentos. Primeiro vem a base. Depois vÃªm as ferramentas.

## Lombok

**Lombok** Ã© uma biblioteca que gera cÃ³digo repetitivo automaticamente em tempo de compilaÃ§Ã£o.

Ela Ã© muito usada para reduzir mÃ©todos como:

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

Lombok ajuda bastante, mas pode esconder cÃ³digo importante de quem ainda estÃ¡ aprendendo. Por isso faz sentido estudar depois de entender bem classes, construtores, encapsulamento e mÃ©todos.

## MapStruct

**MapStruct** Ã© uma biblioteca usada para converter objetos de um tipo para outro.

Ela aparece bastante em projetos backend para transformar:

- entidade em DTO;
- DTO em entidade;
- request em objeto de domÃ­nio;
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

Com MapStruct, a conversÃ£o entre `Cliente` e `ClienteResponse` pode ser gerada automaticamente.

```java
import org.mapstruct.Mapper;

@Mapper
public interface ClienteMapper {
    ClienteResponse toResponse(Cliente cliente);
}
```

MapStruct Ã© Ãºtil porque evita conversÃµes manuais repetitivas e reduz erro em cÃ³digo de mapeamento.

## Jackson

**Jackson** Ã© uma biblioteca muito usada para trabalhar com JSON em Java.

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

## Regra prÃ¡tica

Antes de adicionar uma biblioteca, pergunte:

- ela resolve um problema real?
- ela reduz repetiÃ§Ã£o sem esconder regra importante?
- ela Ã© bem mantida?
- ela Ã© comum no mercado?
- ela aumenta muito a complexidade do projeto?

Biblioteca boa nÃ£o substitui fundamento. Ela amplifica uma base bem construÃ­da.

## PercepÃ§Ãµes

> Lombok, MapStruct e bibliotecas parecidas sÃ£o ferramentas de produtividade. Elas ajudam mais quando a base de Java, OO, DTOs e arquitetura jÃ¡ estÃ¡ firme.
