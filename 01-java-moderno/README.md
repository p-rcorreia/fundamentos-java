# 01 - Java moderno

## Objetivo

Entender os fundamentos e os recursos modernos da linguagem Java usados no mercado, criando uma base confortável para projetos backend.

> Referência prática: estudar com Java 17+ ou superior. Cursos que usam Java 21 ou Java 22 também servem bem, desde que os recursos mais novos sejam tratados como complemento.

## Checklist

- [x] Diferença entre versões LTS e não LTS
- [x] OpenJDK vs Oracle JDK, noção inicial
- [x] Sintaxe básica
- [x] Classes, noção inicial
- [x] Método `main`, noção inicial
- [x] Pacotes
- [x] Modificadores de acesso
- [x] Variáveis
- [x] Comentários
- [x] Identificadores válidos
- [x] Convenções de nomenclatura
- [x] Operadores aritméticos
- [x] Operadores de comparação
- [x] Operadores lógicos
- [x] Operadores de atribuição
- [x] Operadores de incremento e decremento
- [x] Controle de fluxo
- [x] `if`, `else if` e `else`
- [x] Operador ternário
- [x] `instanceof`, noção inicial
- [x] Loops: `for`, `while` e `do while`
- [x] Controle de loop com `break` e `continue`
- [x] `var`
- [x] `switch expressions`
- [x] `text blocks`
- [x] String templates, noção histórica
- [x] `records`
- [x] `sealed classes`, apenas noção inicial
- [x] Pattern matching, apenas noção inicial
- [x] Boas práticas com Java moderno

## Por que importa no backend?

Java moderno é a base de muitos projetos backend com Spring Boot. O foco aqui é aprender a linguagem atual sem ficar preso a uma única versão: Java 17+ cobre bem o mercado, Java 21 traz uma base LTS mais recente e Java 22 aparece em cursos atuais.

## Variáveis

Uma **variável** é um nome que damos para um valor que queremos guardar e usar depois.

Uma forma simples de pensar é imaginar uma receita. Se a receita pede duas xícaras de farinha, podemos guardar esse valor em uma variável chamada `farinha`.

```java
int farinha = 2;

System.out.println("A receita requer " + farinha + " xícaras de farinha.");
```

Nesse exemplo:

- `int` indica o tipo da variável;
- `farinha` é o nome da variável;
- `2` é o valor armazenado;
- `;` finaliza a instrução.

## Estrutura inicial de um programa Java

Um programa Java simples costuma ter uma classe e um método `main`.

```java
public class Main {
    public static void main(String[] args) {
        int farinha = 2;

        System.out.println("A receita requer " + farinha + " xícaras de farinha.");
    }
}
```

Neste momento, o mais importante é entender onde a variável aparece. Detalhes como `public`, `static`, `void`, `String[] args` e chaves ficam mais claros conforme o estudo avança.

## Classe, noção inicial

Uma **classe** é uma estrutura que define um tipo dentro do Java.

Neste primeiro contato, basta entender que a classe organiza o código e precisa ter o mesmo nome do arquivo quando ela é `public`.

```java
// Arquivo: Main.java
public class Main {
    public static void main(String[] args) {
        System.out.println("Olá, Java!");
    }
}
```

Nesse exemplo:

- `Main.java` é o arquivo;
- `Main` é a classe;
- `public class Main` declara uma classe pública;
- o método `main` é o ponto de entrada do programa.

O estudo mais completo de classe, objeto, atributo e método fica no tópico de Orientação a Objetos.

## Pacotes

Pacotes servem para organizar classes em grupos.

Eles funcionam como pastas lógicas dentro do projeto e ajudam a separar responsabilidades.

```java
package br.com.exemplo.cadastro;

public class Cliente {
}
```

Nesse exemplo, a classe `Cliente` pertence ao pacote:

```txt
br.com.exemplo.cadastro
```

Em projetos Java reais, pacotes ajudam a separar partes como:

- controllers;
- services;
- repositories;
- entities;
- DTOs;
- configurações.

Um exemplo comum em backend:

```txt
br.com.empresa.projeto
├── controller
├── service
├── repository
├── entity
└── dto
```

Pacotes deixam o projeto mais navegável e evitam que tudo fique misturado no mesmo lugar.

## Modificadores de acesso

Modificadores de acesso controlam quem pode enxergar ou usar classes, atributos, métodos e construtores.

Os principais são:

| Modificador | Acesso |
|---|---|
| `public` | acessível de qualquer lugar |
| `private` | acessível apenas dentro da própria classe |
| `protected` | acessível no mesmo pacote e por subclasses |
| sem modificador | acessível apenas dentro do mesmo pacote |

Exemplo:

```java
public class Conta {
    private double saldo;

    public void depositar(double valor) {
        saldo += valor;
    }

    public double getSaldo() {
        return saldo;
    }
}
```

Nesse exemplo:

- `saldo` é `private`, então não pode ser alterado diretamente por qualquer parte do sistema;
- `depositar` é `public`, então outras classes podem chamar esse comportamento;
- `getSaldo` é `public`, então outras classes podem consultar o saldo.

Esse controle é uma base importante para encapsulamento em Orientação a Objetos.

## Comentários

Comentários são trechos ignorados pelo compilador. Eles servem para deixar notas e explicações no código.

Comentário de linha única:

```java
// Este é um comentário de linha única
int numero = 10;
```

Comentário de várias linhas:

```java
/*
 Este é um comentário
 de várias linhas.
*/
int numero = 10;
```

Comentário Javadoc:

```java
/**
 * Comentário usado para documentação.
 */
public static void main(String[] args) {
}
```

Comentários ajudam quando explicam algo importante, mas comentários demais podem atrapalhar a leitura. O ideal é comentar apenas o necessário.

## Identificadores

Um **identificador** é o nome dado a uma variável, método, classe ou outro elemento criado no código.

Regras importantes:

- pode usar letras de `A` a `Z` e de `a` a `z`;
- pode usar dígitos de `0` a `9`, mas não no primeiro caractere;
- pode usar `_` e `$`, embora não seja uma boa prática para nomes comuns;
- Java diferencia maiúsculas de minúsculas;
- não pode usar palavras reservadas como `class`, `public`, `void` e `int`.

Exemplos válidos:

```java
int idade = 25;
double salarioAnual = 72000.00;
String nomeCompleto = "Ana Silva";
```

Exemplos inválidos:

```java
int 2idade = 25;
int class = 10;
int salario-anual = 72000;
```

## Convenções de nomenclatura

Além de seguir as regras da linguagem, é importante seguir convenções para deixar o código legível.

Para variáveis e métodos, usamos `camelCase`:

```java
int idadeUsuario = 25;
double salarioAnual = 72000.00;
```

Para classes, usamos `PascalCase`:

```java
public class Funcionario {
}

public class GerenteDeConta {
}
```

Bons nomes devem ser curtos o suficiente para ler com facilidade, mas descritivos o suficiente para explicar a intenção.

## `var`

A palavra `var` foi introduzida no Java 10 para permitir **inferência de tipo** em variáveis locais.

Inferir é deduzir algo a partir do contexto. Quando usamos `var`, o compilador analisa o valor atribuído e descobre o tipo da variável.

```java
var numero = 10;
var salario = 2500.50;
```

No primeiro caso, `numero` é inferido como `int`. No segundo, `salario` é inferido como `double`.

Algumas regras importantes:

- `var` só pode ser usado em variáveis locais;
- a variável precisa ser inicializada;
- não é possível usar `var` com `null`, porque o compilador não conseguiria inferir o tipo;
- usar `var` pode reduzir verbosidade, mas não deve prejudicar a leitura.

Exemplo inválido:

```java
var valor = null;
```

`var` não é uma palavra reservada tradicional. Isso preserva compatibilidade com códigos antigos que já usavam `var` como nome de variável antes do Java 10. Mesmo assim, por convenção, não use `var` como nome de variável.

## Operadores

Operadores são símbolos especiais usados para realizar operações com valores e variáveis.

Em Java, eles podem atuar sobre um, dois ou três operandos e retornam um resultado.

Alguns grupos importantes:

- operadores aritméticos;
- operadores de comparação;
- operadores lógicos;
- operadores de atribuição;
- operadores de incremento e decremento.

## Operadores aritméticos

Operadores aritméticos realizam operações matemáticas comuns.

| Operador | Operação |
|---|---|
| `+` | adição |
| `-` | subtração |
| `*` | multiplicação |
| `/` | divisão |
| `%` | resto da divisão |

Exemplo:

```java
int a = 10;
int b = 2;

System.out.println(a + b); // 12
System.out.println(a - b); // 8
System.out.println(a * b); // 20
System.out.println(a / b); // 5
System.out.println(a % b); // 0
```

O operador `%` retorna o resto da divisão.

```java
System.out.println(10 % 2); // 0
System.out.println(10 % 3); // 1
```

## Operadores de comparação

Operadores de comparação comparam dois valores e retornam `true` ou `false`.

| Operador | Significado |
|---|---|
| `==` | igual a |
| `!=` | diferente de |
| `>` | maior que |
| `<` | menor que |
| `>=` | maior ou igual a |
| `<=` | menor ou igual a |

Exemplo:

```java
int a = 10;
int b = 20;

System.out.println(a == b); // false
System.out.println(a != b); // true
System.out.println(a > b);  // false
System.out.println(a < b);  // true
System.out.println(a >= b); // false
System.out.println(a <= b); // true
```

Atenção:

```java
int a = 10;                  // atribuição
boolean igual = a == 10;      // comparação
```

Um único `=` atribui valor. Dois `==` comparam valores.

## Operadores lógicos

Operadores lógicos combinam condições booleanas.

| Operador | Nome | Significado |
|---|---|---|
| `&&` | E lógico | verdadeiro se os dois lados forem verdadeiros |
| `||` | OU lógico | verdadeiro se pelo menos um lado for verdadeiro |
| `!` | NÃO lógico | inverte o valor booleano |

Exemplo:

```java
int a = 10;
int b = 20;
boolean c = true;

System.out.println(a < b && c); // true
System.out.println(a > b || c); // true
System.out.println(!c);         // false
```

No `&&`, os dois lados precisam ser verdadeiros.

No `||`, basta um dos lados ser verdadeiro.

No `!`, o valor é invertido: `true` vira `false`, e `false` vira `true`.

## Operadores de atribuição

Operadores de atribuição guardam ou atualizam valores em variáveis.

| Operador | Exemplo | Equivalente |
|---|---|---|
| `=` | `a = 10` | atribui `10` a `a` |
| `+=` | `a += 2` | `a = a + 2` |
| `-=` | `a -= 2` | `a = a - 2` |
| `*=` | `a *= 2` | `a = a * 2` |
| `/=` | `a /= 2` | `a = a / 2` |
| `%=` | `a %= 2` | `a = a % 2` |

Exemplo:

```java
int a = 10;

a += 2;
System.out.println(a); // 12

a -= 4;
System.out.println(a); // 8
```

Esses operadores deixam algumas atualizações mais curtas e legíveis.

## Operadores de incremento e decremento

Os operadores `++` e `--` aumentam ou diminuem uma variável em `1`.

```java
int a = 10;

a++;
System.out.println(a); // 11

a--;
System.out.println(a); // 10
```

Essas formas são equivalentes a:

```java
a = a + 1;
a = a - 1;
```

## Pré e pós-incremento

A posição do operador muda o momento em que a operação acontece.

No **pós-incremento**, o valor é usado primeiro e incrementado depois:

```java
int a = 10;
int b = a++;

System.out.println(a); // 11
System.out.println(b); // 10
```

No **pré-incremento**, o valor é incrementado primeiro e usado depois:

```java
int a = 10;
int b = ++a;

System.out.println(a); // 11
System.out.println(b); // 11
```

O mesmo raciocínio vale para decremento:

```java
int a = 10;
int b = a--;

System.out.println(a); // 9
System.out.println(b); // 10
```

```java
int a = 10;
int b = --a;

System.out.println(a); // 9
System.out.println(b); // 9
```

Esse detalhe é importante porque o mau uso de pré e pós-incremento pode causar bugs difíceis de perceber em cálculos e regras de negócio.

## Controle de fluxo

Controle de fluxo é a parte da programação que permite tomar decisões e executar blocos de código com base em condições específicas.

Ele é essencial para:

- tomar decisões;
- repetir tarefas;
- executar um caminho ou outro dependendo do estado do programa.

## `if` e `else`

O `if` executa um bloco de código se uma condição for verdadeira.

O `else` executa outro bloco quando a condição do `if` for falsa.

```java
int a = 10;

if (a > 5) {
    System.out.println("A é maior que cinco");
} else {
    System.out.println("A não é maior que cinco");
}
```

Nesse exemplo, `a > 5` retorna `true`, então o primeiro bloco é executado.

## `else if`

O `else if` permite testar mais de uma condição.

```java
int nota = 7;

if (nota >= 9) {
    System.out.println("Excelente");
} else if (nota >= 7) {
    System.out.println("Aprovado");
} else {
    System.out.println("Reprovado");
}
```

O Java testa as condições de cima para baixo. Quando uma condição verdadeira é encontrada, o bloco correspondente é executado.

## Operador ternário

O operador ternário é uma forma compacta de escrever um `if/else` simples.

Sintaxe:

```java
condicao ? valorSeVerdadeiro : valorSeFalso;
```

Exemplo com `if/else`:

```java
int numero = 10;
String resultado;

if (numero % 2 == 0) {
    resultado = "Par";
} else {
    resultado = "Ímpar";
}

System.out.println("O número é: " + resultado);
```

Mesmo exemplo com operador ternário:

```java
int numero = 10;
String resultado = (numero % 2 == 0) ? "Par" : "Ímpar";

System.out.println("O número é: " + resultado);
```

O ternário é útil para condições curtas. Se a lógica começar a ficar grande ou difícil de ler, prefira `if/else`.

## `instanceof`

O operador `instanceof` verifica se um objeto é de determinado tipo.

```java
Object obj = "Hello";

if (obj instanceof String) {
    System.out.println(obj);
}
```

Nesse exemplo, `obj instanceof String` pergunta se `obj` é uma `String`. Como é verdadeiro, o bloco do `if` é executado.

Esse recurso é útil quando precisamos garantir o tipo de um objeto antes de executar alguma lógica específica.

## `switch`

O `switch` permite executar blocos diferentes de código com base no valor de uma variável.

Ele é útil quando existem vários caminhos possíveis para um mesmo valor analisado.

Exemplo com número:

```java
int dia = 3;

switch (dia) {
    case 1 -> System.out.println("Segunda");
    case 2 -> System.out.println("Terça");
    case 3 -> System.out.println("Quarta");
    default -> System.out.println("Desconhecido");
}
```

O `default` é executado quando nenhum `case` combina com o valor testado.

## `switch expression`

O `switch` também pode ser usado como expressão para inicializar uma variável.

```java
String dia = "ter.";

String tipoDeDia = switch (dia) {
    case "seg.", "ter.", "qua.", "qui.", "sex." -> "Dia útil";
    case "sáb.", "dom." -> "Fim de semana";
    default -> "Desconhecido";
};

System.out.println(tipoDeDia);
```

Nesse exemplo, o resultado do `switch` é guardado na variável `tipoDeDia`.

Alguns pontos importantes:

- `case` compara o valor recebido pelo `switch`;
- vários valores podem ser separados por vírgula;
- `->` indica o resultado daquele caso;
- `default` trata valores não previstos;
- quando o `switch` inicializa uma variável, a expressão termina com `;`.

## Loops

Loops, também chamados de **laços**, são usados para repetir um bloco de código várias vezes.

Uma analogia simples: imagine que você precisa regar várias plantas em um jardim. Em vez de escrever uma instrução para cada planta, você usa um loop para repetir a tarefa até terminar.

Em Java, os laços mais comuns são:

- `for`;
- `while`;
- `do while`.

## `for`

O `for` é útil quando sabemos controlar a repetição com inicialização, condição e incremento.

```java
for (int i = 0; i < 5; i++) {
    System.out.println(i);
}
```

Esse código imprime:

```txt
0
1
2
3
4
```

A estrutura do `for` tem três partes principais:

```java
for (inicializacao; condicao; atualizacao) {
    // bloco repetido
}
```

No exemplo:

- `int i = 0` cria e inicializa a variável de controle;
- `i < 5` define até quando o laço continua;
- `i++` incrementa a variável após cada execução.

Quando `i` chega a `5`, a condição `i < 5` se torna falsa e o laço termina.

## `while`

O `while` executa um bloco enquanto uma condição for verdadeira.

```java
int j = 0;

while (j < 5) {
    System.out.println(j);
    j++;
}
```

O teste acontece antes da execução do bloco.

Se a condição já começar falsa, o bloco pode não executar nenhuma vez.

```java
int j = 20;

while (j < 5) {
    System.out.println(j);
    j++;
}
```

Nesse caso, nada é impresso.

## `do while`

O `do while` executa o bloco primeiro e verifica a condição depois.

Isso garante que o bloco seja executado pelo menos uma vez.

```java
int k = 0;

do {
    System.out.println(k);
    k++;
} while (k < 5);
```

Mesmo se a condição começar falsa, o bloco executa uma vez:

```java
int k = 30;

do {
    System.out.println(k);
    k++;
} while (k < 5);
```

Esse exemplo imprime `30` uma vez e depois termina.

Um caso comum para `do while` é solicitar uma entrada do usuário pelo menos uma vez e repetir enquanto ela não for válida.

## `break`

O `break` interrompe o loop imediatamente.

```java
for (int i = 0; i < 10; i++) {
    if (i == 5) {
        break;
    }

    System.out.println(i);
}
```

Esse código imprime de `0` a `4`. Quando `i` chega a `5`, o `break` sai do laço.

## `continue`

O `continue` pula a execução restante da iteração atual e volta para a próxima repetição do loop.

```java
for (int i = 0; i < 10; i++) {
    if (i == 5) {
        continue;
    }

    System.out.println(i);
}
```

Esse código imprime de `0` a `9`, mas pula o `5`.

Diferença importante:

- `break` sai do loop;
- `continue` pula apenas a iteração atual.

Use `break` e `continue` com cuidado. Eles são úteis, mas em excesso podem deixar o fluxo do código mais difícil de acompanhar.

## Text blocks

Text blocks são strings multilinha criadas com três aspas duplas.

Eles foram adicionados ao Java para facilitar a escrita de textos grandes, como JSON, SQL, HTML ou mensagens formatadas, sem precisar concatenar várias strings nem escapar tantas aspas.

Exemplo:

```java
String json = """
        {
            "nome": "Ana",
            "idade": 30,
            "ativo": true
        }
        """;

System.out.println(json);
```

Sem text block, esse mesmo conteúdo ficaria mais verboso:

```java
String json = "{\\n" +
        "  \\"nome\\": \\"Ana\\",\\n" +
        "  \\"idade\\": 30,\\n" +
        "  \\"ativo\\": true\\n" +
        "}";
```

Text blocks melhoram a legibilidade quando o texto tem várias linhas.

Casos comuns:

- JSON de exemplo;
- SQL;
- HTML;
- XML;
- mensagens grandes;
- templates simples de texto.

## String templates

String templates foram uma tentativa de trazer interpolação de strings para Java de forma mais segura e poderosa.

A ideia era permitir algo como:

```java
String nome = "Ana";
String mensagem = STR."Olá, \\{nome}";
```

Esse recurso apareceu como **preview** no Java 21 e Java 22, mas foi retirado no Java 23.

Por isso, é bom conhecer a ideia, especialmente se aparecer em vídeos ou artigos sobre Java 21/22, mas não vale tratar como recurso estável para projetos reais.

Para código atual, as alternativas mais comuns continuam sendo:

```java
String nome = "Ana";

String mensagem1 = "Olá, " + nome;
String mensagem2 = "Olá, %s".formatted(nome);
```

## Records

`record` é uma forma concisa de criar classes simples para transportar dados.

Ele reduz código repetitivo, porque o Java gera automaticamente construtor, métodos de acesso, `equals`, `hashCode` e `toString`.

Exemplo:

```java
public record ClienteResumo(String nome, String email) {
}
```

Uso:

```java
ClienteResumo cliente = new ClienteResumo("Ana", "ana@email.com");

System.out.println(cliente.nome());
System.out.println(cliente.email());
```

Um record é muito útil para DTOs, respostas de API e objetos simples de leitura.

Comparação rápida:

```java
public class ClienteResumo {
    private final String nome;
    private final String email;

    public ClienteResumo(String nome, String email) {
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

Com `record`, essa estrutura fica muito menor.

## Sealed classes

`sealed class` e `sealed interface` permitem limitar quais classes podem herdar ou implementar um tipo.

Isso é útil quando queremos modelar um conjunto fechado de possibilidades.

Exemplo:

```java
public sealed interface FormaPagamento
        permits Pix, Cartao, Boleto {
}

public final class Pix implements FormaPagamento {
}

public final class Cartao implements FormaPagamento {
}

public final class Boleto implements FormaPagamento {
}
```

Nesse exemplo, apenas `Pix`, `Cartao` e `Boleto` podem implementar `FormaPagamento`.

Isso ajuda a deixar o domínio mais explícito, porque o Java sabe quais variações são permitidas.

## Pattern matching

Pattern matching deixa algumas verificações de tipo mais simples e legíveis.

Antes:

```java
Object valor = "Java";

if (valor instanceof String) {
    String texto = (String) valor;
    System.out.println(texto.toUpperCase());
}
```

Com pattern matching para `instanceof`:

```java
Object valor = "Java";

if (valor instanceof String texto) {
    System.out.println(texto.toUpperCase());
}
```

O Java verifica se `valor` é uma `String` e, se for, já cria a variável `texto` com o tipo correto.

Isso reduz cast manual e deixa o código mais direto.

## Versões do Java

Java tem várias versões, e elas podem ser entendidas em alguns grupos principais.

## Versões não LTS

Versões **não LTS** são lançadas com mais frequência, geralmente trazendo recursos mais recentes da linguagem.

Elas são úteis para estudo, experimentação e contato com novidades, mas costumam ter suporte mais curto, porque logo são substituídas por versões novas.

Um curso pode usar uma versão não LTS, como Java 22, para ensinar recursos atuais da linguagem. Para aprendizado, isso faz sentido.

## Versões LTS

**LTS** vem de **Long-Term Support**, ou **Suporte de Longo Prazo**.

Versões LTS são usadas quando a prioridade é estabilidade e suporte por mais tempo. Em projetos corporativos, isso costuma importar bastante.

Na prática:

- versões não LTS ajudam a acompanhar novidades;
- versões LTS são mais comuns em ambientes de produção;
- o código Java tende a funcionar da mesma forma, mas o tempo de suporte muda.

## OpenJDK e Oracle JDK

O **OpenJDK** é a implementação gratuita e aberta do Java. Ele é amplamente usado por pessoas, empresas e projetos no mundo todo.

O **Oracle JDK** é uma distribuição mantida pela Oracle. Em muitos casos, ele tem os mesmos recursos do OpenJDK, mas pode envolver licença e suporte comercial pago, dependendo do uso.

Para estudar e desenvolver projetos pessoais, o OpenJDK é uma escolha excelente, gratuita e confiável.

## Por que estudar com Java 22 pode fazer sentido?

Mesmo não sendo uma versão LTS, Java 22 pode ser uma boa escolha em curso porque:

- traz recursos modernos da linguagem;
- facilita o contato com novidades;
- é suficiente para aprendizado;
- permite migrar depois para uma versão LTS, se necessário;
- usa a base aberta do OpenJDK.

Em resumo: o Java continua sendo Java. O que muda entre versões e distribuições é principalmente o tempo de suporte, a frequência de atualizações, a licença e a existência ou não de suporte comercial pago.

## Conteúdos recomendados

- Udemy: Java Moderno, Fácil de Seguir, com Spring Boot e Projetos
- Udemy: Domine as Inovações do Java com Spring Boot & MongoDB
- Alura: Principais mudanças do Java desde a versão 8
- DIO: Classes Seladas em Java
- TabNews: Você tá escrevendo Java errado

## Percepções

> Registrar aprendizados conforme o estudo avançar.
