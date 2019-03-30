package pi.KR;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
		add(label[1] = new JLabel("Процентная ставка"));
		add(pane[2]= new JTextField());
		add(label[2] = new JLabel("Срок (год)"));
		add(kapital = new JCheckBox("Начисление капитализации"));
		add(btn1= new JButton("Расчитать"));
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
					JOptionPane.showMessageDialog(null,"Введены неверные значения", "Ошибка", JOptionPane.ERROR_MESSAGE);
				}
				else if ((Integer.valueOf(pane[2].getText())>90)) {
					JOptionPane.showMessageDialog(null,"Слишком долгий срок, врдя ли вы проживете столько", "Ошибка", JOptionPane.ERROR_MESSAGE);
				}
				else {
				double a=Double.valueOf(pane[0].getText());
				double b=Double.valueOf(pane[1].getText());
				int c=Integer.valueOf(pane[2].getText());
				JPanel myPanel = new JPanel();
				Object[] options = {"Ввести новые значения",
                "Продолжить"};
				myPanel.setLayout(new GridLayout(2,2));
				myPanel.add(new JLabel("Сумма на конец вклада:"));
				myPanel.add(new JLabel(""));
					if (kapital.isSelected()) myPanel.add(new JLabel(Calculation.kapitalOn(a, b, c)+" руб."));
					else myPanel.add(new JLabel(Calculation.kapitalOff(a, b, c)+" руб."));
				myPanel.add(new JLabel("Прибыль:"));
				myPanel.add(new JLabel(""));
					if (kapital.isSelected())myPanel.add(new JLabel(Calculation.kapitalOnSum(a, b, c)+" руб.")); 
					else myPanel.add(new JLabel(Calculation.kapitalOffSum(a, b, c)+" руб."));
					int n = JOptionPane.showOptionDialog(null,myPanel, "Результат", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,null, options,options[0]);
					if (n==0) {pane[0].setText("");
					pane[1].setText("");
					pane[2].setText("");}
				}
			}
		});
		add(btn2= new JButton("Отчёт"));
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((pane[0].getText().trim().length()==0)||(pane[1].getText().trim().length()==0)||(pane[2].getText().trim().length()==0)) {
					JOptionPane.showMessageDialog(null,"Введены неверные значения", "Ошибка", JOptionPane.ERROR_MESSAGE);
				}
				else if ((Integer.valueOf(pane[2].getText())>90)) {
					JOptionPane.showMessageDialog(null,"Слишком долгий срок, врдя ли вы проживете столько", "Ошибка", JOptionPane.ERROR_MESSAGE);
				}
				else {
				double a=Double.valueOf(pane[0].getText());
				double b=Double.valueOf(pane[1].getText());
				int c=Integer.valueOf(pane[2].getText());
				Calculation.resulCSV(a,b,c);
				}
			}
		});
		add(btn3 = new JButton("Закрыть"));
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
	}
}


