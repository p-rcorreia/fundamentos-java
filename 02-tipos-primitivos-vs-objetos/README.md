# 02 - Tipos primitivos vs objetos

## Objetivo

Entender a diferença entre valores primitivos, wrappers, referências e objetos em Java.

## Checklist

- [x] `byte`
- [x] `short`
- [x] `int`
- [x] `long`
- [x] `float`
- [x] `double`
- [x] `boolean`
- [x] `char`
- [ ] Wrappers: `Integer`, `Long`, `Double`, `Boolean`
- [ ] Autoboxing e unboxing
- [ ] `null` em objetos
- [ ] Comparação com `==` e `equals`
- [ ] Diferença entre valor e referência
- [ ] Imutabilidade em `String`
- [ ] `BigDecimal` para valores monetários
- [x] Promoções automáticas
- [x] Literais numéricos com `L`, `F` e `D`

## Tipos primitivos

Tipos primitivos são os blocos de construção mais básicos da linguagem.

Uma analogia simples: se você está construindo uma casa, precisa de materiais básicos como tijolo, cimento, areia e aço. Em Java, os tipos primitivos são esses materiais básicos para representar valores simples.

Cada tipo primitivo tem um propósito específico e aceita um tipo de informação.

## Tipos inteiros

Tipos inteiros representam números sem casas decimais.

| Tipo | Tamanho | Uso comum |
|---|---:|---|
| `byte` | 8 bits | valores pequenos, como uma idade limitada |
| `short` | 16 bits | valores inteiros menores |
| `int` | 32 bits | inteiro padrão na maioria dos casos |
| `long` | 64 bits | números inteiros muito grandes |

Exemplos:

```java
byte idade = 25;
short ano = 2024;
int populacaoCidade = 500000;
long populacaoMundial = 8000000000L;
```

O `L` no final indica que o número é do tipo `long`.

## Tipos de ponto flutuante

Tipos de ponto flutuante representam números com casas decimais.

| Tipo | Tamanho | Uso comum |
|---|---:|---|
| `float` | 32 bits | decimal com menor precisão |
| `double` | 64 bits | decimal padrão na maioria dos casos |

Exemplos:

```java
float altura = 1.75F;
double salario = 3500.50;
```

Em Java, números decimais usam ponto, não vírgula.

```java
double valorCorreto = 1.5;
```

O `F` no final indica que o valor é `float`. Sem o `F`, o Java entende o número decimal como `double`.

O `D` pode ser usado para indicar `double`, mas geralmente não é necessário:

```java
double valor = 10.5D;
```

## `boolean`

O tipo `boolean` representa verdadeiro ou falso.

```java
boolean estudante = true;
boolean ativo = false;
```

Em Java, usamos `true` e `false`, não `sim` e `não`.

## `char`

O tipo `char` representa um único caractere.

```java
char inicial = 'A';
```

Java diferencia maiúsculas de minúsculas. Portanto, `'A'` e `'a'` são caracteres diferentes.

## Exemplo completo

```java
public class Main {
    public static void main(String[] args) {
        byte idade = 25;
        short ano = 2024;
        int populacaoCidade = 500000;
        long populacaoMundial = 8000000000L;
        float altura = 1.75F;
        double salario = 3500.50;
        boolean estudante = true;
        char inicial = 'A';

        System.out.println("Idade: " + idade);
        System.out.println("Ano: " + ano);
        System.out.println("População da cidade: " + populacaoCidade);
        System.out.println("População mundial: " + populacaoMundial);
        System.out.println("Altura: " + altura);
        System.out.println("Salário: " + salario);
        System.out.println("É estudante? " + estudante);
        System.out.println("Inicial: " + inicial);
    }
}
```

## Promoções automáticas

Promoção automática é quando Java converte automaticamente um tipo menor para um tipo maior durante uma expressão.

Isso ajuda a preservar precisão e evitar perda de informação em cálculos.

## `byte`, `short` e `char` viram `int`

Quando `byte`, `short` ou `char` participam de uma expressão, o resultado costuma ser promovido para `int`.

```java
byte a = 10;
int b = a + 5;
```

Mesmo `a` sendo `byte`, a expressão `a + 5` gera um resultado do tipo `int`.

## Promoção para `long`

Se um dos operandos é `long`, o outro valor é promovido para `long`.

```java
int a = 10;
long b = 15L;

long resultado = a + b;
```

Nesse caso, `a` é promovido para `long` antes do cálculo.

## Promoção para `float`

Se um dos operandos é `float`, o outro valor é promovido para `float`.

```java
int a = 10;
float b = 1.5F;

float resultado = a * b;
```

Mesmo `a` sendo `int`, ele é promovido para `float` antes da multiplicação.

## Analogia da pizza

Uma forma simples de entender promoção automática é pensar em uma pizza de dois sabores.

Se metade da pizza custa R$ 50 e a outra metade custa R$ 80, muitas pizzarias cobram pelo maior valor. Em uma expressão Java, quando tipos diferentes aparecem juntos, o resultado tende a seguir o tipo maior ou mais abrangente.

## Cuidados importantes

Nem toda conversão acontece automaticamente.

Este exemplo não compila:

```java
var numero = 10;
byte numeroMenor = numero;
```

O compilador infere `numero` como `int`. Como `byte` é menor que `int`, Java não faz essa conversão automaticamente porque poderia haver perda de informação.

Com decimal, acontece algo parecido:

```java
var valor = 10.5;
double outroValor = valor;
```

Nesse caso, `valor` é inferido como `double`.

## Por que importa no backend?

Erros com tipos, conversões automáticas, `null`, comparação incorreta e valores monetários são comuns em sistemas reais.

Entender tipos primitivos ajuda a evitar bugs simples, principalmente em cálculos, regras de negócio, integração com banco de dados e APIs.

## Percepções

> Tipos primitivos guardam valores simples. Cada tipo tem um propósito, um tamanho e um conjunto de valores possíveis.
>
> Promoções automáticas ajudam o Java a calcular expressões com segurança, mas também exigem atenção para evitar conversões incompatíveis.
