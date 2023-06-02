/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab7p1_nahimhilsaca;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author nahim
 */
public class Lab7P1_NahimHilsaca {

    /**
     * @param args the command line arguments
     */
    static Scanner leer = new Scanner(System.in);// Variable global del Scanner
    static Random rng = new Random();// Variable global del Random
    static int acum1 = 0;
    static int acum2 = 0;
    public static void main(String[] args) {

        int opcion = 0;

        while (opcion != 3) {

            System.out.println(" Menu");
            System.out.println("1. She Shoot, she Scores! ");
            System.out.println("2. Piedra, Papel O.... ");
            System.out.println("3. Salir");
            opcion = leer.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("----Tablero de Jugar-----");
                    System.out.println();
                    System.out.println("Ingrese numero de filas: ");
                    int filas = leer.nextInt();
                    System.out.println("Ingrese numero de columnas: ");
                    int columnas = leer.nextInt();

                    while (filas * columnas == 88 || filas * columnas == 99) {

                        System.out.println("No puede meter variables cuya multiplicacion sea 88 o 99");
                        System.out.println("Ingrese numero de filas: ");
                        filas = leer.nextInt();
                        System.out.println("Ingrese numero de columnas: ");
                        columnas = leer.nextInt();

                    }// Fin del while
                    System.out.println("Cuantas balas quiere disparar? ");
                    int balas=leer.nextInt();
                    
                    while( balas==((filas*columnas)/2)){
                        System.out.println("Sus balas no pueden ser la multiplicacion de filas por columnas entre 2");
                    System.out.println("Cuantas balas quiere disparar? ");
                    balas=leer.nextInt();
                    }
                    int[][] num = new int[filas][columnas];
                    num = lectura(filas, columnas);
                    print(num);
                    
                    int balas2=balas;
                    
                    while(balas>0){
                    
                        System.out.println("Elige que numero disparar Jugador 1");
                        int opcion1=leer.nextInt();
                        
                        num=matriz_99(num, opcion1);
                        print(num);
                        
                        System.out.println("Le quedan "+balas + " balas" );
                        System.out.println("Elige que numero disparar Jugador 2");
                        int opcion2=leer.nextInt();
                    
                        num=matriz_88(num,opcion2);
                        print(num);
                    
                        System.out.println("Le quedan"+ balas + " balas");
                    
                        balas--;
                    }// Fin del while
                    
                    if( acum1>acum2){
                    
                        System.out.println("Jugador 1 ha ganado con "+ acum1);
                        System.out.println("Jugador 2 ha perdido con "+ acum2);
                    }else if( acum1<acum2){
                    
                        System.out.println("Jugador 2 ha ganaado con "+acum2);
                        System.out.println("Jugador 1 ha perdido con "+acum1);
                    
                    }else if(acum1==acum2){
                    
                        System.out.println("EMPATE!");
                    
                    }
                    break;

                case 2:
                     
                        
                        System.out.println("Elija que quiere usar: ");   
                        int humano=leer.nextInt();
                        
                        System.out.println("Spock=1");
                        System.out.println("Lizard=2");
                        System.out.println("Rock=3");
                        System.out.println("Paper=4");
                        System.out.println("Scissors=5");
                        
                        int maquina=rng.nextInt(6)+1;
                        
                        System.out.println("La maquina eligic: "+maquina);
                        
                        if( humano>maquina){
                        
                            System.out.println("El jugador gano");
                        
                        }else if( maquina>humano){
                        
                            System.out.println("La maquina gano");
                        
                        }else if( maquina==humano){
                        
                            System.out.println("Empate");
                      
                        
                    }     
                    break;

                    
                    
                    case 3:
                    System.out.println("Ha Salido del Menu");
                    break;

                default:

                    System.out.println("Opcion incorrecta. Debe elegir de las opciones dadas");

                    break;

            }// Fin del switch

            System.out.println("Desea continuar? Si no lo desea, presione 3");
            opcion = leer.nextInt();

        }// Fin del while
    }// Fin del metodo main

    public static void print(int[][] matriz) {

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                System.out.print("[" + matriz[i][j] + "]");

            }// Fin del for interno
            System.out.println();

        }// Fin del for externo

    }// Fin del metodo print

    public static int[][] lectura(int f, int c) {// f para filas, c para columnas

        int[][] temporal = new int[f][c];
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                int random = rng.nextInt(f * c) + 1;
                while (revisar_Repetidos(temporal,random)) {
                     random = rng.nextInt(f * c) + 1;   
                }// Fin del while
                    temporal[i][j]=random;
            }// Fin del for interno
        }// Fin del for externo
        return temporal;
    }// Fin del metodo lectura

    public static boolean revisar_Repetidos(int[][] matriz, int repetido) {
        boolean repe=false;
        for (int k = 0; k < matriz.length; k++) {
            for (int y = 0; y <matriz[k].length; y++) {
                if(repetido == matriz[k][y]){
                    repe=true;
                }
                //1 es conocido como el valor de desplazamiento
            }// Fin del for k
        }// Fin del for y
        return repe;
    }// Fin del metodo revisar_Repetidos
    
   public static int [][] matriz_99(int [][] matriz, int numero){
        boolean acierto=false;
     for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                if(matriz[i][j]==numero){
                    acierto=true;
                     System.out.println("Tiro acertado!");
                     acum1+=numero;
                matriz[i][j]=99;
                break;
                }
                    
            }// Fin del for interno

        }// Fin del for externo
     
     if( acierto==false){
     
         System.out.println("Fallaste!");
     
         acum2=0;
     }

   return matriz;
   }// Fin del metodo matriz_99
   
    public static int [][] matriz_88(int [][] matriz, int numero){
       boolean acierto=false;
     for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                if(matriz[i][j]==numero){
                    acierto=true;
                    System.out.println("Tiro acertado!");
                matriz[i][j]=88;
                    acum2+=numero;
                
                break;
                }
                    
            }// Fin del for interno

        }// Fin del for externo
     
     if( acierto==false){
     
         System.out.println("Fallaste!");
     
            acum2=0;
     }
            
   return matriz;
    }// Fin del metodo matriz_88
   
    public static boolean acierto (int [][] matriz, int acierto){
    boolean resp=false;
    
    for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                if(matriz[i][j]==acierto){
                    resp=true;
                }
            }
    
    }// Fin del metodo acierto
    return resp;
    
    }// Fin del metodo acierto
    
   public static int [][] Juego(){
   
   int [][] matriz= {{0,-2,1,1,-2},{1,0,-2,-2,1},{-2,1,0,1,-2},{-2,1,-2,0,1},{1,-2,1,1,0}};
   
   
   return matriz;
   }
   
}// Fin de la clase
