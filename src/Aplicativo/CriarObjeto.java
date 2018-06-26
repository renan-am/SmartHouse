package Aplicativo;

import Recursos.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class CriarObjeto {
    Casa casa;
    String comodo;
    ObservableList<String> items;
    String tipoObj;

    @FXML
    TextField nome;

    @FXML
    TextField potencia;

    @FXML
    ListView<String> lista;

    @FXML
    private Button btCriar;

    public CriarObjeto (){
        casa = Casa.getInstance();
        comodo = "";
        items = FXCollections.observableArrayList ();
        items.addAll(casa.getComodos());
    }

    @FXML
    public void initialize(){
        lista.setItems(items);
    }

    @FXML
    void selecaoLista(){
        comodo = items.get(lista.getSelectionModel().getSelectedIndex());
    }

    @FXML
    void acaoTV(){
        tipoObj = "TV";
    }

    @FXML
    void acaoAC(){
        tipoObj = "AC";
    }

    @FXML
    void acaoLuz(){
        tipoObj = "Luz";
    }


    @FXML
    void criarObjeto() {
        /*
        Objeto aux;
        if (tipoObj == "TV"){
            aux = new TV (nome.getText(), Integer.parseInt(potencia.getText()), comodo);
        } else if (tipoObj == "AC"){
            aux = new AC(nome.getText(), Integer.parseInt(potencia.getText()), comodo);
        } else if (tipoObj == "Luz") {
            aux = new Luz(nome.getText(), Integer.parseInt(potencia.getText()), comodo);
        }
*/
        Stage stage = (Stage) btCriar.getScene().getWindow();
        stage.close();
    }

}
