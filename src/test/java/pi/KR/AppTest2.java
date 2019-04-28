package pi.KR;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * В теле данного класса расположен метод для проверки точности
 * расчётов суммы процентов вклада с учётом капитализации
 */
public class AppTest2  {
	
	
	/**
	 * Метод, который выполняет тестирование
	 * @param result принимает значение метода расчёта суммы процентов вклада с учётом капитализации из интрефейса Calculation
	 */
	@Test
	public void test_kapitalOnSum()
	{	
		/**
		 * @param result принимает значение метода расчёта суммы процентов вклада с учётом капитализации из интрефейса Calculation.
		 * Методу Calculation.kapitalOnSum(p,i,t) передаются следующие значения:
		 * @param p - Начальная сумма вклада = 47000
		 * @param i - Процентная ставка = 9%
		 * @param t - Срок = 2 год
		 * Значения взяты из примера в разделе 3.
		 */
		String result = Calculation.kapitalOnSum(47000.0, 9.0, 1);
		/**
		 * Вызываем стандартную функцию JUnit библиотеки, которая сравнивает
		 * значение, которое заведомо верно, с значением @param result
		 */
		assertEquals("9231,43", result);	
	}
}
