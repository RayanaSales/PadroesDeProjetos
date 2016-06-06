CREATE TABLE artista
(
  id serial NOT NULL,
  nome text,
  idade integer,
  pseudonimo text,
  nacionalidade text,
  estilomusical text,
  CONSTRAINT id_pk PRIMARY KEY (id)
);
CREATE TABLE musica
(
  id serial NOT NULL,
  nome text,
  album text,
  duracao text,
  CONSTRAINT id2_pk PRIMARY KEY (id)
);
