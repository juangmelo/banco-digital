import java.util.Scanner;

public class main {
	public static void main(String[] args) {

		Scanner valor = new Scanner(System.in);
		Cliente cliente = new Cliente();
		cliente.setNome("Juan");
		
		Conta cc = new ContaCorrente(cliente);
		Conta poupanca = new ContaPoupanca(cliente);

		System.out.println("Quanto voce gostaria de depositar na conta corrente?");
		cc.depositar(valor.nextDouble());
		System.out.println("Seu saldo na conta corrente é de: " + cc.getSaldo() + " R$");

		System.out.println("Digite um valor para saque na conta corrente");
		cc.sacar(valor.nextDouble());
		System.out.println("Seu saldo na conta corrente é de: " + cc.getSaldo() + " R$");

		System.out.println("Insira um valor para transferencia");
		cc.transferir(valor.nextDouble(), poupanca);
		System.out.println("Seu saldo na conta corrente é de: " + cc.getSaldo() + "R$");
		cc.imprimirExtrato();
		//
		System.out.println("Quanto voce gostaria de depositar na conta poupanca?");
		poupanca.depositar(valor.nextDouble());
		System.out.println("Seu saldo é na conta poupança de: " + poupanca.getSaldo() + " R$");

		System.out.println("Digite um valor para saque na conta poupanca");
		poupanca.sacar(valor.nextDouble());
		System.out.println("Seu saldo na conta poupança é de: " + poupanca.getSaldo() + " R$");

		System.out.println("Insira um valor para transferencia");
		poupanca.transferir(valor.nextDouble(), cc);
		System.out.println("Seu saldo na conta poupança é de: " + poupanca.getSaldo() + "R$");
		poupanca.imprimirExtrato();
	}

}