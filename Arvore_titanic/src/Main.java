import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Arquivo_hex arquivo = new Arquivo_hex();

        arquivo.salvar_arquivo();

        arquivo.buscar_linha(200);
    }
}