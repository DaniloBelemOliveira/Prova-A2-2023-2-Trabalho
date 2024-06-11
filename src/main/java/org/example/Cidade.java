package org.example;

import java.util.function.Consumer;

public class Cidade {

    private final String nome;
    private final int idUsado;
    private static int idCidade = 0;

    public Cidade(String nome) {
        this.nome = nome;
        this.idUsado = idCidade;
        idCidade++;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }

    public static Cidade lerDados(){
        System.out.println("===Cidade===");
        System.out.print("Nome: ");
        String nome = Input.input.nextLine();
        return new Cidade(nome);
    }


}
