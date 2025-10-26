package system.model;

public class Paciente {
    private String nome;
    private String nomeMae;
    private String sexo;
    private int idade;
    private String racaCor;
    private String escolaridade;
    private String dataNascimento;
    private String numeroCartaoSUS;

    public Paciente(String nome, String nomeMae, String sexo, int idade, String racaCor, String escolaridade,
                    String dataNascimento, String numeroCartaoSUS) {
        this.nome = nome;
        this.nomeMae = nomeMae;
        this.sexo = sexo;
        this.idade = idade;
        this.racaCor = racaCor;
        this.escolaridade = escolaridade;
        this.dataNascimento = dataNascimento;
        this.numeroCartaoSUS = numeroCartaoSUS;
    }

    // Getters
    public String getNome() { return nome; }
    public String getNomeMae() { return nomeMae; }
    public String getSexo() { return sexo; }
    public int getIdade() { return idade; }
    public String getRacaCor() { return racaCor; }
    public String getEscolaridade() { return escolaridade; }
    public String getDataNascimento() { return dataNascimento; }
    public String getNumeroCartaoSUS() { return numeroCartaoSUS; }
}
