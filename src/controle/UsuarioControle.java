package controle;

import java.util.ArrayList;
import java.sql.*;
import conexao.ConexaoMySQL;
import modelo.Usuario;

public class UsuarioControle {

    public UsuarioControle() {
    }

    public ArrayList<Usuario> consultarUsuarios() {
        ConexaoMySQL conexaoMySQL = new ConexaoMySQL();
        Connection conexao = conexaoMySQL.conectar();

        ArrayList<Usuario> usuarios = new ArrayList();

        try {
            String consulta = "SELECT * FROM USUARIO ORDER BY nome";

            // Declaração de um comando SQL
            Statement stm = conexao.createStatement();

            // O app Java vai fazer a consulta no banco e mandar os resultados aqui, em forma do objeto ResulSet
            ResultSet resultado = stm.executeQuery(consulta);

            while (resultado.next()) {

                Usuario usuario = new Usuario(
                        resultado.getInt("cod_usuario"),
                        resultado.getString("nome"),
                        resultado.getString("senha"),
                        resultado.getDate("dt_nascimento"),
                        resultado.getString("sexo").charAt(0), // Converte a String para Character
                        resultado.getString("cpf"),
                        resultado.getString("cep"),
                        resultado.getString("telefone"),
                        resultado.getString("email")
                );

                usuarios.add(usuario); // Adiciona novo usuário na lista de usuários para imprimí-los                   
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta. " + err.getSQLState());
        }
        return usuarios;
    }

    public Usuario consultarUsuarioCodigo(int codigo) {
        ConexaoMySQL conexaoMySQL = new ConexaoMySQL();
        Connection conexao = conexaoMySQL.conectar();
        Usuario usuario = new Usuario(); // Cria um objeto usuário

        try {
            String consulta = "SELECT  FROM USUARIO "
                    + "where cod_usuario =  + codigo"; // Criando o texto da consulta ou query
            Statement stm = conexao.createStatement(); // EStabelece um statement para utilizar a consulta
            ResultSet resultado = stm.executeQuery(consulta); // Executa a consulta e cria um objeto que guarda os dados gerados

            while (resultado.next()) {
                usuario.setCodigoUsuario(resultado.getInt("cod_usuario"));
                usuario.setNome(resultado.getString("nome"));
                usuario.setSenha(resultado.getString("senha"));
                usuario.setDataNascimento(resultado.getDate("dt_nascimento"));
                usuario.setSexo(resultado.getString("sexo").charAt(0)); // Converte a String para Character
                usuario.setCpf(resultado.getString("cpf"));
                usuario.setCep(resultado.getString("cep"));
                usuario.setTelefone(resultado.getString("telefone"));
                usuario.setEmail(resultado.getString("email"));
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta. " + err.getSQLState());
        }

        return usuario;
    }

    public void inserirUsuario(Usuario us) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();

        try {
            String consulta = "INSERT INTO USUARIO"
                    + "(nome, senha, dt_nascimento, sexo, cpf, cep, telefone, email)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstm = con.prepareStatement(consulta);

            pstm.setString(1, us.getNome());
            pstm.setString(2, us.getSenha());
            pstm.setDate(3, us.getDataNascimento());
            pstm.setString(4, us.getSexo() + "");
            pstm.setString(5, us.getCpf());
            pstm.setString(6, us.getCep());
            pstm.setString(7, us.getTelefone());
            pstm.setString(8, us.getEmail());

            pstm.executeUpdate();
            System.out.println("Novo usuário inserido!");
        } catch (SQLException err) {
            System.err.println(err.getSQLState());
        }
    }

    public void imprimirUsuarios(ArrayList<Usuario> array) {
        System.out.println("Usuários");
        for (Usuario us : array) {
            // E pra cada usuário de cada linha da tabela USUARIO consultada...
            //...imprima-os
            System.out.println("Código " + us.getCodigoUsuario() + "\n"
                    + "Nome " + us.getNome() + "\n"
                    + "Senha " + us.getSenha() + "\n"
                    + "Data  de nascimento " + us.getDataNascimento() + "\n"
                    + "Sexo " + us.getSexo() + "\n"
                    + "CPF " + us.getCpf() + "\n"
                    + "RG " + us.getCep() + "\n"
                    + "Telefone; " + us.getTelefone() + "\n"
                    + "Email " + us.getEmail() + "\n"
            );
        }
    }

/*    public static void main(String[] args) {
        UsuarioControle usuarioControle = new UsuarioControle();
/*
        Usuario novoUsuario = new Usuario(
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

        usuarioControle.inserirUsuario(novoUsuario);

        ArrayList<Usuario> usuarios = usuarioControle.consultarUsuarios(); // a consulta retorna um ArrayList de usuáios

        usuarioControle.imprimirUsuarios(usuarios);

    }
*/
}
