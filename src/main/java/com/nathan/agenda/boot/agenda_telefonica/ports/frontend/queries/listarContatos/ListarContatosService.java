package com.nathan.agenda.boot.agenda_telefonica.ports.frontend.queries.listarContatos;

import com.nathan.agenda.boot.agenda_telefonica.jpa_repository.entity.ContatoEntity;

import java.util.List;

public interface ListarContatosService {
    List<ContatoEntity> execute();
}
