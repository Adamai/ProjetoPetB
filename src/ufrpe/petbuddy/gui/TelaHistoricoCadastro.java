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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ufrpe.petbuddy.exceptions.HistException;
import ufrpe.petbuddy.facade.Fachada;
import ufrpe.petbuddy.facade.IFachada;
import ufrpe.petbuddy.negocio.beans.*;

public class TelaHistoricoCadastro extends JFrame implements ActionListener {

	private JPanel painel;
	private Usuario usuario;
	private JTable table;
	private IFachada fachada;
	private JButton botaoVoltar;
	private ArrayList<Animal>animais;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	//	EventQueue.invokeLater(new Runnable() {
	//		public void run() {
	//			try {
	//				TelaHistoricoCadastro frame = new TelaHistoricoCadastro();
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
	public TelaHistoricoCadastro(Usuario u,ArrayList<Animal> animais) {
		setTitle("PetBuddy");
		this.animais = animais;
		fachada = Fachada.getInstance();
		this.usuario = u;
		setIconImage(Toolkit.getDefaultToolkit().getImage("Sprites\\sai.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		painel.setLayout(null);
		setBackground(new Color(255, 228, 181) );
		setContentPane(painel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 97, 687, 357);
		painel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		DefaultTableModel modelo = new DefaultTableModel();
		table.setModel(modelo);
		
		BufferedImage buttonIcon2;
		try {
			buttonIcon2 = ImageIO.read(new File("Sprites\\voltar.gif"));
			this.botaoVoltar = new JButton(new ImageIcon(buttonIcon2));
			this.botaoVoltar.setBounds(59, 498, 167, 46);
			this.botaoVoltar.setBorder(BorderFactory.createEmptyBorder());
			this.botaoVoltar.setContentAreaFilled(false);
			botaoVoltar.addActionListener(this);
			painel.add(botaoVoltar);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		modelo.addColumn("Nome");
		modelo.addColumn("Sexo");
		modelo.addColumn("Idade");
		modelo.addColumn("Peso");
		modelo.addColumn("ID");
		modelo.addColumn("Data de Cadastro");
		
		table.getColumnModel().getColumn(0).setPreferredWidth(115);
		table.getColumnModel().getColumn(1).setPreferredWidth(115);
		table.getColumnModel().getColumn(2).setPreferredWidth(115);
		table.getColumnModel().getColumn(3).setPreferredWidth(115);
		table.getColumnModel().getColumn(4).setPreferredWidth(115);
		table.getColumnModel().getColumn(5).setPreferredWidth(115);
		
		for(int i =0;i<animais.size();i++){
			String campo1 = animais.get(i).getNome();
			String campo2 = animais.get(i).getSexo();
			int campo3 = animais.get(i).getIdade();
			double campo4 = animais.get(i).getPeso();
			long campo5 = animais.get(i).getNumid();
			String campo6 = animais.get(i).getData();
			modelo.addRow(new Object[]{campo1,campo2,campo3,campo4,campo5,campo6});
			}
		BackgroundImageJFrame();
	}
	
	public void actionPerformed(ActionEvent evento){
		if(evento.getSource().equals(botaoVoltar)){
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
		    BufferedImage ibage = ImageIO.read(new File("Sprites\\thistorico animais.jpg"));		
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
