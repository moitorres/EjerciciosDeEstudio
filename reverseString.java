
public class reverseString{

	public static void main(String [] args){

		/*char[] palabra = {'p','e','r','r','o'};
		System.out.println(reversePalabra(palabra));*/

		char[] oracion = {'i','.','l','i','k','e','.','t','h','i','s','.','p','r','o','g','r','a','m','.','v','e','r','y','.','m','u','c','h'};
		System.out.println(reverseString(oracion));

	}

	//Método que voltea un arreglo de chars en el que se encuentra una oracion con más de una palabra
	public static char[] reverseString (char[] oracion){

		oracion = reversePalabra(oracion,0,oracion.length); //Se voltea el arreglo por completo

		int x1=0, x2; //x1 empieza siendo 0 para marcar la primera posicion del arreglo

		for(int i=0; i<oracion.length;i++){

			if(oracion[i] =='.'){

				x2=i; //En x2 se guarda el valor de la posicion donde está el punto 
				oracion = reversePalabra(oracion,x1,x2); //Se manda a llamar el método para que voltee la palabra, empezando en la posicion x1  del arregloy terminando en x2
				x1=i+1; //x1 es reemplazada con el valor que esté un indice después del punto

			}

		}

		//Se manda a llamar el método una última vez para voltear la ultima palabra del arreglo (ya que ésta no termina en punto y el ciclo no la detecta)
		oracion = reversePalabra(oracion,x1,oracion.length-1);

		return oracion;
	}

	//Método que voltea un arreglo de chars en el que solo se encuentra una palabra
	public static char[] reversePalabra (char [] palabra, int x1, int x2){

		char c;
		int cont=0; //Se utiliza un contador porque hace falta una variable que cuente cuantas veces se ha repetido el ciclo y "i" no siempre va a empezar en 0

		//El ciclo empieza en x1 y termina a la mitad entre x1 y x2
		for (int i=x1; i < (x1+((x2-x1)/2)) ; i++){

			c = palabra[i]; //Se guarda la letra actual en una variable temporal para poder reemplazarla
			palabra[i] = palabra[x2-1-cont]; // Se reemplaza la letra actual por la letra opuesta
			palabra[x2-1-cont] = c; // La letra opuesta es reemplazada por la variable tamporal

			cont+=1;
		}

		return palabra;
	}

} 