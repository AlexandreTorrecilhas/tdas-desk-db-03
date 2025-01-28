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

GRANT SELECT, UPDATE, DELETE, INSERT ON cenaflix.* TO "mestre"@"localhost";

INSERT INTO `podcast` (`id_produtora`, `nome_episodio`, `qtd_episodio`, `duracao`) 
VALUES 
('The Future of AI', 10, 60),
('History Uncovered', 8, 45),
('Tech Trends Weekly', 20, 50),
('Mindful Living', 15, 30),
('True Crime Files', 12, 55),
('Fitness First', 25, 40),
('Space Explorations', 7, 65),
('The Book Club', 10, 50),
('Cooking Secrets', 18, 35),
('Travel Diaries', 14, 60);

SHOW CREATE TABLE produtora;

INSERT INTO produtora (nome_produtora) 
VALUES
('TechWave Studios'),
('History Chronicles Productions'),
('Mindful Creations'),
('True Crime Syndicate'),
('Wanderlust Media');