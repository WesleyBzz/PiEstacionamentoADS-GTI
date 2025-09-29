import java.util.Scanner;

import InformaçõesClientes.InformaçõesCadastro.Cliente;
import InformaçõesClientes.InformaçõesVeiculo.DadosDoVeiculo;

public class App {

    // Criando Usuario CLIENTE

    public static void main(String[] args) {

        //criando usuario

        Cliente usuario = new Cliente();
        usuario.getNome();
        usuario.getEmail();
        usuario.getNumerotelefone();

        // CADRASTRO USUARIO - GUARDAR DADOS DO CLIENTE

        String telefoneDigitado = "";
        String emailDigitado = "";
        String nomeDigitado = "";

        // CADASTRO VEICULO - GUARDAR DADOS DO VEICULO

        DadosDoVeiculo veiculoCliente = new DadosDoVeiculo();

        String corDigitada;
        String placaDigitada;
        String modeloDigitado;


        // criando um scanner para receber os dados
        Scanner scanner = new Scanner(System.in);

        //estancia da classe estacionamento
        Estacionamento estacionamento = new Estacionamento();
        System.out.println("Bem vindo ao estacionamento " + estacionamento.getNomedoestacionamento());


        //variável de controle
        boolean repostaValida = false;

        String email;
        String numerotelefone = "";

        //estrutura de repetição
        //enquanto "resposta valida" for false, o cadastro será pedido novamente
        String info = null;
        while (!repostaValida) {


            // cadastro do usuario


            System.out.println("-----------------------------------");
            System.out.println("Vamos dar inicio ao seu cadastro");
            System.out.println("-----------------------------------");

            //NOME

            boolean nomeValido = false;
            while (!nomeValido) {
                System.out.println("Por favor digite seu nome e sobrenome:");
                nomeDigitado = scanner.nextLine();

                if (nomeDigitado.contains(" ")) {
                    nomeValido = true;
                } else {
                    System.out.println("Erro: nome inválido. Deve conter 'Nome e Sobrenome'.");
                }
            }

            // GUARDANDO NOME

            usuario.setNome(nomeDigitado);
            System.out.println("Nome armazenado: " + usuario.getNome());

            //E-MAIL
            boolean emailValido = false;
            while (!emailValido) {
                System.out.println("Digite seu email:");
                emailDigitado = scanner.nextLine();

                if (emailDigitado.contains("@")) {
                    emailValido = true;
                } else {
                    System.out.println("Erro: E-mail inválido. Deve conter '@'.");
                }
            }

            //GUARDANDO EMAIL

            usuario.setEmail(emailDigitado);
            System.out.println("Email armazenado: " + usuario.getEmail());

            //TELEFONE

            boolean telefoneValido = false;
            while (!telefoneValido) {
                System.out.println("Digite seu telefone COM DDD EXEMPLO (19) 99999-9999");
                telefoneDigitado = scanner.nextLine();

                if (telefoneDigitado.matches("^\\(\\d{2}\\)\\s\\d{5}-\\d{4}$") ){
                    telefoneValido = true;
                } else {
                    System.out.println(" Erro: seu número deve conter um: (DDD) 99999-9999");
                }
            }
            // GUARDANDO TELEFONE

            usuario.setNumerotelefone(telefoneDigitado);
            System.out.println("Telefone armazenado: " + usuario.getNumerotelefone());

            //COMFIRMAÇÃO DE DADOS

            System.out.println("Por favor " + nomeDigitado + " confirme seus dados:");
            System.out.println("Email: " + emailDigitado);
            System.out.println("Numero de telefone: " + telefoneDigitado);


            System.out.println("Suas informações estão corretas? (sim/não)");
            info = scanner.nextLine();

            // verificação da resposta

            //se o usuario confirmar os dados sai do loop:
            if (info.equals("sim")) {
                System.out.println("Próxima etapa");
                System.out.println(nomeDigitado + " agora os dados do seu veiculo!");
                repostaValida = true;

                //se estiver errado,mantem respostaValida = false, para repetir o cadastro
            } else if (info.equals("não") || info.equals("nao")) {
                System.out.println("Realize o cadastro novamente!");
                repostaValida = false;

                // caso digite algo diferente de "sim" ou "não"
                //também respostaValida = false, repetindo o cadastro
            } else {
                System.out.println("Resposta não reconhecida. Digite 'sim' ou 'não'");
                repostaValida = false;

            }
        }


        // MODELO DO VEICULO - SCANNER
        System.out.println("-----------------------------------");

        System.out.println("Digite o Modelo do seu veiculo:");
        modeloDigitado = scanner.nextLine();

        // GUARDANDO MODELO
        veiculoCliente.setModeloveiculo(modeloDigitado);

        System.out.println("Modelo armazenado: " + veiculoCliente.getModeloveiculo());


        System.out.println("Digite a placa do seu veiculo: ");
        placaDigitada = scanner.nextLine();

        // Guardando nome dentro de user
        veiculoCliente.setPlaca(placaDigitada);

        System.out.println("Placa armazenado: " + veiculoCliente.getPlaca());

        System.out.println("Digite a cor do seu veiculo");
        corDigitada = scanner.nextLine();

        // Guardando nome dentro de user
        veiculoCliente.setCor(corDigitada);

        System.out.println("Cor armazenada: " + veiculoCliente.getCor());

        // confirmação dos dados do carro
        System.out.println("-----------------------------------");
        System.out.println("Por favor " + " confime os dados do seu vaiculo:");
        System.out.println("Nome do veiculo: " + modeloDigitado);
        System.out.println("Placa do veiculo" + placaDigitada);
        System.out.println("Cor do veiculo" + corDigitada);

        //veriffcação dos dados do veiculo

        if (info.equals("sim")) {
            System.out.println("Próxima etapa");
            System.out.println("Por favor, escolha uma vaga " + nomeDigitado);
            repostaValida = true;

            //se estiver errado,mantem respostaValida = false, para repetir o cadastro
        } else if (info.equals("não") || info.equals("nao")) {
            System.out.println("Realize o cadastro novamente!");
            repostaValida = false;

            // caso digite algo diferente de "sim" ou "não"
            //também respostaValida = false, repetindo o cadastro
        } else {
            System.out.println("Resposta não reconhecida. Digite 'sim' ou 'não'");
            repostaValida = false;

        }


        // mostrar todas as vagas
        estacionamento.mostrarVagas();

        System.out.print("Digite o número da vaga que deseja ocupar: ");
        int numVaga = scanner.nextInt();

        Vagas vagaEscolhida = estacionamento.getVagaPorNumero(numVaga);

        if (vagaEscolhida != null && vagaEscolhida.isDisponivel()) {
            vagaEscolhida.ocupar();
            System.out.println("Você ocupou a vaga " + vagaEscolhida.getNumero() +
                    " por R$" + vagaEscolhida.getPreço());
        } else {
            System.out.println("Vaga inválida ou já ocupada.");
        }

        // mostrar vagas de novo
        System.out.println("\nVagas atualizadas:");
        estacionamento.mostrarVagas();
    }
}