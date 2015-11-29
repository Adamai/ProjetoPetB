package ufrpe.petbuddy.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
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
import ufrpe.petbuddy.facade.IFachada;
import ufrpe.petbuddy.negocio.beans.Animal;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;

import java.awt.Font;

public class TelaAtualizarAnimais extends JFrame implements ActionListener, ListSelectionListener{

	private JPanel contentPane;
	private DefaultListModel listmodel;
	private JList lista;
	private JScrollPane scrollPane;
	private JTextField campoNome;
	private JTextField campoRaca;
	private JTextField campoIdade;
	private JEditorPane editorSaude;
	private JButton botaoVoltar, botaoRemover, botaoAtualizar;
	private IFachada fachada;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	//	EventQueue.invokeLater(new Runnable() {
	//		public void run() {
	//			try {
	//				TelaAtualizarAnimais frame = new TelaAtualizarAnimais();
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
	
	public TelaAtualizarAnimais(IFachada fachada, ArrayList<Animal> resultado) {
		this.fachada = fachada;
		setTitle("PetBuddy");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
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
		
		campoNome = new JTextField();
		campoNome.setBounds(509, 88, 243, 20);
		contentPane.add(campoNome);
		campoNome.setColumns(10);
		
		campoRaca = new JTextField();
		campoRaca.setColumns(10);
		campoRaca.setBounds(509, 138, 243, 20);
		contentPane.add(campoRaca);
		
		campoIdade = new JTextField();
		campoIdade.setColumns(10);
		campoIdade.setBounds(509, 188, 243, 20);
		contentPane.add(campoIdade);
		
		this.botaoAtualizar = new JButton("Atualizar");
		botaoAtualizar.setBounds(588, 475, 164, 47);
		botaoAtualizar.addActionListener(this);
		contentPane.add(botaoAtualizar);
		
		this.editorSaude = new JEditorPane();
		editorSaude.setBounds(509, 239, 243, 94);
		contentPane.add(editorSaude);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(446, 89, 53, 16);
		contentPane.add(lblNome);
		
		JLabel lblRaa = new JLabel("Ra\u00E7a");
		lblRaa.setBounds(446, 140, 53, 16);
		contentPane.add(lblRaa);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setBounds(446, 191, 53, 16);
		contentPane.add(lblIdade);
		
		JLabel lblSade = new JLabel("Sa\u00FAde");
		lblSade.setBounds(446, 244, 53, 16);
		contentPane.add(lblSade);
		
		JLabel lblAnimais = new JLabel("Animais");
		lblAnimais.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAnimais.setBounds(27, 29, 164, 35);
		contentPane.add(lblAnimais);
		
		this.botaoVoltar = new JButton("Voltar");
		botaoVoltar.setBounds(294, 487, 89, 35);
		botaoVoltar.addActionListener(this);
		contentPane.add(botaoVoltar);
		
		this.botaoRemover = new JButton("Remover");
		botaoRemover.setBounds(414, 475, 164, 47);
		botaoRemover.addActionListener(this);
		contentPane.add(botaoRemover);
		
	}
	
	public void valueChanged(ListSelectionEvent evento){

		campoNome.setText(((Animal)lista.getSelectedValue()).getNome());
		campoRaca.setText(((Animal)lista.getSelectedValue()).getRaca());
		campoRaca.setEditable(false);
		//int numero = ((Animal)lista.getSelectedValue()).getIdade();
		String idade = String.valueOf(((Animal)lista.getSelectedValue()).getIdade());
		campoIdade.setText(idade);
		editorSaude.setText(((Animal)lista.getSelectedValue()).getSaude());
		//campoDados.setText(((Animal)lista.getSelectedValue()).exibirDados());
		//campoDados.setEditable(false);
		//botaoAdotar.setEnabled(true);
	}
	
	
	public void actionPerformed(ActionEvent evento){
		if(evento.getSource().equals(botaoAtualizar)){
			try{
				Animal a = (Animal)lista.getSelectedValue();
				String nome = campoNome.getText();
				a.setNome(nome);
				int idade = Integer.parseInt(campoIdade.getText());
				a.setIdade(idade);
				String saude = editorSaude.getText();
				a.setSaude(saude);
				fachada.atualizar(a);
				JOptionPane.showMessageDialog(null, "Animal atualizado com sucesso");
			}
			catch(DadosException d){
				JOptionPane.showMessageDialog(null, d.getMessage());
			}
			catch(NumberFormatException n){
				JOptionPane.showMessageDialog(null, "erro de conversão");
			}
			
		}
		
	}
}
