# 03 - Orientação a Objetos

## Objetivo

Entender como Java organiza dados, comportamento e regras por meio de **classes** e **objetos**.

Orientação a objetos é um dos pontos mais importantes da linguagem. A ideia não é decorar tudo de uma vez, mas ir juntando as peças: primeiro classe, objeto, atributo, método e construtor; depois encapsulamento, herança, polimorfismo, interfaces e boas práticas.

## Checklist

- [x] Classe
- [x] Objeto
- [x] Instância
- [x] Atributo
- [x] Variável de instância
- [x] Variável local
- [x] Método
- [x] Operador `new`
- [x] Construtor
- [x] Construtor default
- [x] Sobrecarga de construtores
- [x] Pacotes
- [x] `import`
- [x] Pacote `java.lang`
- [x] Modificadores de acesso
- [x] `public`
- [x] `private`
- [x] `protected`
- [x] Acesso default
- [x] Encapsulamento
- [x] Getters e setters
- [x] Métodos com retorno
- [x] Métodos `void`
- [x] Parâmetros em métodos
- [x] Passagem de primitivos para métodos
- [x] Passagem de objetos para métodos
- [x] Sobrecarga de métodos
- [x] Métodos estáticos
- [x] Membros estáticos
- [x] Palavra-chave `final`
- [x] Variáveis finais
- [x] Métodos finais
- [x] Classes finais
- [x] Arrays
- [x] Índices em arrays
- [x] `length`
- [x] Percorrer array com `for`
- [x] Percorrer array com `for-each`
- [x] Herança
- [x] Superclasse
- [x] Subclasse
- [x] `extends`
- [x] Relação "é um"
- [x] Sobrescrita de métodos
- [x] `super`
- [x] `super` em construtores
- [ ] Polimorfismo
- [ ] Abstração
- [x] Interface
- [x] `implements`
- [x] Métodos abstratos em interfaces
- [x] Constantes em interfaces
- [x] Interface estendendo interface
- [x] Métodos `default` em interfaces
- [x] Métodos `static` em interfaces
- [ ] Classe abstrata
- [ ] Composição
- [ ] Associação
- [ ] Agregação
- [ ] Coesão
- [ ] Acoplamento
- [ ] Responsabilidade de classe
- [ ] Diferença entre entidade, serviço e objeto de valor

## Ideia central

Uma **classe** é como uma receita.

Um **objeto** é como o bolo pronto feito a partir daquela receita.

```txt
Receita de bolo  -> classe
Bolo assado      -> objeto
Outro bolo       -> outra instância da mesma classe
```

Em Java, também usamos a palavra **instância** para falar de um objeto criado a partir de uma classe.

Por exemplo:

- abrir uma janela do Chrome: uma instância;
- abrir outra janela do Chrome: outra instância;
- abrir mais uma janela: mais uma instância.

Todas seguem o mesmo "molde" do Chrome, mas cada janela tem seu próprio estado.

## Classe e objeto

Classe é o molde. Objeto é algo criado a partir desse molde.

```java
public class Bolo {
    int quantidadeDeAcucar;
}
```

A classe `Bolo` descreve que todo bolo pode ter uma `quantidadeDeAcucar`.

Mas só declarar a classe ainda não cria um bolo de verdade no programa.

Para criar um objeto, usamos `new`:

```java
Bolo boloDeChocolate = new Bolo();
```

Essa linha pode ser lida assim:

```txt
Bolo             -> tipo da variável
boloDeChocolate -> nome da variável de referência
new Bolo()       -> cria um novo objeto do tipo Bolo
```

## Exemplo com bolos

```java
public class Bolo {
    int quantidadeDeAcucar;

    public static void main(String[] args) {
        Bolo boloDeChocolate = new Bolo();
        boloDeChocolate.quantidadeDeAcucar = 200;

        Bolo boloDeBaunilha = new Bolo();
        boloDeBaunilha.quantidadeDeAcucar = 150;

        System.out.println("Açúcar no bolo de chocolate: " + boloDeChocolate.quantidadeDeAcucar);
        System.out.println("Açúcar no bolo de baunilha: " + boloDeBaunilha.quantidadeDeAcucar);
    }
}
```

Aqui temos **uma classe** e **dois objetos**.

Cada objeto tem sua própria quantidade de açúcar:

```txt
Classe Bolo
  |
  |-- boloDeChocolate -> quantidadeDeAcucar = 200
  |
  `-- boloDeBaunilha  -> quantidadeDeAcucar = 150
```

Mesmo que os dois objetos tenham vindo da mesma classe, cada um guarda seu próprio estado.

## Variável de instância

Uma **variável de instância** é declarada dentro da classe, mas fora de qualquer método.

```java
public class Bolo {
    int quantidadeDeAcucar; // variável de instância
}
```

Ela pertence a cada objeto criado a partir da classe.

O termo "variável de instância" fala sobre **onde a variável está declarada**, não sobre o tipo dela.

```txt
Dentro da classe e fora de método -> variável de instância
Dentro de método                  -> variável local
```

## Variável local

Variável local é criada dentro de um método.

```java
public class Exemplo {
    int valorDaClasse; // variável de instância

    public static void main(String[] args) {
        int valorLocal = 10; // variável local
    }
}
```

Até aqui no curso, a maior parte das variáveis foi criada dentro do método `main`. Por isso, eram variáveis locais.

Com orientação a objetos, começamos a colocar dados dentro da classe para representar o estado dos objetos.

## Valores padrão

Variáveis de instância recebem valores padrão quando o objeto é criado.

```java
public class Bolo {
    int quantidadeDeAcucar;
}
```

Se ninguém atribuir valor a `quantidadeDeAcucar`, ela começa com `0`.

Alguns valores padrão:

| Tipo | Valor padrão |
|---|---|
| `int`, `byte`, `short`, `long` | `0` |
| `float`, `double` | `0.0` |
| `boolean` | `false` |
| `char` | caractere vazio (`\u0000`) |
| Objetos, como `String` | `null` |

Exemplo:

```java
public class Bolo {
    int quantidadeDeAcucar;

    public static void main(String[] args) {
        Bolo bolo = new Bolo();

        System.out.println(bolo.quantidadeDeAcucar); // 0
    }
}
```

Também podemos definir um valor inicial na própria classe:

```java
public class Bolo {
    int quantidadeDeAcucar = 280;
}
```

Nesse caso, se ninguém mudar o valor, todo novo bolo começa com `280`.

## Aplicando com funcionário

Vamos sair do exemplo do bolo e pensar em algo mais próximo de backend: funcionários.

```java
public class Funcionario {
    String nome;
    String cargo;
    int idade;

    public static void main(String[] args) {
        Funcionario funcionario1 = new Funcionario();
        funcionario1.nome = "João";
        funcionario1.cargo = "Desenvolvedor";
        funcionario1.idade = 30;

        Funcionario funcionario2 = new Funcionario();
        funcionario2.nome = "Maria";
        funcionario2.cargo = "Gerente";
        funcionario2.idade = 50;

        System.out.println("Nome: " + funcionario1.nome);
        System.out.println("Cargo: " + funcionario1.cargo);
        System.out.println("Idade: " + funcionario1.idade);

        System.out.println();

        System.out.println("Nome: " + funcionario2.nome);
        System.out.println("Cargo: " + funcionario2.cargo);
        System.out.println("Idade: " + funcionario2.idade);
    }
}
```

Aqui a classe `Funcionario` é reutilizada para criar quantos funcionários forem necessários.

```txt
Funcionario
  |
  |-- funcionario1
  |     nome  = "João"
  |     cargo = "Desenvolvedor"
  |     idade = 30
  |
  `-- funcionario2
        nome  = "Maria"
        cargo = "Gerente"
        idade = 50
```

Essa reutilização é uma das grandes forças da orientação a objetos.

## Métodos

Métodos representam comportamentos.

Em vez de deixar todo o código solto dentro do `main`, podemos ensinar a classe a fazer algo.

```java
public class Funcionario {
    String nome;
    String cargo;
    int idade;

    void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Cargo: " + cargo);
        System.out.println("Idade: " + idade);
    }

    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario();
        funcionario.nome = "João";
        funcionario.cargo = "Desenvolvedor";
        funcionario.idade = 30;

        funcionario.exibirDados();
    }
}
```

Agora o objeto `funcionario` tem um comportamento chamado `exibirDados`.

## Construtor

Um **construtor** é um bloco especial usado para inicializar um objeto.

Ele é chamado quando usamos `new`.

```java
Funcionario funcionario = new Funcionario();
```

O construtor tem o mesmo nome da classe.

```java
public class Funcionario {
    String nome;
    String cargo;
    int idade;

    Funcionario(String nomeInit, String cargoInit, int idadeInit) {
        nome = nomeInit;
        cargo = cargoInit;
        idade = idadeInit;
    }
}
```

Agora podemos criar um funcionário já preenchido:

```java
Funcionario funcionario = new Funcionario("João", "Desenvolvedor", 30);
```

Exemplo completo:

```java
public class Funcionario {
    String nome;
    String cargo;
    int idade;

    Funcionario(String nomeInit, String cargoInit, int idadeInit) {
        nome = nomeInit;
        cargo = cargoInit;
        idade = idadeInit;
    }

    void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Cargo: " + cargo);
        System.out.println("Idade: " + idade);
    }

    public static void main(String[] args) {
        Funcionario joao = new Funcionario("João", "Desenvolvedor", 30);
        Funcionario maria = new Funcionario("Maria", "Gerente", 50);

        joao.exibirDados();
        maria.exibirDados();
    }
}
```

Perceba como o código ficou mais direto. Em vez de criar o objeto vazio e preencher campo por campo, o construtor já recebe os dados iniciais.

## `this`

É comum encontrar construtores assim:

```java
public class Funcionario {
    String nome;
    String cargo;
    int idade;

    Funcionario(String nome, String cargo, int idade) {
        this.nome = nome;
        this.cargo = cargo;
        this.idade = idade;
    }
}
```

O `this` significa "este objeto".

Quando temos um atributo e um parâmetro com o mesmo nome, o `this` deixa claro que estamos falando do atributo do objeto.

```txt
this.nome = nome;
    |       |
    |       `-- parâmetro recebido no construtor
    |
    `-- atributo do objeto atual
```

As duas abordagens funcionam:

```java
Funcionario(String nomeInit, String cargoInit, int idadeInit) {
    nome = nomeInit;
    cargo = cargoInit;
    idade = idadeInit;
}
```

```java
Funcionario(String nome, String cargo, int idade) {
    this.nome = nome;
    this.cargo = cargo;
    this.idade = idade;
}
```

No mundo profissional, você vai ver bastante a segunda forma.

## Construtor default

Se você não cria nenhum construtor, o compilador Java cria um construtor vazio automaticamente.

```java
public class Funcionario {
    String nome;
    String cargo;
    int idade;
}
```

Por trás, é como se o Java permitisse:

```java
Funcionario funcionario = new Funcionario();
```

Mas atenção: quando você cria um construtor explicitamente, o construtor default deixa de existir.

```java
public class Funcionario {
    String nome;
    String cargo;
    int idade;

    Funcionario(String nome, String cargo, int idade) {
        this.nome = nome;
        this.cargo = cargo;
        this.idade = idade;
    }
}
```

Agora isso funciona:

```java
Funcionario funcionario = new Funcionario("João", "Desenvolvedor", 30);
```

Mas isso não funciona mais:

```java
Funcionario funcionario = new Funcionario(); // erro de compilação
```

Se quiser permitir as duas formas, você precisa declarar os dois construtores:

```java
public class Funcionario {
    String nome;
    String cargo;
    int idade;

    Funcionario() {
    }

    Funcionario(String nome, String cargo, int idade) {
        this.nome = nome;
        this.cargo = cargo;
        this.idade = idade;
    }
}
```

## Sobrecarga de construtores

Sobrecarga acontece quando temos mais de um construtor na mesma classe, mas com listas de parâmetros diferentes.

```java
public class Funcionario {
    String nome;
    String cargo;
    int idade;

    Funcionario() {
    }

    Funcionario(String nome) {
        this.nome = nome;
    }

    Funcionario(String nome, String cargo, int idade) {
        this.nome = nome;
        this.cargo = cargo;
        this.idade = idade;
    }
}
```

Agora existem três formas de criar `Funcionario`:

```java
Funcionario funcionario1 = new Funcionario();
Funcionario funcionario2 = new Funcionario("Maria");
Funcionario funcionario3 = new Funcionario("João", "Desenvolvedor", 30);
```

O Java escolhe qual construtor chamar de acordo com:

- quantidade de parâmetros;
- tipo dos parâmetros;
- ordem dos parâmetros.

Exemplo com ordem diferente:

```java
public class Funcionario {
    String nome;
    String cargo;
    int idade;

    Funcionario(String nome, String cargo, int idade) {
        this.nome = nome;
        this.cargo = cargo;
        this.idade = idade;
    }

    Funcionario(int idade, String cargo, String nome) {
        this.nome = nome;
        this.cargo = cargo;
        this.idade = idade;
    }
}
```

Uso:

```java
Funcionario funcionario1 = new Funcionario("Maria", "Gerente", 50);
Funcionario funcionario2 = new Funcionario(50, "Gerente", "Maria");
```

Funciona, mas é preciso cuidado. Construtores demais podem deixar a classe confusa.

## Pacotes

Pacotes em Java são como pastas.

Eles ajudam a organizar classes dentro de um projeto.

```txt
empresa/
`-- dados/
    `-- Funcionario.java
```

Se a classe está dentro da pasta `empresa/dados`, o arquivo Java deve começar com:

```java
package empresa.dados;
```

Exemplo:

```java
package empresa.dados;

public class Funcionario {
    String nome;
    double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Salário: " + salario);
    }
}
```

O pacote precisa combinar com a estrutura de pastas:

```txt
curso/
`-- empresa/
    `-- dados/
        |-- Funcionario.java
        `-- Funcionario.class
```

## Import

Se outra classe quiser usar `Funcionario`, ela precisa importar a classe.

```java
import empresa.dados.Funcionario;

public class FolhaDePagamento {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario("Maria", 6200.00);

        funcionario.exibirDados();
    }
}
```

O `import` diz ao compilador onde encontrar a classe.

```txt
import empresa.dados.Funcionario;
       |       |     |
       |       |     `-- classe
       |       `-- subpacote
       `-- pacote
```

Também existe o import com asterisco:

```java
import empresa.dados.*;
```

Isso importa as classes diretamente dentro do pacote `empresa.dados`.

Mesmo assim, em código profissional, é muito comum preferir imports explícitos:

```java
import empresa.dados.Funcionario;
```

Assim fica mais claro de onde cada classe veio.

## Por que pacotes importam?

Pacotes ajudam em quatro pontos principais:

- organização;
- prevenção de conflito de nomes;
- reutilização de código;
- controle de acesso.

Imagine duas classes chamadas `Funcionario`.

Uma pode estar em:

```txt
empresa.dados.Funcionario
```

Outra pode estar em:

```txt
empresa.relatorio.Funcionario
```

O nome simples é o mesmo, mas o nome completo é diferente.

Esse nome completo é chamado de **nome qualificado**.

## `java.lang`

O pacote `java.lang` é importado automaticamente em todo programa Java.

Por isso conseguimos usar classes como:

- `String`;
- `System`;
- `Math`;
- `Object`.

Sem escrever:

```java
import java.lang.String;
import java.lang.System;
```

Isso já vem disponível por padrão.

Exemplo:

```java
public class Exemplo {
    public static void main(String[] args) {
        String nome = "Maria";

        System.out.println(nome);
        System.out.println(Math.max(10, 20));
    }
}
```

`String`, `System` e `Math` estão em `java.lang`, então não precisam de import manual.

## Compilar e executar com pacotes

Em projetos reais, ferramentas como Maven, Gradle e IDEs cuidam disso.

Mas no terminal puro, o pacote precisa bater com a pasta.

Estrutura:

```txt
curso/
|-- FolhaDePagamento.java
`-- empresa/
    `-- dados/
        `-- Funcionario.java
```

Compilação:

```bash
javac FolhaDePagamento.java
```

Execução:

```bash
java FolhaDePagamento
```

Se a classe com `main` também estiver dentro de um pacote, você executa pelo nome completo:

```bash
java empresa.app.FolhaDePagamento
```

## Modificadores de acesso

Modificadores de acesso definem **quem pode acessar** uma classe, atributo, construtor ou método.

Em Java, os principais são:

| Modificador | Acesso |
|---|---|
| `public` | qualquer lugar |
| `private` | somente dentro da própria classe |
| `protected` | mesma classe, mesmo pacote e subclasses |
| default | mesma classe e mesmo pacote |

O acesso **default** acontece quando não escrevemos nenhum modificador.

```java
class Funcionario {
}
```

Nesse caso, a classe não é `public`, nem `private`, nem `protected`. Ela tem acesso de pacote.

## `public`

Quando algo é `public`, pode ser acessado de qualquer lugar.

```java
package empresa.dados;

public class Funcionario {
    public String nome;

    public Funcionario(String nome) {
        this.nome = nome;
    }
}
```

Outra classe, em outro pacote, consegue usar:

```java
import empresa.dados.Funcionario;

public class FolhaDePagamento {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario("Maria");

        System.out.println(funcionario.nome);
    }
}
```

O `public` abre a porta.

```txt
Outro pacote -> consegue acessar algo public
```

Mas isso não significa que tudo deve ser `public`. Se tudo fica público, qualquer parte do sistema pode mexer em qualquer dado, e o código perde controle.

## `private`

Quando algo é `private`, só pode ser acessado dentro da própria classe.

```java
public class Funcionario {
    private String nome;

    public Funcionario(String nome) {
        this.nome = nome;
    }
}
```

Isso não funciona fora da classe `Funcionario`:

```java
Funcionario funcionario = new Funcionario("Maria");

System.out.println(funcionario.nome); // erro: nome é private
```

Mas funciona dentro da própria classe:

```java
public class Funcionario {
    private String nome;

    public Funcionario(String nome) {
        this.nome = nome;
    }

    public void exibirNome() {
        System.out.println(nome); // ok, está dentro da mesma classe
    }
}
```

O `private` é a base do encapsulamento.

```txt
Fora da classe -> não acessa
Dentro da classe -> acessa
```

## Encapsulamento

Encapsular é proteger o estado interno do objeto.

Em vez de deixar qualquer classe alterar diretamente os atributos:

```java
public class Funcionario {
    public String nome;
    public double salario;
}
```

Preferimos esconder os atributos:

```java
public class Funcionario {
    private String nome;
    private double salario;
}
```

E expor métodos controlados:

```java
public class Funcionario {
    private String nome;
    private double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public String obterInfo() {
        return "Nome: " + nome + ", salário: " + salario;
    }
}
```

Uso:

```java
Funcionario funcionario = new Funcionario("Arnaldo", 5000.00);

System.out.println(funcionario.obterInfo());
```

Aqui a classe `Funcionario` decide como seus dados serão exibidos. Quem está de fora não precisa saber como os atributos estão guardados.

## Getters e setters

Getters e setters são métodos usados para obter ou alterar valores de atributos privados.

```txt
getter -> pega o valor
setter -> define ou altera o valor
```

Exemplo:

```java
class Aluno {
    private String nome;

    public void setNome(String novoNome) {
        nome = novoNome;
    }

    public String getNome() {
        return nome;
    }
}
```

Uso:

```java
class Secretaria {
    public static void main(String[] args) {
        Aluno aluno = new Aluno();

        aluno.setNome("Maria");

        System.out.println("Nome do aluno: " + aluno.getNome());
    }
}
```

O padrão de nomes é:

```txt
getNome()
setNome(String nome)
getSalario()
setSalario(double salario)
```

Para booleanos, é comum ver:

```java
public boolean isAtivo() {
    return ativo;
}
```

Getters e setters não são obrigatórios para tudo. Eles são úteis quando você quer permitir acesso controlado.

## `protected`

Quando algo é `protected`, pode ser acessado:

- dentro da própria classe;
- por classes do mesmo pacote;
- por subclasses, mesmo em outro pacote.

Subclasse é um assunto de herança, então por enquanto o ponto principal é: `protected` é mais aberto que `private`, mas menos aberto que `public`.

```java
package empresa.dados;

public class Funcionario {
    protected Funcionario() {
        System.out.println("Construtor protected");
    }
}
```

Uma classe no mesmo pacote consegue chamar:

```java
package empresa.dados;

public class TestePacote {
    public TestePacote() {
        Funcionario funcionario = new Funcionario();
    }
}
```

Mas uma classe fora do pacote, que não seja subclasse, não consegue chamar esse construtor diretamente.

```txt
Mesmo pacote -> acessa protected
Outro pacote sem herança -> não acessa
```

## Acesso default

Quando não colocamos modificador, o acesso é default.

```java
class Funcionario {
    Funcionario() {
    }
}
```

O acesso default permite acesso dentro:

- da própria classe;
- de outras classes no mesmo pacote.

Não permite acesso direto de classes em outro pacote.

```txt
Mesmo pacote -> acessa
Outro pacote -> não acessa
```

## Modificadores em classes

Uma classe de topo pode ser:

```java
public class Funcionario {
}
```

Ou default:

```java
class Funcionario {
}
```

Mas uma classe de topo não pode ser `private` ou `protected`.

```java
private class Funcionario {
} // erro
```

```java
protected class Funcionario {
} // erro
```

`private` e `protected` podem aparecer em atributos, construtores e métodos. Em classes de topo, não.

## Métodos

Métodos são blocos de código que realizam tarefas específicas.

Eles ajudam em dois pontos:

- reutilização de código;
- organização do programa.

Formato básico:

```java
public String obterInfo() {
    return "Alguma informação";
}
```

Essa declaração tem partes importantes:

```txt
public     -> modificador de acesso
String     -> tipo de retorno
obterInfo -> nome do método
()         -> lista de parâmetros
return     -> valor devolvido pelo método
```

Um método com retorno precisa devolver um valor compatível.

```java
public String obterInfo() {
    return "Nome: Maria";
}
```

Um método `void` não retorna nada.

```java
public void exibirInfo() {
    System.out.println("Nome: Maria");
}
```

## Melhorando `Funcionario` com método

Antes, o construtor estava fazendo coisas demais, inclusive imprimindo dados.

Melhor:

```java
public class Funcionario {
    private String nome;
    private double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public String obterInfo() {
        return "Nome: " + nome + ", salário: " + salario;
    }
}
```

Uso:

```java
public class FolhaDePagamento {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario("Arnaldo", 5000.00);

        System.out.println(funcionario.obterInfo());
    }
}
```

Agora cada parte tem uma responsabilidade:

```txt
Construtor  -> inicializa o objeto
obterInfo() -> monta uma descrição do funcionário
main        -> executa o programa
```

## Métodos com parâmetros

Um método pode receber informações.

```java
public void aumentarSalario(double aumento) {
    salario += aumento;
}
```

Uso:

```java
Funcionario funcionario = new Funcionario("Arnaldo", 5000.00);

funcionario.aumentarSalario(3000.00);

System.out.println(funcionario.obterInfo());
```

O salário passa de `5000.00` para `8000.00`.

## Passagem de primitivos para métodos

Em Java, parâmetros são passados por valor.

Com primitivos, isso significa que o método recebe uma cópia do valor.

```java
public class Exemplo {
    public static void alterarNumero(int numero) {
        numero = 99;
    }

    public static void main(String[] args) {
        int idade = 30;

        alterarNumero(idade);

        System.out.println(idade); // 30
    }
}
```

O método alterou a cópia, não a variável original.

```txt
idade = 30
  |
  `-- cópia enviada para o método

numero = 99

idade continua 30
```

## Passagem de objetos para métodos

Aqui mora uma pegadinha importante.

Em Java, objetos também são passados por valor. O que é copiado é a **referência** para o objeto.

Então o método recebe uma cópia da referência, mas essa cópia aponta para o mesmo objeto.

```java
public class Funcionario {
    public double salario;

    public Funcionario(double salario) {
        this.salario = salario;
    }
}
```

```java
public class FolhaDePagamento {
    public static void alterarSalario(Funcionario funcionario, double novoSalario) {
        funcionario.salario = novoSalario;
    }

    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario(5000.00);

        alterarSalario(funcionario, 9000.00);

        System.out.println(funcionario.salario); // 9000.0
    }
}
```

Visualmente:

```txt
funcionario no main
        |
        v
   Objeto Funcionario
   salario = 5000

cópia da referência no método
        |
        v
   mesmo Objeto Funcionario
   salario = 9000
```

Por isso o objeto é alterado.

Mas a referência em si continua sendo passada por valor. Se o método tentar trocar a referência por outro objeto, isso não troca a variável original do `main`.

```java
public static void trocar(Funcionario funcionario) {
    funcionario = new Funcionario(1000.00);
}
```

Essa troca só altera a cópia local da referência.

Resumo mais correto:

```txt
Primitivo -> passa cópia do valor
Objeto    -> passa cópia da referência
```

## Sobrecarga de métodos

Sobrecarga de métodos acontece quando temos dois ou mais métodos com o mesmo nome, mas listas de parâmetros diferentes.

```java
public class Funcionario {
    private double salario;

    public Funcionario(double salario) {
        this.salario = salario;
    }

    public void aumentarSalario(double aumento) {
        salario += aumento;
    }

    public void aumentarSalario(int porcentagem) {
        double aumento = salario * porcentagem / 100;
        salario += aumento;
    }

    public String obterInfo() {
        return "Salário: " + salario;
    }
}
```

Uso:

```java
Funcionario funcionario = new Funcionario(5000.00);

funcionario.aumentarSalario(1000.50); // chama o método com double
funcionario.aumentarSalario(10);      // chama o método com int
```

O Java escolhe o método pela lista de parâmetros:

- quantidade;
- tipo;
- ordem.

O tipo de retorno não define sobrecarga.

Isso não é uma sobrecarga válida:

```java
public int calcular() {
    return 1;
}

public double calcular() {
    return 1.0;
}
```

Os parâmetros são iguais. Só o retorno mudou. O Java não aceita.

Também não basta mudar apenas o modificador de acesso:

```java
public void processar() {
}

private void processar() {
}
```

Isso também não conta como sobrecarga.

## Métodos estáticos

Métodos estáticos pertencem à classe, não a um objeto específico.

Eles usam a palavra-chave `static`.

```java
public class TesteStatic {
    public static void exibirValor(int valor) {
        System.out.println("Valor inteiro: " + valor);
    }

    public static void main(String[] args) {
        TesteStatic.exibirValor(10);
    }
}
```

Não precisamos criar objeto:

```java
TesteStatic.exibirValor(10);
```

Também é possível chamar diretamente de outro método estático da mesma classe:

```java
public class TesteStatic {
    public static void exibirValor(int valor) {
        System.out.println(valor);
    }

    public static void main(String[] args) {
        exibirValor(10);
    }
}
```

Mas se o método não for `static`, ele pertence ao objeto.

```java
public class TesteStatic {
    public void exibirValor(int valor) {
        System.out.println(valor);
    }

    public static void main(String[] args) {
        TesteStatic teste = new TesteStatic();

        teste.exibirValor(10);
    }
}
```

Um método estático não consegue acessar diretamente atributos de instância, porque ele não está ligado a um objeto específico.

```java
public class Exemplo {
    private String nome = "Maria";

    public static void imprimir() {
        System.out.println(nome); // erro
    }
}
```

Para acessar `nome`, seria necessário ter um objeto.

## Sobrecarga de métodos estáticos

Métodos estáticos também podem ser sobrecarregados.

```java
public class TesteStatic {
    public static void exibirValor(int valor) {
        System.out.println("Valor inteiro: " + valor);
    }

    public static void exibirValor(String valor) {
        System.out.println("Valor texto: " + valor);
    }

    public static void main(String[] args) {
        exibirValor(10);
        exibirValor("Olá");
    }
}
```

As regras são as mesmas da sobrecarga comum: o nome é igual, mas os parâmetros precisam ser diferentes.

## Membros estáticos

Além de métodos, atributos também podem ser `static`.

Um membro estático pertence à classe, não a cada objeto.

```java
class Contador {
    static int total = 0;

    Contador() {
        total++;
    }
}
```

Exemplo completo:

```java
class Contador {
    static int total = 0;

    Contador() {
        total++;
    }
}

public class TesteContador {
    public static void main(String[] args) {
        Contador c1 = new Contador();
        Contador c2 = new Contador();
        Contador c3 = new Contador();

        System.out.println("Objetos criados: " + Contador.total);
    }
}
```

Saída:

```txt
Objetos criados: 3
```

Todos os objetos compartilham o mesmo `total`.

```txt
Contador.total = 3

c1 -> usa o mesmo total
c2 -> usa o mesmo total
c3 -> usa o mesmo total
```

Isso é diferente de um atributo comum:

```java
class Pessoa {
    String nome;
}
```

Cada `Pessoa` tem seu próprio `nome`.

## Quando usar `static`

Use `static` quando o comportamento ou dado pertence à classe, não a um objeto específico.

Bons exemplos:

```java
Math.max(10, 20);
Integer.parseInt("123");
Double.valueOf("10.5");
```

Nesses casos, não faz sentido criar um objeto só para chamar a operação.

Mas cuidado: usar tudo como `static` costuma ser ruim.

Problemas comuns:

- mistura estado global no sistema;
- dificulta testes;
- enfraquece a orientação a objetos;
- mantém dados na memória enquanto a classe estiver carregada;
- faz vários lugares dependerem da mesma variável compartilhada.

Exemplo ruim:

```java
class Pessoa {
    static String nome;
}
```

Se `nome` é `static`, todas as pessoas compartilham o mesmo nome. Isso quebra a ideia de cada objeto ter seu próprio estado.

Melhor:

```java
class Pessoa {
    String nome;
}
```

## Palavra-chave `final`

`final` é uma palavra-chave usada para indicar que algo não pode mais ser alterado em determinado sentido.

Ela pode ser aplicada em:

- variáveis;
- métodos;
- classes.

O efeito muda conforme o lugar onde ela é usada.

```txt
final em variável -> não pode receber outro valor
final em método   -> não pode ser sobrescrito
final em classe   -> não pode ser herdada
```

## Variáveis `final`

Uma variável marcada como `final` só pode receber valor uma vez.

```java
class ExemploFinal {
    final int CODIGO_FIXO = 10;

    public void metodoFinal() {
        System.out.println("Este é o método final");
    }
}
```

Uso:

```java
public class TesteFinal {
    public static void main(String[] args) {
        ExemploFinal testeFinal = new ExemploFinal();

        System.out.println("Valor da constante: " + testeFinal.CODIGO_FIXO);
    }
}
```

Isso funciona.

Mas tentar alterar o valor não funciona:

```java
testeFinal.CODIGO_FIXO = 555; // erro de compilação
```

O compilador entende:

```txt
Essa variável foi marcada como final.
Ela não pode receber outro valor.
```

Também podemos usar `final` em variável local:

```java
public class TesteFinal {
    public static void main(String[] args) {
        final int valorLocal = 777;

        System.out.println(valorLocal);

        valorLocal = 333; // erro de compilação
    }
}
```

Uma vez atribuído, o valor não muda mais.

## Constantes em Java

Quando uma constante pertence à classe, é comum combinar:

```java
public static final int CODIGO_FIXO = 10;
```

Isso significa:

```txt
public -> pode ser acessada de fora
static -> pertence à classe
final  -> não pode ser alterada
```

Convenção importante: constantes costumam usar letras maiúsculas com `_`.

```java
public static final double TAXA_PADRAO = 0.10;
public static final int IDADE_MINIMA = 18;
```

## `final` em métodos

Um método `final` não pode ser sobrescrito por subclasses.

```java
class ExemploFinal {
    public final void meuMetodo() {
        System.out.println("Este é o método final");
    }
}
```

Se uma classe tentar sobrescrever:

```java
class TesteFinal extends ExemploFinal {
    @Override
    public void meuMetodo() {
        System.out.println("Método sobrescrito");
    }
}
```

O código não compila.

Por quê?

Porque `meuMetodo` foi marcado como `final` na classe pai.

```txt
Método final -> mantém o comportamento original
Subclasse    -> não pode trocar esse comportamento
```

Isso é útil quando uma regra precisa permanecer intacta em todas as subclasses.

## `final` em classes

Uma classe `final` não pode ser herdada.

```java
final class MinhaClasseFinal {
}
```

Isso não funciona:

```java
class MinhaSubclasse extends MinhaClasseFinal {
}
```

O compilador impede porque a classe final não pode ser estendida.

```txt
Classe final -> ninguém herda dela
```

Isso ajuda quando você quer garantir que uma classe seja usada como está, sem subclasses alterando seu comportamento.

Exemplo conhecido:

```java
String texto = "Java";
```

`String` é uma classe final. Você usa `String`, mas não cria uma subclasse de `String`.

## Quando usar `final`

Use `final` quando quiser comunicar uma intenção de estabilidade.

Exemplos:

- um valor que não deve mudar;
- uma regra que subclasses não devem sobrescrever;
- uma classe que não deve ser herdada.

Mas cuidado para não usar `final` em tudo sem pensar.

Se você trava tudo cedo demais, o código pode ficar menos flexível do que precisa.

## Arrays

Um array em Java é uma estrutura que guarda vários elementos do mesmo tipo dentro de uma única variável.

Imagine uma cômoda com gavetas numeradas:

```txt
meuArray
  |
  |-- gaveta 0 -> 5
  |-- gaveta 1 -> 8
  `-- gaveta 2 -> 2
```

Cada gaveta tem um número, chamado **índice**.

Em Java, o primeiro índice é sempre `0`.

```txt
Primeiro elemento -> índice 0
Segundo elemento  -> índice 1
Terceiro elemento -> índice 2
Último elemento   -> tamanho do array - 1
```

Se um array tem 3 posições, os índices válidos são:

```txt
0, 1, 2
```

Não existe índice `3` nesse array.

## Declarando arrays

Para declarar um array, colocamos colchetes no tipo ou no nome da variável.

Forma mais comum:

```java
int[] meuArray;
```

Também funciona:

```java
int meuArray[];
```

As duas formas compilam, mas a primeira costuma ser mais usada porque deixa claro que o tipo é `int[]`.

```txt
int   -> um número inteiro
int[] -> um array de números inteiros
```

## Criando um array

Declarar a variável não cria o array.

```java
int[] meuArray;
```

Para criar o array, usamos `new`:

```java
meuArray = new int[3];
```

Essa linha cria um array de `int` com 3 posições.

```txt
new int[3]
  |
  `-- cria 3 espaços para guardar valores inteiros
```

Como `int` tem valor padrão `0`, o array começa assim:

```txt
índice 0 -> 0
índice 1 -> 0
índice 2 -> 0
```

## Preenchendo posições do array

Para colocar valores no array, usamos o índice.

```java
int[] meuArray;

meuArray = new int[3];

meuArray[0] = 5;
meuArray[1] = 8;
meuArray[2] = 2;
```

Visualmente:

```txt
meuArray[0] = 5
meuArray[1] = 8
meuArray[2] = 2

Array final:

0 -> 5
1 -> 8
2 -> 2
```

## Criando e preenchendo na mesma linha

Também podemos criar e preencher o array de uma vez:

```java
int[] meuArray = new int[] { 5, 8, 2 };
```

Ou, em uma declaração direta, de forma ainda mais curta:

```java
int[] meuArray = { 5, 8, 2 };
```

Essas formas já criam um array com 3 elementos.

O tamanho é definido pela quantidade de valores entre `{ }`.

## Exemplo completo

```java
public class Arrays {
    public static void main(String[] args) {
        int[] meuArray;

        meuArray = new int[3];

        meuArray[0] = 5;
        meuArray[1] = 8;
        meuArray[2] = 2;

        System.out.println(meuArray[0]); // 5
        System.out.println(meuArray[1]); // 8
        System.out.println(meuArray[2]); // 2

        meuArray[0] = 10;

        System.out.println("Valor alterado: " + meuArray[0]); // 10
    }
}
```

O valor da posição `0` começou como `5`, mas depois foi alterado para `10`.

```txt
Antes:
0 -> 5
1 -> 8
2 -> 2

Depois:
0 -> 10
1 -> 8
2 -> 2
```

## Percorrendo array com `for`

Percorrer um array significa passar por seus elementos.

O `for` tradicional é útil quando precisamos do índice.

```java
int[] meuArray = { 10, 8, 2 };

for (int i = 0; i < meuArray.length; i++) {
    System.out.println(meuArray[i]);
}
```

`length` informa o tamanho do array.

```txt
meuArray.length -> 3
```

O loop funciona assim:

```txt
i = 0 -> imprime meuArray[0] -> 10
i = 1 -> imprime meuArray[1] -> 8
i = 2 -> imprime meuArray[2] -> 2
i = 3 -> para, porque 3 não é menor que meuArray.length
```

Por isso a condição é:

```java
i < meuArray.length
```

E não:

```java
i <= meuArray.length
```

Se usar `<=`, o Java tentará acessar uma posição que não existe.

## Índice fora do array

Se o array tem 3 posições, o último índice é `2`.

```java
int[] numeros = { 10, 8, 2 };

System.out.println(numeros[3]); // erro em tempo de execução
```

Isso gera:

```txt
ArrayIndexOutOfBoundsException
```

Ou seja: o programa tentou acessar uma gaveta que não existe.

## Percorrendo array com `for-each`

O `for-each` permite percorrer todos os elementos sem controlar índice manualmente.

```java
int[] meuArray = { 10, 8, 2 };

for (int elemento : meuArray) {
    System.out.println(elemento);
}
```

Leia assim:

```txt
para cada int elemento dentro de meuArray
    imprima elemento
```

Visualmente:

```txt
elemento = 10
elemento = 8
elemento = 2
```

## `for` tradicional vs `for-each`

Use `for` tradicional quando precisar do índice.

```java
for (int i = 0; i < meuArray.length; i++) {
    System.out.println("Índice " + i + ": " + meuArray[i]);
}
```

Use `for-each` quando quiser apenas percorrer os valores.

```java
for (int elemento : meuArray) {
    System.out.println(elemento);
}
```

Comparação:

| Situação | Melhor opção |
|---|---|
| Preciso saber o índice | `for` tradicional |
| Só quero ler os valores | `for-each` |
| Quero alterar posição específica | `for` tradicional |
| Quero código mais simples para leitura | `for-each` |

## Array no método `main`

Agora dá para entender melhor essa parte:

```java
public static void main(String[] args) {
}
```

`String[] args` é um array de `String`.

Ele pode receber argumentos passados pelo terminal quando o programa é executado.

```bash
java MeuPrograma Paulo Java
```

Nesse caso:

```txt
args[0] -> "Paulo"
args[1] -> "Java"
```

Exemplo:

```java
public class MeuPrograma {
    public static void main(String[] args) {
        for (String argumento : args) {
            System.out.println(argumento);
        }
    }
}
```

## Arrays e Collections

Arrays são muito importantes e aparecem bastante em Java.

Mas em aplicações modernas, muitas vezes usamos Collections, como `ArrayList`, `List`, `Set` e `Map`.

A diferença inicial é:

```txt
Array      -> tamanho fixo
Collection -> estrutura mais flexível
```

Exemplo:

```java
int[] numeros = new int[3]; // tamanho fixo
```

Depois que esse array foi criado com 3 posições, ele não vira automaticamente um array de 4, 5 ou 10 posições.

Collections entram justamente para resolver muitos cenários mais flexíveis. Esse é um dos próximos assuntos da trilha.

## Herança

Herança é um dos principais conceitos da orientação a objetos.

Ela permite criar uma nova classe a partir de uma classe existente, reaproveitando código e especializando comportamentos.

Em termos simples:

```txt
Superclasse -> classe mais geral
Subclasse   -> classe mais específica
```

Também é comum ouvir:

```txt
Classe pai  -> superclasse
Classe filha -> subclasse
```

A palavra-chave usada em Java é `extends`.

```java
class Cachorro extends Animal {
}
```

Isso significa:

```txt
Cachorro herda de Animal
Cachorro é uma subclasse de Animal
Animal é a superclasse de Cachorro
```

## A regra do "é um"

Herança deve fazer sentido conceitual.

Uma boa pergunta é:

```txt
A subclasse é um tipo da superclasse?
```

Se a resposta for sim, a herança pode fazer sentido.

Exemplos:

```txt
Funcionário é uma Pessoa? Sim.
Terceiro é uma Pessoa? Sim.
Cachorro é um Animal? Sim.
Gato é um Animal? Sim.
```

Então esses casos combinam com herança:

```txt
Pessoa
  |
  |-- Funcionario
  `-- Terceiro
```

```txt
Animal
  |
  |-- Cachorro
  `-- Gato
```

Agora cuidado:

```txt
Carro é um Motor? Não.
Pedido é um Cliente? Não.
NotaFiscal é um Produto? Não.
```

Nesses casos, herança provavelmente está errada. Pode ser composição, associação ou outro tipo de relacionamento.

## Exemplo básico com `extends`

```java
class Animal {
    public void comer() {
        System.out.println("O animal come");
    }
}

class Cachorro extends Animal {
    public void latir() {
        System.out.println("O cachorro late");
    }
}

public class TesteHeranca {
    public static void main(String[] args) {
        Cachorro dog = new Cachorro();

        dog.latir();
        dog.comer();
    }
}
```

Saída:

```txt
O cachorro late
O animal come
```

A classe `Cachorro` tem o método `latir`.

Mas ela também consegue usar `comer`, porque herdou esse método de `Animal`.

Visualmente:

```txt
Animal
  |
  |-- comer()
  |
  `-- Cachorro
        |
        |-- latir()
        `-- também enxerga comer()
```

Quando o Java encontra:

```java
dog.comer();
```

Ele procura primeiro em `Cachorro`. Se não encontrar, sobe para `Animal`.

## Sobrescrita de métodos

Sobrescrita acontece quando a subclasse fornece sua própria versão de um método que já existe na superclasse.

```java
class Animal {
    public void fazerSom() {
        System.out.println("O animal faz um som");
    }
}

class Cachorro extends Animal {
    public void fazerSom() {
        System.out.println("O cachorro late");
    }
}

public class TesteHeranca {
    public static void main(String[] args) {
        Cachorro dog = new Cachorro();

        dog.fazerSom();
    }
}
```

Saída:

```txt
O cachorro late
```

O método da subclasse foi chamado.

```txt
Animal.fazerSom()   -> versão geral
Cachorro.fazerSom() -> versão específica
```

Isso é chamado de **override**.

## Regras da sobrescrita

Para sobrescrever um método, a subclasse precisa manter a mesma assinatura.

Assinatura envolve:

- nome do método;
- lista de parâmetros;
- ordem dos parâmetros;
- tipos dos parâmetros.

Exemplo de sobrescrita:

```java
class Animal {
    public void fazerSom(String intensidade, int vezes) {
        System.out.println("O animal faz um som");
    }
}

class Cachorro extends Animal {
    public void fazerSom(String intensidade, int vezes) {
        System.out.println("O cachorro late");
    }
}
```

Aqui sobrescreveu.

Agora este exemplo não sobrescreve:

```java
class Animal {
    public void fazerSom(int vezes, String intensidade) {
        System.out.println("O animal faz um som");
    }
}

class Cachorro extends Animal {
    public void fazerSom(String intensidade, int vezes) {
        System.out.println("O cachorro late");
    }
}
```

Os parâmetros têm os mesmos tipos, mas em ordem diferente.

Isso vira outro método. É mais parecido com sobrecarga.

## `@Override`

Em código profissional, usamos a anotação `@Override` para deixar claro que queremos sobrescrever um método.

```java
class Animal {
    public void fazerSom() {
        System.out.println("O animal faz um som");
    }
}

class Cachorro extends Animal {
    @Override
    public void fazerSom() {
        System.out.println("O cachorro late");
    }
}
```

Se você errar o nome, retorno ou parâmetros, o compilador avisa.

Isso evita bugs silenciosos.

## Modificador de acesso na sobrescrita

Na sobrescrita, a subclasse não pode tornar o método mais restritivo.

Se na superclasse o método é `public`, na subclasse ele também precisa continuar acessível como `public`.

Isso não pode:

```java
class Animal {
    public void fazerSom() {
        System.out.println("O animal faz um som");
    }
}

class Cachorro extends Animal {
    private void fazerSom() {
        System.out.println("O cachorro late");
    }
}
```

Por quê?

Porque quem espera usar um `Animal` público não pode receber um `Cachorro` que "fecha" aquele comportamento.

Regra mental:

```txt
Subclasse pode manter ou abrir acesso.
Subclasse não pode fechar acesso herdado.
```

## Palavra-chave `super`

`super` é uma referência à superclasse imediata.

Se `Cachorro extends Animal`, então dentro de `Cachorro`:

```txt
super -> Animal
```

Podemos usar `super` para chamar métodos da superclasse.

```java
class Animal {
    public String nome;

    public void fazerSom() {
        System.out.println("O animal faz um som");
    }
}

class Cachorro extends Animal {
    @Override
    public void fazerSom() {
        super.fazerSom();

        System.out.println("O cachorro late");
    }
}

public class TesteHeranca {
    public static void main(String[] args) {
        Cachorro dog = new Cachorro();

        dog.nome = "Rex";

        System.out.println("Nome do animal: " + dog.nome);
        dog.fazerSom();
    }
}
```

Saída:

```txt
Nome do animal: Rex
O animal faz um som
O cachorro late
```

Aqui aconteceu:

```txt
dog.fazerSom()
  |
  `-- entra em Cachorro.fazerSom()
        |
        |-- super.fazerSom() -> chama Animal.fazerSom()
        |
        `-- imprime "O cachorro late"
```

O `super` é útil quando você quer complementar o comportamento herdado, não substituir totalmente.

## `super` em construtores

`super` também pode chamar o construtor da superclasse.

```java
class Animal {
    String nome;

    Animal(String nome) {
        this.nome = nome;
    }
}

class Cachorro extends Animal {
    String raca;

    Cachorro(String nome, String raca) {
        super(nome);

        this.raca = raca;
    }
}

public class TesteSuper {
    public static void main(String[] args) {
        Cachorro dog = new Cachorro("Rex", "Labrador");

        System.out.println("Nome do animal: " + dog.nome);
        System.out.println("Raça do cachorro: " + dog.raca);
    }
}
```

Saída:

```txt
Nome do animal: Rex
Raça do cachorro: Labrador
```

O fluxo é:

```txt
new Cachorro("Rex", "Labrador")
  |
  `-- chama Cachorro(String nome, String raca)
        |
        |-- super(nome) -> chama Animal(String nome)
        |       |
        |       `-- inicializa Animal.nome
        |
        `-- this.raca = raca
```

Regra importante: quando usado, `super(...)` precisa ser a primeira linha do construtor.

```java
Cachorro(String nome, String raca) {
    super(nome); // primeira linha

    this.raca = raca;
}
```

## `this` vs `super`

Os dois ajudam a deixar claro de onde vem cada coisa.

```txt
this  -> este objeto, esta classe
super -> superclasse imediata
```

Exemplo:

```java
class Animal {
    String nome;

    Animal(String nome) {
        this.nome = nome;
    }
}

class Cachorro extends Animal {
    String raca;

    Cachorro(String nome, String raca) {
        super(nome);
        this.raca = raca;
    }
}
```

`super(nome)` entrega o nome para a classe `Animal`.

`this.raca = raca` inicializa a raça na própria classe `Cachorro`.

## Herança e reutilização

Herança permite reaproveitar código, mas precisa ser usada com critério.

Ela é boa quando a relação "é um" é verdadeira.

```txt
Cachorro é um Animal.
Funcionário é uma Pessoa.
Gerente é um Funcionário.
```

Mas não deve ser usada só para "pegar código pronto".

Se a relação conceitual estiver errada, o código pode ficar confuso.

Exemplo perigoso:

```txt
Relatorio extends Arquivo
```

Talvez um relatório não seja um arquivo. Talvez ele gere um arquivo, tenha um arquivo ou exporte um arquivo.

Nesses casos, composição pode fazer mais sentido. Esse assunto entra mais à frente.

## Interfaces

Interface é uma especificação feita em código.

Ela define um contrato: quais métodos uma classe precisa implementar.

Pense em uma interface como um cardápio de restaurante.

```txt
Cardápio  -> lista os pratos disponíveis
Chef      -> prepara os pratos
Interface -> lista os métodos obrigatórios
Classe    -> implementa esses métodos
```

O cardápio não explica como o prato será preparado. Ele apenas diz que aquele prato existe.

Da mesma forma, a interface diz quais métodos devem existir, mas quem escreve o corpo desses métodos é a classe que implementa a interface.

## Interface como contrato

Exemplo mental com um carro:

```txt
Interface Carro
  |
  |-- ligarMotor()
  |-- acelerar()
  |-- frear()
  `-- trocarMarcha()
```

Uma equipe de arquitetura pode definir a interface.

Uma equipe de desenvolvimento implementa o código.

Quem implementa a interface é obrigado a cumprir o contrato.

## Criando uma interface

Usamos a palavra-chave `interface`.

```java
interface Animal {
    void fazerSom();
}
```

Esse método termina com `;`.

Ele não tem corpo:

```java
void fazerSom();
```

Isso representa um método abstrato.

```txt
Método abstrato -> método sem implementação
```

Nesse caso, a interface `Animal` está dizendo:

```txt
Toda classe que implementar Animal precisa ter fazerSom().
```

## Implementando uma interface

Para uma classe usar uma interface, usamos `implements`.

```java
class Cachorro implements Animal {
    public void fazerSom() {
        System.out.println("O cachorro faz au au");
    }
}
```

Não usamos `extends` para implementar interface.

```txt
Classe herda classe       -> extends
Classe implementa interface -> implements
Interface estende interface -> extends
```

## Exemplo com `Animal`, `Cachorro` e `Gato`

```java
interface Animal {
    void fazerSom();
}

class Cachorro implements Animal {
    @Override
    public void fazerSom() {
        System.out.println("O cachorro faz au au");
    }
}

class Gato implements Animal {
    @Override
    public void fazerSom() {
        System.out.println("O gato faz miau");
    }
}

public class TesteInterface {
    public static void main(String[] args) {
        Cachorro cachorro = new Cachorro();
        cachorro.fazerSom();

        Gato gato = new Gato();
        gato.fazerSom();
    }
}
```

Saída:

```txt
O cachorro faz au au
O gato faz miau
```

`Cachorro` e `Gato` implementam o mesmo contrato, mas cada um faz do seu jeito.

```txt
Animal.fazerSom()
  |
  |-- Cachorro -> "au au"
  `-- Gato     -> "miau"
```

## Interface não pode ser instanciada

Uma interface não pode ser instanciada diretamente.

Isso não funciona:

```java
Animal animal = new Animal(); // erro de compilação
```

Por quê?

Porque interface é contrato, não implementação concreta.

Você precisa instanciar uma classe que implementa a interface:

```java
Animal animal = new Cachorro();
```

Esse exemplo também abre caminho para polimorfismo, que será aprofundado depois.

## Atributos em interfaces

Toda variável declarada em uma interface é, implicitamente:

```txt
public static final
```

Exemplo:

```java
interface Animal {
    String DESCRICAO = "Animal é um ser vivo importante";
}
```

Por baixo, é como se fosse:

```java
interface Animal {
    public static final String DESCRICAO = "Animal é um ser vivo importante";
}
```

Isso significa:

```txt
public -> pode ser acessada de fora
static -> pertence à interface
final  -> não pode ser alterada
```

Uso:

```java
System.out.println(Animal.DESCRICAO);
```

Não precisa criar objeto.

Aliás, nem poderia criar objeto da interface.

## Métodos em interfaces são públicos e abstratos

Em uma interface, este método:

```java
interface Animal {
    void fazerSom();
}
```

É entendido pelo compilador como:

```java
interface Animal {
    public abstract void fazerSom();
}
```

Ou seja:

```txt
public   -> a implementação precisa ser pública
abstract -> não tem corpo
```

Por isso, ao implementar:

```java
class Cachorro implements Animal {
    public void fazerSom() {
        System.out.println("O cachorro faz au au");
    }
}
```

O método precisa ser `public`.

Isso não funciona:

```java
class Cachorro implements Animal {
    void fazerSom() {
        System.out.println("O cachorro faz au au");
    }
}
```

Sem `public`, o método fica com acesso default, que é mais restritivo que `public`.

Regra mental:

```txt
Método da interface é public.
A implementação não pode ser mais fechada.
```

## Interface estendendo interface

Uma interface pode estender outra interface.

```java
interface SerVivo {
    void respirar();
}

interface Animal extends SerVivo {
    void fazerSom();
}
```

Agora, quem implementa `Animal` precisa implementar:

```txt
respirar()
fazerSom()
```

Porque `Animal` herdou o contrato de `SerVivo`.

Exemplo:

```java
class Cachorro implements Animal {
    @Override
    public void respirar() {
        System.out.println("O cachorro respira");
    }

    @Override
    public void fazerSom() {
        System.out.println("O cachorro faz au au");
    }
}
```

O mesmo vale para `Gato`:

```java
class Gato implements Animal {
    @Override
    public void respirar() {
        System.out.println("O gato respira");
    }

    @Override
    public void fazerSom() {
        System.out.println("O gato faz miau");
    }
}
```

## Classe herda uma classe, mas pode implementar várias interfaces

Java não permite herança múltipla de classes.

```java
class Cachorro extends Animal {
}
```

Uma classe só pode ter uma superclasse direta.

Mas uma classe pode implementar várias interfaces:

```java
class Carro implements Ligavel, Aceleravel, Freavel {
}
```

Isso é uma das razões de interfaces serem tão importantes no design Java.

## Métodos `default` em interfaces

Antes do Java 8, interfaces tinham basicamente métodos abstratos e constantes.

A partir do Java 8, interfaces podem ter métodos `default`.

Um método `default` tem implementação dentro da própria interface.

```java
interface ExemploInterfaceEspecial {
    void metodoAbstrato();

    default void metodoDefault() {
        System.out.println("Este é o método default na interface");
    }
}
```

Quem implementa a interface é obrigado a implementar `metodoAbstrato`.

Mas não é obrigado a implementar `metodoDefault`, porque ele já tem corpo.

```java
class ExemploClasse implements ExemploInterfaceEspecial {
    @Override
    public void metodoAbstrato() {
        System.out.println("Implementação do método abstrato");
    }
}
```

Uso:

```java
public class TesteInterfaceEspecial {
    public static void main(String[] args) {
        ExemploClasse exemplo = new ExemploClasse();

        exemplo.metodoAbstrato();
        exemplo.metodoDefault();
    }
}
```

Saída:

```txt
Implementação do método abstrato
Este é o método default na interface
```

## Para que serve método `default`?

Ele permite adicionar comportamento novo a uma interface sem quebrar todas as classes que já implementam essa interface.

Imagine uma interface antiga:

```java
interface Relatorio {
    void gerar();
}
```

Várias classes implementam `Relatorio`.

Se você adicionar um método abstrato novo:

```java
interface Relatorio {
    void gerar();
    void exportarPdf();
}
```

Todas as classes quebram até implementarem `exportarPdf`.

Com `default`, você consegue oferecer uma implementação padrão:

```java
interface Relatorio {
    void gerar();

    default void exportarPdf() {
        System.out.println("Exportação padrão em PDF");
    }
}
```

As classes antigas continuam compilando.

Se alguma classe quiser, ela pode sobrescrever:

```java
class RelatorioFinanceiro implements Relatorio {
    @Override
    public void gerar() {
        System.out.println("Gerando relatório financeiro");
    }

    @Override
    public void exportarPdf() {
        System.out.println("Exportação financeira personalizada");
    }
}
```

## Métodos `static` em interfaces

Interfaces também podem ter métodos `static`.

```java
interface ExemploInterfaceEspecial {
    static void metodoStatic() {
        System.out.println("Este é um método static na interface");
    }
}
```

Eles pertencem à interface, não a uma instância.

Chamada:

```java
ExemploInterfaceEspecial.metodoStatic();
```

Não chamamos pelo objeto:

```java
ExemploClasse exemplo = new ExemploClasse();

exemplo.metodoStatic(); // não é assim
```

E classes que implementam a interface não sobrescrevem métodos `static` da interface.

```txt
default -> pode ser usado pelo objeto e pode ser sobrescrito
static  -> pertence à interface e não é sobrescrito pela classe
```

## Exemplo completo com abstrato, default e static

```java
interface ExemploInterfaceEspecial {
    void metodoAbstrato();

    default void metodoDefault() {
        System.out.println("Este é o método default na interface");
    }

    static void metodoStatic() {
        System.out.println("Este é um método static na interface");
    }
}

class ExemploClasse implements ExemploInterfaceEspecial {
    @Override
    public void metodoAbstrato() {
        System.out.println("Implementação do método abstrato");
    }
}

public class TesteInterfaceEspecial {
    public static void main(String[] args) {
        ExemploClasse exemplo = new ExemploClasse();

        exemplo.metodoAbstrato();
        exemplo.metodoDefault();

        ExemploInterfaceEspecial.metodoStatic();
    }
}
```

Saída:

```txt
Implementação do método abstrato
Este é o método default na interface
Este é um método static na interface
```

## Interfaces e design

Interfaces ajudam a separar **o que precisa ser feito** de **como será feito**.

```txt
Interface -> contrato
Classe    -> implementação
```

Isso torna o sistema mais modular.

No backend, esse conceito aparece o tempo todo:

```java
interface EnviadorEmail {
    void enviar(String destino, String mensagem);
}
```

Uma implementação real:

```java
class EnviadorEmailSmtp implements EnviadorEmail {
    @Override
    public void enviar(String destino, String mensagem) {
        System.out.println("Enviando email por SMTP");
    }
}
```

Uma implementação falsa para teste:

```java
class EnviadorEmailFake implements EnviadorEmail {
    @Override
    public void enviar(String destino, String mensagem) {
        System.out.println("Simulando envio de email");
    }
}
```

A interface permite trocar a implementação sem trocar o contrato.

## Armadilhas comuns

- Achar que classe e objeto são a mesma coisa.
- Esquecer o `new` ao criar um objeto.
- Declarar um construtor com parâmetros e depois tentar usar `new Classe()` sem declarar construtor vazio.
- Confundir variável local com variável de instância.
- Esquecer que atributos de objeto começam como `null` quando não são inicializados.
- Criar pacote no código, mas salvar o arquivo fora da pasta correspondente.
- Remover o `import` e não entender por que o compilador não acha a classe.
- Usar muitos construtores e deixar a criação do objeto confusa.
- Tornar tudo `public` e perder controle do estado do objeto.
- Achar que `private` impede a própria classe de acessar o atributo.
- Chamar de "passagem por referência" sem lembrar que Java passa uma cópia da referência.
- Criar métodos `static` para tudo só para não precisar instanciar objetos.
- Usar atributo `static` para dado que deveria pertencer a cada objeto.
- Esquecer que arrays começam no índice `0`.
- Tentar acessar `array[array.length]`, que está fora do array.
- Usar `for-each` quando precisa alterar uma posição específica pelo índice.
- Esperar que um array aumente de tamanho sozinho.
- Usar herança quando a relação "é um" não existe.
- Confundir sobrescrita com sobrecarga.
- Mudar a ordem dos parâmetros e achar que ainda está sobrescrevendo.
- Esquecer que a subclasse não pode reduzir a visibilidade de um método sobrescrito.
- Usar `super` como se ele apontasse para qualquer ancestral; ele aponta para a superclasse imediata.
- Esquecer que `super(...)` precisa ser a primeira linha do construtor.
- Confundir `extends` com `implements`.
- Tentar instanciar uma interface diretamente.
- Esquecer que métodos abstratos de interface são `public` por padrão.
- Implementar método de interface sem `public`.
- Achar que atributo em interface é variável comum; ele é `public static final`.
- Achar que método `default` é obrigatório na classe; ele já tem implementação.
- Tentar sobrescrever método `static` da interface como se fosse método de instância.

## Referência mental

```txt
Classe       -> molde, receita, definição
Objeto       -> instância criada a partir da classe
Atributo     -> dado guardado no objeto
Método       -> comportamento do objeto
Construtor   -> inicialização do objeto
new          -> cria o objeto na memória
Pacote       -> organização das classes
import       -> permite usar classe de outro pacote
java.lang    -> pacote importado automaticamente
public       -> acesso livre
private      -> acesso só dentro da classe
protected    -> classe, pacote e subclasses
default      -> classe e pacote
getter       -> método para obter valor
setter       -> método para alterar valor
static       -> pertence à classe
array        -> conjunto de elementos do mesmo tipo
índice       -> posição de um elemento no array
length       -> tamanho do array
for-each     -> percorre cada elemento sem controlar índice
herança      -> cria uma classe a partir de outra
superclasse  -> classe mais geral
subclasse    -> classe mais específica
extends      -> palavra usada para herdar
override     -> sobrescrita de método
super        -> acesso à superclasse imediata
interface    -> contrato em código
implements   -> implementa uma interface
abstract     -> sem implementação
default      -> método com implementação padrão na interface
```

## Por que importa no backend?

Backend Java é cheio de classes representando conceitos do sistema:

- `Cliente`;
- `Pedido`;
- `Produto`;
- `Pagamento`;
- `Usuario`;
- `Endereco`;
- `Conta`;
- `ServicoDeEmail`;
- `PedidoController`;
- `PedidoService`;
- `PedidoRepository`.

Orientação a objetos ajuda a modelar essas partes com responsabilidades mais claras.

Uma entidade como `Pedido`, por exemplo, guarda estado:

```java
public class Pedido {
    String codigo;
    double valorTotal;
}
```

Um serviço pode representar comportamento:

```java
public class PedidoService {
    void finalizarPedido(Pedido pedido) {
        System.out.println("Finalizando pedido " + pedido.codigo);
    }
}
```

Com o tempo, a trilha vai separar melhor essas ideias: entidade, serviço, objeto de valor, composição, acoplamento e responsabilidade.

## Percepções

> Classe é a estrutura que descreve um conceito. Objeto é uma instância concreta dessa estrutura.
>
> Atributos guardam estado. Métodos representam comportamento.
>
> Construtores deixam a criação do objeto mais organizada, mas construtores demais podem atrapalhar a leitura.
>
> Pacotes são a primeira camada de organização de um projeto Java.
