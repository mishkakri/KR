package pi.KR;

import java.text.DecimalFormat;

public interface Calculation {
	int  k=365;
	DecimalFormat df = new DecimalFormat("#.##");
	
	public static String kapitalOn(double p,double i, int t) {
		double j, sum = 0,sumP=0,n = 0;
		n=t*12;
		j=(t*k)/n;
		sum=p*Math.pow((1+(i*j)/(100*k)),n);
		return df.format(sum);
	}
	
	public static String kapitalOff(double p,double i, int t) {
		double sum = 0,sumP=0;
		t=365*t;
		sum=p*(1+(i*t)/(100*k));
		//sumP=(p*i*t)/(k*100);
		return df.format(sum);
	}
	
	public static void resulCSV(double p, double i, int t) {
		
	}
}
