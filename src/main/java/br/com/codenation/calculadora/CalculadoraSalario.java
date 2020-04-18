package br.com.codenation.calculadora;

public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {
		if (salarioBase < 0) {
			salarioBase = 0.0;
		}

		double brutoMenosInss = calcularInss(salarioBase);

		double salarioFinal;

		if (brutoMenosInss > 3000.00) {

			salarioFinal = calcularIrrf(brutoMenosInss);

		} else {

			salarioFinal = brutoMenosInss;
		}

		if (salarioFinal < 1039.00) {
			salarioFinal = 0;
		}

		return Math.round(salarioFinal);
	}

	private double calcularInss(double salarioBase) {

		double percentDesconto = 0;

		if (salarioBase <= 1500.00) {

			percentDesconto = 8.0;

		} else if (salarioBase > 1500.00 && salarioBase <= 4000.00) {

			percentDesconto = 9.0;

		} else {

			percentDesconto = 11.0;

		}

		double brutoMenosInss = 0.0;

		double desconto = calculaDesconto(salarioBase, percentDesconto);

		brutoMenosInss = salarioBase - desconto;

		return brutoMenosInss;

	}

	private double calcularIrrf(double salarioBase) {

		double descontoIrrf = 0.0;

		if (salarioBase <= 6000.00) {

			descontoIrrf = 7.5;

		} else {

			descontoIrrf = 15;

		}

		double desconto = calculaDesconto(salarioBase, descontoIrrf);

		salarioBase = salarioBase - desconto;

		return salarioBase;
	}

	private double calculaDesconto(double salario, double percentDesconto) {
		return (salario * percentDesconto) / 100;
	}

}
