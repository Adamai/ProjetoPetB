package ufrpe.petbuddy.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import ufrpe.petbuddy.exceptions.DadosException;
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
	private JPasswordField campoConfirma;
	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() {
			//public void run() {
				//try {
					//TelaCadastroUsuario frame = new TelaCadastroUsuario(Fachada.getInstance());
					//frame.setVisible(true);
				//} catch (Exception e) {
					//e.printStackTrace();
				//}
			//}
		//});
	//}

	/**
	 * Create the frame.
	 */
	public TelaCadastroUsuario(IFachada fachada) {
		this.fachada = fachada;
		setTitle("PetBuddy");
		setIconImage(Toolkit.getDefaultToolkit().getImage("Sprites\\sai.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel textoCadastroUsuario = new JLabel("Cadastro Usu\u00E1rio");
		textoCadastroUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textoCadastroUsuario.setBounds(314, 26, 156, 44);
		contentPane.add(textoCadastroUsuario);
		
		JLabel textoNome = new JLabel("Nome");
		textoNome.setBounds(42, 271, 46, 14);
		contentPane.add(textoNome);
		
		JLabel textoEmail = new JLabel("Email");
		textoEmail.setBounds(42, 331, 46, 14);
		contentPane.add(textoEmail);
		
		JLabel textoTelefone = new JLabel("Telefone");
		textoTelefone.setBounds(42, 391, 66, 14);
		contentPane.add(textoTelefone);
		
		JLabel textoIdade = new JLabel("Idade");
		textoIdade.setBounds(42, 451, 46, 14);
		contentPane.add(textoIdade);
		
		JLabel textoEndereco = new JLabel("Endere\u00E7o");
		textoEndereco.setBounds(42, 511, 79, 14);
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
		campoNome.setBounds(175, 265, 274, 20);
		contentPane.add(campoNome);
		
		campoEmail = new JTextField();
		campoEmail.setColumns(10);
		campoEmail.setBounds(175, 325, 274, 20);
		contentPane.add(campoEmail);
		
		campoTelefone = new JTextField();
		campoTelefone.setColumns(10);
		campoTelefone.setBounds(175, 385, 274, 20);
		contentPane.add(campoTelefone);
		
		campoIdade = new JTextField();
		campoIdade.setColumns(10);
		campoIdade.setBounds(175, 445, 274, 20);
		contentPane.add(campoIdade);
		
		campoEndereco = new JTextField();
		campoEndereco.setColumns(10);
		campoEndereco.setBounds(175, 505, 274, 20);
		contentPane.add(campoEndereco);
		
		try {
			BufferedImage buttonIcon = ImageIO.read(new File("Sprites\\Cadastrar.gif"));
			this.botaoCadastrar = new JButton(new ImageIcon(buttonIcon));
			this.botaoCadastrar.setBounds(304, 404, 255, 46);
			this.botaoCadastrar.setBorder(BorderFactory.createEmptyBorder());
			this.botaoCadastrar.setContentAreaFilled(false);
			botaoCadastrar.addActionListener(this);
			contentPane.add(botaoCadastrar);
			
			BufferedImage buttonIcon2 = ImageIO.read(new File("Sprites\\voltar.gif"));
			this.botaoVoltar = new JButton(new ImageIcon(buttonIcon2));
			this.botaoVoltar.setBounds(70, 428, 167, 46);
			this.botaoVoltar.setBorder(BorderFactory.createEmptyBorder());
			this.botaoVoltar.setContentAreaFilled(false);
			botaoVoltar.addActionListener(this);
			contentPane.add(botaoVoltar);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		campoConfirma = new JPasswordField();
		campoConfirma.setColumns(10);
		campoConfirma.setBounds(175, 216, 274, 20);
		contentPane.add(campoConfirma);
		
		JLabel lblConfirmeASenha = new JLabel("Confirme a senha");
		lblConfirmeASenha.setBounds(42, 219, 123, 14);
		contentPane.add(lblConfirmeASenha);
		BackgroundImageJFrame();
	}
	
	public void actionPerformed(ActionEvent evento){
		String nome;
		String login;
		String senha;
		String confirme;
		String email;
		int idade;
		String endereco;
		int contato;
		
		if(evento.getSource().equals(botaoCadastrar)){
			try{
			nome = campoNome.getText();
			login = campoLogin.getText();
			senha = campoSenha.getText();
			confirme = campoConfirma.getText();
			email = campoEmail.getText();
			idade = Integer.parseInt(campoIdade.getText());
			endereco = campoEndereco.getText();
			contato = Integer.parseInt(campoTelefone.getText());
			
			if(fachada.VerificarLogin(login)){
				if(senha.equals(confirme)){
					Pessoa p = new Pessoa(nome,idade,contato,email,endereco,login,senha);
					fachada.cadastrarPessoa(p);
					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
					dispose();
					TelaPrincipal tela = new TelaPrincipal(fachada);
					tela.setVisible(true);
				}
				else{
					JOptionPane.showMessageDialog(null, "Confirme a senha novamente");
				}
			}
			else
				JOptionPane.showMessageDialog(null, "Login indisponível");
			}
			catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "dados incorretos");
			}
			catch(DadosException d){
				JOptionPane.showMessageDialog(null, d.getMessage());
			}
			
		}
		else if (evento.getSource().equals(botaoVoltar)){
			dispose();
			TelaPrincipal tela = new TelaPrincipal(fachada);
			tela.setVisible(true);
		}
	}
	public void BackgroundImageJFrame(){ //usar para mudar background, colocar no final da criação
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setVisible(true);
	    getContentPane().setLayout(new BorderLayout());
	    try {
		    BufferedImage ibage = ImageIO.read(new File("Sprites\\tcadastro usuario.jpg"));		
		    BufferedImage img = new BufferedImage(800,600,BufferedImage.TYPE_INT_RGB);
		    img.getGraphics().drawImage(ibage,0,0,800,600,null);
		    JLabel background =new JLabel(new ImageIcon(img));
		    getContentPane().add(background);
		    background.setLayout(new FlowLayout());
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
}
