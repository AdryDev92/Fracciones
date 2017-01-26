package org.thinway;

/**
 * Created by thinway on 24/1/17.
 */
public class Fraccion {
    private int numerador;
    private int denominador;

    // Constructores

    /**
     * Constructor sin parámetros. Creará una fracción del tipo 1/1.
     */
    public Fraccion(){
        this(1,1);
    }

    /**
     * Construye un objeto de la forma num/1.
     *
     * @param numerador entero que especifica el numerador.
     */
    public Fraccion(int numerador){
        this(numerador,1);
    }

    /**
     * Construye una fracción del tipo a/b
     *
     * @param numerador entero que especifica el numerador.
     * @param denominador entero que especifica el denominador.
     */
    public Fraccion(int numerador, int denominador){
        this.setNumerador(numerador);
        this.setDenominador(denominador);
    }
    // Accessors

    /**
     * Obtiene el valor del numerador.
     *
     * @return entero con el valor del numerador.
     */
    public int getNumerador() {
        return numerador;
    }

    /**
     * Asigna un valor al numerador.
     *
     * @param numerador entero que será asignado al numerador.
     */
    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    /**
     * Obtiene el valor del denominador.
     *
     * @return entero con el valor del denominador.
     */
    public int getDenominador() {
        return denominador;
    }

    /**
     * Asigna un valor al denominador.
     *
     * @param denominador entero que será asignado al denominador.
     */
    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }

    /**
     * Devuelve una representación en cadena de un objeto Fraccion.
     * La forma es numerador/denominador.
     *
     * @return Una cadena que representa al objeto Fraccion.
     */
    @Override public String toString(){
        return this.getNumerador() + "/" + denominador;
    }
}
