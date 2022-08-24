import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class TelaInicial extends JFrame {

	private JPanel contentPane;
	private JTextField txtTermoInput;
	private JButton btnOk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
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
	public TelaInicial() {
		setTitle("N\u00FAmeros de Fibonacci");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 189);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTermoInput = new JLabel("Digite o numero de termos:");
		lblTermoInput.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTermoInput.setBounds(72, 42, 175, 28);
		contentPane.add(lblTermoInput);
		
		txtTermoInput = new JTextField();
		txtTermoInput.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtTermoInput.setBounds(264, 48, 86, 20);
		contentPane.add(txtTermoInput);
		txtTermoInput.setColumns(10);
		
		btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TesteFiboBigInt testeFibo = new TesteFiboBigInt();
				int termo = Integer.parseInt(txtTermoInput.getText());				
				BigInteger[] sequencia = testeFibo.mostraSequencia(termo);
				TelaSaidaSequencia telaSaida = new TelaSaidaSequencia(TelaInicial.this, sequencia);
				telaSaida.setVisible(true);
				dispose();
				
			}
		});
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnOk.setBounds(174, 103, 89, 34);
		contentPane.add(btnOk);
		
		setLocationRelativeTo(null);
	}

}
