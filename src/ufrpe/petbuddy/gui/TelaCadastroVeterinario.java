package ufrpe.petbuddy.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import ufrpe.petbuddy.facade.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ufrpe.petbuddy.negocio.beans.*;

public class TelaCadastroVeterinario extends JFrame implements ActionListener{

	private JPanel painel;
	private JTextField campoNome;
	private JTextField campoTelefone;
	private JTextField campoIdade;
	private JTextField campoCRMV;
	private IFachada fachada;
	private JButton botaoVoltar;
	private JButton botaoCadastrar;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	//	EventQueue.invokeLater(new Runnable() {
	//		public void run() {
	//			try {
	//				TelaCadastroVeterinario frame = new TelaCadastroVeterinario();
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
	public TelaCadastroVeterinario(IFachada fachada) {
		this.fachada = fachada;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		painel.setLayout(null);
		setContentPane(painel);
		
		JLabel textoCadastroVeterinario = new JLabel("Cadastro Veterin\u00E1rio");
		textoCadastroVeterinario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textoCadastroVeterinario.setBounds(292, 24, 200, 50);
		painel.add(textoCadastroVeterinario);
		
		JLabel textoNome = new JLabel("Nome");
		textoNome.setBounds(55, 109, 56, 50);
		painel.add(textoNome);
		
		JLabel textoTelefone = new JLabel("Telefone");
		textoTelefone.setBounds(55, 230, 94, 50);
		painel.add(textoTelefone);
		
		JLabel textoIdade = new JLabel("Idade");
		textoIdade.setBounds(435, 230, 94, 50);
		painel.add(textoIdade);
		
		JLabel textoCrmv = new JLabel("CRMV");
		textoCrmv.setBounds(435, 109, 43, 50);
		painel.add(textoCrmv);
		
		campoNome = new JTextField();
		campoNome.setBounds(65, 170, 228, 29);
		painel.add(campoNome);
		campoNome.setColumns(10);
		
		campoTelefone = new JTextField();
		campoTelefone.setBounds(78, 302, 226, 29);
		painel.add(campoTelefone);
		campoTelefone.setColumns(10);
		
		campoIdade = new JTextField();
		campoIdade.setColumns(10);
		campoIdade.setBounds(446, 302, 226, 29);
		painel.add(campoIdade);
		
		campoCRMV = new JTextField();
		campoCRMV.setColumns(10);
		campoCRMV.setBounds(445, 170, 226, 29);
		painel.add(campoCRMV);
		
		this.botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botaoCadastrar.setBounds(559, 408, 161, 77);
		painel.add(botaoCadastrar);
		
		this.botaoVoltar = new JButton("Voltar");
		botaoVoltar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botaoVoltar.setBounds(55, 435, 139, 50);
		painel.add(botaoVoltar);
	}
	
	public void actionPerformed(ActionEvent evento){
		if(evento.getSource().equals(botaoCadastrar)){
			String nome = campoNome.getText();
			int telefone = Integer.parseInt(campoTelefone.getText());
			int idade = Integer.parseInt(campoIdade.getText());
			long crmv = Long.parseLong(campoCRMV.getText());
			Veterinario vet = new Veterinario(nome,telefone,idade,crmv);
			fachada.cadastrarVet(vet);
			
			dispose();
			TelaAdm tela = new TelaAdm(fachada);
			tela.setVisible(true);
				
		}	else if (evento.getSource().equals(botaoVoltar)){
			dispose();
			TelaAdm tela = new TelaAdm(fachada);
			tela.setVisible(true);	
	}
}
}