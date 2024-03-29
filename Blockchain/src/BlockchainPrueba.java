/**
 * Germ�n Iglesias Ramos UO202549
 * 31/03/2021
 * Universidad de Oviedo 
 * Seguridad en Sistemas Inform�ticos (SSI)
 * Trabajo Grupal - Blockchain
 */
public class BlockchainPrueba {

	public static void main(String args[]) {
		
		Blockchain prueba = new Blockchain(); // creamos un objeto Blockchain llamado prueba
		
		// creamos tres bloques (uno, dos y tres)
		Bloque uno = new Bloque("0x100", new java.util.Date(), "<Datos>" );
		Bloque dos = new Bloque("0x100", new java.util.Date(), "<Datos>" );
		Bloque tres = new Bloque("0x100", new java.util.Date(), "<Datos>" );

		// agregamos a nuestro cadena blockchain los bloques
		prueba.agregarBloque(uno);
		prueba.agregarBloque(dos);
		prueba.agregarBloque(tres);
		
		//prueba.getBloqueAnterior().setHashPrevio("Germ�n"); // alterar el �ltimo bloque (Bloque tres)
		
		// mostramos por consola
		prueba.mostrarChain();
		
		// comporbamos la validez
		prueba.cadenaValida();
	}
}
