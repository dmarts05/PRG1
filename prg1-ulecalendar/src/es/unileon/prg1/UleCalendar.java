package es.unileon.prg1;

import es.unileon.prg1.calendar.Calendar;
import es.unileon.prg1.calendar.io.BatchInterface;
import es.unileon.prg1.calendar.ui.UI;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class UleCalendar {
	
	private static final Logger logger = LogManager.getLogger(UleCalendar.class);

	public static void main(String[] args) {

		logger.trace("Iniciando aplicación");

		Calendar calendar = new Calendar();

		if (args.length > 1) {
			System.out.println("Sintaxis:");
			logger.error("Argumentos invalidos");
			System.out.println("java UleCalendar [fileName]");
		} else if (args.length == 1) {
			BatchInterface interfaz = new BatchInterface(args[0]);
			try {
				calendar = interfaz.createCalendar();
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
		UI ui = new UI(calendar);

		ui.mainMenu();

	}
}
