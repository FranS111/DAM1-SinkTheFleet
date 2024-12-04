import java.util.Random;
import java.util.Scanner;

public class Examen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String matrix[][];
		matrix = new String[10][10];
		String barco = "SHIP";
		boolean game = true;
		// Inicio la fila para que el while de mas adelante se active
		int fila = 15, columna = 15;
		String tocado = "TOCA";
		int existe = 0;

		// Creamos el Tablero y lo rellenamos con Agua en cada una de las posiciones de
		// la matriz
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = "AGUA";
			}
		}
		// Creamos el scanner y preguntamos la orientacion de los barcos
		Scanner sc = new Scanner(System.in);
		System.out.println("Indique la orientación de los barcos");
		String orien = sc.next();
		Random rd = new Random();
		orien = orien.toUpperCase();
		char orientacion = orien.charAt(0);

		// Para difrenciar entre orientaciones lo que cambiara entre las dos es que
		// generara los barcos de izquierda a derecha y de arriba abajo. Sin dejarle que
		// pueda generar uno
		// que empiece en la ultima fila para asi no caer en out of bounds.

		if (orientacion == 'H') {
			for (int i = 0; i < 4; i++) {
				int coord_x = rd.nextInt(9);
				int coord_y = rd.nextInt(10);

				if (matrix[coord_y][coord_x] != barco) {
					matrix[coord_y][coord_x] = barco;
					matrix[coord_y][coord_x + 1] = barco;

				} else {
					i--;
				}
			}

		}
		if (orientacion == 'V') {
			for (int i = 0; i < 4; i++) {
				int coord_x = rd.nextInt(10);
				int coord_y = rd.nextInt(9);
				// Aqui introducimos el barco en la coordenada si esta no tiene ya un barco dentro

				if (matrix[coord_y][coord_x] != barco) {
					matrix[coord_y][coord_x] = barco;
					matrix[coord_y + 1][coord_x] = barco;
					// Si tiene un barco dentro restaremos i-- para que el for pueda dar una vuelta
					// mas y siempre se generen 4 barcos sin importar si se ha generado uno repetido
				} else {
					i--;
				}
			}
		}

		// la variable game hasta que no sea false el juego seguira
		while (game) {
			existe = 0;
			// Crearemos este while para poder repetir la pregunta si el usuario responde
			// con un valor que no esta entre el 0 y 10 o ha introducido una casilla tocada.
			while (fila > 10 || fila < 1 || columna > 10 || columna < 1 || matrix[fila - 1][columna - 1] == tocado) {
				System.out.println("Indique la coordenada que desea bombardear: (Primero fila y despues columna)");
				fila = sc.nextInt();
				columna = sc.nextInt();
			}
			// Usaremos esto para pasar el input a nuestro sistema de array que en vez de ir
			// de 1 a 10 va de 0 a 9.
			fila = fila - 1;
			columna = columna - 1;

			// Aqui comprobaremos si la coordenada introducida coincide con barco o agua
			// para mostrar el resultado por consola
			if (matrix[fila][columna] == barco) {

				System.out.println("- - - - - - Tocado! - - - - - -");
				matrix[fila][columna] = tocado;

			} else {
				System.out.println("- - - - - - Agua! - - - - - -");
			}

			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix.length; j++) {

					System.out.print(matrix[i][j] + "    ");
				}
				System.out.print("\n");
			}
			// Vuelvo a poner esto para que el while que pide el input se vuelva a iniciar
			fila = 15;
			columna = 15;
			// Basicamente aqui compruebo si existe algun barco en el tablero, revisando
			// todas las casillas, si no lo hay game será false.
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix.length; j++) {
					if (matrix[i][j] == barco) {
						existe++;
						game = true;
					}
				}
				if (existe == 0) {
					game = false;
				}
			}

		}
		System.out.println(" ---------------------------");
		System.out.println(" >>>>> JUEGO TERMINADO <<<<<");
		System.out.println(" ---------------------------");

	}

}
