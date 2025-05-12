package cl.conversor;

import cl.conversor.modelos.ConsultaApi;
import cl.conversor.modelos.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        LocalDate fecha = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFormateada = fecha.format(formato);
        Scanner escribirOpciones = new Scanner(System.in);

        List<Service> services = new ArrayList<>();
        while (true){
            Service service = new Service();
            System.out.println("=================================================");
            System.out.println("      Bienvenido al conversor de monedas  ");
            System.out.println("=================================================\n");
            System.out.println("      Eliga una opción\n");
            System.out.println("=================================================\n");
            System.out.println("1- convertir de Dolar a pesos Chileno CLP");
            System.out.println("2- convertir de pesos Chileno CLP a Dolar");
            System.out.println("3- Convertir de Dolar a pesos Argentino ARS");
            System.out.println("4- convertir de pesos Argentino ARS a Dolar");
            System.out.println("5- convertir de Dolar a Reales Braselileño BRL");
            System.out.println("6- convertir de Reales Brasileñoas BRL a Dolar");
            System.out.println("7- convertir de Dolar a Soles Peruano SOL");
            System.out.println("8- convertir de Soles Peruanos SOL a Dolar");
            System.out.println("9- Ver historial");
            System.out.println("10- salir");
            System.out.println("=================================================");

            var ingresoOpciones = escribirOpciones.nextInt();
            double monto;

            if (ingresoOpciones == 10){
                break;
            }

            
            switch (ingresoOpciones){
                case 1:
                    System.out.println("Escribe el monto a convertir:");
                    monto = escribirOpciones.nextDouble();
                    service.convertir("USD", "CLP", monto);
                    services.add(service);
                    break;
                case 2:
                    System.out.println("Escribe el monto a convertir:");
                    monto = escribirOpciones.nextDouble();
                    service.convertir("CLP", "USD", monto);
                    services.add(service);
                    break;
                case 3:
                    System.out.println("Escribe el monto a convertir:");
                    monto = escribirOpciones.nextDouble();
                    service.convertir("USD", "ARS", monto);
                    services.add(service);
                    break;
                case 4:
                    System.out.println("Escribe el monto a convertir:");
                    monto = escribirOpciones.nextDouble();
                    service.convertir("ARS", "USD", monto);
                    services.add(service);
                    break;
                case 5:
                    System.out.println("Escribe el monto a convertir:");
                    monto = escribirOpciones.nextDouble();
                    service.convertir("USD", "BRL", monto);
                    services.add(service);
                    break;
                case 6:
                    System.out.println("Escribe el monto a convertir:");
                    monto = escribirOpciones.nextDouble();
                    service.convertir("BRL", "USD", monto);
                    services.add(service);
                    break;
                case 7:
                    System.out.println("Escribe el monto a convertir:");
                    monto = escribirOpciones.nextDouble();
                    service.convertir("USD", "PEN", monto);
                    services.add(service);
                    break;
                case 8:
                    System.out.println("Escribe el monto a convertir:");
                    monto = escribirOpciones.nextDouble();
                    service.convertir("PEN", "USD", monto);
                    services.add(service);
                    break;
                case 9:
                    System.out.println("\n=== Historial de conversiones ===");
                    System.out.println("\n Fecha de la conversiones " + fechaFormateada + "\n");
                    for (Service s : services){
                        System.out.println(s);
                    }
                    break;
                default:
                    System.out.println("no es una opción valida");
            }



        }
        FileWriter escritura = new FileWriter("conversion.txt");
        escritura.write(String.valueOf(services));
        escritura.close();
        System.out.println("Proceso finalizado");
        System.out.println("Gracias Por usar el sistema de Conversión de moneda");

    }
}
