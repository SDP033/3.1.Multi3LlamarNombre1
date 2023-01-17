package llamarNombre;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Llamada {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dime un numero entero positivo para ejecutar el programa");
		
		String numero = sc.nextLine();

		File directorio = new File("C:\\Users\\sergi\\eclipse-workspace\\3.1Multi3CrearNombre1\\bin");

		ProcessBuilder pb = new ProcessBuilder("java.exe", "crearNombre1.Nombre", numero);

		pb.directory(directorio);

		

		Process p = pb.start();
		int salida = -1;
		try {
			salida = p.waitFor();
			System.out.println("Valor de Salida: " + salida);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (salida == 0) {
			try {

				InputStream is = p.getInputStream();

				int c;
				while ((c = is.read()) != -1)
					System.out.print((char) c);
				is.close();
				System.exit(0);

			} catch (Exception e) {
				System.exit(-1);
				e.printStackTrace();
			}
		}sc.close();
	}
}
