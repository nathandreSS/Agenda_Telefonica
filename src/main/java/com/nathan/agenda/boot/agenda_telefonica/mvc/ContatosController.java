package com.nathan.agenda.boot.agenda_telefonica.mvc;

import com.nathan.agenda.boot.agenda_telefonica.domain.Contato;
import com.nathan.agenda.boot.agenda_telefonica.jpa_repository.entity.ContatoEntity;
import com.nathan.agenda.boot.agenda_telefonica.ports.frontend.modifiers.adicionarContato.AdicionarContatoCommand;
import com.nathan.agenda.boot.agenda_telefonica.ports.frontend.modifiers.adicionarContato.AdicionarContatoService;
import com.nathan.agenda.boot.agenda_telefonica.ports.frontend.modifiers.atualizarContato.AtualizarContatoCommand;
import com.nathan.agenda.boot.agenda_telefonica.ports.frontend.modifiers.atualizarContato.AtualizarContatoService;
import com.nathan.agenda.boot.agenda_telefonica.ports.frontend.modifiers.removerContato.RemoverContatoCommand;
import com.nathan.agenda.boot.agenda_telefonica.ports.frontend.modifiers.removerContato.RemoverContatoService;
import com.nathan.agenda.boot.agenda_telefonica.ports.frontend.queries.detalharContato.DetalharContatoCommand;
import com.nathan.agenda.boot.agenda_telefonica.ports.frontend.queries.detalharContato.DetalharContatoService;
import com.nathan.agenda.boot.agenda_telefonica.ports.frontend.queries.listarContatos.ListarContatosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ContatosController {

    @Autowired
    private AdicionarContatoService adicionarContatoService;
    @Autowired
    private ListarContatosService listarContatosService;
    @Autowired
    private DetalharContatoService detalharContatosService;
    @Autowired
    private AtualizarContatoService atualizarContatoService;
    @Autowired
    private RemoverContatoService removerContatoService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/listar")
    @ResponseBody
    public List<ContatoEntity> listar() {
        return listarContatosService.execute();
    }

    @GetMapping("/detalhar")
    @ResponseBody
    public ContatoEntity detalhar(@RequestParam Long contatoId) {
        DetalharContatoCommand detalharContatoCommand = new DetalharContatoCommand(contatoId);
        return detalharContatosService.execute(detalharContatoCommand);
    }

    @PostMapping(value = "/adicionar", consumes = {"application/json"})
    @ResponseBody
    public Map<String, String> adicionar(@RequestBody Contato contato) {
        Map<String, String> response = new HashMap<String, String>();
        try {
            AdicionarContatoCommand adicionarContatoCommand = new AdicionarContatoCommand(contato);
            adicionarContatoService.execute(adicionarContatoCommand);
            response.put("message", "Ok");
            response.put("statusCode", "200");
        } catch(Error e) {
            response.put("message", e.getMessage());
            response.put("statusCode", "400");
        }
        return response;
    }

    @PutMapping(value = "/atualizar", consumes = {"application/json"})
    @ResponseBody
    public Map<String, String> atualizar(@RequestBody Contato contato, @RequestParam Long contatoId) {
        Map<String, String> response = new HashMap<String, String>();
        try {
            AtualizarContatoCommand atualizarContatoCommand = new AtualizarContatoCommand(contato, contatoId);
            atualizarContatoService.execute(atualizarContatoCommand);
            response.put("message", "Ok");
            response.put("statusCode", "200");
        } catch(Error e) {
            response.put("message", e.getMessage());
            response.put("statusCode", "400");
        }
        return response;
    }

    @DeleteMapping("/remover")
    @ResponseBody
    public Map<String, String> remover(@RequestParam Long contatoId) {
        Map<String, String> response = new HashMap<String, String>();
        try {
            RemoverContatoCommand removerContatoCommand = new RemoverContatoCommand(contatoId);
            removerContatoService.execute(removerContatoCommand);
            response.put("message", "Ok");
            response.put("statusCode", "200");
        } catch(Error e) {
            response.put("message", e.getMessage());
            response.put("statusCode", "400");
        }
        return response;
    }



}
