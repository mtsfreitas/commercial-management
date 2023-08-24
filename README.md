# commercial-management

O objetivo deste projeto é o desenvolvimento de um sistema de gestão comercial de uma loja. O sistema possui as seguintes funcionalidades: Cadastramento de produtos, cadastramento de clientes, cadastramento de vendas, alteração de estoque, alteração de dados dos clientes, alteração do status de uma venda, listagem de produtos, listagem de clientes e listagem de vendas.

## Implementação 
Foi seguido o padrão de software (MVC) Model-View-Controller, que isola as regras de negócios da lógica de apresentação, a interface com o usuário. Possibilitando a divisão do projeto em camadas muito bem definidas para suas classes

![image](https://github.com/mtsfreitas/commercial-management/assets/21324690/a56c71ed-7976-42a6-80f1-765a5f686084)

**gestaocomercial.controller:** É responsável por interpretar as ações de entrada através do mouse e teclado realizadas pelo usuário. O Controle (Controller) envia essas ações para o Modelo (Model) e para a janela de visualização (View) onde serão realizadas as operações necessárias.

**gestaocomercial.model:** É o coração da execução, responsável por tudo que a aplicação vai fazer a partir dos comandos da camada de controle em um ou mais elementos de dados, respondendo a perguntas sobre o sua condição e a instruções para mudá-las.

**gestaocomercial.view:** Não se dedica em saber como o conhecimento foi retirado ou de onde ela foi obtida, apenas trata da exibição na interface do usuário. gestaocomercial: Contém a classe principal com o método main para chamar a interface gráfica e alguns testes de inserções.

## Decisões de projeto 
Certos atributos foram incluídos para fazer sentido a aplicação, sendo uma delas o atributo “Saldo” para um cliente, e “Preço” para um produto.

## Funcionamento do software
### Produto
![image](https://github.com/mtsfreitas/commercial-management/assets/21324690/a32a7998-3d16-4338-ab0b-1c15e818ce1d)
![image](https://github.com/mtsfreitas/commercial-management/assets/21324690/8185718e-a80d-430c-a0ae-96c7caccd204)
![image](https://github.com/mtsfreitas/commercial-management/assets/21324690/b0516818-e9b6-4060-9492-8a7e4e443baa)
![image](https://github.com/mtsfreitas/commercial-management/assets/21324690/a61ea1f4-3393-451b-ae39-aee982f72555)
![image](https://github.com/mtsfreitas/commercial-management/assets/21324690/fbcc5e98-19f5-4e91-b177-6c1d86e89fae)

### Venda 
![image](https://github.com/mtsfreitas/commercial-management/assets/21324690/f778c978-7910-49c6-ae9e-31d7f0371aab)
![image](https://github.com/mtsfreitas/commercial-management/assets/21324690/7ff797ee-18c7-4098-aeba-09a75cdfce7c)
![image](https://github.com/mtsfreitas/commercial-management/assets/21324690/5e266e04-db86-4a3d-b848-5d8a5b9009ac)
![image](https://github.com/mtsfreitas/commercial-management/assets/21324690/9a921ef4-7f2c-4241-8092-d02ff296c4d5)

### Cliente 
![image](https://github.com/mtsfreitas/commercial-management/assets/21324690/02746c2a-a416-4a75-888f-5fda8d6cc785)
![image](https://github.com/mtsfreitas/commercial-management/assets/21324690/91504eb4-a34b-4f21-8adc-bd07056631fe)
![image](https://github.com/mtsfreitas/commercial-management/assets/21324690/0ff64448-0a08-4f76-908a-c042e75dcc84)

## Considerações 
O desenvolvimento do software na linguagem Java, utilizando a orientação objetos, possui seus pacotes organizados pelo padrão MVC (modelo, visão, controle) e uma interface gráfica funcional e amigável para o uso, inclui também o tratamento de possíveis erros que um determinado usuário possa eventualmente cometer através de try-catch e if-else.
