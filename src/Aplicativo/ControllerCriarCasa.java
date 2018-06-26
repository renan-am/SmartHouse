package Aplicativo;

import Recursos.Casa;
import Recursos.Estados;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ControllerCriarCasa {

    Casa casa;
    ObservableList<String> items;
    Estados local;

    @FXML
    TextField nome;

    @FXML
    TextField senha;

    @FXML
    TextField comodos;

    @FXML
    ListView<String> lista;

    @FXML
    private Button btCriar;


    public ControllerCriarCasa(){
        casa = Casa.getInstance();
        items = FXCollections.observableArrayList ();
    }

    @FXML
    void addLista() {
        if (comodos.getText() != "") {
            items.add(comodos.getText());
            comodos.setText("");
            lista.setItems(items);
        }
    }
    @FXML
    void acaoAmazonas(){
        local = Estados.AM;
    }
    @FXML
    void acaoBahia(){
        local = Estados.BA;
    }
    @FXML
    void acaoSP(){
        local = Estados.SP;
    }
    @FXML
    void acaoRS(){
        local = Estados.RS;
    }

    @FXML
    void criarCasa(){
        casa.setEstado(local);
        casa.setNome(nome.getText());
        casa.setNumComodos(items.size());
        ArrayList<String> temp = new ArrayList<String>();
        temp.addAll(items);
        casa.setComodos(temp);
        System.out.println(casa.getNome());

        Apoio.controller.atualizar();
        Stage stage = (Stage) btCriar.getScene().getWindow();
        stage.close();
    }
}
