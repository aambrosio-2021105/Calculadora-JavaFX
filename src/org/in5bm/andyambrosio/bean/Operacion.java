
package org.in5bm.andyambrosio.bean;

/**
 *
 * @author Andy Josue Ambrosio Caal
 * @date 31/3/2022
 * Codigo academico:PE5BM
 * Grupo: 1
 * Jornada:Matutina
 * Carné:2021105
 */
public abstract class Operacion {
    //atributos o variables de instancia 
    private double numero1;
    private double numero2;
    private double resultado;
    private String operador;
    
    // Contructores
    
    //Constructor nulo o sin parametros
    public Operacion(){
        
    }
    // Contructor con parametros
    public Operacion(float numero1, float numero2){
        this.numero1=numero1;
        this.numero2=numero2;
    }
    //Metodos Getter's and Setter's

    public double getNumero1() {
        return numero1;
    }

    public void setNumero1(double numero1) {
        this.numero1 = numero1;
    }

    public double getNumero2() {
        return numero2;
    }

    public void setNumero2(double numero2) {
        this.numero2 = numero2;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }
    
    public abstract double operar();
        
    
    public abstract double operar(double numero1,double numero2);
        
    
}
