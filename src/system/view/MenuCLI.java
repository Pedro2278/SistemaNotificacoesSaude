package system.view;

import system.model.*;
import system.repository.NotificacaoRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class MenuCLI {
    private final Scanner sc = new Scanner(System.in);
    private final NotificacaoRepository repo = new NotificacaoRepository();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n=== Sistema de Notificações de Saúde Pública ===");
            System.out.println("1. Registrar Notificação");
            System.out.println("2. Consultar Notificações");
            System.out.println("3. Gerar Relatórios");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = lerInt();

            switch (opcao) {
                case 1 -> registrarNotificacao();
                case 2 -> consultarNotificacoes();
                case 3 -> gerarRelatorios();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private void registrarNotificacao() {
        System.out.println("\n=== Registrar Notificação ===");

        String nome = lerString("Nome do paciente: ");
        String nomeMae = lerString("Nome da mãe: ");
        String sexo = lerSexo();
        int idade = lerIdade();
        String racaCor = lerRacaCor();
        String escolaridade = lerEscolaridade();
        String dataNascimento = lerData("Data de nascimento (dd/MM/yyyy): ", false);
        String numeroCartaoSUS = lerString("Número do cartão SUS: ");

        Agravo agravo = lerAgravo();
        LocalDate dataNotificacao = LocalDate.parse(lerData("Data da notificação (dd/MM/yyyy): ", true), formatter);
        String tipoNotificacao = lerTipoNotificacao();

        System.out.println("\n=== Endereço ===");
        String logradouro = lerString("Logradouro: ");
        String numero = lerString("Número: ");
        String complemento = lerString("Complemento: ");
        String bairro = lerString("Bairro: ");
        String municipio = lerString("Município: ");
        String uf = lerUF();
        String cep = lerCEP();
        String pais = lerString("País: ");
        String zona = lerZona();

        int numeroLesoes = lerInt("Número de lesões cutâneas: ");
        String classificacao = lerString("Classificação operacional: ");
        String formaClinica = lerString("Forma clínica: ");

        Paciente paciente = new Paciente(nome, nomeMae, sexo, idade, racaCor, escolaridade, dataNascimento, numeroCartaoSUS);
        Endereco endereco = new Endereco(logradouro, numero, complemento, bairro, municipio, uf, cep, pais, zona);
        Notificacao not = new Notificacao(paciente, agravo, dataNotificacao, tipoNotificacao, endereco, numeroLesoes, classificacao, formaClinica);

        repo.salvar(not);
        System.out.println("Notificação registrada com sucesso!");
    }

    private void consultarNotificacoes() {
        System.out.println("\n=== Consultar Notificações ===");
        System.out.println("1. Por nome");
        System.out.println("2. Por bairro");
        System.out.println("3. Por período");
        System.out.println("4. Por agravo");
        System.out.print("Escolha uma opção: ");
        int opcao = lerInt();

        List<Notificacao> resultados;
        switch (opcao) {
            case 1 -> {
                String nome = lerString("Digite o nome do paciente: ");
                resultados = repo.buscarPorNome(nome);
            }
            case 2 -> {
                String bairro = lerString("Digite o bairro: ");
                resultados = repo.buscarPorBairro(bairro);
            }
            case 3 -> {
                String inicio = lerData("Data inicial (dd/MM/yyyy): ", false);
                String fim = lerData("Data final (dd/MM/yyyy): ", false);
                resultados = repo.buscarPorPeriodo(LocalDate.parse(inicio, formatter), LocalDate.parse(fim, formatter));
            }
            case 4 -> {
                Agravo agravo = lerAgravo();
                resultados = repo.buscarPorAgravo(agravo);
            }
            default -> {
                System.out.println("Opção inválida!");
                return;
            }
        }

        if (resultados.isEmpty()) {
            System.out.println("Nenhuma notificação encontrada.");
        } else {
            resultados.forEach(n -> System.out.printf("Paciente: %s | Agravo: %s | Data: %s | Bairro: %s%n",
                    n.getPaciente().getNome(), n.getAgravo(), n.getDataNotificacao(), n.getEndereco().getBairro()));
        }
    }

    private void gerarRelatorios() {
        List<Notificacao> lista = repo.listar();
        System.out.println("\n=== Relatórios ===");

        System.out.println("\nTotal por Agravo:");
        lista.stream().map(Notificacao::getAgravo)
                .distinct().forEach(a -> System.out.println(a + ": " + lista.stream().filter(n -> n.getAgravo() == a).count()));

        System.out.println("\nTotal por Bairro:");
        lista.stream().map(n -> n.getEndereco().getBairro())
                .distinct().forEach(b -> System.out.println(b + ": " + lista.stream().filter(n -> n.getEndereco().getBairro().equals(b)).count()));

        System.out.println("\nTotal por Mês/Ano:");
        lista.stream().map(n -> n.getDataNotificacao().format(DateTimeFormatter.ofPattern("MM/yyyy")))
                .distinct().forEach(m -> System.out.println(m + ": " + lista.stream().filter(n -> n.getDataNotificacao().format(DateTimeFormatter.ofPattern("MM/yyyy")).equals(m)).count()));

        System.out.println("\nTotal por Sexo:");
        lista.stream().map(n -> n.getPaciente().getSexo())
                .distinct().forEach(s -> System.out.println(s + ": " + lista.stream().filter(n -> n.getPaciente().getSexo().equalsIgnoreCase(s)).count()));

        System.out.println("\nTotal por Faixa Etária:");
        lista.stream().map(n -> faixaEtaria(n.getPaciente().getIdade()))
                .distinct().forEach(f -> System.out.println(f + ": " + lista.stream().filter(n -> faixaEtaria(n.getPaciente().getIdade()).equals(f)).count()));

        System.out.println("\nTotal por Raça/Cor:");
        lista.stream().map(n -> n.getPaciente().getRacaCor())
                .distinct().forEach(r -> System.out.println(r + ": " + lista.stream().filter(n -> n.getPaciente().getRacaCor().equals(r)).count()));

        System.out.println("\nTotal por Escolaridade:");
        lista.stream().map(n -> n.getPaciente().getEscolaridade())
                .distinct().forEach(e -> System.out.println(e + ": " + lista.stream().filter(n -> n.getPaciente().getEscolaridade().equals(e)).count()));
    }

    private String faixaEtaria(int idade) {
        if (idade <= 10) return "0-10";
        if (idade <= 20) return "11-20";
        if (idade <= 30) return "21-30";
        if (idade <= 40) return "31-40";
        if (idade <= 50) return "41-50";
        if (idade <= 60) return "51-60";
        return "61+";
    }

    // ================== MÉTODOS DE LEITURA ==================
    private int lerInt() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Digite um número válido: ");
            }
        }
    }

    private int lerInt(String msg) {
        System.out.print(msg);
        return lerInt();
    }

    private String lerString(String msg) {
        System.out.print(msg);
        String valor;
        while ((valor = sc.nextLine().trim()).isEmpty()) {
            System.out.print("Campo obrigatório. " + msg);
        }
        return valor;
    }

    private String lerSexo() {
        System.out.print("Sexo (M/F/I): ");
        String s;
        while (true) {
            s = sc.nextLine().trim().toUpperCase();
            if (s.equals("M") || s.equals("F") || s.equals("I")) return s;
            System.out.print("Opção inválida. Digite M, F ou I: ");
        }
    }

    private String lerRacaCor() {
        System.out.println("Escolha a Raça/Cor:");
        System.out.println("1 - Branca");
        System.out.println("2 - Preta");
        System.out.println("3 - Amarela");
        System.out.println("4 - Parda");
        System.out.println("5 - Indígena");
        System.out.println("9 - Ignorado");
        int opc;
        while (true) {
            opc = lerInt();
            switch (opc) {
                case 1 -> { return "Branca"; }
                case 2 -> { return "Preta"; }
                case 3 -> { return "Amarela"; }
                case 4 -> { return "Parda"; }
                case 5 -> { return "Indígena"; }
                case 9 -> { return "Ignorado"; }
                default -> System.out.print("Opção inválida. Escolha novamente: ");
            }
        }
    }

    private String lerEscolaridade() {
        System.out.println("Escolha a Escolaridade:");
        System.out.println("0 - Analfabeto");
        System.out.println("1 - 1ª a 4ª série incompleta EF");
        System.out.println("2 - 4ª série completa EF");
        System.out.println("3 - 5ª a 8ª série incompleta EF");
        System.out.println("4 - Ensino fundamental completo");
        System.out.println("5 - Ensino médio incompleto");
        System.out.println("6 - Ensino médio completo");
        System.out.println("7 - Educação superior incompleta");
        System.out.println("8 - Educação superior completa");
        System.out.println("9 - Ignorado");
        System.out.println("10 - Não se aplica");
        int opc;
        while (true) {
            opc = lerInt();
            switch (opc) {
                case 0 -> { return "Analfabeto"; }
                case 1 -> { return "1ª a 4ª série incompleta EF"; }
                case 2 -> { return "4ª série completa EF"; }
                case 3 -> { return "5ª a 8ª série incompleta EF"; }
                case 4 -> { return "Ensino fundamental completo"; }
                case 5 -> { return "Ensino médio incompleto"; }
                case 6 -> { return "Ensino médio completo"; }
                case 7 -> { return "Educação superior incompleta"; }
                case 8 -> { return "Educação superior completa"; }
                case 9 -> { return "Ignorado"; }
                case 10 -> { return "Não se aplica"; }
                default -> System.out.print("Opção inválida. Escolha novamente: ");
            }
        }
    }

    private Agravo lerAgravo() {
        System.out.println("Agravos disponíveis: 1-HANSENIASE 2-TUBERCULOSE 3-MALARIA");
        int opc;
        while (true) {
            opc = lerInt();
            switch (opc) {
                case 1 -> { return Agravo.HANSENIASE; }
                case 2 -> { return Agravo.TUBERCULOSE; }
                case 3 -> { return Agravo.MALARIA; }
                default -> System.out.print("Opção inválida. Escolha novamente: ");
            }
        }
    }

    private String lerTipoNotificacao() {
        System.out.println("Escolha o Tipo de Notificação:");
        System.out.println("1 - Individual");
        System.out.println("2 - Coletiva");
        System.out.println("3 - Ignorado");
        int opc;
        while (true) {
            opc = lerInt();
            switch (opc) {
                case 1 -> { return "Individual"; }
                case 2 -> { return "Coletiva"; }
                case 3 -> { return "Ignorado"; }
                default -> System.out.print("Opção inválida. Escolha novamente: ");
            }
        }
    }

    private String lerUF() {
        String[] ufs = {"AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MT","MS","MG",
                        "PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR","SC","SP","SE","TO"};
        System.out.print("UF (ex: SP, RJ): ");
        String uf;
        while (true) {
            uf = sc.nextLine().trim().toUpperCase();
            for (String u : ufs) {
                if (uf.equals(u)) return uf;
            }
            System.out.print("UF inválida. Digite novamente: ");
        }
    }

    private String lerCEP() {
        System.out.print("CEP (somente números ou XXXXX-XXX): ");
        String cep;
        while (true) {
            cep = sc.nextLine().trim();
            if (cep.matches("\\d{5}-?\\d{3}")) return cep;
            System.out.print("CEP inválido. Digite novamente: ");
        }
    }

    private String lerZona() {
        System.out.println("Zona (1-Urbana 2-Rural 3-Periurbana 9-Ignorado): ");
        int opc;
        while (true) {
            opc = lerInt();
            switch (opc) {
                case 1 -> { return "Urbana"; }
                case 2 -> { return "Rural"; }
                case 3 -> { return "Periurbana"; }
                case 9 -> { return "Ignorado"; }
                default -> System.out.print("Opção inválida. Escolha novamente: ");
            }
        }
    }

    private String lerData(String msg, boolean naoFuturo) {
        System.out.print(msg);
        String data;
        while (true) {
            data = sc.nextLine().trim();
            try {
                LocalDate d = LocalDate.parse(data, formatter);
                if (naoFuturo && d.isAfter(LocalDate.now())) {
                    System.out.print("A data não pode ser futura. " + msg);
                } else {
                    return data;
                }
            } catch (DateTimeParseException e) {
                System.out.print("Formato inválido. Digite no formato dd/MM/yyyy: ");
            }
        }
    }

    private int lerIdade() {
        int idade;
        while (true) {
            idade = lerInt("Idade: ");
            if (idade >= 0 && idade <= 120) return idade;
            System.out.println("Idade inválida. Digite um valor entre 0 e 120.");
        }
    }
}
