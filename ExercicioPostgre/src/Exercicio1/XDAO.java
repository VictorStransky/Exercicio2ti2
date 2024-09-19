package Exercicio1;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class XDAO {
    private Connection conexao;

    public XDAO() {
        try {
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/X", "postgres", "Victor$2105");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Inserir registro
    public void inserir(X x) {
        String sql = "INSERT INTO X (nome, descricao, valor) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, x.getNome());
            stmt.setString(2, x.getDescricao());
            stmt.setDouble(3, x.getValor());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Listar registros
    public List<X> listar() {
        List<X> lista = new ArrayList<>();
        String sql = "SELECT * FROM X";
        try {
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                X x = new X(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"), rs.getDouble("valor"));
                lista.add(x);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Atualizar registro
    public void atualizar(X x) {
        String sql = "UPDATE X SET nome=?, descricao=?, valor=? WHERE id=?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, x.getNome());
            stmt.setString(2, x.getDescricao());
            stmt.setDouble(3, x.getValor());
            stmt.setInt(4, x.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Excluir registro
    public void excluir(int id) {
        String sql = "DELETE FROM X WHERE id=?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
