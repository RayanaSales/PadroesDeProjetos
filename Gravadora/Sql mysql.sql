CREATE DATABASE IF NOT EXISTS gravadora;
CREATE TABLE gravadora.artista
(
nome VARCHAR(50),
pseudonimo VARCHAR(50),
nacionalidade VARCHAR(50),
estilomusical VARCHAR(50),
idade INT(6),
id INT(6) NOT NULL AUTO_INCREMENT,
PRIMARY KEY (id)
);

CREATE TABLE gravadora.musica
(
nome VARCHAR(50),
album VARCHAR(50),
duracao VARCHAR(50),
id INT(6) NOT NULL AUTO_INCREMENT,
PRIMARY KEY (id)
);
select * from gravadora.artista;
select * from gravadora.musica;
