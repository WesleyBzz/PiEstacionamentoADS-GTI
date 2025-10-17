package entidades;

public class Vaga {
    private int Numero;
    private boolean disponivel;
    private String tipo;
    private double precoHora;

    public Vaga (int numero, String tipo, double precoHora){
        this.Numero = numero;
        this.disponivel = true;
        this.tipo = tipo;
        this.precoHora = precoHora;}


    //métodos

    public void ocupar() {
        this.disponivel = false;}

    public void liberar() {
        this.disponivel = true;}

    //  retorna se está disponível
    public boolean isDisponivel() {
        return disponivel;}

    //getters e setters

    public int getNumero() {
        return Numero;}

    public void setnumero(int numero) {
        this.Numero = numero;}

    public double getPrecoHora() {
        return precoHora;}

    public void setPrecoHora(double precoHora) {
        this.precoHora = precoHora;}

    public String getTipo() {
        return tipo;}

    public void setTipo(String tipo) {
        this.tipo = tipo;}

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;}


    @Override
    public String toString() {
        String status;
        if (disponivel) {
            status = "DISPONÍVEL";
        } else {
            status = "OCUPADA";
        }

        return "Vaga " + Numero + " (" + tipo + ") - " + status + " | R$" + precoHora + "/hora";
    }
}
