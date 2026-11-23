/**
 * Un envío agrupa los paquetes que un cliente manda a un mismo destino.
 * Un envío admite como máximo tres paquetes.
 *
 * Ninguno de los métodos de esta clase escribe en pantalla.
 *
 * @author
 */
public class Envio {
    //Elegí private porque es la más restrictiva y solo la usa la clase Envio.
    // Comprobé que ninguna otra clase la necesita, así que no hace falta hacerla public
    private static final int MAX_PAQUETES = 3;
    private String codigo;
    private String codigoPostal;
    private Paquete paquete1;
    private Paquete paquete2;
    private Paquete paquete3;
    /**
     * Crea un envío sin paquetes.
     *
     * @param codigo       código de seguimiento, p.ej. "PX00000001R"
     * @param codigoPostal código postal del destino, p.ej. "36202"
     */
    public Envio(String codigo, String codigoPostal) {
        this.codigo = codigo;
        this.codigoPostal = codigoPostal;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * @return cuántos paquetes tiene el envío (0 a 3)
     * Para mejorar el algoritmo: Los paquetes se añaden siempre en orden, así que nunca hay huecos entre ellos.
     */
    public int getNumeroPaquetes() {
        int contador = 0;

        if(paquete1 != null){
            contador++;
        }
        if(paquete2 != null){
            contador++;
        }
        if(paquete3 != null){
            contador++;
        }
        return contador;
    }

    /**
     * @return true si ya no se pueden añadir más paquetes
     */
    public boolean estaCompleto() {
        return getNumeroPaquetes() == MAX_PAQUETES;
    }

    /**
     * Añade un paquete al envío si no está completo.
     *
     * @return true si se ha añadido, false si el envío estaba completo
     */
    public boolean addPaquete(Paquete paquete) {
        if(estaCompleto()){
            return false;
        }
        if(paquete1 == null){
            paquete1 = paquete;
        }
        else if(paquete2 == null) {
            paquete2 = paquete;
        } else {
            paquete3 = paquete;
        }
        return true;
    }

    /**
     * Crea un paquete con las medidas y peso indicados y lo añade al envío.
     *
     * @return true si se ha añadido, false si el envío estaba completo
     */
    public boolean addPaquete(double alto, double ancho, double largo, double peso) {
        Paquete nuevoPaquete = new Paquete(alto,ancho,largo, peso);
        return addPaquete(nuevoPaquete);
    }
    /**
     * @return la suma de los pesos reales de los paquetes (kg)
     */
    public double calcularPesoReal() {
        double pesoRealTotal = 0;

        if(paquete1 != null){
            pesoRealTotal = pesoRealTotal + paquete1.getPeso();
        }
        if(paquete2 != null){
            pesoRealTotal = pesoRealTotal + paquete2.getPeso();
        }
        if(paquete3 != null){
            pesoRealTotal = pesoRealTotal + paquete3.getPeso();
        }
        return pesoRealTotal;
    }

    /**
     * Suma los pesos facturables de los paquetes y redondea hacia arriba
     * al kilo entero.
     *
     * @return el peso facturable del envío (kg enteros)
     */
    public double calcularPesoFacturable() {
        double pesoFacturableTotal = 0;
        if(paquete1 != null){
            pesoFacturableTotal = pesoFacturableTotal + paquete1.calcularPesoFacturable();
        }
        if(paquete2 != null){
            pesoFacturableTotal = pesoFacturableTotal + paquete2.calcularPesoFacturable();
        }
        if(paquete3 != null){
            pesoFacturableTotal = pesoFacturableTotal + paquete3.calcularPesoFacturable();
        }
        return Math.ceil(pesoFacturableTotal);

    }

    /**
     * @return el paquete de mayor peso real; si hay empate, el que se añadió
     * antes; null si el envío no tiene paquetes
     */
    public Paquete getPaqueteMasPesado() {
        // TODO
        return null;
    }

    /**
     * @return representación textual del envío (ver enunciado)
     */
    public String toString() {
        // TODO
        return "";
    }
}
