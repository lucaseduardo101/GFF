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

<br>

## **Funções do sistema**

O sistema é composto por diversas funções como exemplo:
- Cadastrar Cliente
- Produtos
- Pedidos

Abaixo seram descritas as fucionalidades das funções do sistema assim como algum exemplos de utilização dos mesmos.

<br>

## **Cadastrar Cliente**

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
        Retornar HTTP 201 sem corpo de resposta
    Senão
        Retornar HTTP 550 com corpo de resposta exibindo a mensagem "Erro genérico. Por favor tente novamente mais tarde."
    Fimse
Senão
    Retornar HTTP 400 com o corpo exibindo a mensagem "Parâmetro(s) inválido(s) para cadastro"
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

| Função | Responsábilidade da função | Método | Parâmetro (s) | Rota |
|--- |--- |--- |--- |--- |
| Consultar Produto | Retornar o produto especificado na busca | GET | {id} | /produto/busca/{id} |
| Cadastrar Produto | Efetuar o cadastro de um novo produto | POST | {id} {estoque} {nome} {descrição} | /produto/cadastro |
| Listar Produtos | Retorna a lista dos produtos existentes | GET | {id} | /produto/lista/produto |
| Deletar Produto | Efetuar a deleção do produto especificado | POST | {id} | /produto/remove/{id} |
| Atualizar Produto | Efetuar edição em um produto especificado | PUT | {id} | /produto/edita/{id} |

<br>
<br>

## **Função Consultar Produto**

A função consultar produto tem como objetivo informar ao cliente sobre o item informado para a busca.

```bash
Se o parâmetro id informado (obrigatório para a execução da função) na requsição
    Executar busca pelo parâmetro informado no banco de dados na tabela XYZ.
    Se existir informações do parâmetro
        Retornar HTTP 200 com corpo de resposta contendo nome e descrição referêntes ao parâmtro informado.
    Senão
        Retornar HTTP 204 sem corpo de resposta.
    Fimse
Senão
    Retornar HTTP 400 com o corpo exibindo a mensagem "Parâmetro inválido para a consulta."
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
            Retornar HTTP 201 sem corpo de resposta.
        Senão
            Retornar HTTP 550 com corpo de resposta exibindo a mensagem "Erro genérico. Por favor tente novamente mais tarde."
        Fimse
    Senao
        Retornar HTTP 500 com corpo de resposta exibindo a mensagem "Erro interno do servidor."
    Fimse
Senão
    Retornar HTTP 400 com o corpo exibindo a mensagem "Parâmetro(s) inválido(s) para cadastro de um novo produto."
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
        Retornar HTTP 200 com corpo de resposta informando o nome, descrição e imagem.
    Senão
        Retornar HTTP 550 com corpo de resposta exibindo a mensagem "Erro genérico. Por favor tente novamente mais tarde."
    Fimse
Senao
    Retornar HTTP 500 com corpo de resposta exibindo a mensagem "Erro interno do servidor."
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
            Retornar HTTP 204 sem corpo de resposta.
        Se o id informado não existir na base de dados
            Retornar HTTP 400 com o corpo exibindo a mensagem "Parâmetro inválido para a remoção do produto."
        Senão
            Retornar HTTP 550 com corpo de resposta exibindo a mensagem "Erro genérico. Por favor tente novamente mais tarde."
        Fimse
    Senao
        Retornar HTTP 500 com corpo de resposta exibindo a mensagem "Erro interno do servidor."
    Fimse
Senão
    Retornar HTTP 400 com o corpo exibindo a mensagem "Parâmetro inválido para a remoção do produto."
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
            Retornar HTTP 200 com corpo de resposta exibindo as informações do produto atualizado.
        Se o id informado não existir na base de dados
            Retornar HTTP 204 sem corpo de resposta.
        Senão
            Retornar HTTP 550 com corpo de resposta exibindo a mensagem "Erro genérico. Por favor tente novamente mais tarde."
        Fimse
    Senao
        Retornar HTTP 500 com corpo de resposta exibindo a mensagem "Erro interno do servidor."
    Fimse
Senão
    Retornar HTTP 400 com o corpo exibindo a mensagem "Parâmetro inválido para a atualização do produto."
Fimse
```

<br>

### **Exemplos da função atualizar produto**

```bash
curl
```

(anexar imagem aqui)

