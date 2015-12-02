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

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import ufrpe.petbuddy.facade.*;
import ufrpe.petbuddy.negocio.beans.*;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class TelaLogado extends JFrame implements ActionListener{

	private JPanel painel;
	private JButton botaoBusca,botaoSair;
	private IFachada fachada;
	private Usuario usuario;


	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	//	EventQueue.invokeLater(new Runnable() {
	//		public void run() {
	//			try {
	//				TelaLogado frame = new TelaLogado();
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
	public TelaLogado(IFachada fachada, Usuario u) {
		this.fachada = fachada;
		this.usuario = u;
		
		setTitle("PetBuddy");
		setIconImage(Toolkit.getDefaultToolkit().getImage("Sprites\\sai.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		painel.setLayout(null);
		setContentPane(painel);
		
		BufferedImage buttonIcon;
		try {
			buttonIcon = ImageIO.read(new File("Sprites\\buscar animais.gif"));
			this.botaoBusca = new JButton(new ImageIcon(buttonIcon));
			this.botaoBusca.setBounds(174, 301, 383, 47);
			this.botaoBusca.setBorder(BorderFactory.createEmptyBorder());
			this.botaoBusca.setContentAreaFilled(false);
			botaoBusca.addActionListener(this);
			painel.add(botaoBusca);
			
			BufferedImage buttonIcon2 = ImageIO.read(new File("Sprites\\Sair.gif"));
			this.botaoSair = new JButton(new ImageIcon(buttonIcon2));
			this.botaoSair.setBounds(326, 415, 103, 46);
			this.botaoSair.setBorder(BorderFactory.createEmptyBorder());
			this.botaoSair.setContentAreaFilled(false);
			botaoSair.addActionListener(this);
			painel.add(botaoSair);
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		if(usuario != null){
			JLabel label = new JLabel("Bem vindo " + usuario.getNome());
			label.setFont(new Font("Tahoma", Font.PLAIN, 18));
			label.setBounds(104, 11, 592, 65);
			painel.add(label);
		}
	
		BackgroundImageJFrame();
		}
	
	public void actionPerformed(ActionEvent evento){
		if(evento.getSource().equals(botaoBusca)){
			dispose();
			TelaBuscaAnimais tela = new TelaBuscaAnimais(usuario);
			tela.setVisible(true);
		}
		if(evento.getSource().equals(botaoSair)){
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
		    BufferedImage ibage = ImageIO.read(new File("Sprites\\tlogado.jpg"));		
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
