package com.nathan.agenda.boot.agenda_telefonica.domain.valueObjects.endereco;

import com.nathan.agenda.boot.agenda_telefonica.domain.valueObjects.endereco.exceptions.CepInvalido;
import com.nathan.agenda.boot.agenda_telefonica.domain.valueObjects.endereco.exceptions.CepVazio;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Endereco {

    private String cep;
    private int numero;
    private String complemento;

    public Endereco(String cep, int numero, String complemento) {

        try {
            this.Validate(cep, numero);
        } catch (CepInvalido cepInvalido) {
            throw new Error(cepInvalido.getMessage());
        } catch (CepVazio cepVazio) {
            throw new Error(cepVazio.getMessage());
        }
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
    }

    public Endereco(Endereco endereco) {

        try {
            this.Validate(endereco.getCep(), endereco.getNumero());
        } catch (CepInvalido cepInvalido) {
            throw new Error(cepInvalido.getMessage());
        } catch (CepVazio cepVazio) {
            throw new Error(cepVazio.getMessage());
        }
        this.cep = endereco.getCep();
        this.numero = endereco.getNumero();
        this.complemento = endereco.getComplemento();
    }

    public boolean Validate(String cep, int numero) throws CepInvalido, CepVazio {
        String pattern = "[0-9]{5}[-]{1}[0-9]{3}";
        if(cep == "") throw new CepVazio();
        if(!cep.matches(pattern)) throw new CepInvalido();
        if(numero == 0) throw new Error("Numero vazio");
        return true;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
