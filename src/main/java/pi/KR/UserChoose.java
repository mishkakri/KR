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
	
	
	private static final long serialVersionUID = -5079599438260047805L;
	private static JButton userBtn= new JButton();
	private static JButton adminBtn= new JButton();
	private final static String Log="admin";
	private final static char[] Pass= {'a','d','m','i','n'};
	
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
		 * Добовление кнопки userBtn, и изменение события, происходящего при нажатии на кнопку.
		 * После нажатия на кнопку инициализируется новое окно описанное в классе UserForm, происходит закрытие текущего окна и запуск окна UserForm.
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
		 * Добовление кнопки adminBtn, и изменение события, происходящего при нажатии на кнопку.
		 * После нажатия на кнопку выводится панель для ввода пароля и логина сотрудника.
		 * Выполняется проверка достовернеости введёного пароля и логина.
		 * Если пароль и логин введены корректно, то инициализируется новое окно описанное в классе AdminForm,
		 * происходит закрытие текущего окна и запуск окна AdminForm.
		 * Если пароль и логин введены не корректно, выводится сообщение о некоррктно введеных значениях,
		 * значения полей логина и пароля обнуляются, попытка ввода осуществляется снова. 
		 */
		add(adminBtn= new JButton("Сотрудник Банка"));
		adminBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField Login = new JTextField(5);
				JPasswordField Password = new JPasswordField(5);
				JPanel myPanel = new JPanel();
				myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.PAGE_AXIS));
				myPanel.add(new JLabel("Логин:"));
				myPanel.add(Login);
				myPanel.add(new JLabel("Пароль:"));
				myPanel.add(Password); 	
				boolean check=false;
				do {
				int result = JOptionPane.showConfirmDialog(null, myPanel,
						"Введите логин и пароль", JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) { 
					if((Login.getText().equals(Log))&((Arrays.equals(Password.getPassword(),Pass)))) {
						AdminForm form = new AdminForm();
						dispose();
						form.setVisible(true);
						check=true;
					}
					else{
						JOptionPane.showMessageDialog(null,"Попробуйте снова" ,"Логин или пароль введены неверно", JOptionPane.WARNING_MESSAGE);
						Login.setText(null);
						Password.setText(null);
					} 
				}
				else { check=true;}
			}while(check==false);
			}
		});
	}
}