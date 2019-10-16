import model.Remorca;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws Exception{

        Remorca rem1=new Remorca();
        rem1.setNr_Inmatriculare("B65TRE");
        rem1.setMasa_Utila(500);
        rem1.setMasa_Maxima(700);
        rem1.setModel("Opel");
        rem1.setNr_Identificare("xjz");



        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Remorci");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();//mandatory to start a transaction in order to have file save

        entityManager.persist(rem1);//in this way we save student in table Student

        entityManager.getTransaction().commit();//to commit the transaction in database

        //Write the Document in file system
        FileOutputStream out = new FileOutputStream(new File("remrotest4.docx"));

        //Blank Document
        XWPFDocument document = new XWPFDocument();

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









    }
}
