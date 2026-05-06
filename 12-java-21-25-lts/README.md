# 12 - Java 21 e Java 25 LTS

## Objetivo

Entender recursos modernos além da base inicial de Java moderno e acompanhar o ciclo LTS da linguagem.

## Checklist

- [ ] Java 21 como LTS anterior
- [ ] Java 25 como LTS atual no ciclo 2026
- [ ] Virtual threads
- [ ] Sequenced collections
- [x] Pattern matching para switch
- [ ] Record patterns, noção
- [ ] Unnamed classes e instance main methods, noção
- [ ] Scoped values, noção
- [ ] Structured concurrency, noção
- [ ] Quando atualizar versão de Java em projeto real
- [ ] Compatibilidade com Spring Boot
- [ ] Diferença entre feature preview, incubator e final

## Por que importa no backend?

Versões LTS definem a base tecnológica de projetos corporativos e influenciam performance, bibliotecas e suporte.

## Pattern matching para switch

Pattern matching permite escrever verificações de tipo de forma mais direta.

Com `instanceof`, a ideia fica assim:

```java
Object valor = "Java";

if (valor instanceof String texto) {
    System.out.println(texto.toUpperCase());
}
```

No `switch`, a ideia moderna é deixar o código mais expressivo quando diferentes tipos precisam ser tratados.

Exemplo conceitual:

```java
static String descrever(Object valor) {
    return switch (valor) {
        case String texto -> "Texto: " + texto;
        case Integer numero -> "Número: " + numero;
        case null -> "Valor nulo";
        default -> "Tipo desconhecido";
    };
}
```

Esse estilo ajuda a reduzir `if/else` encadeado quando o código precisa reagir a diferentes formatos de entrada.

## Sealed classes e pattern matching

`sealed classes` combinam bem com pattern matching porque limitam quais tipos podem existir.

```java
public sealed interface Evento
        permits PedidoCriado, PedidoCancelado {
}

public record PedidoCriado(Long id) implements Evento {
}

public record PedidoCancelado(Long id, String motivo) implements Evento {
}
```

Depois, o código pode tratar cada tipo de evento de forma clara:

```java
static String descrever(Evento evento) {
    return switch (evento) {
        case PedidoCriado criado -> "Pedido criado: " + criado.id();
        case PedidoCancelado cancelado -> "Pedido cancelado: " + cancelado.motivo();
    };
}
```

Essa combinação ajuda a modelar domínios com possibilidades conhecidas e controladas.

## Percepções

> Registrar aprendizados conforme o estudo avançar.
