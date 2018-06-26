package Aplicativo;

import Recursos.Casa;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class Controller  {

    Casa casa;

    @FXML
    Label nomeCasa;
    @FXML
    Label localCasa;
    @FXML
    Label comodosCasa;

    public Controller() {
        Apoio.controller = this;

        try
        {
            FileInputStream fis = new FileInputStream("treino.sav");
            ObjectInputStream ois = new ObjectInputStream(fis);
            casa = (Casa) ois.readObject();
            ois.close();
            fis.close();
        }catch(IOException ioe){
            casa = Casa.getInstance();

            ioe.printStackTrace();
            return;
        }catch(ClassNotFoundException c){
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }

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
    void criarCasa() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("CriarCasa.fxml"));
            Stage stage = new Stage();
            stage.setTitle("My New Stage Title");
            stage.setScene(new Scene(fxmlLoader.load()));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(){
        nomeCasa.setText("Casa: " + casa.getNome());
        localCasa.setText("Local: " + casa.getEstado());
        comodosCasa.setText("Comodos: " + casa.getComodos().size());
    }

}
