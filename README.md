# Manipulação de TADs

Projeto acadêmico desenvolvido em Java com implementação de Tipos Abstratos de Dados (TADs) fundamentais, criado como parte de uma disciplina de Estrutura de Dados do curso de Ciência da Computação na UEPB. O projeto segue princípios de metodologia ágil, com testes automatizados cobrindo as principais funcionalidades de cada estrutura.

## 📋 Sobre o projeto

O objetivo é implementar, do zero, as estruturas de dados clássicas usadas como base em ciência da computação, explorando tanto a versão com array quanto a versão encadeada de cada TAD, sempre respeitando uma interface (`IF`) que define o contrato de operações.

## 🗂️ Estruturas implementadas

- **Pilha (Stack)** — versões com array (`MinhaPilha`) e encadeada (`MinhaPilhaEncadeada`), com tratamento de pilha cheia/vazia via exceções customizadas.
- **Fila (Queue)** — versões com array (`MinhaFila`) e encadeada (`MinhaFilaEncadeada`), com tratamento de fila cheia/vazia via exceções customizadas.
- **Lista Encadeada** — implementação simples (`ListaEncadeadaImpl`) e duplamente encadeada (`ListaDuplamenteEncadeadaImpl`), com operações de busca, inserção, remoção, sucessor/predecessor e impressão em ordem direta e inversa.
- **Conjunto Dinâmico** — implementação com array (`MeuConjuntoDinamico`) e encadeada (`MeuConjuntoDinamicoEncadeado`), incluindo operações de mínimo, máximo, sucessor e predecessor.
- **Utilitários** — classe `Conversor`, responsável pela geração de arrays genéricos via reflection.

## 🛠️ Tecnologias utilizadas

- **Java** (JDK 22)
- **JUnit 5** — testes unitários automatizados
- **Eclipse IDE** — projeto configurado com `.classpath` e `.project`

## 📁 Estrutura do repositório

```
ManipulacaoTADS/
├── src/
│   ├── tad/
│   │   ├── pilha/                 # Pilha (array e encadeada)
│   │   ├── fila/                  # Fila (array e encadeada)
│   │   ├── listasEncadeadas/      # Lista simples e duplamente encadeada
│   │   ├── conjuntoDinamico/      # Conjunto dinâmico (array e encadeado)
│   │   └── util/                  # Classes utilitárias
│   └── testes/                    # Testes unitários (JUnit 5) de cada TAD
├── .classpath
└── .project
```

## ▶️ Como executar

### Pré-requisitos
- JDK 22 ou superior instalado
- Eclipse IDE (recomendado, já que o projeto está configurado para ele) ou qualquer IDE Java com suporte a JUnit 5

### Passos

1. Clone o repositório:
   ```bash
   git clone https://github.com/rui-fernando/ManipulacaoTADS.git
   ```
2. Abra o projeto no Eclipse via **File > Import > Existing Projects into Workspace**, selecionando a pasta clonada.
3. Certifique-se de que o **JUnit 5** está configurado no classpath (o projeto já referencia `org.eclipse.jdt.junit.JUNIT_CONTAINER/5`).
4. Para rodar os testes, clique com o botão direito em qualquer classe da pasta `src/testes` e selecione **Run As > JUnit Test**.

## ✅ Testes

Cada TAD possui uma classe de teste correspondente na pasta `src/testes`, cobrindo casos de uso comuns e situações de borda (estruturas vazias, estruturas cheias, exceções esperadas), por exemplo:

- `TestaPilha`
- `TestaFila`
- `TestaListaEncadeada`
- `TestaListaDuplamenteEncadeada`
- `TestaConjuntoDinamico`
- `TestaConjuntoDinamicoEncadeado`

## 👤 Autor

Desenvolvido por [Rui Fernando](https://github.com/rui-fernando), estudante de Ciência da Computação na Universidade Estadual da Paraíba (UEPB).
