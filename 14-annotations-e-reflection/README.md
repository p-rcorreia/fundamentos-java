# 14 - Annotations e Reflection

## Objetivo

Entender como Java usa **annotations** para adicionar metadados ao código e como isso se conecta com compilador, ferramentas, bibliotecas e frameworks como Spring Boot.

Annotations podem assustar no começo porque deixam o código com símbolos e marcações extras. Mas, depois que você entende a ideia, elas deixam o código mais expressivo e ajudam ferramentas a entenderem melhor a intenção do programador.

## Checklist

- [x] O que são annotations
- [x] Annotations como metadados
- [x] `@Override`
- [x] `@Deprecated`
- [x] Avisos de compilação com deprecated
- [x] `javac -Xlint:deprecation`
- [x] `@SuppressWarnings`
- [ ] Criar annotation customizada
- [ ] `RetentionPolicy`
- [ ] `Target`
- [ ] Reflection API
- [ ] `Class`, `Method` e `Field`
- [ ] Leitura de metadados em runtime
- [ ] Custo e riscos de reflection
- [ ] Como Spring usa annotations
- [ ] Como JPA usa annotations

## Ideia central

Annotations são metadados.

Elas adicionam informações ao código sem, necessariamente, alterar diretamente a lógica escrita.

```java
@Override
public void fazerSom() {
    System.out.println("O cachorro late");
}
```

O método continua sendo um método Java comum. A annotation `@Override` adiciona uma informação extra:

```txt
Este método deve sobrescrever um método da superclasse.
```

Essas informações podem ser usadas por:

- compilador;
- IDE;
- ferramentas de build;
- bibliotecas;
- frameworks;
- código em tempo de execução, quando combinado com reflection.

## Por que annotations importam?

Annotations ajudam em três frentes:

- deixam intenções explícitas;
- aumentam a segurança do código;
- conectam seu código a ferramentas e frameworks.

No Spring Boot, por exemplo, você vai ver muitas annotations:

```java
@RestController
@RequestMapping("/clientes")
public class ClienteController {
}
```

No começo parece muita "mágica", mas a ideia base é a mesma: o framework lê esses metadados e toma decisões.

## Annotations como "mocinha" e "vilã"

Annotations podem parecer vilãs quando você ainda não entende o que elas fazem.

Um código cheio de `@AlgumaCoisa` pode ficar visualmente pesado:

```java
@Entity
@Table(name = "clientes")
@Getter
@Setter
public class Cliente {
}
```

Mas elas viram mocinhas quando você entende que cada annotation comunica uma intenção:

```txt
@Entity -> esta classe representa uma entidade persistente
@Table  -> esta entidade usa uma tabela específica
@Getter -> gere métodos getters
@Setter -> gere métodos setters
```

A annotation não é enfeite. Ela conversa com alguma ferramenta.

## `@Override`

`@Override` informa ao compilador que um método deve sobrescrever um método da superclasse.

Exemplo sem annotation:

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
```

Esse código funciona.

Mas com `@Override`, o compilador passa a verificar sua intenção:

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

Se o método realmente sobrescreve um método da superclasse, tudo certo.

## Por que usar `@Override`?

Imagine que você queria sobrescrever `fazerSom`, mas escreveu um parâmetro sem perceber:

```java
class Animal {
    public void fazerSom() {
        System.out.println("O animal faz um som");
    }
}

class Cachorro extends Animal {
    public void fazerSom(int volume) {
        System.out.println("O cachorro late");
    }
}
```

Isso **não** é sobrescrita.

Isso é outro método, porque a lista de parâmetros mudou.

```txt
Animal.fazerSom()
Cachorro.fazerSom(int volume)
```

Sem `@Override`, o código compila. Talvez você só perceba o erro testando o comportamento.

Com `@Override`, o compilador acusa o problema:

```java
class Cachorro extends Animal {
    @Override
    public void fazerSom(int volume) {
        System.out.println("O cachorro late");
    }
}
```

O compilador entende:

```txt
Você disse que isso sobrescreve algo, mas eu não encontrei método compatível na superclasse.
```

Esse é o valor da annotation: ela transforma uma intenção em verificação.

## Exemplo completo com `@Override`

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

public class TesteAnnotations {
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

## `@Deprecated`

`@Deprecated` indica que uma classe, método, construtor ou atributo está obsoleto.

Obsoleto significa:

```txt
Ainda existe, mas não deveria ser usado em código novo.
```

Isso é comum quando uma API precisa evoluir sem quebrar tudo de uma vez.

Exemplo:

```java
class InformaRegras {
    @Deprecated
    public void mostrarRegrasParaAposentadoria() {
        System.out.println("Regras antigas para aposentadoria");
    }

    public void mostrarNovasRegrasParaAposentadoria() {
        System.out.println("Novas regras para aposentadoria");
    }
}
```

Uso:

```java
public class Previdencia {
    public static void main(String[] args) {
        InformaRegras regras = new InformaRegras();

        regras.mostrarRegrasParaAposentadoria();
        regras.mostrarNovasRegrasParaAposentadoria();
    }
}
```

O método antigo ainda pode funcionar. A annotation não apaga o método.

Mas o compilador passa a avisar que ele está depreciado.

## Por que não deletar direto?

Em sistemas reais, remover um método imediatamente pode quebrar várias partes do sistema.

Então um caminho comum é:

```txt
1. Criar o método novo.
2. Marcar o método antigo com @Deprecated.
3. Migrar os usos aos poucos.
4. Remover o método antigo em uma versão futura.
```

Isso permite evolução com menos impacto.

Exemplo mental:

```txt
mostrarRegrasParaAposentadoria()
  |
  `-- método antigo, marcado como @Deprecated

mostrarNovasRegrasParaAposentadoria()
  |
  `-- método novo, recomendado
```

## Aviso de compilação

Se você compilar um código que usa método deprecated, pode ver um aviso parecido com:

```txt
Note: Previdencia.java uses or overrides a deprecated API.
Note: Recompile with -Xlint:deprecation for details.
```

Isso não é erro.

É um aviso:

```txt
Seu código compila, mas você está usando algo obsoleto.
```

## `javac -Xlint:deprecation`

Para ver mais detalhes, compile com:

```bash
javac -Xlint:deprecation Previdencia.java
```

Assim o compilador mostra exatamente onde está o uso depreciado.

Exemplo de aviso:

```txt
Previdencia.java:6: warning: [deprecation] mostrarRegrasParaAposentadoria() in InformaRegras has been deprecated
        regras.mostrarRegrasParaAposentadoria();
              ^
```

Isso ajuda quando o projeto tem muitos avisos e você precisa achar a linha exata.

## `@SuppressWarnings`

`@SuppressWarnings` serve para suprimir avisos do compilador.

Exemplo:

```java
public class Previdencia {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        InformaRegras regras = new InformaRegras();

        regras.mostrarRegrasParaAposentadoria();
    }
}
```

Nesse caso, o aviso de uso deprecated é escondido.

Mas cuidado: esconder aviso não resolve o problema.

Em geral, é melhor trocar o método antigo pelo novo:

```java
regras.mostrarNovasRegrasParaAposentadoria();
```

Use `@SuppressWarnings` só quando você entende o risco e tem um bom motivo.

## Chamada deprecated dentro da mesma classe

Existe um detalhe curioso.

Quando um método deprecated é chamado por outro método da **mesma classe**, o compilador pode não emitir o mesmo aviso.

Exemplo:

```java
class InformaRegras {
    @Deprecated
    public void mostrarRegrasParaAposentadoria() {
        System.out.println("Regras antigas");
    }

    public void chamarMetodoObsoletoNaMesmaClasse() {
        mostrarRegrasParaAposentadoria();
    }
}
```

Uso externo:

```java
public class TesteDeprecated {
    public static void main(String[] args) {
        InformaRegras regras = new InformaRegras();

        regras.chamarMetodoObsoletoNaMesmaClasse();
    }
}
```

A chamada direta ao método obsoleto está dentro da própria classe `InformaRegras`.

A ideia é que, dentro da mesma classe, o compilador assume que o autor está ciente da depreciação. Já quando outra classe chama o método deprecated, o compilador avisa para evitar uso acidental.

## Resumo das annotations vistas

| Annotation | Para que serve |
|---|---|
| `@Override` | Garante que um método realmente sobrescreve outro |
| `@Deprecated` | Marca algo como obsoleto |
| `@SuppressWarnings` | Suprime avisos específicos do compilador |

## Relação com Spring Boot

Spring usa annotations o tempo todo.

Exemplos:

```java
@RestController
public class ClienteController {
}
```

```java
@Service
public class ClienteService {
}
```

```java
@Repository
public class ClienteRepository {
}
```

```java
@GetMapping("/clientes")
public List<Cliente> listar() {
    return List.of();
}
```

Você ainda não precisa decorar essas annotations agora.

O ponto importante é entender que elas colocam metadados no código. Depois, o Spring lê esses metadados e decide como montar a aplicação.

## Armadilhas comuns

- Achar que annotation é comentário.
- Usar `@SuppressWarnings` para esconder problema real.
- Esquecer `@Override` em métodos sobrescritos.
- Confundir sobrescrita com sobrecarga e só descobrir em runtime.
- Marcar algo como `@Deprecated` e nunca oferecer uma alternativa nova.
- Ver um código cheio de annotations e achar que todas fazem parte do Java puro; muitas vêm de frameworks ou bibliotecas.

## Referência mental

```txt
Annotation        -> metadado no código
@Override         -> confirma sobrescrita
@Deprecated       -> marca algo obsoleto
@SuppressWarnings -> esconde avisos específicos
-Xlint            -> mostra detalhes de avisos do javac
Spring            -> usa annotations para conectar seu código ao framework
```

## Por que importa no backend?

Muitas "mágicas" do backend Java moderno são baseadas em annotations.

Spring, JPA, Bean Validation, Lombok, MapStruct e bibliotecas de testes usam annotations para reduzir configuração manual e deixar intenções explícitas.

Exemplos que aparecem em backend:

- `@RestController`;
- `@Service`;
- `@Repository`;
- `@Entity`;
- `@Id`;
- `@NotNull`;
- `@Test`;
- `@Mock`;
- `@Getter`;
- `@Mapper`.

Dominar annotations ajuda a ler código Java moderno com menos susto.

## Percepções

> Annotation não é enfeite. Ela é uma informação que alguém vai ler: compilador, IDE, ferramenta, biblioteca ou framework.
>
> `@Override` é pequena, mas evita erro bobo e melhora a leitura.
>
> `@Deprecated` ajuda sistemas grandes a evoluírem sem quebrar tudo de uma vez.
