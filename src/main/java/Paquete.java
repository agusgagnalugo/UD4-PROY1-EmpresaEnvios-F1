/**
 * Un bulto físico que forma parte de un envío.
 *
 * @author Agustina Gagna Lugo
 */
public class Paquete {
    /** cm3 que equivalen a 1 kg a efectos de facturación */
    public static final double FACTOR_VOLUMETRICO = 5000;

    // TODO atributos: una Dimension y el peso real (kg)
    private Dimension dimension;
    private double pesoReal;
    /**
     * Crea un paquete a partir de una dimensión ya creada y su peso real (kg).
     */
    public Paquete(Dimension dimension, double peso) {
        pesoReal = peso;
        this.dimension = dimension;
    }

    /**
     * Crea un paquete a partir de sus medidas (cm) y su peso real (kg).
     * Sin duplicar el código del otro constructor.
     */
    public Paquete(double alto, double ancho, double largo, double peso) {
        this(new Dimension(alto, ancho, largo), peso);
    }

    public Dimension getDimension() {
        return dimension;
    }

    /**
     * @return el peso real en kg
     */
    public double getPeso() {
        return pesoReal;
    }

    /**
     * @return el volumen del paquete en cm3
     */

    // TODO (lee la decisión de diseño del enunciado)
    // He decidido que el volumen se calcule en Dimension por que el ya
    // tiene las tres medidas, y de ese modo Paquete solo tiene que hacer una llamada y no tres.
    // y en el caso que otra clase necesite el volumen, no tendrá que hacer de nuevo la multiplicación.
    public double calcularVolumen() {
        return dimension.calcularVolumen();
    }

    /**
     * @return el peso volumétrico en kg (volumen / FACTOR_VOLUMETRICO)
     */
    public double calcularPesoVolumetrico() {
        return calcularVolumen() / FACTOR_VOLUMETRICO;
    }

    /**
     * El peso facturable es el mayor entre el peso real y el volumétrico.
     *
     * @return el peso facturable en kg
     */
    public double calcularPesoFacturable() {
        // TODO
        return 0;
    }

    /**
     * @return por ejemplo "40.0 x 30.0 x 50.0 cm | 8.0 kg (facturable 12.0 kg)"
     */
    public String toString() {
        // TODO
        return "";
    }
}
