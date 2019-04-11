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

public class UserChoose extends CalcMain{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5079599438260047805L;
	private static JButton userBtn= new JButton();
	private static JButton adminBtn= new JButton();
	private final static String Log="admin";
	private final static char[] Pass= {'a','d','m','i','n'};
	
	/**
	 *  
	 */
	
	public UserChoose() {
		super();
		setTitle("Выберите пользователя");
		setSize(400,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(4,2));
		
		/**
		 * 
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
		 * 
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

