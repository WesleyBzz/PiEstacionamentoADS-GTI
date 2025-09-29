import java.util.ArrayList;

public class Estacionamento {
    String nomedoestacionamento;


    public String Nomedoestacionamento() {
        return nomedoestacionamento;
    }

    private ArrayList<Vagas> vagas;

    public Estacionamento() {
        this.nomedoestacionamento = "FastRoda.";
        vagas = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            double preço;
            if (i <= 5) {
                preço = 10.0; // Primeiras 5 vagas: R$ 8,00/hora
            } else {
                preço = 8.0; // Últimas 5 vagas: R$ 10,00/hora
            }
            vagas.add(new Vagas(i,"comum", preço));
        }
    }

    public String getNomedoestacionamento() {
        return nomedoestacionamento;
    }

    public ArrayList<Vagas> getVagas() {
        return vagas;
    }

    public void mostrarVagas() {
        for (Vagas vaga : vagas) {
            System.out.println(vaga);
        }
    }

    public Vagas getVagaPorNumero(int numero) {
        for (Vagas v : vagas) {
            if (v.getNumero() == numero) {
                return v;
            }
        }
        return null;
    }
}
