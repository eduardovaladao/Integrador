package controle;

import java.util.ArrayList;
import java.sql.*;
import conexao.ConexaoMySQL;
import modelo.Clinica;

public class ClinicaControle {

    public ClinicaControle() {

    }

    public void inserirClinica(Clinica cl) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();

        try {
            String query = "INSERT INTO CLINICA"
                    + "(nome, cep)"
                    + "VALUES(?, ?)";
            PreparedStatement pstm = con.prepareStatement(query);

            pstm.setString(1, cl.getNome());
            pstm.setString(2, cl.getCep());

            pstm.executeUpdate();
            System.out.println("Nova clinica inserida");
        } catch (SQLException err) {
            System.err.println(err.getSQLState());
        }
    }

    public ArrayList<Clinica> consultarClinicas() {
        ConexaoMySQL conexaoMySQL = new ConexaoMySQL();
        Connection conexao = conexaoMySQL.conectar();

        ArrayList<Clinica> clinicas = new ArrayList<>();

        try {
            String query = "SELECT * FROM CLINICA";
            Statement stm = conexao.createStatement();
            ResultSet resultado = stm.executeQuery(query);

            while (resultado.next()) {

                Clinica clinica = new Clinica(
                        resultado.getInt("cod_clinica"),
                        resultado.getString("nome"),
                        resultado.getString("cep")
                );
                
                clinicas.add(clinica);
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta. " + err.getSQLState());
        }

        return clinicas;
    }

    public Clinica consultarClinicaCodigo(int codigo) {
        ConexaoMySQL conexaoMySQL = new ConexaoMySQL();
        Connection conexao = conexaoMySQL.conectar();
        
        Clinica clinica = new Clinica();

        try {
            String query = "SELECT * FROM CLINICA "
                    + "WHERE cod_clinica = " + codigo;
            Statement stm = conexao.createStatement();
            ResultSet resultado = stm.executeQuery(query);

            while (resultado.next()) {
                clinica.setCodigo(resultado.getInt("cod_clinica"));
                clinica.setNome(resultado.getString("nome"));
                clinica.setCep(resultado.getString("cep"));
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a pesquisa. " + err.getSQLState());
        }
        
        System.out.println(clinica);

        return clinica;
    }

    public void imprimirClinicas(ArrayList<Clinica> array) {
        System.out.println("Clinicas:\n");
        for (Clinica cl : array) {
            System.out.println(cl.toString());
        }
    }
/*
    public static void main(String[] args) {
        ClinicaControle clinicaControle = new ClinicaControle();
        /*
        Clinica novoClinica = new Clinica(
                1,
                "Clinica Conceição da Malvadeza",
                "78459886"
        );

        clinicaControle.inserirClinica(novoClinica);

        ArrayList<Clinica> clinicas = clinicaControle.consultarClinicas();
*
        Clinica cl = clinicaControle.consultarClinicaCodigo(1);
        System.out.println(cl.toString());
        
        //clinicaControle.imprimirClinicas(clinicas);
    }
*/

}
