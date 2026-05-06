# 16 - JVM

## Objetivo

Entender o papel da JVM na execução de programas Java e por que ela torna o código Java portável entre diferentes sistemas operacionais.

## Checklist

- [x] O que é JVM
- [x] JDK vs JRE vs JVM
- [x] Bytecode
- [x] Garbage Collector
- [ ] Heap
- [ ] Stack
- [ ] Classpath
- [x] Noção de memória
- [x] Noção de performance
- [x] Como uma aplicação Java executa
- [x] Portabilidade: escreva uma vez, execute em qualquer lugar
- [x] Compatibilidade da JVM com cada sistema operacional

## O que é a JVM?

JVM significa **Java Virtual Machine**, ou **Máquina Virtual Java**.

Uma forma simples de entender a JVM é pensar nela como um tradutor. Se uma pessoa fala português e outra fala japonês, elas precisam de alguém que traduza a comunicação entre as duas.

No mundo da programação, a JVM faz esse papel: ela ajuda o código Java a conversar com o computador.

## Como ela funciona?

O código Java não é executado diretamente pelo computador do mesmo jeito que foi escrito pelo programador.

De forma simplificada, o fluxo é:

```txt
código Java -> bytecode -> JVM -> linguagem que o computador entende
```

O compilador Java transforma o código-fonte em bytecode, e a JVM entende esse bytecode para executar o programa no sistema operacional.

## Portabilidade

Uma das ideias mais importantes do Java é:

```txt
escreva uma vez, execute em qualquer lugar
```

Isso significa que você pode escrever o código Java uma vez e executar esse mesmo código em diferentes ambientes, como:

- Windows;
- macOS;
- Linux.

Essa portabilidade existe porque quem lida com as diferenças entre os sistemas operacionais é a JVM.

## Compatibilidade da JVM

Apesar de o código Java ser portável, a JVM em si precisa ser específica para cada sistema operacional.

Por exemplo:

- em um computador Windows, você instala uma JVM compatível com Windows;
- em um Mac, você instala uma JVM compatível com macOS;
- em Linux, você instala uma JVM compatível com a distribuição usada.

Ou seja: o código Java pode ser o mesmo, mas a JVM instalada precisa conversar corretamente com o sistema onde o programa será executado.

## JDK vs JRE vs JVM

Esses três termos aparecem muito quando se fala de Java:

- **JVM**: é a máquina virtual Java. Ela executa o bytecode Java no sistema operacional.
- **JRE**: significa **Java Runtime Environment**. É o ambiente necessário para executar programas Java.
- **JDK**: significa **Java Development Kit**. É o kit necessário para desenvolver programas Java.

Uma forma simples de pensar:

```txt
JDK = ferramentas de desenvolvimento + JRE
JRE = bibliotecas para execução + JVM
JVM = máquina virtual que executa o bytecode
```

## JRE

O **JRE** é como uma caixa de ferramentas para executar programas Java.

Ele contém a JVM e as bibliotecas necessárias para que um programa Java funcione corretamente.

Se você quer apenas executar um programa Java já pronto, o JRE é suficiente.

## JDK

O **JDK** é como uma caixa de ferramentas mais completa, voltada para quem vai construir programas Java.

Além de tudo que existe no JRE, o JDK traz ferramentas usadas por programadores para escrever, compilar, testar e executar seus próprios programas Java.

Se você quer desenvolver uma aplicação Java, precisa do JDK.

Em resumo:

```txt
executar programa Java pronto -> JRE
desenvolver programa Java -> JDK
```

## Garbage Collector

O **Garbage Collector**, também chamado de **GC** ou **coletor de lixo**, é a parte da JVM responsável por encontrar objetos que não são mais necessários e liberar o espaço de memória ocupado por eles.

Uma forma simples de entender isso é imaginar uma mesa cheia de recortes de papel em uma aula de educação artística. Enquanto você trabalha, pedaços de papel que não servem mais vão se acumulando. Depois de um tempo, eles começam a atrapalhar.

O Garbage Collector é como um ajudante que limpa a mesa automaticamente, removendo aquilo que não está mais sendo usado.

## Como o GC atua na memória?

Durante a execução de um programa Java, muitos objetos são criados. Alguns continuam sendo usados pela aplicação; outros deixam de ser necessários depois de um tempo.

O GC procura esses objetos inúteis e libera a memória ocupada por eles, permitindo que o programa continue funcionando sem desperdiçar recursos.

Essa limpeza acontece automaticamente. O programador não precisa mandar a JVM remover cada objeto manualmente.

## JVM e Garbage Collector

A JVM e o Garbage Collector trabalham juntos para executar programas Java de maneira eficiente.

Uma analogia útil:

- a JVM é como o motor do carro, responsável por fazer o programa funcionar;
- o GC é como o sistema de limpeza, removendo objetos que não são mais necessários e poderiam atrapalhar o desempenho.

Essa parceria ajuda o programa a continuar executando de forma mais estável, independentemente do sistema operacional ou dispositivo usado.

## Exemplo de objetos que podem ser coletados

Imagine que uma aplicação carrega algumas configurações durante a inicialização, como preferências visuais do usuário ou organização inicial de itens na tela.

Depois que essas configurações são carregadas e aplicadas, alguns objetos temporários usados nesse processo podem não ser mais necessários.

Nesse caso, o Garbage Collector pode remover esses objetos da memória, liberando espaço para outras partes da aplicação.

## Por que isso é importante?

Se objetos desnecessários se acumulam demais na memória, a aplicação pode ficar lenta ou até parar de funcionar por falta de espaço.

Por exemplo: se uma aplicação tem um limite de memória de 2 GB e esse espaço é preenchido por muitos objetos que não são mais úteis, a JVM pode não conseguir continuar criando novos objetos. Em situações assim, a aplicação pode travar ou falhar.

O Garbage Collector reduz esse risco ao liberar automaticamente memória que não está mais em uso.

## Por que importa no backend?

Aplicações backend Java rodam em cima da JVM. Entender esse papel ajuda a compreender execução, compatibilidade entre ambientes, deploy, uso de memória, performance, consumo de recursos e investigação de problemas em produção.

## Percepções

> A JVM funciona como uma camada entre o código Java e o computador. O Java ganha portabilidade porque cada sistema operacional tem sua própria JVM, capaz de executar o mesmo programa Java naquele ambiente.
>
> O Garbage Collector complementa esse trabalho limpando automaticamente objetos que não são mais necessários, ajudando a aplicação a usar memória de forma mais eficiente.
