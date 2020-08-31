package com.nathan.agenda.boot.agenda_telefonica.application;

import com.nathan.agenda.boot.agenda_telefonica.domain.Contato;
import com.nathan.agenda.boot.agenda_telefonica.jpa_repository.entity.ContatoEntity;
import com.nathan.agenda.boot.agenda_telefonica.jpa_repository.entity.TelefoneEntity;
import com.nathan.agenda.boot.agenda_telefonica.ports.backservices.modifiers.ContatoPersistence;
import com.nathan.agenda.boot.agenda_telefonica.ports.backservices.modifiers.EnderecoPersistence;
import com.nathan.agenda.boot.agenda_telefonica.ports.backservices.modifiers.TelefonePersistence;
import com.nathan.agenda.boot.agenda_telefonica.ports.backservices.queries.ContatoRepository;
import com.nathan.agenda.boot.agenda_telefonica.ports.frontend.modifiers.adicionarContato.AdicionarContatoCommand;
import com.nathan.agenda.boot.agenda_telefonica.ports.frontend.modifiers.adicionarContato.AdicionarContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AdicionarContatoServiceImpl implements AdicionarContatoService {

    @Autowired
    private EnderecoPersistence enderecoPersistence;

    @Autowired
    private ContatoPersistence contatoPersistence;

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private TelefonePersistence telefonePersistence;

    @Override
    public void execute(AdicionarContatoCommand command) {
        Contato contato = new Contato(command.getContato());
        String name = contato.getNomeObject().getFirstName()
                + " " + contato.getNomeObject().getLastName();

        try {
            contatoRepository.findByName(name);
        } catch(Error e) {
            throw new Error(e.getMessage());
        }

        ContatoEntity contatoEntity = new ContatoEntity(contato);
        contatoPersistence.save(contatoEntity);
        contatoEntity = contatoRepository.findByName(name);

        for(int i = 0; i < contato.getTelefoneObject().size(); i++) {

            TelefoneEntity telefone = new TelefoneEntity(contato.getTelefoneObject().get(i).getTelefone(), contatoEntity);
            telefonePersistence.save(telefone);
        }
    }

    public boolean validateCommand(AdicionarContatoCommand command) {
        if(command == null) throw new Error("Command não pode ser null");
        return true;
    }
}
