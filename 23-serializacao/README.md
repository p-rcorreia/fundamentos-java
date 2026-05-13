# 23 - Serialização

## Objetivo

Entender como a serialização permite transformar objetos Java em dados que podem ser salvos em arquivos, transmitidos pela rede e reconstruídos posteriormente.

## Checklist

- [ ] Conceito de serialização
- [ ] Conceito de desserialização
- [ ] Interface `Serializable`
- [ ] Persistência de objetos em arquivo
- [ ] Serialização de listas
- [ ] `ObjectOutputStream`
- [ ] `ObjectInputStream`
- [ ] `serialVersionUID`
- [ ] Limitações da serialização
- [ ] Quando usar serialização
- [ ] Quando preferir banco de dados
- [ ] Cuidados com segurança
- [ ] Armadilhas comuns

## Por que estudar serialização?

Serialização é um tema mais avançado, mas muito interessante.

Com ela, conseguimos pegar um objeto que está na memória do computador e guardar esse objeto em um arquivo.

Isso permite persistir dados sem precisar, em alguns casos simples, configurar um banco de dados completo.

Exemplos:

- salvar configurações de um aplicativo;
- guardar dados temporários;
- salvar o estado de um jogo;
- criar cache simples;
- armazenar uma lista de tarefas localmente;
- transmitir objetos entre sistemas.

## Serialização e banco de dados

Serialização pode ser uma alternativa simples em cenários pequenos e controlados.

Mas ela não substitui um banco de dados em qualquer situação.

Bancos de dados continuam sendo mais adequados quando precisamos de:

- consultas complexas;
- filtros;
- relatórios;
- controle de concorrência;
- segurança mais forte;
- integridade dos dados;
- muitos usuários acessando e alterando informações.

Então a ideia não é trocar banco de dados por serialização sempre.

A ideia é entender que serialização existe, tem usos reais e pode ser uma solução leve quando o problema é pequeno.

## Percepções

> Registrar aprendizados conforme o estudo avançar.
