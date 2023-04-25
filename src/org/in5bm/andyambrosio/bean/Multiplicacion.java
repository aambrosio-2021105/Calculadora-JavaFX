

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
public class Multiplicacion extends Operacion{
    @Override
    public double operar(){
        setResultado(getNumero1()*getNumero2());
        setOperador("x");
        return getResultado();
    }
    @Override
    public double operar(double numero1, double numero2){
        setNumero1(numero1);
        setNumero2(numero2);
        setOperador("x");
        setResultado(getNumero1()*getNumero2());
        return getResultado();
    }
}
