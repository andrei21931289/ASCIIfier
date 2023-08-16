import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    // static long startTime = System.nanoTime();
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Recommended resolution: 640 x 360 ");
        System.out.println("You can try higher resolutions, but it might not display correctly.");
        System.out.println("Input the image file path for conversion: ");
        String filePath = scanner.nextLine().trim();
        File file = new File(filePath);
        BufferedImage image = ImageIO.read(file);
        int height = image.getHeight();
        int width = image.getWidth();
        System.out.println("Image height: " + height);
        System.out.println("Image width: " + width);
        int [][] brightnessMatrix = new int[width][height];

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int pixel = image.getRGB(x, y);
                Color color = new Color(pixel, false);
                int red = color.getRed();
                int blue = color.getBlue();
                int green = color.getGreen();
                brightnessMatrix[x][y] = (red + blue + green) / 3; // brightness of each pixel

            }
        }

        //System.out.println(Arrays.deepToString(brightnessMatrix));


        String characters = "`^\\\",:;Il!i~+_-?][}{1)(|\\\\/tfjrxnuvczXYUJCLQ0OZmwqpdbkhao*#MW&8%B@$";


        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                System.out.print(characters.charAt(brightnessMatrix[j][i]/4));
                System.out.print(characters.charAt(brightnessMatrix[j][i]/4));
                //System.out.print(characters.charAt(brightnessMatrix[j][i]/4));
            }
            System.out.println();
        }
//        double endTime = System.nanoTime() - startTime;
//        // System.out.println("Total runtime: " + endTime / 1_000_000_000 + " seconds");
//        long convert = TimeUnit.SECONDS.convert((long)endTime, TimeUnit.NANOSECONDS);
//        System.out.println("Converted time using method: " + convert + " seconds");
    }
}