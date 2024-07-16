package controle;

import java.util.ArrayList;
import java.sql.*;
import conexao.ConexaoMySQL;
import modelo.ExameRealizado;

public class ExameRealizadoControle {

    public ExameRealizadoControle() {
    }

    public void inserirExameRealizado(ExameRealizado exr) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();

        try {
            String query = "INSERT INTO EXAME_REALIZADO"
                    + "(cod_exame, cod_paciente, data_realizacao, resultado)"
                    + "VALUES(?, ?, ?, ?)";
            PreparedStatement pstm = con.prepareStatement(query);

            pstm.setInt(1, exr.getExame().getCodigo());
            pstm.setInt(2, exr.getPaciente().getCodigo());
            pstm.setDate(3, exr.getDataRealizacao());
            pstm.setString(4, exr.getResultado());

            pstm.executeUpdate();
            System.out.println("Nova clinica inserida!");
        } catch (SQLException err) {
            System.err.println(err.getSQLState());
        }
    }

    public ArrayList<ExameRealizado> consultarExameRealizados() {
        ConexaoMySQL conexaoMySQL = new ConexaoMySQL();
        Connection conexao = conexaoMySQL.conectar();

        ArrayList<ExameRealizado> examesRealizados = new ArrayList<>();

        try {
            String query = "SELECT * FROM EXAME_REALIZADO";
            Statement stm = conexao.createStatement();
            ResultSet resultado = stm.executeQuery(query);

            ExameControle exc = new ExameControle();
            PacienteControle pc = new PacienteControle();

            while (resultado.next()) {

                ExameRealizado exr = new ExameRealizado(
                        resultado.getInt("cod_exame_realizado"),
                        exc.consultarExameCodigo(resultado.getInt("cod_exame")),
                        pc.consultarPacienteCodigo(resultado.getInt("cod_paciente")),
                        resultado.getDate("data_realizacao"),
                        resultado.getString("resultado")
                );

                examesRealizados.add(exr);
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta ao banco. " + err.getSQLState());
        }

        return examesRealizados;
    }

    public ExameRealizado consultarExameRealizadoCodigo(int codigo) {
        ConexaoMySQL conexaoMySQL = new ConexaoMySQL();
        Connection conexao = conexaoMySQL.conectar();
        ExameRealizado exr = new ExameRealizado();

        try {
            String query = "SELECT FROM EXAME_REALIZADO "
                    + "WHERE cod_exame_realizado = " + codigo;
            Statement stm = conexao.createStatement();
            ResultSet resultado = stm.executeQuery(query);
            
            ExameControle exc = new ExameControle();
            PacienteControle pc = new PacienteControle();

            while (resultado.next()) {
                exr = new ExameRealizado(
                        resultado.getInt("cod_exame_realizado"),
                        exc.consultarExameCodigo(resultado.getInt("cod_exame")),
                        pc.consultarPacienteCodigo(resultado.getInt("cod_paciente")),
                        resultado.getDate("data_realizacao"),
                        resultado.getString("resultado")
                );
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta ao banco." + err.getSQLState());
        }

        return exr;
    }

    public void imprimirExamesRealizados(ArrayList<ExameRealizado> examesRealizados) {
        System.out.println("Exames Realizados:\n");
        for (ExameRealizado exr : examesRealizados) {
            exr.toString();
        }
    }

}
