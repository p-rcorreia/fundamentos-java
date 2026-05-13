import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExemploNIO {

    public static void main(String[] args) {

        Path path = Paths.get("diretorio", "meuArquivoNIO.txt");
        
        try {
            
            // Escrevendo em um arquivo
            Files.write(path, "Olá Mundo NIO!".getBytes(StandardCharsets.UTF_8));
            
            // Lendo de um arquivo
            byte[] bytes = Files.readAllBytes(path);

            String content = new String(bytes, StandardCharsets.UTF_8);
            
            System.out.println(content);

        } catch (IOException e) {
            System.out.println("Problemas de IO: " + e.getMessage());
        }

    }

}
