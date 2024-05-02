package primero;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Main {
	
	public final static String TEXTO_A_CIFRAR="Este es el texto que se va a cifrar y descifrar!!!.";

	public static void main(String[] args) {
		
		String usuario, pass;
		
		SecretKey llave;
		
		byte[] byteGenerados; 
		
		
		
		Scanner scanner = new Scanner(System.in);
		
			System.out.println("Introduzca el usuario: ");
		
		usuario=scanner.nextLine();
		
			System.out.println("Introduzca la contraseña: ");
		
		pass=scanner.nextLine();
		
		//voy a usar un cifrado simetrico, una llave, con ella se aplicara el algoritmo de cifrado.
		
		byteGenerados=obtenKey(usuario, pass);
		
		llave=cifrarTexto(TEXTO_A_CIFRAR, byteGenerados);
		
		leeDesencriptaMuestraTexto(llave);
		
		
		scanner.close();

	}

	private static void leeDesencriptaMuestraTexto(SecretKey llave) {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("fichero.cifrado"));
			String textoEncriptado = reader.readLine();
			byte[] bitesCifrados= Base64.getDecoder().decode(textoEncriptado);
			
			Cipher desencriptador =Cipher.getInstance("Rijndael/ECB/PKCS5Padding");
			desencriptador.init(Cipher.DECRYPT_MODE, llave);
			byte[] bitesDescifrados = desencriptador.doFinal(bitesCifrados);
			
			String textoDesincriptado = new String(bitesDescifrados);
			
			System.out.println("Texto desencriptado:");
            System.out.println(textoDesincriptado);
            
            reader.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra el archivo");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("No se pudo leer el archivo");

			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			System.out.println("No se pudo aplicar el algoritmo de descifrado");

			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			System.out.println("Llave no válida para desincriptar el fichero");
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			System.out.println("No se pudo pasar de bytes encriptados a bytes desincriptados");

			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static SecretKey cifrarTexto(String textoNoCifrado, byte[] byteGenerados) {
		
		SecretKey llavePrivada=null;
		
		try {
			
			Cipher encript = Cipher.getInstance("Rijndael/ECB/PKCS5Padding");
			 llavePrivada = new SecretKeySpec(byteGenerados,"Rijndael");// se instancia una clave privada a partir de bytes generados 
			encript.init(Cipher.ENCRYPT_MODE, llavePrivada);// se establece la llave privada y modo encriptacion
			//paso el texto a bytes
			byte[] byteTexto = textoNoCifrado.getBytes();
			//cifro con doFinal el array de bytes
			byte[] byteTextoCifrado = encript.doFinal(byteTexto);
			//bytes a char
			String texto = Base64.getEncoder().encodeToString(byteTextoCifrado);
			
			System.out.println("\nEl texto cifrado:\n"+texto);
			
			generaFichero(texto);
			
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			System.out.println("No se pudo encriptar el texto");
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return llavePrivada;
	}

	private static void generaFichero(String texto) {
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("fichero.cifrado"));
			writer.write(texto);
            System.out.println("Texto encriptado guardado en 'fichero.cifrado.txt.'");

			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static byte[] obtenKey(String usuario, String pass) {
		//array de byte de 128 bits
		byte[] bitsKey = new byte[16];
		
		String sinCifrar=usuario+pass;
		//sera la semilla
		byte[] bytsSinCifrar=sinCifrar.getBytes();
		
		System.out.println("Estos son los byts de usuario + contraseña:");
		
			for (int i=0;i<bytsSinCifrar.length;i++) {System.out.print(bytsSinCifrar[i]+" ");}
		
		SecureRandom secureRandom;
			try {
				
				secureRandom = SecureRandom.getInstance("SHA1PRNG");
				
				secureRandom.setSeed(bytsSinCifrar);
				secureRandom.nextBytes(bitsKey);//se llena array con el tamaño instanciado del array(16byts)
				
				System.out.println("\nEstos son los byts generados de forma segura a partir de la semilla de usuario + contraseña:");
					for(int i=0;i<bitsKey.length;i++) {
						System.out.print(bitsKey[i]+" ");
					}
				
			} catch (NoSuchAlgorithmException e) {
				
				e.printStackTrace();
				return null;
				
			}
		
		return bitsKey;
			
	}

}
