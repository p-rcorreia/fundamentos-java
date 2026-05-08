# 05 - Generics

## Objetivo

Entender como Java usa tipos genéricos para aumentar segurança, reutilização e clareza do código.

Generics parecem estranhos no começo por causa dos sinais `< >`, mas eles existem para o compilador entender melhor quais tipos podem entrar e sair de uma classe, método ou coleção.

## Checklist

- [x] O que são generics
- [x] Type safety
- [x] Generic classes
- [x] Classe genérica com `<T>`
- [x] Usar generics com `String`
- [x] Usar generics com `Integer`
- [x] Wrappers em generics
- [x] Problema de usar `Object`
- [x] Casting sem generics
- [x] `instanceof` sem generics
- [x] Generics evitando casts
- [ ] Generic methods
- [ ] Wildcards
- [ ] `? extends`
- [ ] `? super`
- [ ] Generics em collections
- [ ] Generics em repositories e services
- [ ] Erasure, apenas noção inicial

## Ideia central

Generics permitem criar classes, interfaces e métodos que trabalham com tipos parametrizados.

Pense em uma caixa.

Sem generics:

```txt
Caixa
  |
  |-- pode guardar livro
  |-- pode guardar bola
  |-- pode guardar telefone
  `-- na hora de pegar, você precisa conferir o que veio
```

Com generics:

```txt
Caixa<Livro>
  |
  `-- só guarda Livro
```

Quando você pega algo da `Caixa<Livro>`, o Java já sabe que aquilo é um `Livro`.

## Por que generics ajudam?

Generics ajudam principalmente em:

- segurança de tipo;
- reutilização de código;
- redução de casting;
- erros encontrados em tempo de compilação;
- código mais claro para quem lê.

Sem generics, muitos erros aparecem só em runtime.

Com generics, o compilador consegue bloquear vários problemas antes do programa rodar.

```txt
Sem generics -> erro pode aparecer em runtime
Com generics -> erro tende a aparecer na compilação
```

## Classe genérica

Uma classe genérica recebe um tipo como parâmetro.

```java
public class Caixa<T> {
    private T coisaNaCaixa;

    public void guardar(T coisa) {
        coisaNaCaixa = coisa;
    }

    public T pegar() {
        return coisaNaCaixa;
    }
}
```

O `T` é um marcador de tipo.

```txt
T -> type -> tipo
```

Ele representa o tipo que será definido quando a classe for usada.

Poderia ser outra letra, mas `T` é uma convenção comum.

## Caixa de `String`

```java
public class Caixa<T> {
    private T coisaNaCaixa;

    public void guardar(T coisa) {
        coisaNaCaixa = coisa;
    }

    public T pegar() {
        return coisaNaCaixa;
    }

    public static void main(String[] args) {
        Caixa<String> caixaDeTexto = new Caixa<>();

        caixaDeTexto.guardar("Oi, mundo!");

        String texto = caixaDeTexto.pegar();

        System.out.println(texto);
    }
}
```

Saída:

```txt
Oi, mundo!
```

Aqui:

```java
Caixa<String> caixaDeTexto = new Caixa<>();
```

Significa:

```txt
Esta caixa guarda String.
```

O compilador sabe que `pegar()` retorna `String`.

Por isso não precisamos fazer cast.

## Caixa de `Integer`

A mesma classe `Caixa<T>` pode ser reutilizada para números.

```java
Caixa<Integer> caixaDeNumeros = new Caixa<>();

Integer numero = Integer.valueOf(3);

caixaDeNumeros.guardar(numero);

Integer valorResgatado = caixaDeNumeros.pegar();

System.out.println(valorResgatado);
```

Saída:

```txt
3
```

Perceba a reutilização:

```txt
Caixa<String>  -> caixa de texto
Caixa<Integer> -> caixa de números
```

A classe é a mesma.

O tipo muda.

## Generics não usam primitivos

Generics trabalham com objetos, não com tipos primitivos.

Isso não funciona:

```java
Caixa<int> caixa = new Caixa<>(); // erro
```

Use o wrapper:

```java
Caixa<Integer> caixa = new Caixa<>();
```

Alguns exemplos:

| Primitivo | Wrapper |
|---|---|
| `int` | `Integer` |
| `long` | `Long` |
| `double` | `Double` |
| `boolean` | `Boolean` |
| `byte` | `Byte` |

## `Integer.valueOf`

Antigamente era comum ver:

```java
Integer numero = new Integer(3);
```

Mas esse construtor foi depreciado.

Prefira:

```java
Integer numero = Integer.valueOf(3);
```

Ou simplesmente:

```java
Integer numero = 3;
```

Nesse segundo caso, o Java faz autoboxing.

## Sem generics: usando `Object`

Antes de generics, uma forma comum de criar uma caixa flexível era usar `Object`.

```java
class CaixaDeBrinquedos {
    private Object coisaNaCaixa;

    public void guardar(Object coisa) {
        coisaNaCaixa = coisa;
    }

    public Object pegar() {
        return coisaNaCaixa;
    }
}
```

Funciona, porque toda classe herda de `Object`.

Mas o problema aparece na hora de pegar.

O método `pegar()` retorna `Object`, então o compilador não sabe se veio um `Carrinho`, uma `Boneca` ou outra coisa.

## Classes de exemplo

```java
class Carrinho {
    private String modelo;

    public Carrinho(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }
}
```

```java
class Boneca {
    private String nome;

    public Boneca(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
```

## Usando `Object`, `instanceof` e cast

```java
public class TesteCaixaSemGenerics {
    public static void main(String[] args) {
        CaixaDeBrinquedos caixaDeCarrinhos = new CaixaDeBrinquedos();
        caixaDeCarrinhos.guardar(new Carrinho("Hot Wheels"));

        CaixaDeBrinquedos caixaDeBonecas = new CaixaDeBrinquedos();
        caixaDeBonecas.guardar(new Boneca("Barbie"));

        if (caixaDeCarrinhos.pegar() instanceof Carrinho) {
            Carrinho carrinho = (Carrinho) caixaDeCarrinhos.pegar();

            System.out.println(carrinho.getModelo());
        }

        if (caixaDeBonecas.pegar() instanceof Boneca) {
            Boneca boneca = (Boneca) caixaDeBonecas.pegar();

            System.out.println(boneca.getNome());
        }
    }
}
```

Saída:

```txt
Hot Wheels
Barbie
```

Funciona.

Mas o código ficou cheio de verificação e conversão:

```txt
instanceof -> verifica o tipo
cast       -> converte Object para o tipo esperado
```

Sem esse cuidado, um cast errado pode gerar `ClassCastException` em runtime.

## Com generics: sem cast

Agora a mesma ideia com generics:

```java
class CaixaGenerica<T> {
    private T coisaNaCaixa;

    public void guardar(T coisa) {
        coisaNaCaixa = coisa;
    }

    public T pegar() {
        return coisaNaCaixa;
    }
}
```

Uso:

```java
public class TesteCaixaGenerica {
    public static void main(String[] args) {
        CaixaGenerica<Carrinho> caixaDeCarrinhos = new CaixaGenerica<>();
        caixaDeCarrinhos.guardar(new Carrinho("Hot Wheels"));

        CaixaGenerica<Boneca> caixaDeBonecas = new CaixaGenerica<>();
        caixaDeBonecas.guardar(new Boneca("Barbie"));

        Carrinho carrinho = caixaDeCarrinhos.pegar();
        Boneca boneca = caixaDeBonecas.pegar();

        System.out.println(carrinho.getModelo());
        System.out.println(boneca.getNome());
    }
}
```

Saída:

```txt
Hot Wheels
Barbie
```

Agora não precisamos de:

```java
instanceof
```

Nem de:

```java
(Carrinho)
(Boneca)
```

O tipo já está definido na caixa:

```txt
CaixaGenerica<Carrinho> -> pegar() retorna Carrinho
CaixaGenerica<Boneca>   -> pegar() retorna Boneca
```

## Type safety

Type safety significa segurança de tipo.

Com generics, o compilador impede que você coloque uma coisa errada na caixa.

```java
CaixaGenerica<Carrinho> caixaDeCarrinhos = new CaixaGenerica<>();

caixaDeCarrinhos.guardar(new Carrinho("Hot Wheels"));
caixaDeCarrinhos.guardar(new Boneca("Barbie")); // erro de compilação
```

O erro aparece antes do programa rodar.

Esse é um dos maiores benefícios de generics.

## Diamond operator

Na criação do objeto, é comum usar `<>`.

```java
CaixaGenerica<Carrinho> caixa = new CaixaGenerica<>();
```

O `<>` do lado direito é chamado de diamond operator.

O compilador infere o tipo a partir do lado esquerdo.

É como se ele entendesse:

```java
CaixaGenerica<Carrinho> caixa = new CaixaGenerica<Carrinho>();
```

Mas sem repetir tudo.

## Comparação geral

| Sem generics | Com generics |
|---|---|
| Usa `Object` | Usa tipo específico |
| Precisa de cast | Evita cast |
| Pode falhar em runtime | Erros aparecem na compilação |
| Código mais verboso | Código mais direto |
| Menos seguro | Mais seguro |

## Armadilhas comuns

- Tentar usar tipo primitivo em generics, como `Caixa<int>`.
- Esquecer que generics trabalham com objetos e wrappers.
- Usar `Object` quando um tipo genérico resolveria melhor.
- Fazer cast sem verificar o tipo real.
- Achar que `<T>` precisa ser sempre a letra `T`.
- Ignorar warnings de raw type.

## Referência mental

```txt
Generic       -> tipo parametrizado
T             -> marcador de tipo
Caixa<T>      -> caixa de algum tipo
Caixa<String> -> caixa de String
Object        -> aceita tudo, mas perde precisão
cast          -> conversão manual
type safety   -> segurança de tipo
<>            -> diamond operator
```

## Por que importa no backend?

Generics aparecem em muitos lugares do Java backend:

- `List<Cliente>`;
- `Map<String, Pedido>`;
- `Optional<Usuario>`;
- `ResponseEntity<ClienteResponse>`;
- `Repository<Cliente, Long>`;
- `Page<Produto>`;
- `Comparator<Funcionario>`.

Entender generics ajuda a ler Collections, Spring Data, respostas HTTP, serviços reutilizáveis e APIs tipadas.

## Percepções

> Generics deixam o tipo explícito para o compilador.
>
> O código fica mais seguro porque vários erros deixam de aparecer em runtime e passam a aparecer na compilação.
>
> Generics são uma resposta mais elegante para muito código antigo baseado em `Object`, `instanceof` e casting.
