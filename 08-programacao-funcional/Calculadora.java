@FunctionalInterface
interface CalculadoraInterface {
    double calcular(double a, double b);
}

public class Calculadora {
    public static void main(String[] args) {
        CalculadoraInterface soma = (a, b) -> a + b;
        System.out.println("Soma: " + soma.calcular(10, 5));

        CalculadoraInterface subtracao = (a, b) -> a - b;
        System.out.println("Subtração: " + subtracao.calcular(10, 5));

        CalculadoraInterface multiplicacao = (a, b) -> a * b;
        System.out.println("Multiplicação: " + multiplicacao.calcular(10, 5));

        CalculadoraInterface divisao = (a, b) -> a / b;
        System.out.println("Divisão: " + divisao.calcular(10, 5));
    }
}
