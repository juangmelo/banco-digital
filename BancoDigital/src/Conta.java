public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	public void sacar(double valor) {
		if(saldo < valor){
			System.out.println("Saldo insuficiente para saque");
		}
		else if(valor == 0){
			System.out.println("Valor invalido para saque");
		}
		else{
			saldo -= valor;
			System.out.println(valor + " R$ foram sacados da sua conta");
		}
	}

	public void depositar(double valor) {
		if(valor == 0){
			System.out.println("Valor invalido para deposito");
		}
		else{
			saldo += valor;
		}
	}

	public void transferir(double valor, IConta contaDestino) {
		if(saldo < valor){
			System.out.println("Saldo insuficiente para transferencia");
		}
		else if(valor == 0){
			System.out.println("Valor inválido para transferencia");
		}
		else{
			sacar(valor);
			contaDestino.depositar(valor);
			System.out.println(valor + " R$ foram transferidos para a conta destino");
		}
	}

	public int getAgencia() {
		return this.agencia;
	}

	public int getNumero() {
		return this.numero;
	}

	public double getSaldo() {
		return this.saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}