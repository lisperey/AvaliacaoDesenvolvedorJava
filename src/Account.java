import java.text.SimpleDateFormat;

public class Account {
    private int CPF;
    private String nome;
    private String endereco;
    private String profisao;
    private String tipo;
    private int numeroConta;
    private int agencia;
    private float saldo;
    private float limite;

    private String dataCalculoJuros;

    public String getDataCalculoJuros() {
        return dataCalculoJuros;
    }

    public void setDataCalculoJuros(String dataCalculoJuros) {
        this.dataCalculoJuros = dataCalculoJuros;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }

    public Account(int CPF, String nome, String endereco, String profisao, String tipo, int numeroConta, int agencia, float saldo) {
        this.CPF = CPF;
        this.nome = nome;
        this.endereco = endereco;
        this.profisao = profisao;
        this.tipo = tipo;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    public int getCPF() {
        return CPF;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getProfisao() {
        return profisao;
    }

    public void setProfisao(String profisao) {
        this.profisao = profisao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }


}
