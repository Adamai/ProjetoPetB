package ufrpe.petbuddy.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ufrpe.petbuddy.facade.*;
import ufrpe.petbuddy.negocio.beans.*;
import ufrpe.petbuddy.exceptions.*;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.util.Scanner;

import static java.nio.file.StandardCopyOption.*;

import javax.swing.ImageIcon;

public class TelaCadastroAnimal extends JFrame implements ActionListener{

	private Usuario usuario;
	private File image = new File("Fotos\\nophoto.png");
	private JPanel painel;
	private JTextField campoNome;
	private JTextField campoRaca;
	private JTextField campoPeso;
	private JTextField campoIdade;
	private JTextField campoVeterinario;
	private JButton botaoVoltar;
	private JButton botaoCadastrar;
	private JButton btnEnviarFoto;
	private JEditorPane editorSaude;
	private IFachada fachada;
	private ButtonGroup grupo1, grupo2, grupo3;
	private JRadioButton radioButtonCalmo,radioButtonAgitado, radioButtonMacho, radioButtonFemea, radioButtonCachorro, radioButtonGato,
	radioButtonAve,radioButtonRoedor,radioButtonReptil;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	//	EventQueue.invokeLater(new Runnable() {
	//		public void run() {
	//			try {
	//			TelaCadastroAnimal frame = new TelaCadastroAnimal(Fachada.getInstance());
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
	public TelaCadastroAnimal(IFachada fachada,Usuario usuario) {
		this.usuario = usuario;
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
		
		this.grupo1 = new ButtonGroup();
		this.grupo2 = new ButtonGroup();
		this.grupo3 = new ButtonGroup();
		
		
		JLabel textoCadastrarAnimal = new JLabel("Cadastrar Animal");
		textoCadastrarAnimal.setForeground(new Color(139, 69, 19));
		textoCadastrarAnimal.setFont(new Font("Segoe Script", Font.PLAIN, 20));
		textoCadastrarAnimal.setBounds(326, 11, 200, 50);
		painel.add(textoCadastrarAnimal);
		
		JLabel textoNome = new JLabel("Nome");
		textoNome.setFont(new Font("Segoe Script", Font.BOLD, 11));
		textoNome.setBounds(10, 266, 37, 50);
		painel.add(textoNome);
		
		JLabel textoRaca = new JLabel("Ra\u00E7a");
		textoRaca.setFont(new Font("Segoe Script", Font.BOLD, 11));
		textoRaca.setBounds(10, 328, 37, 50);
		painel.add(textoRaca);
		
		JLabel textoPeso = new JLabel("Peso");
		textoPeso.setFont(new Font("Segoe Script", Font.BOLD, 11));
		textoPeso.setBounds(10, 389, 37, 37);
		painel.add(textoPeso);
		
		JLabel textoIdade = new JLabel("Idade");
		textoIdade.setFont(new Font("Segoe Script", Font.BOLD, 11));
		textoIdade.setBounds(10, 437, 37, 50);
		painel.add(textoIdade);
		
		JLabel textoSade = new JLabel("Sa\u00FAde");
		textoSade.setFont(new Font("Segoe Script", Font.BOLD, 11));
		textoSade.setBounds(355, 363, 48, 50);
		painel.add(textoSade);
		
		JLabel textoTemperamento = new JLabel("Temperamento");
		textoTemperamento.setFont(new Font("Segoe Script", Font.BOLD, 11));
		textoTemperamento.setBounds(355, 133, 87, 50);
		painel.add(textoTemperamento);
		
		this.radioButtonCalmo = new JRadioButton("Calmo");
		radioButtonCalmo.setFont(new Font("Segoe Script", Font.BOLD, 11));
		radioButtonCalmo.setContentAreaFilled(false);
		radioButtonCalmo.setBounds(546, 147, 109, 23);
		radioButtonCalmo.addActionListener(this);
		painel.add(radioButtonCalmo);
		grupo1.add(radioButtonCalmo);
		
		this.radioButtonAgitado = new JRadioButton("Agitado");
		radioButtonAgitado.setFont(new Font("Segoe Script", Font.BOLD, 11));
		radioButtonAgitado.setContentAreaFilled(false);
		radioButtonAgitado.setBounds(448, 147, 95, 23);
		radioButtonAgitado.addActionListener(this);
		painel.add(radioButtonAgitado);
		grupo1.add(radioButtonAgitado);
		
		JLabel textoSexo = new JLabel("Sexo");
		textoSexo.setFont(new Font("Segoe Script", Font.BOLD, 11));
		textoSexo.setBounds(355, 72, 57, 50);
		painel.add(textoSexo);
		
		this.radioButtonMacho = new JRadioButton("Macho");
		radioButtonMacho.setFont(new Font("Segoe Script", Font.BOLD, 11));
		radioButtonMacho.setContentAreaFilled(false);
		radioButtonMacho.setBounds(459, 86, 67, 23);
		radioButtonMacho.addActionListener(this);
		painel.add(radioButtonMacho);
		grupo2.add(radioButtonMacho);
		
		this.radioButtonFemea = new JRadioButton("F\u00EAmea");
		radioButtonFemea.setFont(new Font("Segoe Script", Font.BOLD, 11));
		radioButtonFemea.setContentAreaFilled(false);
		radioButtonFemea.setBounds(546, 86, 72, 23);
		radioButtonFemea.addActionListener(this);
		painel.add(radioButtonFemea);
		grupo2.add(radioButtonFemea);
		
		JLabel textoVeterinrio = new JLabel("ID Vet");
		textoVeterinrio.setFont(new Font("Segoe Script", Font.BOLD, 11));
		textoVeterinrio.setBounds(10, 498, 67, 50);
		painel.add(textoVeterinrio);
		
		JLabel textoEspecie = new JLabel("Esp\u00E9cie");
		textoEspecie.setFont(new Font("Segoe Script", Font.BOLD, 11));
		textoEspecie.setBounds(354, 199, 133, 29);
		painel.add(textoEspecie);
		
		this.radioButtonCachorro = new JRadioButton("Cachorro");
		radioButtonCachorro.setFont(new Font("Segoe Script", Font.BOLD, 11));
		radioButtonCachorro.setContentAreaFilled(false);
		radioButtonCachorro.setBounds(378, 235, 109, 23);
		radioButtonCachorro.addActionListener(this);
		painel.add(radioButtonCachorro);
		grupo3.add(radioButtonCachorro);
		
		this.radioButtonGato = new JRadioButton("Gato");
		radioButtonGato.setFont(new Font("Segoe Script", Font.BOLD, 11));
		radioButtonGato.setContentAreaFilled(false);
		radioButtonGato.setBounds(378, 280, 109, 23);
		radioButtonGato.addActionListener(this);
		painel.add(radioButtonGato);
		grupo3.add(radioButtonGato);
		
		this.radioButtonAve = new JRadioButton("Ave");
		radioButtonAve.setFont(new Font("Segoe Script", Font.BOLD, 11));
		radioButtonAve.setContentAreaFilled(false);
		radioButtonAve.setBounds(378, 321, 109, 23);
		radioButtonAve.addActionListener(this);
		painel.add(radioButtonAve);
		grupo3.add(radioButtonAve);
		
		this.radioButtonRoedor = new JRadioButton("Roedor");
		radioButtonRoedor.setFont(new Font("Segoe Script", Font.BOLD, 11));
		radioButtonRoedor.setContentAreaFilled(false);
		radioButtonRoedor.setBounds(528, 280, 72, 23);
		radioButtonRoedor.addActionListener(this);
		painel.add(radioButtonRoedor);
		grupo3.add(radioButtonRoedor);
		
		this.radioButtonReptil = new JRadioButton("R\u00E9ptil");
		radioButtonReptil.setFont(new Font("Segoe Script", Font.BOLD, 11));
		radioButtonReptil.setContentAreaFilled(false);
		radioButtonReptil.setBounds(528, 235, 72, 23);
		radioButtonReptil.addActionListener(this);
		painel.add(radioButtonReptil);
		grupo3.add(radioButtonReptil);
		
		
		campoNome = new JTextField();
		campoNome.setBounds(57, 279, 207, 28);
		painel.add(campoNome);
		campoNome.setColumns(10);
		
		campoRaca = new JTextField();
		campoRaca.setBounds(57, 339, 207, 28);
		painel.add(campoRaca);
		campoRaca.setColumns(10);
		
		campoPeso = new JTextField();
		campoPeso.setText("");
		campoPeso.setBounds(57, 393, 207, 28);
		painel.add(campoPeso);
		campoPeso.setColumns(10);
		
		campoIdade = new JTextField();
		campoIdade.setBounds(57, 448, 207, 28);
		painel.add(campoIdade);
		campoIdade.setColumns(10);
		
		campoVeterinario = new JTextField();
		campoVeterinario.setBounds(87, 509, 177, 29);
		painel.add(campoVeterinario);
		campoVeterinario.setColumns(10);
		
		this.editorSaude = new JEditorPane();
		editorSaude.setBounds(401, 375, 207, 67);
		painel.add(editorSaude);
		
		try {
			BufferedImage buttonIcon = ImageIO.read(new File("Sprites\\Cadastrar.gif"));
			this.botaoCadastrar = new JButton(new ImageIcon(buttonIcon));
			this.botaoCadastrar.setBounds(529, 492, 255, 46);
			this.botaoCadastrar.setBorder(BorderFactory.createEmptyBorder());
			this.botaoCadastrar.setContentAreaFilled(false);
			botaoCadastrar.addActionListener(this);
			painel.add(botaoCadastrar);
			
			BufferedImage buttonIcon2 = ImageIO.read(new File("Sprites\\voltar.gif"));
			this.botaoVoltar = new JButton(new ImageIcon(buttonIcon2));
			this.botaoVoltar.setBounds(320, 492, 167, 46);
			this.botaoVoltar.setBorder(BorderFactory.createEmptyBorder());
			this.botaoVoltar.setContentAreaFilled(false);
			botaoVoltar.addActionListener(this);
			painel.add(botaoVoltar);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.btnEnviarFoto = new JButton("Enviar Foto");
		btnEnviarFoto.setBounds(147, 232, 117, 23);
		btnEnviarFoto.addActionListener(this);
		painel.add(btnEnviarFoto);
		setImage(new File("Fotos\\nophoto.png"));
		label = new JLabel("");
		label.setIcon(new ImageIcon(image.getPath()));
		label.setBounds(31, 47, 207, 174);
		painel.add(label);
		
		BackgroundImageJFrame();
		
	}
	
	public void actionPerformed(ActionEvent evento){
		
		String sexo = "";
		String temperamento = "";
		AnimalEspecie especie = null;
		
		if(evento.getSource().equals(botaoCadastrar)){
			try{
				String nome = campoNome.getText();
				String raca = campoRaca.getText();
				double peso = (Double.parseDouble(campoPeso.getText()));
				int idade = (Integer.parseInt(campoIdade.getText()));
				long vet = Long.parseLong(campoVeterinario.getText());
				String saude = editorSaude.getText();
				
				if(radioButtonFemea.isSelected()){
					sexo = "Femea";
				}
				if(radioButtonMacho.isSelected()){
					sexo = "Macho";
				}
				if(radioButtonAgitado.isSelected()){
					temperamento = "Agitado";
				}
				if(radioButtonCalmo.isSelected()){
					temperamento = "Calmo";
				}
				if(radioButtonCachorro.isSelected()){
					especie = AnimalEspecie.CACHORRO;
				}
				if(radioButtonGato.isSelected()){
					especie = AnimalEspecie.GATO;
				}
				if(radioButtonAve.isSelected()){
					especie = AnimalEspecie.AVE;
				}
				if(radioButtonReptil.isSelected()){
					especie = AnimalEspecie.REPTIL;
				}
				if(radioButtonRoedor.isSelected()){
					especie = AnimalEspecie.ROEDOR;
				}

				
				Veterinario v = fachada.buscaVetID(vet);
				Animal a = new Animal(nome,raca,sexo,peso,idade,saude,temperamento,v, especie, image);
				fachada.cadastrarAnimal(a);
				JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso");
				dispose();
				TelaAdm tela = new TelaAdm(fachada,usuario);
				tela.setVisible(true);
			}	
			
			catch(NumberFormatException n){
				JOptionPane.showMessageDialog(null, "Dados Inválidos");
			}
			catch(IDException i){
				JOptionPane.showMessageDialog(null, i.getMessage());
			}
			catch(DadosException d){
				JOptionPane.showMessageDialog(null, d.getMessage());
			}
		}
		else if(evento.getSource().equals(botaoVoltar)){
			dispose();
			TelaAdm tela = new TelaAdm(fachada,usuario);
			tela.setVisible(true);
		}
		
		if(evento.getSource().equals(btnEnviarFoto)){
			final JFileChooser fc = new JFileChooser();
			fc.showOpenDialog(this);
			setImage(new File(fc.getSelectedFile().getAbsolutePath()));
			
			try {
			    BufferedImage ibage = ImageIO.read(image);
			    BufferedImage img = new BufferedImage(207,174,BufferedImage.TYPE_INT_RGB);
			    img.getGraphics().drawImage(ibage,0,0,207,174,null);
			    label.setIcon(new ImageIcon(img));
				JOptionPane.showMessageDialog(null, image.getAbsolutePath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

				
		}
		
	}
	private void setImage(File x){
		this.image = x;
	}
	public void BackgroundImageJFrame(){ //usar para mudar background, colocar no final da criação
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setVisible(true);
	    getContentPane().setLayout(new BorderLayout());
	    try {
		    BufferedImage ibage = ImageIO.read(new File("Sprites\\tcadastro animal.jpg"));		
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
