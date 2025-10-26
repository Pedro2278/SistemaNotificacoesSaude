package system.view;

import system.repository.NotificacaoRepository;
import system.model.*;

import java.time.LocalDate;
import java.util.Scanner;

public class MenuCLI {

    private Scanner scanner = new Scanner(System.in);
    private NotificacaoRepository repo = new NotificacaoRepository();

    public void exibirMenu() {
        int opcao = -1;

        while(opcao != 0) {
            System.out.println("==== Sistema de Notificações de Saúde Pública ====");
            System.out.println("1. Registrar Notificação");
            System.out.println("2. Consultar Notificações");
            System.out.println("3. Gerar Relatórios");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir o ENTER

            switch(opcao) {
                case 1:
                    registrarNotificacao();
                    break;
                case 2:
                    System.out.println("Consultar Notificações selecionado");
                    break;
                case 3:
                    System.out.println("Gerar Relatórios selecionado");
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void registrarNotificacao() {
        System.out.println("=== Registrar Notificação ===");

        System.out.print("Nome do paciente: ");
        String nome = scanner.nextLine();

        System.out.print("Nome da mãe: ");
        String nomeMae = scanner.nextLine();

        System.out.print("Sexo (M/F/I): ");
        String sexo = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Raça/Cor: ");
        String raca = scanner.nextLine();

        System.out.print("Escolaridade: ");
        String escolaridade = scanner.nextLine();

        System.out.print("Data de nascimento (dd/MM/yyyy): ");
        String dataNascimento = scanner.nextLine();

        System.out.print("Número do cartão SUS: ");
        String cartaoSUS = scanner.nextLine();

        Paciente paciente = new Paciente(nome, nomeMae, sexo, idade, raca, escolaridade, dataNascimento, cartaoSUS);

        System.out.println("Agravos disponíveis: 1-HANSENIASE 2-TUBERCULOSE 3-MALARIA");
        int agr = scanner.nextInt();
        scanner.nextLine();
        Agravo agravo = switch (agr) {
            case 1 -> Agravo.HANSENIASE;
            case 2 -> Agravo.TUBERCULOSE;
            case 3 -> Agravo.MALARIA;
            default -> Agravo.HANSENIASE;
        };

        System.out.print("Data da notificação (dd/MM/yyyy): ");
        String dataNotif = scanner.nextLine();
        LocalDate data = LocalDate.parse(dataNotif, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.print("Tipo de notificação: ");
        String tipo = scanner.nextLine();

        System.out.print("Logradouro: ");
        String logradouro = scanner.nextLine();

        System.out.print("Número: ");
        String numero = scanner.nextLine();

        System.out.print("Complemento: ");
        String complemento = scanner.nextLine();

        System.out.print("Bairro: ");
        String bairro = scanner.nextLine();

        System.out.print("Município: ");
        String municipio = scanner.nextLine();

        System.out.print("UF: ");
        String uf = scanner.nextLine();

        System.out.print("CEP: ");
        String cep = scanner.nextLine();

        System.out.print("País: ");
        String pais = scanner.nextLine();

        System.out.print("Zona (Urbana/Rural/Periurbana): ");
        String zona = scanner.nextLine();

        Endereco endereco = new Endereco(logradouro, numero, complemento, bairro, municipio, uf, cep, pais, zona);

        System.out.print("Número de lesões cutâneas: ");
        int lesoes = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Classificação operacional: ");
        String classificacao = scanner.nextLine();

        System.out.print("Forma clínica: ");
        String formaClinica = scanner.nextLine();

        Notificacao not = new Notificacao(paciente, agravo, data, tipo, endereco, lesoes, classificacao, formaClinica);

        repo.salvar(not);
        System.out.println("Notificação registrada com sucesso!");
    }
}
