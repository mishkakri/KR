package pi.KR;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

/**
 * В теле данного класса расположен метод для проверки точности
 * расчётов суммы вклада с учётом капитализации
 */
public class AppTest2 
    extends TestCase {
	
	
	/**
	 * Метод, который выполняет тестирование
	 * @param result принимает значение метода расчёта суммы процентов вклада с учётом капитализации из интрефейса Calculation
	 */
	@Test
	public void test_kapitalOnSum()
	{	
		/**
		 * @param result gринимает значение метода расчёта суммы процентов вклада с учётом капитализации из интрефейса Calculation.
		 * Методу Calculation.kapitalOnSum(p,i,t) передаются следующие значения:
		 * @param p - Начальная сумма вклада = 47000
		 * @param i - Процентная ставка = 9%
		 * @param t - Срок = 2 год
		 */
		String result = Calculation.kapitalOnSum(47000.0, 9.0, 2);
		/**
		 * Вызываем стандартную функцию JUnit библиотеки, которая сравнивает
		 * значение, которое заведомо верно, с значением @param result
		 */
		assertEquals("9231,43", result);	
	}
}
