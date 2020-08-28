package com.nathan.agenda.boot.agenda_telefonica.application;

import com.nathan.agenda.boot.agenda_telefonica.jpa_repository.entity.ContatoEntity;
import com.nathan.agenda.boot.agenda_telefonica.jpa_repository.entity.TelefoneEntity;
import com.nathan.agenda.boot.agenda_telefonica.ports.backservices.queries.ContatoRepository;
import com.nathan.agenda.boot.agenda_telefonica.ports.backservices.queries.TelefoneRepository;
import com.nathan.agenda.boot.agenda_telefonica.ports.frontend.queries.listarContatos.ListarContatosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ListarContatosServiceImpl implements ListarContatosService {

    @Autowired
    private ContatoRepository contatoRepository;
    @Autowired
    private TelefoneRepository telefoneRepository;
    @Override
    public List<ContatoEntity> execute() {

        List<ContatoEntity> contatos = contatoRepository.findAll();

        for(int i = 0; i < contatos.size(); i++) {
            List<TelefoneEntity> telefones = telefoneRepository.findByContact(contatos.get(i).getId());
            contatos.get(i).setTelefone(telefones);
        }

        return contatos;
    }
}
