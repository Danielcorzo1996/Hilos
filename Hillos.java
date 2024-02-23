import javax.sound.sampled.*;
import java.io.*;

public class Hillos implements Runnable {

   private String rutaMusica;
    private String rutaLetra;

    public Hillos(String rutaMusica, String rutaLetra) {
        this.rutaMusica = rutaMusica;
        this.rutaLetra = rutaLetra;
    }

    public void run() {
        try {
            // Cargar el archivo de música
            File archivoMusica = new File(rutaMusica);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoMusica);
            Clip clip = AudioSystem.getClip();

            // Abrir el clip y reproducir la música
            clip.open(audioStream);
            clip.start();

            // Leer y mostrar las letras de la canción
            BufferedReader br = new BufferedReader(new FileReader(rutaLetra));
            String linea;
            Thread.sleep(10000);
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);

                // Pausa de 2 segundos
                Thread.sleep(1000);
            }

            // Cerrar el clip y el lector de archivos
            clip.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

       
}