package com.nathan.agenda.boot.agenda_telefonica.application;

import com.nathan.agenda.boot.agenda_telefonica.domain.Contato;
import com.nathan.agenda.boot.agenda_telefonica.jpa_repository.entity.ContatoEntity;
import com.nathan.agenda.boot.agenda_telefonica.jpa_repository.entity.TelefoneEntity;
import com.nathan.agenda.boot.agenda_telefonica.ports.backservices.modifiers.ContatoPersistence;
import com.nathan.agenda.boot.agenda_telefonica.ports.backservices.modifiers.TelefonePersistence;
import com.nathan.agenda.boot.agenda_telefonica.ports.backservices.queries.ContatoRepository;
import com.nathan.agenda.boot.agenda_telefonica.ports.backservices.queries.TelefoneRepository;
import com.nathan.agenda.boot.agenda_telefonica.ports.frontend.modifiers.atualizarContato.AtualizarContatoCommand;
import com.nathan.agenda.boot.agenda_telefonica.ports.frontend.modifiers.atualizarContato.AtualizarContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AtualizarContatoServiceImpl implements AtualizarContatoService {
    @Autowired
    private ContatoPersistence contatoPersistence;
    @Autowired
    private ContatoRepository contatoRepository;
    @Autowired
    private TelefoneRepository telefoneRepository;
    @Autowired
    private TelefonePersistence telefonePersistence;

    @Override
    public void execute(AtualizarContatoCommand command) {
        Contato contato = new Contato(command.getContato());
        ContatoEntity updateContato = new ContatoEntity(command.getContato(), command.getId());
        contatoPersistence.update(updateContato);

        List<TelefoneEntity> phones = contatoRepository.findById(command.getId()).getTelefone();
        System.out.println(phones.get(0).getId());
//        for (int i = 0; i < contato.getTelefoneObject().size() ; i++) {
//            System.out.println(phones.get(i).getId());
//            TelefoneEntity updatePhone = new TelefoneEntity(phones.get(i).getId(), contato.getTelefoneObject().get(i), updateContato);
//            telefonePersistence.update(updatePhone);
//        }
    }
}
