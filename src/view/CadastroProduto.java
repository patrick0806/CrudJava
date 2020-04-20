package view;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import control.MarcaControl;
import control.ProdutoControl;
import model.Marca;
import javax.swing.DefaultComboBoxModel;

public class CadastroProduto extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldEstoque;
	private JTextField textFieldCompra;
	private JTextField textFieldVenda;
	private JTextField textFieldDataC;
	private JTextField textFieldDataV;
	
	
	
	private ProdutoControl controle= new ProdutoControl();
	
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroProduto frame = new CadastroProduto();
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
	public CadastroProduto() {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				comboBoxMarca.removeAllItems();
				
				preencheCombox();
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		setTitle("Cadastro de Produto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblMarca = new JLabel("Marca");
		
		JLabel lblNome = new JLabel("Nome");
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		
		JLabel lblEstoque = new JLabel("Estoque");
		
		textFieldEstoque = new JTextField();
		textFieldEstoque.setColumns(10);
		
		JLabel lblPrecoDeVenda = new JLabel("Preco de venda");
		
		JLabel lblPrecoDeCompra = new JLabel("Preco de Compra");
		
		JLabel lblDataDaCompra = new JLabel("Data da Compra");
		
		JLabel lblDataDaVenda = new JLabel("Data da Venda");
		
		textFieldCompra = new JTextField();
		textFieldCompra.setColumns(10);
		
		textFieldVenda = new JTextField();
		textFieldVenda.setColumns(10);
		
		textFieldDataC = new JTextField();
		textFieldDataC.setColumns(10);
		
		textFieldDataV = new JTextField();
		textFieldDataV.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SimpleDateFormat formateData = new SimpleDateFormat("dd/mm/YYYY");
				int codigo =0;
				String nome=textFieldNome.getText();
				int estoque=Integer.parseInt(textFieldEstoque.getText());
				double precoVenda=Double.parseDouble(textFieldVenda.getText());
				double precoCompra=Double.parseDouble(textFieldCompra.getText());
				String dataCompra=textFieldDataC.getText();
				String dataVenda=textFieldDataV.getText();
				Marca marca= (Marca) comboBoxMarca.getSelectedItem();
				try {
					java.util.Date date = formateData.parse(dataCompra);
				    java.sql.Date dataCompraBanco = new java.sql.Date(date.getTime());
				    
				    java.util.Date dateVenda = formateData.parse(dataVenda);
				    java.sql.Date dataVendaBanco = new java.sql.Date(dateVenda.getTime());
				    
					if(controle.persist(codigo, nome, estoque, precoVenda, precoCompra, dataCompraBanco, dataVendaBanco, marca)){
						JOptionPane.showMessageDialog(rootPane,
								nome+" foi cadastrado");
					}
					else{
						JOptionPane.showMessageDialog(rootPane,
								nome+" já existe");
						
					}
				} catch (HeadlessException | SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
					JOptionPane.showMessageDialog(rootPane,
							"reveja o sql");
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblEstoque)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(textFieldEstoque, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblPrecoDeVenda)
										.addComponent(lblDataDaCompra)
										.addComponent(lblPrecoDeCompra)
										.addComponent(lblDataDaVenda))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(textFieldDataV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldCompra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldDataC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldVenda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addContainerGap(232, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblNome)
							.addPreferredGap(ComponentPlacement.RELATED, 215, Short.MAX_VALUE)
							.addComponent(lblMarca)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBoxMarca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(111))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(67)
					.addComponent(btnCadastrar)
					.addGap(64)
					.addComponent(btnCancelar)
					.addContainerGap(123, Short.MAX_VALUE))
		);
		comboBoxMarca.setModel(new DefaultComboBoxModel(new String[] {"Selecione uma Marca"}));
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(lblMarca)
						.addComponent(comboBoxMarca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEstoque)
						.addComponent(textFieldEstoque, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrecoDeCompra)
						.addComponent(textFieldCompra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrecoDeVenda)
						.addComponent(textFieldVenda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addComponent(lblDataDaCompra)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDataDaVenda)
								.addComponent(textFieldDataV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldDataC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCadastrar)
						.addComponent(btnCancelar))
					.addGap(25))
		);
		contentPane.setLayout(gl_contentPane);
		preencheCombox();
	}
	private void preencheCombox() {
			
			//Trazer da controler um 
			ArrayList<Marca> marcas=null;
			try {
				marcas = new MarcaControl().obtemMarcas();
			for(Marca marca:marcas ) {
				comboBoxMarca.addItem(marca);
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(rootPane, "Não foi possivel buscar as marcas");
			}
	
	        
			
		}
		
		JComboBox<Marca> comboBoxMarca = new JComboBox<Marca>();
}
