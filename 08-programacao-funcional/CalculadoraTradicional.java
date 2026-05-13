public class CalculadoraTradicional {
    public double somar(double a, double b) {
        return a + b;
    }

    public double subtrair(double a, double b) {
        return a - b;
    }

    public double multiplicar(double a, double b) {
        return a * b;
    }

    public double dividir(double a, double b) {
        return a / b;
    }

    public static void main(String[] args) {
        CalculadoraTradicional calculadora = new CalculadoraTradicional();

        double resultadoSoma = calculadora.somar(10, 5);
        System.out.println("Soma: " + resultadoSoma);

        double resultadoSubtracao = calculadora.subtrair(10, 5);
        System.out.println("Subtração: " + resultadoSubtracao);

        double resultadoMultiplicacao = calculadora.multiplicar(10, 5);
        System.out.println("Multiplicação: " + resultadoMultiplicacao);

        double resultadoDivisao = calculadora.dividir(10, 5);
        System.out.println("Divisão: " + resultadoDivisao);
    }
}
