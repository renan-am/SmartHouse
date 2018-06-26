package Aplicativo;

import Recursos.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class Controller  {

    Objeto objeto;
    Casa casa;
    ObservableList<String> items;
    QualidadeLuz intensidade;
    QualidadeLuz cor;

    @FXML
    MenuButton menuInte;

    @FXML
    MenuButton menuCor;


    @FXML
    Label status;
    @FXML
    Label statusAC;
    @FXML
    Label statusLuz;
    @FXML
    Label nomeCasa;
    @FXML
    Label localCasa;
    @FXML
    Label comodosCasa;
    @FXML
    Label energia;
    @FXML
    Label preco;

    @FXML
    Label volumeAtual;
    @FXML
    Label canalAtual;
    @FXML
    Label brilhoAtual;
    @FXML
    Label constrasteAtual;
    @FXML
    Label temperaturaAtual;

    @FXML
    Label intensidadeAtual;
    @FXML
    Label corAtual;

    @FXML
    Pane paneTV;
    @FXML
    Pane paneAC;
    @FXML
    Pane paneLuz;

    @FXML
    TextField canal;
    @FXML
    TextField volume;
    @FXML
    TextField brilho;
    @FXML
    TextField contraste;

    @FXML
    TextField temperatura;



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

        atualizarPanes();

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

    public void atualizarPanes(){
        paneTV.setVisible(false);
        paneAC.setVisible(false);
        paneLuz.setVisible(false);

        if (objeto instanceof TV) {
            if (objeto.isEstado())
                status.setText("On");
            else
                status.setText("Off");
            paneTV.setVisible(true);
            canalAtual.setText("" + ((TV) objeto).getCanal());
            volumeAtual.setText("" + ((TV) objeto).getVolume());
            brilhoAtual.setText("" + ((TV) objeto).getBrilho());
            constrasteAtual.setText("" + ((TV) objeto).getContraste());
        } else if (objeto instanceof AC) {
            if (objeto.isEstado())
                statusAC.setText("On");
            else
                statusAC.setText("Off");
            paneAC.setVisible(true);
            temperaturaAtual.setText("" + ((AC) objeto).getTemperatura() + "ºC");
        } else if (objeto instanceof Luz) {
            if (objeto.isEstado())
                statusLuz.setText("On");
            else
                statusLuz.setText("Off");
            paneLuz.setVisible(true);
            intensidadeAtual.setText(((Luz) objeto).getIntensidade().toString());
            corAtual.setText(((Luz) objeto).getCor().toString());

        }
    }

    @FXML
    void ligar(){

            if (objeto.isEstado()) {
                objeto.setEstado(false);
                status.setText("Off");
                statusAC.setText("Off");
                statusLuz.setText("Off");
            } else {
                objeto.setEstado(true);
                status.setText("On");
                statusAC.setText("On");
                statusLuz.setText("On");
            }


    }

    @FXML
    public void enviar(){
        if (objeto instanceof TV){
            if(Integer.parseInt(canal.getText()) != 0)
                ((TV) objeto).setCanal(Integer.parseInt(canal.getText()));
            if(Integer.parseInt(volume.getText()) != 0) {
                try {
                    ((TV) objeto).setVolume(Integer.parseInt(volume.getText()));
                } catch (MinhaExcecao minhaExcecao) {
                    minhaExcecao.printStackTrace();
                }
            }
            if(Integer.parseInt(brilho.getText()) != 0)
                ((TV) objeto).setBrilho(Integer.parseInt(brilho.getText()));
            if(Integer.parseInt(contraste.getText()) != 0)
                ((TV) objeto).setContraste(Integer.parseInt(contraste.getText()));
        } else if (objeto instanceof AC){
            if(Integer.parseInt(temperatura.getText()) != 0) {
                try {
                    ((AC) objeto).setTemperatura(Integer.parseInt(temperatura.getText()));
                } catch (MinhaExcecao minhaExcecao) {
                    minhaExcecao.printStackTrace();
                }
            }
        } else if (objeto instanceof Luz){
            ((Luz) objeto).setIntensidade(intensidade);
            ((Luz) objeto).setCor(cor);


        }

        atualizarPanes();
    }

    @FXML
    void acaoFraca(){
        intensidade = QualidadeLuz.BAIXA;
        menuInte.setText("Fraca");
    }

    @FXML
    void acaoMedia(){
        intensidade = QualidadeLuz.MEDIA;
        menuInte.setText("Media");
    }
    @FXML
    void acaoForte(){
        intensidade = QualidadeLuz.ALTA;
        menuInte.setText("Forte");
    }

    @FXML
    void acaoAzul(){
        cor = QualidadeLuz.AZUL;
        menuCor.setText("Azul");
    }

    @FXML
    void acaoVermerlha(){
        cor = QualidadeLuz.VERMELHO;
        menuCor.setText("Vermelho");
    }
    @FXML
    void acaoVerde(){
        cor = QualidadeLuz.VERDE;
        menuCor.setText("Verde");
    }

    @FXML
    public void consumoEnergia(){

        energia.setText("" + String.format("%.2f", casa.consumoTotal()) +"kWh");
        preco.setText("R$ " + String.format("%.2f", casa.consumoTotal()/casa.getPreco()));
    }


}
