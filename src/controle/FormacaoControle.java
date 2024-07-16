package controle;

import java.util.AbstractList;
import java.sql.*;
import conexao.ConexaoMySQL;
import java.util.ArrayList;
import modelo.Formacao;

public class FormacaoControle {

    public FormacaoControle() {

    }

    public void inserirFormacao(Formacao form) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();

        try {
            String consulta = "INSERT INTO FORMACAO"
                    + "(dt_formacao, cod_medico, cod_especialidade)"
                    + "VALUES (?, ?, ?)";

            PreparedStatement pstm = con.prepareStatement(consulta);
            pstm.setDate(1, form.getDataFormacao());
            pstm.setInt(2, form.getMedico().getCodigo());
            pstm.setInt(3, form.getEspecialidade().getCodigo());

            pstm.executeUpdate();
            System.out.println("Nova formação inserida!");
        } catch (SQLException err) {
            System.err.println(err.getSQLState());
        }
    }

    public ArrayList<Formacao> consultarFormacoes() {
        ConexaoMySQL conexaoMySQL = new ConexaoMySQL();
        Connection conexao = conexaoMySQL.conectar();

        ArrayList<Formacao> pacientes = new ArrayList<>();

        try {
            String consulta = "SELECT * FROM FORMACAO";
            Statement stm = conexao.createStatement();
            ResultSet resultado = stm.executeQuery(consulta);

            MedicoControle mc = new MedicoControle();
            EspecialidadeControle espc = new EspecialidadeControle();

            while (resultado.next()) {
                // corrigir
                Formacao formacao = new Formacao(
                        resultado.getInt("cod_formacao"),
                        //corrigir os 2 
                        mc.consultarMedicoCodigo(resultado.getInt("cod_medico")),
                        espc.consultarEspecialidadeCodigo(resultado.getInt("cod_especialidade")),
                        resultado.getDate("dt_formacao")
                );

                pacientes.add(formacao);
                System.out.println(formacao);
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta. " + err.getSQLState());
        }
        return pacientes;
    }

    public Formacao consultarFormacaoCodigo(int codigo) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();

        Formacao formacao = new Formacao();

        try {
            String consulta = "SELECT * FROM FORMACAO "
                    + "WHERE cod_formacao = " + codigo;
            Statement stm = con.createStatement();
            ResultSet resultado = stm.executeQuery(consulta);

            MedicoControle mc = new MedicoControle();
            EspecialidadeControle espc = new EspecialidadeControle();

            while (resultado.next()) {

                formacao = new Formacao(
                        resultado.getInt("cod_formacao"),
                        mc.consultarMedicoCodigo(resultado.getInt("cod_medico")),
                        espc.consultarEspecialidadeCodigo(resultado.getInt("cod_especialidade")),
                        resultado.getDate("dt_formacao")
                );
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta. " + err.getSQLState());
        }

        return formacao;
    }

    public void imprimirFormacoes(ArrayList<Formacao> formacoes) {
        System.out.println("Formações:");
        for (Formacao fo : formacoes) {
            System.out.println(fo.toString());
        }
    }
    
    /*
    public static void main(String args[]) {
        Formacao f = new Formacao(
                1,
                null,
                null,
                Date.valueOf("2004-02-20")
        );
                
        FormacaoControle fc = new FormacaoControle();
        
        fc.inserirFormacao(f);
        System.out.println("ok");
    }*/
}
