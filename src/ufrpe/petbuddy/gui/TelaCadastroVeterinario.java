package ufrpe.petbuddy.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import ufrpe.petbuddy.exceptions.DadosException;
import ufrpe.petbuddy.facade.*;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

import ufrpe.petbuddy.negocio.beans.*;
import ufrpe.petbuddy.exceptions.*;

public class TelaCadastroVeterinario extends JFrame implements ActionListener{

	private JPanel painel;
	private JTextField campoNome;
	private JTextField campoTelefone;
	private JTextField campoIdade;
	private IFachada fachada;
	private JButton botaoVoltar;
	private JButton botaoCadastrar;
	private Usuario usuario;
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
	public TelaCadastroVeterinario(IFachada fachada,Usuario usuario) {
		setTitle("PetBuddy");
		this.usuario = usuario;
		this.fachada = fachada;
		setIconImage(Toolkit.getDefaultToolkit().getImage("Sprites\\sai.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		painel.setLayout(null);
		setContentPane(painel);
		
		JLabel textoCadastroVeterinario = new JLabel("Cadastro Veterin\u00E1rio");
		textoCadastroVeterinario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textoCadastroVeterinario.setBounds(292, 24, 200, 50);
		painel.add(textoCadastroVeterinario);
		
		JLabel textoNome = new JLabel("Nome");
		textoNome.setBounds(56, 82, 56, 50);
		painel.add(textoNome);
		
		JLabel textoTelefone = new JLabel("Telefone");
		textoTelefone.setBounds(56, 198, 94, 50);
		painel.add(textoTelefone);
		
		JLabel textoIdade = new JLabel("Idade");
		textoIdade.setBounds(56, 318, 94, 50);
		painel.add(textoIdade);
		
		campoNome = new JTextField();
		campoNome.setBounds(66, 143, 228, 29);
		painel.add(campoNome);
		campoNome.setColumns(10);
		
		campoTelefone = new JTextField();
		campoTelefone.setBounds(66, 259, 226, 29);
		painel.add(campoTelefone);
		campoTelefone.setColumns(10);
		
		campoIdade = new JTextField();
		campoIdade.setColumns(10);
		campoIdade.setBounds(66, 379, 226, 29);
		painel.add(campoIdade);
		
		BufferedImage buttonIcon;
		try {
			buttonIcon = ImageIO.read(new File("Sprites\\Cadastrar.gif"));
			this.botaoCadastrar = new JButton(new ImageIcon(buttonIcon));
			this.botaoCadastrar.setBounds(56, 458, 255, 46);
			this.botaoCadastrar.setBorder(BorderFactory.createEmptyBorder());
			this.botaoCadastrar.setContentAreaFilled(false);
			botaoCadastrar.addActionListener(this);
			painel.add(botaoCadastrar);
			
			BufferedImage buttonIcon2 = ImageIO.read(new File("Sprites\\voltar.gif"));
			this.botaoVoltar = new JButton(new ImageIcon(buttonIcon2));
			this.botaoVoltar.setBounds(56, 515, 167, 46);
			this.botaoVoltar.setBorder(BorderFactory.createEmptyBorder());
			this.botaoVoltar.setContentAreaFilled(false);
			botaoVoltar.addActionListener(this);
			painel.add(botaoVoltar);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		BackgroundImageJFrame();
	}
	
	public void actionPerformed(ActionEvent evento){
		if(evento.getSource().equals(botaoCadastrar)){
			try{
				String nome = campoNome.getText();
				long contato = Long.parseLong(campoTelefone.getText());;
				int idade = Integer.parseInt(campoIdade.getText());
				Veterinario vet = new Veterinario(nome,idade,contato);
				fachada.cadastrarVet(vet);
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
				dispose();
				TelaAdm tela = new TelaAdm(fachada,usuario);
				tela.setVisible(true);
			}
			catch(DadosException d){
				JOptionPane.showMessageDialog(null, d.getMessage());
			}
				
		}	else if (evento.getSource().equals(botaoVoltar)){
			dispose();
			TelaAdm tela = new TelaAdm(fachada,usuario);
			tela.setVisible(true);	
	}
}
	public void BackgroundImageJFrame(){ //usar para mudar background, colocar no final da criação
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setVisible(true);
	    getContentPane().setLayout(new BorderLayout());
	    try {
		    BufferedImage ibage = ImageIO.read(new File("Sprites\\tcadastro vet.jpg"));		
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