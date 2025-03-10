/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import produtos.ProdutosDTO;
import java.sql.SQLException;


public class ProdutosDAO {
        Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
   
    public void cadastrarProduto(ProdutosDTO produto) {
    String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)";
    try {
        conn = new ConectaDAO().connectDB(); // Conecta ao banco de dados
        prep = conn.prepareStatement(sql);
        prep.setString(1, produto.getNome());
        prep.setInt(2, produto.getValor());
        prep.setString(3, produto.getStatus());
        prep.executeUpdate(); // Executa a inserção
        JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto: " + e.getMessage());
    } finally {
        try {
            if (prep != null) prep.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e.getMessage());
        }
    }
}
    
    public ArrayList<ProdutosDTO> listarProdutos() {
    String sql = "SELECT * FROM produtos";
    try {
        conn = new ConectaDAO().connectDB(); // Conecta ao banco de dados
        prep = conn.prepareStatement(sql);
        resultset = prep.executeQuery(); // Executa a consulta

        listagem.clear(); // Limpa a lista antes de adicionar novos itens
        while (resultset.next()) {
            ProdutosDTO produto = new ProdutosDTO();
            produto.setId(resultset.getInt("id"));
            produto.setNome(resultset.getString("nome"));
            produto.setValor(resultset.getInt("valor"));
            produto.setStatus(resultset.getString("status"));
            listagem.add(produto);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao listar produtos: " + e.getMessage());
    } finally {
        try {
            if (resultset != null) resultset.close();
            if (prep != null) prep.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e.getMessage());
        }
    }
    return listagem;

}
    public void venderProduto(int id) {
    String sql = "UPDATE produtos SET status = ? WHERE id = ?";
    try {
        conn = new ConectaDAO().connectDB(); // Conecta ao banco de dados
        prep = conn.prepareStatement(sql);
        prep.setString(1, "Vendido"); // Define o novo status
        prep.setInt(2, id); // Define o ID do produto
        prep.executeUpdate(); // Executa a atualização
        JOptionPane.showMessageDialog(null, "Produto vendido com sucesso!");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao vender produto: " + e.getMessage());
    } finally {
        try {
            if (prep != null) prep.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e.getMessage());
        }
    }
}
}
