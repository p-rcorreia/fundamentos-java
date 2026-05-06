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
- [x] Wrappers: `Integer`, `Long`, `Double`, `Boolean`
- [x] Autoboxing e unboxing
- [x] `null` em objetos
- [x] Comparação com `==` e `equals`
- [x] Diferença entre valor e referência
- [x] Imutabilidade em `String`
- [x] `BigDecimal` para valores monetários
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

## Wrappers

Wrappers são classes que representam tipos primitivos como objetos.

| Primitivo | Wrapper |
|---|---|
| `byte` | `Byte` |
| `short` | `Short` |
| `int` | `Integer` |
| `long` | `Long` |
| `float` | `Float` |
| `double` | `Double` |
| `boolean` | `Boolean` |
| `char` | `Character` |

Exemplo:

```java
int idadePrimitiva = 25;
Integer idadeObjeto = 25;
```

`int` guarda um valor simples.

`Integer` é um objeto que representa um número inteiro.

## Por que wrappers existem?

Wrappers são úteis porque algumas APIs trabalham com objetos, não com tipos primitivos.

Um exemplo importante são collections:

```java
import java.util.ArrayList;
import java.util.List;

List<Integer> idades = new ArrayList<>();

idades.add(25);
idades.add(30);
```

Não usamos `List<int>`, porque generics em Java trabalham com tipos de referência.

Por isso usamos `List<Integer>`.

Wrappers também permitem representar ausência com `null`:

```java
Integer idade = null;
```

Um `int` não pode ser `null`.

```java
int idade = null; // não compila
```

## Autoboxing

**Autoboxing** é a conversão automática de um valor primitivo para seu wrapper.

```java
int numero = 10;

Integer numeroObjeto = numero;
```

O Java faz automaticamente algo parecido com:

```java
Integer numeroObjeto = Integer.valueOf(numero);
```

Outro exemplo:

```java
List<Integer> numeros = new ArrayList<>();

numeros.add(10); // int vira Integer automaticamente
```

## Unboxing

**Unboxing** é a conversão automática de um wrapper para seu tipo primitivo.

```java
Integer numeroObjeto = 10;

int numero = numeroObjeto;
```

O Java faz automaticamente algo parecido com:

```java
int numero = numeroObjeto.intValue();
```

## Cuidado com `null` no unboxing

Wrappers podem ser `null`.

Primitivos não podem.

Isso pode causar erro em tempo de execução:

```java
Integer quantidade = null;

int valor = quantidade; // NullPointerException
```

O problema acontece porque o Java tenta fazer unboxing de `quantidade`, mas não existe valor dentro dela.

Uma forma mais segura:

```java
Integer quantidade = null;

if (quantidade != null) {
    int valor = quantidade;
    System.out.println(valor);
}
```

## Valor vs referência

Tipos primitivos guardam valores diretamente.

```java
int a = 10;
int b = a;

b = 20;

System.out.println(a); // 10
System.out.println(b); // 20
```

Mudar `b` não altera `a`, porque cada variável tem seu próprio valor.

Objetos são acessados por referência.

```java
class Produto {
    String nome;
}

Produto p1 = new Produto();
p1.nome = "Teclado";

Produto p2 = p1;
p2.nome = "Mouse";

System.out.println(p1.nome); // Mouse
System.out.println(p2.nome); // Mouse
```

Nesse exemplo, `p1` e `p2` apontam para o mesmo objeto.

Por isso, alterar o objeto por uma referência também aparece pela outra.

## `==` vs `equals`

Com tipos primitivos, `==` compara valores.

```java
int a = 10;
int b = 10;

System.out.println(a == b); // true
```

Com objetos, `==` compara se as duas referências apontam para o mesmo objeto.

```java
Integer a = new Integer(1000);
Integer b = new Integer(1000);

System.out.println(a == b);      // false
System.out.println(a.equals(b)); // true
```

Nesse caso:

- `a == b` verifica se é o mesmo objeto na memória;
- `a.equals(b)` verifica se os valores são equivalentes.

Em código moderno, evite `new Integer(...)`, porque está obsoleto. O exemplo serve apenas para visualizar a diferença entre referência e valor.

Forma comum:

```java
Integer a = 1000;
Integer b = 1000;

System.out.println(a.equals(b)); // true
```

## Cuidado com cache de wrappers

Java mantém cache para alguns valores pequenos de wrappers, como `Integer` entre `-128` e `127`.

Por isso, este exemplo pode confundir:

```java
Integer a = 127;
Integer b = 127;

System.out.println(a == b); // true
```

Mas este pode retornar `false`:

```java
Integer a = 128;
Integer b = 128;

System.out.println(a == b); // false
```

Regra prática: para comparar wrappers e objetos por valor, use `equals`.

## `String` e imutabilidade

`String` é um objeto, mas tem comportamento especial e é muito usada como se fosse um valor.

Strings são imutáveis: depois de criadas, não mudam.

```java
String nome = "Java";

nome.toUpperCase();

System.out.println(nome); // Java
```

O método `toUpperCase()` cria uma nova `String`, mas não altera a original.

Para guardar o novo valor:

```java
String nome = "Java";

nome = nome.toUpperCase();

System.out.println(nome); // JAVA
```

Para comparar o conteúdo de strings, use `equals`:

```java
String a = "Java";
String b = "Java";

System.out.println(a.equals(b)); // true
```

## Por que importa no backend?

Erros com tipos, conversões automáticas, `null`, comparação incorreta e valores monetários são comuns em sistemas reais.

Entender tipos primitivos ajuda a evitar bugs simples, principalmente em cálculos, regras de negócio, integração com banco de dados e APIs.

## Percepções

> Tipos primitivos guardam valores simples. Cada tipo tem um propósito, um tamanho e um conjunto de valores possíveis.
>
> Promoções automáticas ajudam o Java a calcular expressões com segurança, mas também exigem atenção para evitar conversões incompatíveis.
>
> Wrappers permitem tratar primitivos como objetos, mas exigem cuidado com `null`, unboxing e comparação com `equals`.
