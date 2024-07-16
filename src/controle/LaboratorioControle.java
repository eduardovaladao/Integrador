package controle;

import conexao.ConexaoMySQL;
import java.sql.*;
import java.util.ArrayList;
import modelo.Disponibilidade;
import modelo.Laboratorio;

public class LaboratorioControle {

    public LaboratorioControle() {
    }

    public void inserirLaboratorio(Laboratorio lab) {

        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();
        try {
            String laboratorio;
            laboratorio = "INSERT INTO LABORATORIO"
                    + "(tipo, disponibilidade, cod_clinica )"
                    + "VALUES (?, ?, ?)";

            PreparedStatement pstm = con.prepareStatement(laboratorio);

            pstm.setString(1, lab.getTipo());
            pstm.setString(2, lab.getDisponibilidade().getValor());
            pstm.setInt(3, lab.getClinica().getCodigo());
        } catch (SQLException err) {
            System.err.println(err.getSQLState());
        }
    }

    public ArrayList<Laboratorio> consultarLaboratorios() {
        ConexaoMySQL conexaoMySQL = new ConexaoMySQL();
        Connection conexao = conexaoMySQL.conectar();

        ArrayList<Laboratorio> laboratorios = new ArrayList<>();

        try {
            String query = "SELECT * FROM LABORATORIO";
            Statement stm = conexao.createStatement();
            ResultSet resultado = stm.executeQuery(query);

            while (resultado.next()) {

                Disponibilidade dis = Disponibilidade.pegaDisponibilidadePorValor(
                        resultado.getString("disponibilidade"));

                ClinicaControle cc = new ClinicaControle();

                Laboratorio paciente = new Laboratorio(
                        resultado.getInt("cod_laboratorio"),
                        resultado.getString("tipo"),
                        dis,
                        cc.consultarClinicaCodigo(resultado.getInt("cod_clinica"))
                );

                laboratorios.add(paciente);
                System.out.println(paciente);
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta. " + err.getSQLState());
        }
        return laboratorios;
    }

    public Laboratorio consultarLaboratorioCodigo(int codigo) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();

        Laboratorio lab = new Laboratorio();

        try {
            String consulta = "SELECT * FROM PACIENTE "
                    + "WHERE cod_laboratorio = " + codigo;
            Statement stm = con.createStatement();
            ResultSet resultado = stm.executeQuery(consulta);
            
            Disponibilidade dis;
            ClinicaControle clc = new ClinicaControle();

            while (resultado.next()) {
                lab = new Laboratorio(
                        resultado.getInt("cod_laboratorio"),
                        resultado.getString("tipo"),
                        dis = Disponibilidade.pegaDisponibilidadePorValor(resultado.getString("disponibilidade")),
                        clc.consultarClinicaCodigo(resultado.getInt("cod_clinica"))
                );
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta ao banco." + err.getSQLState());
        }

        return lab;
    }
    
    public void imprimirLaboratorios(ArrayList<Laboratorio> laboratorios) {
        System.out.println("Laboratórios:\n");
        for(Laboratorio lab : laboratorios)
            System.out.println(lab);
    }

    public static void main(String args[]) {
        LaboratorioControle lc = new LaboratorioControle();
        
        ClinicaControle cc = new ClinicaControle();
        
        Laboratorio lab = new Laboratorio(
                1,
                "Tomográfico",
                Disponibilidade.ABERTO,
                cc.consultarClinicaCodigo(1)
        );
        
        lc.inserirLaboratorio(lab);
        
        ArrayList<Laboratorio> labs = lc.consultarLaboratorios();
        
        lc.imprimirLaboratorios(labs);
    }
}
