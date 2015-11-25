package ufrpe.petbuddy.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.ButtonGroup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ufrpe.petbuddy.facade.*;
import ufrpe.petbuddy.negocio.beans.*;
import ufrpe.petbuddy.exceptions.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class TelaCadastroAnimal extends JFrame implements ActionListener,  ItemListener{

	private JPanel painel;
	private String sexo;
	private String temperamento;
	private AnimalEspecie especie;
	private JTextField campoNome;
	private JTextField campoRaca;
	private JTextField campoPeso;
	private JTextField campoIdade;
	private JTextField campoVeterinario;
	private JButton botaoVoltar;
	private JButton botaoCadastrar;
	private JEditorPane editorSaude;
	private IFachada fachada;
	private ButtonGroup grupo1, grupo2, grupo3;
	private JRadioButton radioButtonCalmo,radioButtonAgitado, radioButtonMacho, radioButtonFemea, radioButtonCachorro, radioButtonGato,
	radioButtonAve,radioButtonRoedor,radioButtonReptil;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				TelaCadastroAnimal frame = new TelaCadastroAnimal(Fachada.getInstance());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastroAnimal(IFachada fachada) {
		this.fachada = fachada;
		setTitle("PetBuddy");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		painel.setLayout(null);
		setContentPane(painel);
		
		this.grupo1 = new ButtonGroup();
		this.grupo2 = new ButtonGroup();
		this.grupo3 = new ButtonGroup();
		
		
		JLabel textoCadastrarAnimal = new JLabel("Cadastrar Animal");
		textoCadastrarAnimal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textoCadastrarAnimal.setBounds(292, 11, 200, 50);
		painel.add(textoCadastrarAnimal);
		
		JLabel textoNome = new JLabel("Nome");
		textoNome.setBounds(10, 51, 200, 50);
		painel.add(textoNome);
		
		JLabel textoRaca = new JLabel("Ra\u00E7a");
		textoRaca.setBounds(10, 141, 200, 50);
		painel.add(textoRaca);
		
		JLabel textoPeso = new JLabel("Peso");
		textoPeso.setBounds(10, 234, 200, 50);
		painel.add(textoPeso);
		
		JLabel textoIdade = new JLabel("Idade");
		textoIdade.setBounds(10, 314, 200, 50);
		painel.add(textoIdade);
		
		JLabel textoSade = new JLabel("Sa\u00FAde");
		textoSade.setBounds(10, 408, 200, 50);
		painel.add(textoSade);
		
		JLabel textoTemperamento = new JLabel("Temperamento");
		textoTemperamento.setBounds(444, 197, 87, 50);
		painel.add(textoTemperamento);
		
		this.radioButtonCalmo = new JRadioButton("Calmo");
		radioButtonCalmo.setBounds(633, 211, 109, 23);
		radioButtonCalmo.addItemListener(this);;
		painel.add(radioButtonCalmo);
		grupo1.add(radioButtonCalmo);
		
		this.radioButtonAgitado = new JRadioButton("Agitado");
		radioButtonAgitado.setBounds(535, 211, 95, 23);
		radioButtonAgitado.addItemListener(this);
		painel.add(radioButtonAgitado);
		grupo1.add(radioButtonAgitado);
		
		JLabel textoSexo = new JLabel("Sexo");
		textoSexo.setBounds(448, 72, 57, 50);
		painel.add(textoSexo);
		
		this.radioButtonMacho = new JRadioButton("Macho");
		radioButtonMacho.setBounds(504, 86, 109, 23);
		radioButtonMacho.addItemListener(this);
		painel.add(radioButtonMacho);
		grupo2.add(radioButtonMacho);
		
		this.radioButtonFemea = new JRadioButton("F\u00EAmea");
		radioButtonFemea.setBounds(615, 86, 109, 23);
		radioButtonFemea.addItemListener(this);
		painel.add(radioButtonFemea);
		grupo2.add(radioButtonFemea);
		
		JLabel textoVeterinrio = new JLabel("Veterin\u00E1rio");
		textoVeterinrio.setBounds(444, 133, 67, 50);
		painel.add(textoVeterinrio);
		
		JLabel textoEspecie = new JLabel("Esp\u00E9cie");
		textoEspecie.setBounds(444, 258, 133, 29);
		painel.add(textoEspecie);
		
		this.radioButtonCachorro = new JRadioButton("Cachorro");
		radioButtonCachorro.setBounds(468, 294, 109, 23);
		radioButtonCachorro.addItemListener(this);
		painel.add(radioButtonCachorro);
		grupo3.add(radioButtonCachorro);
		
		this.radioButtonGato = new JRadioButton("Gato");
		radioButtonGato.setBounds(468, 339, 109, 23);
		radioButtonGato.addItemListener(this);
		painel.add(radioButtonGato);
		grupo3.add(radioButtonGato);
		
		this.radioButtonAve = new JRadioButton("Ave");
		radioButtonAve.setBounds(468, 380, 109, 23);
		radioButtonAve.addItemListener(this);
		painel.add(radioButtonAve);
		grupo3.add(radioButtonAve);
		
		this.radioButtonRoedor = new JRadioButton("Roedor");
		radioButtonRoedor.setBounds(633, 339, 109, 23);
		radioButtonRoedor.addItemListener(this);
		painel.add(radioButtonRoedor);
		grupo3.add(radioButtonRoedor);
		
		this.radioButtonReptil = new JRadioButton("R\u00E9ptil");
		radioButtonReptil.setBounds(633, 294, 109, 23);
		radioButtonReptil.addItemListener(this);
		painel.add(radioButtonReptil);
		grupo3.add(radioButtonReptil);
		
		
		campoNome = new JTextField();
		campoNome.setBounds(31, 92, 207, 28);
		painel.add(campoNome);
		campoNome.setColumns(10);
		
		campoRaca = new JTextField();
		campoRaca.setBounds(31, 174, 207, 28);
		painel.add(campoRaca);
		campoRaca.setColumns(10);
		
		campoPeso = new JTextField();
		campoPeso.setText("");
		campoPeso.setBounds(31, 267, 207, 28);
		painel.add(campoPeso);
		campoPeso.setColumns(10);
		
		campoIdade = new JTextField();
		campoIdade.setBounds(31, 353, 207, 28);
		painel.add(campoIdade);
		campoIdade.setColumns(10);
		
		campoVeterinario = new JTextField();
		campoVeterinario.setBounds(515, 144, 200, 29);
		painel.add(campoVeterinario);
		campoVeterinario.setColumns(10);
		
		this.editorSaude = new JEditorPane();
		editorSaude.setBounds(31, 449, 207, 67);
		painel.add(editorSaude);
		
		this.botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botaoCadastrar.setBounds(555, 449, 200, 50);
		botaoCadastrar.addActionListener(this);
		painel.add(botaoCadastrar);
		
		
		this.botaoVoltar = new JButton("Voltar");
		botaoVoltar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botaoVoltar.setBounds(323, 449, 127, 50);
		botaoVoltar.addActionListener(this);
		painel.add(botaoVoltar);	
		
	}
	//TEM Q RESOLVER O LANCE DOS RADIOBUTTONS =\
	
	
	//public void itemStateChanged(ItemEvent evento){
	//	if(evento.getSource().equals(grupo2)){
	//		if(radioButtonFemea.isSelected()){
	//			this.sexo = "F�mea";
	//		}
	//		else if(radioButtonMacho.isSelected()){
	//			this.sexo = "Macho";
	//		}
	//	}
	//	else if(evento.getSource().equals(grupo1)){
	//		if(radioButtonCalmo.isSelected()){
	//			this.temperamento = "Calmo";
	//		}
	//		else if(radioButtonAgitado.isSelected()){
	//			this.temperamento = "Agitado";
	//		}
	//	}
	//	else if(evento.getSource().equals(grupo3)){
	//		if(radioButtonCachorro.isSelected())
	//			this.especie = AnimalEspecie.CACHORRO;
	//		else if(radioButtonGato.isSelected())
	//			this.especie = AnimalEspecie.GATO;
	//		else if (radioButtonAve.isSelected())
	//			this.especie = AnimalEspecie.AVE;
	//		else if (radioButtonRoedor.isSelected())
	//			this.especie = AnimalEspecie.ROEDOR;
	//		else if(radioButtonReptil.isSelected())
	//			this.especie = AnimalEspecie.REPTIL;
	//	}
	//}
	
	public void handlerGrupo1 (ItemEvent evento){
		if(grupo1.getSelection().equals(radioButtonAgitado)){
			this.temperamento = "Agitado";
		}
		else if(grupo1.getSelection().equals(radioButtonCalmo)){
			this.temperamento = "Calmo";
		}
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
				
				//Veterinario v = fachada.buscaVetID(vet);
				
				Animal a = new Animal(nome,raca,sexo,peso,idade,saude,temperamento,null, especie);
				fachada.cadastrarAnimal(a);
				
				JOptionPane.showMessageDialog(null, a.getSexo());
				JOptionPane.showMessageDialog(null, a.getSaude());
				JOptionPane.showMessageDialog(null, a.getEspecie());
				JOptionPane.showMessageDialog(null, a.getSaude());
				JOptionPane.showMessageDialog(null, "cadastro realizado com sucesso");
				dispose();
				TelaAdm tela = new TelaAdm(fachada);
				tela.setVisible(true);
			}	
			
			catch(NumberFormatException n){
				JOptionPane.showMessageDialog(null, "dados inv�lidos");
			}
			//catch(IDException i){
			//	JOptionPane.showMessageDialog(null, i.getMessage());
			//}
		}
		else if(evento.getSource().equals(botaoVoltar)){
			dispose();
			TelaAdm tela = new TelaAdm(fachada);
			tela.setVisible(true);
		}
	}
	

}
