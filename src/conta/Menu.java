package conta;

import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

public class Menu { 

	public static void main(String[] args) {

		Conta c1 = new Conta(1, 123, 1, "Millena", 250000.0f);

		c1.visualizar();
		c1.setAgencia(456);
		//System.out.println(c1.getAgencia());
		ContaCorrente cc1 = new ContaCorrente(20, 25, 1, "Millena", 330000.0f, 3000.0f);

		if (c1.sacar(100))
			System.out.println("Saque efetuado com sucesso. O novo saldo é de: " + c1.getSaldo());
		else
			System.out.println("O saldo é insuficiente!");
		
		ContaPoupanca cp1 = new ContaPoupanca(20, 25, 1, "Millena", 330000.0f, "232333202");
		
		System.out.println("Saldo inicial: " + cc1.getSaldo());
		cc1.sacar(200000);
		System.out.println("Saldo pós saque: "+ cc1.getSaldo());
		

		c1.depositar(1000);
		System.out.println("Depósito concluido. O novo saldo é: " + c1.getSaldo());
		
		System.out.println(cp1.getCpf());

	}

}
