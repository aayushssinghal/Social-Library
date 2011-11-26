/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Project_Lib;
import DBPackage.basicLibrary;
import java.util.Random;
/**
 *
 * @author aayush
 */
public class RandomDataGenerator {
    
    public static basicLibrary[] generateBooks(int count) {
        return generateBooks(count, 1);
    }
    
    public static basicLibrary[] generateBooks(int count, int offset) {
        int ii = 0, accoffset = offset;
        basicLibrary[] books = null;
        try {
            books = new basicLibrary[count];
            
            if (books == null) {
                System.err.println("books is null");
            } else {
                System.err.println("books is not null : " + books);
            }
            for (ii = 0; ii < count; ii++) {
                books[ii] = new basicLibrary();
                
                books[ii].acc = ii + accoffset;
                books[ii].title = generateString();
                books[ii].author = generateString();
                books[ii].author = generateString();
                books[ii].publication = generateString();

                books[ii].edition = getRandomInteger(20);
                books[ii].volume = getRandomInteger(10);
                books[ii].year = getRandomInteger(60) + 1950;
                books[ii].pages = getRandomInteger(1000) + 30;

                books[ii].subject = generateString();
                books[ii].ddc = "";
                books[ii].sears = "";
            }
        } catch (java.lang.NullPointerException Ex) {
            System.out.println("null pointer exception at random data generator in " + ii + "th loop : " + Ex);
        }
        return books;
    }
    
    public static int getRandomInteger(int upperlimit) {
        double randomvalue = Math.random()*upperlimit;
        //System.out.println("double random value : " + randomvalue);
        return (int)(randomvalue);
    }
    
    public static String generateString(Random rng, String characters, int length) {
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }
    
    public static String generateString() {
        Random rng = new Random();
        String characters = " abcdefghijklmnopqrstrvwxyz";
        characters += characters.toUpperCase();
        int length = (int) ((Math.random()*1000)%10 + 5);
        return generateString(rng, characters, length);
    }
    
    /*
    public static void main(String args[]) {
        int a = getRandomInteger(100);
        String rstr = generateString();
        System.out.println("integer is : " + a);
        System.out.println("string  is : " + rstr);
        basicLibrary[] generateBooks = generateBooks(10);
        
    }
     * 
     */
}
