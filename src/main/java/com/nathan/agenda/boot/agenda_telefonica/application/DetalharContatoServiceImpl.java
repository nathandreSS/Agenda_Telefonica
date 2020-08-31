package com.nathan.agenda.boot.agenda_telefonica.application;

import com.nathan.agenda.boot.agenda_telefonica.jpa_repository.entity.ContatoEntity;
import com.nathan.agenda.boot.agenda_telefonica.ports.backservices.queries.ContatoRepository;
import com.nathan.agenda.boot.agenda_telefonica.ports.frontend.queries.detalharContato.DetalharContatoCommand;
import com.nathan.agenda.boot.agenda_telefonica.ports.frontend.queries.detalharContato.DetalharContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class DetalharContatoServiceImpl implements DetalharContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Override
    public ContatoEntity execute(DetalharContatoCommand command) {
        ContatoEntity contato = contatoRepository.findById(command.getContatoId());
        if(contato == null) throw new Error("Contato não encontrado");
        for(int i = 0; i < contato.getTelefone().size(); i++) {

            contato.getTelefone().get(i).setContato(null);
        }
        return contato;
    }
}
