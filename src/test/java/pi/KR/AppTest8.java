package pi.KR;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * В теле данного класса расположен метод для проверки точности
 * расчётов суммы процентов вклада
 */
public class AppTest8 {
	
	/**
	 * Метод, который выполняет тестирование
	 * @param result принимает значение метода расчёта суммы процентов вклада из интрефейса Calculation
	 */
	@Test
	void test_kapitalOffSum()
	{	
		/**
		 * @param result принимает значение метода расчёта суммы процентов вклада из интрефейса Calculation.
		 * Методу Calculation.kapitalOff(p,i,t) передаются следующие значения:
		 * @param p - Начальная сумма вклада = 3228
		 * @param i - Процентная ставка = 5.3%
		 * @param t - Срок = 5 год
		 */
		String result = Calculation.kapitalOffSum(3228.0, 5.3, 5);
		/**
		 * Вызываем стандартную функцию JUnit библиотеки, которая сравнивает
		 * значение, которое заведомо верно, с значением @param result
		 */
		assertEquals("855,41", result);	
	}
}
