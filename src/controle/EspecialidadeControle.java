package controle;

import java.util.ArrayList;
import java.sql.*;
import conexao.ConexaoMySQL;
import modelo.Especialidade;

public class EspecialidadeControle {

    public EspecialidadeControle() {
    }

    public void inserirEspecialidade(Especialidade esp) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();

        try {
            String consulta = "INSERT INTO ESPECIALIDADE"
                    + "(nome)"
                    + "VALUES (?)";
            PreparedStatement pstm = con.prepareStatement(consulta);
            pstm.setString(1, esp.getNome());

            pstm.executeUpdate();
            System.out.println("Nova especialidade inserida!");

        } catch (SQLException err) {
            System.err.println(err.getSQLState());
        }
    }

    public ArrayList<Especialidade> consultarEspecialidades() {
        ConexaoMySQL conexaoMySQL = new ConexaoMySQL();
        Connection conexao = conexaoMySQL.conectar();

        ArrayList<Especialidade> especialidades = new ArrayList<>();

        try {
            String consulta = "SELECT * FROM ESPECIALIDADE";

            Statement stm = conexao.createStatement();
            ResultSet resultado = stm.executeQuery(consulta);

            while (resultado.next()) {
                Especialidade esp = new Especialidade(
                        resultado.getInt("cod_especialidade"),
                        resultado.getString("nome")
                );

                especialidades.add(esp);
                System.out.println(esp);
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta. " + err.getSQLState());
        }
        return especialidades;
    }

    public Especialidade consultarEspecialidadeCodigo(int codigo) {
        ConexaoMySQL conexaoMySQL = new ConexaoMySQL();
        Connection conexao = conexaoMySQL.conectar();

        Especialidade esp = new Especialidade();

        try {
            String consulta = "SELECT * FROM ESPECIALIDADE "
                    + "WHERE cod_especialidade = " + codigo;
            Statement stm = conexao.createStatement();
            ResultSet resultado = stm.executeQuery(consulta);

            while (resultado.next()) {
                esp.setCodigo(resultado.getInt("cod_especialidade"));
                esp.setNome(resultado.getString("nome"));
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta. " + err.getSQLState());
        }
        return esp;
    }

    public void imprimirEspecialidades(ArrayList<Especialidade> array) {
        System.out.println("Especialidades:");
        for (Especialidade esp : array) {
            System.out.println("Código: " + esp.getCodigo() + "\n"
                    + "Nome: " + esp.getNome() + "\n"
            );
        }
    }
    /*
    public static void main(String args[]) {
        EspecialidadeControle especialidadeControle = new EspecialidadeControle();
        
        ArrayList<Especialidade> especialidades = especialidadeControle.consultarEspecialidades();
        
        
        Especialidade especialidade = new Especialidade(
                1,
                "Cardiologia"
        );
        
        especialidadeControle.inserirEspecialidade(especialidade);
        
        
        especialidadeControle.imprimirEspecialidades(especialidades);
    
        System.out.println(especialidadeControle.consultarEspecialidadeCodigo(1));
    }*/
}
