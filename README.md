# Blockchain
Programa de ejemplo en Java sobre la filosofía del blockchain
### Autor: Germán Iglesias Ramos UO202549

## Ejemplo en JAVA 

IDE: Eclipse 

Creamos un proyecto llamado Blockchain y le añadimos una clase Bloque que contendrá los siguientes apartados: 

![](https://github.com/giramos/Blockchain/blob/main/imagenes/Aspose.Words.2e0ccb9e-bfa9-407a-af90-e8d14ebe5aa8.001.png)

*Ilustración 1 Proyecto Blockchain* 

**Definición de bloque**. Bloque se puede dividir en dos secciones: un posible encabezado con información sobre el bloque, el bloque anterior o anteriores. La otra sección, “sección de datos” contiene información de transacciones (aunque no siempre se trata de transacciones). Ejemplo gráfico de cómo sería la estructura de los bloques, con algunos de los ítems que pueden llevar  

![](https://github.com/giramos/Blockchain/blob/main/imagenes/Aspose.Words.2e0ccb9e-bfa9-407a-af90-e8d14ebe5aa8.002.png)

*Ilustración 2 Definición de bloque* 

*Encabezado*: 

- Version (marca de versión) 
- Timestamp (cuando se creó el bloque hash) 
- Hash 
- PreviousHash 
- HasOfMerkelTree (subestructura central, llamada árbol de Merkle, que supone un resumen de todas las transacciones contenidas en el bloque) 
- Nonce (número arbitrario que se emplea en criptografía dentro de los denominados protocolos de autenticación. Va relacionado con el hash) 
- Other info 


En nuestro ejemplo definiremos alguna de esta información: 

![](https://github.com/giramos/Blockchain/blob/main/imagenes/Aspose.Words.2e0ccb9e-bfa9-407a-af90-e8d14ebe5aa8.003.png)

*Ilustración 3 Secciones de bloque* 

Posteriormente declararemos un constructor para iniciar nuestras variables y calcular el hash (para el cálculo del hash se proporciona una herramienta online que nos orientará en la definición de dicho término para poder seguidamente implementar su cálculo): 

![](https://github.com/giramos/Blockchain/blob/main/imagenes/Aspose.Words.2e0ccb9e-bfa9-407a-af90-e8d14ebe5aa8.004.png)

*Ilustración 4 Contructor Bloque* 

**Hashes**: funciones unidireccionales que toman unos datos y dan salida a otros datos, esta salida la llamaremos función hash resumen que utiliza una función sha-256 (función hash criptográfica).  

Generadora online de sha-256,[ https://www.freeformatter.com/sha256- generator.html#sha256-explained ](https://www.freeformatter.com/sha256-generator.html#sha256-explained) 

*SHA-256* es un algoritmo que se utiliza para calcular un valor hash en criptografía. La función hash toma un bloque de datos y devuelve una cadena de bits de tamaño fijo (valor hash). En el enlace anterior los datos utilizados por las funciones hash se denominan "mensaje", irían en esta sección: 

![](https://github.com/giramos/Blockchain/blob/main/imagenes/Aspose.Words.2e0ccb9e-bfa9-407a-af90-e8d14ebe5aa8.005.png)

*Ilustración 5 Generador hash con SHA-256 Generator* 

El valor hash calculado se denomina "resumen del mensaje" y nos saldría aquí: 

![](https://github.com/giramos/Blockchain/blob/main/imagenes/Aspose.Words.2e0ccb9e-bfa9-407a-af90-e8d14ebe5aa8.006.png)

*Ilustración 6 Hash generada* 

A la hora de calcular el hash se ha consultado varias páginas que nos instruyen en cómo calcular una función Hash SHA-256 y la codificación de cadenas, por ejemplo, utilizando Java Base64: 

![](https://github.com/giramos/Blockchain/blob/main/imagenes/Aspose.Words.2e0ccb9e-bfa9-407a-af90-e8d14ebe5aa8.007.png)

*Ilustración 7 Función para calcular Hash* 

Declaramos también en esta clase bloque todos los getters y setters de nuestros atributos para dar por concluida nuestra clase. 

El segundo paso será el de crear una clase Blockchain. Veamos la estructura de bloques que vamos a implementar:  

![](https://github.com/giramos/Blockchain/blob/main/imagenes/Aspose.Words.2e0ccb9e-bfa9-407a-af90-e8d14ebe5aa8.008.png)

*Ilustración 8 Estructura de bloques a implementar* 

Para crear nuestra clase Blockchain empezaremos por definir una lista de bloques 

![](https://github.com/giramos/Blockchain/blob/main/imagenes/Aspose.Words.2e0ccb9e-bfa9-407a-af90-e8d14ebe5aa8.009.png)

*Ilustración 9 Lista de bloques* 

El constructor no tendrá ningún parámetro pero si inicializaremos nuestra lista como un Array y después añadiremos a nuestra cadena un bloque denominado “Genesis”, que será el primer bloque de nuestra cadena. Este bloque “Genesis” es el inicial, por lo tanto, no tendrá ningún hash previo, es decir no apuntará a ningún otro bloque anterior ya que es el inicial, el genuino, el Génesis.  

![](https://github.com/giramos/Blockchain/blob/main/imagenes/Aspose.Words.2e0ccb9e-bfa9-407a-af90-e8d14ebe5aa8.010.png)

*Ilustración 10 Blockchain con lista de bloques* 

El método generarGenesis(), consistirá en la siguiente implementación (comentada): 

![](https://github.com/giramos/Blockchain/blob/main/imagenes/Aspose.Words.2e0ccb9e-bfa9-407a-af90-e8d14ebe5aa8.011.png)

*Ilustración 11 Método generarGenesis* 

Crearemos dos funciones/métodos más, uno para añadir bloques a nuestra cadena “chain” y otro que muestre la información de nuestra cadena. Véase en los siguientes fragmentos: 

![](https://github.com/giramos/Blockchain/blob/main/imagenes/Aspose.Words.2e0ccb9e-bfa9-407a-af90-e8d14ebe5aa8.012.png)

*Ilustración 12 Método para agregar bloque* 

![](https://github.com/giramos/Blockchain/blob/main/imagenes/Aspose.Words.2e0ccb9e-bfa9-407a-af90-e8d14ebe5aa8.013.png)

*Ilustración 13 Método mostrarChain* 

Por último, crearemos una clase de prueba, para probar el correcto funcionamiento de nuestro proyecto ejemplo de Blockchain. 

![](https://github.com/giramos/Blockchain/blob/main/imagenes/Aspose.Words.2e0ccb9e-bfa9-407a-af90-e8d14ebe5aa8.014.png)

*Ilustración 14 Clase de prueba* El resultado por consola es el siguiente: 

![](https://github.com/giramos/Blockchain/blob/main/imagenes/Aspose.Words.2e0ccb9e-bfa9-407a-af90-e8d14ebe5aa8.015.png)

*Ilustración 15 Salida prueba* 

Antes de dar por finalizado el ejemplo, probaremos qué sucederá si alteramos una de las funciones hash obtenidas previamente, para constatar que cualquier alteración romperá nuestra cadena y no se podrá dar por validez dicho proceso. Crearemos un método en la clase blockchain que nos dé el bloque antecesor de otro. 

![](https://github.com/giramos/Blockchain/blob/main/imagenes/Aspose.Words.2e0ccb9e-bfa9-407a-af90-e8d14ebe5aa8.016.png)

*Ilustración 16 Alteración función hash* 

Vamos pues, a alterar el último de los bloques agregados a nuestra cadena en la clase de pruebas de blockchain. 

![](https://github.com/giramos/Blockchain/blob/main/imagenes/Aspose.Words.2e0ccb9e-bfa9-407a-af90-e8d14ebe5aa8.017.png)

*Ilustración 17 Alteración último bloque* El resultado en la consola será el siguiente: 

![](https://github.com/giramos/Blockchain/blob/main/imagenes/Aspose.Words.2e0ccb9e-bfa9-407a-af90-e8d14ebe5aa8.018.png)

*Ilustración 18 Resultado modificando hash* 

Como se puede observar, el bloque tres no coincide su hash previo (“Germán”) con el hash del bloque dos (“fpTs…”) 

Para que nuestro ejemplo tenga cierto rigor y acciones como esta no sean posibles de hacer, necesitaremos crear en nuestro proyecto, más explícitamente en nuestra clase blockchain un método que nos valide si la cadena sufre alguna alteración como la acontecida o no. 

Comprobaremos que el hash de nuestro bloque actual es el mismo que el almacenado y también comprobaremos que el hash previo de nuestro bloque actual es el mismo que el hash del bloque anterior 

![](https://github.com/giramos/Blockchain/blob/main/imagenes/Aspose.Words.2e0ccb9e-bfa9-407a-af90-e8d14ebe5aa8.019.png)

*Ilustración 19 Método para comprobar validez de cadena* 

Para concluir comprobamos la validez en la clase de pruebas de nuestro proyecto. 

![](https://github.com/giramos/Blockchain/blob/main/imagenes/Aspose.Words.2e0ccb9e-bfa9-407a-af90-e8d14ebe5aa8.020.png)

*Ilustración 20 Insección de validación de cadena* 

La consola nos dice que no: 

![](https://github.com/giramos/Blockchain/blob/main/imagenes/Aspose.Words.2e0ccb9e-bfa9-407a-af90-e8d14ebe5aa8.021.png)

*Ilustración 21 Salida con validación de cadena* 

Si comentamos la anterior declaración que modifica el hash previo comprobamos si la cadena es válida: 

![](https://github.com/giramos/Blockchain/blob/main/imagenes/Aspose.Words.2e0ccb9e-bfa9-407a-af90-e8d14ebe5aa8.022.png)

*Ilustración 22 Comprobación con cadena válida y comprobándolo* 

![](https://github.com/giramos/Blockchain/blob/main/imagenes/Aspose.Words.2e0ccb9e-bfa9-407a-af90-e8d14ebe5aa8.023.png)

*Ilustración 23 Cadena comentada* 

![](https://github.com/giramos/Blockchain/blob/main/imagenes/Aspose.Words.2e0ccb9e-bfa9-407a-af90-e8d14ebe5aa8.024.png)

*Ilustración 24 Salida cadena válida con comprobación* 
PAGE8 
