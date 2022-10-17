create table ficha (
  id serial,
  nome varchar(40) not null,
  data_nascimento date,
  data_hora_cadastro timestamp default now(),
  sexo char(1) check (sexo in ('M','F')),
  visitas int,
  filhos  smallint,
  historia_vida text,
  foto bytea,
  primary key (id)
);

create table exame (
	id serial,
	data_exame date,
	resultado text,
	id_ficha int4,
	foreign key (id_ficha) references ficha(id)
);

alter table exame add primary key(id);

create index idx_ficha_nome on ficha (nome);