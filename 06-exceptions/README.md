# 06 - Exceptions

## Objetivo

Entender como Java representa, lança e trata problemas que acontecem durante a execução de um programa.

Exceções são situações inesperadas que interrompem o fluxo normal do código, mas que muitas vezes podem ser tratadas para que o programa continue funcionando.

## Checklist

- [x] O que são exceções
- [x] Checked exceptions
- [x] Unchecked exceptions
- [x] `RuntimeException`
- [x] `try/catch`
- [x] `finally`
- [x] `throw`
- [x] `throws`
- [ ] Criar exceções customizadas
- [x] Quando lançar exceção
- [x] Quando tratar exceção
- [ ] Tratamento global no Spring Boot
- [x] Diferença entre erro de regra de negócio e erro técnico

## Por que importa no backend?

APIs precisam transformar falhas em respostas HTTP claras e consistentes.

Se uma exceção não for tratada, ela pode derrubar o fluxo da aplicação e devolver uma resposta confusa para quem está consumindo a API. Em sistemas backend, tratar bem exceções ajuda a:

- evitar que problemas pequenos interrompam todo o sistema;
- devolver mensagens mais úteis;
- separar erro técnico de erro de regra de negócio;
- registrar logs melhores;
- manter o sistema previsível.

## O Que São Exceptions

Uma exceção é como um alerta disparado quando algo inesperado acontece durante a execução do programa.

Exemplos comuns:

- dividir um número por zero;
- acessar uma posição inexistente de um array;
- chamar um método em um objeto `null`;
- tentar abrir um arquivo que não existe;
- receber um dado inválido em uma regra de negócio.

Em Java, uma exceção é representada por um objeto. Esse objeto é lançado quando o problema acontece e pode ser capturado por um bloco de tratamento.

## Error Não É Exception

Em Java, é importante separar duas ideias:

- `Error`: representa problemas graves, normalmente fora do controle da aplicação.
- `Exception`: representa problemas que podem ser tratados pelo programa.

Exemplos de `Error`:

- falta de memória;
- falhas graves da JVM;
- problemas internos que comprometem a execução.

Exemplos de `Exception`:

- divisão por zero;
- objeto nulo;
- índice inválido em array;
- arquivo não encontrado;
- entrada inválida do usuário.

No dia a dia, quando estamos falando de tratamento recuperável no código, geralmente estamos falando de exceptions, não de `Error`.

## Hierarquia

A hierarquia principal é:

```text
Object
  Throwable
    Error
    Exception
      RuntimeException
```

Tudo começa em `Throwable`, que é a superclasse dos problemas que podem ser lançados.

`Error` e `Exception` são filhos de `Throwable`, mas têm propósitos diferentes.

## Checked E Unchecked Exceptions

As exceções em Java se dividem em duas categorias principais.

## Checked Exceptions

Checked exceptions são exceções que o compilador obriga você a tratar ou declarar com `throws`.

Elas representam situações esperadas em operações externas ou arriscadas, como trabalhar com arquivos, rede ou banco de dados.

Exemplos:

- `IOException`;
- `SQLException`;
- `FileNotFoundException`.

Se um método pode lançar uma checked exception, quem chama esse método precisa lidar com isso.

## Unchecked Exceptions

Unchecked exceptions são exceções que o compilador não obriga você a tratar.

Elas são subclasses de `RuntimeException` e geralmente representam problemas de programação ou validações que aparecem em tempo de execução.

Exemplos:

- `ArithmeticException`;
- `NullPointerException`;
- `ArrayIndexOutOfBoundsException`;
- `IllegalArgumentException`.

Mesmo quando o compilador não obriga o tratamento, ainda pode ser uma boa ideia prevenir ou tratar essas exceções quando fizer sentido para o fluxo do programa.

## Try, Catch E Finally

Para tratar exceções, usamos `try`, `catch` e, opcionalmente, `finally`.

- `try`: contém o código que pode causar uma exceção.
- `catch`: captura e trata a exceção.
- `finally`: executa sempre, com ou sem exceção.

Exemplo com divisão por zero:

```java
public class ExceptionDivisaoPorZero {
    public static void main(String[] args) {
        int totalNotas = 100;
        int quantidadeAlunos = 0;

        try {
            int media = totalNotas / quantidadeAlunos;
            System.out.println("Media: " + media);
        } catch (ArithmeticException e) {
            System.out.println("Problema: divisao por zero.");
        } finally {
            System.out.println("O programa terminou.");
        }

        System.out.println("O programa segue normalmente.");
    }
}
```

Saída:

```text
Problema: divisao por zero.
O programa terminou.
O programa segue normalmente.
```

Se a divisão não gerar problema, o bloco `catch` não será executado, mas o `finally` ainda será.

## Sem Tratamento

Se o mesmo problema acontecer sem `try/catch`, a exceção interrompe o fluxo normal do programa.

```java
public class SemTratamento {
    public static void main(String[] args) {
        int totalNotas = 100;
        int quantidadeAlunos = 0;

        int media = totalNotas / quantidadeAlunos;

        System.out.println("Media: " + media);
        System.out.println("O programa segue normalmente.");
    }
}
```

Nesse caso, o programa para na divisão por zero e a linha final não é executada.

## Unnamed Variables No Catch

A partir do Java 22, é possível usar `_` quando você precisa capturar uma exceção, mas não vai usar a variável da exceção.

Antes:

```java
try {
    int media = totalNotas / quantidadeAlunos;
} catch (ArithmeticException e) {
    System.out.println("Problema: divisao por zero.");
}
```

Depois:

```java
try {
    int media = totalNotas / quantidadeAlunos;
} catch (ArithmeticException _) {
    System.out.println("Problema: divisao por zero.");
}
```

Isso faz parte da JEP 456, relacionada a unnamed variables and patterns.

Use com cuidado. Se a variável da exceção ajuda na leitura ou será usada para log, mensagem ou diagnóstico, dê um nome para ela.

## NullPointerException

`NullPointerException` acontece quando tentamos usar um objeto que está `null`.

```java
public class ExemploObjetosNulos {
    public static void main(String[] args) {
        String nome = null;

        try {
            int tamanhoNome = nome.length();
            System.out.println("Tamanho do nome: " + tamanhoNome);
        } catch (NullPointerException e) {
            System.out.println("Erro: a variavel nome esta nula.");
        }
    }
}
```

O problema acontece porque `nome` não aponta para um objeto real. Ele está nulo.

Para evitar esse problema, inicialize o objeto antes de usar:

```java
String nome = "Arnaldo";
System.out.println(nome.length());
```

Também é possível criar a `String` com construtor, embora para textos simples a forma literal seja a mais comum:

```java
String nome = new String("Arnaldo");
```

## Variáveis Locais Precisam Ser Inicializadas

Existe uma diferença importante entre variáveis locais e variáveis de instância.

Variáveis de instância recebem valores padrão:

```java
public class Exemplo {
    String texto; // null
    int numero;  // 0
}
```

Variáveis locais não recebem valor padrão automaticamente.

```java
public class Exemplo {
    public static void main(String[] args) {
        String nome;
        System.out.println(nome);
    }
}
```

Esse código nem compila.

Isso não é uma exception. É um erro de compilação, porque o compilador exige que variáveis locais sejam inicializadas antes do uso.

## ArrayIndexOutOfBoundsException

`ArrayIndexOutOfBoundsException` acontece quando tentamos acessar uma posição que não existe em um array.

```java
public class TesteArrayException {
    public static void main(String[] args) {
        try {
            int[] numeros = {1, 2, 3};
            System.out.println(numeros[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            System.out.println("Programa finalizado com ou sem problemas.");
        }
    }
}
```

O array tem três elementos:

```text
indice 0 -> 1
indice 1 -> 2
indice 2 -> 3
```

Então `numeros[5]` não existe.

Também é importante lembrar: se o tamanho do array é `3`, o último índice válido é `2`.

## getMessage

Toda exceção possui métodos úteis herdados pela hierarquia de classes.

Um dos mais comuns é `getMessage()`.

```java
catch (Exception e) {
    System.out.println("Erro: " + e.getMessage());
}
```

Esse método retorna uma descrição do problema.

Em programas pequenos, a mensagem pode parecer desnecessária. Em sistemas grandes, ela ajuda bastante no diagnóstico.

## Capturando Classes Mais Genéricas

Como exceções seguem uma hierarquia, você pode capturar uma exceção específica ou uma superclasse dela.

Exemplo específico:

```java
catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Indice invalido.");
}
```

Exemplo mais genérico:

```java
catch (RuntimeException e) {
    System.out.println("Problema em tempo de execucao.");
}
```

Exemplo ainda mais amplo:

```java
catch (Exception e) {
    System.out.println("Problema geral.");
}
```

Quando você sabe qual exceção pode acontecer, prefira capturar a exceção mais específica. Isso deixa o código mais claro.

Se usar vários `catch`, coloque os mais específicos antes dos mais genéricos.

```java
try {
    int[] numeros = {1, 2, 3};
    System.out.println(numeros[5]);
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Indice invalido.");
} catch (Exception e) {
    System.out.println("Problema geral.");
}
```

## throws

`throws` é usado na assinatura de um método para declarar que ele pode lançar uma exceção.

```java
public class ExceptionDivisaoPorZeroLancandoException {
    public static int calcularMedia(int totalNotas, int quantidadeAlunos)
            throws ArithmeticException {
        return totalNotas / quantidadeAlunos;
    }

    public static void main(String[] args) {
        int totalNotas = 10;
        int quantidadeAlunos = 0;

        try {
            int media = calcularMedia(totalNotas, quantidadeAlunos);
            System.out.println("Media das notas: " + media);
        } catch (ArithmeticException e) {
            System.out.println("Erro: divisao por zero. " + e.getMessage());
        }

        System.out.println("O programa segue normalmente.");
    }
}
```

Nesse exemplo, `calcularMedia` declara que pode lançar `ArithmeticException`.

Como `ArithmeticException` é unchecked, o compilador não obriga o tratamento. Mesmo assim, o `throws` pode servir como documentação da intenção do método.

Com checked exceptions, o tratamento ou a declaração com `throws` é obrigatório.

Exemplo conceitual:

```java
public void lerArquivo() throws java.io.IOException {
    // codigo que pode gerar IOException
}
```

Quem chamar `lerArquivo` precisará tratar ou repassar essa exceção.

## throw

`throw` é usado para lançar uma exceção intencionalmente.

Isso é útil quando o programa encontra uma condição inválida e você quer interromper aquele fluxo.

```java
public class Main {
    public static void main(String[] args) {
        int idade = 15;

        if (idade < 18) {
            throw new RuntimeException("Idade deve ser 18 ou maior.");
        }

        System.out.println("Idade valida: " + idade);
    }
}
```

Aqui, a exceção não aconteceu por acidente. Ela foi lançada de propósito para indicar uma regra inválida.

## throw Vs throws

Apesar dos nomes parecidos, são coisas diferentes.

`throw` lança uma exceção:

```java
throw new RuntimeException("Algo deu errado.");
```

`throws` declara que um método pode lançar uma exceção:

```java
public void executar() throws Exception {
    // codigo
}
```

Resumo:

- `throw`: usado dentro do método.
- `throws`: usado na assinatura do método.

## Erro Técnico E Regra De Negócio

Nem toda exceção representa o mesmo tipo de problema.

Erro técnico:

```java
int media = totalNotas / quantidadeAlunos;
```

Se `quantidadeAlunos` for zero, temos um problema técnico de execução.

Erro de regra de negócio:

```java
if (idade < 18) {
    throw new RuntimeException("Idade deve ser 18 ou maior.");
}
```

Aqui o programa está rejeitando uma condição que viola uma regra.

Em sistemas backend, essa diferença é muito importante. Um erro técnico pode virar uma resposta HTTP `500`. Um erro de regra de negócio normalmente deve virar uma resposta mais controlada, como `400` ou `422`, dependendo do caso.

## Quando Tratar Exceção

Trate uma exceção quando você consegue fazer algo útil com ela.

Exemplos:

- mostrar uma mensagem melhor;
- tentar uma alternativa;
- registrar um log;
- devolver uma resposta adequada em uma API;
- impedir que o sistema pare por causa de uma falha esperada.

Evite capturar exceções apenas para esconder o problema.

## Quando Lançar Exceção

Lance uma exceção quando o fluxo atual não pode continuar corretamente.

Exemplos:

- dado obrigatório ausente;
- valor inválido;
- regra de negócio violada;
- operação impossível no estado atual;
- falha que deve ser avisada para quem chamou o método.

## Percepções

Tratamento de exceções não serve apenas para "não quebrar o programa". Ele serve para controlar melhor o comportamento da aplicação quando algo sai do caminho esperado.

Uma exception bem tratada transforma um problema bruto em uma decisão clara do sistema.
