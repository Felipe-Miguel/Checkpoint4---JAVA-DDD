//FELIPE MIGUEL ORTEGA DE SOUZA RM 94921
package fiap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FilmesDAO {
	 private Connection con;
	 
	 public Connection getCon() {
	        return con;
	    }
	    
	    public void setCon(Connection con) {
	        this.con = con;
	    }
	   
	    public FilmesDAO(Connection con) {
	        setCon(con);
	    }
	    public String inserir(Filme filme) {
	    	String sql = "insert into filmes(codigo,titulo,genero,produtora) values (?,?,?,?)";
	    	try {
	    		PreparedStatement ps = getCon().prepareStatement(sql);
	    		ps.setString(1, filme.getCodigo());
	    		ps.setString(2, filme.getTitulo());
	    		ps.setString(3, filme.getGenero());
	    		ps.setString(4, filme.getProdutora());
	    		if (ps.executeUpdate() > 0) {
					return "Inserido com sucesso";
				} else {
					return "Erro ao inserir";
				}
			} catch (SQLException e) {
				return e.getMessage();
			}
	    }
	    public String alterar(Filme filme) {
	    	String sql = "update filmes set titulo = ?, genero = ?, produtora = ? where codigo = ?";
	    	try {
	    		PreparedStatement ps = getCon().prepareStatement(sql);
	    		ps.setString(1, filme.getTitulo());
	    		ps.setString(2, filme.getGenero());
	    		ps.setString(3, filme.getProdutora());
	    		ps.setString(4, filme.getCodigo());
	    		if (ps.executeUpdate() > 0) {
					return "Banco alterado com sucesso";
				} else {
					return "Erro ao alterar";
				}
			} catch (SQLException e) {
				return e.getMessage();
			}
	    }
	    public String excluir(Filme filme) {
	    	String sql = "delete from filmes where codigo = ?";
	    	try {
	    		PreparedStatement ps = getCon().prepareStatement(sql);
	    		ps.setString(1, filme.getCodigo());
	    		if (ps.executeUpdate() > 0) {
					return "Excluido com sucesso";
				} else {
					return "Erro ao excluir";
				}
			} catch (SQLException e) {
				return e.getMessage();
			}
	    }
	    public ArrayList<Filme> listarTodos(){
	    	String sql = "select*from filmes";
	    	ArrayList<Filme> listaFilme = new ArrayList<Filme>();
	    	try {
	    		PreparedStatement ps = getCon().prepareStatement(sql);
	    		ResultSet rs = ps.executeQuery();
	    		if (rs != null) {
					while (rs.next()) {
						Filme fm = new Filme();
						fm.setCodigo(rs.getString(1));
						fm.setTitulo(rs.getString(2));
						fm.setGenero(rs.getString(3));
						fm.setProdutora(rs.getString(4));
						listaFilme.add(fm);
					}
					return listaFilme;
				} else {
					return null;
				}
			} catch (SQLException e) {
				return null;
			}
	    }
}
