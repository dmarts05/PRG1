package es.unileon.prg1.agregados;

/**
 * Represents a type of product than is defined by its name, unit price and
 * number of items
 *
 * @author PRG
 * @version 1.0
 */
public class Product {

	/**
	 * Name of the product
	 */
	private String name;
	/**
	 * Price of each unit (Euro)
	 */
	private double price;
	/**
	 * Number of units available
	 */
	private int amount;

	/**
	 * Builds a type of product from its name, price and amount
	 *
	 * @param name   name of the product
	 * @param price  unit price in Euro
	 * @param amount number of available items
	 */
	public Product(String name, double price, int amount) {
		this.name = name;
		this.price = price;
		this.amount = amount;
	}

	/**
	 * Copy constructor - creates a clone of the product received as parameter
	 *
	 * @param anotherProduct product to be cloned
	 */
	public Product(Product anotherProduct) {
		this.name = anotherProduct.getName();
		this.price = anotherProduct.getPrice();
		this.amount = anotherProduct.getAmount();
	}

	/**
	 * Returns the name of the product
	 *
	 * @return name of the product
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Returns the unit price of the product
	 *
	 * @return unit price (Euro)
	 */
	public double getPrice() {
		return this.price;
	}

	/**
	 * Returns the amount of units available of this type of product
	 *
	 * @return units available
	 */
	public int getAmount() {
		return this.amount;
	}

	/**
	 * Checks if the actual product is the same one as the one received as parameter
	 * by comparing their names ignoring the case (lower or upper)
	 *
	 * @param anotherProduct product to be compared with the actual one
	 * @return true if the two products are the same one
	 */
	public boolean equals(Product anotherProduct) {
		return this.name.equalsIgnoreCase(anotherProduct.getName());
	}

	/**
	 * Checks if the actual product has the same name as the one received as
	 * parameter by comparing their names ignoring the case (lower or upper)
	 *
	 * @param name name of the type of product to be compared with the actual one
	 * @return true if the two products have the same name
	 */
	public boolean equals(String name) {
		return this.name.equalsIgnoreCase(name);
	}

	/**
	 * Checks if the name of the actual product is ordered alphabetically before the
	 * name received as parameter
	 *
	 * @param another name to be compared with the actual one
	 * @return true if the actual name is alphabetically ordered before the name
	 *         received as parameter and false if not
	 */
	public boolean isAlphabeticallyBefore(String another) {
		return this.name.toLowerCase().compareTo(another.toLowerCase()) < 0;
	}

	/**
	 * Checks if the name of the actual product is alphabetically ordered after the
	 * name received as parameter
	 *
	 * @param another name to be compared with the actual one
	 * @return true if the actual name is alphabetically ordered after the name
	 *         received as parameter and false if not
	 */
	public boolean isAlphabeticallyAfter(String another) {
		return name.toLowerCase().compareTo(another.toLowerCase()) > 0;
	}

	/**
	 * Checks if the name of the actual product is ordered alphabetically before the
	 * name of the product received as parameter
	 *
	 * @param anotherProduct product to be compared with the actual one
	 * @return true if the name of the actual product is alphabetically ordered
	 *         before the name of the product received as parameter and false if not
	 */
	public boolean isAlfabeticallyBefore(Product anotherProduct) {
		return name.toLowerCase().compareTo(anotherProduct.getName().toLowerCase()) < 0;
	}

	/**
	 * Checks if the name of the actual product is ordered alphabetically after the
	 * name of the product received as parameter
	 *
	 * @param anotherProduct product to be compared with the actual one
	 * @return true if the name of the actual product is alphabetically ordered
	 *         after the name of the product received as parameter and false if not
	 */
	public boolean isAlphabeticallyAfter(Product anotherProduct) {
		return name.toLowerCase().compareTo(anotherProduct.getName().toLowerCase()) > 0;
	}

	/**
	 * Returns the name of the type of product together with its unit price and
	 * amount of available units
	 */
	public String toString() {
		return "\t" + name + ":" + price + ":" + amount;
	}

}
