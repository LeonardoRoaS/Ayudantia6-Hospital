//Leonardo Roa

import java.util.Random;
import java.util.Scanner;
public class Ayudantia5 {

    public static void main ( String [] args ){

        Ahorcado();

    }

    public static void Ahorcado(){

        String palabra = ElegirPalabraAzar();
        char [] oculta = DescomponerPalabra(palabra);
        char [] palabraChar = DescomponerPalabra(palabra);
        oculta = OcultarPalabra(oculta);
        int fallidos = 0;
        int aciertosTotales = 0;
        while ((fallidos < 10) && (aciertosTotales != palabraChar.length)) {
            System.out.println("Adivina la palabra!");
            System.out.println(oculta);
            char letra = IngresarLetra();
            int aciertos = Adivinar(palabraChar, letra, oculta);
            System.out.println(" ");


            aciertosTotales = aciertosTotales + aciertos;
            if (aciertosTotales == aciertosTotales - aciertos) {
                fallidos++;
            }
            System.out.println("Aciertos: "+aciertosTotales+". Fallidos: "+fallidos);
        }
        if ((fallidos == 10)) {
            System.out.println("Has perdido. La palabra era: "+palabra);
        }
        else {
            System.out.println("Felicidades, has ganado! La palabra era: " + palabra);
        }
    }

    public static char [] OcultarPalabra (char [] palabraOculta){
        for(int i = 0; i < palabraOculta.length; i++){
            palabraOculta[i] = '_';
        }
        return palabraOculta;
    }

    public static String ElegirPalabraAzar(){

        Random random = new Random();

        String [] palabras = {"terremoto", "helado", "cafetera", "celular", "mochila", "edificio", "nube", "insecto", "universidad", "espejo"};
        int azar = random.nextInt(10);
        System.out.println(palabras[azar]);
        return palabras[azar];
    }

    public static char IngresarLetra() {

        Scanner leer = new Scanner(System.in);
        char letra = 0;

        // Ingreso y validacion de la letra para adivinar
        while (!((letra >= 'a' && letra <= 'z')) ){
            System.out.println("Ingrese una letra.");
            letra = leer.next().toLowerCase().charAt(0);
            if (!((letra >= 'a' && letra <= 'z'))){
                System.out.println("ERROR: Sólo debe ingresar letras.");
            }
        }


        return letra;
    }

    public static char [] DescomponerPalabra(String palabra){
        //Descomponer la palabra en un arreglo char para hacer funcionar el juego
        char [] letras;
        letras = new char [palabra.length()];
        for(int i = 0; i < palabra.length(); i++){
            letras [i] = palabra.charAt(i);
        }
        return letras;
    }

    public static int Adivinar(char [] palabra, char letra, char [] palabraoculta) {


        int aciertos = 0;
        for (int x = 0; x<palabra.length; x++){

            if(palabra[x]==letra){
                palabraoculta[x] = palabra[x];
                palabra[x] = ' ';
                aciertos++;
            }

        }
        return aciertos;
    }

}
