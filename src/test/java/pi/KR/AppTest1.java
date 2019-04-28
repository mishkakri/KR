package pi.KR;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.junit.jupiter.api.Test;

/**
 * В теле данного класса расположен метод для проверки точности
 * расчётов суммы вклада с учётом капитализации
 */
public class AppTest1  {
	/**
	 * Метод, который выполняет тестирование
	 * @param result принимает значение метода расчёта суммы вклада с учётом капитализации из интрефейса Calculation
	 */
	@Test
	public void test_kapitalOn()
	{	
		/**
		 * @param result принимает значение метода расчёта суммы вклада с учётом капитализации из интрефейса Calculation.
		 * Методу Calculation.kapitalOn(p,i,t) передаются следующие значения:
		 * @param p - Начальная сумма вклада = 30000
		 * @param i - Процентная ставка = 11%
		 * @param t - Срок = 1 год
		 * Значения взяты из примера в разделе 3.
		 */
		String result = Calculation.kapitalOn(30000.0, 11.0, 1);
		result = result.replace(",", ".");
		/**
		 * Вызываем стандартную функцию JUnit библиотеки, которая сравнивает
		 * значение, которое заведомо верно, с значением @param result
		 */
		assertEquals("33471,56" , result);	
	}
}
