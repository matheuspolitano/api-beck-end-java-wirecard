package com.br.wirecard.wirecardapi.service;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class PagamentoServiceTest extends PagamentoService {
    @Test
    /*teste é executado para cair no
    catch e copular a List Erros. */
    public void tratamentoDeErroComDadosNull()
    {

        this.validaçao();
        assertThat(getErros().size()).isEqualTo(1);



    }
    @Test/*todos os dados válido com o type True para que o
    *pagamento seja por cartão e não haverá nenhum erro
    */
    public void validacaoPassandoTodosOsParametrosCorretamenteComPagementoNoCartao()
    {
        this.setCpf("49073517800");
        this.setAmount(50);
        this.setEmail("matheusteste@gmail.com");
        this.setName("Matheus Politano");
        this.setType(true);
        this.setCard("MasterCard");

        this.setCardNumber("123456789123");
        this.setCardHolderName("Matheus Politano");
        this.setCardExpirationDate("05/2020");
        this.setCardCVV("123");
        this.validaçao();
        System.out.println(this.getSuccess());
        assertThat(this.getSuccess().size()).isEqualTo(2);
    }
    @Test
    /*atribui todos os dados corretamente com type
    *false portanto o pagamento será feito via boletoatribui todos os dados corretamente com type
    *false portanto o pagamento será feito via boleto
    * */
    public void validacaoPassandoTodosOsParametrosCorretamenteComPagementoNoBoleto()
    {
        this.setCpf("49073517800");
        this.setAmount(50);
        this.setEmail("matheusteste@gmail.com");
        this.setName("Matheus Politano");
        this.setType(false);

        this.validaçao();
        System.out.println(this.getSuccess());
        assertThat(this.getSuccess().size()).isEqualTo(2);
    }


}
