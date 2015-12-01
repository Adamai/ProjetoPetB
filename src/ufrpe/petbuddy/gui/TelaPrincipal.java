package ufrpe.petbuddy.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import ufrpe.petbuddy.facade.*;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class TelaPrincipal extends JFrame implements ActionListener{

	private JPanel painel;
	private JButton botaoLogin, botaoBusca, botaoCadastro;
	private IFachada fachada;
	private File imagem = new File("Sprites\\telaprincipal.jpg");
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
		setIconImage(Toolkit.getDefaultToolkit().getImage("Sprites\\sai.png"));
		setTitle("PetBuddy");
		this.fachada = fachada;		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		painel.setLayout(null);
		setContentPane(painel);
				
		JLabel textoBemVindo = new JLabel("");
		textoBemVindo.setIcon(new ImageIcon("Sprites\\PetBuddy.gif"));
		textoBemVindo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textoBemVindo.setBounds(237, 22, 340, 78);
		painel.add(textoBemVindo);
		

		
		this.botaoCadastro = new JButton("Cadastre-se");
		this.botaoCadastro.setBounds(322, 308, 164, 58);
		botaoCadastro.addActionListener(this);
		painel.add(botaoCadastro);
		
		try {
			BufferedImage buttonIcon = ImageIO.read(new File("Sprites\\Login.gif"));
			this.botaoLogin = new JButton(new ImageIcon(buttonIcon));
			this.botaoLogin.setBounds(322, 233, 164, 58);
			this.botaoLogin.setBorder(BorderFactory.createEmptyBorder());
			this.botaoLogin.setContentAreaFilled(false);
			botaoLogin.addActionListener(this);
			painel.add(botaoLogin);
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		this.botaoBusca = new JButton("Procurar Animais");
		this.botaoBusca.setBounds(322, 383, 164, 58);
		//AcaoBotaoBusca actionBusca = new AcaoBotaoBusca();
		botaoBusca.addActionListener(this);
		painel.add(botaoBusca);
		BackgroundImageJFrame();
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
			TelaBuscaAnimais buscaAnimais = new TelaBuscaAnimais(null);
			buscaAnimais.setVisible(true);
		}
	}
	
	public void BackgroundImageJFrame() //usar para mudar background, colocar no final da criação
    {
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
    setLayout(new BorderLayout());
    try {
	    BufferedImage ibage = ImageIO.read(imagem);		//imagem a ser utilizada
	    BufferedImage img = new BufferedImage(
	    		784,			//modificar baseado no tamanho da janela(background)
	    		564				//modificar baseado no tamanho da janela(background)
	    		,BufferedImage.TYPE_INT_RGB);
	    img.getGraphics().drawImage(ibage,0,0,
	    		784				//modificar baseado no tamanho da janela(background)
	    		,564			//modificar baseado no tamanho da janela(background)
	    		,null);
	    JLabel background =new JLabel(new ImageIcon(img));
	    add(background);
	    background.setLayout(new FlowLayout());
	} catch (IOException e) {
		e.printStackTrace();
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
