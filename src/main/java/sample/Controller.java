package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import model.Car;
import model.Client;
import model.Remorca;
import repository.Constants;
import repository.RemorcaRepository;
import repository.carRepository;
import repository.clientRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

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

    private RemorcaRepository remorcaRepository;
    private clientRepository clientRepository1;
    private carRepository carRepository;

    public void initialize() {
       tabPane.getTabs().remove(tabMain);
       tabPane.getTabs().remove(tabLogin);
        tabPane.getTabs().remove(tabAdaugClient);
        tabPane.getTabs().remove(tabAdaugCar);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Remorci");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        remorcaRepository = new RemorcaRepository(entityManager);
        clientRepository1 = new clientRepository(entityManager);
        carRepository =new carRepository(entityManager);
        remorcaRepository.findAll();
        clientRepository1.findAll();


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
}

