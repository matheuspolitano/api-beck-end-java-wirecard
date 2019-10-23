# Desafio Wirecard API


## Requisitos

For building and running the application you need:

- [Maven](http://maven.apache.org/download.cgi)
## Executar



mvn spring-boot:run execute esse comando na pasta do arquivo

## Porta

http://localhost:8080


## Postman


Modelo de dados para pagamento via cartão


{
    	"name":"Matheus Politano",
    	"cpf":"49073517800",
    	"email":"matheuspolitano1@gmail.com",
    	"amount":"50",
        "type":true,
        "card": "MasterCard",
        "cardHolderName": "Matheus Politano",
        "cardNumber": "123456789123",
        "cardExpirationDate": "12/2020",
        "cardCVV": "123"
    }


Modelo de dados para pagamento via boleto


{
    	"name":"Matheus Politano",
    	"cpf":"49073517800",
    	"email":"matheuspolitano1@gmail.com",
    	"amount":"50",
        "type":false
 
    }