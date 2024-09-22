package utils;

import java.io.*;
import java.util.Optional;
import java.util.logging.Logger;

public class RandomEmail {

    static Logger logger = Logger.getLogger(RandomEmail.class.getName());

    public static String getEmail(String template) throws IOException {
        String filename = "email_serial.txt";

        // read serial
        String serial;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            serial = br.readLine();
        }

        // generate email
        Integer newSerial = Optional.ofNullable(serial)
                .map(Integer::parseInt)
                .orElse(0) + 1;
        String email = template.replace("#", String.valueOf(newSerial));
        logger.info(email);

        // write serial
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(filename))) {
            bf.write(String.valueOf(newSerial));
        }

        return email;
    }


}
