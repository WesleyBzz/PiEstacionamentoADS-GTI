import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entidades.Estacionamento;
import entidades.Cliente;
import entidades.Vaga;
import entidades.Veiculo;

public class App {
    public static void main(String[] args) {

        // LISTAS para armazenar os dados
        List<Cliente> clientes = new ArrayList<>();
        List<Veiculo> veiculos = new ArrayList<>();
        List<Integer> vagasOcupadas = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        Estacionamento estacionamento = new Estacionamento();
        int opcao;

        // Recuperar vagas ocupadas persistentes, se existir essa funcionalidade
        for (Integer numero : vagasOcupadas) {
            estacionamento.ocuparVagaPersistente(numero);
        }

        do {


            System.out.println("\n=== ESTACIONAMENTO FASTRODA ===");
            System.out.println("1. Adicionar Cliente + Veículo");
            System.out.println("2. Lista de Clientes + Veículos");
            System.out.println("3. Buscar Clientes");
            System.out.println("4. Informações de Vagas");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("--- CADASTRAR CLIENTE + VEÍCULO ---");

                    // CADASTRO DO CLIENTE - NOME
                    boolean nomeValido = false;
                    String nome = "";
                    while (!nomeValido) {
                        System.out.print("Digite nome e sobrenome: ");
                        nome = scanner.nextLine();
                        if (nome.contains(" ")) {
                            nomeValido = true;
                        } else {
                            System.out.println("Erro: Digite nome E sobrenome!");
                        }
                    }

                    // CADASTRO DO CLIENTE - EMAIL
                    System.out.print("\033[H\033[2J"); // envia o console para cima
                    System.out.flush();

                    boolean emailValido = false;
                    String email = "";
                    while (!emailValido) {
                        System.out.print("Digite seu email: ");
                        email = scanner.nextLine();
                        if (email.contains("@") && email.contains(".")) {
                            emailValido = true;
                        } else {
                            System.out.println("Email inválido! Deve conter '@' e '.'");
                        }
                    }

                    // CADASTRO DO CLIENTE - TELEFONE
                    System.out.print("\033[H\033[2J"); // envia o console para cima
                    System.out.flush();

                    boolean telefoneValido = false;
                    String telefone = "";
                    while (!telefoneValido) {
                        System.out.print("Digite telefone (XX) XXXXX-XXXX: ");
                        telefone = scanner.nextLine();
                        if (telefone.matches("^\\(\\d{2}\\)\\s\\d{5}-\\d{4}$")) {
                            telefoneValido = true;
                        } else {
                            System.out.println("Formato: (XX) XXXXX-XXXX");
                        }
                    }

                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("=== DADOS DO VEÍCULO ===");

                    // CADASTRO DO VEÍCULO
                    System.out.print("Tipo do veículo: ");
                    String tipoVeiculo = scanner.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Placa: ");
                    String placa = scanner.nextLine();
                    System.out.print("Cor: ");
                    String cor = scanner.nextLine();

                    // CRIAR OS OBJETOS
                    Cliente cliente = new Cliente(nome, email, telefone);
                    Veiculo veiculo = new Veiculo(modelo, placa, cor, tipoVeiculo);

                    
                    System.out.println("CADASTRO REALIZADO!");
                    System.out.println("Cliente: " + cliente.getNome());
                    System.out.println("Veículo: " + veiculo.getModelo() + " - " + veiculo.getPlaca());

                    // OFERECER VAGA
                    System.out.println("\n--- VAGAS DISPONÍVEIS ---");

                    // Lista todas as vagas disponíveis
                    for (Vaga vaga : estacionamento.getVagas()) {
                        if (vaga.isDisponivel()) {
                            System.out.println("Vaga " + vaga.getNumero() + " (" + vaga.getTipo() +
                                            ") - R$" + vaga.getPrecoHora() + "/hora");
                        }
                    }

                    // Agora, pergunta qual vaga o usuário quer
                    System.out.print("\nDigite o número da vaga que deseja ocupar: ");
                    int numeroVaga = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("\033[H\033[2J"); // envia o console para cima
                    System.out.flush();

                    // Tenta ocupar a vaga
                    boolean sucesso = estacionamento.ocuparVagas(numeroVaga);

                    if (sucesso) {
                        vagasOcupadas.add(numeroVaga);
                        System.out.println(" Vaga " + numeroVaga + " ocupada com sucesso!");
                        System.out.println("Veículo " + veiculo.getPlaca() + " estacionado");
                    } else {
                        System.out.println("X Não foi possível ocupar a vaga " + numeroVaga);
                    }

                    // ADICIONAR ÀS LISTAS (SEMPRE, MESMO SEM VAGA)
                    clientes.add(cliente);
                    veiculos.add(veiculo);
                    break;

                case 2:
                    
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("--- LISTA DE CLIENTES + VEÍCULOS ---");

                    if (clientes.isEmpty()) {
                        System.out.println("Nenhum cliente cadastrado!");
                    } else {
                        for (int i = 0; i < clientes.size(); i++) {
                            Cliente c = clientes.get(i);
                            Veiculo v = veiculos.get(i);

                            System.out.println(" " + c.getNome() + " | " + c.getEmail() + " | " + c.getTelefone());
                            System.out.println(" " + v.getModelo() + " - " + v.getPlaca() + " - " + v.getCor());
                            System.out.println("-----------------------------------");
                        }
                    }
                    break;

                case 3:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("--- BUSCAR CLIENTES ---");

                    if (clientes.isEmpty()) {
                        System.out.println("Nenhum cliente cadastrado!");
                    } else {
                        System.out.print("Digite o nome para buscar: ");
                        String nomeBusca = scanner.nextLine();

                        boolean encontrou = false;
                        for (int i = 0; i < clientes.size(); i++) {
                            Cliente c = clientes.get(i);
                            Veiculo v = veiculos.get(i);

                            if (c.getNome().toLowerCase().contains(nomeBusca.toLowerCase())) {
                                System.out.println(" CLIENTE ENCONTRADO:");
                                System.out.println(" " + c.getNome() + " | " + c.getEmail() + " | " + c.getTelefone());
                                System.out.println(" " + v.getModelo() + " - " + v.getPlaca() + " - " + v.getCor());
                                encontrou = true;
                                break;
                            }
                        }

                        if (!encontrou) {
                            System.out.println(" Cliente não encontrado!");
                        }
                    }
                    break;

                case 4:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("--- INFORMAÇÕES DE VAGAS ---");

                    int vagasLivres = 0;
                    int vagasOcupadasCount = 0;

                    for (Vaga vaga : estacionamento.getVagas()) {
                        if (vaga.isDisponivel()) {
                            vagasLivres++;
                        } else {
                            vagasOcupadasCount++;
                        }
                    }

                    System.out.println(" RESUMO:");
                    System.out.println("Vagas Livres: " + vagasLivres);
                    System.out.println("Vagas Ocupadas: " + vagasOcupadasCount);
                    System.out.println("Total: " + estacionamento.getVagas().size() + " vagas");

                    System.out.println("\n--- DETALHES DAS VAGAS ---");
                    for (Vaga vaga : estacionamento.getVagas()) {
                        String status = vaga.isDisponivel() ? "LIVRE" : "OCUPADA";
                        System.out.println("Vaga " + vaga.getNumero() + " (" + vaga.getTipo() + 
                                        "): " + status + " - R$" + vaga.getPrecoHora() + "/hora");
                    }

                    // MOSTRAR VAGAS OCUPADAS DO SISTEMA
                    if (!vagasOcupadas.isEmpty()) {
                        System.out.println("\n--- VAGAS OCUPADAS NO SISTEMA ---");
                        for (Integer numero : vagasOcupadas) {
                            System.out.println("Vaga " + numero + " - OCUPADA");
                        }
                    }
                    break;

                case 5:
                    System.out.print("\033[H\033[2J"); // envia o console para cima
                    System.out.flush();
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 5);

        scanner.close();
    }
}
