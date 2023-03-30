import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinha {

    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {

        //leitura da imagem
        // InputStream inputStream = new FileInputStream(new File("entrada/TopMovies_1.jpg"));
        // InputStream inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_1.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        //criar uma nova imagem em memória com transparencia e tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        //copiar a imagem original para uma nova (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        //configurar a fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 80);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        //escrver uma frase na nova imagem
        String texto = "TOPZERA";
        FontMetrics fontMetrics = graphics.getFontMetrics();
        Rectangle2D retangulo =  fontMetrics.getStringBounds(texto, graphics);
        int larguraTexto = (int ) retangulo.getWidth();
        int posicaoTextoX = (largura - larguraTexto) / 2;
        graphics.drawString(texto, posicaoTextoX, novaAltura - 100);

        //ecrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));
    }    
}
