package ufrpe.petbuddy.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ufrpe.petbuddy.facade.*;

public class TelaPrincipal extends JFrame implements ActionListener{

	private JPanel painel;
	private JButton botaoLogin, botaoBusca, botaoCadastro;
	private IFachada fachada;
	//private GerenciadorTelas gerenciador = GerenciadorTelas.getInstance();

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() {
			//public void run() {
				//try {
					//TelaPrincipal frame = new TelaPrincipal();
					//frame.setVisible(true);
			//	} catch (Exception e) {
				//	e.printStackTrace();
				//}
			//}
		//});
	//}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal(IFachada fachada) {
		
		this.fachada = fachada;		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		painel.setLayout(null);
		setContentPane(painel);
		
		JLabel textoBemVindo = new JLabel("Bem vindo ao PetBuddy");
		textoBemVindo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textoBemVindo.setBounds(280, 11, 224, 78);
		painel.add(textoBemVindo);
		
		this.botaoCadastro = new JButton("Cadastre-se");
		this.botaoCadastro.setBounds(322, 308, 164, 58);
		botaoCadastro.addActionListener(this);
		painel.add(botaoCadastro);
		
		this.botaoLogin = new JButton("Login");
		this.botaoLogin.setBounds(322, 233, 164, 58);
		botaoLogin.addActionListener(this);
		painel.add(botaoLogin);
		
		
		this.botaoBusca = new JButton("Procurar Animais");
		this.botaoBusca.setBounds(322, 383, 164, 58);
		//AcaoBotaoBusca actionBusca = new AcaoBotaoBusca();
		botaoBusca.addActionListener(this);
		painel.add(botaoBusca);
		
	}
	
	public void actionPerformed (ActionEvent evento){
		if (evento.getSource().equals(this.botaoLogin)){
			dispose();
			TelaLogin tela = new TelaLogin(fachada);
			tela.setVisible(true);
		} else if(evento.getSource().equals(this.botaoCadastro)){
			dispose();
			TelaCadastroUsuario cadastro = new TelaCadastroUsuario(fachada);
			cadastro.setVisible(true);
		}else if(evento.getSource().equals(this.botaoBusca)){
			dispose();
			TelaBuscaAnimais buscaAnimais = new TelaBuscaAnimais(fachada,null);
			buscaAnimais.setVisible(true);
		}
	}

	//public class AcaoBotaoBusca implements ActionListener{
	
		//public void actionPerformed(ActionEvent evento){
			//if (evento.getSource() == botaoBusca)
		//	dispose();
		//	TelaBuscaAnimais tela =new  TelaBuscaAnimais();
			//tela.setVisible(true);
		//}
	//}
}
