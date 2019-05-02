package pi.KR;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

	/**
	 * Класс, в котором создаётся окно выбора пользователя и
	 * осуществляется переход на выбранное окно пользователя.
	 */
public class UserChoose extends CalcMain{
	/**
	 * @param userBtn - функциональная кнопка
	 * @param adminBtn - функциональная кнопка 
	 * @param login - Текстовая переменная имени пользователя, для идентфикации при переходе на окно AdminForm
	 * @param password - массив символов пароля, для идентфикации при переходе на окно AdminForm
	 */
	private static final long serialVersionUID = -5079599438260047805L;
	private static JButton userBtn= new JButton();
	private static JButton adminBtn= new JButton();
	private final static String login="admin";
	private final static char[] password= {'a','d','m','i','n'};
	
	/**
	 * Метод заполнения графического окна элементам.
	 * Изначально устанавливается его название, размеры, стандартная операция закрытия,
	 * начальное положение на экране и стиль расположения элементов в окне.
	 */
	public UserChoose() {
		super();
		setTitle("Выберите пользователя");
		setSize(400,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(4,2));
		
		/**
		 * @param userBtn - кнопка, инициализирующая переход на окно UserForm
		 */
		add(userBtn= new JButton("Клиент"));
		userBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserForm form = new UserForm();
				dispose();
				form.setVisible(true);
				
			}
		});
		
		/**
		 * @param adminBtn - кнопка, инициализирующая переход на окно AdminForm
		 * После нажатия на кнопку выводится панель для ввода пароля и логина сотрудника.
		 * Выполняется проверка достоверности введённого пароля и логина.
		 * Если пароль и логин введены корректно, то инициализируется новое окно описанное в классе AdminForm,
		 * происходит закрытие текущего окна и запуск окна AdminForm.
		 * Если пароль и логин введены не корректно, выводится сообщение о некорректно введенных значениях,
		 * значения полей логина и пароля обнуляются, попытка ввода осуществляется снова. 
		 */
		add(adminBtn= new JButton("Сотрудник Банка"));
		adminBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * @param loginField - поле ввода логина
				 * @param passwordField - поле ввода пароля
				 * @param signInPanel - панель авторизации на которой расположены loginField и passwordField
				 */
				JTextField loginField = new JTextField(5);
				JPasswordField passwordField = new JPasswordField(5);
				JPanel signInPanel = new JPanel();
				signInPanel.setLayout(new BoxLayout(signInPanel, BoxLayout.PAGE_AXIS));
				signInPanel.add(new JLabel("Логин:"));
				signInPanel.add(loginField);
				signInPanel.add(new JLabel("Пароль:"));
				signInPanel.add(passwordField); 	
				/**
				 * @param check - логическая переменная, принимающая значение true если пароль и логин являються верными.
				 */
				boolean check=false;
				/**
				 * Цикл проверки введеного пароля и логина на верность
				 * @param result - принимает значение кнопик, нажатой на окне авторизации.
				 * Если была нажата кнопка OK, то запускается цикл проверки.
				 */
				do {
				int result = JOptionPane.showConfirmDialog(null, signInPanel,
						"Введите логин и пароль", JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) { 
					if((loginField.getText().equals(login))&((Arrays.equals(passwordField.getPassword(),password)))) {
						AdminForm form = new AdminForm();
						dispose();
						form.setVisible(true);
						check=true;
					}
					else{
						JOptionPane.showMessageDialog(null,"Попробуйте снова" ,"Логин или пароль введены неверно", JOptionPane.WARNING_MESSAGE);
						loginField.setText(null);
						passwordField.setText(null);
					} 
				}
				else { check=true;}
			}while(check==false);
			}
		});
	}
}