# **GFF Gerenciador de Fast Food**

## **Sistema de gerenciamento de Fast Food**

O sistema de gerenciamento de fast food tem como objetivo facilitar o controle de pedidos, fazendo com que dessa forma o atendimento seja mais eficiente, organizado e evitando confusões entre os pedidos que podem levar não somente a perca do produto como também um atraso na fabricação e entrega ao cliente final.

<br>

## **Índice**
1. [Funções do Sistema](#Funções%20do%20Sistema)
2. [Cadastrar Cliente](#Cadastro%20de%20Cliente)
3. [Cadastrar Cliente - Função Cadastrar Cliente](#Função%20Cadastrar%20Cliente)
4. [Produtos](#Produtos)
5. [Produtos - Função Consultar Produto](#Função%20Consultar%20Produto)
- 5.1 [Exemplos da função consultar produto](#Exemplos%20da%20função%20consultar%20produto)
6. [Produtos - Função Cadastrar Produto](#Função%20Cadastrar%20Produto)
- 6.1 [Exemplos da função cadastrar produto](#Exemplos%20da%20função%20cadastrar%20produto)
7. [Produtos - Função Listar Produto](#Função%20Listar%20Produtos)
- 7.1 [Exemplos da função listar produtos](#Exemplos%20da%20função%20listar%20produtos)
8. [Produtos - Função Deletar Produto](#Função%20Deletar%20Produto)
- 8.1 [Exemplos da função deletar produto](#Exemplos%20da%20função%20deletar%20produto)
9. [Produtos - Função Atualizar Produto](#Função%20Atualizar%20Produto)
- 9.1 [Exemplos da função atualizar produto](#Exemplos%20da%20função%20atualizar%20produto)
10. [Função Forma de Pagemento](#Função%20Forma%20de%20Pagamento)
- 10.1 [Exemplos da função forma de pagamento](#Exemplos%20da%20função%20de%20pagamento)
11. [Função Acompanhamento do Pedido](#Função%20Acompanhamento%20do%20Pedido)
- 11.1 [Exemplos da função acompanhamento do pedido](#Exemplos%20da%20função%20acompanhamento%20do%20pedido)


<br>

## **Funções do sistema**

O sistema é composto por diversas funções como exemplo:
- Cadastrar Cliente
- Produtos
- Pedidos

Abaixo seram descritas as fucionalidades das funções do sistema assim como algum exemplos de utilização dos mesmos.

<br>

## **Cadastrar Cliente**

<br>

| Função | Responsabilidade da função | Método | Parâmetro (s) | Rota |
|--- |--- |--- |--- |--- |
| Consultar Cliente | Retornar o produto especificado na busca | POST | {cpf} {nome} {email} | /cliente/cadastro |

O cadastro de cliente tem como objetivo facilitar o cadastro do cliente no sistema de forma que o cadastro possa ser realizado por uma das seguintes formas:
- Via CPF
- Nome e e-mail

>**Observação**:
>
> O cadastro do cliente não é obrigatório e por tanto o cliente pode solicitar o pedido normalmente precisando apenas informar o nome para que o pedido seja entregue corretamente ao respectivo cliente.

<br>

### **Função Cadastrar Cliente**

A função cadastrar cliente tem como objetivo adicionar um novo cliente na base de dados, facilitando assim sua identificação e a lista de consumo do mesmo.

```bash
Se o parâmetro cpf ou os parâmetros nome e e-mail forem informados (obrigatório para a execução da função) na requsição
    Executar criação de um novo cliente no banco de dados passando os dados informados na requisição na tabela XYZ
    Se a inserção do cliente for efetuada com sucesso
        retornar HTTP 201 sem corpo de resposta
    Senão
        retornar HTTP 550 com corpo de resposta exibindo a mensagem "Erro genérico. Por favor tente novamente mais tarde."
    Fimse
Senão
    retornar HTTP 400 com o corpo exibindo a mensagem "Parâmetro(s) inválido(s) para cadastro"
Fimse
```
<br>

### **Exemplos da função cadastrar cliente**

```bash
curl
```

(anexar imagem aqui)

<br>
<br>

## **Produtos**

O produto tem como objetivo consultar, cadastrar, listar, deletar e atualizar os produtos oferecidos aos clientes, cada qual com sua função como demonstradas na tabela abaixo:

<br>

| Função | Responsabilidade da função | Método | Parâmetro (s) | Rota |
|--- |--- |--- |--- |--- |
| Consultar Produto | Retornar o produto especificado na busca | GET | {id} | /produto/busca/{id} |
| Cadastrar Produto | Efetuar o cadastro de um novo produto | POST | {id} {estoque} {nome} {descrição} | /produto/cadastro |
| Listar Produtos | Retorna a lista dos produtos existentes | GET | {id} | /produto/lista/produto |
| Deletar Produto | Efetuar a deleção do produto especificado | DEL | {id} | /produto/remove/{id} |
| Atualizar Produto | Efetuar edição em um produto especificado | PUT | {id} | /produto/edita/{id} |

<br>
<br>

## **Função Consultar Produto**

A função consultar produto tem como objetivo informar ao cliente sobre o item informado para a busca.

```bash
Se o parâmetro id informado (obrigatório para a execução da função) na requsição
    Executar busca pelo parâmetro informado no banco de dados na tabela XYZ.
    Se existir informações do parâmetro
        retornar HTTP 200 com corpo de resposta contendo nome e descrição referêntes ao parâmtro informado.
    Senão
        retornar HTTP 204 sem corpo de resposta.
    Fimse
Senão
    retornar HTTP 400 com o corpo exibindo a mensagem "Parâmetro inválido para a consulta."
Fimse
```

<br>

### **Exemplos da função consultar produto**

```bash
curl
```

(anexar imagem aqui)

<br>
<br>

## **Função Cadastrar Produto**

A função cadastrar produto tem como objetivo adicionar um novo cliente na base de dados, facilitando assim sua identificação e a lista de consumo do mesmo.

```bash
Se os parâmetros id, nome, estoque e descrição e imagem forem informados (obrigatório para a execução da função) no corpo da requsição
    Executar conexão com o banco de dados
    Se a conexão for estabelecida com sucesso
        Executar a criação de um novo produto no banco de dados passando os dados informados na requisição na tabela XYZ.
        Se a inserção do produto for efetuada com sucesso
            retornar HTTP 201 sem corpo de resposta.
        Senão
            retornar HTTP 550 com corpo de resposta exibindo a mensagem "Erro genérico. Por favor tente novamente mais tarde."
        Fimse
    Senao
        retornar HTTP 500 com corpo de resposta exibindo a mensagem "Erro interno do servidor."
    Fimse
Senão
    retornar HTTP 400 com o corpo exibindo a mensagem "Parâmetro(s) inválido(s) para cadastro de um novo produto."
Fimse
```

<br>

### **Exemplos da função cadastrar produto**

```bash
curl
```

(anexar imagem aqui)

<br>
<br>

## **Função Listar Produtos**

A função listar produtors tem como objetivo mostrar ao cliente os produtos oferecidos para consumo.

```bash
Executar conexão com o banco de dados
Se a conexão for estabelecida com sucesso
    Executar a busca dos produtos na tabela XYZ.
    Se houver produtos para serem informados
        retornar HTTP 200 com corpo de resposta informando o nome, descrição e imagem.
    Senão
        retornar HTTP 550 com corpo de resposta exibindo a mensagem "Erro genérico. Por favor tente novamente mais tarde."
    Fimse
Senao
    retornar HTTP 500 com corpo de resposta exibindo a mensagem "Erro interno do servidor."
Fimse
```

<br>

### **Exemplos da função listar produtos**

```bash
curl
```

(anexar imagem aqui)

<br>
<br>

## **Função Deletar Produto**

A função deletar produto tem como objetivo remover um produto contido na base de dados.

```bash
Se o parâmetro id for informado (obrigatório para a execução da função) na requsição
    Executar conexão com o banco de dados
    Se a conexão for estabelecida com sucesso
        Executar a criação de um novo produto no banco de dados passando os dados informados na requisição na tabela XYZ.
        Se a remoção do produto for efetuada com sucesso
            retornar HTTP 204 sem corpo de resposta.
        Se o id informado não existir na base de dados
            retornar HTTP 400 com o corpo exibindo a mensagem "Parâmetro inválido para a remoção do produto."
        Senão
            retornar HTTP 550 com corpo de resposta exibindo a mensagem "Erro genérico. Por favor tente novamente mais tarde."
        Fimse
    Senao
        retornar HTTP 500 com corpo de resposta exibindo a mensagem "Erro interno do servidor."
    Fimse
Senão
    retornar HTTP 400 com o corpo exibindo a mensagem "Parâmetro inválido para a remoção do produto."
Fimse
```

<br>

### **Exemplos da função deletar produto**

```bash
curl
```

(anexar imagem aqui)

<br>
<br>

## **Função Atualizar Produto**

A função atualizar produto tem como objetivo atualizar um produto na base de dados.

```bash
Se o parâmetro id for informado (obrigatório para a execução da função) na requsição
    Executar conexão com o banco de dados
    Se a conexão for estabelecida com sucesso
        Executar a criação de um novo produto no banco de dados passando os dados informados na requisição na tabela XYZ.
        Se a remoção do produto for efetuada com sucesso
            retornar HTTP 200 com corpo de resposta exibindo as informações do produto atualizado.
        Se o id informado não existir na base de dados
            retornar HTTP 204 sem corpo de resposta.
        Senão
            retornar HTTP 550 com corpo de resposta exibindo a mensagem "Erro genérico. Por favor tente novamente mais tarde."
        Fimse
    Senao
        retornar HTTP 500 com corpo de resposta exibindo a mensagem "Erro interno do servidor."
    Fimse
Senão
    retornar HTTP 400 com o corpo exibindo a mensagem "Parâmetro inválido para a atualização do produto."
Fimse
```

<br>

### **Exemplos da função atualizar produto**

```bash
curl
```

(anexar imagem aqui)

<br>
<br>

## **Função Forma de Pagamento**

A função forma de pagamento tem como objetivo mostras as opções de pagamento disponíveis para o cliente, para que ele escolha da forma que melhor lhe atender ao momento. Efetuando assim seu pagamento para que seu pedido seja feito pelo estabelecimento.

```bash
Exbibir as formas de pagamento para o cliente (Dinheiro, PIX, QrCode, Cartão de Crédito e CArtão de Débito)
Dada opção selecionada
Se pagamento selecionado for Dinheiro
    retornar HTTP 200 com a mensagem "Por favor se dirija até o caixa."
Se pagamento selecionado for PIX
    Exibir a mensagem "Chave PIX para deposito xxxxxxx."
    Chamar função de validação de deposito PIX
    Se a função de depósito PIX retornar HTTP 200
        retornar HTTP 200 com corpo exibindo a mensgaem "Pagamento recebido com sucesso. Obrigado pela preferência."
    Senão a função de depósito PIX retornar HTTP != 200
        retornar HTTP 550 com corpo exibindo a mensagem "Pagamento nã recebido. Por favor tente novamente."
    Fimse
Se pagamento selecionado for QrCOde
    Exibir QrCode do Mercado Pago
    Se a API do Mercado Pago retornar HTTP 200
        retornar HTTP 200 com corpo exibindo a mensgaem "Pagamento recebido com sucesso. Obrigado pela preferência."
    Senão
        retornar HTTP 550 com corpo exibindo a mensagem "Pagamento nã recebido. Por favor tente novamente."
    Fimse
Se pagamento selecionado for Cartão de Crédito ou Cartão de Débito
    Exibir mensagem "Por favor insira o cartão de crédito ou aproxime seu cartão."
    Chamar função API validar cartão
    Se API valida cartão retornar HTTP 200
        retornar HTTP 200 com corpo exibindo a mensgaem "Pagamento recebido com sucesso. Obrigado pela preferência."
    Senão
        retornar HTTP 550 com corpo exibindo a mensagem "Pagamento nã recebido. Por favor tente novamente."
    Fimse
Fimse
```

<br>

### **Exemplos da função de pagamento**

```bash
curl
```

(anexar imagem aqui)

<br>
<br>

## **Função Acompanhamento do Pedido**

A função acompanhamento do pedido tem como objetivo mostrar os estágio em que o pedido se encontra sendo eles:

<br>

| Status | Descrição |
|--- |--- |
| Recebido | Informa que o pedido feito pelo cliente foi recebido pela cozinha do estabelecimento |
| Em preparação | Informa que o pedido do cliente está sendo feito |
| Pronto | Informa que o pedido do cliente foi feito e será revisado |
| Finalizado | Informa que o pedido do cliente foi finalizado |

<br>

```bash
Exbir a mensagem do status Recebido para o cliente
Se Status do pedido for 'Em Preparação'
    exibir mensagem 'Em Preparação'
Se Status do pedido for 'Pronto'
    exibir mensagem 'Pronto'
Se Status do pedido for 'Finalizado'
    exibir mensagem 'Finalizado'
    notificar cliente
```

<br>

### **Exemplos da função acompanhamento do pedido**

```bash
curl
```

(anexar imagem aqui)
