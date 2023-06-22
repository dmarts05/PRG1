package es.unileon.prg1.agregados;

/**
 * Class to test the operation of the supermarket
 *
 * @author PRG
 * @version 1.0
 */
class MainSupermarket2 {
	public static void main(String args[]) {
		Supermarket supermarket;
		supermarket = new Supermarket("Galenas");
		try {
			supermarket.add(new Product("libreta", 3.5, 10));
			supermarket.add(new Product("lapiz", 1.0, 100));
			supermarket.add(new Product("papel", 2, 50));
			supermarket.add(new Product("goma", 0.5, 60));
			supermarket.add(new Product("carpeta", 1.5, 200));
			supermarket.add(new Product("calendario", 1.8, 40));
			supermarket.add(new Product("rotulador", 0.4, 150));
			supermarket.add(new Product("tiza", 0.1, 90));
			supermarket.add(new Product("borrador", 2.0, 30));
			supermarket.add(new Product("dvd", 0.10, 500));
			supermarket.add(new Product("toner", 100.0, 10));
		} catch (StoreException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Buscar dvd: " + supermarket.search("dvd"));
		System.out.println("Buscar toner: " + supermarket.search("toner"));		
		System.out.print(supermarket);
	}
}
