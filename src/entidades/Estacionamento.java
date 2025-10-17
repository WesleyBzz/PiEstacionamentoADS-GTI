package entidades;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

   private String nome;
    private List<Vaga> vagas;

    //construtor
    public Estacionamento() {
        this.nome = "FASTRODA";
        this.vagas = new ArrayList<>();

        //criando as vagas
        for (int i = 1; i <= 10; i++) {
            double preco;
            String tipo;

            //colocando preços
            if (i <= 5) {
                preco = 10.00;
            } else {
                preco = 8.00;
            }

            //criando os tipos
            if (i == 4 || i == 5) {
                tipo = "idoso";
            } else if (i == 3) {
                tipo = "deficiente";
            } else {
                tipo = "comum";
            }
            vagas.add(new Vaga(i, tipo, preco));
        }
    }

    //ver todas as vagas
    public void mostrarVagas() {
        System.out.println("VAGAS DO ESTACIONAMENTO ");
        for (Vaga vaga : vagas) {
            System.out.println(vaga);
        }
    }

    //procurar por vaga especifica
    public Vaga getVagaPorNumero(int numero) {
        for (Vaga vaga : vagas) {
            if (vaga.getNumero() == numero) {
                return vaga;
            }
        }
        return null;
    }
    public boolean ocuparVagas(int numero) {
        Vaga vaga = getVagaPorNumero(numero);

        // verifica se a vaga existe
        if (vaga == null) {
            System.out.println("Vaga " + numero + " não existe!");
            return false;
        }

        //ocupa as vagas
        if (vaga.isDisponivel()) {
            vaga.ocupar();
            System.out.println("Vaga " + numero + " ocupada com sucesso!");
            return true;
        } else {
            System.out.println("Vaga " + numero + " já está ocupada!");
            return false;
        }

    }
    public boolean liberarVaga(int numero) {
        Vaga vaga = getVagaPorNumero(numero);

        //verifica se a vga está disponivel
        if (vaga == null) {
            System.out.println("Vaga " + numero + " não existe!");
            return false;
        }
         // verifica se está ocupada
        if (vaga.isDisponivel()) {
            System.out.println("Vaga " + numero + " já está liberada!");
            return false;
        } else {
            vaga.liberar();
            System.out.println("Vaga " + numero + " liberada com sucesso!");
            return true;
        }
    }
    public void vagasDisponiveis() {
        System.out.println(" VAGAS DISPONÍVEIS ");
        boolean encontrouDisponivel = false;

        for (Vaga vaga : vagas) {
            if (vaga.isDisponivel()) {
                System.out.println(vaga);
                encontrouDisponivel = true;
            }
        }

        if (!encontrouDisponivel) {
            System.out.println("Nenhuma vaga disponível no momento!");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Vaga> getVagas() {
        return vagas;
    }

    public void setVagas(List<Vaga> vagas) {
        this.vagas = vagas;


        
    }
    
    public void ocuparVagaPersistente(int numero) {
    Vaga vaga = getVagaPorNumero(numero);
    if (vaga != null && vaga.isDisponivel()) {
        vaga.ocupar();
    }
    }
}