CREATE TABLE agenda(
    id bigint PRIMARY KEY AUTO_INCREMENT,
    descricao varchar(255),
    data_hora timestamp,
    data_criacao timestamp,
    paciente_id bigint,
    CONSTRAINT fk_agenda_paciente FOREIGN KEY(paciente_id) REFERENCES paciente(id)
);