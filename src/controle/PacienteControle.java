package controle;

import java.util.ArrayList;
import java.sql.*;
import conexao.ConexaoMySQL;
import modelo.Paciente;
import modelo.Usuario;

public class PacienteControle extends UsuarioControle {

    public PacienteControle() {
    }

    public void inserirPaciente(Paciente pa) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();

        try {
            String consulta = "INSERT INTO PACIENTE"
                    + "(historico, cod_usuario)"
                    + "VALUES (?, ?)";

            PreparedStatement pstm = con.prepareStatement(consulta);
            pstm.setString(1, pa.getHistorico());
            pstm.setInt(2, pa.getCodigoUsuario());

            pstm.executeUpdate();
            System.out.println("Novo paciente inserido!");
        } catch (SQLException err) {
            System.err.println(err.getSQLState());
        }
    }

    public ArrayList<Paciente> consultarPacientes() {
        ConexaoMySQL conexaoMySQL = new ConexaoMySQL();
        Connection conexao = conexaoMySQL.conectar();

        ArrayList<Paciente> pacientes = new ArrayList<>();

        try {
            String consulta = "SELECT * FROM PACIENTE";
            Statement stm = conexao.createStatement();
            ResultSet resultado = stm.executeQuery(consulta);

            while (resultado.next()) {
                // método "emprestado" do UsuarioControle para extrair as informações do usuário
                // que irá se cadastrar como paciente
                Usuario us = PacienteControle.super.consultarUsuarioCodigo(resultado.getInt("cod_usuario"));

                //durante a criação do paciente, vamos colocar os atributos do seu respectivo ussuário
                Paciente paciente = new Paciente(
                        resultado.getInt("cod_paciente"),
                        resultado.getString("historico"),
                        us.getCodigoUsuario(),
                        us.getNome(),
                        us.getSenha(),
                        us.getDataNascimento(),
                        us.getSexo(),
                        us.getCpf(),
                        us.getCep(),
                        us.getTelefone(),
                        us.getEmail()
                );

                pacientes.add(paciente);
                System.out.println(paciente);
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta. " + err.getSQLState());
        }
        return pacientes;
    }

    public Paciente consultarPacienteCodigo(int codigo) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();
        
        Paciente paciente = new Paciente();
        
        try {
            String consulta = "SELECT * FROM PACIENTE "
                    + "WHERE cod_paciente = " + codigo;
            Statement stm = con.createStatement();
            ResultSet resultado = stm.executeQuery(consulta);
            
            while (resultado.next()) {
                Usuario us = PacienteControle.super.consultarUsuarioCodigo(resultado.getInt("cod_usuario"));
                
                paciente = new Paciente(
                        resultado.getInt("cod_paciente"),
                        resultado.getString("historico"),
                        us.getCodigoUsuario(),
                        us.getNome(),
                        us.getSenha(),
                        us.getDataNascimento(),
                        us.getSexo(),
                        us.getCpf(),
                        us.getCep(),
                        us.getTelefone(),
                        us.getEmail()
                );
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta. " + err.getSQLState());
        }
        
        return paciente;
    }

    public void imprimirPacientes(ArrayList<Paciente> pacientes) {
        System.out.println("Pacientes:");
        for (Paciente pa : pacientes) {
            pa.toString();
        }
    }
/*
    public static void main(String[] args) {
        PacienteControle pacienteControle = new PacienteControle();
/*        
        Paciente paciente = new Paciente(
                1,
                "Alergia a picada de insetos",
                1,
                "Victor Valadão",
                "minha@senha@misteriosa",
                Date.valueOf("2010-11-05"),
                'M',
                "12345678910",
                "38410134",
                "34998789645",
                "victorvaladaotete2010@gmail.com"
        );

        //pacienteControle.inserirPaciente(paciente);
        
        ArrayList<Paciente> pacientes = pacienteControle.consultarPacientes();

        pacienteControle.imprimirPacientes(pacientes);

        //pacienteControle.consultarPacienteCodigo(1);
        
        System.out.println("Ok");
    }*/
}
