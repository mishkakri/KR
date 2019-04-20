package pi.KR;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

/**
 * В теле данного класса расположен метод для проверки точности
 * расчётов суммы вклада с учётом капитализации
 */
public class AppTest 
    extends TestCase {
	
	@Test
	/**
	 * Метод, который выполняет тестирование
	 * @param result принимает значение метода расчёта суммы вклада с учётом капитализации из интрефейса Calculation
	 */
	public void test_kapitalOn()
	{	
		/**
		 * @param result gринимает значение метода расчёта суммы вклада с учётом капитализации из интрефейса Calculation.
		 * Методу Calculation.kapitalOn(p,i,t) передаются следующие значения:
		 * @param p - Начальная сумма вклада = 30000
		 * @param i - Процентная ставка = 11%
		 * @param t - Срок = 1 год
		 */
		String result = Calculation.kapitalOn(30000.0, 11.0, 1);
		/**
		 * Вызываем стандартную функцию JUnit библиотеки, которая сравнивает
		 * значение, которое заведомо верно, с значением @param result
		 */
		assertEquals("33471,56", result);	
	}
}
