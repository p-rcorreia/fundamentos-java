# 03 - Orientação a Objetos

## Objetivo

Entender como Java organiza dados, comportamento e regras por meio de objetos.

## Checklist

- [x] Classe
- [x] Objeto
- [x] Atributo
- [x] Método
- [ ] Construtor
- [ ] Encapsulamento
- [ ] Herança
- [ ] Polimorfismo
- [ ] Abstração
- [ ] Interface
- [ ] Classe abstrata
- [ ] Sobrecarga
- [ ] Sobrescrita
- [ ] Composição
- [ ] Associação
- [ ] Agregação
- [ ] Coesão
- [ ] Acoplamento
- [ ] Responsabilidade de classe
- [ ] Diferença entre entidade, serviço e objeto de valor

## Por que importa no backend?

POO é a base para modelar entidades, serviços, regras de negócio e componentes Spring.

Em uma aplicação backend, é comum representar conceitos do domínio usando classes e objetos, como `Cliente`, `Pedido`, `Produto`, `Conta`, `Pagamento` e `Usuario`.

## Classe

Uma **classe** é um molde.

Ela descreve quais dados e comportamentos um tipo de objeto pode ter.

```java
public class Cliente {
    String nome;
    String email;

    void exibirDados() {
        System.out.println(nome + " - " + email);
    }
}
```

Nesse exemplo, `Cliente` é uma classe.

Ela define que um cliente possui:

- um `nome`;
- um `email`;
- um comportamento chamado `exibirDados`.

## Objeto

Um **objeto** é uma instância de uma classe.

Se a classe é o molde, o objeto é algo criado a partir desse molde.

```java
Cliente cliente = new Cliente();

cliente.nome = "Ana";
cliente.email = "ana@email.com";

cliente.exibirDados();
```

Nesse exemplo:

- `Cliente` é o tipo;
- `cliente` é a variável de referência;
- `new Cliente()` cria um objeto;
- `cliente.nome` acessa o atributo `nome`;
- `cliente.exibirDados()` chama um método.

## Atributos

**Atributos** representam os dados de um objeto.

```java
public class Produto {
    String nome;
    double preco;
    int quantidadeEmEstoque;
}
```

Nesse exemplo, todo objeto `Produto` pode ter:

- nome;
- preço;
- quantidade em estoque.

Um objeto específico poderia representar:

```java
Produto produto = new Produto();

produto.nome = "Teclado";
produto.preco = 150.00;
produto.quantidadeEmEstoque = 10;
```

## Métodos

**Métodos** representam comportamentos.

Eles dizem o que um objeto sabe fazer.

```java
public class Produto {
    String nome;
    double preco;
    int quantidadeEmEstoque;

    double calcularValorTotalEmEstoque() {
        return preco * quantidadeEmEstoque;
    }
}
```

Uso:

```java
Produto produto = new Produto();

produto.nome = "Teclado";
produto.preco = 150.00;
produto.quantidadeEmEstoque = 10;

double total = produto.calcularValorTotalEmEstoque();

System.out.println(total);
```

Nesse caso, o método `calcularValorTotalEmEstoque` usa os atributos do próprio objeto para calcular uma informação.

## Classe reunindo dados e comportamento

O ponto central da orientação a objetos é aproximar dados e comportamentos relacionados.

```java
public class Conta {
    double saldo;

    void depositar(double valor) {
        saldo += valor;
    }

    void sacar(double valor) {
        saldo -= valor;
    }

    void exibirSaldo() {
        System.out.println("Saldo: " + saldo);
    }
}
```

Uso:

```java
Conta conta = new Conta();

conta.depositar(100);
conta.sacar(30);
conta.exibirSaldo();
```

Aqui, a classe `Conta` não guarda apenas o dado `saldo`. Ela também concentra os comportamentos que alteram ou exibem esse saldo.

## Referência mental

Uma boa forma de pensar:

```txt
Classe  -> molde
Objeto  -> coisa criada a partir do molde
Atributo -> dado do objeto
Método -> comportamento do objeto
```

## Percepções

> Classe é a estrutura que descreve um conceito. Objeto é uma instância concreta dessa estrutura.
>
> Atributos guardam estado. Métodos representam comportamento.
