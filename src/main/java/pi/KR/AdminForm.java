package pi.KR;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AdminForm extends CalcForm{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -441900793765254338L;
	static JTextField[] pane= new JTextField[3];
	static JButton btn1= new JButton();
	static JButton btn2= new JButton();
	static JButton btn3 = new JButton();
	static JLabel[] label= new JLabel[3];
	static JCheckBox kapital= new JCheckBox();
	static DecimalFormat df = new DecimalFormat("#.####");
 
	public AdminForm() {
		super();
		setTitle("Admin form");
		setSize(400,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(5,2));
		add(pane[0]= new JTextField());
		add(label[0] = new JLabel("Сумма вклада"));
		add(pane[1]= new JTextField());
		add(label[1] = new JLabel("Процент вклада"));
		add(pane[2]= new JTextField());
		add(label[2] = new JLabel("Срок вклада (Год)"));
		add(kapital = new JCheckBox("Êàïèòàëèçàöèÿ"));
		add(btn1= new JButton("Ðàñ÷èòàòü"));
		for (int i=0;i<pane.length;i++) {
		pane[i].addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
			char c = e.getKeyChar();
			if ( ((c < '0') || (c > '9')) &&((int)c!= KeyEvent.VK_PERIOD)){
			e.consume();
			}
			}
			});
		}
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((pane[0].getText().trim().length()==0)||(pane[1].getText().trim().length()==0)||(pane[2].getText().trim().length()==0)) {
					JOptionPane.showMessageDialog(null,"Ââåäåíû íåâåðíûå çíà÷åíèÿ", "Îøèáêà", JOptionPane.ERROR_MESSAGE);
				}
				else {
				boolean cap = Boolean.valueOf(kapital.isSelected());
				double a=Double.valueOf(pane[0].getText());
				double b=Double.valueOf(pane[1].getText());
				int c=Integer.valueOf(pane[2].getText());
				if (kapital.isSelected()) {
					JOptionPane.showMessageDialog(null,/*void Ðàñ÷¸òà*/1, "Ðåçóëüòàò", JOptionPane.PLAIN_MESSAGE);
				}
				else JOptionPane.showMessageDialog(null,/*void Ðàñ÷¸òà*/1, "Ðåçóëüòàò", JOptionPane.PLAIN_MESSAGE);
				pane[0].setText("");
				pane[1].setText("");
				pane[2].setText("");
				}
			}
		});
		add(btn2= new JButton("ÎÒ÷¸ò"));
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  try (PrintWriter writer = new PrintWriter(new File("K:/Êóðñà÷ ÈÑ/Ðàçäåë 2/test.csv"))) {

				      StringBuilder sb = new StringBuilder();
				      sb.append("Äàòà;Ñóììà; Ïðîöåíò");
				      sb.append('\n');

				      sb.append("31;15;300");
				      sb.append('\n');

				      writer.write(sb.toString());

				    } catch (FileNotFoundException f) {
				      System.out.println(f.getMessage());
				    }

			}
		});
		add(btn3 = new JButton("Çàêðûòü"));
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
	}
}


