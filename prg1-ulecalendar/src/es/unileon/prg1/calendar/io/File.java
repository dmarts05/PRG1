package es.unileon.prg1.calendar.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Class that manages all the information related to a user
 *
 * @author prg
 * @version 1.0
 */

public class File {

	private String fileName;

	static final Logger logger = LogManager.getLogger(File.class.getClass());

	/**
	 * Constructor
	 * 
	 * @param fileName Name of the file
	 */
	public File(String fileName) {
		this.fileName = fileName;
	}

	public String getName() {
		return this.fileName;
	}

	/**
	 * Reads the next line of the file and returns its content
	 * 
	 * @return String The content of one line of the file
	 * @throws FileException if file couldn't be opened
	 */
	public String readElements() throws FileException {
		FileReader fr = null;
		BufferedReader br = null;
		StringBuilder line = new StringBuilder();
		String lineAux = "";

		logger.info("Lee un elemento del fichero " + this.fileName);

		try {
			/*
			 * Apertura del fichero y creacion de BufferedReader para poder hacer una
			 * lectura comoda (disponer del metodo readLine()).
			 */
			fr = new FileReader(this.fileName);
			br = new BufferedReader(fr);

			// File reading
			lineAux = br.readLine();
			while (lineAux != null) {
				line.append(lineAux + System.getProperty("line.separator"));
				lineAux = br.readLine();
			}
		} catch (IOException e) {
			logger.warn("File error: No ha sido posible abrir el fichero " + this.fileName);
			throw new FileException("File error: No ha sido posible abrir el fichero " + this.fileName);
		} finally {
			/*
			 * En el finally cerramos el fichero, para asegurarnos que se cierra tanto si
			 * todo va bien como si salta una excepcion.
			 */
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (IOException e) {
				logger.warn("File error: No ha sido posible cerrar el fichero " + this.fileName);
				throw new FileException("File error: No ha sido posible cerrar el fichero " + this.fileName);
			}
		}
		return line.toString();
	}
	/**
	 * A method that writes the Calendar information in a file. The filename is defined using the constructor. 
	 * 
	 * @param lines Lines of the file
	 * @return  boolean Returns true if everything goes okay.
	 * @throws FileException if file couldn't be opened
	 */
	public boolean writeElements(String lines) throws FileException {

		FileWriter fw = null;
		boolean succeed = true;

		try {
			/*
			 * Apertura del fichero
			 */
			fw = new FileWriter(this.fileName);
			fw.write(lines);

			// File writting
		} catch (IOException e) {
			logger.warn("File Error: No ha sido posible abrir el fichero " + this.fileName);
			succeed = false;
			throw new FileException("File error: No ha sido posible abrir el fichero " + this.fileName);
		} finally {
			/*
			 * En el finally cerramos el fichero, para asegurarnos que se cierra tanto si
			 * todo va bien como si salta una excepcion.
			 */
			try {
				if (null != fw) {
					fw.close();
				}
			} catch (IOException e) {
				logger.warn("File error: No ha sido posible cerrar el fichero " + this.fileName);
				succeed = false;
				throw new FileException("File error: No ha sido posible cerrar el fichero " + this.fileName);
			}
		}

		return succeed;
	}
	/**
	 * Método para eliminar el fichero. 
	 * 
	 * @return  boolean Devolverá true ha conseguido eliminar el fichero. 
	 */
	public boolean delete() {
		java.io.File f = new java.io.File(this.fileName);
		return f.delete();
	}
}
