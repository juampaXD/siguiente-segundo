package sgtesegenmain;

import java.util.Scanner;

public class SgteSegEnMain {

    private static int n, hh, mm, ss;
    static Scanner s;

    public static void main(String[] args) {
        //E: Entrada
        s = new Scanner(System.in);
        System.out.println("\t\t\t\tTIEMPO DEL SIGUIENTE SEGUNDO");
        System.out.print("Digite la cantidad de momentos o instantes del tiempo:\n");
        //Validación 1: momento o instante del tiempo
        ValidarMomento();

        for (int mom = 1; mom <= n; mom++) {
            System.out.println("\n\t\tMomento #" + mom + ":");
            System.out.println("Digite un tiempo en formato militar (hh:mm:ss)");
            System.out.print("\tHoras (entre 0 y 23):");
            hh = s.nextInt();
            //Validación 2: horas
            do {
                if (hh < 0 || hh > 23) {
                    System.out.println("\t\tError: las horas deben estar entre 0 y 23");
                    System.out.print("\tIngrese de nuevo la cantidad horas (entre 0 y 23):");
                    hh = s.nextInt();
                }
            } while (hh < 0 || hh > 23);
            System.out.println("\t\t\t\t\t\t¡Correcto!");
            System.out.print("\tMinutos (entre 0 y 59):");
            mm = s.nextInt();
            //Validación 3: minutos
            do {
                if (mm < 0 || mm > 59) {
                    System.out.println("\t\tError: los minutos deben estar entre 0 y 59");
                    System.out.print("\tIngrese de nuevo la cantidad minutos (entre 0 y 59):");
                    mm = s.nextInt();
                }
            } while (mm < 0 || mm > 59);
            System.out.println("\t\t\t\t\t\t¡Correcto!");
            System.out.print("\tSegundos (entre 0 y 59):");
            ss = s.nextInt();
            //Validación 4: segundos
            do {
                if (ss < 0 || ss > 59) {
                    System.out.println("\t\tError: los segundos deben estar entre 0 y 59");
                    System.out.println("\tIngrese de nuevo la cantidad segundos (entre 0 y 59):");
                    ss = s.nextInt();
                }
            } while (ss < 0 || ss > 59);
            System.out.println("\t\t\t\t\t\t¡Correcto!");
            Tiempodigitado();

            //P: Proceso
            //Ahora se procede a calcular el tiempo del siguiente segundo
            //Incrementar();
            Incrementar2();
            s.close();
            //S: Salida
            MostrarHora();
        }
        System.out.println("\n¡Gracias y hasta pronto!\n");
    }
    private static void ValidarMomento(){
        do {
            n = s.nextInt();
            if (n < 0) {
                System.out.println("\tError: el número debe ser positivo");
                System.out.print("Ingrese de nuevo la cantidad de momentos o instantes:\n");
                n = s.nextInt();
            }
        } while (n < 0);
        System.out.println("\t\t\t\t\t\t¡Correcto!");
    }
    private static void MostrarHora() {
        System.out.print("\nEl tiempo del siguiente segundo es: \n");
        /*if (hh < 10) {
            System.out.print("0" + hh + ":");
        } else {
            System.out.print(hh + ":");
        }
        if (mm < 10) {
            System.out.print("0" + mm + ":");
        } else {
            System.out.print(mm + ":");
        }
        if (ss < 10) {
            System.out.print("0" + ss);
        } else {
            System.out.print(ss);
        }*/
        System.out.print(AjustarFormato(hh) + ":" + AjustarFormato(mm) + ":" + AjustarFormato(ss));
    }

    private static String AjustarFormato(int x) {
        try {
            if (x < 10) {
                return ("0" + x);
            } else {
                return String.valueOf(x);
                //return Integer.toString(x);
            }
        } catch (Exception e) {
            return "Error " + e.getMessage();
        }
    }

    private static void Tiempodigitado() {
        System.out.println("El tiempo digitado fue:");
        /*if (hh < 10) {
            System.out.print("0" + hh + ':');
        } else {
            System.out.print(hh + ":");
        }
        if (mm < 10) {
            System.out.print("0" + mm + ':');
        } else {
            System.out.print(mm + ':');
        }

        if (ss < 10) {
            System.out.print("0" + ss);
        } else {
            System.out.print(ss);
        }*/
        System.out.print(AjustarFormato(hh) + ":" + AjustarFormato(mm) + ":" + AjustarFormato(ss));
    }

    private static void Incrementar() {
        if (ss < 59) {
            ss++;
        } else {
            ss = 0;
            if (mm < 59) {
                mm++;
            } else {
                mm = 0;
                if (hh < 23) {
                    hh++;
                } else {
                    hh = 0;
                }
            }
        }
    }

    private static void Incrementar2() {
        if (ss < 59) {//Cuando se declara el int por defecto inicia en 0
            ss++;
        } else {
            if (mm < 59) {
                mm++;
            } else {
                if (hh < 23) {
                    hh++;
                }
            }
        }
    }
}