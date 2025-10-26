package system.model;

import java.time.LocalDate;

public class Notificacao {
    private Paciente paciente;
    private Agravo agravo;
    private LocalDate dataNotificacao;
    private String tipoNotificacao; // Individual, Coletiva, etc
    private Endereco endereco;
    private int numeroLesoesCutaneas;
    private String classificacaoOperacional; // Caso novo, recidiva, etc
    private String formaClinica; // PB, MB, etc

    public Notificacao(Paciente paciente, Agravo agravo, LocalDate dataNotificacao,
                       String tipoNotificacao, Endereco endereco, int numeroLesoesCutaneas,
                       String classificacaoOperacional, String formaClinica) {
        this.paciente = paciente;
        this.agravo = agravo;
        this.dataNotificacao = dataNotificacao;
        this.tipoNotificacao = tipoNotificacao;
        this.endereco = endereco;
        this.numeroLesoesCutaneas = numeroLesoesCutaneas;
        this.classificacaoOperacional = classificacaoOperacional;
        this.formaClinica = formaClinica;
    }

    // Getters e setters
    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }

    public Agravo getAgravo() { return agravo; }
    public void setAgravo(Agravo agravo) { this.agravo = agravo; }

    public LocalDate getDataNotificacao() { return dataNotificacao; }
    public void setDataNotificacao(LocalDate dataNotificacao) { this.dataNotificacao = dataNotificacao; }

    public String getTipoNotificacao() { return tipoNotificacao; }
    public void setTipoNotificacao(String tipoNotificacao) { this.tipoNotificacao = tipoNotificacao; }

    public Endereco getEndereco() { return endereco; }
    public void setEndereco(Endereco endereco) { this.endereco = endereco; }

    public int getNumeroLesoesCutaneas() { return numeroLesoesCutaneas; }
    public void setNumeroLesoesCutaneas(int numeroLesoesCutaneas) { this.numeroLesoesCutaneas = numeroLesoesCutaneas; }

    public String getClassificacaoOperacional() { return classificacaoOperacional; }
    public void setClassificacaoOperacional(String classificacaoOperacional) { this.classificacaoOperacional = classificacaoOperacional; }

    public String getFormaClinica() { return formaClinica; }
    public void setFormaClinica(String formaClinica) { this.formaClinica = formaClinica; }
}
