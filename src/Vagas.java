public class Vagas {


    private int numero;
    private boolean disponivel;
    private String tipo;
    private double precoHora;

    // Construtor
    public Vagas(int numero, String tipo, double precoHora) {
        this.numero = numero;
        this.tipo = tipo;
        this.precoHora = precoHora;
        this.disponivel = true;
    }
    // Getters
    public int getNumero() {
        return numero;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecoHora() {
        return precoHora;
    }

    // Setters
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPrecoHora(double precoHora) {
        this.precoHora = precoHora;
    }

    // Métodos para ocupar ou liberar vaga
    public void ocupar() {
        this.disponivel = false;
    }

    public void liberar() {
        this.disponivel = true;
    }

    public double getPreço() {
        return precoHora;
    }

    // Para exibir dados da vaga
    public String toString() {

        String status;
        if (disponivel) {
            status = " Disponivel";
        } else {
            status = "indisponivel";
        }

        return "Vaga nº " + numero + " (" + tipo + ") - " +
                (disponivel ? "Disponível" : "Ocupada") +
                " | Preço/hora: R$" + precoHora;
    }
}



