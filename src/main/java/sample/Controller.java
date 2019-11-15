package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import model.Antreprenor;
import model.Car;
import model.Client;
import model.Remorca;
import repository.*;
import repositoryCalculator.SumaRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.security.acl.Owner;
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
    public Tab tabCalculezSuma;
    public Label lblprimulnr;
    public Label lblal2leaNr;
    public TextField txtRezultat;
    public Button btnSuma;
    public Label lnlRezultat;
    public Tab tabCalcDiferenta;
    public MenuItem mnuItemSuma;
    public TextField txtPrimulNr;
    public TextField txtal2leaNr;
    public Tab tabAddOwner;
    public Label lblOwnerName;
    public Label lblOwnerSurname;
    public Label lblOwnerCity;
    public Label lblOwnerStreet;
    public Label lblOwnerHouseNr;
    public Label lblOwnerBI;
    public Label lblOwnerCNP;
    public Label lblOwnerPhone;
    public TextField txtOwnerName;
    public TextField txtOwnerSurname;
    public TextField txtOwnerCity;
    public TextField txtOwnerStreet;
    public TextField txtOwnerHouseNr;
    public TextField txtOwnerBI;
    public TextField txtOwnerCNP;
    public TextField txtAddOwnerPhone;
    public Button btnSaveOwnerMySQL;
    public Tab tabUpdateOwner;
    public MenuItem menuItemUpdateOwner;
    public AnchorPane tabAnchorPaneUpdateOwner;
    public ComboBox comboCNPOwnerUpdate;
    public Label lblCNPOwnerpdate;
    public Label lblNumeOwnerUpdate;
    public Label lblPrenumeOwnerUpdate;
    public TextField txtNumeOwnerUpdate;
    public TextField txtPrenumeOwnerUpdate;
    public TextField txtTelActualOwner;
    public Button btnUpdateTelOwner;
    public Label lblTelactualOwner;
    public Label lblNewPhoneOwner;
    public TextField txtTelOwnerUpdated;
    public Label lblNewStreetOwner;
    public TextField txtNewStreetOwnerName;
    public Button btnUpdateStreetlOwner;
    public TextField txtNewHouseNrOwnerName;
    public Label lblNewHouseNrOwner;
    public Button btnUpdateHouseNrOwner;
    public TextField txtNewBIOwnerName;
    public Label lblNewBIOwner;
    public Button btnUpdateBIOwner;
    public TextField txtNewCityOwnerName;
    public Label lblNewCityOwner;
    public Button btnUpdateCityIOwner;
    public TextField txtStreetCleintUpdate;
    public TextField txtHousNrCllientUpdate;
    public TextField txtBICllientUpdate;
    public TextField txtCityCllientUpdate;
    public Button btnUpdateHouseNrClient;
    public Button btnUpdateStreetClient;
    public Button btnUpdateBIClient;
    public Button btnUpdateCityClient;
    public Label lblStreetClient;
    public TextField txtStreetClient;
    public Label lblCityClient;
    public TextField txtCityClient;
    public Label lblHouseNrClient;
    public TextField txtHouseNrClient;


    private RemorcaRepository remorcaRepository;
    private ClientRepository clientRepository1;
    private CarRepository carRepository;
    private OwnerRepository ownerRepository;


    public void initialize() {
       tabPane.getTabs().remove(tabMain);
       tabPane.getTabs().remove(tabLogin);
        tabPane.getTabs().remove(tabAdaugClient);
        tabPane.getTabs().remove(tabAdaugCar);
        tabPane.getTabs().remove(tabDeleteCar);
        tabPane.getTabs().remove(tabUpdateClientandOwner);
        tabPane.getTabs().remove(tabDeleteREmorca);
        tabPane.getTabs().remove(tabAdaugRemorca);
        tabPane.getTabs().remove(tabCalcDiferenta);
        tabPane.getTabs().remove(tabCalculezSuma);
        tabPane.getTabs().remove(tabAddOwner);
        tabPane.getTabs().remove(tabUpdateOwner);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Remorci");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        remorcaRepository = new RemorcaRepository(entityManager);
        clientRepository1 = new ClientRepository(entityManager);
        carRepository =new CarRepository(entityManager);
        ownerRepository= new OwnerRepository(entityManager);
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
        client.setC_City(txtCityClient.getText());
        client.setC_House_nr(txtHouseNrClient.getText());
        client.setC_Street(txtStreetClient.getText());
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

    public void getSelectedClient(ActionEvent actionEvent)
    { if (comboBoxClientCNP.getSelectionModel().getSelectedIndex() != -1) {
        try
        {Client client = (Client) comboBoxClientCNP.getSelectionModel().getSelectedItem();
            txtCNPClient.setText(client.getC_cnp());
            txtFieldClientSurname.setText(String.valueOf(client.getC_Prenume()));
            txtFieldNumeClient.setText(String.valueOf(client.getC_Nume()));
        }
        catch (Exception ex)
        { System.out.println("Something wrong"); }
    }}

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
        clientRepository1.updateTelefon(comboCNPClientUpdate.getEditor().getText(),txtTelClientUpdated.getText());

    }

    public void openTabUpdateClientandOwner(ActionEvent actionEvent) {
        tabPane.getTabs().add(tabUpdateClientandOwner);
    }

    public void selectClientUpdateTel(ActionEvent actionEvent) {

        System.out.println(actionEvent.getEventType());
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
            txtTelClientUpdated.requestFocus();
            comboCNPClientUpdate.show();

        }
    }

    public void calculeazaSuma(ActionEvent actionEvent) {

        SumaRepository sr = new SumaRepository();
        int rez=sr.calculezSuma(Integer.parseInt(txtPrimulNr.getText()),Integer.parseInt(txtal2leaNr.getText()));
        txtRezultat.setText(rez + "");


    }

    public void openTabSuma(ActionEvent actionEvent) {
        tabPane.getTabs().add(tabCalculezSuma);
    }

    public void openTabDiferenta(ActionEvent actionEvent) {
        tabPane.getTabs().add(tabCalcDiferenta);

    }


    public void saveOwnerinMySQL(ActionEvent actionEvent) {
        Antreprenor antreprenor=new Antreprenor();
        antreprenor.setA_nume(txtOwnerName.getText());
        antreprenor.setA_prenume(txtOwnerSurname.getText());
        antreprenor.setA_telefon(txtAddOwnerPhone.getText());
        antreprenor.setCnp(txtOwnerCNP.getText());
        antreprenor.setSerie_Buletin(txtOwnerBI.getText());
        antreprenor.setStrada(txtOwnerStreet.getText());
        antreprenor.setA_nr_Casa(txtOwnerHouseNr.getText());
        antreprenor.setA_city(txtOwnerCity.getText());
        ownerRepository.saveOwner(antreprenor);


    }

    public void openTabAddOwner(ActionEvent actionEvent) {
        tabPane.getTabs().add(tabAddOwner);
    }

    public void selectOwnerUpdateTel(ActionEvent actionEvent) {
        System.out.println(actionEvent.getEventType());
        if (comboCNPOwnerUpdate.getSelectionModel().getSelectedIndex() != -1) {

            Antreprenor antreprenor = (Antreprenor) comboCNPOwnerUpdate.getSelectionModel().getSelectedItem();

            txtNumeOwnerUpdate.setText(antreprenor.getA_nume());
            txtPrenumeOwnerUpdate.setText(String.valueOf(antreprenor.getA_prenume()));

            txtTelActualOwner.setText(String.valueOf(antreprenor.getA_telefon()));
        }

    }
        


    public void bringMySQLCNPOwnerForTelupdate(KeyEvent keyEvent) {
        comboCNPOwnerUpdate.getItems().clear();
        if (comboCNPOwnerUpdate.getEditor().getText().length() >= 2) {
            List<Antreprenor> ownerList = ownerRepository.findCNP("%"+comboCNPOwnerUpdate.getEditor().getText()+"%");

            comboCNPOwnerUpdate.getItems()
                    .addAll(ownerList);
            txtTelOwnerUpdated.requestFocus();
            comboCNPOwnerUpdate.show();

        }
    }

    public void updateTelOwner(ActionEvent actionEvent) {
        ownerRepository.updateTelefonOwner(comboCNPOwnerUpdate.getEditor().getText(),txtTelOwnerUpdated.getText());

    }

    public void openTabUpdateOwner(ActionEvent actionEvent) {
        tabPane.getTabs().add(tabUpdateOwner);
    }

    public void updateStreetOwner(ActionEvent actionEvent) {
        ownerRepository.updateOwnerStreet(comboCNPOwnerUpdate.getEditor().getText(),txtNewStreetOwnerName.getText());

    }

    public void updateHouseNrOwner(ActionEvent actionEvent) {
        ownerRepository.updateHouseNrOwner(comboCNPOwnerUpdate.getEditor().getText(),txtNewHouseNrOwnerName.getText());
    }

    public void updateBIOwner(ActionEvent actionEvent) {
        ownerRepository.updateBIOwner(comboCNPOwnerUpdate.getEditor().getText(),txtNewBIOwnerName.getText());
    }

    public void updateCityOwner(ActionEvent actionEvent) {
        ownerRepository.updateCityOwner(comboCNPOwnerUpdate.getEditor().getText(),txtNewCityOwnerName.getText());
    }

    public void updateHouseNrClient(ActionEvent actionEvent) {
    }

    public void updateStreetClient(ActionEvent actionEvent) {
        clientRepository1.updateStreetClient(comboCNPClientUpdate.getEditor().getText(),txtStreetCleintUpdate.getText());
    }

    public void updateBIClient(ActionEvent actionEvent) {
    }

    public void updateCityClient(ActionEvent actionEvent) {
    }
}

