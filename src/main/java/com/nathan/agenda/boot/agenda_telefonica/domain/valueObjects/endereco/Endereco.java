package com.nathan.agenda.boot.agenda_telefonica.domain.valueObjects.endereco;

import com.nathan.agenda.boot.agenda_telefonica.domain.valueObjects.endereco.exceptions.CepInvalido;
import com.nathan.agenda.boot.agenda_telefonica.domain.valueObjects.endereco.exceptions.CepVazio;

public class Endereco {

    private String cep;
    private int numero;
    private String complemento;

    public Endereco(String cep, int numero, String complemento) {

        try {
            Endereco.cepValidate(cep);
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
            Endereco.cepValidate(endereco.getCep());
        } catch (CepInvalido cepInvalido) {
            throw new Error(cepInvalido.getMessage());
        } catch (CepVazio cepVazio) {
            throw new Error(cepVazio.getMessage());
        }
        this.cep = endereco.getCep();
        this.numero = endereco.getNumero();
        this.complemento = endereco.getComplemento();
    }

    static boolean cepValidate(String cep) throws CepInvalido, CepVazio {
        String pattern = "[0-9]{5}[-]{1}[0-9]{3}";
        if(cep == "") throw new CepVazio();
        if(!cep.matches(pattern)) throw new CepInvalido();

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
