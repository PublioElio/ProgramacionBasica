package programacion_basica;

/* hay que importar Scanner porque lo vamos a utilizar para leer la entrada 
de teclado desde la terminal*/
import java.util.Scanner;

/**
 * Este programa es un ejemplo de la Actividad de aprendizaje: Programación
 * Básica, del curso Análisis y Programación en Java. En ella hay que solicitar
 * al usuario dos números, realizar una suma, resta, producto y división con
 * estos números y, además, controlar los errores en caso de que se introduzca
 * un cero como divisor. Por último, debemos crear un array de enteros y
 * mostrarlo por pantalla.
 *
 * @author Adriano Díaz Benítez
 */
public class ProgramacionBasica {

    public static void main(String[] args) {
        int numero1, numero2, resultado; // declaramos las variables
        double resultadoDivision; // la división puede dar decimales, así que la definimos como double
        int[] array = {0, 1, 42}; // declaramos e inicializamos un array para mostrarlo al final

        /* inicializamos las variables llamando a una función con la que 
        obtendremos un número entero positivo */
        numero1 = pedir_numero();
        numero2 = pedir_numero();

        /* hacemos la primera operación, guardamos el resultado y lo mostramos 
        por la terminal */
        resultado = numero1 + numero2;
        System.out.printf("La suma de los dos números es %d\n",
                resultado);

        /* Hacemos lo propio con la resta, sobreescribiendo el valor de 
        la variable resultado */
        resultado = numero1 - numero2;
        System.out.printf("La resta de los dos números es %d\n",
                resultado);

        resultado = numero1 * numero2;
        System.out.printf("La multiplicación de los dos números es %d\n",
                resultado);

        /* Ahora vamos a realizar la división, aquí hay que controlar si el 
        divisor es cero y, además castear los números introducidos por el 
        usuario para guardarlos en la variable resultadoDivision */
        try {
            if (numero2 == 0) {
                throw new ArithmeticException();
            }
        } catch (ArithmeticException error) {
            System.out.println("¡Es imposible hacer una división por cero!");
            do {
                numero2 = pedir_numero();
            } while (numero2 < 1);
        } finally {
            resultadoDivision = (double) numero1 / (double) numero2;
            System.out.printf("La división de los dos números es %,.2f\n",
                    resultadoDivision);
        }

        /* Ahora vamos a mostrar el array que hemos inicializado antes, para
        ello vamos a usar un bucle for */
        System.out.print("Contenido del array de números enteros: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    /**
     * Esta función pide por teclado un número entero positivo, hasta que el
     * usuario no lo introduce, no le deja continuar
     *
     * @return el número entero positivo
     */
    static int pedir_numero() {
        int numero;
        boolean numeroValido;
        /* creamos un objeto del tipo Scanner, porque vamos a pedir al usuario 
        algo por teclado */
        Scanner sc = new Scanner(System.in);

        /* con el siguiente bucle nos aseguramos que el usuario introduzca un 
        número entero positivo */
        do {
            System.out.print("Introduzca un número entero positivo: ");
            numero = sc.nextInt();
            numeroValido = (numero >= 0); // es válido si es mayor de cero
            if (!numeroValido) { // si no es valido, mostramos el siguiente mensaje
                System.out.print("ERROR: ese número no es válido. ");
            }
        } while (!numeroValido);

        return (numero);
    }
}
