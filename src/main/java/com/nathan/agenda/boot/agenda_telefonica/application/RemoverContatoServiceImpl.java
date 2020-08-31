package com.nathan.agenda.boot.agenda_telefonica.application;

import com.nathan.agenda.boot.agenda_telefonica.jpa_repository.entity.TelefoneEntity;
import com.nathan.agenda.boot.agenda_telefonica.ports.backservices.modifiers.ContatoPersistence;
import com.nathan.agenda.boot.agenda_telefonica.ports.backservices.modifiers.TelefonePersistence;
import com.nathan.agenda.boot.agenda_telefonica.ports.backservices.queries.ContatoRepository;
import com.nathan.agenda.boot.agenda_telefonica.ports.frontend.modifiers.removerContato.RemoverContatoCommand;
import com.nathan.agenda.boot.agenda_telefonica.ports.frontend.modifiers.removerContato.RemoverContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RemoverContatoServiceImpl implements RemoverContatoService {

    @Autowired
    private ContatoPersistence contatoPersistence;

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private TelefonePersistence telefonePersistence;

    @Override
    public void execute(RemoverContatoCommand command) {
        try {
            List<TelefoneEntity> phones = contatoRepository.findById(command.getContatoId()).getTelefone();
            for(int i = 0; i < phones.size(); i ++) {
                telefonePersistence.delete(phones.get(i).getId());
            }
            contatoPersistence.delete(command.getContatoId());
        } catch(NullPointerException e) {
            throw new Error("Contato não encontrado para remoção.");
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }
}
