package pi.KR;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * В теле данного класса расположен метод для проверки точности
 * расчётов суммы вклада
 */
public class AppTest3 {
	
	/**
	 * Метод, который выполняет тестирование
	 * @param result принимает значение метода расчёта суммы вклада из интрефейса Calculation
	 */
	@Test
	void test_kapitalOn()
	{	
		/**
		 * @param result принимает значение метода расчёта суммы вклада из интрефейса Calculation.
		 * Методу Calculation.kapitalOff(p,i,t) передаются следующие значения:
		 * @param p - Начальная сумма вклада = 50000
		 * @param i - Процентная ставка = 10.5%
		 * @param t - Срок = 1 год
		 * Значения взяты из примера в разделе 3.
		 */
		String result = Calculation.kapitalOff(50000.0, 10.5, 1);
		/**
		 * Вызываем стандартную функцию JUnit библиотеки, которая сравнивает
		 * значение, которое заведомо верно, с значением @param result
		 */
		assertEquals("55250,00", result);	
	}
}
