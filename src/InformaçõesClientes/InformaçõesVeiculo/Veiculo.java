package InformaçõesClientes.InformaçõesVeiculo;

abstract class Veiculo {  // HERANÇA DADOS DO VEICULO

    String modeloveiculo;

    String placa;

    String cordoveiculo;

//GETTER AND SETTER

    //MODELO

    public String getModeloveiculo() {
        return modeloveiculo;
    }

    public void setModeloveiculo(String modeloveiculo) {
        this.modeloveiculo = modeloveiculo;
    }

// PLACA

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

// COR DO VEICULO

    public String getCor() {
        return cordoveiculo;
    }

    public void setCor(String cor) {
        this.cordoveiculo = cordoveiculo;
    }

}

