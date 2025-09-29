package InformaçõesClientes.InformaçõesCadastro;
import java.util.Scanner;

abstract class User { // HERANÇA CLIENTE

    private String nome;
    private String email;
    private String numerotelefone;


//metodos acessores e modificadores

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getNumerotelefone(){
        return numerotelefone;
    }

    public void setNumerotelefone(String numerotelefone){
        this.numerotelefone = numerotelefone;
    }

}

