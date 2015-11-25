package ufrpe.petbuddy.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ufrpe.petbuddy.facade.*;
import ufrpe.petbuddy.negocio.beans.*;

public class TelaCadastroUsuario extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField campoLogin;
	private JPasswordField campoSenha;
	private JTextField campoNome;
	private JTextField campoEmail;
	private JTextField campoTelefone;
	private JTextField campoIdade;
	private JTextField campoEndereco;
	private JButton botaoCadastrar, botaoVoltar;
	private IFachada fachada;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroUsuario frame = new TelaCadastroUsuario(Fachada.getInstance());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastroUsuario(IFachada fachada) {
		this.fachada = fachada;
		setTitle("PetBuddy");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel textoCadastroUsuario = new JLabel("Cadastro Usu\u00E1rio");
		textoCadastroUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textoCadastroUsuario.setBounds(314, 26, 156, 44);
		contentPane.add(textoCadastroUsuario);
		
		JLabel textoNome = new JLabel("Nome");
		textoNome.setBounds(42, 232, 46, 14);
		contentPane.add(textoNome);
		
		JLabel textoEmail = new JLabel("Email");
		textoEmail.setBounds(42, 292, 46, 14);
		contentPane.add(textoEmail);
		
		JLabel textoTelefone = new JLabel("Telefone");
		textoTelefone.setBounds(42, 352, 66, 14);
		contentPane.add(textoTelefone);
		
		JLabel textoIdade = new JLabel("Idade");
		textoIdade.setBounds(42, 412, 46, 14);
		contentPane.add(textoIdade);
		
		JLabel textoEndereco = new JLabel("Endere\u00E7o");
		textoEndereco.setBounds(42, 472, 79, 14);
		contentPane.add(textoEndereco);
		
		JLabel textoLogin = new JLabel("Login");
		textoLogin.setBounds(42, 112, 46, 14);
		contentPane.add(textoLogin);
		
		JLabel textoSenha = new JLabel("Senha");
		textoSenha.setBounds(42, 172, 46, 14);
		contentPane.add(textoSenha);
		
		campoLogin = new JTextField();
		campoLogin.setBounds(175, 109, 274, 20);
		contentPane.add(campoLogin);
		campoLogin.setColumns(10);
		
		campoSenha = new JPasswordField();
		campoSenha.setColumns(10);
		campoSenha.setBounds(175, 166, 274, 20);
		contentPane.add(campoSenha);
		
		campoNome = new JTextField();
		campoNome.setColumns(10);
		campoNome.setBounds(175, 226, 274, 20);
		contentPane.add(campoNome);
		
		campoEmail = new JTextField();
		campoEmail.setColumns(10);
		campoEmail.setBounds(175, 286, 274, 20);
		contentPane.add(campoEmail);
		
		campoTelefone = new JTextField();
		campoTelefone.setColumns(10);
		campoTelefone.setBounds(175, 346, 274, 20);
		contentPane.add(campoTelefone);
		
		campoIdade = new JTextField();
		campoIdade.setColumns(10);
		campoIdade.setBounds(175, 406, 274, 20);
		contentPane.add(campoIdade);
		
		campoEndereco = new JTextField();
		campoEndereco.setColumns(10);
		campoEndereco.setBounds(175, 466, 274, 20);
		contentPane.add(campoEndereco);
		
		this.botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botaoCadastrar.setBounds(560, 370, 156, 58);
		botaoCadastrar.addActionListener(this);
		contentPane.add(botaoCadastrar);
		
		this.botaoVoltar = new JButton("Voltar");
		botaoVoltar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botaoVoltar.setBounds(575, 456, 127, 44);
		botaoVoltar.addActionListener(this);
		contentPane.add(botaoVoltar);
	}
	
	public void actionPerformed(ActionEvent evento){
		String nome;
		String login;
		String senha;
		String email;
		int idade;
		String endereco;
		int contato;
		
		if(evento.getSource().equals(botaoCadastrar)){
			try{
			nome = campoNome.getText();
			login = campoLogin.getText();
			senha = campoSenha.getText();
			email = campoEmail.getText();
			idade = Integer.parseInt(campoIdade.getText());
			endereco = campoEndereco.getText();
			contato = Integer.parseInt(campoTelefone.getText());
			
			Pessoa p = new Pessoa(nome,idade,contato,endereco,login,senha);
			fachada.cadastrarPessoa(p);
			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
			dispose();
			TelaPrincipal tela = new TelaPrincipal(fachada);
			tela.setVisible(true);
			}
			catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "dados incorretos");
			}
			
		}
		else if (evento.getSource().equals(botaoVoltar)){
			dispose();
			TelaPrincipal tela = new TelaPrincipal(fachada);
			tela.setVisible(true);
		}
	}
	

}
