package pi.KR;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
/**
 * В теле данного класса расположен метод для проверки точности
 * расчётов суммы процентов вклада с учётом капитализации
 */
public class AppTest6 {
	
	
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
		 * @param p - Начальная сумма вклада = 25456
		 * @param i - Процентная ставка = 1.1%
		 * @param t - Срок = 3 год
		 */
		String result = Calculation.kapitalOnSum(25456.0, 1.1, 3);
		/**
		 * Вызываем стандартную функцию JUnit библиотеки, которая сравнивает
		 * значение, которое заведомо верно, с значением @param result
		 */
		assertEquals("853,66", result);	
	}
}
