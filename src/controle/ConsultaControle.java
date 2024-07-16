/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.*;
import java.util.ArrayList;
import conexao.ConexaoMySQL;
import modelo.Consulta;

public class ConsultaControle {

    public ConsultaControle() {

    }

    public ArrayList<Consulta> consultarConsultas() {
        ConexaoMySQL conexaoMySQL = new ConexaoMySQL();
        Connection conexao = conexaoMySQL.conectar();

        ArrayList<Consulta> consultas = new ArrayList<>();

        try {
            String query = "SELECT * FROM CONSULTA";

            Statement stm = conexao.createStatement();

            ResultSet resultado = stm.executeQuery(query);

            MedicoControle mc = new MedicoControle();
            PacienteControle pc = new PacienteControle();
            ConsultorioControle cc = new ConsultorioControle();

            while (resultado.next()) {

                Consulta consulta = new Consulta(
                        resultado.getInt("cod_consulta"),
                        resultado.getDate("data"),
                        resultado.getTime("horario"),
                        mc.consultarMedicoCodigo(resultado.getInt("cod_medico")),
                        pc.consultarPacienteCodigo(resultado.getInt("cod_paciente")),
                        cc.consultarConsultorioCodigo(resultado.getInt("cod_consultorio"))
                );

                consultas.add(consulta);
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta ao banco.");
        }

        return consultas;
    }

    public Consulta consultarConsultaCodigo(int codigo) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();

        Consulta consulta = new Consulta();

        try {
            String query = "SELECT * FROM CONSULTA "
                    + "WHERE cod_consulta = " + codigo;
            Statement stm = con.createStatement();
            ResultSet resultado = stm.executeQuery(query);
            
            MedicoControle mc = new MedicoControle();
            PacienteControle pc = new PacienteControle();
            ConsultorioControle cc = new ConsultorioControle();

            while (resultado.next()) {

                consulta.setCodigo(resultado.getInt("cod_consulta"));

                consulta.setDataRealizacao(resultado.getDate("data"));

                consulta.setHorarioRealizacao(resultado.getTime("horario"));

                consulta.setMedico(mc.consultarMedicoCodigo(resultado.getInt("cod_medico")));
                consulta.setPaciente(pc.consultarPacienteCodigo(resultado.getInt("cod_paciente")));
                consulta.setConsultorio(cc.consultarConsultorioCodigo(resultado.getInt("cod_consultorio")));
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível consultar a tabela");
        }

        return consulta;
    }

    public void inserirConsulta(Consulta cst) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();

        try {
            String consulta = "INSERT INTO CONSULTA"
                    + "(data, horario, cod_paciente, cod_medico, cod_consultorio)"
                    + "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstm = con.prepareStatement(consulta);

            pstm.setDate(1, cst.getDataRealizacao());
            pstm.setTime(2, cst.getHorarioRealizacao());
            pstm.setInt(4, cst.getPaciente().getCodigo());
            pstm.setInt(3, cst.getMedico().getCodigo());
            pstm.setInt(5, cst.getConsultorio().getCodigo());

            pstm.executeUpdate();
            System.out.println("Nova consulta registrada!");

        } catch (SQLException err) {
            System.err.println(err.getSQLState());
        }
    }

    public void imprimirConsulta(ArrayList<Consulta> array) {
        System.out.println("Consulta:");
        for (Consulta cst : array) {
            cst.toString();
        }
    }
/*
    public static void main(String[] args) {
        ConsultaControle consultaControle = new ConsultaControle();

        
        Consulta novaConsulta = new Consulta(
                1,
                Date.valueOf("2024-07-19"),
                Time.valueOf("16:45"),
                null,
                null,
                null,
                null
        );

        consultaControle.inserirConsulta(novaConsulta);

        ArrayList<Consulta> consulta = consultaControle.consultarConsultas();

        consultaControle.imprimirConsulta(consulta);

        System.out.println("Ok");

    }*/
}
