# 09 - Stream API

## Objetivo

Usar Stream API para filtrar, transformar, ordenar, combinar e coletar dados de coleções com código expressivo.

## Checklist

- [ ] Stream API
- [ ] `stream()`
- [ ] `filter`
- [ ] `map`
- [ ] `reduce`
- [ ] `collect`
- [ ] `toList`
- [ ] `forEach`
- [ ] `sorted`
- [ ] `distinct`
- [ ] `anyMatch`
- [ ] `allMatch`
- [ ] Operações intermediárias
- [ ] Operações terminais
- [ ] Quando usar stream
- [ ] Quando evitar stream para não piorar legibilidade

## Por que importa no backend?

Streams ajudam a transformar listas de entidades, DTOs e resultados de regras de negócio.

Em projetos backend, é comum buscar uma lista de dados e precisar filtrar, converter, ordenar ou montar uma resposta.

## Primeiro exemplo

Com loop tradicional:

```java
List<Integer> numerosPares = new ArrayList<>();

for (Integer numero : numeros) {
    if (numero % 2 == 0) {
        numerosPares.add(numero);
    }
}
```

Com Stream API:

```java
List<Integer> numerosPares = numeros.stream()
        .filter(numero -> numero % 2 == 0)
        .toList();
```

Nesse exemplo:

- `stream()` cria um fluxo a partir da lista;
- `filter(...)` mantém apenas os números pares;
- `toList()` transforma o resultado em uma nova lista.

## Ponto de atenção

Stream API é poderosa, mas não deve ser usada só para parecer código moderno.

Se a operação ficar difícil de entender, um `for` tradicional pode ser mais claro.

## Percepções

> Registrar aprendizados conforme o estudo avançar.
