import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Som {
    public class SoundPlayer {

    public static void main(String[] args) {
        try {
            // Carrega o arquivo de som
            File soundFile = new File("caminho/para/seu/arquivo.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);

            // Obtém o Clip que será usado para reproduzir o som
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            // Reproduz o som
            clip.start();

            // Espera o som terminar antes de fechar
            clip.drain();
            clip.close();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}

}
