package system.repository;

import system.model.*;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NotificacaoRepository {
    private final String arquivo = "notificacoes.txt";
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Salvar notificação
    public void salvar(Notificacao not) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, true))) {
            String linha = String.join(";",
                    not.getPaciente().getNome(),
                    not.getPaciente().getNomeMae(),
                    not.getPaciente().getSexo(),
                    String.valueOf(not.getPaciente().getIdade()),
                    not.getPaciente().getRacaCor(),
                    not.getPaciente().getEscolaridade(),
                    not.getPaciente().getDataNascimento(),
                    not.getPaciente().getNumeroCartaoSUS(),
                    not.getAgravo().name(),
                    not.getDataNotificacao().format(formatter),
                    not.getTipoNotificacao(),
                    not.getEndereco().getLogradouro(),
                    not.getEndereco().getNumero(),
                    not.getEndereco().getComplemento(),
                    not.getEndereco().getBairro(),
                    not.getEndereco().getMunicipio(),
                    not.getEndereco().getUf(),
                    not.getEndereco().getCep(),
                    not.getEndereco().getPais(),
                    not.getEndereco().getZona(),
                    String.valueOf(not.getNumeroLesoesCutaneas()),
                    not.getClassificacaoOperacional(),
                    not.getFormaClinica()
            );
            bw.write(linha);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao salvar notificação: " + e.getMessage());
        }
    }

    // Ler todas notificações
    public List<Notificacao> listar() {
        List<Notificacao> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                Paciente paciente = new Paciente(
                        dados[0], dados[1], dados[2], Integer.parseInt(dados[3]),
                        dados[4], dados[5], dados[6], dados[7]
                );
                Endereco endereco = new Endereco(
                        dados[11], dados[12], dados[13], dados[14],
                        dados[15], dados[16], dados[17], dados[18], dados[19]
                );
                Agravo agravo = Agravo.valueOf(dados[8]);
                LocalDate data = LocalDate.parse(dados[9], formatter);
                Notificacao n = new Notificacao(
                        paciente, agravo, data, dados[10], endereco,
                        Integer.parseInt(dados[20]), dados[21], dados[22]
                );
                lista.add(n);
            }
        } catch (FileNotFoundException e) {
            // Arquivo ainda não existe
        } catch (IOException e) {
            System.out.println("Erro ao ler notificações: " + e.getMessage());
        }
        return lista;
    }

    // Consultas
    public List<Notificacao> buscarPorNome(String nome) {
        return listar().stream()
                .filter(n -> n.getPaciente().getNome().equalsIgnoreCase(nome))
                .collect(Collectors.toList());
    }

    public List<Notificacao> buscarPorBairro(String bairro) {
        return listar().stream()
                .filter(n -> n.getEndereco().getBairro().equalsIgnoreCase(bairro))
                .collect(Collectors.toList());
    }

    public List<Notificacao> buscarPorPeriodo(LocalDate inicio, LocalDate fim) {
        return listar().stream()
                .filter(n -> !n.getDataNotificacao().isBefore(inicio) && !n.getDataNotificacao().isAfter(fim))
                .collect(Collectors.toList());
    }

    public List<Notificacao> buscarPorAgravo(Agravo agravo) {
        return listar().stream()
                .filter(n -> n.getAgravo() == agravo)
                .collect(Collectors.toList());
    }
}
