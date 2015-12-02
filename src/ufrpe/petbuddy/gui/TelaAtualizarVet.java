package ufrpe.petbuddy.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ufrpe.petbuddy.exceptions.DadosException;
import ufrpe.petbuddy.facade.Fachada;
import ufrpe.petbuddy.facade.IFachada;
import ufrpe.petbuddy.negocio.beans.*;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;

import java.awt.Font;

public class TelaAtualizarVet extends JFrame implements ActionListener, ListSelectionListener{

	private JPanel contentPane;
	private DefaultListModel listmodel;
	private JList lista;
	private JScrollPane scrollPane;
	private JTextField campoNome;
	private JTextField campoContato;
	private JTextField campoIdade;
	private JButton botaoVoltar, botaoRemover, botaoAtualizar;
	private IFachada fachada;
	private Usuario usuario;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() {
			//public void run() {
				//try {
					//TelaAtualizarVet frame = new TelaAtualizarVet();
					//frame.setVisible(true);
				//} catch (Exception e) {
				//	e.printStackTrace();
				//}
			//}
		//});
	//}

	/**
	 * Create the frame.
	 */
	public TelaAtualizarVet(IFachada fachada,Usuario u, ArrayList<Veterinario> vet) {
		this.fachada = fachada;
		this.usuario = u;
		setTitle("PetBuddy");
		setIconImage(Toolkit.getDefaultToolkit().getImage("Sprites\\sai.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
	
	listmodel = new DefaultListModel();
	ArrayList<Veterinario> buscados = vet;
	
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
	
	campoNome = new JTextField();
	campoNome.setBounds(509, 88, 243, 20);
	campoNome.setColumns(10);
	campoNome.setEnabled(false);
	contentPane.add(campoNome);
			
	campoContato = new JTextField();
	campoContato.setColumns(10);
	campoContato.setBounds(509, 138, 243, 20);
	campoContato.setEnabled(false);
	contentPane.add(campoContato);
			
	campoIdade = new JTextField();
	campoIdade.setColumns(10);
	campoIdade.setBounds(509, 188, 243, 20);
	campoIdade.setEnabled(false);
	contentPane.add(campoIdade);
	
	JLabel textoNome = new JLabel("Nome");
	textoNome.setBounds(446, 89, 53, 16);
	contentPane.add(textoNome);
	
	JLabel textoContato = new JLabel("Contato");
	textoContato.setBounds(446, 140, 53, 16);
	contentPane.add(textoContato);
	
	JLabel textoIdade = new JLabel("Idade");
	textoIdade.setBounds(446, 191, 53, 16);
	contentPane.add(textoIdade);
	
	JLabel textoVeterinarios = new JLabel("Veterin\u00E1rios");
	textoVeterinarios.setFont(new Font("Tahoma", Font.PLAIN, 15));
	textoVeterinarios.setBounds(27, 29, 164, 35);
	contentPane.add(textoVeterinarios);
	
	BufferedImage buttonIcon;
	try {
		buttonIcon = ImageIO.read(new File("Sprites\\atualizar.gif"));
		this.botaoAtualizar = new JButton(new ImageIcon(buttonIcon));
		this.botaoAtualizar.setBounds(304, 404, 247, 46);
		this.botaoAtualizar.setBorder(BorderFactory.createEmptyBorder());
		this.botaoAtualizar.setContentAreaFilled(false);
		botaoAtualizar.addActionListener(this);
		contentPane.add(botaoAtualizar);
		
		BufferedImage buttonIcon2 = ImageIO.read(new File("Sprites\\voltar.gif"));
		this.botaoVoltar = new JButton(new ImageIcon(buttonIcon2));
		this.botaoVoltar.setBounds(70, 428, 167, 46);
		this.botaoVoltar.setBorder(BorderFactory.createEmptyBorder());
		this.botaoVoltar.setContentAreaFilled(false);
		botaoVoltar.addActionListener(this);
		contentPane.add(botaoVoltar);
		
		BufferedImage buttonIcon3 = ImageIO.read(new File("Sprites\\remover.gif"));
		this.botaoRemover = new JButton(new ImageIcon(buttonIcon3));
		this.botaoRemover.setBounds(304, 404, 196, 46);
		this.botaoRemover.setBorder(BorderFactory.createEmptyBorder());
		this.botaoRemover.setContentAreaFilled(false);
		botaoRemover.addActionListener(this);
		contentPane.add(botaoRemover);
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}

public void valueChanged(ListSelectionEvent evento){
	
	campoNome.setEnabled(false);
	campoContato.setEnabled(true);
	campoIdade.setEnabled(true);
	campoNome.setText(((Veterinario)lista.getSelectedValue()).getNome());
	String contato = String.valueOf(((Veterinario)lista.getSelectedValue()).getContato());
	campoContato.setText(contato);
	String idade = String.valueOf(((Veterinario)lista.getSelectedValue()).getIdade());
	campoIdade.setText(idade);
	
}

public void actionPerformed(ActionEvent evento){
	if(evento.getSource().equals(botaoAtualizar)){
		try{
			Veterinario v = (Veterinario)lista.getSelectedValue();
			String nome = campoNome.getText();
			v.setNome(nome);
			int idade = Integer.parseInt(campoIdade.getText());
			v.setIdade(idade);
			fachada.atualizarVeterinario(v);
			JOptionPane.showMessageDialog(null, "Veterinário Atualizado com Sucesso");
			dispose();
			TelaAdm tela = new TelaAdm(fachada,usuario);
			tela.setVisible(true);
			
		}
		catch(DadosException d){
			JOptionPane.showMessageDialog(null, d.getMessage());
		}
		catch(NumberFormatException n){
			JOptionPane.showMessageDialog(null, "Erro de Conversão");
		}
		
	}else if (evento.getSource().equals(botaoVoltar)){
		dispose();
	TelaAdm tela = new TelaAdm(fachada,usuario);
	tela.setVisible(true);
	}
	
	else if(evento.getSource().equals(botaoRemover)){
		Veterinario vet =(Veterinario) lista.getSelectedValue();
		fachada.removerVeterinario(vet);
		JOptionPane.showMessageDialog(null, "Veterinario Removido com Sucesso");
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
	    BufferedImage ibage = ImageIO.read(new File("Sprites\\atualizarvet.jpg"));		
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

