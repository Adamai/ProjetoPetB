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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ufrpe.petbuddy.facade.Fachada;
import ufrpe.petbuddy.facade.IFachada;
import ufrpe.petbuddy.negocio.beans.Pessoa;
import ufrpe.petbuddy.negocio.beans.Usuario;
import java.awt.Font;

public class TelaListaUsuarios extends JFrame implements ActionListener{

	private JPanel painel;
	private Usuario usuario;
	private JTable table;
	private IFachada fachada = Fachada.getInstance();
	private JButton botaoVoltar;
	private ArrayList<Usuario>users;
	private JLabel lblNewLabel;


	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	//	EventQueue.invokeLater(new Runnable() {
	//		public void run() {
	//			try {
	//				TelaListaUsuarios frame = new TelaListaUsuarios();
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
	public TelaListaUsuarios(Usuario u,ArrayList<Usuario>usuarios) {
		setTitle("PetBuddy");
		this.users = usuarios;
		this.usuario = u;
		setIconImage(Toolkit.getDefaultToolkit().getImage("Sprites\\sai.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		painel.setLayout(null);
		setContentPane(painel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 94, 687, 357);
		painel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		DefaultTableModel modelo = new DefaultTableModel();
		table.setModel(modelo);
		
		BufferedImage buttonIcon2;
		try {
			buttonIcon2 = ImageIO.read(new File("Sprites\\voltar.gif"));
			this.botaoVoltar = new JButton(new ImageIcon(buttonIcon2));
			this.botaoVoltar.setBounds(53, 501, 167, 46);
			this.botaoVoltar.setBorder(BorderFactory.createEmptyBorder());
			this.botaoVoltar.setContentAreaFilled(false);
			botaoVoltar.addActionListener(this);
			painel.add(botaoVoltar);
			
			lblNewLabel = new JLabel("Hist\u00F3rico de Usu\u00E1rios");
			lblNewLabel.setForeground(new Color(139, 69, 19));
			lblNewLabel.setFont(new Font("Segoe Script", Font.PLAIN, 19));
			lblNewLabel.setBounds(44, 37, 230, 26);
			painel.add(lblNewLabel);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		modelo.addColumn("Nome");
		modelo.addColumn("Idade");
		modelo.addColumn("Email");
		modelo.addColumn("Contato");
		modelo.addColumn("Endereço");
		
		table.getColumnModel().getColumn(0).setPreferredWidth(115);
		table.getColumnModel().getColumn(1).setPreferredWidth(115);
		table.getColumnModel().getColumn(2).setPreferredWidth(115);
		table.getColumnModel().getColumn(3).setPreferredWidth(115);
		table.getColumnModel().getColumn(4).setPreferredWidth(115);
	
		
		for(int i =0;i<users.size();i++){
			if(users.get(i) instanceof Pessoa){
				Pessoa p = (Pessoa)users.get(i);
				String campo1 = p.getNome();
				int campo2 = p.getIdade();
				String campo3 = p.getEmail();
				long campo4 = p.getContato();
				String campo5 = p.getEndereco();
				modelo.addRow(new Object[]{campo1,campo2,campo3,campo4,campo5});
				}
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
		    BufferedImage ibage = ImageIO.read(new File("Sprites\\tlista usuario.jpg"));		
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
