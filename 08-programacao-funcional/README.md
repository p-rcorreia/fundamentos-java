# 08 - Programação Funcional

## Objetivo

Entender como o Java usa expressões lambda e interfaces funcionais para escrever código menor, mais direto e mais declarativo.

## Checklist

- [x] Programação funcional em Java
- [x] Função como comportamento
- [x] Interfaces funcionais
- [x] `@FunctionalInterface`
- [ ] `Predicate`
- [ ] `Function`
- [ ] `Consumer`
- [ ] `Supplier`
- [ ] Composição de operações
- [ ] Imutabilidade, noção inicial
- [ ] Efeitos colaterais, noção inicial
- [ ] Quando usar estilo funcional
- [ ] Quando evitar estilo funcional para não piorar legibilidade

## Por que importa no backend?

Programação funcional ajuda a expressar validações, filtros, transformações e regras pequenas com menos código repetitivo.

Ela também prepara o caminho para usar Stream API com mais clareza.

## Programação funcional em Java

Programação funcional é um paradigma que dá mais importância para **funções**, **transformação de dados** e **composição de operações**.

No Java, ela não substitui a orientação a objetos. Ela complementa a linguagem e aparece principalmente a partir do Java 8, com recursos como:

- expressões lambda;
- interfaces funcionais;
- Stream API;
- métodos como `filter`, `map`, `reduce`, `forEach` e `collect`.

Por isso, o capítulo anterior de expressões lambda é importante. Lambdas são a base para conseguir escrever código funcional em Java.

## Menos código não significa menos trabalho

Quando usamos programação funcional, muitas operações que escreveríamos manualmente passam a ser delegadas para a API do Java.

Isso não significa que o código deixou de existir. Significa que deixamos o Java cuidar de partes repetitivas ou operacionais.

Em vez de escrever todos os detalhes de uma repetição, filtro ou transformação, podemos declarar a intenção:

```java
numero -> numero % 2 == 0
```

Essa lambda diz: receba um número e verifique se ele é par.

O ganho está em deixar o código mais curto e mais focado na regra.

## Interfaces funcionais

Uma **interface funcional** é uma interface que contém apenas um método abstrato.

Ela define uma única operação.

Exemplo:

```java
@FunctionalInterface
interface CalculadoraInterface {
    double calcular(double a, double b);
}
```

Nesse exemplo, a interface tem apenas o método `calcular`.

Como existe só um método abstrato, o Java consegue associar uma expressão lambda a esse método.

## Benefícios das interfaces funcionais

Interfaces funcionais são importantes porque permitem:

- usar expressões lambda;
- criar implementações menores;
- passar comportamento como valor;
- reaproveitar a mesma operação abstrata com implementações diferentes;
- reduzir código repetitivo.

Elas também se conectam com polimorfismo: diferentes implementações podem executar o mesmo contrato de formas diferentes.

## A anotação `@FunctionalInterface`

A anotação `@FunctionalInterface` deixa explícito que aquela interface deve ter apenas um método abstrato.

Se alguém tentar adicionar outro método abstrato, o compilador gera erro.

Exemplo inválido:

```java
@FunctionalInterface
interface CalculadoraInterface {
    double calcular(double a, double b);

    double calcularDois(double a, double b);
}
```

Esse código não compila, porque a interface deixou de ter apenas um método abstrato.

A anotação é opcional, mas é uma boa prática. Sem ela, a interface ainda pode funcionar como interface funcional se tiver apenas um método abstrato, mas a intenção fica menos protegida.

## Calculadora tradicional

Uma forma tradicional de escrever uma calculadora é criar um método para cada operação.

```java
public class CalculadoraTradicional {
    public double somar(double a, double b) {
        return a + b;
    }

    public double subtrair(double a, double b) {
        return a - b;
    }

    public double multiplicar(double a, double b) {
        return a * b;
    }

    public double dividir(double a, double b) {
        return a / b;
    }

    public static void main(String[] args) {
        CalculadoraTradicional calculadora = new CalculadoraTradicional();

        double resultadoSoma = calculadora.somar(10, 5);
        System.out.println("Soma: " + resultadoSoma);

        double resultadoSubtracao = calculadora.subtrair(10, 5);
        System.out.println("Subtração: " + resultadoSubtracao);

        double resultadoMultiplicacao = calculadora.multiplicar(10, 5);
        System.out.println("Multiplicação: " + resultadoMultiplicacao);

        double resultadoDivisao = calculadora.dividir(10, 5);
        System.out.println("Divisão: " + resultadoDivisao);
    }
}
```

Esse código funciona bem, mas cada operação precisa de um método próprio.

## Calculadora com interface funcional

Com interface funcional, mantemos uma única operação abstrata e mudamos o comportamento usando lambdas.

```java
@FunctionalInterface
interface CalculadoraInterface {
    double calcular(double a, double b);
}

public class Calculadora {
    public static void main(String[] args) {
        CalculadoraInterface soma = (a, b) -> a + b;
        System.out.println("Soma: " + soma.calcular(10, 5));

        CalculadoraInterface subtracao = (a, b) -> a - b;
        System.out.println("Subtração: " + subtracao.calcular(10, 5));

        CalculadoraInterface multiplicacao = (a, b) -> a * b;
        System.out.println("Multiplicação: " + multiplicacao.calcular(10, 5));

        CalculadoraInterface divisao = (a, b) -> a / b;
        System.out.println("Divisão: " + divisao.calcular(10, 5));
    }
}
```

Nesse exemplo, todas as variáveis são do tipo `CalculadoraInterface`.

O que muda é a implementação da lambda:

```java
(a, b) -> a + b
(a, b) -> a - b
(a, b) -> a * b
(a, b) -> a / b
```

Cada lambda implementa o método `calcular` de um jeito diferente.

O Java sabe qual método está sendo implementado porque uma interface funcional tem apenas um método abstrato.

## Inferência de tipo

Na lambda, não precisamos escrever os tipos dos parâmetros:

```java
CalculadoraInterface soma = (a, b) -> a + b;
```

O Java infere que `a` e `b` são `double`, porque o método abstrato foi declarado assim:

```java
double calcular(double a, double b);
```

Também seria possível escrever explicitamente:

```java
CalculadoraInterface soma = (double a, double b) -> a + b;
```

Mas, nesse caso, a versão inferida costuma ser mais simples.

## Saída esperada

As duas versões produzem o mesmo resultado:

```txt
Soma: 15.0
Subtração: 5.0
Multiplicação: 50.0
Divisão: 2.0
```

Como os valores são `double`, a saída mostra a parte decimal.

## Resumo

Interface funcional é uma interface com apenas um método abstrato.

`@FunctionalInterface` protege essa intenção e faz o compilador reclamar se outro método abstrato for adicionado.

Com lambdas, podemos implementar esse método de forma curta e direta.

Esse recurso é poderoso porque reduz código repetitivo e abre caminho para recursos como `Predicate`, `Function`, `Consumer`, `Supplier` e Stream API.

## Próximo passo

Depois de programação funcional, o próximo assunto da trilha é [Stream API](../09-stream-api).

## Percepções

> Registrar aprendizados conforme o estudo avançar.
