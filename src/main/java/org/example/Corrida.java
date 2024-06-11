package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Corrida implements Impressao{

    private LocalDateTime inicio;
    private LocalDateTime fim;
    private String localPartida;
    private String localChegada;
    private static int id = 0;
    private final int idCorrida;
    private Motorista motorista;
    private Uber uber;
    private Cidade cidade;

    @Override
    public void imprimir() {
        System.out.println(this.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Corrida corrida)) return false;
        return idCorrida == corrida.idCorrida && Objects.equals(inicio, corrida.inicio) && Objects.equals(fim, corrida.fim) && Objects.equals(localPartida, corrida.localPartida) && Objects.equals(localChegada, corrida.localChegada) && Objects.equals(motorista, corrida.motorista) && Objects.equals(uber, corrida.uber) && Objects.equals(cidade, corrida.cidade);
    }

    public String getLocalChegada() {
        return localChegada;
    }

    public String getLocalPartida() {
        return localPartida;
    }

    public Cidade getCidade() {
        return cidade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(inicio, fim, localPartida, localChegada, idCorrida);
    }

    public int getIdCorrida() {
        return idCorrida;
    }

    @Override
    public String toString() {
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
        return "\n========================================" +
                "\nCorrida Id = " + idCorrida +
                "\nInicio = " + inicio.format(formater) +
                "\nFim = " + fim.format(formater) +
                "\nLocalPartida = " + localPartida +
                "\nLocalChegada = " + localChegada +
                "\nCidade = " + cidade.getNome() +
                "\nMotorista = " + "Nome: "+motorista.getNome()+" - Cpf: "+motorista.getCpf() +
                "\nAutomovel = " + uber
                ;
    }

    public static Corrida lerDados(){
        System.out.println("Hora e Data de Inicio[HH:mm dd/mm/aaaa]: ");
        String inicio = Input.input.nextLine();
        System.out.println("Hora e Data de Chegada[HH:mm dd/mm/aaaa]:");
        String termino = Input.input.nextLine();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
        LocalDateTime inicioLocalDateTime = LocalDateTime.parse(inicio,dateTimeFormatter);
        LocalDateTime terminoLocalDateTime = LocalDateTime.parse(termino,dateTimeFormatter);
        System.out.print("Local De Partida: ");
        String localDePartida = Input.input.nextLine();
        System.out.print("Local De Chegada: ");
        String localDeChegada = Input.input.nextLine();

        return new Corrida(inicioLocalDateTime,terminoLocalDateTime,localDeChegada,localDePartida);
    }

    public Corrida(LocalDateTime inicio, LocalDateTime fim,
                   String localChegada,String localPartida) {
        this.inicio = inicio;
        this.fim = fim;
        this.localPartida = localPartida;
        this.localChegada = localChegada;
        this.idCorrida = id;
        id++;
        this.motorista = Motorista.lerDados();
        this.uber = motorista.getUber();
        this.cidade = Cidade.lerDados();
    }

    public Motorista getMotorista() {
        return motorista;
    }

}
