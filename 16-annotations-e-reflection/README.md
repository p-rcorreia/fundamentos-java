# 16 - Annotations e Reflection

## Objetivo

Entender como Java usa **annotations** para adicionar metadados ao cÃ³digo e como isso se conecta com compilador, ferramentas, bibliotecas e frameworks como Spring Boot.

Annotations podem assustar no comeÃ§o porque deixam o cÃ³digo com sÃ­mbolos e marcaÃ§Ãµes extras. Mas, depois que vocÃª entende a ideia, elas deixam o cÃ³digo mais expressivo e ajudam ferramentas a entenderem melhor a intenÃ§Ã£o do programador.

## Checklist

- [x] O que sÃ£o annotations
- [x] Annotations como metadados
- [x] `@Override`
- [x] `@Deprecated`
- [x] Avisos de compilaÃ§Ã£o com deprecated
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

Annotations sÃ£o metadados.

Elas adicionam informaÃ§Ãµes ao cÃ³digo sem, necessariamente, alterar diretamente a lÃ³gica escrita.

```java
@Override
public void fazerSom() {
    System.out.println("O cachorro late");
}
```

O mÃ©todo continua sendo um mÃ©todo Java comum. A annotation `@Override` adiciona uma informaÃ§Ã£o extra:

```txt
Este mÃ©todo deve sobrescrever um mÃ©todo da superclasse.
```

Essas informaÃ§Ãµes podem ser usadas por:

- compilador;
- IDE;
- ferramentas de build;
- bibliotecas;
- frameworks;
- cÃ³digo em tempo de execuÃ§Ã£o, quando combinado com reflection.

## Por que annotations importam?

Annotations ajudam em trÃªs frentes:

- deixam intenÃ§Ãµes explÃ­citas;
- aumentam a seguranÃ§a do cÃ³digo;
- conectam seu cÃ³digo a ferramentas e frameworks.

No Spring Boot, por exemplo, vocÃª vai ver muitas annotations:

```java
@RestController
@RequestMapping("/clientes")
public class ClienteController {
}
```

No comeÃ§o parece muita "mÃ¡gica", mas a ideia base Ã© a mesma: o framework lÃª esses metadados e toma decisÃµes.

## Annotations como "mocinha" e "vilÃ£"

Annotations podem parecer vilÃ£s quando vocÃª ainda nÃ£o entende o que elas fazem.

Um cÃ³digo cheio de `@AlgumaCoisa` pode ficar visualmente pesado:

```java
@Entity
@Table(name = "clientes")
@Getter
@Setter
public class Cliente {
}
```

Mas elas viram mocinhas quando vocÃª entende que cada annotation comunica uma intenÃ§Ã£o:

```txt
@Entity -> esta classe representa uma entidade persistente
@Table  -> esta entidade usa uma tabela especÃ­fica
@Getter -> gere mÃ©todos getters
@Setter -> gere mÃ©todos setters
```

A annotation nÃ£o Ã© enfeite. Ela conversa com alguma ferramenta.

## `@Override`

`@Override` informa ao compilador que um mÃ©todo deve sobrescrever um mÃ©todo da superclasse.

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

Esse cÃ³digo funciona.

Mas com `@Override`, o compilador passa a verificar sua intenÃ§Ã£o:

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

Se o mÃ©todo realmente sobrescreve um mÃ©todo da superclasse, tudo certo.

## Por que usar `@Override`?

Imagine que vocÃª queria sobrescrever `fazerSom`, mas escreveu um parÃ¢metro sem perceber:

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

Isso **nÃ£o** Ã© sobrescrita.

Isso Ã© outro mÃ©todo, porque a lista de parÃ¢metros mudou.

```txt
Animal.fazerSom()
Cachorro.fazerSom(int volume)
```

Sem `@Override`, o cÃ³digo compila. Talvez vocÃª sÃ³ perceba o erro testando o comportamento.

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
VocÃª disse que isso sobrescreve algo, mas eu nÃ£o encontrei mÃ©todo compatÃ­vel na superclasse.
```

Esse Ã© o valor da annotation: ela transforma uma intenÃ§Ã£o em verificaÃ§Ã£o.

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

SaÃ­da:

```txt
O cachorro late
```

## `@Deprecated`

`@Deprecated` indica que uma classe, mÃ©todo, construtor ou atributo estÃ¡ obsoleto.

Obsoleto significa:

```txt
Ainda existe, mas nÃ£o deveria ser usado em cÃ³digo novo.
```

Isso Ã© comum quando uma API precisa evoluir sem quebrar tudo de uma vez.

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

O mÃ©todo antigo ainda pode funcionar. A annotation nÃ£o apaga o mÃ©todo.

Mas o compilador passa a avisar que ele estÃ¡ depreciado.

## Por que nÃ£o deletar direto?

Em sistemas reais, remover um mÃ©todo imediatamente pode quebrar vÃ¡rias partes do sistema.

EntÃ£o um caminho comum Ã©:

```txt
1. Criar o mÃ©todo novo.
2. Marcar o mÃ©todo antigo com @Deprecated.
3. Migrar os usos aos poucos.
4. Remover o mÃ©todo antigo em uma versÃ£o futura.
```

Isso permite evoluÃ§Ã£o com menos impacto.

Exemplo mental:

```txt
mostrarRegrasParaAposentadoria()
  |
  `-- mÃ©todo antigo, marcado como @Deprecated

mostrarNovasRegrasParaAposentadoria()
  |
  `-- mÃ©todo novo, recomendado
```

## Aviso de compilaÃ§Ã£o

Se vocÃª compilar um cÃ³digo que usa mÃ©todo deprecated, pode ver um aviso parecido com:

```txt
Note: Previdencia.java uses or overrides a deprecated API.
Note: Recompile with -Xlint:deprecation for details.
```

Isso nÃ£o Ã© erro.

Ã‰ um aviso:

```txt
Seu cÃ³digo compila, mas vocÃª estÃ¡ usando algo obsoleto.
```

## `javac -Xlint:deprecation`

Para ver mais detalhes, compile com:

```bash
javac -Xlint:deprecation Previdencia.java
```

Assim o compilador mostra exatamente onde estÃ¡ o uso depreciado.

Exemplo de aviso:

```txt
Previdencia.java:6: warning: [deprecation] mostrarRegrasParaAposentadoria() in InformaRegras has been deprecated
        regras.mostrarRegrasParaAposentadoria();
              ^
```

Isso ajuda quando o projeto tem muitos avisos e vocÃª precisa achar a linha exata.

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

Nesse caso, o aviso de uso deprecated Ã© escondido.

Mas cuidado: esconder aviso nÃ£o resolve o problema.

Em geral, Ã© melhor trocar o mÃ©todo antigo pelo novo:

```java
regras.mostrarNovasRegrasParaAposentadoria();
```

Use `@SuppressWarnings` sÃ³ quando vocÃª entende o risco e tem um bom motivo.

## Chamada deprecated dentro da mesma classe

Existe um detalhe curioso.

Quando um mÃ©todo deprecated Ã© chamado por outro mÃ©todo da **mesma classe**, o compilador pode nÃ£o emitir o mesmo aviso.

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

A chamada direta ao mÃ©todo obsoleto estÃ¡ dentro da prÃ³pria classe `InformaRegras`.

A ideia Ã© que, dentro da mesma classe, o compilador assume que o autor estÃ¡ ciente da depreciaÃ§Ã£o. JÃ¡ quando outra classe chama o mÃ©todo deprecated, o compilador avisa para evitar uso acidental.

## Resumo das annotations vistas

| Annotation | Para que serve |
|---|---|
| `@Override` | Garante que um mÃ©todo realmente sobrescreve outro |
| `@Deprecated` | Marca algo como obsoleto |
| `@SuppressWarnings` | Suprime avisos especÃ­ficos do compilador |

## RelaÃ§Ã£o com Spring Boot

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

VocÃª ainda nÃ£o precisa decorar essas annotations agora.

O ponto importante Ã© entender que elas colocam metadados no cÃ³digo. Depois, o Spring lÃª esses metadados e decide como montar a aplicaÃ§Ã£o.

## Armadilhas comuns

- Achar que annotation Ã© comentÃ¡rio.
- Usar `@SuppressWarnings` para esconder problema real.
- Esquecer `@Override` em mÃ©todos sobrescritos.
- Confundir sobrescrita com sobrecarga e sÃ³ descobrir em runtime.
- Marcar algo como `@Deprecated` e nunca oferecer uma alternativa nova.
- Ver um cÃ³digo cheio de annotations e achar que todas fazem parte do Java puro; muitas vÃªm de frameworks ou bibliotecas.

## ReferÃªncia mental

```txt
Annotation        -> metadado no cÃ³digo
@Override         -> confirma sobrescrita
@Deprecated       -> marca algo obsoleto
@SuppressWarnings -> esconde avisos especÃ­ficos
-Xlint            -> mostra detalhes de avisos do javac
Spring            -> usa annotations para conectar seu cÃ³digo ao framework
```

## Por que importa no backend?

Muitas "mÃ¡gicas" do backend Java moderno sÃ£o baseadas em annotations.

Spring, JPA, Bean Validation, Lombok, MapStruct e bibliotecas de testes usam annotations para reduzir configuraÃ§Ã£o manual e deixar intenÃ§Ãµes explÃ­citas.

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

Dominar annotations ajuda a ler cÃ³digo Java moderno com menos susto.

## PercepÃ§Ãµes

> Annotation nÃ£o Ã© enfeite. Ela Ã© uma informaÃ§Ã£o que alguÃ©m vai ler: compilador, IDE, ferramenta, biblioteca ou framework.
>
> `@Override` Ã© pequena, mas evita erro bobo e melhora a leitura.
>
> `@Deprecated` ajuda sistemas grandes a evoluÃ­rem sem quebrar tudo de uma vez.
