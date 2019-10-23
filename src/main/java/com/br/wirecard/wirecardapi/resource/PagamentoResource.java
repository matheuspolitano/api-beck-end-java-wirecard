package com.br.wirecard.wirecardapi.resource;

import com.br.wirecard.wirecardapi.service.PagamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


@RestController
@RequestMapping
/*
* */
public class PagamentoResource {
    @PostMapping(value = "/")

    public ResponseEntity<List<String>> persist(@RequestBody final PagamentoService pagamentoService){
        //Executa a validação
        pagamentoService.validaçao();

      
        List<String> lista = new ArrayList <String>();

        lista = pagamentoService.getResponseList();

        

        return  new ResponseEntity<>(lista,HttpStatus.OK);
    }
}
