USE cenaflix;

SHOW TABLES;

/*Criando Tabela Filme*/
CREATE TABLE podcast(
	id				INT AUTO_INCREMENT,
    nome_episodio	VARCHAR(100) NOT NULL,
    qtd_episodio	SMALLINT not null,
    duracao			SMALLINT NOT NULL, 
    CONSTRAINT pk_pod_id PRIMARY KEY(id)
);

ALTER TABLE podcast
	RENAME COLUMN id TO id_podcast;

/*Criando tabela Prudotora*/    
CREATE TABLE produtora(
	id_produtora			INT AUTO_INCREMENT,
    nome_produtora			VARCHAR(150) NOT NULL,
    CONSTRAINT pk_pro_id_pro PRIMARY KEY(id_produtora)
);

/*Adicionando Constraint*/
ALTER TABLE podcast
	ADD COLUMN id_produtora INT after id_podcast;
    
ALTER TABLE podcast
	ADD CONSTRAINT fk_pod_id_fil FOREIGN KEY(id_produtora) REFERENCES produtora(id_produtora);
    
/*Criando tabela Usuários*/
CREATE TABLE usuario(
	id_usuario	INT AUTO_INCREMENT,
	login		VARCHAR(100) NOT NULL,
    senha		VARCHAR(60) NOT NULL,
    CONSTRAINT pk_usu_id_usu PRIMARY KEY(id_usuario),
    CONSTRAINT un_usu_log UNIQUE(login)
);

ALTER TABLE usuario
	MODIFY senha VARCHAR(255) NOT NULL;

/*Criando triiger para encriptar a senha antes de inserir o valor*/
DELIMITER //
CREATE TRIGGER hash_usuario_senha
BEFORE INSERT ON usuario
FOR EACH ROW
BEGIN
	SET NEW.senha = SHA2(NEW.senha, 256);
END//
DELIMITER ;

/*Criando o trigger para encriptar o valor antes da consulta*/
DELIMITER //


DELIMITER ;

INSERT INTO usuario(login, senha)
	VALUES("carloss", "mudar@123");
    
DELETE FROM usuario WHERE id_usuario = 1;