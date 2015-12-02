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
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import ufrpe.petbuddy.exceptions.IDException;
import ufrpe.petbuddy.exceptions.RepoException;
import ufrpe.petbuddy.facade.Fachada;
import ufrpe.petbuddy.facade.IFachada;
import ufrpe.petbuddy.negocio.beans.*;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class TelaBuscaAnimais extends JFrame implements ActionListener {

	private IFachada fachada;
	private Usuario usuario;
	private JPanel painel;
	private JTextField campoRaca;
	private JButton botaoVoltar;
	private JButton botaoBusca;
	private ButtonGroup grupo;
	private JRadioButton radioButtonCachorro, radioButtonGato,radioButtonAve,radioButtonRoedor,radioButtonReptil;
	private ArrayList<Animal> buscados;
	private JLabel textoBuscarTodos;
	private JLabel textoBuscaPorEspcie;
	private JButton botaoBuscarTodos;


	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	//	EventQueue.invokeLater(new Runnable() {
	//		public void run() {
	//			try {
	//				TelaBuscaAnimais frame = new TelaBuscaAnimais(Fachada.getInstance());
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
	public TelaBuscaAnimais( Usuario u) {
		
		this.usuario = u;
		this.fachada = Fachada.getInstance(); 
		setTitle("PetBuddy");
		setIconImage(Toolkit.getDefaultToolkit().getImage("Sprites\\sai.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		painel.setLayout(null);
		setContentPane(painel);
		this.grupo = new ButtonGroup();
		
		JLabel textoInsiraOsDados = new JLabel("Insira os dados referentes ao tipo de animal que esta procurando");
		textoInsiraOsDados.setFont(new Font("Segoe Script", Font.PLAIN, 17));
		textoInsiraOsDados.setBounds(138, 63, 602, 46);
		painel.add(textoInsiraOsDados);
		
		JLabel textoRaca = new JLabel("Ra\u00E7a");
		textoRaca.setFont(new Font("Segoe Script", Font.PLAIN, 13));
		textoRaca.setBounds(42, 233, 43, 30);
		painel.add(textoRaca);
		
		campoRaca = new JTextField();
		campoRaca.setBounds(95, 234, 352, 30);
		painel.add(campoRaca);
		campoRaca.setColumns(10);
		
		this.radioButtonCachorro = new JRadioButton("Cachorro");
		radioButtonCachorro.setContentAreaFilled(false);
		radioButtonCachorro.setFont(new Font("Segoe Script", Font.PLAIN, 13));
		radioButtonCachorro.setBounds(39, 156, 109, 23);
		radioButtonCachorro.addActionListener(this);
		painel.add(radioButtonCachorro);
		grupo.add(radioButtonCachorro);
		
		this.radioButtonGato = new JRadioButton("Gato");
		radioButtonGato.setContentAreaFilled(false);
		radioButtonGato.setFont(new Font("Segoe Script", Font.PLAIN, 13));
		radioButtonGato.setBounds(187, 156, 109, 23);
		radioButtonGato.addActionListener(this);
		painel.add(radioButtonGato);
		grupo.add(radioButtonGato);
		
		this.radioButtonReptil = new JRadioButton("Reptil");
		radioButtonReptil.setContentAreaFilled(false);
		radioButtonReptil.setFont(new Font("Segoe Script", Font.PLAIN, 13));
		radioButtonReptil.setBounds(483, 156, 109, 23);
		radioButtonReptil.addActionListener(this);
		painel.add(radioButtonReptil);
		grupo.add(radioButtonReptil);
		
		this.radioButtonRoedor = new JRadioButton("Roedor");
		radioButtonRoedor.setContentAreaFilled(false);
		radioButtonRoedor.setFont(new Font("Segoe Script", Font.PLAIN, 13));
		radioButtonRoedor.setBounds(631, 156, 109, 23);
		radioButtonRoedor.addActionListener(this);
		painel.add(radioButtonRoedor);
		grupo.add(radioButtonRoedor);
		
		this.radioButtonAve = new JRadioButton("Ave");
		radioButtonAve.setContentAreaFilled(false);
		radioButtonAve.setFont(new Font("Segoe Script", Font.PLAIN, 13));
		radioButtonAve.setBounds(335, 156, 109, 23);
		radioButtonAve.addActionListener(this);
		painel.add(radioButtonAve);
		grupo.add(radioButtonAve);
		
		BufferedImage buttonIcon;
		try {
			buttonIcon = ImageIO.read(new File("Sprites\\buscar.gif"));
			this.botaoBusca = new JButton(new ImageIcon(buttonIcon));
			this.botaoBusca.setBounds(544, 390, 196, 46);
			this.botaoBusca.setBorder(BorderFactory.createEmptyBorder());
			this.botaoBusca.setContentAreaFilled(false);
			botaoBusca.addActionListener(this);
			painel.add(botaoBusca);
			
			BufferedImage buttonIcon2 = ImageIO.read(new File("Sprites\\voltar.gif"));
			this.botaoVoltar = new JButton(new ImageIcon(buttonIcon2));
			this.botaoVoltar.setBounds(70, 428, 167, 46);
			this.botaoVoltar.setBorder(BorderFactory.createEmptyBorder());
			this.botaoVoltar.setContentAreaFilled(false);
			botaoVoltar.addActionListener(this);
			painel.add(botaoVoltar);
			
			BufferedImage buttonIcon3 = ImageIO.read(new File("Sprites\\buscar todos.gif"));
			this.botaoBuscarTodos = new JButton(new ImageIcon(buttonIcon3));
			this.botaoBuscarTodos.setBounds(438, 467, 346, 47);
			this.botaoBuscarTodos.setBorder(BorderFactory.createEmptyBorder());
			this.botaoBuscarTodos.setContentAreaFilled(false);
			botaoBuscarTodos.addActionListener(this);
			painel.add(botaoBuscarTodos);
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		textoBuscarTodos = new JLabel("Buscar todos os animais da esp\u00E9cie selecionada");
		textoBuscarTodos.setFont(new Font("Segoe Script", Font.BOLD, 13));
		textoBuscarTodos.setBounds(419, 442, 352, 14);
		painel.add(textoBuscarTodos);
		
		textoBuscaPorEspcie = new JLabel("Busca por esp\u00E9cie e ra\u00E7a");
		textoBuscaPorEspcie.setFont(new Font("Segoe Script", Font.BOLD, 13));
		textoBuscaPorEspcie.setBounds(538, 365, 191, 14);
		painel.add(textoBuscaPorEspcie);
		BackgroundImageJFrame();
	}
	
	public void actionPerformed(ActionEvent evento){
		
		AnimalEspecie especie = null;
		String raca = campoRaca.getText();
		
				if(radioButtonCachorro.isSelected()){
					especie = AnimalEspecie.CACHORRO;
					botaoBusca.setEnabled(true);
					botaoBuscarTodos.setEnabled(true);
					
				}
				if(radioButtonGato.isSelected()){
					especie = AnimalEspecie.GATO;
					botaoBusca.setEnabled(true);
					botaoBuscarTodos.setEnabled(true);
				}
				if(radioButtonAve.isSelected()){
					especie = AnimalEspecie.AVE;
					botaoBusca.setEnabled(true);
					botaoBuscarTodos.setEnabled(true);
				}
				if(radioButtonReptil.isSelected()){
					especie = AnimalEspecie.REPTIL;
					botaoBusca.setEnabled(true);
					botaoBuscarTodos.setEnabled(true);
				}
				if(radioButtonRoedor.isSelected()){
					especie = AnimalEspecie.ROEDOR;
					botaoBusca.setEnabled(true);
					botaoBuscarTodos.setEnabled(true);
				}
				
				if(evento.getSource().equals(botaoBusca)){
					try{
						if(especie == null){
							JOptionPane.showMessageDialog(null,"Selecione uma espécie e uma raça");
							}
						else {
							buscados = fachada.buscaAnimais(raca, especie);
						
						if(buscados.size()>0 && (usuario instanceof Pessoa || usuario == null)){
							JOptionPane.showMessageDialog(null,buscados.size() + " Animais encontrados" );
							dispose();
							TelaResultadoBusca tela = new TelaResultadoBusca(usuario,buscados);
							tela.setVisible(true);
								}
						else if(buscados.size()>0 && usuario instanceof Adm){
							TelaAtualizarAnimais tela = new TelaAtualizarAnimais (fachada,usuario,buscados);
							tela.setVisible(true);
									}
						else{
							JOptionPane.showMessageDialog(null, "Nenhum Animal Encontrado!");
								}
					}
						}
					
					catch(NumberFormatException n){
						JOptionPane.showMessageDialog(null, "Dados Inválidos");
					}
					catch(RepoException i){
						JOptionPane.showMessageDialog(null, i.getMessage());
					}
						}
			 if(evento.getSource().equals(botaoVoltar) && usuario instanceof Pessoa){
				dispose();
				TelaLogado tela = new TelaLogado(fachada,usuario);
				tela.setVisible(true);
			
			}if(evento.getSource().equals(botaoVoltar) && usuario instanceof Adm){
				dispose();
				TelaAdm tela = new TelaAdm(fachada, usuario);
				tela.setVisible(true);
			}if (evento.getSource().equals(botaoVoltar) && usuario == null) {
					dispose();
					TelaPrincipal tela = new TelaPrincipal(fachada);
					tela.setVisible(true);
			}if(evento.getSource().equals(botaoBuscarTodos) && (usuario instanceof Pessoa || usuario == null)){
				try{	
					buscados = fachada.buscaEspecie(especie);
						//if(buscados.size()>0){
						JOptionPane.showMessageDialog(null,especie);
						JOptionPane.showMessageDialog(null,buscados.size());
						dispose();
						TelaResultadoBusca tela = new TelaResultadoBusca(usuario,buscados);
						tela.setVisible(true);
					//}
					//else{
						//JOptionPane.showMessageDialog(null, "Nenhum animal encontrado");
					//}
				}
				catch(RepoException r){
					JOptionPane.showMessageDialog(null, r.getMessage());
				} 
			}if(evento.getSource().equals(botaoBuscarTodos) && usuario instanceof Adm){
				
				try{
					if(especie == null){
						JOptionPane.showMessageDialog(null,"Selecione uma espécie");
					}
					buscados = fachada.buscaEspecie(especie);
					//if(buscados.size()>0){
						JOptionPane.showMessageDialog(null,especie);
						JOptionPane.showMessageDialog(null,buscados.size());
						dispose();
						TelaAtualizarAnimais tela = new TelaAtualizarAnimais(fachada,usuario,buscados);
						tela.setVisible(true);
						
					//}
				}
				catch(RepoException r){
					JOptionPane.showMessageDialog(null, r.getMessage());
				}
	
			}
	}
	public void BackgroundImageJFrame(){ //usar para mudar background, colocar no final da criação
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setVisible(true);
	    getContentPane().setLayout(new BorderLayout());
	    try {
		    BufferedImage ibage = ImageIO.read(new File("Sprites\\tbusca animais.jpg"));		
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
			
			