package es.unileon.prg1.agregados;

/**
 * This class represents a supermarket defined by a name that includes a store
 * of products
 *
 * @author PRG
 * @version 1.0
 */
public class Supermarket {

	/**
	 * Name of the supermarket
	 */
	private String name;
	/**
	 * Store for the supermarket products
	 */
	private Store store;

	/**
	 * Builds a supermarket with the given name and creates an empty store for
	 * products
	 * 
	 * @param name the name of the supermarket
	 */
	public Supermarket(String name) {
		this.name = name;
		this.store = new Store();
	}

	/**
	 * Adds a new type of product to the store if it is not already included and if
	 * the store is not already full
	 *
	 * @param product product to be added to the supermarket
	 * @return true if the product has been added
	 * @throws StoreException thrown if the product was already included and if
	 *                        there is no more room in the store
	 */
	public boolean add(Product product) throws StoreException {
		// COMPLETAR
		return false;
	}

	/**
	 * Searches for a product with the same name as the one received
	 *
	 * @param product name of the product to be found
	 * @return the product if it has been found, or null if not
	 */
	public Product search(String product) {
		// COMPLETAR
		return null;
	}

	/**
	 * Returns the name of the supermarket and the content of its store
	 *
	 */
	public String toString() {
		// COMPLETAR
		return null;
	}

}
