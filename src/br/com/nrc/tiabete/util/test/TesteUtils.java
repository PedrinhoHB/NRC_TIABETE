package br.com.nrc.tiabete.util.test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.nrc.tiabete.util.DataCalendar;

public class TesteUtils {
	public static void main(String[] args) {

		DataCalendar f = new DataCalendar();
		System.out.println(
				f.getDataAtual().get("Dia") + "/" + f.getDataAtual().get("Mes") + "/" + f.getDataAtual().get("Ano"));

		System.out.println(f.getDataAtual().get("Hora") + ":" + f.getDataAtual().get("Minuto") + ":"
				+ f.getDataAtual().get("Segundo"));

		Calendar ca = new GregorianCalendar(1997, 6, 4, 20, 30, 40);
		System.out.println(ca.getTime());
	}
}
