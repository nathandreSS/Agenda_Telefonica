package com.nathan.agenda.boot.agenda_telefonica.application;

import com.nathan.agenda.boot.agenda_telefonica.jpa_repository.entity.ContatoEntity;
import com.nathan.agenda.boot.agenda_telefonica.ports.backservices.queries.ContatoRepository;
import com.nathan.agenda.boot.agenda_telefonica.ports.frontend.queries.detalharContato.DetalharContatoCommand;
import com.nathan.agenda.boot.agenda_telefonica.ports.frontend.queries.detalharContato.DetalharContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalharContatoServiceImpl implements DetalharContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Override
    public ContatoEntity execute(DetalharContatoCommand command) { return contatoRepository.findById(command.getContatoId()); }
}
