package com.br.wirecard.wirecardapi.service;

import com.br.wirecard.wirecardapi.validation.PaymentValidation;

public class PagamentoService extends PaymentValidation {


    public void validaçao(){
        try {
            isEmail();
            payment();
        }catch (NullPointerException ex){
            this.setHavaError(true);
            this.setErros("Campos Incompletos ou preenchimento invalido");
        }



        if(isHavaError()==false) {
            setResponseList(getSuccess());

        }else{
            setResponseList(getErros());
        }




    }


}
