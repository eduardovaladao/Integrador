package modelo;

import java.sql.Date;

public class Usuario {

    protected Integer codigoUsuario;

    protected String nome;
    
    protected String senha;

    protected Date dataNascimento;

    protected Character sexo;

    protected String cpf;

    protected String cep;

    protected String telefone;

    protected String email;

    public Usuario() {
    } // construtor vazio

    public Usuario(Integer codigoUsuario, String nome, String senha, Date dataNascimento, Character sexo, String cpf, String cep, String telefone, String email) {
        this.codigoUsuario = codigoUsuario;
        this.nome = nome;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.cpf = cpf;
        this.cep = cep;
        this.telefone = telefone;
        this.email = email;
    }

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
       this.dataNascimento = dataNascimento;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario{" + "codigoUsuario=" + codigoUsuario + ", nome=" + nome + ", senha=" + senha + ", dataNascimento=" + dataNascimento + ", sexo=" + sexo + ", cpf=" + cpf + ", cep=" + cep + ", telefone=" + telefone + ", email=" + email + '}';
    }
}
