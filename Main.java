public class Main {
    public static void main(String[] args) {
        // Rutas del archivo de música y del archivo de letra
        String rutaMusica = "C:\\Users\\DANIEL\\Desktop\\Hilos\\MeHaceDano.wav";
        String rutaLetra = "C:\\Users\\DANIEL\\Desktop\\Hilos\\letra.txt"; // Reemplaza con la ruta de tu archivo de letra

        // Crear un hilo para reproducir la música con la letra
        Thread hiloMusica = new Thread(new Hillos(rutaMusica, rutaLetra));

        // Iniciar el hilo para reproducir la música con la letra
        hiloMusica.start();
    }
}