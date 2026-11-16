create database validamed_db;
use validamed_db;
create table Paciente(
id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
nome varchar(90) NOT NULL,
senha varchar(45) NOT NULL,
idade int NOT NULL,
sexo varchar(45) not null
);
create table Receita(
id int PRIMARY KEY NOT NULL auto_increment,
id_paciente int,
data_emissao date not null,
crm_medico int,
carimbo boolean,
foreign key (id_paciente) references paciente(id)
);
create table Medicamento(
id int primary key not null auto_increment,
id_receita int,
nome varchar(45) not null,
comprimidos int not null,
dias int not null,
foreign key (id_receita) references receita(id)
);