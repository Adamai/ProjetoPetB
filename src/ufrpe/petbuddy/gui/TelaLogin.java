package ufrpe.petbuddy.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

import java.awt.Font;

import ufrpe.petbuddy.facade.*;
import ufrpe.petbuddy.negocio.beans.*;
import ufrpe.petbuddy.exceptions.*;

public class TelaLogin extends JFrame implements ActionListener {

	private JPanel painel;
	private JTextField campoLogin;
	private JPasswordField campoSenha;
	private JButton botaoVoltar;
	private JButton botaoEfetuarLogin;
	private IFachada fachada;
	//private GerenciadorTelas gerenciador = GerenciadorTelas.getInstance();

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	//	EventQueue.invokeLater(new Runnable() {
	//		public void run() {
	//			try {
	//				TelaLogin frame = new TelaLogin();
	//				frame.setVisible(true);
	//			} catch (Exception e) {
	//				e.printStackTrace();
	//			}
	//		}
	//	});
	//}

	/**
	 * Create the frame.
	 */
	public TelaLogin(IFachada fachada) {
		
		this.fachada = fachada;
		setTitle("PetBuddy");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		painel.setLayout(null);
		setContentPane(painel);
		
		JLabel textoLogins = new JLabel("Usu\u00E1rio\r\n");
		textoLogins.setBounds(70, 174, 60, 26);
		painel.add(textoLogins);
		
		JLabel textoSenha = new JLabel("Senha");
		textoSenha.setBounds(70, 230, 46, 14);
		painel.add(textoSenha);
		
		campoLogin = new JTextField();
		campoLogin.setBounds(133, 177, 321, 20);
		painel.add(campoLogin);
		campoLogin.setColumns(10);
		
		campoSenha = new JPasswordField();
		campoSenha.setBounds(133, 227, 321, 20);
		painel.add(campoSenha);
		
		this.botaoEfetuarLogin = new JButton("Entrar");
		botaoEfetuarLogin.addActionListener(this);
		botaoEfetuarLogin.setBounds(540, 341, 125, 46);
		painel.add(botaoEfetuarLogin);
		
		JLabel textoEntrar = new JLabel("Login");
		textoEntrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textoEntrar.setBounds(154, 43, 149, 38);
		painel.add(textoEntrar);
		
		this.botaoVoltar = new JButton("Voltar");
		botaoVoltar.setBounds(70, 428, 89, 23);
		botaoVoltar.addActionListener(this);
		painel.add(botaoVoltar);
		painel.setBackground(new Color(102, 255, 255) );
	
	}
	
	public void actionPerformed(ActionEvent evento){
		if(evento.getSource().equals(botaoEfetuarLogin)){
			try{
				Usuario usuario = fachada.buscaLogin(campoLogin.getText(), campoSenha.getText());
				if(usuario instanceof Pessoa){
					dispose();
					TelaLogado tela = new TelaLogado(this.fachada,usuario);
					tela.setVisible(true);
					}
				else if(usuario instanceof Adm){
					dispose();
					TelaAdm tela = new TelaAdm(this.fachada,usuario);
					tela.setVisible(true);
				}
				}
			catch(RepoException e){
				JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		else if(evento.getSource().equals(botaoVoltar)){
			dispose();
			TelaPrincipal tela = new TelaPrincipal(fachada);
			tela.setVisible(true);
		}
	}
	
}
