package modelo;

import java.util.ArrayList;
import java.sql.Date;

public class Paciente extends Usuario {

    private Integer codigo;

    private String historico;

    private ArrayList<Consulta> consultas;
    
    private ArrayList<ExameRealizado> examesRealizados;

    public Paciente() {
    } // construtor vazio

    // construtor de objeto Paciente + atributos de Usuario
    public Paciente(Integer codigo, String historico, Integer codigoUsuario, String nome, String senha, Date dataNascimento, Character sexo, String cpf, String cep, String telefone, String email) {
        super(codigoUsuario, nome, senha, dataNascimento, sexo, cpf, cep, telefone, email);
        this.codigo = codigo;
        this.historico = historico;
    }    

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public ArrayList<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(ArrayList<Consulta> consultas) {
        this.consultas = consultas;
    }

    public ArrayList<ExameRealizado> getExamesRealizados() {
        return examesRealizados;
    }

    public void setExamesRealizados(ArrayList<ExameRealizado> examesRealizados) {
        this.examesRealizados = examesRealizados;
    }

    @Override
    public String toString() {
        return super.toString() + "Paciente{codigo=" + codigo + ", historico=" + historico + ", consultas=" + consultas + ", examesRealizados=" + examesRealizados + '}';
    }
}
