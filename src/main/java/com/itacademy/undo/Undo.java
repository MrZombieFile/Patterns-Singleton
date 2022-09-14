package com.itacademy.undo;

import java.util.ArrayList;

public class Undo {

    private ArrayList<String> llistaDeComandes = new ArrayList<>();
    private static Undo instancia;
    private ArrayList<String> count = new ArrayList<>();

    private Undo(){

    }

    public static Undo getInstance(){
        if (instancia == null){
            instancia = new Undo();
        }
        return instancia;
    }

    public String undo(int i) {

        if (llistaDeComandes.get(llistaDeComandes.size() - 1).equalsIgnoreCase("undo")){
            llistaDeComandes.remove(llistaDeComandes.size() - 1);
        }

        llistaDeComandes.remove(llistaDeComandes.size() - 1);

        this.count.add("1");

        return llistaDeComandes.get(llistaDeComandes.size() - 1);

    }

    public void add(String comanda){
        if (!comanda.equals("undo"))
            this.count.clear();
        llistaDeComandes.add(comanda);
    }

    public ArrayList<String> history(){
        if(llistaDeComandes.get(llistaDeComandes.size() - 1).equalsIgnoreCase("history"))
            llistaDeComandes.remove(llistaDeComandes.size() - 1);
        return llistaDeComandes;
    }

    public int getLength(){
        return llistaDeComandes.size();
    }

}
