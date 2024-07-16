package controle;

import conexao.ConexaoMySQL;
import java.sql.*;
import java.util.ArrayList;
import modelo.Consultorio;
import modelo.Disponibilidade;
import modelo.Clinica;

/**
 *
 * @author aluno
 */
public class ConsultorioControle {

    public ConsultorioControle() {
    }

    public void inserirConsultorio(Consultorio consul) {

        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();

        try {
            String consulta = "INSERT INTO CONSULTORIO"
                    + "(disponibilidade, cod_clinica)"
                    + "VALUES (?, ?)";
            PreparedStatement pstm = con.prepareStatement(consulta);
            pstm.setString(1, consul.getDisponibilidade().getValor());
            pstm.setInt(2, consul.getClinica().getCodigo());

            pstm.executeUpdate();
            System.out.println("Nova especialidade inserida!");

        } catch (SQLException err) {
            System.err.println("AAA " + err.getSQLState());
        }
    }

    public ArrayList<Consultorio> consultarConsultorios() {
        ConexaoMySQL conexaoMySQL = new ConexaoMySQL();
        Connection conexao = conexaoMySQL.conectar();

        ArrayList<Consultorio> consultorio = new ArrayList<>();

        try {
            String consulta = "SELECT * FROM CONSULTORIO";

            Statement stm = conexao.createStatement();
            ResultSet resultado = stm.executeQuery(consulta);

            while (resultado.next()) {
                Disponibilidade dis = Disponibilidade.pegaDisponibilidadePorValor(resultado.getString("disponibilidade"));

                ClinicaControle cc = new ClinicaControle();

                Consultorio consul = new Consultorio(
                        resultado.getInt("cod_consultorio"),
                        dis,
                        cc.consultarClinicaCodigo(resultado.getInt("cod_clinica"))
                );

                consultorio.add(consul);
                System.out.println(consul);
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta. " + err.getSQLState());
        }
        return consultorio;
    }

    public Consultorio consultarConsultorioCodigo(int codigo) {
        ConexaoMySQL conexaoMySQL = new ConexaoMySQL();
        Connection conexao = conexaoMySQL.conectar();

        Consultorio consul = new Consultorio();

        try {
            String query = "SELECT * FROM CONSULTORIO "
                    + "WHERE cod_consultorio = " + codigo;
            Statement stm = conexao.createStatement();
            ResultSet resultado = stm.executeQuery(query);

            while (resultado.next()) {
                ClinicaControle c = new ClinicaControle();

                consul.setCodigo(resultado.getInt("cod_consultorio"));
                consul.setDisponibilidade(Disponibilidade.pegaDisponibilidadePorValor(resultado.getString("disponibilidade")));
                consul.setClinica(c.consultarClinicaCodigo(resultado.getInt("cod_clinica")));

            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta ao banco." + err.getSQLState());
        }
        return consul;
    }

    public void imprimirConsultorio(ArrayList<Consultorio> array) {
        System.out.println("Consultorio:");
        array.forEach((Consultorio consul) -> {
            consul.toString();
        });
    }

    public static void main(String[] args) {
        ConsultorioControle cc = new ConsultorioControle();

        ClinicaControle clc = new ClinicaControle();

        Consultorio consultorio = new Consultorio(
                1,
                Disponibilidade.ABERTO,
                clc.consultarClinicaCodigo(1)
        );

        cc.inserirConsultorio(consultorio);
    }
}
