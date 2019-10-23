package com.br.wirecard.wirecardapi.validation;

import com.br.wirecard.wirecardapi.model.ModelPagamento;

import java.util.ArrayList;
import java.util.List;

public class InitValidation extends ModelPagamento {
    List<String> responseList = new ArrayList<String>();
    private boolean havaError;
    private List<String> erros = new ArrayList<String>();
    private List<String> success = new ArrayList<String>();




    public InitValidation() {
        setHavaError(false);
    }

    public boolean isHavaError() {
        return havaError;
    }

    public void setHavaError(boolean havaError) {
        this.havaError = havaError;
    }

    public List<String> getErros() {
        return erros;
    }

    public void setErros(String erros) {
        this.erros.add(erros);
    }

    public List<String> getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success.add(success);
    }
    public List<String> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<String> responseList) {
        this.responseList = responseList;
    }

}
