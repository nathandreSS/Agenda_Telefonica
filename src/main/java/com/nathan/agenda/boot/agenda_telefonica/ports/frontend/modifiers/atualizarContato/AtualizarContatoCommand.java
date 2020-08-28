package com.nathan.agenda.boot.agenda_telefonica.ports.frontend.modifiers.atualizarContato;

import com.nathan.agenda.boot.agenda_telefonica.domain.Contato;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AtualizarContatoCommand {
    private Contato contato;
    private Long id;
}
