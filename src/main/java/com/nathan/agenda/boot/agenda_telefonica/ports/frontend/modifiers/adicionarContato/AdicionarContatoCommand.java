package com.nathan.agenda.boot.agenda_telefonica.ports.frontend.modifiers.adicionarContato;

import com.nathan.agenda.boot.agenda_telefonica.domain.Contato;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AdicionarContatoCommand {
    private Contato contato;
}
