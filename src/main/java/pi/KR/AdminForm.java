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
	 * @param paneCount - целочисленная переменная, используемая для циклов, в которых принимают участие текстовые поля
	 * @param pane - массив текстовых полей, которые используются для ввода данных
	 * @param btn - массив функциональных кнопок
	 * @param label - массив текстовых полей
	 * @param kapital - флаговая кнопка
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
	 */
	public AdminForm() {
		super();
		setTitle("Депозитный калькулятор (Сотрудник)");
		setSize(400,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(5,2));
		/**
		 * @param pane[0] - поле ввода суммы вклада
		 * @param label[0] - текстовое поле, поясняющее поле ввода pane[0] 
		 */
		add(pane[0]= new JTextField());
		add(label[0] = new JLabel("Сумма вклада"));
		/**
		 * @param pane[1] - поле ввода процентной ставки вклада
		 * @param label[1] - текстовое поле, поясняющее поле ввода pane[1] 
		 */
		add(pane[1]= new JTextField());
		add(label[1] = new JLabel("Процентная ставка"));
		/**
		 * @param pane[2] - поле ввода срока на который оформляется вклад
		 * @param label[2] - текстовое поле, поясняющее поле ввода pane[2]
		 * @param kapital - флаговая кнопка, которая регулирует функцию капитализации. Выбранное состояние кнопки сигнализирует о том,
		 * что условия капитализации выполняются
		 */
		add(pane[2]= new JTextField());
		add(label[2] = new JLabel("Срок (год)"));
		add(kapital = new JCheckBox("Начисление капитализации"));
		kapital.setToolTipText("Автоматическое присоединение суммы процентов ко вкладу");
		/**
		 * @param btn[0] - кнопка, в результате которой выполняються расчёты, исходя изз данных
		 * введённых в поля pane.
		 * При помощи цикла организовано ограничение ввода символов в поля 
		 * JTextField таким образом, что в данные поля разрешается вводить только числовые значения и десятичный разделитель.
		 * В связи с особенностью языка Java, десятичным разделителем является знак '.', но для удобства 
		 * обращения с калькулятором, ввод знака ',' тоже разрешен, но графически
		 * будет отображаться как знак '.'.
		 */
		add(btn[0]= new JButton("Рассчитать"));
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
		 * Изменение обработчика события для кнопки btn[0] (кнопка "Рассчитать").
		 * Устанавливаются ограничения на вводимые значения для JTextField и отображаются ошибки, при вводе значений, превышающих ограничения.
		 * Производится вызов операции по расчёту вклада из интерфейса Calculation
		 * и отображение полученного результата при помощи JOptionPane.
		 * @throws NumberFormatException при вводе некорректных значений
		 */
		btn[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				if ((pane[0].getText().trim().length()==0)||(pane[1].getText().trim().length()==0)||(pane[2].getText().trim().length()==0)) {
					JOptionPane.showMessageDialog(null,"Введите значения в поля", "Ошибка", JOptionPane.ERROR_MESSAGE);
				}
				
				else if ((Double.valueOf(pane[2].getText())>40)) {
					JOptionPane.showMessageDialog(null,"Максимально возможный срок 40 лет", "Ошибка", JOptionPane.ERROR_MESSAGE);
				}
				else if((Double.valueOf(pane[1].getText())>30)) {
					JOptionPane.showMessageDialog(null,"Максимально возможная процентная ставка = 30%", "Ошибка", JOptionPane.ERROR_MESSAGE);
				}
				else {
					/**
					 * @param deposit - запись значения из поля ввоода pane[0] в переменную
					 * @param percentage - запись значения из поля ввоода pane[1] в переменную
					 * @param term - запись значения из поля ввоода pane[2] в переменную
					 * @param myPanel - панель, используемая для вывода результатов
					 * @param options - массив объектов, используемый в панеле myPanel для настройки функциональных кнопок 
					 */
					double deposit=Double.valueOf(pane[0].getText());
					double percentage=Double.valueOf(pane[1].getText());
					int term=Integer.valueOf(pane[2].getText());
					JPanel myPanel = new JPanel();
					Object[] options = {"Ввести новые значения",
	                "Продолжить"};
					myPanel.setLayout(new GridLayout(2,2));
					myPanel.add(new JLabel("Сумма на конец вклада:"));
					myPanel.add(new JLabel(""));
					/**
					 * цикл осуществляющий вызов функций расчёта и отображение результатов в окне
					 */
					if (kapital.isSelected()) myPanel.add(new JLabel(Calculation.kapitalOn(deposit, percentage, term)+" руб."));
					else myPanel.add(new JLabel(Calculation.kapitalOff(deposit, percentage, term)+" руб."));
					myPanel.add(new JLabel("Прибыль:"));
					myPanel.add(new JLabel(""));
					if (kapital.isSelected())myPanel.add(new JLabel(Calculation.kapitalOnSum(deposit, percentage, term)+" руб.")); 
					else myPanel.add(new JLabel(Calculation.kapitalOffSum(deposit, percentage, term)+" руб."));
					/**
					 * @param n - принимает числовое значение, отображающее кнопку, которая нажата на панели отображения результатов.
					 * Если была нажата кнопка для очистки полей, то производиться очистка полей ввода pane 
					 */
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
		 * @param btn[1] - кнопка осуществялющая подробный вывод результата в табличный документ "Отчёт.csv"
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
				else if((Double.valueOf(pane[1].getText())>30)) {
					JOptionPane.showMessageDialog(null,"Максимально возможная процентная ставка = 30%", "Ошибка", JOptionPane.ERROR_MESSAGE);
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
		 * осуществляющей переход на окно выбора пользователя UserChoose.
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
