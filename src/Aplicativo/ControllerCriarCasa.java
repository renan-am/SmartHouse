package Aplicativo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class ControllerCriarCasa {

    ObservableList<String> items;

    @FXML
    TextField comodos;

    @FXML
    ListView<String> lista;

    public ControllerCriarCasa(){
        items = FXCollections.observableArrayList ();
    }

    @FXML
    void addLista() {
        if (comodos.getText() == "") {
            items.add(comodos.getText());
            comodos.setText("");
            lista.setItems(items);
        }
    }
}
