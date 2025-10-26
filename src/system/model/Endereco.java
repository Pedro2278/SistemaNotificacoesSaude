package system.model;

public class Endereco {
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String municipio;
    private String uf;
    private String cep;
    private String pais;
    private String zona;

    public Endereco(String logradouro, String numero, String complemento, String bairro,
                    String municipio, String uf, String cep, String pais, String zona) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.municipio = municipio;
        this.uf = uf.toUpperCase();
        this.cep = cep;
        this.pais = pais;
        this.zona = zona;
    }

    // Getters
    public String getLogradouro() { return logradouro; }
    public String getNumero() { return numero; }
    public String getComplemento() { return complemento; }
    public String getBairro() { return bairro; }
    public String getMunicipio() { return municipio; }
    public String getUf() { return uf; }
    public String getCep() { return cep; }
    public String getPais() { return pais; }
    public String getZona() { return zona; }
}
