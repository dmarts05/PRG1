package es.unileon.prg1.agregados;

/**
 * Class to test the operation of the supermarket
 *
 * @author PRG
 * @version 1.0
 */
class MainSupermarket1 {
	public static void main(String args[]) {
		Supermarket supermarket;
		supermarket = new Supermarket("Galenas");
		try {
			supermarket.add(new Product("libreta", 3.5, 10));
			supermarket.add(new Product("lapiz", 1.0, 100));
			supermarket.add(new Product("lapiz", 1.0, 100));
		} catch (StoreException e) {
			System.out.println(e.getMessage());
		}
		System.out.print(supermarket);
	}
}
