package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import model.Car;
import model.Client;
import model.Remorca;
import repository.ClientRepository;
import repository.Constants;
import repository.RemorcaRepository;
import repository.CarRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Controller {
    public PasswordField pswfield;
    public TextField txtfield;
    public Label lblName;
    public Label lblPasswaor;
    public Button btnLogin;
    public MenuItem mnuItemLogin;
    public Tab tabMain;
    public Tab tabLogin;
    public TabPane tabPane;

    public MenuItem tabLogOut;
    public TextField txtFieldCarNumber;
    public Label lbCarNumber;
    public TextField txtFieldMaxWeigth;
    public Label lbMaxWeigth;
    public TextField txtfieldUserName;
    public ComboBox comboBoxCarNumber;
    public Label lbUtilWeigth1;
    public TextField txtFieldUtilWeigth1;

    public MenuItem menuItemAddClient;
    public TextField txtNumeClient;
    public Label lblNameClient;
    public Label lblPrenumeClient;
    public TextField txtPreNumeClient;
    public Tab tabAdaugClient;
    public Label lblNumeClient;
    public TextField txtPrenumeClient;
    public Button btnSaveClient;
    public TextField txtSerieBuletin;
    public Label lblSerieBuletin;
    public Label lblCNPClient;
    public Label lblTelClient;
    public TextField txtCNPClient;
    public TextField txtTelClient;
    public Tab tabAdaugCar;
    public Label lblCarNumber;
    public Label lblCarRegNr;
    public TextField txtCarNumber;
    public TextField txtCarRegNr;
    public Button btnSaveCar;
    public TextField txtCarOem;
    public Label lblCarOem;
    public Label lblDataVerificare;
    public TextField txtDataVerificare;
    public ComboBox comboBoxClientCNP;
    public TextField txtFieldClientSurname;
    public TextField txtFieldNumeClient;
    public Tab tabDeleteCar;
    public AnchorPane anchorPaneDelRemorca;
    public Label lblSelectDelCar;
    public ComboBox cmbCartoDelete;
    public Button btnDeleteRemorca;
    public Tab tabUpdateClientandOwner;
    public Tab tabDeleteREmorca;
    public MenuBar menuBarUpdateVCientOwner;
    public MenuItem menuItemRemoveRemorca;
    public TextField txtRemorcadeleted;
    public TextField txtNrnmatriculare;
    public TextField txtMasaUtila;
    public TextField txtMasaMaxima;
    public TextField txtModel;
    public Label lblNrInmatriculare;
    public Label lblMasaUtile;
    public Label lblMasaMaxima;
    public Label lblModel;
    public Button btnSaveRemorca;
    public TextField txtNrnmatriculareRem;
    public TextField txtMasaUtilaRem;
    public TextField txtMasaMaximaRem;
    public TextField txtModelRem;
    public Tab tabAdaugRemorca;
    public MenuItem menuItemUpdateRemorca;
    public ComboBox comboCNPClientUpdate;
    public Label lblCNPClientUpdate;
    public Label lblNumeClientUpdate;
    public Label lblPrenumeClientUpdate;
    public TextField txtNumeClientUpdate;
    public TextField txtPrenumeClientUpdate;
    public TextField txtTelActualClient;
    public Button btnUpdateTelClient;
    public Label lblTelactualClient;
    public TextField txtTelClientUpdated;
    public AnchorPane tabAnchorPaneUpdateClientandOwner;


    private RemorcaRepository remorcaRepository;
    private ClientRepository clientRepository1;
    private CarRepository carRepository;

    public void initialize() {
       tabPane.getTabs().remove(tabMain);
       tabPane.getTabs().remove(tabLogin);
        tabPane.getTabs().remove(tabAdaugClient);
        tabPane.getTabs().remove(tabAdaugCar);
        tabPane.getTabs().remove(tabDeleteCar);
        tabPane.getTabs().remove(tabUpdateClientandOwner);
        tabPane.getTabs().remove(tabDeleteREmorca);
        tabPane.getTabs().remove(tabAdaugRemorca);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Remorci");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        remorcaRepository = new RemorcaRepository(entityManager);
        clientRepository1 = new ClientRepository(entityManager);
        carRepository =new CarRepository(entityManager);
        //remorcaRepository.findAll();
        //remorcaRepository.findByName("B62TRE");
        //clientRepository1.findAll();
        //clientRepository1.findCNP("1750520020044");
        //clientRepository1.FindClientbyCMP("1750520020044");
        //clientRepository1.DeleteClientbyCMP("1750520020044");
        //clientRepository1.updateTelefon("173547");
        //remorcaRepository.findByName("B62TRE");
        //remorcaRepository.DeleteRemorcabyNrInmatriculare("B62TRE");


    }


    public void loginUser(ActionEvent actionEvent) {
        if (txtfieldUserName.getText().equals(Constants.USERNAME)) {
            lblName.setTextFill(Color.BLACK);
            System.out.println(txtfieldUserName.getText());
        } else {
            lblName.setTextFill(Color.RED);
        }

        if (pswfield.getText().equals(Constants.PASSWORD)) {
            lblPasswaor.setTextFill(Color.BLACK);
            System.out.println(pswfield.getText());
        } else {
            lblPasswaor.setTextFill(Color.RED);
        }
        if (lblName.getTextFill().equals(Color.BLACK) && lblPasswaor.getTextFill().equals(Color.BLACK)) {
            tabPane.getTabs().add(tabMain);
            tabPane.getTabs().remove(tabLogin);

        }

    }

    public void openLogInWindow(ActionEvent actionEvent) {
        tabPane.getTabs().add(tabLogin);
    }

    public void logoutUser(ActionEvent actionEvent) {
        tabPane.getTabs().clear();
    }


    public void bringfromMySql(KeyEvent keyEvent) {
        comboBoxCarNumber.getItems().clear();
        if (comboBoxCarNumber.getEditor().getText().length() >= 2) {
            List<Remorca> remorcaList = remorcaRepository.findByName("%" + comboBoxCarNumber.getEditor().getText() + "%");

            comboBoxCarNumber.getItems()
                    .addAll(remorcaList);
            comboBoxCarNumber.show();
        }
    }

    public void getSelectedRemorca(ActionEvent actionEvent) {
        if (comboBoxCarNumber.getSelectionModel().getSelectedIndex() != -1) {
            Remorca remorca = (Remorca) comboBoxCarNumber.getSelectionModel().getSelectedItem();
            txtFieldCarNumber.setText(remorca.getNr_Inmatriculare());
            txtFieldMaxWeigth.setText(String.valueOf(remorca.getMasa_Maxima()));
            txtFieldUtilWeigth1.setText(String.valueOf(remorca.getMasa_Utila()));
        }
    }
    /*public void openLogInWindow(ActionEvent actionEvent) {
        tabPane.getTabs().add(tabLogin);
    }

    public void logoutUser(ActionEvent actionEvent) {
        tabPane.getTabs().clear();*/


    public void openTabAddClient(ActionEvent actionEvent) {
tabPane.getTabs().add(tabAdaugClient);
    }

    public void saveClient(ActionEvent actionEvent) {
        Client client = new Client();
        client.setC_Nume(txtNumeClient.getText());
        client.setC_Prenume(txtPrenumeClient.getText());
        client.setSerie_Buletin(txtSerieBuletin.getText());
        client.setC_cnp(txtCNPClient.getText());
        client.setC_nr_Telefon(txtTelClient.getText());
        clientRepository1.save(client);

    }

    public void saveCar(ActionEvent actionEvent) {
        Car car = new Car();
        car.setNr_Inmatriculare(txtCarNumber.getText());
        car.setNr_Identificare(txtCarRegNr.getText());
        car.setModel(txtCarOem.getText());
        carRepository.save(car);

    }

    public void openTabAddCar(ActionEvent actionEvent) {
        tabPane.getTabs().add(tabAdaugCar);
    }
    public void bringfromMySqlClient(KeyEvent keyEvent) {
        comboBoxClientCNP.getItems().clear();
        if (comboBoxClientCNP.getEditor().getText().length() >= 2) {
            List<Client> clientList = clientRepository1.findCNP("%"+comboBoxClientCNP.getEditor().getText()+"%");

            comboBoxClientCNP.getItems()
                    .addAll(clientList);
            comboBoxClientCNP.show();
        }
    }

    public void getSelectedClient(ActionEvent actionEvent) {
        if (comboBoxClientCNP.getSelectionModel().getSelectedIndex() != -1) {
            Client client = (Client) comboBoxClientCNP.getSelectionModel().getSelectedItem();
            txtCNPClient.setText(client.getC_cnp());
            txtFieldClientSurname.setText(String.valueOf(client.getC_Prenume()));
            txtFieldNumeClient.setText(String.valueOf(client.getC_Nume()));
        }
    }

    public void openTabDeleteRemorca(ActionEvent actionEvent) {
        tabPane.getTabs().add(tabDeleteREmorca);
    }

    public void getSelectedRemorcaforDelete(ActionEvent actionEvent)
    { if (cmbCartoDelete.getSelectionModel().getSelectedIndex() != -1)
    { try
    { Remorca remorca = (Remorca) cmbCartoDelete.getSelectionModel().getSelectedItem();
    txtRemorcadeleted.setText(remorca.getNr_Inmatriculare());
       }
    catch (Exception ex)
    { System.out.println("Something wrong"); }
    }
    }


    public void bringfromMySqlforDelete(KeyEvent keyEvent) {
        cmbCartoDelete.getItems().clear();
        if (cmbCartoDelete.getEditor().getText().length() >= 2) {
            List<Remorca> remorcaList = remorcaRepository.findByName("%" + cmbCartoDelete.getEditor().getText() + "%");

            cmbCartoDelete.getItems()
                    .addAll(remorcaList);
            cmbCartoDelete.show();
        }
    }

    public void deleteRemorcaByNrImatriculare(ActionEvent actionEvent) {
        cmbCartoDelete.getItems().clear();
        remorcaRepository.DeleteRemorcabyNrInmatriculare(txtRemorcadeleted.getText());

        txtRemorcadeleted.clear();


    }

    public void saveRemorcainMySQL(ActionEvent actionEvent) {
        Remorca remorca=new Remorca();
        remorca.setNr_Inmatriculare(txtNrnmatriculareRem.getText());
        remorca.setModel(txtModelRem.getText());
        remorca.setMasa_Maxima(txtMasaMaximaRem.getText());
        remorca.setMasa_Utila(txtMasaUtilaRem.getText());
        remorcaRepository.save(remorca);
    }

    public void openTabAddRemorca(ActionEvent actionEvent) {
        tabPane.getTabs().add(tabAdaugRemorca);
    }

    public void updateTelClient(ActionEvent actionEvent) {

    }

    public void openTabUpdateClientandOwner(ActionEvent actionEvent) {
        tabPane.getTabs().add(tabUpdateClientandOwner);
    }

    public void selectClientUpdateTel(ActionEvent actionEvent) {
        if (comboCNPClientUpdate.getSelectionModel().getSelectedIndex() != -1) {
            Client client = (Client) comboCNPClientUpdate.getSelectionModel().getSelectedItem();
            txtNumeClientUpdate.setText(client.getC_Nume());
            txtPrenumeClientUpdate.setText(String.valueOf(client.getC_Prenume()));

            txtTelActualClient.setText(String.valueOf(client.getC_nr_Telefon()));
        }

    }

    public void bringMySQLCNPClinetforTelupdate(KeyEvent keyEvent) {
        comboCNPClientUpdate.getItems().clear();
        if (comboCNPClientUpdate.getEditor().getText().length() >= 2) {
            List<Client> clientList = clientRepository1.findCNP("%"+comboCNPClientUpdate.getEditor().getText()+"%");

            comboCNPClientUpdate.getItems()
                    .addAll(clientList);
            comboCNPClientUpdate.show();
        }
    }
}

