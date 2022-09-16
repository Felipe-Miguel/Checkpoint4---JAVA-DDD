//FELIPE MIGUEL ORTEGA DE SOUZA RM 94921

package fiap;

import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Teste {
	public static void main(String[] args) {
		int opcao;
		String escolha = "sim", codigo, titulo,genero,produtora;	
		while (escolha.equalsIgnoreCase("sim")) {
			try {
				Connection con = Conexao.abrirConexao();
				Filme fm = new Filme();
				FilmesDAO fmDAO = new FilmesDAO(con);
				ArrayList<Filme> listaFilmes = fmDAO.listarTodos();
				opcao = Integer.parseInt(JOptionPane.showInputDialog("Você deseja: (1)Inserir\n (2)Alterar\n (3)Excluir" ));
				switch (opcao) {
				case 1:	
					codigo = JOptionPane.showInputDialog("Código do filme");
					titulo = JOptionPane.showInputDialog("Titulo do filme");
					genero = JOptionPane.showInputDialog("Genero do filme");
					produtora = JOptionPane.showInputDialog("Produtora do filme");
					fm.setCodigo(codigo);
					fm.setTitulo(titulo);
					fm.setGenero(genero);
					fm.setProdutora(produtora);
					System.out.println(fmDAO.inserir(fm));
					if (listaFilmes != null) {
						for (Filme filme : listaFilmes) {
							JOptionPane.showMessageDialog(null, "Código: " + filme.getCodigo() + "Titulo: " + filme.getTitulo() + 
									"Genero: " + filme.getGenero() + "Produtora: " + filme.getProdutora());
						}
					} else {
						JOptionPane.showMessageDialog(null,"Lista vazia");
					}
					Conexao.fecharConexao(con);
					break;
				case 2:
					codigo = JOptionPane.showInputDialog("Código do filme");
					titulo = JOptionPane.showInputDialog("Titulo do filme");
					genero = JOptionPane.showInputDialog("Genero do filme");
					produtora = JOptionPane.showInputDialog("Produtora do filme");
					fm.setCodigo(codigo);
					fm.setTitulo(titulo);
					fm.setGenero(genero);
					fm.setProdutora(produtora);
					if (listaFilmes != null) {
						for (Filme filme : listaFilmes) {
							JOptionPane.showMessageDialog(null, "Código: " + filme.getCodigo() + "\nTitulo: " + filme.getTitulo() + 
									"\nGenero: " + filme.getGenero() + "\nProdutora: " + filme.getProdutora());
						}
					} else {
						JOptionPane.showMessageDialog(null,"Lista vazia");
					}
					Conexao.fecharConexao(con);
					break;
				case 3:
					codigo = JOptionPane.showInputDialog("Código do filme");
					fm.setCodigo(codigo);
					System.out.println(fmDAO.excluir(fm));
					if (listaFilmes != null) {
						for (Filme filme : listaFilmes) {
							JOptionPane.showMessageDialog(null, "Código: " + filme.getCodigo() + "\nTitulo: " + filme.getTitulo() + 
									"\nGenero: " + filme.getGenero() + "\nProdutora: " + filme.getProdutora());
						}
					} else {
						JOptionPane.showMessageDialog(null,"Lista vazia");
					}
					Conexao.fecharConexao(con);
					break;
				default:
					break;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			escolha = JOptionPane.showInputDialog("Deseja continuar? sim ou não?");
		}
	}
}
