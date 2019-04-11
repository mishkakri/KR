package pi.KR;

import javax.swing.JFrame;

public class CalcMain extends JFrame
{
    /**
	 *serialVersionUID — идентификатор класса в языке Java,
	 * используемый при сериализации с использованием стадартного алгоритма. Хранится как числовое значение типа long.
	 */
	private static final long serialVersionUID = 9118988428064818287L;
	
	/**
	 * Основной метод, организующий работу программы.
	 * Вызвает класс UserChoose и устанавливает видимость графического окна window
	 */
	public static void main( String[] args )
    {	
        UserChoose window = new UserChoose();
        window.setVisible(true);
    }
}
