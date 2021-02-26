package templateMethod;
public class Midterm01 {
    public static void main(String[] args) {
        final String HOUSE = "house.png";
        final String IMAGE_FORMAT = "png";
       
        Template grey = new GreyImageConverter();
        Template inverse = new InverseImageConverter();
        Template sepia = new SepiaImageConverter();
        
       /* ImageConverter converter = new ImageConverter(IMAGE_FORMAT, new GreyImageConverter());
        converter.convert(HOUSE, "g_" + HOUSE);

        converter.setColorConverter(new InverseImageConverter());
        converter.convert(HOUSE, "i_" + HOUSE);

        converter.setColorConverter(new SepiaImageConverter());
        converter.convert(HOUSE, "s_" + HOUSE);
        */
        grey.templateMethod(HOUSE, "g_"+ HOUSE,IMAGE_FORMAT);
        inverse.templateMethod(HOUSE, "i_"+ HOUSE,IMAGE_FORMAT);
        sepia.templateMethod(HOUSE, "s_"+ HOUSE,IMAGE_FORMAT);
    }
}
