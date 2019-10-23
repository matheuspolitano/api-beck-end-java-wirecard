package com.br.wirecard.wirecardapi.validation;

public class EmailValidation extends InitValidation {
             public void isEmail() {

            String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
            this.setHavaError(!getEmail().matches(regex));
            if (isHavaError()==true){
                setErros("Email invalido");
            }


}}
