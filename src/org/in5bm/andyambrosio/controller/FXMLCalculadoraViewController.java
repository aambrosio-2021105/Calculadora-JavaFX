
package org.in5bm.andyambrosio.controller;
import java.util.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javax.swing.JOptionPane;
import org.in5bm.andyambrosio.bean.*;
import javafx.event.ActionEvent;
/**
 *
 * @author Andy Josue Ambrosio Caal
 * @date 31/3/2022
 * Codigo academico:PE5BM
 * Grupo: 1
 * Jornada:Matutina
 * Carné:2021105
 */
public class FXMLCalculadoraViewController implements Initializable {
    private double resultado=0;
    private double numero;
    private int contadorOperadores=0;
    private String operadorAnterior;
    private boolean ingreseNuevo=false;
    Operacion calc;

    @FXML
    private Label lblPantalla;
    @FXML
    private Button btnLimpiar;
    @FXML
    private Button btnPorciento;
    @FXML
    private Button btnDividir;
    @FXML
    private Button btnSiete;
    @FXML
    private Button btnCuatro;
    @FXML
    private Button btnUno;
    @FXML
    private Button btnInversoAditivo;
    @FXML
    private Button btnOcho;
    @FXML
    private Button btnCinco;
    @FXML
    private Button btnDos;
    @FXML
    private Button btnCero;
    @FXML
    private Button btnNueve;
    @FXML
    private Button btnSeis;
    @FXML
    private Button btnTres;
    @FXML
    private Button btoMultiplicar;
    @FXML
    private Button btnPunto;
    @FXML
    private Button btnResta;
    @FXML
    private Button btnSuma;
    @FXML
    private Button btnSalida;
    @FXML
    private Button btnInversoMultiplicacion;
    @FXML
    private Button btnRaiz;
    @FXML
    private Button btnCuadrado;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    public void actualizar(String digito){
        
        if(ingreseNuevo){
           lblPantalla.setText(" ");
        }
        String palabra=lblPantalla.getText();
        lblPantalla.setText(palabra.concat(digito));
        ingreseNuevo=false;

        
    }
    @FXML
    private void clicEliminar(){
        try{
            eliminar();
        }catch(NumberFormatException e){
            lblPantalla.setText("");
        }
        
    }
    public void eliminar(){
        String palabra=lblPantalla.getText();
        int num=palabra.length();
        if(num==0){
            lblPantalla.setText("");
        }else{
        
        palabra=palabra.substring(0,palabra.length()-1);
        
        lblPantalla.setText(palabra);
            contadorOperadores=0;
            ingreseNuevo=false;

          
        }
   
    }
    @FXML 
    private void clicNumero(ActionEvent event){
        if(event.getSource().equals(btnUno)){
            actualizar("1");
        }else if(event.getSource().equals(btnDos)){
            actualizar("2");
        }else if(event.getSource().equals(btnTres)){
            actualizar("3");
        }else if(event.getSource().equals(btnCuatro)){
            actualizar("4");
        }else if(event.getSource().equals(btnCinco)){
            actualizar("5");
        }else if(event.getSource().equals(btnSeis)){
            actualizar("6");
        }else if(event.getSource().equals(btnSiete)){
            actualizar("7");
        }else if(event.getSource().equals(btnOcho)){
            actualizar("8");
        }else if(event.getSource().equals(btnNueve)){
            actualizar("9");
        }else if(event.getSource().equals(btnCero)){       
            agregarCero();       
        }
    }
    @FXML 
    private void clicOperacion(ActionEvent event){
        if(event.getSource().equals(btnSuma)){
            calcular("+");
        }else if(event.getSource().equals(btnResta)){
            calcular("-");
        }else if(event.getSource().equals(btoMultiplicar)){
            calcular("×");
        }else if(event.getSource().equals(btnDividir)){
            calcular("÷");
        }else if(event.getSource().equals(btnPorciento)){
            calcular("%");
        }else if(event.getSource().equals(btnInversoAditivo)){
            inversoAditivo();
        }else if(event.getSource().equals(btnInversoMultiplicacion)){
             inversoMultiplicativo();
        }else if(event.getSource().equals(btnRaiz)){
            raiz();
        }else if(event.getSource().equals(btnCuadrado)){
            potencia(this.resultado);
        }
    }
    
    public void agregarCero(){
        if(ingreseNuevo) {
            lblPantalla.setText(" ");
            ingreseNuevo=false;
        } 
        if(!lblPantalla.getText().contains("0")) {
            actualizar("0");
            ingreseNuevo=false;
        } else if (Double.parseDouble(lblPantalla.getText()) != 0) {
            actualizar("0");     
        } else if(lblPantalla.getText().equals("0")) {
            actualizar("");          
        } else if(lblPantalla.getText().contains("0.")){
            actualizar("0");
        }
        ingreseNuevo=false;
    }
    
   
    
    @FXML
    private void clicPunto(ActionEvent event) {
        agregarPunto();
    }
    
    public void agregarPunto(){ 
        if(ingreseNuevo==true){
            lblPantalla.setText("");
        }
        String cadena=lblPantalla.getText();
        if(cadena.equals("")){
            actualizar("0.");
             ingreseNuevo=false;
             
        }else if(!(cadena.contains("."))){
            actualizar(".");
  
        }  

    }


    @FXML
    private void clicLimpiar(ActionEvent event) {
        limpiar();   
    }
    public void limpiar(){
        lblPantalla.setText("");
        resultado=0;
        numero=0;
        contadorOperadores=0;
        operadorAnterior="";
        ingreseNuevo=false;
    }
    
    @FXML
    private void clicIgual(ActionEvent event){
        try{
          calcular(String.valueOf(this.operadorAnterior));
        
        lblPantalla.setText(String.valueOf(this.resultado));
        }catch(NumberFormatException e){
            lblPantalla.setText(" ");
        }
        
    }
    private void calcular(String operador){
        
        
        if(!(lblPantalla.getText().equals(""))){
            String strPantalla = lblPantalla.getText();
            
            if(ingreseNuevo==false){
                this.numero=Double.parseDouble(strPantalla);
                contadorOperadores++;
                
                if(contadorOperadores==1 ){
                    this.resultado=numero;
                   
                }else if(contadorOperadores>=2){
                    
                    switch(operador){
                        case"+":
                            calc=new Suma();
                            this.resultado=calc.operar(resultado,numero);
                            break;
                        case"-":
                            calc=new Resta();
                            this.resultado=calc.operar(resultado,numero);
                            break;
                        case"÷":
                            if(this.numero==0){
                                lblPantalla.setText("0");
                            }else if(this.numero!=0){
                                calc=new Division();
                            this.resultado=calc.operar(resultado,numero);
                            }
                            break; 
                        case"×":
                            calc=new Multiplicacion();
                            this.resultado=calc.operar(resultado,numero);
                            break;
                        case"%":
                            calc=new Porcentaje();
                            this.resultado=calc.operar(resultado,numero);
                             break;
                        case "1/x":
                            calc =new InversoMultiplicativo();
                            if(numero==0){
                                lblPantalla.setText("0");
                            }else if(numero>0){
                                this.resultado=calc.operar(resultado,numero);
                            }
                            break;  
                        case"±":
                            calc = new InversoAditivo();
                            this.resultado=calc.operar(resultado,numero);
                            break;
                        case"√":
                            calc = new Raiz();
                            this.resultado=calc.operar(resultado,numero);
                            break;
                            
                    }
                    lblPantalla.setText(String.valueOf(this.resultado));
                }
            }
            this.operadorAnterior=operador;
            
        }
         ingreseNuevo=true;
    }
    @FXML
    private void clicSalir(){
        System.exit(0);
    }

    public void inversoAditivo(){
        
          contadorOperadores++;
          ingreseNuevo=false;
          resultado=-1;
          operadorAnterior="±";
          calcular("±");
    }
  
    public void inversoMultiplicativo(){
        try{
           contadorOperadores++;
           ingreseNuevo=false;
           resultado=1;
           operadorAnterior="1/x";
           calcular("1/x");      
        }catch(NumberFormatException e){
            lblPantalla.setText("0");
        }
               
        
       
    }
    
    public void raiz(){
        try{
           contadorOperadores++;
           ingreseNuevo=false;
           resultado=1;
           operadorAnterior="√";
           calcular("√");      
        }catch(NumberFormatException e){
            lblPantalla.setText("0");
        }
           
    }
    

    public void potencia(double numero){
        ElevadoCuadrado ob8=new ElevadoCuadrado();
        this.resultado=Double.parseDouble(lblPantalla.getText());
        double num=ob8.elevadoCuadrado(this.resultado);
        lblPantalla.setText(String.valueOf(num));
    }
    
    
    
    @FXML
    private void clicInformacion(){
         JOptionPane.showMessageDialog(null, "Version Java JDK 11 zulu\n"
                 +"Date: 18/3/2022 14:19:14\n"
                 +"Project folder:E: \\in5bm-calculadora-javafx-andy-ambrosio\n"
                 +"Autor: Andy Josue Ambrosio Caal\n"
                 +"Codigo academico: PE5BM\n"
                 +"Codigo tecnico: IN5BM"
                );
        
    }

   
}
