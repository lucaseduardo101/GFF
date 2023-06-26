CREATE DATABASE IF NOT EXISTS gff;

USE gff;

CREATE TABLE IF NOT EXISTS tb_status_pedido (
        id_status int PRIMARY KEY AUTO_INCREMENT,
        descricao varchar(50) NOT NULL
 );

CREATE TABLE IF NOT EXISTS tb_tipo_pagamento (
        id_tipo_pagamento int PRIMARY KEY AUTO_INCREMENT,
        descricao varchar(50) NOT NULL
 );

CREATE TABLE IF NOT EXISTS tb_pedido ( id_pedido int PRIMARY KEY AUTO_INCREMENT,
                         id_cliente int NOT NULL,
                         id_status int NOT NULL,
                         id_tipo_pagamento int NOT NULL,
                         data_pedido datetime NOT NULL);

CREATE TABLE IF NOT EXISTS tb_cliente (
        id_cliente int PRIMARY KEY AUTO_INCREMENT,
        nome varchar(250),
        cpf varchar(11) NOT NULL,
        email varchar(250) NOT NULL,
        telefone varchar(15),
        senha varchar(255) NOT NULL
 );

CREATE TABLE IF NOT EXISTS tb_item_pedido (
        id_item_pedido int PRIMARY KEY AUTO_INCREMENT,
        id_pedido int NOT NULL,
        id_produto int NOT NULL,
        preco decimal NOT NULL,
        quantidade int NOT NULL
 );

CREATE TABLE IF NOT EXISTS tb_produto (
        id_produto int PRIMARY KEY AUTO_INCREMENT,
        nome varchar(250) NOT NULL,
        descricao varchar(250),
        estoque int NOT NULL,
        id_categoria int NOT NULL
 );

CREATE TABLE IF NOT EXISTS tb_categoria (
        id_categoria int PRIMARY KEY AUTO_INCREMENT,
        descricao varchar(50) NOT NULL
 );

ALTER TABLE tb_produto
    ADD CONSTRAINT fk_produto_categoria
    FOREIGN KEY (id_categoria)
    REFERENCES tb_categoria (id_categoria) ;

ALTER TABLE tb_pedido
    ADD CONSTRAINT fk_pedido_cliente
    FOREIGN KEY (id_cliente)
    REFERENCES tb_cliente (id_cliente) ;

ALTER TABLE tb_pedido
    ADD CONSTRAINT fk_pedido_status
    FOREIGN KEY (id_status)
    REFERENCES tb_status_pedido (id_status) ;

ALTER TABLE tb_pedido
    ADD CONSTRAINT fk_pedido_pagamento
    FOREIGN KEY (id_tipo_pagamento)
    REFERENCES tb_tipo_pagamento (id_tipo_pagamento) ;

ALTER TABLE tb_item_pedido
    ADD CONSTRAINT fk_itempedido_pedido
    FOREIGN KEY (id_pedido)
    REFERENCES tb_pedido (id_pedido) ;

ALTER TABLE tb_item_pedido
    ADD CONSTRAINT fk_itempedido_produto
    FOREIGN KEY (id_produto)
    REFERENCES tb_produto (id_produto) ;

INSERT INTO tb_status_pedido (id_status,descricao) VALUES (1,"Recebido");
INSERT INTO tb_status_pedido (id_status,descricao) VALUES (2,"Em preparação");
INSERT INTO tb_status_pedido (id_status,descricao) VALUES (3,"Pronto");
INSERT INTO tb_status_pedido (id_status,descricao) VALUES (4,"Finalizado");

INSERT INTO tb_tipo_pagamento (id_tipo_pagamento,descricao) VALUES (1,"PIX - QR CODE");
INSERT INTO tb_tipo_pagamento (id_tipo_pagamento,descricao) VALUES (2,"PIX - Transferência");
INSERT INTO tb_tipo_pagamento (id_tipo_pagamento,descricao) VALUES (3,"QR CODE - Carteira digital");
INSERT INTO tb_tipo_pagamento (id_tipo_pagamento,descricao) VALUES (4,"Cartão de debito");
INSERT INTO tb_tipo_pagamento (id_tipo_pagamento,descricao) VALUES (5,"Cartão de credito");
INSERT INTO tb_tipo_pagamento (id_tipo_pagamento,descricao) VALUES (6,"Dinheiro vivo");

INSERT INTO tb_categoria (id_categoria, descricao) VALUES (1,"Lanche");
INSERT INTO tb_categoria (id_categoria, descricao) VALUES (2,"Bebida");
INSERT INTO tb_categoria (id_categoria, descricao) VALUES (3,"Combo");
INSERT INTO tb_categoria (id_categoria, descricao) VALUES (4,"Acompanhamento");
INSERT INTO tb_categoria (id_categoria, descricao) VALUES (5,"Sobremesa");

INSERT INTO tb_produto (id_produto,nome, descricao, estoque,id_categoria ) VALUES (1,"Hamburguer Duplo", "Hamburguer com duas carnes queijo e salada", 100, 1);
INSERT INTO tb_produto (id_produto,nome, descricao, estoque,id_categoria ) VALUES (2,"Hamburguer Simples", "Hamburguer com uma carne queijo e salada", 100, 1);
INSERT INTO tb_produto (id_produto,nome, descricao, estoque,id_categoria ) VALUES (3,"Hamburguer Especial", "Hamburguer com duas carnes queijo e salada", 100, 1);

INSERT INTO tb_produto (id_produto,nome, descricao, estoque,id_categoria ) VALUES (4,"Refrigerante", "Bebida gasosa", 100, 2);
INSERT INTO tb_produto (id_produto,nome, descricao, estoque,id_categoria ) VALUES (5,"Suco da fruta", "Suco de frutas da polpa", 100, 2);

INSERT INTO tb_produto (id_produto,nome, descricao, estoque,id_categoria ) VALUES (6,"Batata Frita", "Batata frita da casa", 100, 4);

INSERT INTO tb_produto (id_produto,nome, descricao, estoque,id_categoria ) VALUES (7,"Pudim", "Pudim de leite", 100, 5);

INSERT INTO tb_produto (id_produto,nome, descricao, estoque,id_categoria ) VALUES (8,"Combo simples", "Hamburguer simples, 1 bebida, 1 acompanhamento e 1 sobremesa", 100, 3);
INSERT INTO tb_produto (id_produto,nome, descricao, estoque,id_categoria ) VALUES (9,"Combo duplo", "Hamburguer duplo, 1 bebida, 1 acompanhamento e 1 sobremesa", 100, 3);
INSERT INTO tb_produto (id_produto,nome, descricao, estoque,id_categoria ) VALUES (10,"Combo especial", "Hamburguer especial, 1 bebida, 1 acompanhamento e 1 sobremesa", 100, 3);
