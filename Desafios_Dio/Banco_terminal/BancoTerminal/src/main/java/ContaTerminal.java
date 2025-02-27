import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        String numero_agencia;
        int numero_conta;
        String nome_cliente;
        double saldo;

        Scanner entrada = new Scanner(System.in);
        System.out.println("Bem vindo ao Banco Dio, Por favor, digite o número da Agência !");
        numero_agencia = entrada.nextLine();
        System.out.println("Digite o numero de conta: ");
        numero_conta = Integer.parseInt(entrada.nextLine());
        System.out.println("Digite o nome do Cliente: ");
        nome_cliente = entrada.nextLine();
        System.out.println("Digite o saldo do Cliente: ");
        saldo = Double.parseDouble(entrada.nextLine());

        System.out.println("Olá "+nome_cliente+", obrigado por criar uma conta em nosso banco, sua agência é "+numero_agencia+", conta "+numero_conta+" e seu saldo "+saldo+" já está disponível para saque");

    }
}
