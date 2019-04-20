package pi.KR;

import org.junit.Test;
import junit.framework.TestCase;

/**
 * В теле данного класса расположен метод для проверки точности
 * расчётов суммы процентов вклада
 */
public class AppTest5 
    extends TestCase {
	
	@Test
	/**
	 * Метод, который выполняет тестирование
	 * @param result принимает значение метода расчёта суммы процентов вклада из интрефейса Calculation
	 */
	public void test_kapitalOn()
	{	
		/**
		 * @param result gринимает значение метода расчёта суммы процентов вклада из интрефейса Calculation.
		 * Методу Calculation.kapitalOff(p,i,t) передаются следующие значения:
		 * @param p - Начальная сумма вклада = 45000
		 * @param i - Процентная ставка = 12%
		 * @param t - Срок = 2 год
		 */
		String result = Calculation.kapitalOffSum(45000.0, 12.0, 2);
		/**
		 * Вызываем стандартную функцию JUnit библиотеки, которая сравнивает
		 * значение, которое заведомо верно, с значением @param result
		 */
		assertEquals("10800,00", result);	
	}
}
