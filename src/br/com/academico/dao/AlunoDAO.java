package br.com.academico.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.academico.modelo.Aluno;
import br.com.aluno.jdbc.FabricaDeConexoes;

public class AlunoDAO {
  public void criar(Aluno pAluno) throws Exception {
    Connection con = FabricaDeConexoes.pegarConexao();
    
    String sql = "insert into tbaluno "
        + "(cpf, nome, idade, altura) "
        + "values (?, ?, ?, ?)";
    
    PreparedStatement stmt = con.prepareStatement(sql);
    
    stmt.setString(1, pAluno.getCpf());
    stmt.setString(2, pAluno.getNome());
    stmt.setInt   (3, pAluno.getIdade());
    stmt.setDouble(4, pAluno.getAltura());
    stmt.execute();
  }

  public void atualizar(Aluno pAluno) throws Exception {
    Connection con = FabricaDeConexoes.pegarConexao();
    
    String sql = "update tbaluno "
        + "   set nome = ?, "
        + "       idade = ?, "
        + "       altura = ? "
        + " where cpf = ?";
    
    PreparedStatement stmt = con.prepareStatement(sql);
    
    stmt.setString(1, pAluno.getNome());
    stmt.setInt   (2, pAluno.getIdade());
    stmt.setDouble(3, pAluno.getAltura());
    stmt.setString(4, pAluno.getCpf());
    stmt.execute();
  }
}
