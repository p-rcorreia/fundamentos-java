import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ExemploIO {
    public static void main(String[] args) {
        try {
            // Escrevendo em um arquivo.
            FileWriter writer = new FileWriter("C:\\Users\\wh1of\\OneDrive\\Documentos\\Desenvolvimento\\fundamentos-java\\22-entrada-e-saida\\diretorio\\meuArquivo.txt");
            writer.write("Olá Mundo!");
            writer.close();

            // Lendo o arquivo caractere por caractere.
            FileReader reader = new FileReader("C:\\Users\\wh1of\\OneDrive\\Documentos\\Desenvolvimento\\fundamentos-java\\22-entrada-e-saida\\diretorio\\meuArquivo.txt");
            int data = reader.read();

            while (data != -1) {
                System.out.print((char) data);
                data = reader.read();
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Problemas de IO: " + e.getMessage());
        }
    }
}
