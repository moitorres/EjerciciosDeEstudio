/* Crea un metodo que reciva 2 char[] A y B, el A  es una palabra cualquiera
y el B es un conjunto de caracteres que tienes que remover de A.
Tienes que retornar la primera palabra A con puntos en los lugares en los que habia caracteres contenidos en B.

ejem:

A = programacion
B = arn

retornar = p.og..m.cio.
*/

public class removeChars{
	public static void main(String [] args){

		char[] a = {'p','r','o','g','r','a','m','a','c','i','o','n'};
		char[] b = {'a','r','n'};

		System.out.println(removeChars(a,b));

	}

	//Método que borra de un arreglo de chars las letras que se encuentren en otro arreglo de chars
	public static char[] removeChars (char[] a, char[] b) {

		boolean[] letters;
		int ascii;
		// LALO-COMENTARIO :) Buen uno de metodo aparte! muy bien
		letters = letterChecker(b);

		//Ciclo que revisa que letras del arreglo a se encuentran 
		for (int i = 0; i<a.length;i++){
			ascii = a[i];
			// LALO-COMENTARIO :) Deberias poner otro IF tal vez para que no se rompa si el ejemplo contiene un caracter que no sea letra
			if(ascii>=97){
				if (letters[ascii -97]) //Si la posicion del valor ascii - 97 en el arreglo de booleans es verdadero, eso es porque esa letra se encuentra en el arreglo b
					a[i] = '.';
			}

			else{
				if (letters[ascii -39]) //Si la posicion del valor ascii - 39 en el arreglo de booleans es verdadero, eso es porque esa letra se encuentra en el arreglo b
					a[i] = '.';
			}	

		}
		return a;
	}

	//Método que marca en un arreglo de booleans cuales son las letras que se encuentran en un arreglo de chars
	public static boolean[] letterChecker (char[] b){

		boolean[] letters = new boolean[52]; //Arreglo que representa el alfabeto, tanto las letras minusculas como mayusculas
		int ascii; //Int que se va a utilizar para guardar el valor ascii de cada caracter

		//Ciclo que marca en el arreglo letters cuales letras existen en el arreglo b
		for(int i=0; i<b.length;i++){
			// LALO-COMENTARIO :) La linea que sigue no es necesaria porque el casteo a int se hace automatico
			ascii = b[i]; //b[i] es la letra en la posición i, se convierte a su valor en ascii

			//Si el valor de ascii es mayor o igual a 97 es porque es una letra minuscula
			if(ascii>=97)
				// LALO-COMENTARIO :) Ejemplo del comentario anterior (puedes restarle directamente un entero a un caracter)
				letters[b[i] - 97] = true; //Se le resta 97 al valor ascii y el boolean en esa posición del arreglo se marca como true

			//Si es menor a 97 es una letra mayuscula. Las mayusculas se acomodan a partir de la posicion 26 en el arreglo de booleans
			else
				letters[ascii - 39] = true; //Se le resta 39 al valor ascii y el boolean en esa posición del arreglo se marca como true
		}

		return letters;
	}
	// LALO-COMENTARIO :) Muy bien hecho, ahora piensa como le harias si no solo fueran letras (el codigo seria mas sencillo)
}