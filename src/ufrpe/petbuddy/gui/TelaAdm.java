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
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;

import ufrpe.petbuddy.exceptions.HistException;
import ufrpe.petbuddy.facade.*;
import ufrpe.petbuddy.negocio.beans.*;
import ufrpe.petbuddy.gui.*;

public class TelaAdm extends JFrame implements ActionListener{

	private JPanel painel;
	private JButton botaoCadastroAnimais; 
	private JButton botaoCadastroVeterinario;
	private JButton botaoHistoricoAdocoes;
	private JButton botaoAtualizarAnimais;
	private JButton botaoControleVeterinarios;
	private JButton botaoSair;
	private JButton botaoHistoricoCadastro;
	private JButton botaoAtualizarVeterinarios;
	private JButton botaoListaUsuarios;
	private IFachada fachada;
	private Usuario usuario;
	 
	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	//	EventQueue.invokeLater(new Runnable() {
	//		public void run() {
	//			try {
	//				TelaAdm frame = new TelaAdm();
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
	public TelaAdm(IFachada fachada, Usuario u) {
		
		this.usuario = u;
		this.fachada = fachada;
		setTitle("PetBuddy");
		setIconImage(Toolkit.getDefaultToolkit().getImage("Sprites\\sai.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		painel.setLayout(null);
		setContentPane(painel);
		JLabel textoAdministrador = new JLabel("Administrador");
		textoAdministrador.setForeground(new Color(160, 82, 45));
		textoAdministrador.setFont(new Font("Segoe Script", Font.PLAIN, 34));
		textoAdministrador.setBounds(246, 11, 288, 50);
		painel.add(textoAdministrador, BorderLayout.NORTH);
		
		BufferedImage buttonIcon;
		try {
			buttonIcon = ImageIO.read(new File("Sprites\\historico adocoes.gif"));
			this.botaoHistoricoAdocoes = new JButton(new ImageIcon(buttonIcon));
			this.botaoHistoricoAdocoes.setBounds(10, 98, 465, 47);
			this.botaoHistoricoAdocoes.setBorder(BorderFactory.createEmptyBorder());
			this.botaoHistoricoAdocoes.setContentAreaFilled(false);
			botaoHistoricoAdocoes.addActionListener(this);
			painel.add(botaoHistoricoAdocoes);
			
			BufferedImage buttonIcon3 = ImageIO.read(new File("Sprites\\cadastro animais.gif"));
			this.botaoCadastroAnimais = new JButton(new ImageIcon(buttonIcon3));
			this.botaoCadastroAnimais.setBounds(10, 270, 441, 47);
			this.botaoCadastroAnimais.setBorder(BorderFactory.createEmptyBorder());
			this.botaoCadastroAnimais.setContentAreaFilled(false);
			botaoCadastroAnimais.addActionListener(this);
			painel.add(botaoCadastroAnimais);
			
			BufferedImage buttonIcon4 = ImageIO.read(new File("Sprites\\cadastro veterinario.gif"));
			this.botaoCadastroVeterinario = new JButton(new ImageIcon(buttonIcon4));
			this.botaoCadastroVeterinario.setBounds(10, 502, 548, 45);
			this.botaoCadastroVeterinario.setBorder(BorderFactory.createEmptyBorder());
			this.botaoCadastroVeterinario.setContentAreaFilled(false);
			botaoCadastroVeterinario.addActionListener(this);
			painel.add(botaoCadastroVeterinario);
			
			BufferedImage buttonIcon2 = ImageIO.read(new File("Sprites\\Sair.gif"));
			this.botaoSair = new JButton(new ImageIcon(buttonIcon2));
			this.botaoSair.setBounds(662, 501, 103, 46);
			this.botaoSair.setBorder(BorderFactory.createEmptyBorder());
			this.botaoSair.setContentAreaFilled(false);
			botaoSair.addActionListener(this);
			painel.add(botaoSair);
			
			BufferedImage buttonIcon5 = ImageIO.read(new File("Sprites\\atualizar animais.gif"));
			this.botaoAtualizarAnimais = new JButton(new ImageIcon(buttonIcon5));
			this.botaoAtualizarAnimais.setBounds(10, 444, 461, 47);
			this.botaoAtualizarAnimais.setBorder(BorderFactory.createEmptyBorder());
			this.botaoAtualizarAnimais.setContentAreaFilled(false);
			botaoAtualizarAnimais.addActionListener(this);
			painel.add(botaoAtualizarAnimais);
			
			BufferedImage buttonIcon6 = ImageIO.read(new File("Sprites\\historico veterinarios.gif"));
			this.botaoControleVeterinarios = new JButton(new ImageIcon(buttonIcon6));
			this.botaoControleVeterinarios.setBounds(10, 328, 581, 47);
			this.botaoControleVeterinarios.setBorder(BorderFactory.createEmptyBorder());
			this.botaoControleVeterinarios.setContentAreaFilled(false);
			botaoControleVeterinarios.addActionListener(this);
			painel.add(botaoControleVeterinarios);
			
			BufferedImage buttonIcon7 = ImageIO.read(new File("Sprites\\historico animais.gif"));
			this.botaoHistoricoCadastro = new JButton(new ImageIcon(buttonIcon7));
			this.botaoHistoricoCadastro.setBounds(10, 156, 445, 47);
			this.botaoHistoricoCadastro.setBorder(BorderFactory.createEmptyBorder());
			this.botaoHistoricoCadastro.setContentAreaFilled(false);
			botaoHistoricoCadastro.addActionListener(this);
			painel.add(botaoHistoricoCadastro);
			
			BufferedImage buttonIcon8 = ImageIO.read(new File("Sprites\\atualizar veterinarios.gif"));
			this.botaoAtualizarVeterinarios = new JButton(new ImageIcon(buttonIcon8));
			this.botaoAtualizarVeterinarios.setBounds(10, 386, 597, 47);
			this.botaoAtualizarVeterinarios.setBorder(BorderFactory.createEmptyBorder());
			this.botaoAtualizarVeterinarios.setContentAreaFilled(false);
			botaoAtualizarVeterinarios.addActionListener(this);
			painel.add(botaoAtualizarVeterinarios);
			
			BufferedImage buttonIcon9 = ImageIO.read(new File("Sprites\\historico usuario.gif"));
			this.botaoListaUsuarios = new JButton(new ImageIcon(buttonIcon9));
			this.botaoListaUsuarios.setBounds(10, 214, 449, 45);
			this.botaoListaUsuarios.setBorder(BorderFactory.createEmptyBorder());
			this.botaoListaUsuarios.setContentAreaFilled(false);
			botaoListaUsuarios.addActionListener(this);
			painel.add(botaoListaUsuarios);
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		BackgroundImageJFrame();
	}
	public void actionPerformed (ActionEvent evento){
		if (evento.getSource().equals(this.botaoCadastroAnimais)){
			dispose();
			TelaCadastroAnimal cadastroAnimais = new TelaCadastroAnimal(fachada,usuario);
			cadastroAnimais.setVisible(true);
		} else if(evento.getSource().equals(this.botaoCadastroVeterinario)){
			dispose();
			TelaCadastroVeterinario cadastroVet = new TelaCadastroVeterinario(fachada,usuario);
			cadastroVet.setVisible(true);
		}else if(evento.getSource().equals(this.botaoSair)){
			dispose();
			TelaPrincipal tela = new TelaPrincipal(fachada);
			tela.setVisible(true);
		}
		else if(evento.getSource().equals(botaoHistoricoAdocoes)){
			
			try{
				ArrayList<Adocao>adocoes = fachada.buscaHistoricoAdocoes();
				if(adocoes.size()>0){
					TelaHistoricoAdocoes tela = new TelaHistoricoAdocoes(usuario,adocoes);
					dispose();
					tela.setVisible(true);
				}
				}
			catch(HistException h){
				JOptionPane.showMessageDialog(null, h.getMessage());
			}
				
		}
		else if(evento.getSource().equals(botaoAtualizarAnimais)){
			dispose();
			TelaBuscaAnimais tela = new TelaBuscaAnimais(usuario);
			tela.setVisible(true);
		} else if(evento.getSource().equals(botaoControleVeterinarios)){
			try{
				ArrayList<Veterinario>buscados = fachada.ListarVet();
				dispose();
				TelaListaVeterinarios tela = new TelaListaVeterinarios(usuario,buscados);
				tela.setVisible(true);

			}
			catch(HistException h){
				JOptionPane.showMessageDialog(null, h.getMessage());
			}
						
		}else if(evento.getSource().equals(botaoHistoricoCadastro)){
			try{
				ArrayList<Animal>animais = fachada.listarAnimais();
				dispose();
				TelaHistoricoCadastro tela = new TelaHistoricoCadastro(usuario,animais);
				tela.setVisible(true);
			}
			catch(HistException h){
				JOptionPane.showMessageDialog(null, h.getMessage());
			}
		}else if(evento.getSource().equals(botaoAtualizarVeterinarios)){
				try{
				ArrayList<Veterinario> vet = fachada.ListarVet();
				dispose();
				TelaAtualizarVet tela = new TelaAtualizarVet(fachada,usuario,vet);
				tela.setVisible(true);
				}
				catch(HistException h){
					JOptionPane.showMessageDialog(null, h.getMessage());
		}
		
			
		}
		else if(evento.getSource().equals(botaoListaUsuarios)){
			try{
				ArrayList<Usuario>buscados = fachada.listarUsuarios();
				dispose();
				TelaListaUsuarios tela = new TelaListaUsuarios(usuario, buscados);
				tela.setVisible(true);
			}
			catch(HistException h){
				JOptionPane.showMessageDialog(null, h.getMessage());
			}
		}
}	
	public void BackgroundImageJFrame(){ //usar para mudar background, colocar no final da criação
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setVisible(true);
	    getContentPane().setLayout(new BorderLayout());
	    try {
		    BufferedImage ibage = ImageIO.read(new File("Sprites\\tadm.jpg"));		
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

