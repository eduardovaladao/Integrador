package controle;

import java.util.ArrayList;
import java.sql.*;
import conexao.ConexaoMySQL;
import modelo.Exame;

public class ExameControle {

    public ExameControle() {
    }

    public void inserirExame(Exame ex) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();

        try {
            String consulta = "INSERT INTO EXAME"
                    + "(nome, tipo, descricao, duracao) "
                    + "VALUES (?, ?, ?, ?) ";

            PreparedStatement pstm = con.prepareStatement(consulta);
            pstm.setString(1, ex.getNome());
            pstm.setString(2, ex.getTipo());
            pstm.setString(3, ex.getDescricao());
            pstm.setTime(4, ex.getDuracao());

            pstm.executeUpdate();
            System.out.println("Novo exame inserido!");
        } catch (SQLException err) {
            System.err.println(err.getSQLState());
        }
    }

    public ArrayList<Exame> consultarExames() {
        ConexaoMySQL conexaoMySQL = new ConexaoMySQL();
        Connection conexao = conexaoMySQL.conectar();

        ArrayList<Exame> exames = new ArrayList<>();

        try {
            String query = "SELECT * FROM EXAME";
            Statement stm = conexao.createStatement();
            ResultSet resultado = stm.executeQuery(query);

            LaboratorioControle lc = new LaboratorioControle();

            while (resultado.next()) {

                Exame exame = new Exame(
                        resultado.getInt("cod_exame"),
                        resultado.getString("nome"),
                        resultado.getString("tipo"),
                        resultado.getString("descricao"),
                        resultado.getTime("duracao"),
                        lc.consultarLaboratorioCodigo(resultado.getInt("cod_laboratorio"))
                );

                exames.add(exame);
                System.out.println(exame);
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta. " + err.getSQLState());
        }
        return exames;
    }

    public Exame consultarExameCodigo(int codigo) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();

        Exame exame = new Exame();

        try {
            String consulta = "SELECT * FROM EXAME "
                    + "WHERE cod_exame = " + codigo;
            Statement stm = con.createStatement();
            ResultSet resultado = stm.executeQuery(consulta);

            LaboratorioControle lc = new LaboratorioControle();

            while (resultado.next()) {

                exame = new Exame(
                        resultado.getInt("cod_exame"),
                        resultado.getString("nome"),
                        resultado.getString("tipo"),
                        resultado.getString("descricao"),
                        resultado.getTime("duracao"),
                        lc.consultarLaboratorioCodigo(resultado.getInt("cod_laboratorio"))
                );
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta. " + err.getSQLState());
        }

        return exame;
    }

    public void imprimirExames(ArrayList<Exame> exames) {
        System.out.println("Exames:\n");
        for (Exame ex : exames) {
            ex.getCodigo();
        }
    }

    public static void main(String[] args) {
        ExameControle exameControle = new ExameControle();
        
        Exame exame = new Exame(
                1,
                "jubsclaudo riox",
                "kleberiano",
                "cutcut maciinho xavoso",
                Time.valueOf("01:30:20"),
                null
        );

        exameControle.inserirExame(exame);
        
        //ArrayList<Paciente> pacientes = pacienteControle.consultarPacientes();
        //pacienteControle.imprimirPacientes(pacientes);
        System.out.println(exameControle.consultarExameCodigo(1));

        System.out.println("Ok");
    }
}
