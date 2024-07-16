package modelo;

import java.util.ArrayList;
import java.sql.Date;

public class Medico extends Usuario {

    private Integer codigo;

    private String crm;

    private ArrayList<Consulta> consultas;
    
    private ArrayList<Formacao> formacoes;

    public Medico() {
    } // construtor vazio

    //construtor de Medico + atributos de Usuario
    public Medico(Integer codigo, String crm, Integer codigoUsuario, String nome, String senha, Date dataNascimento, Character sexo, String cpf, String cep, String telefone, String email) {
        super(codigoUsuario, nome, senha, dataNascimento, sexo, cpf, cep, telefone, email);
        this.codigo = codigo;
        this.crm = crm;
    }
    

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public ArrayList<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(ArrayList<Consulta> consultas) {
        this.consultas = consultas;
    }

    public ArrayList<Formacao> getFormacoes() {
        return formacoes;
    }

    public void setFormacoes(ArrayList<Formacao> formacoes) {
        this.formacoes = formacoes;
    }

    @Override
    public String toString() {
        return "Medico{" + "codigo=" + codigo + ", crm=" + crm + ", consultas=" + consultas + ", formacoes=" + formacoes + '}';
    }
}
