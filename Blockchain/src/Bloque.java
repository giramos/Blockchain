
/**
 * Germán Iglesias Ramos UO202549
 * 31/03/2021
 * Universidad de Oviedo 
 * Seguridad en Sistemas Informáticos (SSI)
 * Trabajo Grupal - Blockchain
 */

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;

public class Bloque {

	// Informacion de las secciones del bloque

	private String hash; // propio hash
	private String hashPrevio; // anterior hash
	private String datos; // datos que contiene nuestro bloque (transacciones por ejemplo)
	private String version; // marca
	private Date fecha; // fecha

	public Bloque(String version, Date timestamp, String data) {
		this.version = version;
		this.fecha = timestamp;
		this.hash = calcularHash(); // calculamos el hash
	}

	/**
	 * Método que nos calcula el hash. Mismo procedimiento que nos podría resultar
	 * en la herramienta online (generadora de sha-256) citada en el trabajo:
	 * https://www.freeformatter.com/sha256-generator.html#sha256-explained
	 * 
	 * @return mensaje codificado
	 */
	public String calcularHash() {
		// datos del hash que vamos a calcular en cada bloque
		String dataHash = "" + this.version + this.fecha + this.hashPrevio + this.datos;

		MessageDigest resumen; // MessageDigest proporciona a las aplicaciones la funcionalidad de un algoritmo
								// de compendio de mensajes, como SHA-1 o SHA-256
		String codificado = null;

		try {
			resumen = MessageDigest.getInstance("SHA-256"); // el algoritmo se inicializa con el método estático
															// getInstance()
			byte[] hash = resumen.digest(dataHash.getBytes(StandardCharsets.UTF_8)); // calcular el resumen del mensaje
																						// de una entrada
			// y lo guarda en un array de bytes llamado hash
			codificado = Base64.getEncoder().encodeToString(hash); // codificamos el array
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		this.hash = codificado;
		return codificado; // devolvemos el hash codificado
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getHashPrevio() {
		return hashPrevio;
	}

	public void setHashPrevio(String hashPrevio) {
		this.hashPrevio = hashPrevio;
	}

	public String getDatos() {
		return datos;
	}

	public void setDatos(String datos) {
		this.datos = datos;
	}

}
