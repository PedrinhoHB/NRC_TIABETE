package br.com.nrc.tiabete.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class DataCalendar {
	private Calendar calendar;

	private DateFormat df;

	public Map<String, Integer> getDataHoraAtual() {
		Map<String, Integer> data = new HashMap<String, Integer>();
		calendar = Calendar.getInstance();

		data.put("Dia", Integer.parseInt(new SimpleDateFormat("dd").format(calendar.getTime())));
		data.put("Mes", Integer.parseInt(new SimpleDateFormat("MM").format(calendar.getTime())));
		data.put("Ano", Integer.parseInt(new SimpleDateFormat("yyyy").format(calendar.getTime())));
		data.put("Hora", Integer.parseInt(new SimpleDateFormat("HH").format(calendar.getTime())));
		data.put("Minuto", Integer.parseInt(new SimpleDateFormat("mm").format(calendar.getTime())));
		data.put("Segundo", Integer.parseInt(new SimpleDateFormat("ss").format(calendar.getTime())));

		return data;
	}

	public String formataData(Calendar calendar, String formato) {
		df = new SimpleDateFormat(formato);
		return df.format(calendar.getTime());
	}

	public String formataData(Calendar calendar) {
		df = new SimpleDateFormat("dd-MM-yyyy");
		return df.format(calendar.getTime());
	}

	public String formataHora(Calendar calendar) {
		df = new SimpleDateFormat("hh:mm:ss");
		return df.format(calendar.getTime());
	}

	public String formataHora(Calendar calendar, String formato) {
		df = new SimpleDateFormat(formato);
		return df.format(calendar.getTime());
	}

	public String formataDataHora(Calendar calendar) {
		df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		return df.format(calendar.getTime());
	}

	public String formataDataHora(Calendar calendar, String formato) {
		df = new SimpleDateFormat(formato);
		return df.format(calendar.getTime());
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public DateFormat getDf() {
		return df;
	}

	public void setDf(DateFormat df) {
		this.df = df;
	}
}
