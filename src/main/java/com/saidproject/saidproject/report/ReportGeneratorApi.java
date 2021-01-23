package com.saidproject.saidproject.report;

import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFAbstractNum;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFNumbering;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFStyle;
import org.apache.poi.xwpf.usermodel.XWPFStyles;
import org.apache.xmlbeans.impl.xb.xmlschema.SpaceAttribute;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STFldCharType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STLineSpacingRule;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STNumberFormat;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STStyleType;

import java.math.BigInteger;
import java.util.List;

public class ReportGeneratorApi {


    public static XWPFDocument addTableOfContent(XWPFDocument doc) {
        XWPFParagraph paragraph = doc.createParagraph();
        CTP ctP = paragraph.getCTP();
        CTSimpleField toc = ctP.addNewFldSimple();
        toc.setInstr("TOC \\h");
        toc.setDirty(STOnOff.TRUE);
        return doc;
    }

    public static void addPageToTOC(XWPFDocument doc, String headingText, String headingStyle) {
        XWPFParagraph paragraph = doc.createParagraph();
        XWPFRun run = paragraph.createRun();
        if ("heading 1".equals(headingStyle)) {
            run.setFontSize(20);
            run.setText(headingText);
        } else if ("heading 2".equals(headingStyle)) {
            run.setFontSize(16);
            run.setText("\t" + headingText);
        } else {
            run.setText("\t\t" + headingText);
        }
        paragraph.setStyle(headingStyle);
    }

    public static void addCustomHeadingStyle(XWPFDocument docxDocument, String strStyleId, int headingLevel) {
        CTStyle ctStyle = CTStyle.Factory.newInstance();
        ctStyle.setStyleId(strStyleId);

        CTString styleName = CTString.Factory.newInstance();
        styleName.setVal(strStyleId);
        ctStyle.setName(styleName);

        CTDecimalNumber indentNumber = CTDecimalNumber.Factory.newInstance();
        indentNumber.setVal(BigInteger.valueOf(headingLevel));

        // lower number > style is more prominent in the formats bar
        ctStyle.setUiPriority(indentNumber);

        CTOnOff onoffnull = CTOnOff.Factory.newInstance();
        ctStyle.setUnhideWhenUsed(onoffnull);

        // style shows up in the formats bar
        ctStyle.setQFormat(onoffnull);

        // style defines a heading of the given level
        CTPPr ppr = CTPPr.Factory.newInstance();
        ppr.setOutlineLvl(indentNumber);
        ctStyle.setPPr(ppr);

        XWPFStyle style = new XWPFStyle(ctStyle);

        // is a null op if already defined
        XWPFStyles styles = docxDocument.createStyles();

        style.setType(STStyleType.PARAGRAPH);
        styles.addStyle(style);
    }

    public static void createHeaderAndFooter(XWPFDocument document){
        // header-footer policy parent object
        XWPFHeaderFooterPolicy headerFooterPolicy = document.getHeaderFooterPolicy();
        if (headerFooterPolicy == null) headerFooterPolicy = document.createHeaderFooterPolicy();

        // create header
        XWPFHeader header = headerFooterPolicy.createHeader(XWPFHeaderFooterPolicy.DEFAULT);
        XWPFParagraph paragraph = header.createParagraph();
        addTextToParagraph(paragraph, 20, "990000", true, ParagraphAlignment.CENTER, "INŻYNIERIA BEZPIECZEŃSTWA POŻAROWEGO");
        setSingleLineSpacing(paragraph);

        //add company logo
//        Path imagePath = Paths.get(ClassLoader.getSystemResource(logo).toURI());
//        run.addPicture(Files.newInputStream(imagePath),
//                XWPFDocument.PICTURE_TYPE_JPEG, imagePath.getFileName().toString(),
//                Units.toEMU(50), Units.toEMU(50)).getPictureData();

        paragraph = header.createParagraph();
        addTextToParagraph(paragraph, 12, "FF8000", true, ParagraphAlignment.CENTER, "POŻARÓWKA");
        setSingleLineSpacing(paragraph);

        paragraph = header.createParagraph();
        addTextToParagraph(paragraph, 12, "FF8000", true, ParagraphAlignment.CENTER, "www.pozarowka.pl");
        setSingleLineSpacing(paragraph);

        // create footer start

        createFooter(document, headerFooterPolicy);
    }

    public static void createBulletList(XWPFDocument document, List<String> textToBeListed) {
        CTAbstractNum cTAbstractNum = CTAbstractNum.Factory.newInstance();
        //Next we set the AbstractNumId. This requires care.
        //Since we are in a new document we can start numbering from 0.
        //But if we have an existing document, we must determine the next free number first.
        cTAbstractNum.setAbstractNumId(BigInteger.valueOf(0));

// Bullet list
        CTLvl cTLvl = cTAbstractNum.addNewLvl();
        cTLvl.addNewNumFmt().setVal(STNumberFormat.BULLET);
        cTLvl.addNewLvlText().setVal("•");

        XWPFAbstractNum abstractNum = new XWPFAbstractNum(cTAbstractNum);
        XWPFNumbering numbering = document.createNumbering();
        BigInteger abstractNumID = numbering.addAbstractNum(abstractNum);
        BigInteger numID = numbering.addNum(abstractNumID);

        textToBeListed.forEach(text -> {
            XWPFParagraph paragraph = document.createParagraph();
            paragraph.setNumID(numID);
            paragraph.setIndentFromLeft(50); // indent from left 360 Twips = 1/4 inch
            paragraph.setIndentationHanging(50);
            XWPFRun run = paragraph.createRun();
            run.setText(text);
        });
    }


    //this method is responsible for adding page numbers and footer text
    private static void createFooter(XWPFDocument document, XWPFHeaderFooterPolicy headerFooterPolicy) {
        CTP ctp = CTP.Factory.newInstance();

        CTText txt = ctp.addNewR().addNewT();
        txt.setStringValue("Strona ");
        txt.setSpace(SpaceAttribute.Space.PRESERVE);

        CTR run = ctp.addNewR();
        run.addNewFldChar().setFldCharType(STFldCharType.BEGIN);
        run.addNewInstrText().setStringValue(" PAGE ");
        run.addNewFldChar().setFldCharType(STFldCharType.END);

        txt = ctp.addNewR().addNewT();
        txt.setStringValue(" z ");
        txt.setSpace(SpaceAttribute.Space.PRESERVE);

        run = ctp.addNewR();
        run.addNewFldChar().setFldCharType(STFldCharType.BEGIN);
        run.addNewInstrText().setStringValue(" NUMPAGES ");
        run.addNewFldChar().setFldCharType(STFldCharType.END);

        XWPFParagraph par = new XWPFParagraph(ctp, document);
        par.setAlignment(ParagraphAlignment.CENTER);


        XWPFParagraph xwpfParagraph = new XWPFParagraph(CTP.Factory.newInstance(), document);
        addTextToParagraph(xwpfParagraph, 12, ParagraphAlignment.CENTER, "IBP POŻARÓWKA Sebastian Tomczyk Natolin 11 G, 92-701 Łódź Tel: 602373765 NIP: 728-223-14-86 REGON: 101403582");

        if (headerFooterPolicy == null)
            headerFooterPolicy = document.createHeaderFooterPolicy();
        headerFooterPolicy.createFooter(XWPFHeaderFooterPolicy.DEFAULT, new XWPFParagraph[]{xwpfParagraph, par});
    }

    public static void setSingleLineSpacing(XWPFParagraph para) {
        CTPPr ppr = para.getCTP().getPPr();
        if (ppr == null) ppr = para.getCTP().addNewPPr();
        CTSpacing spacing = ppr.isSetSpacing()? ppr.getSpacing() : ppr.addNewSpacing();
        spacing.setAfter(BigInteger.valueOf(0));
        spacing.setBefore(BigInteger.valueOf(0));
        spacing.setLineRule(STLineSpacingRule.AUTO);
        spacing.setLine(BigInteger.valueOf(240));
    }

    public static void addTextToParagraph(XWPFParagraph paragraph, int fontSize, String color,
                                               boolean setBold, ParagraphAlignment pa, String text) {
        paragraph.setAlignment(pa);
        XWPFRun run = paragraph.createRun();
        run.setText(text);
        run.setFontSize(fontSize);
        run.setColor(color);
        run.setBold(setBold);
    }

    public static void addTextToParagraph(XWPFParagraph paragraph, int fontSize, boolean setBold, ParagraphAlignment pa, String text) {
        paragraph.setAlignment(pa);
        XWPFRun run = paragraph.createRun();
        run.setText(text);
        run.setFontSize(fontSize);
        run.setBold(setBold);
    }

    public static void addTextToParagraph(XWPFParagraph paragraph, int fontSize, ParagraphAlignment pa, String text) {
        paragraph.setAlignment(pa);
        XWPFRun run = paragraph.createRun();
        run.setText(text);
        run.setFontSize(fontSize);
    }

    public static void addTextToParagraph(XWPFParagraph paragraph, ParagraphAlignment pa, String text) {
        paragraph.setAlignment(pa);
        XWPFRun run = paragraph.createRun();
        run.setText(text);
    }

    //add empty line to document
    public static void addEnter(XWPFDocument document) {
        XWPFRun run = document.createParagraph().createRun();
        run.setText("");
    }

    //everything below this method will be moved to the next page
    public static void pageBreak(XWPFDocument document) {
        document.createParagraph().setPageBreak(true);
    }


}
