import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String nome = "Marcos Amaral";
        String tipoConta = "Corrente";
        double saldo = 0.00;
        Scanner leitor = new Scanner(System.in);
        int operacao = 0;
        double transferencia = 0;

        System.out.println(String.format(
                """
                ******************************************************
                Dados iniciais do cliente:
                
                Nome:           %s
                Tipo conta:     %s
                Saldo inicial:  R$ %.2f
                ******************************************************
                """, nome, tipoConta, saldo));

        while (operacao != 4){
            System.out.println("""
                    
                    Operações
                    
                    1 - Consultar saldos
                    2 - Receber valor
                    3 - Transferir valor
                    4 - Sair
                    
                    Digite a opção desejada:""");
            operacao = leitor.nextInt();

            switch (operacao) {
                case 1:
                    System.out.println("O saldo atual é R$ %.2f".formatted(saldo));
                    break;
                case 2:
                    System.out.println("Informe o valor a receber: ");
                    saldo += leitor.nextDouble();
                    System.out.println("Saldo atualizado R$ %.2f".formatted(saldo));
                    break;
                case 3:
                    System.out.println("Informe o valor que deseja transferir:");
                    transferencia = leitor.nextDouble();
                    if (transferencia > saldo){
                        System.out.println("Não há saldo suficiente para fazer essa tranferência.");
                    } else{
                        saldo -= transferencia;
                    }
                    break;
                case 4:
                    System.out.println("Você escolheu sair.");
                    break;
                default:
                    System.out.println("Você digitou uma opção inválida.");
            }
        }
    }
}