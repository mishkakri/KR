package pi.KR;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Класс, в котором создаётся окно для сотрудника.
 */
public class AdminForm extends CalcMain{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -441900793765254338L;
	private int paneCount;
	private static JTextField[] pane= new JTextField[3];
	private static JButton[] btn= new JButton[3];
	private static JLabel[] label= new JLabel[3];
	public static JCheckBox kapital= new JCheckBox();
	
	/**
	 * Метод заполнения графического окна элементам.
	 * Изначально устанавливается его название, размеры, стандартная операция закрытия,
	 * начальное положение на экране и стиль расположения элементов в окне.
	 * На панель добавляются JTextField - поля ввода,
	 * JButton - функциональные кнопки
	 * JLabel - подписи к некоторым элементам
	 * JCheckBox - флаговая кнопка
	 */
	public AdminForm() {
		super();
		setTitle("Депозитный калькулятор (Сотрудник)");
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
		add(btn[0]= new JButton("Расчитать"));
		
		/**
		 * При помощи цикла организовано ограничение ввода символов в поля 
		 * JTextField таким образом, что в данные поля разрешается вводить только числове значения и десятичный разделитель.
		 * Всвязи с особенностью языка Java, десятичным разделителем является знак '.', но для удобства 
		 * обращения с калькулятором, ввод знака ',' тоже разжрешен, но графически
		 * будет отображаться как знак '.'.
		 */
		for (paneCount=0;paneCount<pane.length;paneCount++) {
			pane[paneCount].addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					if (e.getKeyChar()==',') e.setKeyChar('.');
					char c = e.getKeyChar();
					if ( ((c < '0') || (c > '9')) &&((int)c!= KeyEvent.VK_PERIOD)){
						e.consume();
					}
				}	
			});
		}
		
		/**
		 * Изменение обработчика события для кнопки btn[0] (кнопка "Расчитать").
		 * Устанавливаются ограничения на вводимые значения для JTextField и отображаются ошибки, при вводе значений, превышающих ограничения.
		 * Производится вызов операции по расчёту вклада из интерфейса Calculation
		 * и отображение полученного результата при помощи JOptionPane.
		 */
		btn[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				if ((pane[0].getText().trim().length()==0)||(pane[1].getText().trim().length()==0)||(pane[2].getText().trim().length()==0)) {
					JOptionPane.showMessageDialog(null,"Введите значения в поля", "Ошибка", JOptionPane.ERROR_MESSAGE);
				}
				
				else if ((Integer.valueOf(pane[2].getText())>40)) {
					JOptionPane.showMessageDialog(null,"Максимально возможный срок 40 лет", "Ошибка", JOptionPane.ERROR_MESSAGE);
				}
				else if((Integer.valueOf(pane[1].getText())>30)) {
					JOptionPane.showMessageDialog(null,"Максиально возмождная процентная ставка = 30%", "Ошибка", JOptionPane.ERROR_MESSAGE);
				}
				else {
					double deposit=Double.valueOf(pane[0].getText());
					double percentage=Double.valueOf(pane[1].getText());
					int term=Integer.valueOf(pane[2].getText());
					JPanel myPanel = new JPanel();
					Object[] options = {"Ввести новые значения",
	                "Продолжить"};
					myPanel.setLayout(new GridLayout(2,2));
					myPanel.add(new JLabel("Сумма на конец вклада:"));
					myPanel.add(new JLabel(""));
					if (kapital.isSelected()) myPanel.add(new JLabel(Calculation.kapitalOn(deposit, percentage, term)+" руб."));
					else myPanel.add(new JLabel(Calculation.kapitalOff(deposit, percentage, term)+" руб."));
					myPanel.add(new JLabel("Прибыль:"));
					myPanel.add(new JLabel(""));
					if (kapital.isSelected())myPanel.add(new JLabel(Calculation.kapitalOnSum(deposit, percentage, term)+" руб.")); 
					else myPanel.add(new JLabel(Calculation.kapitalOffSum(deposit, percentage, term)+" руб."));
					int n = JOptionPane.showOptionDialog(null,myPanel, "Результат", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,null, options,options[0]);
					if (n==0) {
						pane[0].setText("");
						pane[1].setText("");
						pane[2].setText("");
					}
				}
				} catch(NumberFormatException f) { 
					JOptionPane.showMessageDialog(null, "Введены недопустимые значения\\nПожалуйста повторите попытку" ,"Ошибка",JOptionPane.ERROR_MESSAGE);
					for (paneCount=0;paneCount<pane.length;paneCount++) {
						pane[paneCount].setText("");
					}
				}
			}
		});
		
		/**
		 * Добавление на окно UserForm кнопки btn[1],
		 * осуществляещей выввод поторобной информации о вкладе в табличный документ.
		 * Вывод осуществляется посредством вызова метода из интерфейса Caclulation.
		 */
		add(btn[1]= new JButton("Отчёт"));
		btn[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((pane[0].getText().trim().length()==0)||(pane[1].getText().trim().length()==0)||(pane[2].getText().trim().length()==0)) {
					JOptionPane.showMessageDialog(null,"Введены неверные значения", "Ошибка", JOptionPane.ERROR_MESSAGE);
				}
				else if ((Integer.valueOf(pane[2].getText())>40)) {
					JOptionPane.showMessageDialog(null,"Максимально возможный срок 40 лет", "Ошибка", JOptionPane.ERROR_MESSAGE);
				}
				else if((Integer.valueOf(pane[1].getText())>30)) {
					JOptionPane.showMessageDialog(null,"Максиально возмождная процентная ставка = 30%", "Ошибка", JOptionPane.ERROR_MESSAGE);
				}
				else {
				double deposit=Double.valueOf(pane[0].getText());
				double percentage=Double.valueOf(pane[1].getText());
				int term=Integer.valueOf(pane[2].getText());
				Calculation.resulCSV(deposit,percentage,term);
				}
			}
		});
		
		/**
		 * Добавление на окно UserForm кнопки btn[2],
		 * осуществляещей переход на окно выбора пользователя UserChoose.
		 */
		add(btn[2] = new JButton("Сменить пользователя"));
		btn[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 UserChoose window = new UserChoose();
				 dispose();
			     window.setVisible(true);
			}
		});
	}
}