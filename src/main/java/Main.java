import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String img = "Image-Path";
        String zip = "Zip-Path";
        String out = "Output-Path";

        try {
            Hider.simpletrick(img, zip, out);
            System.out.println("Done successfully ;) ");
        } catch (IOException e) {
            System.err.println("Something went wrong: " + e.getMessage());
        }
    }

}