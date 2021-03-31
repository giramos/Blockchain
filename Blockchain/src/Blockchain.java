/**
 * Germán Iglesias Ramos UO202549
 * 31/03/2021
 * Universidad de Oviedo 
 * Seguridad en Sistemas Informáticos (SSI)
 * Trabajo Grupal - Blockchain
 */

import java.util.ArrayList;
import java.util.List;

public class Blockchain {

	private List<Bloque> chain; // creamos una lista de bloques llamanada cadena "chain"

	public Blockchain() {
		chain = new ArrayList<Bloque>(); // definimos la cadena chain como un ArrayList
		chain.add(generarGenesis());// se genera el bloque Genesis
	}

	/**
	 * Metodo que crea el bloque Genesis. Este bloque es el primero que se crea en
	 * la cadena y no apunta a ningun bloque
	 * 
	 * @return el bolque Genesis
	 */
	private Bloque generarGenesis() {
		Bloque genesis = new Bloque("0x100", new java.util.Date(), "<Datos>"); // Creamos el objeto con los sguientes
																				// valores relevantes
		genesis.setHashPrevio(null); // no apunta a nadie
		genesis.calcularHash(); // calcula el hash propio
		return genesis;
	}

	/**
	 * Metodo que agrega bloques a nuestra cadena "chain"
	 * 
	 * @param bloque
	 */
	public void agregarBloque(Bloque bloque) {
		Bloque newBloque = bloque;
		newBloque.setHashPrevio(chain.get(chain.size() - 1).getHash()); // apunta al bloque (hash) anterior
		newBloque.calcularHash(); // calcula el hash propio
		this.chain.add(newBloque);
	}

	/**
	 * Método que nos muestra el contenido de nuestra cadena "chain" (la info de los
	 * bloques)
	 */
	public void mostrarChain() {
		// recorremos la cadena para imprimir los valores de cada bloque
		for (int i = 0; i < chain.size(); i++) {
			System.out.println("Bloque: " + i);
			System.out.println("Versión: " + chain.get(i).getVersion());
			System.out.println("Fecha: " + chain.get(i).getFecha());
			System.out.println("HashPrevio: " + chain.get(i).getHashPrevio());
			System.out.println("Hash: " + chain.get(i).getHash());

		}
	}

	/**
	 * Método que nos devuelve el bloque anterior de un bloque
	 */
	public Bloque getBloqueAnterior() {
		return this.chain.get(chain.size() - 1);
	}

	/**
	 * Método que verifica correctamente la validez de la cadena
	 */
	public void cadenaValida() {
		// recorremos la cadena
		for (int i = chain.size() - 1; i > 0; i--) {
			// comprueba que el calculo del hash del bloque actual es igual al hash
			// almacenado
			if (!(chain.get(i).getHash().equals(chain.get(i).calcularHash()))) {
				System.out.println("La cadena no es válida");
				return;// el return nos ayudad a salir del bloque for, si no sale del for la cadena es
						// valida
			}

			// comprueba el hash anterior almacenado del bloque actual es en realidad igual
			// al calculo
			// del hash del bloque anterior
			if (!(chain.get(i).getHashPrevio().equals(chain.get(i - 1).calcularHash()))) {
				System.out.println("La cadena no es válida");
				return;// el return nos ayudad a salir del bloque for, si no sale del for la cadena es
						// valida
			}
		}

		System.out.println("La cadena es válida");

	}
}
