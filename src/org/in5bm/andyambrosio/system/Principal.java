

package org.in5bm.andyambrosio.system;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author Andy Josue Ambrosio Caal
 * @date 31/3/2022
 * Codigo academico:PE5BM
 * Grupo: 1
 * Jornada:Matutina
 * Carné:2021105
 */
public class Principal extends Application{
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../view/FXMLCalculadoraView.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
       launch(args);
    }
}
