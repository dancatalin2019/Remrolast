import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Remorca;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import repository.RemorcaRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Optional;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sample.fxml"));
        primaryStage.setTitle("REMRO FLEET MANAGEMENT");
        primaryStage.setScene(new Scene(root, 429, 300));
        primaryStage.setMinHeight(100);
        primaryStage.setMinWidth(100);

        primaryStage.show();
    }

    public static void main(String[] args) throws Exception {

      /*  Remorca rem1 = new Remorca();
        rem1.setNr_Inmatriculare("B71TRE");
        rem1.setMasa_Utila(500);
        rem1.setMasa_Maxima(700);
        rem1.setModel("Opel");
        rem1.setNr_Identificare("xjz");

        Remorca rem2 = new Remorca();
        rem2.setNr_Inmatriculare("B72TRE");
        rem2.setMasa_Utila(500);
        rem2.setMasa_Maxima(700);
        rem2.setModel("Opel");
        rem2.setNr_Identificare("xjz");



//        remorcaRepository.save(entityManager, rem1);
//        remorcaRepository.save(entityManager, rem2);

        for (Remorca r : remorcaRepository.findAll(entityManager)) {
            System.out.println(r);
        }
        System.out.println("filter");

        for (Remorca r : remorcaRepository.findByName(entityManager, "B7%")) {
            System.out.println(r);
        }

        //Write the Document in file system
        FileOutputStream out = new FileOutputStream(new File("remrotest4.docx"));

        //Blank Document
        XWPFDocument document = new XWPFDocument();

// steps :
caut in document bookmarurile (e.g, caut numar_inmatriculare, si cu POI pot scrie in locul bookmarkului remorca.getNr_inmatriculare

        //create Paragraph
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText(
                "(1) Obiectul prezentului contract consta in darea in folosinta (inchirierea) de catre Locator, Locatarului a vehiculului descris la al.(2) din prezentul articol, proprietatea Locatorului, denumit in continuare in prezentul contract „vehicul”, in schimbul achitarii de catre Locatar a unui pret.\n" +
                        "(2) Vehiculul inchiriat are urmatoarele caracteristici:\n" +
                        "\n" +
                        "□    CATEGORIA:______________________________________________________\n" +
                        "□    MARCA:__________________________________________________________\n" +
                        "□    NR. DE INMATRICULARE:___________________________________________\n" +
                        "□    MASA UTILA:_________________________________________________Kg\n" +
                        "□    MASA total maxima autorizata:________________________________________Kg\n" +
                        "□    ALTE DATE:______________________________________________________\n" +
                        " (3) Pe toata durata contractului Locatorul isi pastreaza dreptul de proprietate deplina asupra vehiculului inchiriat, care face obiectul prezentului contract de inchiriere. Vehiculul este asigurat, asigurarea fiind operabila in conditiile legii si ale prezentului contract.\n" +
                        "(4) Locatarul declara ca va folosi vehiculul inchiriat pe teritoriul:\n" +
                        "□ in tara:______________________________________________________;\n" +
                        "□ in strainatate:_________________________________________________;\n" +
                        "Vehiculul poate fi folosit in strainatate doar cu acordul explicit in scris al Locatorului.\n" +
                        "(5) In cazul in care Locatar este o societate comerciala, in sensul prezentului contract, prin „Locatar” se intelege atat societatea comerciala cat si persoana fizica desemnata de aceasta sa conduca vehiculul, si inscrisa in prezentul contract.\n" +
                        "\n" +
                        "Art.3 Predarea-primirea vehiculului\n");

        document.write(out);
        out.close();
        System.out.println("createparagraph.docx written successfully");

*/
        Main.launch(args);


    }
}
