
package controle;
import java.util.ArrayList;
import java.sql.*;
import conexao.ConexaoMySQL;
import modelo.Medico;
import modelo.Usuario;

public class MedicoControle extends UsuarioControle {
    public MedicoControle(){
    }
    
    public void inserirMedico(Medico me) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();

        try {
            String consulta = "INSERT INTO MEDICO"
                    + "(crm, cod_usuario)"
                    + "VALUES (?, ?)";

            PreparedStatement pstm = con.prepareStatement(consulta);
            pstm.setString(1, me.getCrm());
            pstm.setInt(2, me.getCodigoUsuario());

            pstm.executeUpdate();
            System.out.println("Novo medico inserido!");
        } catch (SQLException err) {
            System.err.println(err.getSQLState());
        }
}
    
    public ArrayList<Medico> consultarMedicos() {
        ConexaoMySQL conexaoMySQL = new ConexaoMySQL();
        Connection conexao = conexaoMySQL.conectar();

        ArrayList<Medico> medicos = new ArrayList<>();

        try {
            String consulta = "SELECT * FROM MEDICO";
            Statement stm = conexao.createStatement();
            ResultSet resultado = stm.executeQuery(consulta);

            while (resultado.next()) {
                // método "emprestado" do UsuarioControle para extrair as informações do usuário
                // que irá se cadastrar como medico
                Usuario us = MedicoControle.super.consultarUsuarioCodigo(resultado.getInt("cod_usuario"));

                //durante a criação do medico, vamos colocar os atributos do seu respectivo ussuário
                Medico medico = new Medico(
                        resultado.getInt("cod_medico"),
                        resultado.getString("crm"),
                        us.getCodigoUsuario(),
                        us.getNome(),
                        us.getSenha(),
                        us.getDataNascimento(),
                        us.getSexo(),
                        us.getCpf(),
                        us.getCep(),
                        us.getTelefone(),
                        us.getEmail()
                );

                medicos.add(medico);
                System.out.println(medico);
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta. " + err.getSQLState());
        }
        return medicos;
        
    }       public Medico consultarMedicoCodigo(int codigo) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();
        
        Medico medico = new Medico();
        
        try {
            String consulta = "SELECT * FROM Medico "
                    + "WHERE cod_medico = " + codigo;
            Statement stm = con.createStatement();
            ResultSet resultado = stm.executeQuery(consulta);
            
            while (resultado.next()) {
                Usuario us = MedicoControle.super.consultarUsuarioCodigo(resultado.getInt("cod_usuario"));
                
                medico = new Medico(
                        resultado.getInt("cod_medico"),
                        resultado.getString("CRM"),
                        us.getCodigoUsuario(),
                        us.getNome(),
                        us.getSenha(),
                        us.getDataNascimento(),
                        us.getSexo(),
                        us.getCpf(),
                        us.getCep(),
                        us.getTelefone(),
                        us.getEmail()
                );
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta. " + err.getSQLState());
        }
        
        return medico;
    }
        public void imprimirMedicos(ArrayList<Medico> medicos) {
        System.out.println("Medicos:");
        for (Medico me : medicos) {
            System.out.println("Código: " + me.getCodigo() + "\n"
                    + "CRM: " + me.getCrm() + "\n"
                    + "Código Usuário: " + me.getCodigoUsuario() + "\n"
            );
        }
    }
/*
    public static void main(String[] args) {
        MedicoControle medicoControle = new MedicoControle();
        
        Medico medico = new Medico(
                1,
                "1452367",
                1,
                "Victor Valadão",
                "minha@senha@misteriosa",
                Date.valueOf("2010-11-05"),
                'M',
                "12345678910",
                "38410134",
                "34998789645",
                "victorvaladaotete2010@gmail.com"
        );

        medicoControle.inserirMedico(medico);
        
        //ArrayList<Paciente> pacientes = pacienteControle.consultarPacientes();

        //pacienteControle.imprimirPacientes(pacientes);

        System.out.println(medicoControle.consultarMedicoCodigo(1));
        
        System.out.println("Ok");
    }
    */
}
