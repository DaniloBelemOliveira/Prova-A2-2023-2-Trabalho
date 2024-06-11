package org.example;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;


public class Principal {
    public static  final List<Corrida> corridas = new ArrayList<>();

    public static void main(String[] args) {


        int op = menu();
        while (op != 5){
            switch (op){
                case 1:
                    cadastrar();
                    System.out.println("\nAperte Enter Para Continuar");
                    Input.input.nextLine();
                    break;
                case 2:
                    excluir();
                    System.out.println("\nAperte Enter Para Continuar");
                    Input.input.nextLine();
                    break;
                case 3:
                    todasCorridas();
                    System.out.println("\nAperte Enter Para Continuar");
                    Input.input.nextLine();
                    break;
                case 4:
                    buscarCorridasPorCidade();
                    System.out.println("\nAperte Enter Para Continuar");
                    Input.input.nextLine();
                    break;
            }
            op = menu();
        }

    }

    private static void todasCorridas() {
        System.out.println("=====Todas As Corridas=====");
        Set<Corrida> corridasSemRepeticao = new HashSet<>(corridas);
        corridasSemRepeticao.stream().sorted(Comparator.comparing(Corrida::getIdCorrida)).forEach(Corrida::imprimir);
        System.out.println("===========================");
    }


    private static void buscarCorridasPorCidade() {
        Set<String> cidades = corridas.stream().map(corrida -> corrida.getCidade()
                .getNome()).collect(Collectors.toSet());
        System.out.println("==Cidades-Disponiveis==");
        cidades.forEach(System.out::println);
        System.out.println("=======================");
        System.out.print("Cidade: ");
        String cidade = Input.input.nextLine();
        Set<Corrida> corridasFiltradasPorCidade
                = corridas.stream()
                .filter(corrida -> corrida.getCidade().getNome().equals(cidade))
                .collect(Collectors.toSet());

        System.out.println("===Corridas===");
        corridasFiltradasPorCidade.stream()
                .sorted(Comparator.comparing(corrida -> corrida.getMotorista().getCpf()))
                .forEach(Corrida::imprimir);
        System.out.println("==============");

    }



    private static void excluir() {
        Set<Corrida> corridasSemRepeticao = new HashSet<>(corridas);
        corridasSemRepeticao.stream().sorted(Comparator.comparing(Corrida::getIdCorrida))
                .forEach(Corrida::imprimir);
        System.out.println("========================================");
        System.out.print("Selecione Pelo Id: ");
        Corrida corrida = buscarCorrida(Input.input.nextInt());
        Input.input.nextLine();
        corridas.remove(corrida);
        System.out.println("Corrida Removida Com Sucesso!!!");
    }

    private static Corrida buscarCorrida(int id) {

        try {
            return corridas.stream().
                    filter(corrida -> corrida.getIdCorrida() == id).findFirst().get();
        }
        catch (Exception e){
            throw new RuntimeException("Corrida Inexistente!!!");
        }

    }

    private static void cadastrar() {
        System.out.println("====Cadastrando-Corrida====");
        Corrida corrida = Corrida.lerDados();
        corridas.add(corrida);
        System.out.println("--------------------------------");
        System.out.println("Corrida Cadastrada Com Sucesso!");
    }

    public static int menu(){
        int op = -1;
        while(op > 5 || op < 1){
            System.out.println("\n=========Menu=========");
            System.out.println("[1]-Cadastrar Uma Corrida ");
            System.out.println("[2]-Excluir Uma Corrida");
            System.out.println("[3]-Imprimir Todas As Corridas");
            System.out.println("[4]-Consultar Corridas por Cidade");
            System.out.println("[5]-Sair");
            op = Input.input.nextInt();
            Input.input.nextLine();
        }
        return op;
    }

}