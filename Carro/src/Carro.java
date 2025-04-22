import java.util.Scanner;

public class Carro {
    
    String Motor;
    int Velocidade;
    int Marcha;

    public Carro(String meucarro) {

        this.Motor = meucarro;
        this.Velocidade = 0;
        this.Marcha = 0;
        
    }
    
    public static void main(String[] args) throws Exception {

        
        Carro meucarro = new Carro("Desligado");
        System.out.println("Carro criado com sucesso.");

        int opcao = 0; 
        Scanner scanner = new Scanner(System.in);
        
        while (opcao != 8 ) {
            
            System.out.println("Escolha uma açao: ");
            System.out.println("1. Ligar o carro");
            System.out.println("2. Desligar o carro");
            System.out.println("3. Acelerar");
            System.out.println("4. Diminuir a velocidade");
            System.out.println("5. Virar á esquerda/direita");
            System.out.println("6. Verificar marcha");
            System.out.println("7. Trocar marcha");
            System.out.println("8. Sair");

            opcao = scanner.nextInt();
            int[] limiteMarcha = {0, 20, 40, 60, 80, 100, 120};

            switch (opcao) {
                case 1:
                    if (meucarro.Motor.equals("Ligado")) {
                        System.out.println("Carro já está ligado.");
                    } else {
                        meucarro.Motor = "Ligado";
                        System.out.println("Carro ligado.");
                    }
                break;

                case 2:
                    if (meucarro.Motor.equals("Desligado")) {
                        System.out.println("Carro já está desligado.");

                    } else if (meucarro.Velocidade == 0 && meucarro.Marcha == 0) {
                        meucarro.Motor = "Desligado";
                        System.out.println("Desligando carro...");
                        System.out.println("Carro desligado!");
                    }

                break;

                case 3:
                    if (meucarro.Motor.equals("Ligado") && meucarro.Marcha > 0 && meucarro.Velocidade < limiteMarcha[meucarro.Marcha]) {
                        System.out.println("Acelerando...");
                        meucarro.Velocidade += 10;
                        System.out.println("Velocidade atual: " + meucarro.Velocidade + " km/h");

                    } else if (meucarro.Marcha == 0) {
                        System.out.println("Carro está em neutro. Não é possível acelerar.");

                    } else if (meucarro.Velocidade >= limiteMarcha[meucarro.Marcha]) {
                        System.out.println("Limite de velocidade atingido na marcha " + meucarro.Marcha + ": " + limiteMarcha[meucarro.Marcha] + " km/h");

                    } else {
                        System.out.println("Carro desligado. Não é possível acelerar.");
                    }

                break;

                case 4:
                    if (meucarro.Motor.equals("Ligado") && meucarro.Marcha > 0 && meucarro.Velocidade > 0) {

                        meucarro.Velocidade -= 10;
                        System.out.println("Velocidade atual: " + meucarro.Velocidade + " km/h" + " na marcha " + meucarro.Marcha);
                        
                        while (meucarro.Marcha > 1 && meucarro.Velocidade < limiteMarcha[meucarro.Marcha - 1]) {
                            meucarro.Marcha = meucarro.Marcha - 1;
                            System.out.println("Reduzindo marcha para: " + meucarro.Marcha);
                            
                        }

                    } else if (meucarro.Velocidade == 0) {
                        meucarro.Marcha = 0;
                        System.out.println("Acionado marcha neutra.");
                    }
                    
                    else {
                        System.out.println("Carro parado ou desligado. Não é possível reduzir.");
                    }

                break;

                case 5:
                    if (meucarro.Velocidade > 0 && meucarro.Velocidade < 40) {
                        System.out.println("Virando á esquerda/direita...");
                    } else {
                        System.out.println("Não é possível virar. Velocidade nao permitida.");
                    }

                break;

                case 6:
                    if (meucarro.Marcha == 0) {
                        System.out.println("Carro está em neutro.");
                    } else {
                        System.out.println("Marcha atual: " + limiteMarcha);
                    }
                break;

                case 7:
                    System.out.println("Marcha atual: " + meucarro.Marcha);
                    System.out.println("Digite a marcha desejada (1-6): ");
                    int marchaDesejada = scanner.nextInt();
                    int diferenca = Math.abs(marchaDesejada - meucarro.Marcha);
                    
                    if (diferenca > 1) {
                        System.out.println("nao é possivel pular marchas");
                        System.out.println("Marcha mantida: " + meucarro.Marcha);
                        
                    } else if (marchaDesejada >= 0 || marchaDesejada < 6) {
                        meucarro.Marcha = marchaDesejada;
                        System.out.println("Marcha trocada para: " + meucarro.Marcha);

                    } else if (marchaDesejada >= 1 && marchaDesejada <= 6) {
                        meucarro.Marcha = marchaDesejada;
                        System.out.println("Marcha trocada para: " + meucarro.Marcha);
                        
                    } else {
                        System.out.println("Marcha inválida. Escolha entre 1 e 6.");
                    }

                break;

                case 8:
                    System.out.println("Saindo do programa...");
                    break;

                default:
                System.out.println("Opção inválida.");
                    break;
            }
            
        }
        scanner.close();
    }

    public String getMotor(){
        return Motor;
    }

    public int getVelocidade(){
        return Velocidade;
    }

    public int getMarcha(){
        return Marcha;
    }
}
