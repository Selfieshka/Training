package ru.kpfu.itis.kirillakhmetov.work.grayImg;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;

public class ImgUtil {
    public static void main(String[] args) throws IOException {
        BufferedImage img = read("test.jpg");
        BufferedImage gray = new BufferedImage(img.getWidth(), img.getHeight(),
                BufferedImage.TYPE_BYTE_GRAY);

        int rgb=0, r=0, g=0, b=0;
        for (int y=0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                rgb = (int) img.getRGB(x, y);
                // C помощью побитового сдвига и маски достаём из int
                // значения для красного, зелёного, синего каналов цвета
                r = (rgb >> 16) & 0xFF;
                g = (rgb >> 8) & 0xFF;
                b = (rgb) & 0xFF;
                // С помощью формулы переводим три основных цвета в оттенок серого
                rgb = (int) (0.212655 * r + 0.715158 * g + 0.072187 * b);
                gray.setRGB(x, y, rgb);
            }
        }
        write(gray);
    }

    public static BufferedImage read(String file) throws IOException {
        BufferedImage picture = ImageIO.read(new File(file));
        return picture;
    }

    public static void write(BufferedImage picture) throws IOException {

        BufferedImage out = new BufferedImage(picture.getWidth(), picture.getHeight(), TYPE_INT_RGB);
        for(int i = 0; i < picture.getWidth(); ++i)
            for (int j = 0; j < picture.getHeight(); ++j) {
                out.setRGB(i,j,picture.getRGB(i,j));
            }
        ImageIO.write(out, "JPG", new FileOutputStream(new File("test1.jpg")));
    }
}
