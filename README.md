# Projeto de Testes Automatizados com Selenium e JUnit

Este projeto consiste em uma suíte de testes automatizados para ambiente web desenvolvida em Java, utilizando o framework **Selenium WebDriver** para a automação dos testes e o **JUnit** como framework de testes e asserções.

## Tecnologias Utilizadas

* **Java **
* **Selenium WebDriver** (Automação de navegador)
* **JUnit** (Framework de testes)
* **Maven** (Gerenciamento de dependências e build)

## Estrutura de Pastas

A estrutura do projeto segue o padrão Maven, organizada da seguinte forma:

* `src/test/java/testeselenium.pageObject`: Contém as classes que representam as páginas web (Page Objects), responsáveis pelo mapeamento dos elementos e interações (ex: `BasePO.java`, `DuckPO.java`, `LoginPO.java`).
* `src/test/java/testeselenium.test`: Contém as classes de testes que executam os cenários planejados e realizam as validações (ex: `LoginTest.java`, `DuckFirstTest.java` e evoluções de refatoração).
* `src/test/resources`: Armazena recursos de teste, como os executáveis de drivers de navegadores (`chromedriver.exe`).
* `pom.xml`: Arquivo de configuração do Maven contendo as dependências do Selenium, JUnit e plugins associados.

## Pré-requisitos

Antes de iniciar, certifique-se de ter instalado em sua máquina:
* Java Development Kit
* Apache Maven
* Navegador Google Chrome compatível com a versão do `chromedriver.exe` incluído no projeto
