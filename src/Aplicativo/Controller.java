package Aplicativo;

import Recursos.Casa;
import Recursos.Objeto;
import Recursos.TV;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class Controller  {

    Objeto objeto;
    Casa casa;
    ObservableList<String> items;

    @FXML
    Label status;
    @FXML
    Label nomeCasa;
    @FXML
    Label localCasa;
    @FXML
    Label comodosCasa;

    @FXML
    TextField canal;
    @FXML
    TextField brilho;
    @FXML
    TextField contraste;

    @FXML
    ListView lista;

    public Controller() {
        Apoio.controller = this;
        items = FXCollections.observableArrayList ();
        casa = Casa.getInstance();
        objeto = null;

    }

    @FXML
    public void initialize(){
        nomeCasa.setText("Casa: ");
        localCasa.setText("Local: ");
        comodosCasa.setText("Comodos: ");
    }

    @FXML
    void Salvar(){

        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("SAV files (*.sav)", "*.sav");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show save file dialog
        File file = fileChooser.showSaveDialog(new Stage());

        try{
            FileOutputStream fos= new FileOutputStream(file);
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(casa);
            oos.close();
            fos.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    @FXML
    void Carregar(){

        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("SAV files (*.sav)", "*.sav");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show save file dialog
        File file = fileChooser.showOpenDialog(new Stage());

        try
        {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            casa = (Casa) ois.readObject();
            ois.close();
            fis.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
            return;
        }catch(ClassNotFoundException c){
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }

        atualizar();
    }

    @FXML
    void criarCasa() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("CriarCasa.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Criar Casa");
            stage.setScene(new Scene(fxmlLoader.load()));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void criarObjeto() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("CriarObjeto.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Adicionar Objeto");
            stage.setScene(new Scene(fxmlLoader.load()));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void selecaoLista(){
        String aux;
        aux = items.get(lista.getSelectionModel().getSelectedIndex());
        for (Objeto i : casa.getObjetos()){
            if (i.getNome() == aux){
                objeto = i;
                System.out.println(objeto.getNome());
                break;
            }
        }

        atualizar();

    }

    public void atualizar(){
        nomeCasa.setText("Casa: " + casa.getNome());
        localCasa.setText("Local: " + casa.getEstado());
        comodosCasa.setText("Comodos: " + casa.getComodos().size());


        items.setAll(casa.getObjetosString());
        lista.setItems(items);

        if (objeto != null)
        status.setText(objeto.getNome());
    }

    @FXML
    void ligar(){
        if (objeto instanceof TV){
            objeto.setEstado(true);
        }

        status.setText("On");
    }

    @FXML
    public void enviar(){
        if (objeto instanceof TV){
            ((TV) objeto).setCanal(Integer.parseInt(canal.getText()));
            ((TV) objeto).setBrilho(Integer.parseInt(brilho.getText()));
            ((TV) objeto).setContraste(Integer.parseInt(contraste.getText()));
        }
    }


}
