package funciones;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.DateFormatSymbols;

public class Funciones {
	public static boolean esBisiesto(int anio) {
		return new GregorianCalendar().isLeapYear(anio);
	}
	
	public static int traerAnio(GregorianCalendar fecha){
		return fecha.get(Calendar.YEAR);
	}
	
	public static int traerMes(GregorianCalendar fecha) {
		return fecha.get(Calendar.MONTH) + 1;
	}
	
	public static int traerDia(GregorianCalendar fecha) {
		return fecha.get(Calendar.DAY_OF_MONTH);
	}
	
	public static boolean esFechaValida(int anio, int mes, int dia) {
		boolean esValido = true;

		if(mes < 1 || mes > 12 || dia < 1) esValido = false;
		
		if(mes == 2) {
			if(esBisiesto(anio)) {
				if(dia > 28) esValido = false;
			}else {
				if(dia > 29) esValido = false;
			}
		}else if(mes == 4 || mes == 6 || mes == 9 || mes == 11) {
			if(dia > 30) esValido = false;
		}else {
			if(dia > 31) esValido = false; 
		}
		
		return esValido;
	}
	
	public static GregorianCalendar traerFecha(int anio, int mes, int dia) {
		return new GregorianCalendar(anio, mes - 1, dia);
	}
	
	public static GregorianCalendar traerFecha(String fecha) {
		int anio, mes, dia;
		String[] rFecha = fecha.split("/");
		
		dia = Integer.parseInt(rFecha[0]);
		mes = Integer.parseInt(rFecha[1]);
		anio = Integer.parseInt(rFecha[2]);
		
		//if(fecha.length() > 10 || !esFechaValida(dia, mes, anio)) return null; Era un validacion para el largo de la fecha entrante pero queria poner un solo return.
		
		return new GregorianCalendar(anio, mes - 1, dia);
	}
	
	public static String traerFechaCorta(GregorianCalendar fecha) {
		return new String(traerDia(fecha) + "/" + traerMes(fecha) + "/" + traerAnio(fecha));  
	}
	
	public static String traerFechaCortaHora(GregorianCalendar fecha) {
		return new String(traerDia(fecha) + "/" + traerMes(fecha) + "/" + traerAnio(fecha) + " " + fecha.get(Calendar.HOUR) + ":" + fecha.get(Calendar.MINUTE) + ":" + fecha.get(Calendar.SECOND));
	}
	
	public static GregorianCalendar traerFechaProximo(GregorianCalendar fecha, int cantDias){
		GregorianCalendar fechaAux = new GregorianCalendar(traerAnio(fecha), traerMes(fecha), traerDia(fecha));
		fechaAux.add((GregorianCalendar.DATE), cantDias);
		return fechaAux;
	}
	
	public static boolean esDiaHabil(GregorianCalendar fecha){
		return (fecha.get(Calendar.DAY_OF_WEEK) > 1 && fecha.get(Calendar.DAY_OF_WEEK) < 7);
	}
	
	public static String traerDiaDeLaSemana(GregorianCalendar fecha){
		String[] weekDays = new DateFormatSymbols().getWeekdays();
		return weekDays[fecha.get(Calendar.DAY_OF_WEEK)];
	}
	
	public static String traerMesEnLetras(GregorianCalendar fecha){
		String[] months = new DateFormatSymbols().getMonths();
		return months[fecha.get(Calendar.MONTH)];
	}
	
	public static String traerFechaLarga(GregorianCalendar fecha){
		return new String(traerDiaDeLaSemana(fecha) + " " + traerDia(fecha) + " de " + traerMesEnLetras(fecha) + " del " + traerAnio(fecha));
	}
	
	public static boolean sonFechasIguales(GregorianCalendar fecha, GregorianCalendar fecha1){
		return !(fecha.before(fecha1) || fecha.after(fecha1));
	}
	
	public static boolean sonFechasHorasIguales(GregorianCalendar fecha, GregorianCalendar fecha1){
		return (sonFechasIguales(fecha, fecha1) && fecha.get(Calendar.HOUR) == fecha.get(Calendar.HOUR));
	}
	
	public static int traerCantDiasDeUnMes(int anio, int mes){
		GregorianCalendar fechaAux = new GregorianCalendar(anio, mes, 1);
		return fechaAux.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	
	public static double aproximar2Decimal(double valor) {
		return Math.round(valor * 100) / 100.0d;
	}
	
	public static boolean esNumero(char c) {
		return Character.isDigit(c);  
	}
	
	public static boolean esLetra(char c) {
		return ((int)c >= 65 && (int)c <= 90 || (int)c >= 97 && (int)c <= 122); 
	}
	
	public static boolean esCadenaNros(String cadena) {
		boolean esCadenaNros = true;
		for(int i = 0; i < cadena.length(); i++) {
			if(!esNumero(cadena.charAt(i))) esCadenaNros = false; 
		}
		return esCadenaNros;
	}
	
	public static boolean esCadenaLetras(String cadena) {
		boolean esCadenaLetras = true;
		for(int i = 0; i < cadena.length(); i++) {
			if(!esLetra(cadena.charAt(i))) esCadenaLetras = false;
		}
		return esCadenaLetras;
	}
	
	public static double convertirADouble(int n){
		return ((double)n);
	}
}
