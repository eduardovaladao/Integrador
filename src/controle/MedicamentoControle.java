package controle;

import java.util.ArrayList;
import java.sql.*;
import conexao.ConexaoMySQL;
import modelo.Medicamento;

public class MedicamentoControle {

    public MedicamentoControle() {
    }

    public void inserirMedicamento(Medicamento med) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();

        try {
            String consulta = "INSERT INTO MEDICAMENTO"
                    + "(nome, tipo, uso, descricao)"
                    + "VALUES (?, ?, ?, ?)";

            PreparedStatement pstm = con.prepareStatement(consulta);
            pstm.setString(1, med.getNome());
            pstm.setString(2, med.getTipo());
            pstm.setString(3, med.getUso());
            pstm.setString(4, med.getDescricao());

            pstm.executeUpdate();
            System.out.println("Novo paciente inserido!");
        } catch (SQLException err) {
            System.err.println(err.getSQLState());
        }
    }

    public ArrayList<Medicamento> consultarMedicamentos() {
        ConexaoMySQL conexaoMySQL = new ConexaoMySQL();
        Connection conexao = conexaoMySQL.conectar();

        ArrayList<Medicamento> medicamentos = new ArrayList<>();

        try {
            String query = "SELECT * FROM MEDICAMENTO";
            Statement stm = conexao.createStatement();
            ResultSet resultado = stm.executeQuery(query);

            while (resultado.next()) {
                Medicamento medicamento = new Medicamento(
                        resultado.getInt("cod_medicamento"),
                        resultado.getString("nome"),
                        resultado.getString("tipo"),
                        resultado.getString("uso"),
                        resultado.getString("descricao")
                );

                medicamentos.add(medicamento);
                System.out.println(medicamento);
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta. " + err.getSQLState());
        }
        return medicamentos;
    }
    
    public Medicamento consultarMedicamentoCodigo(int codigo) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();
        
        Medicamento medicamento = new Medicamento();
        
        try {
            String consulta = "SELECT * FROM MEDICAMENTO "
                    + "WHERE cod_medicamento = " + codigo;
            Statement stm = con.createStatement();
            ResultSet resultado = stm.executeQuery(consulta);
            
            while (resultado.next()) {
                medicamento = new Medicamento(
                        resultado.getInt("cod_medicamento"),
                        resultado.getString("nome"),
                        resultado.getString("tipo"),
                        resultado.getString("uso"),
                        resultado.getString("descricao")
                );
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta. " + err.getSQLState());
        }
        
        return medicamento;
    }
    
    public void imprimirMedicamentos(ArrayList<Medicamento> medicamentos) {
        System.out.println("Medicamento:");
        for (Medicamento med : medicamentos) {
            med.toString();
        }
    }
}
