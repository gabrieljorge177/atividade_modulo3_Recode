drop database agencia;

CREATE DATABASE agencia;

USE agencia;

CREATE TABLE Cliente 
( 
 id_cliente INT PRIMARY KEY auto_increment,  
 cpf INT NOT NULL,
 idade INT,  
 acompanhantes INT NOT NULL,  
 nome VARCHAR(40) NOT NULL,   
 email VARCHAR(40) NOT NULL,  
 senha VARCHAR(40) NOT NULL,
 UNIQUE (email),
 UNIQUE (cpf)
); 

CREATE TABLE Passagem 
( 
 id_passagem INT PRIMARY KEY auto_increment,  
 cidade VARCHAR(20) NOT NULL, 
 data_passagem VARCHAR(20) NOT NULL,
 preço FLOAT NOT NULL, 
 categoria VARCHAR(20) NOT NULL
); 

CREATE TABLE Compra 
( 
 data_compra VARCHAR(40) NOT NULL,  
 id_compra INT PRIMARY KEY auto_increment,  
 id_cliente INT ,  
 id_passagem INT ,  
 metodo_pagamento VARCHAR(40) NOT NULL,
 total_compra FLOAT NOT NULL,
 FOREIGN KEY (id_cliente) references Cliente (id_cliente),
 FOREIGN KEY (id_passagem) references Passagem (id_passagem)
); 

select * from Cliente;
select * from Passagem;
select * from Compra;
select*from Cliente_Passagem;

CREATE VIEW Cliente_Passagem AS
select c.id_compra, c.data_compra, c.metodo_pagamento, c.total_compra, p.*, t.* from Compra c, Passagem p, Cliente t where c.id_passagem = p.id_passagem and c.id_cliente = t.id_cliente;

insert into Cliente values 
(default,'1231','27','1','Gabriel','gabriel@', '25637474');
insert into Cliente values 
(default,'1323','36','3','Jania','Jania@', '256374743');

insert into Passagem values 
(default,'Rio de Janeiro', '28/03/2024','1000.50','cidades paradisíacas');
insert into Passagem values 
(default,'Bonito', '30/08/2023', '1500.50','ecoturismo');

insert into Compra values ('18/09/2023', default, '1', '2', 'dinheiro', '975.00' );
insert into Compra values ('15/09/2023', default, '2', '1', 'cartao', '1300.00');

select c.id_compra, c.data_compra, p.*, t.* from Compra c, Passagem p, Cliente t where c.id_passagem = p.id_passagem and c.id_cliente = t.id_cliente;

delete from Compra where id_cliente = 2;
delete from Cliente where id_cliente = 2;
