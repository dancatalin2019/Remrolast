import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Client;
import model.Remorca;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmark;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResourceAsStream("sample.fxml"));
        primaryStage.setTitle("REMRO FLEET MANAGEMENT");
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.setMinHeight(400);
        primaryStage.setMaxHeight(500);
        primaryStage.setMinWidth(700);
        primaryStage.setMaxWidth(800);

        primaryStage.show();
    }

    public static void main(String[] args) throws Exception {
        Client client1=new Client();
        client1.setC_Nume("Gligor");
        client1.setC_Nume("Ciprian");
        Remorca rem1 = new Remorca();
        //remorcaRepository.save(entityManager, rem1);
        //ClientRepository.save(Client, client1);


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



       remorcaRepository.save(entityManager, rem1);

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

        try {

            openFile("C:\\Users\\User\\IdeaProjects\\Remro\\src\\main\\resources\\template.docx");
            insertAtBookmark("nr_remorca", "B60TRE");
           saveAs("C:\\Users\\User\\IdeaProjects\\Remro\\src\\main\\resources\\contract.docx");
        }
        catch(Exception ex) {
            System.out.println("Caught a: " + ex.getClass().getName());
            System.out.println("Message: " + ex.getMessage());
            System.out.println("Stacktrace follows:.....");
            ex.printStackTrace(System.out);
        }

        Main.launch(args);



    }

    private static XWPFDocument document = null;

    public static void openFile(String filename) throws IOException {
        File file = null;
        FileInputStream fis = null;
        try {
            file = new File(filename);
            fis = new FileInputStream(file);
            document = new XWPFDocument(fis);
        }
        finally {
            try {
                if(fis != null) {
                    fis.close();
                    fis = null;
                }
            }
            catch(IOException ioEx) {
                // Swallow this exception. It would have occured onyl
                // when releasing the file handle and should not pose
                // problems to later processing.
            }
        }
    }

    public static void saveAs(String filename) throws IOException {
        File file = null;
        FileOutputStream fos = null;
        try {
            file = new File(filename);
            fos = new FileOutputStream(file);
            document.write(fos);
        }
        finally {
            if(fos != null) {
                fos.close();
                fos = null;
            }
        }
    }

    public static void insertAtBookmark(String bookmarkName, String bookmarkValue) {
        List<XWPFParagraph> paraList = null;
        Iterator<XWPFParagraph> paraIter = null;
        XWPFParagraph para = null;
        List<CTBookmark> bookmarkList = null;
        Iterator<CTBookmark> bookmarkIter = null;
        CTBookmark bookmark = null;
        XWPFRun run = null;

        paraList = document.getParagraphs();
        paraIter = paraList.iterator();

        while(paraIter.hasNext()) {
            para = paraIter.next();

            bookmarkList = para.getCTP().getBookmarkStartList();
            bookmarkIter = bookmarkList.iterator();

            while(bookmarkIter.hasNext()) {
                bookmark = bookmarkIter.next();
                if(bookmark.getName().equals(bookmarkName)) {
                    run = para.createRun();
                    run.setText(bookmarkValue);
                    para.getCTP().getDomNode().insertBefore(run.getCTR().getDomNode(), bookmark.getDomNode());
                }
            }
        }
    }
}
