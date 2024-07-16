package controle;

import java.util.ArrayList;
import java.sql.*;
import conexao.ConexaoMySQL;
import modelo.Prescricao;

public class PrescricaoControle {
    
    public PrescricaoControle() {
    }
    
    public void inserirPrescricao(Prescricao pre) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();

        try {
            String consulta = "INSERT INTO PRESCRICAO"
                    + "(data_prescricao, diagnostico, indicacoes, cod_consulta)"
                    + "VALUES (?, ?, ?, ?)";
            PreparedStatement pstm = con.prepareStatement(consulta);
            pstm.setDate(1, pre.getDataRealizacao());
            pstm.setString(2, pre.getDiagnostico());
            pstm.setString(3, pre.getIndicacoes());
            pstm.setInt(4, pre.getConsulta().getCodigo());

            pstm.executeUpdate();
            System.out.println("Nova prescrição inserida!");

        } catch (SQLException err) {
            System.err.println(err.getSQLState());
        }
    }
    
    public ArrayList<Prescricao> consultarPrescricaos() {
        ConexaoMySQL conexaoMySQL = new ConexaoMySQL();
        Connection conexao = conexaoMySQL.conectar();

        ArrayList<Prescricao> prescricoes = new ArrayList<>();

        try {
            String consulta = "SELECT * FROM PRESCRICOES";

            Statement stm = conexao.createStatement();
            ResultSet resultado = stm.executeQuery(consulta);
            
            ConsultaControle c = new ConsultaControle();

            while (resultado.next()) {
                Prescricao pre = new Prescricao(
                        resultado.getInt("cod_precricao"),
                        resultado.getDate("data_prescricao"),
                        resultado.getString("diagnostico"),
                        resultado.getString("indicacoes"),
                        c.consultarConsultaCodigo(resultado.getInt("cod_consulta"))
                );

                prescricoes.add(pre);
                System.out.println(pre);
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta. " + err.getSQLState());
        }
        return prescricoes;
    }
    
    public Prescricao consultarPrescricaoCodigo(int codigo) {
        ConexaoMySQL conexaoMySQL = new ConexaoMySQL();
        Connection conexao = conexaoMySQL.conectar();

        Prescricao pre = new Prescricao();

        try {
            String consulta = "SELECT * FROM PRESCRICAO "
                    + "WHERE cod_prescricao = " + codigo;
            Statement stm = conexao.createStatement();
            ResultSet resultado = stm.executeQuery(consulta);
            
            ConsultaControle c = new ConsultaControle();

            while (resultado.next()) {
                pre.setCodigo(resultado.getInt("cod_prescricao"));
                pre.setDataRealizacao(resultado.getDate("data_prescricao"));
                pre.setDiagnostico(resultado.getString("diagnostico"));
                pre.setIndicacoes(resultado.getString("indicacoes"));
                pre.setConsulta(c.consultarConsultaCodigo(resultado.getInt("cod_consulta")));
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta. " + err.getSQLState());
        }
        return pre;
    }

    public void imprimirPrescricao(ArrayList<Prescricao> array) {
        System.out.println("\nPrescricao:\n");
        for (Prescricao pre : array) {
            pre.toString();
        }
    }
}
