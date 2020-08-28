package com.nathan.agenda.boot.agenda_telefonica.ports.frontend.queries.detalharContato;

import com.nathan.agenda.boot.agenda_telefonica.jpa_repository.entity.ContatoEntity;

public interface DetalharContatoService {

    ContatoEntity execute(DetalharContatoCommand command);
}
