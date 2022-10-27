INSERT INTO categoria (id, nome, descricao) VALUES 
	(1, 'Informatica', 'Livros de tecnologia da informação'),
    (2, 'Romance','Livros de romance'),
    (3, 'Terror', 'Livros de Terror'),
    (4, 'Fantasia', 'Livros de fantasia'),
    (5, 'Ficção Científica', 'Livros de ficção Científica')
    ;
   
INSERT INTO autor (id, nome) VALUES 
(1, 'Erich Gamma' ),
(2, 'Richard Helm' ),
(3, 'Ralph Johnson' ),
(4, 'John Vlissides' ),
(5, 'Booch Grady' ),
(6, 'J.R.R. Tolkien' ),
(7, 'Isaac Asimov' ),
(8, 'George R.R Martin' ),
(9, 'Ellroy James'),
(10, 'Stephen King');

INSERT INTO livro (id, titulo, isbn, data_publicacao, id_categoria) VALUES
 (1, 'Design Patterns',
  '978-0201633610', '1994-10-31', 1),
 (2, 'O Senhor dos Aneis', '8533615167', '2001-02-03', 4),
 (3, 'O Hobbit', '8578277104', '2013-01-01',4),
 (4, 'Eu, Robô', '8576572001', '2014-11-24',5),
 (5, 'O Fim da Eternidade','8576574225', '2019-07-10',5),
 (6, 'Fundação', '8576574837', '2020-07-04',5),
 (7, 'A Guerra dos Tronos','8556510787','2019-03-25',4),
 (8, 'A Fúria dos Reis', '8556510795', '2910-07-20',4),
 (9, 'A Tormenta das Espadas', '8556510809', '2019-07-20',4),
 (10,'O Festim dos Corvos', '8556510884','2019-11-11',4),
 (11,'Los Angeles. Cidade Proibida', '8577991881','2011-07-20',2),
 (12, 'O Iluminado','8581050484','2012-11-19',3),
 (13, 'It: A coisa', '8560280944', '2014-06-24', 3),
 (14, 'Carrie a Estranha','8581050360','2013-07-23',3);
 

INSERT INTO livro_autor (id_livro, id_autor) VALUES 
(1,1), (1,2), (1,3), (1,4), (1,5),
(2,6),(3,6),
(4,7),(5,7),(6,7),
(7,8),(8,8),(9,8),(10,8),
(11,9),
(12,10),(13,10),(14,10);

INSERT INTO associado 
    (id,nome,telefone,cpf,logradouro,numero,
     complemento,bairro,cidade,estado) VALUES
  (1, 'luis', '222122122', '91879325047', 'rua dos bobos', 'zero',
     '', 'centro','cidade qq', 'rj'),
  (2, 'andre', '222432122', '46750948057', 'rua dos bodes', '234',
     '', 'centro','cidade qq', 'rj'),
  (3, 'claudia', '222176522', '65507543054', 'rua das coves', '5321',
     '', 'centro','cidade qq', 'rj');


INSERT INTO emprestimo (id, id_associado, data_emprestimo) VALUES
 (1, 1, '2022-07-10'),
 (2, 1, '2022-08-11');
 

INSERT INTO emprestimo_livro(id_emprestimo, id_livro, obs_ato_emprestimo) VALUES
 (1, 1, ''),
 (1, 2, ''),
 (1, 3, ''),
 (1, 7, ''),
 (1, 9, ''),
 (2, 7, ''),
 (2, 8, 'capa do livro amassada' ),
 (2, 9, ''),
 (2, 10, ''),
 (2, 14, '');

 

ALTER SEQUENCE categoria_id_seq RESTART WITH 30;
ALTER SEQUENCE livro_id_seq RESTART WITH 30;
ALTER SEQUENCE autor_id_seq RESTART WITH 30;
ALTER SEQUENCE associado_id_seq RESTART WITH 30;
ALTER SEQUENCE emprestimo_id_seq RESTART WITH 30;
ALTER SEQUENCE emprestimo_livro_id_seq RESTART WITH 30;
