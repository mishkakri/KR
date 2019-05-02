package pi.KR;

import javax.swing.JFrame;

	/**
	 * @author ToxanUfa
	 * 
	 * Главный класс программы, наследующий библиотек javax.swing.JFrame
	 * @see javax.swing.JFrame
	 */
public class CalcMain extends JFrame
{
    /**
	 *@param serialVersionUID — идентификатор класса в языке Java,
	 * используемый при сериализации с использованием стандартного алгоритма. Хранится как числовое значение типа long.
	 */
	private static final long serialVersionUID = 9118988428064818287L;
	
	/**
	 * Основной метод, организующий работу программы.
	 * @param window - инициализация окна приложения.
	 * Вызывает класс UserChoose и устанавливает видимость графического окна window
	 */
	public static void main( String[] args )
    {	
        UserChoose window = new UserChoose();
        window.setVisible(true);
    }
}
