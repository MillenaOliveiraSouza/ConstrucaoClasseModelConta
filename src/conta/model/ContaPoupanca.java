package conta.model;

public class ContaPoupanca extends Conta {
	
	private int cpf;
	
	public ContaPoupanca(int numero, int agencia, int tipo, String titular, float saldo, int cpf) {
		
		super(numero, agencia, tipo, titular, saldo);

			this.cpf= cpf;
		
	}

	public int getCpf() {
		return cpf;
	}
	
	public void setCpf(int cpf) {
		
		this.cpf = cpf;
		
	}
	
	public void vizualizar() {
		
		super.visualizar();
		System.out.println("CPF: " + this.cpf);
	}
	
	
}
