package com.nathan.agenda.boot.agenda_telefonica.ports.frontend.modifiers.removerContato;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RemoverContatoCommand {
    private Long contatoId;
}
