# Sudoku-DIO

Este é um projeto de Sudoku desenvolvido com base no curso da DIO em Java Cloud Native.

## 🚀 Como Rodar o Projeto

### 🔧 Pré-requisitos

Antes de executar o projeto, certifique-se de ter instalado:

- [Java JDK 8+](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Git](https://git-scm.com/)

### 👅 Clonar o Repositório

Abra um terminal e execute o seguinte comando:
```
git clone https://github.com/Gabriel-Farias-06/sudoku-dio.git
```
### 📂 Navegar até a pasta do projeto
```
cd sudoku-dio
```

### 🏰️ Compilar o Projeto
```
javac -d bin -sourcepath src src/ui/TelaInicial.java
```
Isso compilará o código-fonte e colocará os arquivos `.class` na pasta `bin`.

### ▶️ Executar o Sudoku

Se compilou com `javac`:

```
  java -cp bin TelaInicial
```
Se estiver usando um **IDE** como Eclipse ou IntelliJ, basta abrir o projeto e executar a classe `TelaInicial.java`.

### 🛠️ Possíveis Problemas

- Se ocorrer erro de **classe não encontrada**, verifique se a estrutura de pacotes está correta e tente rodar com o nome completo do pacote, por exemplo:
```
  java -cp bin src.ui.TelaInicial
```
---
