package com.nathan.agenda.boot.agenda_telefonica.application;

import com.nathan.agenda.boot.agenda_telefonica.domain.Contato;
import com.nathan.agenda.boot.agenda_telefonica.jpa_repository.entity.ContatoEntity;
import com.nathan.agenda.boot.agenda_telefonica.jpa_repository.entity.TelefoneEntity;
import com.nathan.agenda.boot.agenda_telefonica.ports.backservices.modifiers.ContatoPersistence;
import com.nathan.agenda.boot.agenda_telefonica.ports.backservices.modifiers.EnderecoPersistence;
import com.nathan.agenda.boot.agenda_telefonica.ports.backservices.modifiers.TelefonePersistence;
import com.nathan.agenda.boot.agenda_telefonica.ports.backservices.queries.ContatoRepository;
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
    private EnderecoPersistence enderecoPersistence;
    @Autowired
    private TelefonePersistence telefonePersistence;

    @Override
    public void execute(AtualizarContatoCommand command) {
        try {
            Contato contato = new Contato(command.getContato());
            String name = contato.getNomeObject().getFirstName() + " " + contato.getNomeObject().getLastName();

            ContatoEntity contactWithThisNameAlreadyExists = contatoRepository.findByName(name);
            if (contactWithThisNameAlreadyExists != null && contactWithThisNameAlreadyExists.getId() != command.getId()) {
                throw new Error("Já existe um contato com esse nome");
            }

            ContatoEntity contatoBeforeUpdate = contatoRepository.findById(command.getId());
            if(contatoBeforeUpdate == null) throw new Error("Contato não encontrado para a atualização.");
            if(contato.getEnderecoObject() == null && contatoBeforeUpdate.getEndereco() != null) {
                enderecoPersistence.delete(contatoBeforeUpdate.getEndereco().getId());
            }
            ContatoEntity contatoEntity = new ContatoEntity(command.getContato(), command.getId());
            List<TelefoneEntity> phones = contatoBeforeUpdate.getTelefone();
            int biggestList = Integer.max(contato.getTelefoneObject().size(), phones.size());
            for (int i = 0; i < biggestList; i++) {
                if (i < contato.getTelefoneObject().size()) {
                    Long id = i < phones.size() ? phones.get(i).getId() : null;
                    TelefoneEntity updatePhone = new TelefoneEntity(id, contato.getTelefoneObject().get(i), contatoEntity);
                    telefonePersistence.update(updatePhone);
                } else {
                    telefonePersistence.delete(phones.get(i).getId());
                }
            }
            contatoPersistence.update(contatoEntity);
        } catch(Error error) {
            throw new Error(error.getMessage());
        }
    }
}
