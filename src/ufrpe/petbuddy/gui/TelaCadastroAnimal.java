package ufrpe.petbuddy.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;

public class TelaCadastroAnimal extends JFrame {

	private JPanel painel;
	private JTextField campoNome;
	private JTextField campoRaca;
	private JTextField campoPeso;
	private JTextField campoIdade;
	private JTextField campoVeterinario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroAnimal frame = new TelaCadastroAnimal();
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
	public TelaCadastroAnimal() {
		setTitle("PetBuddy");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		painel.setLayout(null);
		setContentPane(painel);
		
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
		
		JRadioButton radioButtonCalmo = new JRadioButton("Calmo");
		radioButtonCalmo.setBounds(633, 211, 109, 23);
		painel.add(radioButtonCalmo);
		
		JRadioButton radioButtonAgitado = new JRadioButton("Agitado");
		radioButtonAgitado.setBounds(535, 211, 95, 23);
		painel.add(radioButtonAgitado);
		
		JLabel textoSexo = new JLabel("Sexo");
		textoSexo.setBounds(448, 72, 57, 50);
		painel.add(textoSexo);
		
		JRadioButton radioButtonMacho = new JRadioButton("Macho");
		radioButtonMacho.setBounds(504, 86, 109, 23);
		painel.add(radioButtonMacho);
		
		JRadioButton radioButtonFemea = new JRadioButton("F\u00EAmea");
		radioButtonFemea.setBounds(615, 86, 109, 23);
		painel.add(radioButtonFemea);
		
		JLabel textoVeterinrio = new JLabel("Veterin\u00E1rio");
		textoVeterinrio.setBounds(444, 133, 67, 50);
		painel.add(textoVeterinrio);
		
		JLabel textoEspecie = new JLabel("Esp\u00E9cie");
		textoEspecie.setBounds(444, 258, 133, 29);
		painel.add(textoEspecie);
		
		JRadioButton radioButtonCachorro = new JRadioButton("Cachorro");
		radioButtonCachorro.setBounds(468, 294, 109, 23);
		painel.add(radioButtonCachorro);
		
		JRadioButton radioButtonGato = new JRadioButton("Gato");
		radioButtonGato.setBounds(468, 339, 109, 23);
		painel.add(radioButtonGato);
		
		JRadioButton radioButtonAve = new JRadioButton("Ave");
		radioButtonAve.setBounds(468, 380, 109, 23);
		painel.add(radioButtonAve);
		
		JRadioButton radioButtonRoedor = new JRadioButton("Roedor");
		radioButtonRoedor.setBounds(633, 339, 109, 23);
		painel.add(radioButtonRoedor);
		
		JRadioButton radioButtonReptil = new JRadioButton("R\u00E9ptil");
		radioButtonReptil.setBounds(633, 294, 109, 23);
		painel.add(radioButtonReptil);
		
		JButton botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botaoCadastrar.setBounds(464, 463, 251, 67);
		painel.add(botaoCadastrar);
		
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
		
		JEditorPane editorSaude = new JEditorPane();
		editorSaude.setBounds(31, 449, 207, 67);
		painel.add(editorSaude);
		
		
		
	}
}
