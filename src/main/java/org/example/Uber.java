package org.example;

public class Uber {

    private final String modelo;
    private final String cor;
    private final String placaDoCarroUsado;

    public Uber(String modelo,String cor, String placaDoCarroUsado) {
        this.placaDoCarroUsado = placaDoCarroUsado;
        this.cor = cor;
        this.modelo = modelo;
    }


    public static Uber lerDados(){
        System.out.println("===Automovel-Do-Motorista===");
        System.out.print("Modelo Do Veiculo: ");
        String modelo = Input.input.nextLine();
        System.out.print("Placo do Automovel: ");
        String placa = Input.input.next();
        Input.input.nextLine();
        System.out.print("Cor do Automovel: ");
        String cor = Input.input.next();
        Input.input.nextLine();
        return new Uber(modelo,cor,placa);
    }

    public String getPlacaDoCarroUsado() {
        return placaDoCarroUsado;
    }

    public String getCor() {
        return cor;
    }

    public String getModelo() {
        return modelo;
    }

    @Override
    public String toString() {
        return
                "Modelo: "+modelo  +" - Cor: "+ cor + " - Placa: " + placaDoCarroUsado ;

    }
}

