import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaNasa implements ExtratorDeConteudo {
    
    public List<Conteudo> extariConteudo(String json) {
        
         // extrair só os dados que interessam (título, poster, classificação)
         var parser = new JsonParser();
         List<Map<String, String>> listaDeAtributos = parser.parse(json);

         return listaDeAtributos.stream()
         .map(atributos -> new Conteudo(atributos.get("title"), atributos.get("url")))
         .toList();         
    }
    
}
