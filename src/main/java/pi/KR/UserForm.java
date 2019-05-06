1.	package pi.KR;
2.	
3.	import java.awt.GridLayout;
4.	import java.awt.event.ActionEvent;
5.	import java.awt.event.ActionListener;
6.	import java.awt.event.KeyAdapter;
7.	import java.awt.event.KeyEvent;
8.	import javax.swing.JButton;
9.	import javax.swing.JCheckBox;
10.	import javax.swing.JLabel;
11.	import javax.swing.JOptionPane;
12.	import javax.swing.JPanel;
13.	import javax.swing.JTextField;
14.	
15.		/**
16.		 * Класс, в котором создаётся окно для клиента.
17.		 */
18.	public class UserForm extends CalcMain{
19.		/**
20.		 * @param paneCount - целочисленная переменная, используемая для циклов, в которых принимают участие текстовые поля
21.		 * @param pane - массив текстовых полей, которые используются для ввода данных
22.		 * @param btn - массив функциональных кнопок
23.		 * @param label - массив текстовых полей
24.		 * @param kapital - флаговая кнопка
25.		 */
26.		private static final long serialVersionUID = -388753505614938320L;
27.		private int paneCount;
28.		private static JTextField[] pane= new JTextField[3];
29.		private static JButton[] btn= new JButton[2];
30.		private static JLabel[] label= new JLabel[4];
31.		private static JCheckBox kapital= new JCheckBox();
32.	 
33.		/**
34.		 * Метод заполнения графического окна элементам.
35.		 * Изначально устанавливается его название, размеры, стандартная операция закрытия,
36.		 * начальное положение на экране и стиль расположения элементов в окне.
37.		 */
38.		public UserForm() {
39.			super();
40.			setTitle("Депозитный калькулятор (Клиент)");
41.			setSize(400,400);
42.			setDefaultCloseOperation(EXIT_ON_CLOSE);
43.			setLocationRelativeTo(null);
44.			setLayout(new GridLayout(5,2));
45.			/**
46.			 * @param pane[0] - поле ввода суммы вклада
47.			 * @param label[0] - текстовое поле, поясняющее поле ввода pane[0] 
48.			 */
49.			add(pane[0]= new JTextField());
50.			add(label[0] = new JLabel("Сумма вклада"));
51.			/**
52.			 * @param pane[1] - поле ввода процентной ставки вклада
53.			 * @param label[1] - текстовое поле, поясняющее поле ввода pane[1] 
54.			 */
55.			add(pane[1]= new JTextField());
56.			add(label[1] = new JLabel("Процент вклада"));
57.			/**
58.			 * @param pane[2] - поле ввода срока на который оформляется вклад
59.			 * @param label[2] - текстовое поле, поясняющее поле ввода pane[2]
60.			 * @param kapital - флаговая кнопка, которая регулирует функцию капитализации. Выбранное состояние кнопки сигнализирует о том,
61.			 * что условия капитализации выполняются
62.			 * @param label[3] - пустое текстовое поле для более удобного расположения всех элементов в окне
63.			 */
64.			add(pane[2]= new JTextField());
65.			add(label[2] = new JLabel("Срок (год)"));
66.			add(kapital = new JCheckBox("Капитализация"));
67.			kapital.setToolTipText("Автоматическое присоединение суммы процентов ко вкладу");
68.			add(label[3]=new JLabel(""));
69.			/**
70.			 * @param btn[0] - кнопка, в результате которой выполняються расчёты, исходя изз данных
71.			 * введённых в поля pane.
72.			 * При помощи цикла организовано ограничение ввода символов в поля 
73.			 * JTextField таким образом, что в данные поля разрешается вводить только числовые значения и десятичный разделитель.
74.			 * В связи с особенностью языка Java, десятичным разделителем является знак '.', но для удобства 
75.			 * обращения с калькулятором, ввод знака ',' тоже разрешен, но графически
76.			 * будет отображаться как знак '.'.
77.			 */
78.			add(btn[0]= new JButton("Рассчитать"));
79.			for (paneCount=0;paneCount<pane.length;paneCount++) {
80.				pane[paneCount].addKeyListener(new KeyAdapter() {
81.					public void keyTyped(KeyEvent e) {
82.						if (e.getKeyChar()==',') e.setKeyChar('.');
83.						char c = e.getKeyChar();
84.						if ( ((c < '0') || (c > '9')) &&(c!= KeyEvent.VK_PERIOD)) e.consume();
85.					}
86.				});
87.			}
88.			
89.			/**
90.			 * Изменение обработчика события для кнопки btn[0] (кнопка "Рассчитать").
91.			 * Устанавливаются ограничения на вводимые значения для JTextField и отображаются ошибки, при вводе значений, превышающих ограничения.
92.			 * Производится вызов операции по расчёту вклада из интерфейса Calculation
93.			 * и отображение полученного результата при помощи JOptionPane.
94.			 */
95.			btn[0].addActionListener(new ActionListener() {
96.				public void actionPerformed(ActionEvent e) {
97.					/**
98.					 * В данном блоке кода выполняется проверка значений из панелей ввода pane на корректность
99.					 */
100.					try {
101.						if ((pane[0].getText().trim().length()==0)||(pane[1].getText().trim().length()==0)||(pane[2].getText().trim().length()==0)) {
102.							JOptionPane.showMessageDialog(null,"Введите значения в поля", "Ошибка", JOptionPane.ERROR_MESSAGE);
103.						}
104.						else if ((Double.valueOf(pane[0].getText())>1000000000)) {
105.							JOptionPane.showMessageDialog(null,"Максимально возможная сумма вклада 1000000000 руб.", "Ошибка", JOptionPane.ERROR_MESSAGE);
106.						}
107.						else if ((Integer.valueOf(pane[2].getText())>40)) {
108.							JOptionPane.showMessageDialog(null,"Максимально возможный срок 40 лет", "Ошибка", JOptionPane.ERROR_MESSAGE);
109.						}
110.						else if((Double.valueOf(pane[1].getText())>30)) {
111.							JOptionPane.showMessageDialog(null,"Максимально возможная процентная ставка = 30%", "Ошибка", JOptionPane.ERROR_MESSAGE);
112.						}
113.						else {
114.							/**
115.							 * @param deposit - запись значения из поля ввоода pane[0] в переменную
116.							 * @param percentage - запись значения из поля ввоода pane[1] в переменную
117.							 * @param term - запись значения из поля ввоода pane[2] в переменную
118.							 * @param myPanel - панель, используемая для вывода результатов
119.							 * @param options - массив объектов, используемый в панеле myPanel для настройки функциональных кнопок 
120.							 */
121.							double deposit=Double.valueOf(pane[0].getText());
122.							double percentage=Double.valueOf(pane[1].getText());
123.							int term=Integer.valueOf(pane[2].getText());	
124.							JPanel myPanel = new JPanel();
125.							myPanel.setLayout(new GridLayout(2,3));
126.							Object[] options = {"Ввести новые значения",
127.			                "Продолжить"};
128.							myPanel.add(new JLabel("Сумма на конец вклада:"));
129.							myPanel.add(new JLabel(""));
130.							/**
131.							 * Цикл осуществляющий вызов функций расчёта и отображение результатов в окне
132.							 */
133.							if (kapital.isSelected()) myPanel.add(new JLabel(Calculation.kapitalOn(deposit, percentage, term)+" руб."));
134.							else myPanel.add(new JLabel(Calculation.kapitalOff(deposit, percentage, term)+" руб."));
135.							myPanel.add(new JLabel("Прибыль:"));
136.							myPanel.add(new JLabel(""));
137.							if (kapital.isSelected())myPanel.add(new JLabel(Calculation.kapitalOnSum(deposit, percentage, term)+" руб.")); 
138.							else myPanel.add(new JLabel(Calculation.kapitalOffSum(deposit, percentage, term)+" руб."));
139.							/**
140.							 * @param n - принимает числовое значение, отображающее кнопку, которая нажата на панели отображения результатов.
141.							 * Если была нажата кнопка для очистки полей, то производиться очистка полей ввода pane 
142.							 */
143.							int n = JOptionPane.showOptionDialog(null,myPanel, "Результат", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
144.									null, options,options[0]);
145.								if (n==0) {
146.									pane[0].setText("");
147.									pane[1].setText("");
148.									pane[2].setText("");
149.								}
150.					}
151.				} catch(NumberFormatException f) { 
152.					JOptionPane.showMessageDialog(null, "Введены недопустимые значения\nПожалуйста повторите попытку" ,"Ошибка",JOptionPane.ERROR_MESSAGE);
153.					for (paneCount=0;paneCount<pane.length;paneCount++) {
154.						pane[paneCount].setText("");
155.					}
156.				}
157.				}
158.			});
159.			
160.			/**
161.			 * @param btn[1] - кнопка, осуществялющая переход на окно выбора пользователя UserChoose
162.			 */
163.			add(btn[1]= new JButton("Сменить пользователя"));
164.			btn[1].addActionListener(new ActionListener() {
165.				public void actionPerformed(ActionEvent e) {
166.					 UserChoose window = new UserChoose();
167.					 dispose();
168.				     window.setVisible(true);
169.				}
170.			});
171.		}
172.	}
