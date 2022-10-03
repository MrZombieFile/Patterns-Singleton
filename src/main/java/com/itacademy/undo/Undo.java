package com.itacademy.undo;

import java.util.ArrayList;

public class Undo {

    private ArrayList<String> llistaDeComandes;
    private static Undo instancia;

    private int count = 0;

    private Undo(){
        llistaDeComandes = new ArrayList<>();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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

        setCount(getCount() + 1);

        return llistaDeComandes.get(llistaDeComandes.size() - 1);

    }

    public void add(String comanda){
        if (!comanda.equals("undo"))
            setCount(0);
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
