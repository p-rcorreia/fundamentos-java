# 07 - Expressões Lambda

## Objetivo

Entender expressões lambda como uma forma compacta de passar comportamentos para métodos em Java.

## Checklist

- [x] Lambda expressions
- [x] `forEach`
- [x] Lambda com corpo
- [x] Parênteses opcionais
- [x] Tipo explícito exige parênteses
- [x] Chaves opcionais
- [x] Variáveis `final` e efetivamente finais

## Por que importa no backend?

Lambdas aparecem em coleções, callbacks, validações, ordenações, streams e vários recursos usados no backend moderno.

## Expressões lambda

Expressões lambda são uma forma mais curta de escrever comportamentos que podem ser passados para métodos.

Elas ajudam a reduzir código repetitivo e são uma das bases para usar Java com um estilo mais funcional.

A ideia principal é: em vez de criar uma classe ou um método separado para uma operação simples, podemos escrever a operação diretamente no ponto em que ela será usada.

Exemplo:

```java
List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

numeros.forEach(numero -> System.out.println(numero));
```

Nesse exemplo:

- `numeros` é uma lista de inteiros;
- `forEach` percorre cada item da lista;
- `numero` representa o item atual;
- `->` é a seta da expressão lambda;
- `System.out.println(numero)` é o comportamento executado para cada item.

No começo, lambdas podem parecer mais difíceis porque deixam o código mais compacto. Com prática, elas ajudam a escrever código menor, mais direto e mais fácil de manter.

## Criando listas de forma concisa

Uma lista pode ser criada item por item:

```java
List<Integer> numeros = new ArrayList<>();

numeros.add(1);
numeros.add(2);
numeros.add(3);
numeros.add(4);
numeros.add(5);
```

Mas, para uma lista simples já conhecida, podemos escrever de forma bem menor:

```java
List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
```

As duas formas criam uma lista com os mesmos números, mas a segunda reduz bastante a quantidade de código.

Esse é um ponto importante do Java moderno: escrever muito ou pouco depende bastante do conhecimento das APIs disponíveis.

## Lambda com corpo

Quando a lambda precisa executar mais de uma instrução, usamos chaves para criar um corpo.

Exemplo: criar uma segunda lista contendo apenas números pares.

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> numerosPares = new ArrayList<>();

        numeros.forEach(numero -> {
            if (numero % 2 == 0) {
                numerosPares.add(numero);
            }
        });

        System.out.println("Números pares: " + numerosPares);
    }
}
```

Saída:

```txt
Números pares: [2, 4, 6]
```

Nesse exemplo, o `if` verifica se o número é par:

```java
numero % 2 == 0
```

O operador `%` retorna o resto da divisão. Se o resto da divisão por `2` for `0`, o número é par.

## Regras importantes das lambdas

### Parênteses opcionais

Quando existe apenas um parâmetro e o tipo é inferido pelo Java, os parênteses podem ser omitidos.

```java
numeros.forEach(numero -> System.out.println(numero));
```

Também seria possível escrever:

```java
numeros.forEach((numero) -> System.out.println(numero));
```

Como a lista foi declarada como `List<Integer>`, o Java já sabe que `numero` é um `Integer`.

### Tipo explícito exige parênteses

Se o tipo do parâmetro for escrito explicitamente, os parênteses são obrigatórios.

Correto:

```java
numeros.forEach((Integer numero) -> System.out.println(numero));
```

Incorreto:

```java
numeros.forEach(Integer numero -> System.out.println(numero));
```

Quando o tipo aparece na lambda, o Java exige os parênteses ao redor do parâmetro.

### Chaves opcionais

Se a lambda tem apenas uma instrução, as chaves podem ser omitidas.

```java
numeros.forEach(numero -> System.out.println(numero));
```

Se a lambda tem mais de uma instrução, use chaves.

```java
numeros.forEach(numero -> {
    System.out.println("Número atual:");
    System.out.println(numero);
});
```

Essa regra lembra o `if`: quando existe só uma instrução, as chaves podem ser omitidas, mas em código real muitas equipes preferem manter as chaves para melhorar a leitura e reduzir risco de erro em alterações futuras.

## Variáveis locais em lambdas

Uma lambda pode acessar variáveis locais do escopo onde foi criada, mas essas variáveis precisam ser `final` ou efetivamente finais.

Uma variável `final` é uma constante: depois de receber valor, não pode ser alterada.

```java
final int i = 10;

numeros.forEach(numero -> {
    System.out.println("Valor de i: " + i);
});
```

Esse código funciona porque `i` foi declarado como `final`.

Também funciona quando a variável é **efetivamente final**.

```java
int i = 10;

numeros.forEach(numero -> {
    System.out.println("Valor de i: " + i);
});
```

Mesmo sem a palavra `final`, o compilador percebe que `i` não foi alterado depois da inicialização. Por isso, trata essa variável como efetivamente final.

Agora, se o valor for alterado, a lambda não pode mais acessar essa variável:

```java
int i = 10;
i++;

numeros.forEach(numero -> {
    System.out.println("Valor de i: " + i);
});
```

Esse exemplo não compila, porque `i` deixou de ser efetivamente final.

O mesmo aconteceria com uma reatribuição:

```java
int i = 10;
i = 20;

numeros.forEach(numero -> {
    System.out.println("Valor de i: " + i);
});
```

Para lembrar:

- variável local fora da lambda pode ser lida dentro da lambda se for `final`;
- variável local fora da lambda também pode ser lida se for efetivamente final;
- se a variável local for alterada depois da inicialização, ela não pode ser capturada pela lambda.

## Variáveis criadas dentro da lambda

Variáveis declaradas dentro do corpo da lambda pertencem ao próprio bloco da lambda.

```java
numeros.forEach(numero -> {
    int y = 200;
    y++;

    System.out.println("Valor de y: " + y);
});
```

Nesse caso, `y` é criada dentro da lambda a cada execução. Por isso, ela pode ser alterada normalmente dentro desse bloco.

O cuidado principal é com variáveis locais criadas fora da lambda e capturadas por ela.

## Próximo passo

Depois de lambdas, o próximo assunto da trilha é [Programação Funcional](../08-programacao-funcional).

## Percepções

> Registrar aprendizados conforme o estudo avançar.
