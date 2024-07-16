package controle;

import java.util.ArrayList;
import java.sql.*;
import conexao.ConexaoMySQL;
import modelo.ExamePrescrito;

public class ExamePrescritoControle {

    public ExamePrescritoControle() {
    }

    public void inserirExamePrescrito(ExamePrescrito exp) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();

        try {
            String consulta = "INSERT INTO EXAME_PRESCRITO"
                    + "(codigo, cod_exame, cod_prescricao, data, horario)"
                    + "VALUES (?, ?, ?, ?, ?) ";

            PreparedStatement pstm = con.prepareStatement(consulta);

            pstm.setInt(1, exp.getCodigo());
            pstm.setInt(2, exp.getExame().getCodigo());
            pstm.setInt(3, exp.getPrescricao().getCodigo());
            pstm.setDate(4, exp.getDataAgendada());
            pstm.setTime(5, exp.getHorarioAgendado());

            pstm.executeUpdate();
            System.out.println("Novo exame prescrito inserido!");
        } catch (SQLException err) {
            System.err.println(err.getSQLState());
        }
    }

    public ArrayList<ExamePrescrito> consultarExamesPrescritos() {
        ConexaoMySQL conexaoMySQL = new ConexaoMySQL();
        Connection conexao = conexaoMySQL.conectar();

        ArrayList<ExamePrescrito> examesPrescritos = new ArrayList<>();

        try {
            String consulta = "SELECT * FROM EXAME_PRESCRITO";
            Statement stm = conexao.createStatement();
            ResultSet resultado = stm.executeQuery(consulta);

            ExameControle exameControle = new ExameControle();
            PrescricaoControle prescricaoControle = new PrescricaoControle();

            while (resultado.next()) {

                ExamePrescrito examePrescrito = new ExamePrescrito(
                        resultado.getInt("cod_exame_prescrito"),
                        exameControle.consultarExameCodigo(resultado.getInt("cod_exame")),
                        prescricaoControle.consultarPrescricaoCodigo(resultado.getInt("cod_prescricao")),
                        resultado.getDate("data"),
                        resultado.getTime("horario")
                );

                examesPrescritos.add(examePrescrito);
                System.out.println(examePrescrito);
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta ao banco." + err.getSQLState());
        }
        return examesPrescritos;
    }

    public ExamePrescrito consultarExamePrescritoCodigo(int codigo) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();

        ExamePrescrito examePrescrito = new ExamePrescrito();

        try {
            String consulta = "SELECT * FROM EXAME_PRESCRITO "
                    + "WHERE cod_exame_prescrito = " + codigo;
            Statement stm = con.createStatement();
            ResultSet resultado = stm.executeQuery(consulta);

            ExameControle exameControle = new ExameControle();
            PrescricaoControle prescricaoControle = new PrescricaoControle();

            while (resultado.next()) {

                examePrescrito = new ExamePrescrito(
                        resultado.getInt("cod_exame_prescrito"),
                        exameControle.consultarExameCodigo(resultado.getInt("cod_exame")),
                        prescricaoControle.consultarPrescricaoCodigo(resultado.getInt("cod_prescricao")),
                        resultado.getDate("data"),
                        resultado.getTime("horario")
                );
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta. " + err.getSQLState());
        }

        return examePrescrito;
    }

    public void imprimirExamesPrescritos(ArrayList<ExamePrescrito> examesPrescritos) {
        System.out.println("Exames prescritos:\n");
        for (ExamePrescrito exp : examesPrescritos) {
            exp.toString();
        }
    }
}
