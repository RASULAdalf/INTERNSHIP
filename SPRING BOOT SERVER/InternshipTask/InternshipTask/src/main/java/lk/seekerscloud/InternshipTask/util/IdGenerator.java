package lk.seekerscloud.InternshipTask.util;

import org.springframework.stereotype.Service;

import java.util.Random;
@Service
public class IdGenerator {
    private final String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final Random randomNum = new Random();
    public GeneratedIDDto generateId(int num_of_char){
        StringBuilder generatedId = new StringBuilder(num_of_char);
        for (int i = 0; i < num_of_char; i++) {
            generatedId.append(characters.charAt(randomNum.nextInt(characters.length())));
        }
        return new GeneratedIDDto(generatedId.toString());
    }
}
