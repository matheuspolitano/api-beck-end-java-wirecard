package com.br.wirecard.wirecardapi.validation;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
public class PaymentValidationTest extends PaymentValidation {

    /*executado esperando a geração do boleto corretamente,
     *perceba que o campo type é false e que os campos de cartão não precisão serem preenchidos e a variável
    *CPF recebe um CPF válido, portanto List success será copulada*/
    @Test
    public void gerarBoleto()
    {
        this.setAmount(50);
        this.setName("Matheus");
        this.setCpf("49073517800");
        this.setType(false);
        this.payment();
        assertThat(getSuccess().size()).isEqualTo(2);

    }
    /*O segundo método recebe um CPF
    *invalido, portanto a List Erros será copulada*/
    @Test
    public void erroParaGerarBoleto()
    {
        this.setAmount(50);
        this.setName("Matheus");

        //CPF invalido
        this.setCpf("49073517");

        this.setType(false);
        this.payment();
        assertThat(getErros().size()).isEqualTo(1);

    }
    /*é executado sem a atribuição para o
    *cardNumber, portanto List Erros será copulada
    * */
    @Test
    public void erroNaValidacaoDoCartaoPorTerNumberNull()
    {
        this.setType(true);
        this.setCard("MasterCard");
        /*
        CardNumber recebe null
        this.setCardNumber("123456789123");
         */this.setCardHolderName("Matheus Politano");
         this.setCardExpirationDate("05/2020");
         this.setCardCVV("123");
         this.payment();
         assertThat(getErros().size()).isEqualTo(1);
    }
    /*recebe todos os dados corretamente porém os
     *nome do cliente é diferente do nome do
     *titular do cartão o que não irá permitir a
    *transação e a List Erros será copulada
    * */
    @Test
    public void divergenciaNoNomeCard()
    {
        this.setName("Matheus Gabriel");
        this.setType(true);
        this.setCard("MasterCard");

        this.setCardNumber("123456789123");
        this.setCardHolderName("Matheus Politano");
        this.setCardExpirationDate("05/2020");
        this.setCardCVV("123");
        this.payment();
        assertThat(getErros().size()).isEqualTo(1);
    }
    /*
    executado com dados invalida de vencimento, portanto a transação não
    *será permitida, e a List Erros será copulada
    * */
    @Test
    public void dataDeVencimentoInvalida()
    {
        this.setName("Matheus Politano");
        this.setType(true);
        this.setCard("MasterCard");

        this.setCardNumber("123456789123");
        this.setCardHolderName("Matheus Politano");
        this.setCardExpirationDate("05/2015");
        this.setCardCVV("123");
        this.payment();
        assertThat(getErros().size()).isEqualTo(1);
    }
    /*
    * executado com todos os dados atribuído de maneira correta
    *  portanto o transação via cartão será feita com sucesso
    * */
    @Test
    public void pagamentoFeitoComSuccesso()
    {
        this.setName("Matheus Politano");
        this.setType(true);
        this.setCard("MasterCard");

        this.setCardNumber("123456789123");
        this.setCardHolderName("Matheus Politano");
        this.setCardExpirationDate("05/2020");
        this.setCardCVV("123");
        this.payment();
        assertThat(getSuccess().size()).isEqualTo(2);
    }


}
