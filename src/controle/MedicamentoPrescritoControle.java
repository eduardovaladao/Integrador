package controle;

import java.util.ArrayList;
import java.sql.*;
import conexao.ConexaoMySQL;
import modelo.MedicamentoPrescrito;


public class MedicamentoPrescritoControle {

    public MedicamentoPrescritoControle() {
    }

    public void inserirMedicamentoPrescrito(MedicamentoPrescrito medp) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();

        try {
            String consulta = "INSERT INTO MEDICAMENTO_PRESCRITO"
                    + "(medicamento, prescricao, quantidadePorDia, periodoDeUso, intervaloDeUso)"
                    + "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement pstm = con.prepareStatement(consulta);
            pstm.setInt(1, medp.getMedicamento().getCodigo());
            pstm.setInt(2, medp.getPrescricao().getCodigo());
            pstm.setInt(3, medp.getQuantidadePorDia());
            pstm.setString(4, medp.getPeriodoDeUso());
            pstm.setTime(4, medp.getIntervaloDeUso());

            pstm.executeUpdate();
            System.out.println("Novo medicamento prescrito inserido!");
        } catch (SQLException err) {
            System.err.println(err.getSQLState());
        }
    }

    public ArrayList<MedicamentoPrescrito> consultarMedicamentosPrescritos() {
        ConexaoMySQL conexaoMySQL = new ConexaoMySQL();
        Connection conexao = conexaoMySQL.conectar();

        ArrayList<MedicamentoPrescrito> medicamentosPrescritos = new ArrayList<>();

        try {
            String query = "SELECT * FROM MEDICAMENTO_PRESCRITO";
            Statement stm = conexao.createStatement();
            ResultSet resultado = stm.executeQuery(query);

            MedicamentoControle mc = new MedicamentoControle();
            PrescricaoControle pc = new PrescricaoControle();

            while (resultado.next()) {
                MedicamentoPrescrito medicamentoPrescrito = new MedicamentoPrescrito(
                        resultado.getInt("cod_medicamento_prescrito"),
                        mc.consultarMedicamentoCodigo(resultado.getInt("cod_medicamento")),
                        pc.consultarPrescricaoCodigo(resultado.getInt("cod_prescricao")),
                        resultado.getInt("qtde_por_dia"),
                        resultado.getString("periodo_de_uso"),
                        resultado.getTime("intervalo_de_uso")
                );

                medicamentosPrescritos.add(medicamentoPrescrito);
                System.out.println(medicamentoPrescrito);
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta. " + err.getSQLState());
        }
        return medicamentosPrescritos;
    }

    public MedicamentoPrescrito consultarMedicamentoPrescritoCodigo(int codigo) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();

        MedicamentoPrescrito medicamentoPrescrito = new MedicamentoPrescrito();

        try {
            String consulta = "SELECT * FROM MEDICAMENTO_PRESCRITO "
                    + "WHERE cod_medicamento_prescrito = " + codigo;
            Statement stm = con.createStatement();
            ResultSet resultado = stm.executeQuery(consulta);
            
            MedicamentoControle mc = new MedicamentoControle();
            PrescricaoControle pc = new PrescricaoControle();
            
            while (resultado.next()) {
                medicamentoPrescrito = new MedicamentoPrescrito(
                          resultado.getInt("cod_medicamento_prescrito"),
                        mc.consultarMedicamentoCodigo(resultado.getInt("cod_medicamento")),
                        pc.consultarPrescricaoCodigo(resultado.getInt("cod_prescricao")),
                        resultado.getInt("qtde_por_dia"),
                        resultado.getString("periodo_de_uso"),
                        resultado.getTime("intervalo_de_uso")
                );
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta. " + err.getSQLState());
        }

        return medicamentoPrescrito;
    }

    public void imprimirMedicamentosPrescritos(ArrayList<MedicamentoPrescrito> medicamentosPrescritos) {
        System.out.println("Medicamento Prescritos:\n");
        for (MedicamentoPrescrito medp : medicamentosPrescritos) {
            medp.toString();
        }
    }
    public static void main(String[] args) {
        MedicamentoPrescritoControle medicamentoPrescritoControle = new MedicamentoPrescritoControle();
        /*
        MedicamentoPrescrito medicamentoPrescrito = new MedicamentoPrescrito(
                1,
                null,
                null,
                2,
                "4 anus",
                Time.valueOf("12:39:59")
        );

        medicamentoPrescritoControle.inserirMedicamentoPrescrito(medicamentoPrescrito);
        */
        //ArrayList<MedicamentoPrescrito> mp = medicamentoPrescritoControle.consultarMedicamentosPrescritos();
        //medicamentoPrescritoControle.consultarMedicamentoPrescritoCodigo(1);
        //medicamentoPrescritoControle.imprimirMedicamentosPrescritos(mp);

        

        System.out.println("Ok");
    }
}


