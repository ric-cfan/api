CREATE TABLE categoria (
   id serial PRIMARY KEY,
   nome varchar(20) NOT NULL,
   descricao varchar(200)
);

CREATE TABLE livro (
  id serial PRIMARY KEY,
  titulo varchar(40) NOT NULL,
  isbn varchar(20) NOT NULL UNIQUE,
  data_publicacao date,
  id_categoria int REFERENCES categoria(id)
);

CREATE TABLE autor (
  id serial PRIMARY KEY,
  nome varchar(50) NOT null
);

CREATE TABLE livro_autor (
	id_livro int REFERENCES livro(id),
	id_autor int REFERENCES autor(id),
	PRIMARY KEY (id_livro, id_autor)
);


CREATE TABLE associado (
	id serial PRIMARY KEY,
	nome varchar(50) NOT NULL,
	telefone varchar(15) NOT NULL,
	cpf varchar(11) NOT NULL,
	logradouro varchar(80) NOT NULL,
	numero varchar(10) NOT NULL,
	complemento varchar(30),
	bairro varchar(50) NOT NULL,
	cidade varchar(50) NOT NULL,
	estado varchar(2) NOT null
); 

CREATE TABLE emprestimo (
	id serial PRIMARY KEY,
	id_associado int REFERENCES associado(id),
	data_emprestimo date
);


CREATE TABLE emprestimo_livro (
	id serial PRIMARY KEY,
	id_emprestimo int REFERENCES emprestimo(id),
	id_livro int REFERENCES livro(id),
	obs_ato_emprestimo varchar(200)
);	





