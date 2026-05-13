# 19 - Compilação e execução

## Objetivo

Entender o caminho do código-fonte Java até a aplicação rodando, passando pela compilação, pelo bytecode e pela execução na JVM.

## Checklist

- [x] Arquivo `.java`
- [x] Compilador `javac`
- [x] Bytecode
- [x] Arquivo `.class`
- [ ] Execução com `java`
- [ ] Classpath
- [ ] JAR
- [ ] Fat JAR
- [ ] Build com Maven
- [ ] Build com Gradle, noção
- [ ] Compilação vs empacotamento
- [x] Tempo de compilação vs tempo de execução
- [ ] Erros de compilação
- [ ] Erros de runtime
- [ ] Como o Spring Boot inicia

## Compilação

Em Java, **compilação** é o processo de transformar o código que você escreve, chamado de **código-fonte**, em um formato que possa ser executado.

Em muitas linguagens, a compilação transforma o código diretamente em código de máquina, também chamado de código binário. No Java, o processo é um pouco diferente.

Quando um programa Java é compilado, ele não vira código de máquina diretamente. Em vez disso, ele é transformado em um formato intermediário chamado **bytecode**.

## Bytecode

O **bytecode** é como um idioma universal para programas Java.

Ele não depende diretamente de Windows, macOS, Linux ou de um tipo específico de hardware. O mesmo bytecode pode ser executado em ambientes diferentes, desde que exista uma JVM instalada naquele ambiente.

Uma forma simples de pensar nisso:

```txt
código-fonte Java -> compilador Java -> bytecode -> JVM -> execução no sistema operacional
```

O compilador Java pega o código escrito pelo programador e gera bytecode. Depois, a JVM entende esse bytecode e executa o programa.

## O arquivo `.class`

Durante a compilação, o compilador Java gera um arquivo com extensão `.class`.

Esse arquivo contém o bytecode do programa. Ele funciona como um pacote com as instruções necessárias para a JVM carregar e executar o código.

Por exemplo:

```txt
Programa.java -> Programa.class
```

O arquivo `.java` contém o código-fonte escrito pelo programador. O arquivo `.class` contém o bytecode gerado pela compilação.

## Por que isso ajuda na portabilidade?

Imagine uma pessoa viajando por vários países. Cada país tem sua própria língua, então seria difícil aprender todas elas. Seria muito mais simples se existisse um idioma intermediário que todos conseguissem entender.

No Java, o bytecode cumpre esse papel.

O programador escreve Java uma vez, o compilador transforma em bytecode, e cada sistema operacional usa sua JVM específica para executar esse bytecode.

Por isso o Java é conhecido pela ideia:

```txt
escreva uma vez, execute em qualquer lugar
```

## Por que importa no backend?

Todo projeto backend Java precisa ser compilado, empacotado, executado e entregue em algum ambiente. Entender a diferença entre código-fonte, bytecode, arquivo `.class` e JVM ajuda a compreender build, deploy e problemas de execução.

## Percepções

> O Java não compila diretamente para o sistema operacional. Ele gera bytecode em arquivos `.class`, e a JVM instalada em cada ambiente executa esse bytecode.
