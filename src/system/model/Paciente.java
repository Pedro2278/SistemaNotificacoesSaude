package system.model;

public class Paciente {
    private String nome;
    private String nomeMae;
    private String sexo;        // M, F ou I
    private int idade;
    private String racaCor;     // 1-Branca, 2-Preta, etc
    private String escolaridade;
    private String dataNascimento;
    private String numeroCartaoSUS;

    // Construtor
    public Paciente(String nome, String nomeMae, String sexo, int idade, String racaCor,
                    String escolaridade, String dataNascimento, String numeroCartaoSUS) {
        this.nome = nome;
        this.nomeMae = nomeMae;
        this.sexo = sexo;
        this.idade = idade;
        this.racaCor = racaCor;
        this.escolaridade = escolaridade;
        this.dataNascimento = dataNascimento;
        this.numeroCartaoSUS = numeroCartaoSUS;
    }

    // Getters e setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getNomeMae() { return nomeMae; }
    public void setNomeMae(String nomeMae) { this.nomeMae = nomeMae; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public String getRacaCor() { return racaCor; }
    public void setRacaCor(String racaCor) { this.racaCor = racaCor; }

    public String getEscolaridade() { return escolaridade; }
    public void setEscolaridade(String escolaridade) { this.escolaridade = escolaridade; }

    public String getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(String dataNascimento) { this.dataNascimento = dataNascimento; }

    public String getNumeroCartaoSUS() { return numeroCartaoSUS; }
    public void setNumeroCartaoSUS(String numeroCartaoSUS) { this.numeroCartaoSUS = numeroCartaoSUS; }
}
