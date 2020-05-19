package menu;

import beans.Comentario;
import beans.Compra;
import java.util.Scanner;

/**
 *
 * @author daniel migales puertas
 *
 */
public class Main {

    public static void main(String[] args) {

        menuPrincipal();

    }

    public static void menuPrincipal() {

        Scanner entrada = new Scanner(System.in);
        int seleccion;
        boolean salir = true;

        do {
            System.out.println("\n*************MENU PRINCIPAL *************\n");
            System.out.println("1. REALIZAR UNA COMPRA");
            System.out.println("2. SALIR DEL PROGRAMA");
            System.out.println("\n******************************************\n");
            System.out.println("Seleccione una opcion:");
            seleccion = entrada.nextInt();
            System.out.println("\n");
            System.out.println("\n******************************************\n");

            switch (seleccion) {

                case 1:
                    realizarCompra();
                    break;
                case 2:
                    salir = false;
                    break;
            }
        } while (salir);
    }

    public static void realizarCompra() {

        Scanner entradaLetra = new Scanner(System.in);

        System.out.println("Dame el Articulo");
        String articulo = entradaLetra.nextLine();
        System.out.println("Dame el Comentario");
        String comentarioUsuario = entradaLetra.nextLine();
        System.out.println("Dame el Usuario");
        String usuario = entradaLetra.nextLine();

        //este es el objeto que interesa crear para poder operar con el bean.
        Comentario comentario = new Comentario(comentarioUsuario);

        Compra compra = new Compra();
        compra.setComentario(comentario);
        comentario.addPropertyChangeListener(compra);//Aviso de que esta accion puede generar un cambio     
        comentario.setComentario(comentarioUsuario);

        System.out.printf("COMPRA REALIZADA: " + usuario + " Has comprado: " + articulo + " y has comentado: "
                + comentarioUsuario + "\n");

    }

}
