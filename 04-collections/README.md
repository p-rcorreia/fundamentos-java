# 04 - Collections

## Objetivo

Entender as principais estruturas de coleção em Java e quando usar cada uma.

Collections são uma alternativa mais flexível aos arrays. Elas permitem armazenar, recuperar, manipular e comunicar grupos de objetos com uma API rica e muito usada no dia a dia profissional.

## Checklist

- [x] O que são Collections
- [x] Java Collections Framework
- [x] Diferença entre arrays e Collections
- [x] Interface `Collection`
- [x] Métodos comuns: `add`, `remove`, `clear`, `size`, `isEmpty`, `contains`
- [x] `Set`
- [x] `HashSet`
- [x] `List`
- [x] `ArrayList`
- [x] `Map`
- [x] `HashMap`
- [x] `LinkedHashMap`, apenas noção
- [x] `TreeMap`, apenas noção
- [ ] `LinkedList`, apenas noção
- [ ] `LinkedHashSet`
- [ ] `TreeSet`
- [ ] `Queue`
- [ ] Iteração
- [ ] Ordenação
- [ ] `Comparator`
- [ ] `Comparable`
- [ ] Imutabilidade em coleções
- [ ] Quando usar cada estrutura

## Ideia central

Uma Collection é um container que agrupa vários elementos em uma unidade.

```txt
Collection
  |
  |-- guardar vários objetos
  |-- recuperar objetos
  |-- remover objetos
  |-- verificar se algo existe
  `-- limpar tudo
```

Arrays também guardam vários elementos.

Mas arrays têm tamanho fixo.

Collections são dinâmicas.

## Arrays vs Collections

```java
String[] nomes = new String[3];
```

Esse array tem 3 posições.

Depois de criado, ele não cresce sozinho.

Com Collections:

```java
List<String> nomes = new ArrayList<>();

nomes.add("Maria");
nomes.add("João");
nomes.add("Ana");
nomes.add("Paulo");
```

A lista cresce conforme os elementos são adicionados.

Comparação:

| Característica | Array | Collection |
|---|---|---|
| Tamanho | Fixo | Dinâmico |
| API de manipulação | Menor | Mais rica |
| Performance simples de acesso | Muito boa | Depende da implementação |
| Uso profissional cotidiano | Existe | Muito comum |
| Generics | Não do mesmo jeito | Sim |

No dia a dia de backend, você tende a usar Collections o tempo todo.

## Java Collections Framework

O Java Collections Framework fornece interfaces e classes para trabalhar com grupos de objetos.

Algumas interfaces importantes:

```txt
Collection
  |
  |-- List
  |-- Set
  `-- Queue

Map
```

`Map` faz parte do framework de coleções, mas não estende `Collection`.

Isso acontece porque `Map` trabalha com pares de chave e valor, não apenas com elementos soltos.

## Interface `Collection`

`Collection` é uma das interfaces raiz do framework.

Ela define métodos básicos que aparecem em várias coleções:

```txt
add      -> adiciona elemento
remove   -> remove elemento
clear    -> limpa a coleção
size     -> quantidade de elementos
isEmpty  -> verifica se está vazia
contains -> verifica se contém um elemento
```

Você não costuma instanciar `Collection` diretamente. Normalmente usa uma implementação concreta, como `ArrayList` ou `HashSet`.

## Imports

As Collections ficam no pacote `java.util`.

Você pode importar item por item:

```java
import java.util.Set;
import java.util.HashSet;
```

Ou importar o pacote todo:

```java
import java.util.*;
```

Em exemplos pequenos isso é comum.

Em código profissional, muitos times preferem imports explícitos para deixar claro o que está sendo usado.

## `Set`

`Set` representa um conjunto.

A principal regra:

```txt
Set não permite elementos duplicados.
```

Se você tentar adicionar um elemento que já existe, ele não será adicionado novamente.

Uma implementação comum é `HashSet`.

```java
import java.util.HashSet;
import java.util.Set;

public class ExemploSet {
    public static void main(String[] args) {
        Set<String> conjunto = new HashSet<>();

        conjunto.add("Java");
        conjunto.add("Python");
        conjunto.add("C++");

        System.out.println(conjunto);
    }
}
```

`Set<String>` usa generics.

Isso significa:

```txt
Esse conjunto guarda String.
```

## Operações com `HashSet`

```java
import java.util.HashSet;
import java.util.Set;

public class ExemploSet {
    public static void main(String[] args) {
        Set<String> conjunto = new HashSet<>();

        conjunto.add("Java");
        conjunto.add("Python");
        conjunto.add("C++");

        System.out.println("Contém Java? " + conjunto.contains("Java"));

        conjunto.add("JavaScript");
        conjunto.add("Ruby");

        System.out.println("Conjunto completo: " + conjunto);

        conjunto.remove("Python");

        System.out.println("Conjunto após remoção: " + conjunto);

        boolean foiAdicionado = conjunto.add("Java");

        System.out.println("Java foi adicionado novamente? " + foiAdicionado);

        conjunto.clear();

        System.out.println("Conjunto após limpar: " + conjunto);
    }
}
```

Pontos importantes:

- `contains("Java")` retorna `true` ou `false`;
- `remove("Python")` remove o elemento;
- `add("Java")` retorna `false` se `Java` já existir;
- `clear()` limpa o conjunto.

## Ordem no `HashSet`

`HashSet` não garante ordem de inserção.

Você pode adicionar:

```txt
Java
Python
C++
JavaScript
Ruby
```

E a impressão pode aparecer em outra ordem.

Isso é normal.

```txt
HashSet -> não garante ordem
```

Se a ordem importar, você precisa pensar em outra implementação.

## `List`

`List` representa uma coleção ordenada.

Principais características:

```txt
List mantém ordem de inserção.
List permite elementos duplicados.
List permite acesso por índice.
```

Uma implementação muito comum é `ArrayList`.

```java
import java.util.ArrayList;
import java.util.List;

public class ExemploList {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();

        lista.add("Java");
        lista.add("Python");
        lista.add("C++");

        System.out.println(lista);
    }
}
```

## Operações com `ArrayList`

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExemploList {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();

        lista.add("Java");
        lista.add("Python");
        lista.add("C++");

        System.out.println("Contém Java? " + lista.contains("Java"));

        List<String> outraLista = Arrays.asList("JavaScript", "Ruby");

        lista.addAll(outraLista);

        System.out.println("Lista completa: " + lista);

        lista.remove("Python");

        System.out.println("Lista após remoção: " + lista);

        String elemento = lista.get(2);

        System.out.println("Elemento no índice 2: " + elemento);

        lista.clear();

        System.out.println("Lista após limpar: " + lista);
    }
}
```

Pontos importantes:

- `add` adiciona um elemento;
- `addAll` adiciona todos os elementos de outra coleção;
- `remove` remove um elemento;
- `get(2)` obtém o elemento no índice 2;
- `clear` limpa a lista.

## Índice em `List`

Assim como arrays, listas usam índice começando em zero.

```txt
Lista:
0 -> Java
1 -> C++
2 -> JavaScript
3 -> Ruby
```

Então:

```java
lista.get(2);
```

Retorna:

```txt
JavaScript
```

## Duplicatas em `List`

`List` permite elementos repetidos.

```java
List<String> linguagens = new ArrayList<>();

linguagens.add("Java");
linguagens.add("Java");
linguagens.add("Python");

System.out.println(linguagens);
```

Saída:

```txt
[Java, Java, Python]
```

Essa é uma diferença importante em relação ao `Set`.

## `Set` vs `List`

| Característica | `Set` | `List` |
|---|---|---|
| Permite duplicados | Não | Sim |
| Mantém ordem | Depende da implementação | Sim, em geral |
| Acesso por índice | Não | Sim |
| Exemplo comum | `HashSet` | `ArrayList` |

Regra prática inicial:

```txt
Preciso evitar duplicados -> Set
Preciso manter sequência e acessar por índice -> List
```

## `Map`

`Map` armazena pares de chave e valor.

Pense em um dicionário:

```txt
palavra -> significado
```

Ou em cores de frutas:

```txt
maçã   -> vermelha
banana -> amarela
abacate -> verde
```

Em Java:

```txt
chave -> valor
```

Uma implementação comum é `HashMap`.

## `HashMap`

```java
import java.util.HashMap;
import java.util.Map;

public class ExemploMap {
    public static void main(String[] args) {
        Map<String, String> cores = new HashMap<>();

        cores.put("maçã", "vermelha");
        cores.put("banana", "amarela");
        cores.put("abacate", "verde");

        System.out.println(cores.get("banana"));
    }
}
```

Saída:

```txt
amarela
```

`Map<String, String>` significa:

```txt
Chave String
Valor String
```

## Chaves únicas

`Map` não permite chaves duplicadas.

Se você usar a mesma chave de novo, o valor antigo é substituído.

```java
Map<String, String> cores = new HashMap<>();

cores.put("maçã", "vermelha");
cores.put("maçã", "verde");

System.out.println(cores.get("maçã"));
```

Saída:

```txt
verde
```

A chave `"maçã"` continuou única.

O valor associado a ela mudou.

## Métodos comuns de `Map`

```java
Map<String, Integer> idades = new HashMap<>();

idades.put("Maria", 30);
idades.put("João", 25);

System.out.println(idades.get("Maria"));       // 30
System.out.println(idades.containsKey("João")); // true

idades.remove("João");

System.out.println(idades);
```

Métodos importantes:

```txt
put         -> adiciona ou substitui valor por chave
get         -> busca valor pela chave
remove      -> remove entrada pela chave
containsKey -> verifica se a chave existe
clear       -> limpa o mapa
```

## `Map` não é `Collection`

`List` e `Set` estendem `Collection`.

`Map` não estende `Collection`.

Por quê?

Porque `Map` não guarda apenas elementos.

Ele guarda pares:

```txt
chave -> valor
```

Mesmo assim, `Map` faz parte do Java Collections Framework e é usado junto com as outras estruturas o tempo todo.

## Ordem no `Map`

`HashMap` não garante ordem.

Se a ordem importar, existem outras implementações:

```txt
LinkedHashMap -> mantém ordem de inserção
TreeMap       -> ordena pelas chaves
```

Essas estruturas podem custar mais em processamento ou memória, porque manter ordem exige trabalho extra.

Regra mental:

```txt
Sem ordem -> geralmente mais simples e rápido
Com ordem -> mais controle, mas pode custar mais
```

## Qual usar primeiro?

| Necessidade | Estrutura inicial |
|---|---|
| Lista ordenada de itens | `ArrayList` |
| Evitar duplicatas | `HashSet` |
| Buscar valor por chave | `HashMap` |
| Manter ordem de inserção no mapa | `LinkedHashMap` |
| Ordenar mapa por chave | `TreeMap` |

Isso não cobre todos os casos, mas já resolve muita coisa no início.

## Armadilhas comuns

- Usar array quando precisa adicionar e remover elementos dinamicamente.
- Usar `List` esperando evitar duplicatas.
- Usar `HashSet` esperando ordem de inserção.
- Usar `HashMap` esperando ordem.
- Esquecer que `Map.put` substitui o valor quando a chave já existe.
- Confundir `contains` de coleção com `containsKey` de mapa.
- Esquecer que Collections usam generics.

## Referência mental

```txt
Collection -> grupo de elementos
List       -> sequência, permite duplicados
ArrayList  -> lista baseada em array dinâmico
Set        -> conjunto, evita duplicados
HashSet    -> set rápido, sem ordem garantida
Map        -> chave -> valor
HashMap    -> map rápido, sem ordem garantida
LinkedHashMap -> map com ordem de inserção
TreeMap    -> map ordenado por chave
```

## Por que importa no backend?

APIs, regras de negócio e persistência usam coleções o tempo todo para listar, buscar, agrupar e transformar dados.

Exemplos comuns:

```java
List<Cliente> clientes;
Set<String> permissoes;
Map<Long, Pedido> pedidosPorId;
```

Collections aparecem em:

- respostas de API;
- consultas de banco;
- filtros;
- agrupamentos;
- regras de permissão;
- processamento de eventos;
- transformação de DTOs.

## Percepções

> Arrays são importantes, mas Collections são mais flexíveis para o dia a dia.
>
> `List`, `Set` e `Map` resolvem problemas diferentes. Escolher bem evita gambiarra depois.
>
> Se a ordem importa, escolha uma implementação que garanta ordem.
