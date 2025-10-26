package system.model;

import java.time.LocalDate;

public class Notificacao {
    private Paciente paciente;
    private Agravo agravo;
    private LocalDate dataNotificacao;
    private String tipoNotificacao;
    private Endereco endereco;
    private int numeroLesoesCutaneas;
    private String classificacaoOperacional;
    private String formaClinica;

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

    // Getters
    public Paciente getPaciente() { return paciente; }
    public Agravo getAgravo() { return agravo; }
    public LocalDate getDataNotificacao() { return dataNotificacao; }
    public String getTipoNotificacao() { return tipoNotificacao; }
    public Endereco getEndereco() { return endereco; }
    public int getNumeroLesoesCutaneas() { return numeroLesoesCutaneas; }
    public String getClassificacaoOperacional() { return classificacaoOperacional; }
    public String getFormaClinica() { return formaClinica; }
}
