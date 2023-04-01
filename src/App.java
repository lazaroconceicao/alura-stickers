import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        
        API api = API.NASA;

        String url = api.getUrl();
        ExtratorDeConteudo extrator = api.getExtrator();

        var http = new ClienteHttp();
        String json = http.buscaDados(url);

       

        // exibir e manipular os dados        
        List<Conteudo> conteudos = extrator.extariConteudo(json);

        var geradora = new GeradoraDeFigurinha();

        for (int i = 0; i < 4; i++) {
            
            Conteudo conteudo = conteudos.get(i);        


            InputStream inputStream = new URL(conteudo.urlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.titulo() + ".png";

            
            geradora.cria(inputStream, nomeArquivo);

            // System.out.println(conteudo.getTitulo());
            System.out.println();

            System.out.println("\u001b[1mTítulo:\u001b[m " + conteudo.titulo());
            System.out.println("\u001b[1mURL da imagem:\u001b[m " +conteudo.urlImagem());
            // double classificacao = Double.parseDouble(conteudo.get("imDbRating"));
            // int numeroEstrelinhas = (int) classificacao;

            // for (int n = 1; n <= numeroEstrelinhas; n++) 
            //     System.out.print("⭐");
            
            // System.out.println("\n");

        }
    }
}
