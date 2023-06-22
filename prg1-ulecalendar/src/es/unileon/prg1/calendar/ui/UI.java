package es.unileon.prg1.calendar.ui;

import es.unileon.prg1.calendar.Calendar;
import es.unileon.prg1.calendar.date.Date;
import es.unileon.prg1.calendar.date.Time;
import es.unileon.prg1.calendar.io.File;
import es.unileon.prg1.calendar.io.FileException;
import es.unileon.prg1.calendar.users.*;
import es.unileon.prg1.calendar.events.*;
import es.unileon.prg1.calendar.io.Teclado;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Class that execute the main task of the program
 *
 * @author Mario
 * @version 1.0
 */

public class UI {

    static final Logger logger = LogManager.getLogger(UI.class.getClass());

    /**
     *Calendar associated with UI
     */
    private Calendar calendar;


    /**
     * Establish the information contained in calendar
     *
     * @param calendar Contains the main information
     */
    public UI(Calendar calendar) {
        this.calendar = calendar;
    }

    /**
     * Executes the main task of the program
     */
    public void mainMenu() {
        boolean run = true;

        while (run) {
            String slash = "////////////////";
            System.out.println(slash);
            System.out.println(calendar.toString());
            System.out.println(slash + "\n");
            System.out.println("Elige una opcion:");
            System.out.println("\t1 - Crear un nuevo usuario.");
            System.out.println("\t2 - Eliminar un usuario.");
            System.out.println("\t3 - Gestionar el calendario de un usuario.");
            System.out.println("\t4 - Mostrar calendarios.");
            System.out.println("\t5 - Salir.");

            int option = Teclado.readInteger();

            switch (option) {
                case 1:
                    String name;
                    String surname;
                    String nickname;

                    System.out.println("Introduce el nombre del nuevo usuario: ");
                    name = Teclado.readString();

                    System.out.println("Introduce el apellido del nuevo usuario: ");
                    surname = Teclado.readString();

                    System.out.println("Introduce el nickname del nuevo usuario:");
                    nickname = Teclado.readString();

                    User user = new User(nickname, name, surname);

                    try {
                        this.calendar.add(user);
                        logger.info("Usuario " + user + " creado.\n");
                    } catch (UserException e) {
                        logger.warn(e.getMessage());
                    }

                    break;
                case 2:
                    System.out.println("Introduce el nickname del usuario: ");
                    nickname = Teclado.readString();

                    try {
                        this.calendar.remove(nickname);
                        logger.info("Usuario " + nickname + " eliminado.\n");
                    } catch (UserException e) {
                        logger.warn(e.getMessage());
                    }

                    break;
                case 3:
                    System.out.println("Introduce el nickname del usuario:");
                    nickname = Teclado.readString();

                    if (this.calendar.search(nickname) == null) {
                        logger.warn("El usuario " + nickname + " introducido no existe.\n");
                    } else {
                        boolean run2 = true;

                        while (run2) {
                            System.out.println(slash);
                            System.out.println(this.calendar.search(nickname).toAgendaFormat());
                            System.out.println(slash + "\n");
                            System.out.println("Calendario de: " + this.calendar.search(nickname).userAgendaFormat());
                            System.out.println("Elige una opcion:");
                            System.out.println("\t1 - Crear un nuevo evento.");
                            System.out.println("\t2 - Eliminar un evento.");
                            System.out.println("\t3 - Imprimir agenda.");
                            System.out.println("\t4 - Volver al menu principal.");

                            int option2 = Teclado.readInteger();

                            switch (option2) {
                                case 1:
                                    System.out.println("Introduce el nombre del evento: ");
                                    String eventName = Teclado.readString();

                                    System.out.println("Introduce el nombre del lugar: ");
                                    Place place = new Place(Teclado.readString());

                                    System.out.println("Introduce la fecha de del evento (dd/mm/yyyy/): ");

                                    Date date;

                                    try {
                                        date = new Date(Teclado.readString());

                                    } catch (Exception e) {
                                        logger.warn(e.getMessage());
                                        continue;
                                    }

                                    System.out.println("Introduce la hora de inicio del evento (hh:mm):");
                                    String initialTime = Teclado.readString();

                                    System.out.println("Introduce la hora de fin del evento (hh:mm):");
                                    String finalTime = Teclado.readString();

                                    Time startTime;
                                    Time endTime;

                                    try {
                                        startTime = new Time(initialTime);
                                        endTime = new Time(finalTime);
                                    } catch (Exception e) {
                                        logger.warn(e.getMessage());
                                        continue;
                                    }

                                    Event event;

                                    try {
                                        event = new Event(eventName, place, date, startTime, endTime);
                                    } catch (Exception e) {
                                        logger.warn(e.getMessage());
                                        continue;
                                    }

                                    try {
                                        this.calendar.search(nickname).add(event);
                                        logger.info("Evento " + event.getName() + " creado.\n");
                                    } catch (Exception e) {
                                        logger.warn(e.getMessage());
                                        continue;
                                    }

                                    break;
                                case 2:
                                    System.out.println("Introduce el nombre del evento: ");
                                    eventName = Teclado.readString();

                                    try {
                                        this.calendar.remove(nickname, eventName);
                                        logger.info("Evento " + eventName + " eliminado.\n");
                                    } catch (Exception e) {
                                        logger.warn(e.getMessage());
                                        continue;
                                    }

                                    break;
                                case 3:
                                    System.out.println(slash);
                                    System.out.println(this.calendar.search(nickname).toAgendaFormat());
                                    System.out.println(slash + "\n");
                                    break;
                                case 4:
                                    run2 = false;
                                    break;
                                default:
                                    logger.warn("Opcion no valida, vuelva a intentarlo.\n");
                                    break;
                            }
                        }
                    }
                    break;
                case 4:
                    System.out.println(slash);
                    System.out.println(this.calendar.toString());
                    System.out.println(slash + "\n");

                    break;
                case 5:
                    System.out.println("Introduce el nombre del fichero:");
                    String filename = Teclado.readString();

                    File file = new File(filename);

                    try {
                        file.writeElements(this.calendar.toFile());
                    } catch (FileException e) {
                        logger.error("Ha ocurrido un error al guardar el archivo.");
                        continue;
                    }

                    run = false;
                    break;
                default:
                    logger.warn("Opcion no valida, vuelva a intentarlo.");
                    break;
            }
        }
    }
}
