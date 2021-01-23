package com.saidproject.saidproject.report;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import static com.saidproject.saidproject.report.ReportGeneratorApi.addCustomHeadingStyle;
import static com.saidproject.saidproject.report.ReportGeneratorApi.addEnter;
import static com.saidproject.saidproject.report.ReportGeneratorApi.addPageToTOC;
import static com.saidproject.saidproject.report.ReportGeneratorApi.addTableOfContent;
import static com.saidproject.saidproject.report.ReportGeneratorApi.addTextToParagraph;
import static com.saidproject.saidproject.report.ReportGeneratorApi.createBulletList;
import static com.saidproject.saidproject.report.ReportGeneratorApi.createHeaderAndFooter;
import static com.saidproject.saidproject.report.ReportGeneratorApi.pageBreak;

public class ReportGenerator {
    public static void main(String[] args) throws IOException {
        //main document object
        XWPFDocument document = new XWPFDocument();

        //header
        //footer
        createHeaderAndFooter(document);

        //title page
        addEnter(document);
        addEnter(document);
        addEnter(document);
        addTextToParagraph(document.createParagraph(), 24, true, ParagraphAlignment.CENTER, "Protokół Badania");
        addTextToParagraph(document.createParagraph(), 24, false, ParagraphAlignment.CENTER, "Hydrantów zewnętrznych na terenie Gminy Nowosolna");
        pageBreak(document);

        //second page is always empty
        pageBreak(document);

//        //create table of content
        document.createTOC();
        addCustomHeadingStyle(document, "heading 1", 1);
        addCustomHeadingStyle(document, "heading 2", 2);
        addCustomHeadingStyle(document, "heading 3", 3);
        addTableOfContent(document);
        pageBreak(document);


        //general information
        addPageToTOC(document, "Informacje ogólne", "heading 1");
        addEnter(document);
        addEnter(document);
        addTextToParagraph(document.createParagraph(), ParagraphAlignment.LEFT, "Badania wykonano w oparciu o");
        List<String> generalInfo = Arrays.asList(
                "Rozporządzenie Ministra Infrastruktury z dnia 12 kwietnia 2002 r. w sprawie warunków technicznych jakim powinny odpowiadać budynki i ich usytuowanie (Dz. U. Nr 75 poz. 690 z późn. zm.)",
                "Rozporządzenie Ministra Spraw Wewnętrznych i Administracji z dnia 7 czerwca 2010 w sprawie ochrony przeciwpożarowej budynków, innych obiektów budowlanych i terenów (Dz. U. Nr 109 poz. 719)",
                "Rozporządzenie Ministra Spraw Wewnętrznych i Administracji z dnia 24 lipca 2009 w sprawie przeciwpożarowego zaopatrzenia w wodę oraz dróg pożarowych (Dz. U. Nr 124 poz. 1030),",
                "Rozporządzenie Ministra Gospodarki z 21 listopada 2005 roku w sprawie warunków technicznych jakim powinny odpowiadać bazy i stacje paliw płynnych, rurociągi przesyłowe dalekosiężne służące do transportu ropy naftowej i produktów naftowych i ich usytuowanie, (Dz. U. Nr 243, poz. 2063)",
                "PN-EN ISO 5167 -1 do 4 Pomiary strumienia płynu za pomocą zwężek pomiarowych wbudowanych w rurociąg.",
                "PN – 97/B – 02865 – „Ochrona przeciwpożarowa budynków. Przeciwpożarowe zaoptrzenie wodne. Instalacja wodociągowa przeciwpożarowa” (dla hydrantów innych niż zgodne z PN–EN i starych).");
        createBulletList(document,generalInfo);
        pageBreak(document);

        //norm requirements
        addPageToTOC(document, "Wymagania przepisów i norm.", "heading 1");
        addEnter(document);
        addPageToTOC(document, "Wydajność i ciśnienie na hydrancie zewnętrznym", "heading 2");
        addTextToParagraph(document.createParagraph(), ParagraphAlignment.LEFT, "Obowiązują następujące minimalne wydajności hydrantów zewnętrznych: ");
        List<String> hydrantEfficiencies = Arrays.asList("Hydrantu nadziemnego DN 80 – 10 dm3/s",
                "Hydrantu nadziemnego DN 100 – 15 dm3/s",
                "Hydrantu podziemnego DN 80 – 10 dm3/s",
                "Hydrantu nadziemnego DN 150 – 20 dm3/s");
        createBulletList(document,hydrantEfficiencies);
        addEnter(document);
        addPageToTOC(document, "Sposób dokonywania pomiarów", "heading 2");
        addTextToParagraph(document.createParagraph(), ParagraphAlignment.BOTH, "\tZgodnie z rozporządzeniem Ministra Spraw Wewnętrznych i Administracji w sprawie przeciwpożarowego zaopatrzenia w wodę oraz dróg pożarowych (Dz. U. Nr 124 poz. 1030) instalacja wodociągowa hydrantów zewnętrznych");
        pageBreak(document);

        //measurement using Hydro-test
        addPageToTOC(document, "Metodyka pomiarów urządzeniem Hydro-test.", "heading 1");
        addEnter(document);
        addTextToParagraph(document.createParagraph(), ParagraphAlignment.BOTH, "Metodykę pomiarów określa Dokumentacja Techniczno – Ruchowa wydana przez producenta w oparciu o świadectwo dopuszczeń badań Politechniki Białostockiej Laboratorium Mechaniki Płynów ZWM.");
        addEnter(document);
        addTextToParagraph(document.createParagraph(), ParagraphAlignment.BOTH, "Urządzenie pomiarowe składa się z:");
        List<String> measurementTool = Arrays.asList(
                "Elektroniczne urządzenie pomiarowe HT – 02 służące do odczytu ciśnienia statycznego i dynamicznego oraz akcją kalibracji, godziny, daty, transmisji danych, odczytu wyników wraz z futerałem, kablem, manometrem w klasie 1,6 z szybkozłączką typu męskiego i programem komputerowym mini-Hydro",
                "Wąż tłoczny z wykładziną gumową W 75/2 m zakończony łącznikami tłocznymi 75 – 1 kpl.",
                "Wąż tłoczny z wykładziną gumową W 52/1,5 m zakończony łącznikami tłocznymi 52 – 1 kpl.",
                "Wąż tłoczny z wykładziną gumową W 25/1,5 m zakończony łącznikami tłocznymi 25 – 1 kpl.",
                "Kolektor z uchwytem, nasadami 52 i szybkozłączką typu żeńskiego z zaworem kulowym 1 szt.",
                "Kolektor z uchwytem, nasadami 25 i szybkozłączką typu żeńskiego z zaworem kulowym 1 szt.",
                "Pokrywa nasady 75",
                "Dysze równoważne wzorcowane z wyznaczonym współczynnikiem K i wydajnością Q DR 10/K",
                "42/Q 60 dm3/min – 1 dm3/s 0,2 MPa – 1 szt; DR 13/K85/Q 120 dm3/min – 2 dm3/s -,2 MPa –1 szt.; DR 13/K110/Q 150 dm3/min – 2,5 dm3/s 0,2 MPa – 1 szt.",
                "Dysze pomiarowe wzorcowane z wyznaczoną wydajnością Q DP 26/Q 600 dm3/ min –10 dm3/s 0,2 MPa – 2 szt.; DP 32/Q 900 dm3/min – 15 dm3/s 0,2 MPa – 2 szt.",
                "Przełącznik 25/52 – 1 szt",
                "Przełącznik 75/52 – 1 szt",
                "Manometr o zakresie 0-1,6 MPa w klasie 1.6 wraz gumową osłoną i szybkozłączką typu męskiego",
                "Walizka profesjonalna Stanley – 1 szt.",
                "Materiały pomocnicze w języku polskim – 1 szt."
        );
        createBulletList(document, measurementTool);
        pageBreak(document);

        addTextToParagraph(document.createParagraph(), ParagraphAlignment.LEFT, "Parametry techniczne:");
        addTextToParagraph(document.createParagraph(), ParagraphAlignment.BOTH, "\tZastosowana technika pomiaru wydajności przyrządem HYDRO – TEST oparta jest na zjawisku Bernoulliego i klasycznej metodzie pomiaru dyszami, zwężkami i kryzami stosowanymi powszechnie w technice pomiarowej laboratoryjnej i przemysłowej. Zastosowane wzorcowane dysze równoważne odpowiadają wymaganiom stawianym przy tego typu pomiarach a szczegółowo określonych w normach.");
        addTextToParagraph(document.createParagraph(), ParagraphAlignment.LEFT, "Błąd pomiaru wydajności wzorcowanymi dyszami równoważnymi wynosi odpowiednio:");
        addTextToParagraph(document.createParagraph(), ParagraphAlignment.LEFT, "- dla błędu wzorcowania dyszy równoważnej wynoszącego ΔK = 2 % błąd pomiaru wydajności wynosi ΔQ = 2%");
        addTextToParagraph(document.createParagraph(), ParagraphAlignment.LEFT, "- przy błędzie dokładności pomiaru ciśnienia wynoszącego Δp = 1,6% błąd pomiaru wydajności wynosi odpowiednio ΔQ = 0.8%");
        addTextToParagraph(document.createParagraph(), ParagraphAlignment.LEFT, "- maksymalny błąd pomiaru wydajności hydrantów wzorcowanymi dyszami równoważnymi przy zakładanych maksymalnych błędach wzorcowania dysz równoważnych i wskazań manometru obliczony ze wzoru ΔQ=f(ΔK, Δp) wynosi odpowiednio:");
        List<String> deltas = Arrays.asList(
                "DK = 2% i Δp = 1,6 % błąd pomiaru ΔQ = 2,79%.",
                "DK = 0% i Δp = 1,6 % błąd pomiaru ΔQ = 0,80%.",
                "DK = 0,5% i Δp = 0,6 % błąd pomiaru ΔQ = 0,80%."
        );
        createBulletList(document, deltas);
        pageBreak(document);


        //Annual Conservations
        addPageToTOC(document, "Doroczne przeglądy i konserwacje.", "heading 1");
        addEnter(document);
        addPageToTOC(document, "Doroczne przeglądy i konserwacje hydrantów zewnętrznych", "heading 2");
        addEnter(document);
        addTextToParagraph(document.createParagraph(), ParagraphAlignment.LEFT, "W trakcie przeglądu okresowego kontroli poddawane są następujące elementy hydrantu:");
        addTextToParagraph(document.createParagraph(), ParagraphAlignment.LEFT, " - Oględziny zewnętrzne hydrantu nadziemnego i podziemnego pod ątem stanu powłoki lakierniczej,");
        addTextToParagraph(document.createParagraph(), ParagraphAlignment.LEFT, " - Dostępność do hydrantu,");
        addTextToParagraph(document.createParagraph(), ParagraphAlignment.LEFT, " - Dostępność do zasuwy hydrantu,");
        addTextToParagraph(document.createParagraph(), ParagraphAlignment.LEFT, " - Sposób oznakowania:");

        List<String> norms = Arrays.asList(
                "Hydrantu znakiem zgodnym z PN-N-01256-4:1997",
                "Hydrantu znakiem zgodnym z PN-B-09700:1986,",
                "Zasuwy znakiem zgodnym z PN-B-09700:1986"
        );
        createBulletList(document, norms);
        addTextToParagraph(document.createParagraph(), ParagraphAlignment.LEFT, " - Stan nasad Storz`a w hydrnacie, ");
        addTextToParagraph(document.createParagraph(), ParagraphAlignment.LEFT, " - Stan uszczelek w nasadzie, ");
        addTextToParagraph(document.createParagraph(), ParagraphAlignment.LEFT, " - Stan pokryw nasad Storz`a, ");
        addTextToParagraph(document.createParagraph(), ParagraphAlignment.LEFT, " - Odległość od budynków, ");
        addTextToParagraph(document.createParagraph(), ParagraphAlignment.LEFT, " - Ciśnienia statyczne i dynamiczne oraz wydajność, ");
        addTextToParagraph(document.createParagraph(), ParagraphAlignment.LEFT, " - Skuteczność odwodnienia hydrnatu. ");

        //generate whole report
        FileOutputStream fos = new FileOutputStream("TestReport.docx");
        document.write(fos);


    }
}
