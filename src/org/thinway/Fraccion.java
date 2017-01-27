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
        if(denominador != 0){
            this.setNumerador(numerador);
            this.setDenominador(denominador);
        } else {
            this.setNumerador(numerador);
            this.setDenominador(1);
        }


        this.simplificar();
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

    // Operaciones

    public void sumar(Fraccion frac){
        int mcm = minimoComunMultiplo(this.getDenominador(), frac.getDenominador());

        this.setNumerador(  mcm/this.getDenominador() * this.getNumerador() +
                            mcm/frac.getDenominador() * frac.getNumerador() );
        this.setDenominador( mcm );

        this.simplificar();

    }


    /**
     * Multiplica dos fracciones y guarda el resultado en la instancia
     * que lo invoca.
     *
     * @param frac Fracción que será el segundo operando de la multiplicación.
     */
    public void multiplicar(Fraccion frac){
        this.setNumerador(this.getNumerador()*frac.getNumerador());
        this.setDenominador(this.getDenominador()*frac.getDenominador());

        this.simplificar();
    }

    /**
     * Multiplica dos fracciones y guarda el resultado en la instancia
     * que lo invoca.
     *
     * @param frac Fracción que será el segundo operando de la multiplicación.
     */
    public Fraccion multiply(Fraccion frac){
        Fraccion resultado = new Fraccion();

        resultado.setNumerador(this.getNumerador()*frac.getNumerador());
        resultado.setDenominador(this.getDenominador()*frac.getDenominador());

        resultado.simplificar();

        return resultado;
    }

    /**
     * Divide dos fracciones y guarda el resultado en la instancia
     * que lo invoca.
     *
     * @param frac Fracción que será el segundo operando de la multiplicación.
     */
    public void dividir(Fraccion frac){
        this.setNumerador(this.getNumerador()*frac.getDenominador());
        this.setDenominador(this.getDenominador()*frac.getNumerador());

        this.simplificar();
    }


    // Helpers

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public int mcd(int a, int b){
        // a: 537, b: 50
        a = Math.abs(a);
        b = Math.abs(b);

        if (a < b){
            int aux = a;
            a = b;
            b = aux;
        }

        int resto = a % b;

        while( resto!= 0){
            b = resto;
            resto = a % b;
            a = b;
        }

        return b;
    }

    private int minimoComunMultiplo(int a, int b){
        return ((a*b) / mcd(a,b));
    }

    private void simplificar(){
        int maxDiv = mcd(this.getNumerador(),
                        this.getDenominador());

        this.setNumerador(this.getNumerador()/maxDiv);
        this.setDenominador(this.getDenominador()/maxDiv);
    }
}
