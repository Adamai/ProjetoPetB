package ufrpe.petbuddy.gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

import ufrpe.petbuddy.exceptions.DadosException;
import ufrpe.petbuddy.exceptions.IDException;
import ufrpe.petbuddy.exceptions.RepoException;
import ufrpe.petbuddy.facade.*;
import ufrpe.petbuddy.negocio.beans.AnimalEspecie;

import java.util.ArrayList;

import ufrpe.petbuddy.negocio.beans.*;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;

public class TelaResultadoBusca extends JFrame implements ActionListener,ListSelectionListener{

	private JPanel contentPane;
	private JButton botaoAdotar = new JButton("Adotar");
	private JButton botaoVoltar;
	private JList lista;
	private DefaultListModel listmodel;
	private IFachada fachada;
	private Usuario usuario;
	private JScrollPane scrollPane;
	private JEditorPane campoDados;
	private JLabel label;
	private File image = new File("Fotos\\nophoto.png");

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	//	EventQueue.invokeLater(new Runnable() {
	//		public void run() {
	//			try {
	//				TelaResultadoBusca frame = new TelaResultadoBusca();
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
	public TelaResultadoBusca(Usuario u,ArrayList<Animal>resultado) {
		fachada = Fachada.getInstance();
		usuario = u;
		setIconImage(Toolkit.getDefaultToolkit().getImage("Sprites\\sai.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
				
		listmodel = new DefaultListModel();
		ArrayList<Animal> buscados = resultado;
		
		for(int i = 0; i<buscados.size();i++){
			listmodel.addElement(buscados.get(i));
		}
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 89, 224, 413);
		contentPane.add(scrollPane);
				
		lista = new JList(listmodel);
		scrollPane.setViewportView(lista);
		lista.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		lista.addListSelectionListener(this);
		lista.setLayoutOrientation(JList.VERTICAL);
		
		JLabel lblNewLabel = new JLabel("Animais");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(38, 30, 150, 48);
		contentPane.add(lblNewLabel);
		
		if(u instanceof Pessoa){
			BufferedImage buttonIcon;
			try {
				buttonIcon = ImageIO.read(new File("Sprites\\adotar.gif"));
				this.botaoAdotar = new JButton(new ImageIcon(buttonIcon));
				this.botaoAdotar.setBounds(304, 404, 170, 46);
				this.botaoAdotar.setBorder(BorderFactory.createEmptyBorder());
				this.botaoAdotar.setContentAreaFilled(false);
				botaoAdotar.addActionListener(this);
				contentPane.add(botaoAdotar);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		
		BufferedImage buttonIcon2;
		try {
			buttonIcon2 = ImageIO.read(new File("Sprites\\voltar.gif"));
			this.botaoVoltar = new JButton(new ImageIcon(buttonIcon2));
			this.botaoVoltar.setBounds(70, 428, 167, 46);
			this.botaoVoltar.setBorder(BorderFactory.createEmptyBorder());
			this.botaoVoltar.setContentAreaFilled(false);
			botaoVoltar.addActionListener(this);
			contentPane.add(botaoVoltar);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.campoDados = new JEditorPane();
		campoDados.setFont(new Font("Tahoma", Font.PLAIN, 15));
		campoDados.setBounds(489, 89, 275, 232);
		contentPane.add(campoDados);
		
		this.label = new JLabel("");
		this.label.setIcon(new ImageIcon(image.getPath()));
		this.label.setBounds(261, 89, 207, 174);
		contentPane.add(label);
		
		botaoAdotar.setBounds(493, 446, 141, 56);
		botaoAdotar.addActionListener(this);
		botaoAdotar.setEnabled(false);
		contentPane.add(botaoAdotar);
		

		BackgroundImageJFrame();
	}

	//WRYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY
	public void valueChanged(ListSelectionEvent evento){
		image = (((Animal)lista.getSelectedValue()).getImaji());
		try {
		    BufferedImage ibage = ImageIO.read(image);
		    BufferedImage img = new BufferedImage(207,174,BufferedImage.TYPE_INT_RGB);
		    img.getGraphics().drawImage(ibage,0,0,207,174,null);
		    this.label.setIcon(new ImageIcon(img));
		} catch (IOException e) {
			e.printStackTrace();
		}
		campoDados.setText(((Animal)lista.getSelectedValue()).exibirDados());
		campoDados.setEditable(false);
		if(usuario instanceof Pessoa){
		botaoAdotar.setEnabled(true);
		
		}
	}
	
	/*public void theImage(Animal a){
		image = a.getImaji();
		try {
		    BufferedImage ibage = ImageIO.read(image);
		    BufferedImage img = new BufferedImage(207,174,BufferedImage.TYPE_INT_RGB);
		    img.getGraphics().drawImage(ibage,0,0,207,174,null);
		    label.setIcon(new ImageIcon(img));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
	
	public void actionPerformed(ActionEvent evento){
		
	
		if(evento.getSource().equals(botaoAdotar)){
			try{
				Animal a = fachada.buscaAnimalID(((Animal)lista.getSelectedValue()).getNumid());
			Adocao adocao = new Adocao(a,(Pessoa)usuario);
			fachada.cadastrarAdocao(adocao);
			JOptionPane.showMessageDialog(null,"Adoção Realizada com Sucesso, em:"+adocao.getData());
			dispose();
			TelaLogado daniel = new TelaLogado(fachada,usuario);
			daniel.setVisible(true);
		}
			catch(DadosException b){
			JOptionPane.showMessageDialog(null,b.getMessage());
		} catch (IDException i){
			JOptionPane.showMessageDialog(null,i.getMessage());
		}
		
		}else if(evento.getSource().equals(botaoVoltar)){
			if(usuario == null){
				dispose();
				TelaPrincipal tela = new TelaPrincipal(fachada);
				tela.setVisible(true);
			}
			else if(usuario instanceof Pessoa){
				dispose();
				TelaBuscaAnimais tela = new TelaBuscaAnimais(usuario);
				tela.setVisible(true);
			}
			else if(usuario instanceof Adm){
				dispose();
				TelaAdm tela = new TelaAdm(fachada,usuario);
				tela.setVisible(true);
			} 
			
		}// fim IF VOLTAR


			}
	public void BackgroundImageJFrame(){ //usar para mudar background, colocar no final da criação
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setVisible(true);
	    getContentPane().setLayout(new BorderLayout());
	    try {
		    BufferedImage ibage = ImageIO.read(new File("Sprites\\tresultado busca.jpg"));		
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

