package restAssured_Sample;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Rhombus implements Serializable {
    private double width;
    private double height;
    
    public Rhombus(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    public double getWidth() {
        return width;
    }
    
    public double getHeight() {
        return height;
    }
    
    public void setWidth(int width) {
        this.width = width;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    public static void main(String[] args) {
        Rhombus r = new Rhombus(50, 100);
        
        double product = (double) r.getWidth() * r.getHeight();
        System.out.println("Product of width and height: " + product);
        
        try {
            Path utilsPath = Paths.get("utils");
            if (!Files.exists(utilsPath)) {
                Files.createDirectory(utilsPath);
            }
            
            FileOutputStream fileOut = new FileOutputStream("utils/rhombusSerialized");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(r);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in utils/rhombusSerialized file");
            
            Rhombus r2 = DeserializeRhombus();
            
            System.out.println("Deserialized Rhombus object:");
            System.out.println("Width = " + r2.getWidth());
            System.out.println("Height = " + r2.getHeight());
            
        } catch(IOException i) {
            i.printStackTrace();
        }
    }
    
    public static Rhombus DeserializeRhombus() throws IOException {
        try {
            FileInputStream fileIn = new FileInputStream("utils/rhombusSerialized");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Rhombus r = (Rhombus) in.readObject();
            in.close();
            fileIn.close();

            return r;
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException occurred: " + e.getMessage());
            return null;
        }
    }
}
