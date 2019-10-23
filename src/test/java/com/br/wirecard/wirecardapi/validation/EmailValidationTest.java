package com.br.wirecard.wirecardapi.validation;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class EmailValidationTest extends EmailValidation {

    @Test
    /*Esse metodo tem como objetivo testar
    * a função isEmail que valida os es email na aplicação
    * atribuimos um email invalido e a função tem que retornar True
    * */
    public void testaEmailInvalido(){
        setEmail("fsdfsdfsdfsdfsdf");
        isEmail();
        Boolean teste =this.isHavaError();


        assertThat(teste).isEqualTo(true);

    }
    @Test
    /*Esse metodo tem como objetivo testar
     * a função isEmail que valida os es email na aplicação
     * atribuimos um email valido e a função tem que retornar false
     * */
    public void testaEmaiValido(){
        setEmail("matheusteste@gmail.com");
        isEmail();
        Boolean teste =this.isHavaError();


        assertThat(teste).isEqualTo(false);

    }
}
