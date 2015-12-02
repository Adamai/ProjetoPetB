package ufrpe.petbuddy.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ButtonGroup;
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
		painel.setBackground(new Color(255, 228, 181) );
		setContentPane(painel);
		this.grupo = new ButtonGroup();
		
		JLabel textoInsiraOsDados = new JLabel("Insira os dados referentes ao tipo de animal que esta procurando");
		textoInsiraOsDados.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textoInsiraOsDados.setBounds(59, 62, 452, 46);
		painel.add(textoInsiraOsDados);
		
		JLabel textoRaca = new JLabel("Ra\u00E7a");
		textoRaca.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textoRaca.setBounds(42, 233, 43, 30);
		painel.add(textoRaca);
		
		campoRaca = new JTextField();
		campoRaca.setBounds(95, 234, 352, 30);
		painel.add(campoRaca);
		campoRaca.setColumns(10);
		
		this.radioButtonCachorro = new JRadioButton("Cachorro");
		radioButtonCachorro.setBackground(new Color(255, 228, 181) );
		radioButtonCachorro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		radioButtonCachorro.setBounds(39, 156, 109, 23);
		radioButtonCachorro.addActionListener(this);
		painel.add(radioButtonCachorro);
		grupo.add(radioButtonCachorro);
		
		this.radioButtonGato = new JRadioButton("Gato");
		radioButtonGato.setBackground(new Color(255, 228, 181) );
		radioButtonGato.setFont(new Font("Tahoma", Font.PLAIN, 13));
		radioButtonGato.setBounds(187, 156, 109, 23);
		radioButtonGato.addActionListener(this);
		painel.add(radioButtonGato);
		grupo.add(radioButtonGato);
		
		this.radioButtonReptil = new JRadioButton("Reptil");
		radioButtonReptil.setBackground(new Color(255, 228, 181) );
		radioButtonReptil.setFont(new Font("Tahoma", Font.PLAIN, 13));
		radioButtonReptil.setBounds(483, 156, 109, 23);
		radioButtonReptil.addActionListener(this);
		painel.add(radioButtonReptil);
		grupo.add(radioButtonReptil);
		
		this.radioButtonRoedor = new JRadioButton("Roedor");
		radioButtonRoedor.setBackground(new Color(255, 228, 181) );
		radioButtonRoedor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		radioButtonRoedor.setBounds(631, 156, 109, 23);
		radioButtonRoedor.addActionListener(this);
		painel.add(radioButtonRoedor);
		grupo.add(radioButtonRoedor);
		
		this.radioButtonAve = new JRadioButton("Ave");
		radioButtonAve.setBackground(new Color(255, 228, 181) );
		radioButtonAve.setFont(new Font("Tahoma", Font.PLAIN, 13));
		radioButtonAve.setBounds(335, 156, 109, 23);
		radioButtonAve.addActionListener(this);
		painel.add(radioButtonAve);
		grupo.add(radioButtonAve);
		
		this.botaoBusca = new JButton("Buscar");
		botaoBusca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botaoBusca.setBounds(573, 324, 167, 60);
		botaoBusca.setEnabled(false);
		botaoBusca.addActionListener(this);
		painel.add(botaoBusca);
		
		this.botaoVoltar = new JButton("Voltar");
		botaoVoltar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botaoVoltar.setBounds(42, 479, 124, 52);
		botaoVoltar.addActionListener(this);
		painel.add(botaoVoltar);
		
		this.botaoBuscarTodos = new JButton("Buscar Todos");
		botaoBuscarTodos.addActionListener(this);			
		botaoBuscarTodos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botaoBuscarTodos.setEnabled(false);
		botaoBuscarTodos.setBounds(573, 455, 167, 60);
		painel.add(botaoBuscarTodos);
		
		textoBuscarTodos = new JLabel("Buscar todos os animais da esp\u00E9cie selecionada:");
		textoBuscarTodos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textoBuscarTodos.setBounds(455, 435, 285, 14);
		painel.add(textoBuscarTodos);
		
		textoBuscaPorEspcie = new JLabel("Busca por esp\u00E9cie e ra\u00E7a:");
		textoBuscaPorEspcie.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textoBuscaPorEspcie.setBounds(538, 299, 191, 14);
		painel.add(textoBuscaPorEspcie);
		
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
	}
			
			