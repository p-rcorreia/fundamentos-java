# 22 - Entrada e Saída

## Objetivo

Entender como o Java lida com operações de entrada e saída de dados, principalmente leitura e gravação de arquivos e comunicação por rede.

## Checklist

- [x] Conceito de input e output
- [x] Fluxos de entrada e saída
- [x] Conversão de inteiros para caracteres
- [x] Noção de tabela Unicode
- [x] Leitura de arquivos
- [x] Escrita de arquivos
- [x] API IO clássica
- [x] API NIO
- [ ] Noção de AIO
- [ ] Canais
- [ ] Buffers
- [ ] Comunicação entre servidores, noção inicial
- [ ] Sockets, noção inicial
- [ ] Boas práticas com arquivos
- [ ] Armadilhas comuns em entrada e saída

## Por que importa no backend?

Operações de entrada e saída continuam muito presentes no mercado.

Mesmo em sistemas modernos com APIs, bancos de dados e mensageria, ainda é comum trabalhar com:

- leitura e geração de arquivos;
- integração com sistemas legados;
- arquivos de bancos, empresas e órgãos externos;
- logs;
- relatórios;
- importação e exportação de dados;
- comunicação entre sistemas;
- persistência simples de objetos ou dados.

Grandes empresas, bancos, bolsas de valores e sistemas corporativos ainda dependem bastante de arquivos e fluxos de dados.

## Input e output

**Input** significa entrada de dados.

**Output** significa saída de dados.

Em Java, entrada e saída aparecem quando precisamos ler ou escrever dados em algum lugar.

Exemplos:

- ler um arquivo;
- gravar um arquivo;
- receber dados do teclado;
- enviar dados para a tela;
- comunicar dois servidores;
- transmitir dados pela rede;
- salvar dados em arquivo.

## A ideia de fluxo

Uma forma simples de imaginar entrada e saída é pensar em um cano conectado a um balde.

O cano representa o **fluxo**.

O balde representa o destino ou a origem dos dados, como um arquivo, teclado, tela ou rede.

Quando escrevemos dados, colocamos dados no fluxo para que eles cheguem ao destino.

Quando lemos dados, puxamos dados do fluxo a partir de uma origem.

Em programação, esses fluxos permitem ler e escrever dados em arquivos, teclado, redes e outros dispositivos.

## Conversão de inteiros para caracteres

Antes de ler arquivos caractere por caractere, é importante entender que um caractere também pode ser representado por um número.

Java usa Unicode para representar caracteres.

Exemplo:

```java
public class Saudacao {
    public static void main(String[] args) {
        int num1 = 79;
        int num2 = 108;
        int num3 = 225;

        char letra1 = (char) num1; // 'O'
        char letra2 = (char) num2; // 'l'
        char letra3 = (char) num3; // 'á'

        System.out.println("Saudação: " + letra1 + letra2 + letra3);
    }
}
```

Saída:

```txt
Saudação: Olá
```

Nesse exemplo:

- `79` corresponde ao caractere `O`;
- `108` corresponde ao caractere `l`;
- `225` corresponde ao caractere `á`;
- `(char)` faz a conversão explícita do número para caractere.

Isso ajuda a entender o método `read()`, porque ele lê um caractere do arquivo, mas retorna um `int`.

## IO clássico

A API clássica de IO trabalha com fluxos de entrada e saída.

Ela existe desde as primeiras versões do Java e é muito usada para operações básicas de arquivos.

Exemplos de classes comuns:

- `File`;
- `FileInputStream`;
- `FileOutputStream`;
- `FileReader`;
- `FileWriter`;
- `BufferedReader`;
- `BufferedWriter`.

A ideia principal é abrir um fluxo, ler ou escrever dados e depois fechar o recurso.

## Escrevendo e lendo um arquivo

O exemplo abaixo grava o texto `Olá Mundo!` em um arquivo chamado `meuArquivo.txt` e depois lê esse mesmo arquivo caractere por caractere.

```java
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ExemploIO {
    public static void main(String[] args) {
        try {
            // Escrevendo em um arquivo.
            FileWriter writer = new FileWriter("meuArquivo.txt");
            writer.write("Olá Mundo!");
            writer.close();

            // Lendo o arquivo caractere por caractere.
            FileReader reader = new FileReader("meuArquivo.txt");
            int data = reader.read();

            while (data != -1) {
                System.out.print((char) data);
                data = reader.read();
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Algo deu errado ao tentar escrever ou ler um arquivo. " + e.getMessage());
        }
    }
}
```

Saída esperada:

```txt
Olá Mundo!
```

## `FileWriter`

`FileWriter` é usado para escrever texto em um arquivo.

```java
FileWriter writer = new FileWriter("meuArquivo.txt");
writer.write("Olá Mundo!");
writer.close();
```

Nessa parte:

- `new FileWriter("meuArquivo.txt")` cria um fluxo de escrita para o arquivo;
- `write(...)` grava o texto no arquivo;
- `close()` fecha o fluxo.

Fechar o fluxo é importante porque libera o recurso usado para comunicação com o arquivo.

Usando a analogia anterior: é como fechar a torneira depois de terminar de enviar a água pelo cano.

## `FileReader`

`FileReader` é usado para ler texto de um arquivo.

```java
FileReader reader = new FileReader("meuArquivo.txt");
int data = reader.read();
```

O método `read()` retorna um `int`.

Esse número representa o caractere lido na tabela Unicode.

Por exemplo, a letra `O` pode aparecer como `79`.

Para imprimir o caractere correspondente, fazemos um casting para `char`:

```java
System.out.print((char) data);
```

## O papel do `-1`

Quando `read()` chega ao final do arquivo, ele retorna `-1`.

Por isso o laço usa esta condição:

```java
while (data != -1) {
    System.out.print((char) data);
    data = reader.read();
}
```

Enquanto `data` for diferente de `-1`, ainda existe caractere para ler.

Quando `data` vira `-1`, significa que o arquivo acabou.

## `print` em vez de `println`

No exemplo, usamos:

```java
System.out.print((char) data);
```

Não usamos `println`, porque `println` pula uma linha a cada impressão.

Como a leitura acontece caractere por caractere, `println` imprimiria uma letra por linha.

Com `print`, os caracteres aparecem lado a lado, formando o texto original.

## Tratamento de exceções

Operações com arquivos podem falhar.

Exemplos:

- o arquivo pode não existir;
- o programa pode não ter permissão para ler ou escrever;
- o caminho pode estar errado;
- outro processo pode estar usando o arquivo;
- o disco pode ter algum problema.

Por isso usamos `try/catch` com `IOException`.

```java
try {
    // operações de arquivo
} catch (IOException e) {
    System.out.println("Algo deu errado ao tentar escrever ou ler um arquivo. " + e.getMessage());
}
```

## Observação sobre IO, NIO e AIO

Este exemplo usa a API clássica de IO, do pacote `java.io`.

As classes `FileWriter`, `FileReader` e `IOException` pertencem a essa API.

NIO e AIO são APIs diferentes:

- IO clássico trabalha com fluxos;
- NIO trabalha com canais, buffers, `Path` e `Files`;
- AIO trabalha com operações assíncronas.

## NIO

NIO significa **New IO**.

É uma API mais moderna para trabalhar com entrada e saída.

Ela usa conceitos como:

- canais;
- buffers;
- caminhos com `Path`;
- utilitários com `Files`.

Uma analogia simples:

- canais são como canos mais flexíveis;
- buffers são recipientes temporários para armazenar dados antes da transferência final.

NIO costuma oferecer mais flexibilidade e pode ser mais adequada para operações mais modernas com arquivos e comunicação.

## Escrevendo e lendo com NIO

Com NIO, o mesmo exemplo de escrita e leitura pode ficar mais direto.

Em vez de abrir manualmente um `FileWriter`, escrever, fechar, abrir um `FileReader`, ler caractere por caractere e fechar novamente, podemos usar a classe `Files`.

```java
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExemploNIO {

    public static void main(String[] args) {

        Path path = Paths.get("diretorio", "meuArquivoNIO.txt");

        try {

            // Escrevendo em um arquivo
            Files.write(path, "Olá Mundo NIO!".getBytes(StandardCharsets.UTF_8));

            // Lendo de um arquivo
            byte[] bytes = Files.readAllBytes(path);

            String content = new String(bytes, StandardCharsets.UTF_8);

            System.out.println(content);

        } catch (IOException e) {
            System.out.println("Problemas de IO: " + e.getMessage());
        }

    }

}
```

Saída esperada:

```txt
Olá Mundo NIO!
```

Nesse exemplo:

- `Path` representa o caminho do arquivo;
- `Paths.get("diretorio", "meuArquivoNIO.txt")` monta o caminho para o arquivo dentro da pasta `diretorio`;
- `Files.write(...)` escreve os bytes no arquivo;
- `Files.readAllBytes(...)` lê todos os bytes do arquivo;
- `new String(bytes, StandardCharsets.UTF_8)` transforma os bytes lidos de volta em texto.

Usar `Paths.get("diretorio", "meuArquivoNIO.txt")` evita escrever barras manualmente no caminho.

Isso deixa o código mais portátil, porque o Java monta o caminho considerando o sistema operacional em que o programa está rodando.

## Caminhos de arquivos

Quando usamos `java.io` com uma string direta, é comum aparecerem caminhos assim no Windows:

```java
"diretorio\\meuArquivo.txt"
```

A barra invertida precisa ser duplicada porque `\` tem significado especial dentro de strings Java.

Outra opção é usar barra normal:

```java
"diretorio/meuArquivo.txt"
```

Com NIO, a forma abaixo costuma ser mais clara:

```java
Paths.get("diretorio", "meuArquivoNIO.txt");
```

Assim, cada parte do caminho é passada separadamente.

## Por que não chamamos `close()`?

No exemplo com `FileWriter` e `FileReader`, precisamos fechar os objetos depois do uso:

```java
writer.close();
reader.close();
```

Isso libera os recursos usados para comunicação com o arquivo.

No exemplo com `Files.write` e `Files.readAllBytes`, não chamamos `close()` diretamente porque esses métodos utilitários cuidam da abertura e do fechamento dos recursos internamente.

Um ponto importante: isso não quer dizer que toda operação de NIO seja sempre não bloqueante.

Operações simples de arquivo, como `Files.write` e `Files.readAllBytes`, ainda podem esperar o sistema operacional concluir a leitura ou a escrita.

A diferença prática neste exemplo é que a API deixa o código mais curto e cuida dos detalhes de abertura e fechamento para nós.

## AIO

AIO está relacionado a operações assíncronas de entrada e saída.

Em vez de bloquear o programa esperando uma operação terminar, a ideia é permitir que algumas operações aconteçam de forma assíncrona.

Esse é um assunto mais avançado, mas faz parte da evolução do IO no Java.

Nesta etapa, o foco inicial é entender primeiro arquivos, fluxos, canais e buffers.

## Comunicação entre sistemas

Entrada e saída não servem apenas para arquivos.

Esses conceitos também aparecem em comunicação entre aplicações, inclusive comunicação entre servidores.

Mais adiante, isso se conecta com:

- sockets;
- protocolos de comunicação;
- APIs;
- integração entre sistemas.

Nesta seção, o foco principal será a base: arquivos, fluxos, leitura, gravação e noções iniciais de comunicação.

## Ponto de atenção

Este é um capítulo mais denso.

Entrada e saída exige cuidado porque envolve recursos externos ao programa, como arquivos, rede e sistema operacional.

Alguns pontos importantes:

- sempre fechar recursos quando necessário;
- tratar exceções;
- cuidar de caminhos de arquivos;
- evitar sobrescrever dados por acidente;
- entender a diferença entre texto e bytes;
- saber quando usar IO clássico ou NIO.

O melhor caminho é implementar o exemplo como foi mostrado, executar, observar o resultado e depois modificar pequenos detalhes para praticar.

## Percepções

> Registrar aprendizados conforme o estudo avançar.
