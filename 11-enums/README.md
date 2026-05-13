# 11 - Enums

## Objetivo

Entender enums como tipos fechados para representar valores conhecidos, constantes e opÃ§Ãµes controladas.

Enums aparecem bastante em backend para status, categorias, perfis, tipos de operaÃ§Ã£o e regras de negÃ³cio.

## Checklist

- [x] O que Ã© enum
- [x] Criar enums
- [x] Usar enum em variÃ¡vel
- [x] Enum como conjunto de constantes
- [x] RelaÃ§Ã£o entre enum e `final`
- [ ] Enums com atributos
- [ ] Enums com mÃ©todos
- [ ] Enums para status
- [ ] Enums em regras de negÃ³cio
- [ ] Enums em entidades JPA
- [ ] `EnumType.STRING`

## Ideia central

`enum` Ã© uma estrutura parecida com uma classe, mas usada para definir um conjunto fechado de constantes.

Em vez de usar `class`, usamos `enum`.

```java
enum DiaDaSemana {
    SEGUNDA,
    TERCA,
    QUARTA,
    QUINTA,
    SEXTA,
    SABADO,
    DOMINGO
}
```

Esse enum define os Ãºnicos valores possÃ­veis para `DiaDaSemana`.

```txt
DiaDaSemana
  |
  |-- SEGUNDA
  |-- TERCA
  |-- QUARTA
  |-- QUINTA
  |-- SEXTA
  |-- SABADO
  `-- DOMINGO
```

## Usando enum

```java
public class ExemploEnum {
    public static void main(String[] args) {
        DiaDaSemana dia = DiaDaSemana.SEGUNDA;

        System.out.println("Hoje Ã© " + dia);
    }
}
```

SaÃ­da:

```txt
Hoje Ã© SEGUNDA
```

A variÃ¡vel `dia` Ã© do tipo `DiaDaSemana`.

Isso significa que ela sÃ³ pode receber valores definidos dentro do enum:

```java
DiaDaSemana dia = DiaDaSemana.SEGUNDA;
```

NÃ£o faz sentido fazer:

```java
DiaDaSemana dia = "segunda"; // erro
```

`"segunda"` Ã© uma `String`, nÃ£o um `DiaDaSemana`.

## Por que nÃ£o usar sÃ³ String?

Sem enum, poderÃ­amos representar dias com texto:

```java
String dia = "SEGUNDA";
```

Mas isso Ã© frÃ¡gil.

AlguÃ©m poderia escrever:

```java
String dia = "Segunda";
String outroDia = "segunda";
String diaErrado = "SEGUNNDA";
```

O compilador nÃ£o sabe que isso estÃ¡ errado.

Com enum, o Java controla os valores possÃ­veis:

```java
DiaDaSemana dia = DiaDaSemana.SEGUNDA;
```

Se tentar usar um valor que nÃ£o existe, o cÃ³digo nem compila.

## Enum como constante

Enum tem relaÃ§Ã£o com a ideia de constantes.

Cada valor do enum representa uma constante.

```java
DiaDaSemana.SEGUNDA
DiaDaSemana.TERCA
DiaDaSemana.QUARTA
```

Esses valores sÃ£o fixos.

VocÃª nÃ£o cria uma `SEGUNDA` nova durante a execuÃ§Ã£o do programa.

Por isso, a ideia conversa com `final`: estamos lidando com valores que nÃ£o devem ser alterados.

## Enum melhora o design

Enums ajudam quando existe uma lista conhecida de opÃ§Ãµes.

Exemplos:

```java
enum StatusPedido {
    AGUARDANDO_PAGAMENTO,
    PAGO,
    ENVIADO,
    ENTREGUE,
    CANCELADO
}
```

```java
enum PerfilUsuario {
    ADMIN,
    CLIENTE,
    OPERADOR
}
```

```java
enum TipoPagamento {
    PIX,
    CARTAO,
    BOLETO
}
```

Esses tipos deixam o cÃ³digo mais claro.

Em vez de passar texto solto, passamos um tipo controlado.

## Exemplo com status

```java
enum StatusPedido {
    AGUARDANDO_PAGAMENTO,
    PAGO,
    CANCELADO
}

public class Pedido {
    StatusPedido status;

    public Pedido(StatusPedido status) {
        this.status = status;
    }
}
```

Uso:

```java
public class TestePedido {
    public static void main(String[] args) {
        Pedido pedido = new Pedido(StatusPedido.PAGO);

        System.out.println(pedido.status);
    }
}
```

SaÃ­da:

```txt
PAGO
```

## Armadilhas comuns

- Usar `String` quando existe uma lista fechada de opÃ§Ãµes.
- Criar enum para valores que mudam toda hora.
- Esquecer que o nome do enum costuma seguir PascalCase, como classe.
- Esquecer que os valores do enum costumam ser escritos em maiÃºsculas.
- Comparar enum com texto em vez de comparar com o prÃ³prio enum.

## ReferÃªncia mental

```txt
enum             -> conjunto fechado de valores
DiaDaSemana      -> tipo enum
SEGUNDA          -> constante do enum
StatusPedido.PAGO -> valor controlado
String solta     -> mais frÃ¡gil
```

## Por que importa no backend?

Enums ajudam a modelar status de pedidos, perfis, tipos de operaÃ§Ã£o e regras com valores controlados.

Em backend, vocÃª vai encontrar enums em:

- status de pedido;
- tipo de pagamento;
- perfil de usuÃ¡rio;
- tipo de documento;
- categoria de produto;
- origem de evento;
- situaÃ§Ã£o de processamento.

Mais Ã  frente, eles tambÃ©m aparecem com JPA, banco de dados e `EnumType.STRING`.

## PercepÃ§Ãµes

> Enum Ã© uma forma de transformar texto solto em tipo seguro.
>
> Se a lista de possibilidades Ã© fechada e conhecida, enum geralmente deixa o cÃ³digo mais claro.
