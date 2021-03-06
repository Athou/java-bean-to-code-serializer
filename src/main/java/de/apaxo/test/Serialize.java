package de.apaxo.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is a shortcut to use the {@link Object2CodeObjectOutputStream}
 * class.
 * 
 * @author Manue Blechschmidt <blechschmidt@apaxo.de>
 * 
 */
public class Serialize {

    private static final Logger log = Logger.getLogger(Serialize.class
            .getName());

    /**
     * This function serializes an object directly to code. You can use a static
     * import to use it.
     * 
     * import static de.apaxo.test.Serialize.object2code;
     * 
     * System.out.println(object2code(myBean));
     * 
     * @param o
     * @return
     */
    public static String object2code(Object o) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (Object2CodeObjectOutputStream object2CodeObjectOutputStream = new Object2CodeObjectOutputStream(
                byteArrayOutputStream)) {
            object2CodeObjectOutputStream.writeObject(o);
            return byteArrayOutputStream.toString();
        } catch (SecurityException e) {
            log.log(Level.WARNING, "Excetion was thrown", e);
            throw new RuntimeException(e);
        } catch (IOException e) {
            log.log(Level.WARNING, "Excetion was thrown", e);
            throw new RuntimeException(e);
        }
    }
}
