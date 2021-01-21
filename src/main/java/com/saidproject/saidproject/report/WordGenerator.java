package com.saidproject.saidproject.report;

import com.saidproject.saidproject.dao.measurement.HydrantType;
import com.saidproject.saidproject.dao.measurement.Measurement;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFFooter;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

public class WordGenerator {
    public void generate() throws URISyntaxException, IOException, InvalidFormatException {
        String logo = "db/said.jpg";
        String headerTitle = "INŻYNIERIA BEZPIECZEŃSTWA POŻAROWEGO";
        String headerSubtitle = "POŻARÓWKA";
        String headerWebsite = "WWW.POZAROWKA.PL";
        String table = "poi-word-para2.txt";
        String footerContent = "IBP POŻARÓWKA Sebastian Tomczyk Natolin 11 G, 92-701 Łódź Tel: 602373765 NIP: 728-223-14-86 REGON: 101403582";
        String output = "report.docx";


        Measurement measurement = new Measurement();
        measurement.setAddress("Biedronkowa 2137");
        measurement.setCreatedAt(new Date());
        measurement.setHydrantType(HydrantType.OUTSIDE);

        //title
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph title = document.createParagraph();
        title.setAlignment(ParagraphAlignment.CENTER);

        //header footer
        // create header-footer
        XWPFHeaderFooterPolicy headerFooterPolicy = document.getHeaderFooterPolicy();
        if (headerFooterPolicy == null) headerFooterPolicy = document.createHeaderFooterPolicy();




        // create header start
        XWPFHeader header = headerFooterPolicy.createHeader(XWPFHeaderFooterPolicy.DEFAULT);
        XWPFParagraph paragraph = header.createParagraph();



        paragraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run = paragraph.createRun();

        Path imagePath = Paths.get(ClassLoader.getSystemResource(logo).toURI());
        run.addPicture(Files.newInputStream(imagePath),
                XWPFDocument.PICTURE_TYPE_JPEG, imagePath.getFileName().toString(),
                Units.toEMU(50), Units.toEMU(50)).getPictureData();



        run.setText(headerTitle);
        run.setFontSize(20);
        run.setColor("990000"); //red
        run.setBold(true);

        XWPFParagraph paragraphSubtitle = header.createParagraph();
        paragraphSubtitle.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run2 = paragraphSubtitle.createRun();
        run2.setText(headerSubtitle);
        run2.setFontSize(12);
        run2.setColor("FF8000"); //yellow
        run2.setBold(true);

        XWPFParagraph paragraphWebsite = header.createParagraph();
        paragraphWebsite.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run3 = paragraphWebsite.createRun();
        run3.setText(headerWebsite);
        run3.setFontSize(12);
        run3.setColor("FF8000"); //yellow
        run3.setBold(true);


        // create footer start
        XWPFFooter footer = headerFooterPolicy.createFooter(XWPFHeaderFooterPolicy.DEFAULT);
        paragraph = footer.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        run = paragraph.createRun();
        run.setText(footerContent);




        XWPFRun titleRun = title.createRun();
        titleRun.setText("RAPORT Z OBIEKTU");
        titleRun.setColor("009933");
        titleRun.setBold(true);
        titleRun.setFontFamily("Courier");
        titleRun.setFontSize(20);

        // Creating Table
        XWPFTable tab = document.createTable();
        XWPFTableRow row = tab.getRow(0); // First row
        // Columns
        row.getCell(0).setText("Arkusz Badania Hydrantu");
        row.addNewTableCell().setText("Name");
        row.addNewTableCell().setText("Email");
        row = tab.createRow(); // Second Row
        row.getCell(0).setText("1.");
        row.getCell(1).setText("Irfan");
        row.getCell(2).setText("irfan@gmail.com");
        row = tab.createRow(); // Third Row
        row.getCell(0).setText("2.");
        row.getCell(1).setText("Mohan");
        row.getCell(2).setText("mohan@gmail.com");


        XWPFParagraph para1 = document.createParagraph();
        para1.setAlignment(ParagraphAlignment.BOTH);
        String string1 = "this should be a table";
        XWPFRun para1Run = para1.createRun();
        para1Run.setText(string1);

        FileOutputStream out = new FileOutputStream(output);
        document.write(out);
        out.close();
        document.close();
    }


}
