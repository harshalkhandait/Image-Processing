package com.image.processing;
/*DEATAILS*/
//1. Name: Saurav Gajbhiye
//Roll Number: BT17CSE069
//Batch B3 CSE Sec B
//2. Name: Harshal Khandait
//Roll Number: BT17CSE074
//Batch B3 CSE Sec B

//OBJECT ORIENTED PROGRAMMING PROJECT
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;
import java.awt.*;
import java.awt.geom.Rectangle2D;


public class MenuDrivenImageProcessing {
    public static void main(String[] args) throws IOException{
        String path;
        int choice = 1;
        int rgb_choice;
        int p = 0;
        int width;
        int height;
        int a, r, g, b;
        int avg;
        BufferedImage img = null;
        //Calling welcome function
        welcome();
        System.out.println("Enter Path of the Image: ");
        Scanner kb = new Scanner(System.in);
        path = kb.nextLine();
        System.out.println();
        while (choice != 13) {
            System.out.println("1. Get Pixel Value From Image");
            System.out.println("2. Convert Image to Sepia Exposure");
            System.out.println("3. Convert Image to either Red Green or Blue Exposure");
            System.out.println("4. Convert Image to Negative Exposure");
            System.out.println("5. Create Random Pixel over Image");
            System.out.println("6. Set Particular Pixel Values for the Image");
            System.out.println("7. Convert Image to GrayScale Exposure");
            System.out.println("8. Create Mirror Image from the Existing Image");
            System.out.println("9. Add Text WaterMark to the Images");
            System.out.println("10. Compress a Specified Image");
            System.out.println("11. Change Brightness of the Image");
            System.out.println("12. Convert Image to Black and White Exposure");
            System.out.println("13. Exit");
            System.out.println("Enter One of the Above Mentioned Choices");
            choice = kb.nextInt();
            switch (choice) {
                case 1:
                    try {
                        File inputfile = new File(path);
                        img = ImageIO.read(inputfile);
                        width = img.getWidth();
                        height = img.getHeight();
                        for (int x = 0; x < width; x++) {
                            for (int y = 0; y < height; y++) {
                                p = img.getRGB(x, y);
                            }
                        }
                        System.out.println("Pixel Value Using getRGB Function is:");
                        System.out.println(p);
                        System.out.println();
                    } catch (IOException e) {
                        System.out.println("Error: " + e);
                    }
                    break;
                case 2:
                    int tr, tg, tb;
                    try {
                        File inputfile = new File(path);
                        img = ImageIO.read(inputfile);
                        height = img.getHeight();
                        width = img.getWidth();
                        for (int x = 0; x < width; x++) {
                            for (int y = 0; y < height; y++) {
                                p = img.getRGB(x, y);
                                a = (p >> 24) & 0xff;
                                r = (p >> 16) & 0xff;
                                g = (p >> 8) & 0xff;
                                b = (p >> 0) & 0xff;
                                tr = (int) (0.393 * r + 0.769 * g + 0.189 * b);
                                tg = (int) (0.349 * r + 0.686 * g + 0.168 * b);
                                tb = (int) (0.272 * r + 0.534 * g + 0.131 * b);
                                if (tr > 255) {
                                    r = 255;
                                } else {
                                    r = tr;
                                }
                                if (tg > 255) {
                                    g = 255;
                                } else {
                                    g = tg;
                                }
                                if (tb > 255) {
                                    b = 255;
                                } else {
                                    g = tg;
                                }
                                p = (a << 24) | (r << 16) | (g << 8) | (b << 0);
                                img.setRGB(x, y, p);
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Error: " + e);
                    }
                    try {
                        File outputfile = new File (GetProcessedImgPathFromUser());
                        ImageIO.write(img, "jpg", outputfile);
                        System.out.println("Image After Processing>>>>");
                        System.out.println();
                    } catch (IOException e) {
                        System.out.println("Error: " + e);
                    }
                    break;
                case 3:
                    try {
                        File inputfile = new File(path);
                        img = ImageIO.read(inputfile);
                        width = img.getWidth();
                        height = img.getHeight();
                        System.out.println("1. Convert Image to Red Exposure");
                        System.out.println("2. Convert Image to Green Exposure");
                        System.out.println("3. Convert Image to Blue Exposure");
                        System.out.println("Enter one of the Above Choices");
                        rgb_choice = kb.nextInt();
                        switch (rgb_choice) {
                            case 1:
                                for (int x = 0; x < width; x++) {
                                    for (int y = 0; y < height; y++) {
                                        p = img.getRGB(x, y);
                                        a = (p >> 24) & 0xff;
                                        r = (p >> 16) & 0xff;
                                        g = (p >> 8) & 0xff;
                                        b = (p >> 0) & 0xff;
                                        //Red
                                        p = (a << 24) | (r << 16) | (0 << 8) | (0 << 0);
                                        img.setRGB(x, y, p);
                                    }
                                }
                                try {
                                    File outputfile = new File(GetProcessedImgPathFromUser());
                                    ImageIO.write(img, "jpg", outputfile);
                                    System.out.println("Image After Processing>>>>");
                                    System.out.println();
                                }
                                catch (IOException e) {
                                    System.out.println("Error: " + e);
                                }
                                break;
                            case 2:
                                for (int x = 0; x < width; x++) {
                                    for (int y = 0; y < height; y++) {
                                        p = img.getRGB(x, y);
                                        a = (p >> 24) & 0xff;
                                        r = (p >> 16) & 0xff;
                                        g = (p >> 8) & 0xff;
                                        b = (p >> 0) & 0xff;
                                        //Red
                                        p = (a << 24) | (0 << 16) | (g << 8) | (0 << 0);
                                        img.setRGB(x, y, p);
                                    }
                                }
                                try {
                                    File outputfile = new File(GetProcessedImgPathFromUser());
                                    ImageIO.write(img, "jpg", outputfile);
                                    System.out.println("Image After Processing>>>>");
                                    System.out.println();
                                }
                                catch (IOException e) {
                                    System.out.println("Error: " + e);
                                }
                                break;
                            case 3:
                                for (int x = 0; x < width; x++) {
                                    for (int y = 0; y < height; y++) {
                                        p = img.getRGB(x, y);
                                        a = (p >> 24) & 0xff;
                                        r = (p >> 16) & 0xff;
                                        g = (p >> 8) & 0xff;
                                        b = (p >> 0) & 0xff;
                                        //Red
                                        p = (a << 24) | (0 << 16) | (0 << 8) | (b << 0);
                                        img.setRGB(x, y, p);
                                    }
                                }
                                try {
                                    File outputfile = new File(GetProcessedImgPathFromUser());
                                    ImageIO.write(img, "jpg", outputfile);
                                    System.out.println("Image After Processing>>>>");
                                    System.out.println();
                                }
                                catch (IOException e) {
                                    System.out.println("Error: " + e);
                                }
                                break;
                            default:
                                System.out.println("Please Enter a Valid Choice");
                                break;
                        }
                    }
                    catch (IOException e) {
                        System.out.println("Error: " + e);
                    }
                    break;
                case 4:
                    try {
                        File inputfile = new File(path);
                        img = ImageIO.read(inputfile);
                        height = img.getHeight();
                        width = img.getWidth();
                        for (int x = 0; x < width; x++) {
                            for (int y = 0; y < height; y++) {
                                p = img.getRGB(x, y);
                                a = (p >> 24) & 0xff;
                                r = (p >> 16) & 0xff;
                                g = (p >> 8) & 0xff;
                                b = (p >> 0) & 0xff;
                                r = 255 - r;
                                g = 255 - g;
                                b = 255 - b;
                                p = (a << 24) | (r << 16) | (g << 8) | (b << 0);
                                img.setRGB(x, y, p);

                            }

                        }
                    } catch (IOException e) {
                        System.out.println("Error: " + e);
                    }
                    try {
                        File outputfile = new File(GetProcessedImgPathFromUser());
                        ImageIO.write(img, "jpg", outputfile);
                        System.out.println("Image After Processing>>>>");
                        System.out.println();
                    } catch (IOException e) {
                        System.out.println("Error: " + e);
                    }
                    break;
                case 5:
                    System.out.println("Enter Width: ");
                    width = kb.nextInt();
                    System.out.println("Enter Height: ");
                    height = kb.nextInt();
                    BufferedImage imgb = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
                    try {
                        File inputfile = new File(path);
                        imgb = ImageIO.read(inputfile);
                        for (int x = 0; x < width; x++) {
                            for (int y = 0; y < height; y++) {
                                a = (int) (Math.random() * 256);
                                r = (int) (Math.random() * 256);
                                g = (int) (Math.random() * 256);
                                b = (int) (Math.random() * 256);
                                p = (a << 24) | (r << 16) | (g << 8) | (b << 0);
                                imgb.setRGB(x, y, p);
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Error: " + e);
                    }
                    try {
                        File outputfile = new File(GetProcessedImgPathFromUser());
                        ImageIO.write(imgb, "jpg", outputfile);
                        System.out.println("Image After Processing>>>>");
                        System.out.println();
                    } catch (IOException e) {
                        System.out.println("Error: " + e);
                    }
                    break;
                case 6:
                    try{
                        File inputfile = new File(path);
                        img = ImageIO.read(inputfile);
                        System.out.println("Enter Value of a: ");
                        a = kb.nextInt();
                        System.out.println("Enter Value of r: ");
                        r = kb.nextInt();
                        System.out.println("Enter Value of g: ");
                        g = kb.nextInt();
                        System.out.println("Enter Value of b: ");
                        b = kb.nextInt();
                        p = (a<<24) | (r<<16) | (g<<8) | (b<<0);
                        System.out.println("The Set Pixel Value is: ");
                        System.out.println(p);
                        System.out.println();

                    }
                    catch (IOException e){
                        System.out.println("Error: " + e);
                    }
                case 7:
                    try{
                        File inputfile = new File(path);
                        img = ImageIO.read(inputfile);
                        width = img.getWidth();
                        height = img.getHeight();
                        for(int x=0; x<width; x++) {
                            for (int y = 0; y < height; y++) {
                                // Do not initialize x and y with '0'
                                // Calculate p
                                p = img.getRGB(x, y);
                                a = (p >> 24) & 0xff;
                                r = (p >> 16) & 0xff;
                                g = (p >> 8) & 0xff;
                                b = p & 0xff;
                                avg = (r + g + b) / 3;
                                p = (a << 24) | (avg << 16) | (avg << 8) | avg;
                                // Setting new Pixels
                                img.setRGB(x, y, p);

                            }
                        }
                    }
                    catch (IOException e){
                        System.out.println("Error: " + e);
                    }
                    try{
                        // Output the Image
                        File outputfile = new File(GetProcessedImgPathFromUser());
                        ImageIO.write(img, "jpg", outputfile);
                        System.out.println("Image After Processing>>>>");
                        System.out.println();
                    }
                    catch (IOException e){
                        System.out.println("Error: " + e);
                    }
                    break;
                case 8:
                    BufferedImage simg = null;
                    try{
                        File inputfile = new File(path);
                        simg = ImageIO.read(inputfile);
                    }
                    catch (IOException e){
                        System.out.println("Error" + e);
                    }
                    /*width = simg.getWidth();
                    height = simg.getHeight();
                    BufferedImage mimg = new BufferedImage(width*2, height, BufferedImage.TYPE_INT_ARGB);
                    for (int y=0; y<height; y++) {
                        for (int lx = 0, rx = width * 2 - 1; lx < width; lx++, rx--) {
                            p = simg.getRGB(lx, y);
                            mimg.setRGB(lx, y, p);
                            mimg.setRGB(rx, y, p);

                        }
                    }*/
                    width = simg.getWidth();
                    height = simg.getHeight();
                    //BufferedImage for mirror image
                    BufferedImage mimg = new BufferedImage(width*2, height, BufferedImage.TYPE_INT_ARGB);
                    //create mirror image pixel by pixel
                    for(int y = 0; y < height; y++){
                        for(int lx = 0, rx = width*2 - 1; lx < width; lx++, rx--){
                            //lx starts from the left side of the image
                            //rx starts from the right side of the image
                            //get source pixel value
                            p = simg.getRGB(lx, y);
                            //set mirror image pixel value - both left and right
                            mimg.setRGB(lx, y, p);
                            mimg.setRGB(rx, y, p);
                        }
                    }
                    try {
                        File outputfile = new File(GetProcessedImgPathFromUser());
                        ImageIO.write(mimg, "png", outputfile );
                        System.out.println("Image After Processing>>>>");
                    }
                    catch (IOException e){
                        System.out.println("Error" + e);
                    }
                    break;
                case 9:
                    String text = "\u00a9 Zayn Malik - This is a Text WaterMark";
                    File input = new File(path);
                    File output = new File(GetProcessedImgPathFromUser());

                    // adding text as overlay to an image
                    addTextWaterMark(text, "jpg", input, output);
                    System.out.println("Image After Processing>>>>");
                    System.out.println();
                    break;
                case 10:
                    /*ImageWriteParam.MODE_DISABLED – when this mode is set the
                    stream will not be tiled, progressive, or compressed*/
                    /*ImageWriteParam.MODE_DEFAULT – when this mode is enabled the
                    stream will be tiled, progressive, or compressed according to a sensible
                    default chosen internally by the writer in a plug-in dependent way*/
                    /*ImageWriteParam.MODE_EXPLICIT – when this mode is set the stream
                    will be tiled or compressed according to additional information supplied
                    to the corresponding set methods in this class. Note that this mode
                    is not supported for progressive output*/
                    /*ImageWriteParam.MODE_COPY_FROM_METADATA – when this mode is enabled the stream
                    will be tiled, progressive, or compressed based on the contents of stream
                    and/or image metadata passed into the write operation*/
                    try {
                        File inputfile = new File(path);
                        img = ImageIO.read(inputfile);
                        File outputfile = new File(GetProcessedImgPathFromUser());
                        OutputStream out = new FileOutputStream(outputfile);
                        ImageWriter writer = ImageIO.getImageWritersByFormatName("jpg").next();
                        ImageOutputStream ios = ImageIO.createImageOutputStream(outputfile);
                        writer.setOutput(ios);
                        ImageWriteParam param = writer.getDefaultWriteParam();
                        if (param.canWriteCompressed()){
                            param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
                            param.setCompressionQuality(0.05f);
                        }
                        writer.write(null, new IIOImage(img, null, null), param);
                        out.close();
                        ios.close();
                        writer.dispose();
                        System.out.println("Image After Processing>>>>");
                        System.out.println();
                    }
                    catch (IOException e){
                        System.out.println("Error" + e);
                    }
                    break;
                case 11:
                    int factor;
                    try {
                        File inputfile = new File(path);
                        img = ImageIO.read(inputfile);
                        //BufferedImage outputfile= new BufferedImage(img.getWidth(), img.getHeight(),BufferedImage.TYPE_INT_RGB);
                        System.out.println("By How much Factor the Brightness of the Image must be Increased(Factor can be between 0 to 100)");
                        factor = kb.nextInt();
                        width = img.getWidth();
                        height = img.getHeight();
                        for (int x=0; x<width; x++){
                            for (int y=0; y<height; y++){
                                Color c = new Color(img.getRGB(x, y));
                                 a = c.getAlpha() + factor;
                                 r = c.getRed() + factor;
                                 g = c.getGreen() + factor;
                                 b = c.getBlue() + factor;
                                if (r>=255){
                                    r = 255;
                                }
                                else if (r<0){
                                    r = 0;
                                }
                                else {
                                    r = c.getRed() + factor;
                                }
                                if (g>=255){
                                    g = 255;
                                }
                                else if(g<0){
                                    g = 0;
                                }
                                else {
                                    g = c.getGreen() + factor;
                                }
                                if (b>=255){
                                    b = 255;
                                }
                                else if(b<0){
                                    b = 0;
                                }
                                else {
                                    b = c.getBlue() + factor;
                                }
                                img.setRGB(x, y,new Color(r,g,b).getRGB());
                            }
                        }
                    }
                    catch (IOException e){
                        System.out.println("Error" + e);
                    }
                    try {
                        File Bright_output = new File(GetProcessedImgPathFromUser());
                        ImageIO.write(img,"jpg",Bright_output);
                        System.out.println("Image After Processing>>>>");
                        System.out.println();
                    }
                    catch (IOException e){
                        System.out.println("Error" + e);
                    }
                    break;
                case 12:
                    try {
                        File inputfile = new File(path);
                        img = ImageIO.read(inputfile);
                        //BufferedImage originalImage = ImageIO.read(inputfile);

                        BufferedImage blackAndWhiteImg = new BufferedImage(
                                img.getWidth(), img.getHeight(),
                                BufferedImage.TYPE_BYTE_BINARY);

                        Graphics2D graphics = blackAndWhiteImg.createGraphics();
                        graphics.drawImage(img, 0, 0, null);

                        ImageIO.write(blackAndWhiteImg, "png", new File(GetProcessedImgPathFromUser()));
                        System.out.println("Image After Processing>>>>");
                        System.out.println();
                    }
                    catch (IOException e){
                        System.out.println("Error" + e);
                    }
                    break;
                case 13:
                    finish();
                    System.exit(0);
                default:
                    System.out.println("Please enter a Valid Choice");
                    break;
            }
        }
        //Calling the Function finish after execution of while loop
    }
    //Function Declarations
    private static void addTextWaterMark(String text, String type, File source, File destination) throws IOException {
        BufferedImage image = ImageIO.read(source);

        // determine image type and handle correct transparency
        int imageType = "png".equalsIgnoreCase(type) ? BufferedImage.TYPE_INT_ARGB : BufferedImage.TYPE_INT_RGB;
        BufferedImage watermarked = new BufferedImage(image.getWidth(), image.getHeight(), imageType);

        // initializes necessary graphic properties
        Graphics2D w = (Graphics2D) watermarked.getGraphics();
        w.drawImage(image, 0, 0, null);
        AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f);
        w.setComposite(alphaChannel);
        w.setColor(Color.GRAY);
        w.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 26));
        FontMetrics fontMetrics = w.getFontMetrics();
        Rectangle2D rect = fontMetrics.getStringBounds(text, w);

        // calculate center of the image
        int centerX = (image.getWidth() - (int) rect.getWidth()) / 2;
        int centerY = image.getHeight() / 2;

        // add text overlay to the image
        w.drawString(text, centerX, centerY);
        ImageIO.write(watermarked, type, destination);
        w.dispose();
    }
    public static void welcome(){
        System.out.println();
        System.out.println("===Image Processing in Java===");
        System.out.println("This Program will smoothly process any Image");
        System.out.println("Enter the Path for jpeg, jpg or png Format of Images(Locally Present on your Machine)");
        System.out.println("For Example: /users/(your_user_name)/Desktop/Image_Name.jpg");
        System.out.println();
    }
    public static void finish(){
        System.out.println();
        System.out.println("Images Updated");
        System.out.println("You may now open the Images in the Specified Path");
        System.out.println("Enjoy!");
        System.out.println();
        System.out.println("Saurav Gajbhiye");
        System.out.println("Harshal Khandait");
        System.out.println();

    }
    public static String GetProcessedImgPathFromUser(){
        String ImgPathFromUser;
        Scanner kb1 = new Scanner(System.in);
        System.out.println("Enter Path for the Processed Image");
        System.out.println("That is where the Image Must be Stored After Processing");
        System.out.println("For Example: /users/(your_user_name)/Desktop/Image_Name.jpg");
        System.out.println();
        System.out.println(">>>>");
        ImgPathFromUser = kb1.nextLine();
        return ImgPathFromUser;
    }

}
