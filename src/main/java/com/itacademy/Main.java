package com.itacademy;

import com.itacademy.undo.Undo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*El que faig es, demano que vagi introduint les comandes amb el segon do while, fins que aquesta
        * no sigui "undo or history", si passa aixo vaig al singleton i n'agafo el corresponent.
        * Tot aixo dins d'un primer do while que comprova que l'usuari encara volgui estar dins el programa*/


        Scanner scanner = new Scanner(System.in);

        Undo undo = Undo.getInstance();
        String comanda;
        System.out.print("Introdueix la comanda, 'exit' per sortir, 'history' per mostrar l'historial o 'undo' per anar enrere ");
        do {
            boolean exitLoop = false;
            int i = undo.getLength();
            ArrayList<String> comandes;
            do {
                comanda = scanner.next();
                undo.add(comanda);
                if (comanda.equals("undo") || comanda.equals("history") || comanda.equals("exit")) {
                    exitLoop = true;
                }
                i++;
            } while (!exitLoop);

            if (comanda.equals("undo")) {
                comandes = undo.history();
                try {
                    System.out.println(undo.undo(i));
                }catch(Exception exc){

                }
            } else if (comanda.equals("history")) {
                comandes = undo.history();
                comandes.forEach(System.out::println);
            } else {
            }
        }while(!comanda.equals("exit"));

    }
}