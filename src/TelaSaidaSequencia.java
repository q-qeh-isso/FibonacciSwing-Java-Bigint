import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import java.awt.SystemColor;


public class TelaSaidaSequencia extends JFrame {

	private JPanel contentPane;
	private TelaInicial parent;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSaidaSequencia frame = new TelaSaidaSequencia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public TelaSaidaSequencia(TelaInicial telaInicial, BigInteger[] sequencia) {
		this.parent = telaInicial;
		setTitle("N\u00FAmeros de Fibonacci");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.setVisible(true);
				dispose();
			}
		});
		btnFechar.setBounds(177, 237, 89, 23);
		contentPane.add(btnFechar);
		
		

		JLabel lblOs = new JLabel("Os");
		lblOs.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOs.setBounds(10, 11, 18, 23);
		contentPane.add(lblOs);
		
		JLabel lblTermos = new JLabel(String.valueOf(sequencia.length));
		lblTermos.setForeground(SystemColor.textHighlight);
		lblTermos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTermos.setBounds(38, 11, 55, 23);
		contentPane.add(lblTermos);
		
		JLabel lblPrimeirosTermosSo = new JLabel("primeiros termos s\u00E3o:");
		lblPrimeirosTermosSo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrimeirosTermosSo.setBounds(100, 11, 185, 23);
		contentPane.add(lblPrimeirosTermosSo);		
		
		StyleContext sc = new StyleContext();
	    final DefaultStyledDocument doc = new DefaultStyledDocument(sc);
	    JTextPane pane = new JTextPane(doc);
	    pane.setEditable(false);
	    
	    // Create and add the main document style
	    Style defaultStyle = sc.getStyle(StyleContext.DEFAULT_STYLE);
	    final Style mainStyle = sc.addStyle("MainStyle", defaultStyle);
	    StyleConstants.setLeftIndent(mainStyle, 8);
	    StyleConstants.setRightIndent(mainStyle, 8);
	    StyleConstants.setFontFamily(mainStyle, "serif");
	    StyleConstants.setFontSize(mainStyle, 14);
	    StyleConstants.setForeground(mainStyle, Color.black);

	    // Create and add the heading style
	    final Style heading2Style = sc.addStyle("Heading2", null);
	    StyleConstants.setForeground(heading2Style, SystemColor.textHighlight);
	    StyleConstants.setFontSize(heading2Style, 14);
	    StyleConstants.setFontFamily(heading2Style, "serif");
	    StyleConstants.setBold(heading2Style, true);
//	    StyleConstants.setLeftIndent(heading2Style, 8);
	    
	    // Set the logical style
	    doc.setLogicalStyle(0, mainStyle);

	    try {
			for (int i = sequencia.length-1; i >= 0; i--) {
				String t = String.valueOf(i);
				int tLen = t.length();
				doc.insertString(0, "Termo " + (i+1) + ":   " + String.valueOf(sequencia[i])+"\n", null);
				doc.setCharacterAttributes(0, (7+tLen), heading2Style, false);
			}
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}

	    
	    JScrollPane scrollPane = new JScrollPane(pane);
	    scrollPane.setBounds(10, 44, 424, 182);
	    contentPane.add(scrollPane);
		
		
		
		setLocationRelativeTo(null);
	}
}
