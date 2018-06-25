package Aplicativo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class Controller  {

    Treino treino;

    @FXML
    Label nomeCasa;
    @FXML
    Label localCasa;
    @FXML
    Label comodosCasa;

    public Controller() {
        // treino = new Treino();
        try
        {
            FileInputStream fis = new FileInputStream("treino.sav");
            ObjectInputStream ois = new ObjectInputStream(fis);
            treino = (Treino) ois.readObject();
            ois.close();
            fis.close();
        }catch(IOException ioe){
            treino = Treino.getInstance();
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
        nomeCasa.setText("Casa: " + treino.nome);
        localCasa.setText("Local: " + treino.local);
        comodosCasa.setText("Comodos: " + treino.comodos);
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
            oos.writeObject(treino);
            oos.close();
            fos.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    @FXML
    void criarCasa() {
        Parent root;
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

}
