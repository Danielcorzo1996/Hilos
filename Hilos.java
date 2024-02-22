import javax.sound.sampled.*;
import java.io.*;

public class Hilos implements Runnable {

   private String rutaMusica;
    private String rutaLetra;

    public Hilos(String rutaMusica, String rutaLetra) {
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

    
   public static void main(String[] args) {
        // Rutas del archivo de música y del archivo de letra
        String rutaMusica = "C:\\Users\\DANIEL\\Desktop\\Hilos\\MeHaceDano.wav";
        String rutaLetra = "C:\\Users\\DANIEL\\Desktop\\Hilos\\letra.txt"; // Reemplaza con la ruta de tu archivo de letra

        // Crear un hilo para reproducir la música con la letra
        Thread hiloMusica = new Thread(new Hilos(rutaMusica, rutaLetra));

        // Iniciar el hilo para reproducir la música con la letra
        hiloMusica.start();
    }
    
}