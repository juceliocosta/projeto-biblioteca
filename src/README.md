# Compilar e Executar um Projeto Maven

## 1.  Acessar o Diretório do Projeto
   Navegue até a pasta raiz do projeto, ex.:

```Bash
cd ~/Área\ de\ trabalho/ProjetoBiblioteca
```
## 2. Compilar e Gerar as Classes
   Use o Maven para baixar as dependências e compilar todo o código-fonte (.java) em arquivos .class. Isso garante que a pasta target/classes seja criada e preenchida.

```Bash
mvn install
```

## 3. Executar o Programa
- Se estiver na pasta raiz do projeto:

```Bash
java -cp target/classes StartApp
```

- Se não estiver na raiz do projeto, percorra o caminho e o execute, ex.:

```Bash
java -cp ./Área\ de\ trabalho/ProjetoBiblioteca/target/classes StartApp
```
