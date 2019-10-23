package com.br.wirecard.wirecardapi.validation;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.ThreadLocalRandom;

public class PaymentValidation extends EmailValidation {
    /*Esse método aplica as regras
    de negocio para o pagamento
    * */
    public void payment(){
        /*O tipo type caso seja true determina que o
        * pagamento será feito através
        * do cartão de crédito, e caso seja
        * false a transação ocorrerá via
        * boleto
        * */
        if(this.getType() == true){
            Calendar c = new GregorianCalendar();
            Calendar f = Calendar.getInstance();
            /*A primeira regra de negocio é verificar se as informações
            * do cartão estão preechida caso nenhum campo seja null a regra de negócio
            * irá para a segunda etapa. Nessa etapa ocorre também a verificação no preenchimento adequado
            * de alguns campos como CVV, data de validade do cartão e o numero do cartão
            * */
            if(this.getCardCVV() != null && this.getCard() != null && this.getCardExpirationDate() != null &&this.getCardHolderName() != null &&this.getCardNumber() != null && this.getCardCVV().length() == 3 && this.getCard() != null && this.getCardExpirationDate().length() == 7  &&this.getCardNumber().length() == 12 ){
                /*A segunda faze da validação é verificar se o nome do comprador
                * e o nome do titular do cartão são correspondente, caso o contrario o cartão
                * negará a transação
                * */
                if(this.getCardHolderName().equals(this.getName())){
                try {
                    c.set(Calendar.YEAR,Integer.parseInt(getCardExpirationDate().split("/")[1]));
                    c.set(Calendar.MONTH,Integer.parseInt(getCardExpirationDate().split("/")[0]));
                    System.out.println(c.after(f));
                }catch(Exception ex){
                    this.setErros("Formato invalido da data de validade do cartão");
                }
                /*A terceira etapa da regra de negocio é verificar se a data de validae é superior a data atual
                * caso a data seja anterior ao da campra a regra de negocio negara a negociação*/
                 if(c.after(f)){
                     if(isHavaError()==false)
                     {
                         this.setSuccess("Cartão");
                         this.setSuccess("Pagamento aprovado");
                     }
                 }else {
                     this.setHavaError(true);
                     this.setErros("Transação negada : Cartão invalido, pois já está vencido");

                 }

             }else {

                 this.setHavaError(true);
                 this.setErros("Transação negada : O nome de cadastro é diferente do titular do cartão");

             }

         }else{
             this.setHavaError(true);
             this.setErros("dados do cartão imcompleto");
         }
        }else {

            /*======================BOLETO=================================================
            *Para chegar até aqui é necessário que o type seja false
            *
            *
            * Essa if  é responsável pela validação dos dados
            * para geração do bolero
            * */
            if (getCpf().length()==11 && getName()!= null && getCpf() != "0")
            {
             /*Aqui é gerado o numero do boleto
             * */
            Integer rand_int1 = ThreadLocalRandom.current().nextInt();
            while (rand_int1 < 0){
                rand_int1 = ThreadLocalRandom.current().nextInt();
            }
            this.setSuccess("Boleto");
            this.setSuccess(rand_int1.toString());
            this.getErros();
            /*Todos os campos que não fazem parte
            * do scopo do boleto serão atribuidos o valor
            * null*/
            setCard(null);
            setCardCVV(null);
            setCardExpirationDate(null);
            setCardHolderName(null);
            setCardNumber(null);
        }
            else   {
                this.setHavaError(true);
                this.setErros("CPf invalido ou nome null");
            }
        }

    }

    }





