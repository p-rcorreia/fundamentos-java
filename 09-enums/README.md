# 09 - Enums

## Objetivo

Entender enums como tipos fechados para representar valores conhecidos, constantes e opções controladas.

Enums aparecem bastante em backend para status, categorias, perfis, tipos de operação e regras de negócio.

## Checklist

- [x] O que é enum
- [x] Criar enums
- [x] Usar enum em variável
- [x] Enum como conjunto de constantes
- [x] Relação entre enum e `final`
- [ ] Enums com atributos
- [ ] Enums com métodos
- [ ] Enums para status
- [ ] Enums em regras de negócio
- [ ] Enums em entidades JPA
- [ ] `EnumType.STRING`

## Ideia central

`enum` é uma estrutura parecida com uma classe, mas usada para definir um conjunto fechado de constantes.

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

Esse enum define os únicos valores possíveis para `DiaDaSemana`.

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

        System.out.println("Hoje é " + dia);
    }
}
```

Saída:

```txt
Hoje é SEGUNDA
```

A variável `dia` é do tipo `DiaDaSemana`.

Isso significa que ela só pode receber valores definidos dentro do enum:

```java
DiaDaSemana dia = DiaDaSemana.SEGUNDA;
```

Não faz sentido fazer:

```java
DiaDaSemana dia = "segunda"; // erro
```

`"segunda"` é uma `String`, não um `DiaDaSemana`.

## Por que não usar só String?

Sem enum, poderíamos representar dias com texto:

```java
String dia = "SEGUNDA";
```

Mas isso é frágil.

Alguém poderia escrever:

```java
String dia = "Segunda";
String outroDia = "segunda";
String diaErrado = "SEGUNNDA";
```

O compilador não sabe que isso está errado.

Com enum, o Java controla os valores possíveis:

```java
DiaDaSemana dia = DiaDaSemana.SEGUNDA;
```

Se tentar usar um valor que não existe, o código nem compila.

## Enum como constante

Enum tem relação com a ideia de constantes.

Cada valor do enum representa uma constante.

```java
DiaDaSemana.SEGUNDA
DiaDaSemana.TERCA
DiaDaSemana.QUARTA
```

Esses valores são fixos.

Você não cria uma `SEGUNDA` nova durante a execução do programa.

Por isso, a ideia conversa com `final`: estamos lidando com valores que não devem ser alterados.

## Enum melhora o design

Enums ajudam quando existe uma lista conhecida de opções.

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

Esses tipos deixam o código mais claro.

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

Saída:

```txt
PAGO
```

## Armadilhas comuns

- Usar `String` quando existe uma lista fechada de opções.
- Criar enum para valores que mudam toda hora.
- Esquecer que o nome do enum costuma seguir PascalCase, como classe.
- Esquecer que os valores do enum costumam ser escritos em maiúsculas.
- Comparar enum com texto em vez de comparar com o próprio enum.

## Referência mental

```txt
enum             -> conjunto fechado de valores
DiaDaSemana      -> tipo enum
SEGUNDA          -> constante do enum
StatusPedido.PAGO -> valor controlado
String solta     -> mais frágil
```

## Por que importa no backend?

Enums ajudam a modelar status de pedidos, perfis, tipos de operação e regras com valores controlados.

Em backend, você vai encontrar enums em:

- status de pedido;
- tipo de pagamento;
- perfil de usuário;
- tipo de documento;
- categoria de produto;
- origem de evento;
- situação de processamento.

Mais à frente, eles também aparecem com JPA, banco de dados e `EnumType.STRING`.

## Percepções

> Enum é uma forma de transformar texto solto em tipo seguro.
>
> Se a lista de possibilidades é fechada e conhecida, enum geralmente deixa o código mais claro.
