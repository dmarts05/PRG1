package es.unileon.prg1.agregados;

/**
 * This class represents a store of products with a limited capacity
 *
 * @author PRG
 * @version 1.0
 */
public class Store {

	/**
	 * Array of types of products
	 */
	private Product products[];
	/**
	 * Maximum capacity in the store of different types of products
	 */
	final int MAX_PRODUCTS = 10;
	/**
	 * Number of types of products already included in the store or first free
	 * position in the array
	 */
	private int next;

	/**
	 * Creates an empty store
	 */
	public Store() {
		// COMPLETAR
	}

	/**
	 * Adds a new type of product to the store if it is not already included and if
	 * the store is not already full
	 *
	 * @param product product to be added
	 * @return true if the product has been added
	 * @throws StoreException thrown if the product was already included and if
	 *                        there is no more room in the store
	 */
	public boolean add(Product product) throws StoreException {
		// COMPLETAR
		return false;
	}

	/**
	 * Checks if the product is already included in the store
	 *
	 * @param product product wanted
	 * @return true if the product is included in the store and false if not
	 */
	public boolean exists(Product product) {
		// COMPLETAR
		return false;
	}

	/**
	 * Searches using the binary search on the sorted collection of products
	 *
	 * @param name name of the wanted product
	 * @return the wanted product if it is included in the store or null if not
	 */
	public Product search(String name) {
		// COMPLETAR
		return null;
	}

	/**
	 * Interchanges the products allocated in the positions received as parameters
	 *
	 * @param i position of the first product
	 * @param j position of the second product
	 */
	private void swap(int i, int j) {
		// COMPLETAR
	}

	/**
	 * Uses the bidirectional bubble-sort algorithm to sort the products of the
	 * store using their names to order them alphabetically
	 */
	public void sort() {
		int upperLimit, lowerLimit;
		boolean end, changed;

		upperLimit = products.length;
		lowerLimit = -1;
		end = false;

		while ((lowerLimit < upperLimit) && !end) {
			lowerLimit++;
			upperLimit--;
			changed = false;
			for (int j = lowerLimit; j < upperLimit; j++) {
				if (products[j].isAlphabeticallyAfter(products[j + 1])) {
					swap(j, j + 1);
					changed = true;
				}
			}
			if (!changed) {
				end = true;
			} else {
				changed = false;
				for (int j = upperLimit; --j >= lowerLimit;) {
					if (products[j].isAlphabeticallyAfter(products[j + 1])) {
						swap(j, j + 1);
						changed = true;
					}
				}
				if (!changed) {
					end = true;
				}
			}
		}
	}

	/**
	 * Returns the string containing the information about the products included in
	 * the store. They appear sorted by name
	 */
	public String toString() {
		StringBuffer salida = new StringBuffer();
		sort();
		salida.append("---------");
		salida.append("PRODUCTOS");
		salida.append("---------\n");
		for (int i = 0; i < next; i++) {
			salida.append(products[i].toString() + "\n");
		}
		return salida.toString();
	}

}
