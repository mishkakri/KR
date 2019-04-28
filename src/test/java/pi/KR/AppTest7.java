package pi.KR;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * В теле данного класса расположен метод для проверки точности
 * расчётов суммы вклада
 */
class AppTest7 {
	
	/**
	 * Метод, который выполняет тестирование
	 * @param result принимает значение метода расчёта суммы вклада из интрефейса Calculation
	 */
	@Test
	void test_kapitalOff()
	{	
		/**
		 * @param result принимает значение метода расчёта суммы вклада из интрефейса Calculation.
		 * Методу Calculation.kapitalOff(p,i,t) передаются следующие значения:
		 * @param p - Начальная сумма вклада = 1000
		 * @param i - Процентная ставка = 4.5%
		 * @param t - Срок = 1 год
		 */
		String result = Calculation.kapitalOff(1000.0, 4.5, 1);
		/**
		 * Вызываем стандартную функцию JUnit библиотеки, которая сравнивает
		 * значение, которое заведомо верно, с значением @param result
		 */
		assertEquals("1045,00", result);	
	}
}
