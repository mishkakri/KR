package pi.KR;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

public interface Calculation {
	int  k=365;
	DecimalFormat df = new DecimalFormat("#.##");
	
	public static String kapitalOn(double p,double i, int t) {
		double j, sum = 0,n = 0;
		n=t*12;
		j=(t*k)/n;
		sum=p*Math.pow((1+(i*j)/(100*k)),n);
		return df.format(sum);
	}
	
	public static String kapitalOnSum(double p,double i, int t) {
		double j,sumP=0,n = 0;
		n=t*12;
		j=(t*k)/n;
		sumP=p*Math.pow((1+(i*j)/(100*k)),n)-p;
		return df.format(sumP);
	}
	
	public static String kapitalOff(double p,double i, int t) {
		double sum = 0;
		t=365*t;
		sum=p*(1+(i*t)/(100*k));
		return df.format(sum);
	}
	
	public static String kapitalOffSum(double p,double i, int t) {
		double sumP=0;
		t=365*t;
		sumP=(p*i*t)/(k*100);
		return df.format(sumP);
	}
	
	
	public static void resulCSV(double p, double i, int t) {
		 try (PrintWriter writer = new PrintWriter(new File("Îò÷¸ò.csv"))) {

		      StringBuilder sb = new StringBuilder();
		      sb.append("Date ;Summ ; Ord");
		      sb.append('\n');

		      sb.append("31;15;300");
		      sb.append('\n');

		      writer.write(sb.toString());

		    } catch (FileNotFoundException f) {
		      System.out.println(f.getMessage());
		    }
	}
}
