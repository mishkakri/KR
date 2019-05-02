package pi.KR;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class Calculation {
	/**
	 * @param k - целочисленная переменная, отображающая усредненное количество дней в году 
	 * @param df - формат отображения чисел с плавающей точкой
	 */
	static final int  k=365;
	static DecimalFormat df = new DecimalFormat("0.00");
	/**
	 * Функция расчёта суммы вклада на конец срока с учётом капитализации.
	 * @param p - значение суммы вклада
	 * @param i - значение процента вклада
	 * @param t - значение срока вклада в годах
	 * @param sum - значение суммы вклада на конец срока
	 * @param j - количество календарных дней в периоде
	 * @param n - количество операций по капитализации начисленных процентов в течение общего срока
	 * @return значение переменной sum после выполнения операций расчёта
	 * Метод возвращает значение строки равной сумме вклада + начисленный процент
	 */
	public static String kapitalOn(double p,double i, int t) {
		df.setRoundingMode(RoundingMode.FLOOR);
		double j, sum = 0,n = 0;
		n=t*12;
		j=(t*k)/n;
		sum=p*Math.pow((1+(i*j)/(100*k)),n);
		return df.format(sum);
	}
	
	/**
	 * Функция расчёта суммы процентов вклада на конец срока с учётом капитализации.
	 * @param p - значение суммы вклада
	 * @param i - значение процента вклада
	 * @param t - значение срока вклада в годах
	 * @param sumP - значение суммы процентов вклада на конец срока
	 * @param j - количество календарных дней в периоде
	 * @param n - количество операций по капитализации начисленных процентов в течение общего срока
	 * @return значение переменной sumP после выполнения операций расчёта
	 *  Метод возвращает значение строки равной начисленному проценту
	 */
	public static String kapitalOnSum(double p,double i, int t) {
		df.setRoundingMode(RoundingMode.FLOOR);
		double j,sumP=0,n = 0;
		n=t*12;
		j=(t*k)/n;
		sumP=p*Math.pow((1+(i*j)/(100*k)),n)-p;
		return df.format(sumP);
	}
	
	/**
	 * Функция расчёта суммы вклада на конец срока без учёта капитализации.
	 * @param p - значение суммы вклада
	 * @param i - значение процента вклада
	 * @param t - значение срока вклада в годах
	 * @param sum - значение суммы вклада на конец срока
	 * @return значение переменной sum после выполнения операций расчёта
	 * Метод возвращает значение строки равной сумме вклада + начисленный процент
	 */
	public static String kapitalOff(double p,double i, int t) {
		df.setRoundingMode(RoundingMode.FLOOR);
		double sum = 0;
		t=365*t;
		sum=p*(1+(i*t)/(100*k));
		return df.format(sum);
	}
	
	/**
	 * Функция расчёта суммы процентов вклада на конец срока без учёта капитализации.
	 * @param p - значение суммы вклада
	 * @param i - значение процента вклада
	 * @param t - значение срока вклада в годах
	 * @param sumP - значение суммы процентов вклада на конец срока
	 * @return значение переменной sumP после выполнения операций расчёта
	 *  Метод возвращает значение строки равной начисленному проценту
	 */
	public static String kapitalOffSum(double p,double i, int t) {
		df.setRoundingMode(RoundingMode.FLOOR);
		double sumP=0;
		t=365*t;
		sumP=(p*i*t)/(k*100);
		return df.format(sumP);
	}
	
	/**
	 * Функция создания табличного документа с подробной информацией о начислениях по вкладу
	 * @param p отображает значение суммы вклада
	 * @param i отображает значение процента вклада
	 * @param t отображает значение срока вклада в годах
	 * @param sumP - значение суммы процентов вклада на конец срока
	 * @param sum - значение суммы вклада на конец срока
	 * @param sb - переменная передающая комманды для заполнения документа
	 * @throws FileNotFoundException
	 */
	public static void resulCSV(double p, double i, int t) {
		df.setRoundingMode(RoundingMode.FLOOR);
		 try (PrintWriter writer = new PrintWriter(new File("Отчёт.csv"))) {
			  double sumP=((p*i*t*365)/(k*100))/(12*t);
		      StringBuilder sb = new StringBuilder();
		      sb.append("Month ;% sum ;sum");
		      sb.append('\n');
		    if (AdminForm.kapital.isSelected()) {
		    	for(int j=1;j<=t*12;j++) {
		    		double sum=(p*Math.pow((1+(i*(k/12))/(100*k)),(t*12))-p)/(t*12);
		    		p=p+sum;
		    		sb.append(j+";"+df.format(sum)+";"+df.format(p));
			    	  sb.append('\n');
			    	  if (j==t*12) sb.append("Summ at the"+";"+"end of deposit"+";"+(df.format(p*Math.pow((1+(i*(k/12))/(100*k)),(t*12))-p)));
		    	}
		    }
		    else {
		    	for(int j=1;j<=t*12;j++) {
		    	  sb.append(j+";"+df.format(sumP)+";"+df.format(p)+" rub");
		    	  sb.append('\n');
		    	  if (j==t*12) sb.append("Summ at the"+";"+"end of deposit"+";"+(df.format((p*i*t*365)/(k*100))));
		      }}
		      writer.write(sb.toString());

		    } catch (FileNotFoundException f) {
		      System.out.println(f.getMessage());
		    }
		 JOptionPane.showMessageDialog(null, "Успешно", "Отчёт создан", JOptionPane.PLAIN_MESSAGE);
	}
	
}
