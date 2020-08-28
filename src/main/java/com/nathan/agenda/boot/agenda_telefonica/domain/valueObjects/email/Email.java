package com.nathan.agenda.boot.agenda_telefonica.domain.valueObjects.email;

import com.nathan.agenda.boot.agenda_telefonica.domain.valueObjects.email.exceptions.EmailInvalido;
import com.nathan.agenda.boot.agenda_telefonica.domain.valueObjects.email.exceptions.EmailVazio;

public class Email {
    private String email;

    public Email(){}
    public Email(String email){

        try {
            this.validate(email);
        } catch (EmailInvalido emailInvalido) {
            throw new Error(emailInvalido.getMessage());
        } catch (EmailVazio emailVazio) {
            throw new Error(emailVazio.getMessage());
        }
        this.email = email;
    }
    public Email(Email email){

        try {
            this.validate(email.getEmail());
        } catch (EmailInvalido emailInvalido) {
            throw new Error(emailInvalido.getMessage());
        } catch (EmailVazio emailVazio) {
            throw new Error(emailVazio.getMessage());
        }
        this.email = email.getEmail();
    }

    public boolean validate(String email) throws EmailInvalido, EmailVazio {

        String pattern = "[A-Z a-z 0-9 !-~]{1,64}@{1}[A-Z a-z 0-9]{1,255}(.com)";
        if(email == "") throw new EmailVazio();
        if(!email.matches(pattern)) throw new EmailInvalido();
        return true;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
