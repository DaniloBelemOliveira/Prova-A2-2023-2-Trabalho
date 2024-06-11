package org.example;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class Motorista {

    private final String nome;
    private final String cpf;
    private static final Set<Motorista> motoristas = new HashSet<>();
    private static int id = 0;
    private final int idMotorista;
    private final Uber uber;

    public Motorista(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
        this.idMotorista = id;
        id++;
        this.uber = Uber.lerDados();
    }

    public Uber getUber() {
        return uber;
    }

    @Override
    public String toString() {
        return
                 nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", idMotorista=" + idMotorista +
                '}';
    }

    public static Motorista lerDados(){
        System.out.println("===Motorista===");
        System.out.print("Nome: ");
        String nome = Input.input.nextLine();
        System.out.print("Cpf: ");
        String cpf = Input.input.next();
        Input.input.nextLine();
        Motorista motorista = new Motorista(nome,cpf);
        motoristas.add(motorista);
        return motorista;
    }

    static Consumer<Motorista> print = motorista -> {
        System.out.println("Id: "+motorista.idMotorista);
        System.out.println("Nome: "+motorista.nome);
        System.out.println("Cpf: "+motorista.cpf);
    };

    public static Motorista buscarMotorista(int id){
        try{
            return motoristas.stream().
                    filter(motorista -> motorista.getIdMotorista() == id).findFirst().get();
        }
        catch (Exception e) {
            throw new RuntimeException("Id inexistente!!!");
        }
    }

    public static void imprimir() {
        motoristas.forEach(motorista -> print.accept(motorista));
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdMotorista() {
        return idMotorista;
    }
}
