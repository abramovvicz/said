package com.saidproject.saidproject.utils;

import com.google.gson.Gson;
import com.saidproject.saidproject.dao.measurement.document.MeasurementFieldDocument;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;
import java.util.Set;

public class GenerateWordFileImp implements GenerateWordFile<String, String> {

    public static String output = "rest-with-spring.docx";
    private final Gson gson = new Gson();

    @Override
    public Map<String, String> convert() {
        MeasurementFieldDocument fieldDocument = gson.fromJson(JsonFileReader.readFile("src/main/resources/documentStructure.json"), MeasurementFieldDocument.class);
        return fieldDocument.getHeaderFooter();
    }

    @Override
    public void generateWordFile() throws IOException {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph title = document.createParagraph();
        title.setAlignment(ParagraphAlignment.CENTER);

        XWPFRun titleRun = title.createRun();
        titleRun.setText("Build Your REST API with Spring");
        titleRun.setColor("009933");
        titleRun.setBold(true);
        titleRun.setFontFamily("Courier");
        titleRun.setFontSize(20);

        XWPFParagraph subTitle = document.createParagraph();
        subTitle.setAlignment(ParagraphAlignment.CENTER);

        XWPFRun subTitleRun = subTitle.createRun();
        subTitleRun.setText("from HTTP fundamentals to API Mastery");
        subTitleRun.setColor("00CC44");
        subTitleRun.setFontFamily("Courier");
        subTitleRun.setFontSize(16);
        subTitleRun.setTextPosition(20);
        subTitleRun.setUnderline(UnderlinePatterns.DOT_DOT_DASH);

        FileOutputStream out = new FileOutputStream(output);
        document.write(out);
        out.close();
        document.close();
    }
}
