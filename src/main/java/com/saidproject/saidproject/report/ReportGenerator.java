package com.saidproject.saidproject.report;

import com.saidproject.saidproject.dao.measurement.HydrantType;
import com.saidproject.saidproject.dao.measurement.Measurement;
import com.saidproject.saidproject.exceptions.NotFoundException;
import com.saidproject.saidproject.service.measurement.MeasurementService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Date;

import static j2html.TagCreator.*;


public class ReportGenerator {


    public void generateReport() throws IOException, URISyntaxException {
        Measurement measurement = new Measurement();
        measurement.setAddress("Biedronkowa 2137");
        measurement.setCreatedAt(new Date());
        measurement.setHydrantType(HydrantType.OUTSIDE);
        String style = renderStyle();

        String bodyContent = body(
                div (
                        header(
                            img().withSrc("said.jpg"),
                            p("Inzynieria Bezpieczenstwa Pozarowego Pozarowka"),
                            p("Pozarowka"),
                            p("www.pozarowka.pl")
                        ),

                        article(
                                table(
                                        tr(
                                                th( "Arkusz Badania Hydrantu").attr("colspan=\"4\"")
                                        ),
                                        tr(
                                                th("Nazwa"),th("Wartość"),th("Jednostka"),th("Uwagi")
                                        ),
                                        tr(
                                                td("Adres Hydrantu"), td(measurement.getAddress()).attr("colspan=\"2\""), td().attr("rowspan=\"3\"")
                                        ),
                                        tr(
                                                td("Data Badania"), td(measurement.getCreatedAt().toString()).attr("colspan=\"2\"")
                                        ),
                                        tr(
                                                td("Rodzaj hydrantu"), td(measurement.getHydrantType().toString()).attr("colspan=\"2\"")
                                        )

                                )
                        ),

                        footer("IBP POŻARÓWKA Sebastian Tomczyk Natolin 11 G, 92-701 Łódź Tel: 602373765 NIP: 728-223-14-86 REGON: 101403582")
                )
        ).render();

        File template = getTemplate();
        String htmlString = FileUtils.readFileToString(template, "UTF-8");
        htmlString = htmlString.replace("$style", style);
        htmlString = htmlString.replace("$body", bodyContent);
        FileUtils.writeStringToFile(new File ("resolved.html"), htmlString, "UTF-8");
    }

    private File getTemplate() throws URISyntaxException {
        URL resource = getClass().getClassLoader().getResource("report/template.html");
        if (resource == null) {
            throw new IllegalArgumentException("file not found!");
        } else {

            // failed if files have whitespaces or special characters
            //return new File(resource.getFile());

            return new File(resource.toURI());
        }
    }

    private String renderStyle() {
        return style(
                "table, th, td {border: 1px solid black; margin-left: auto; margin-right: auto;} " +
                        "\n header {" +
                        "  background-color: #666;\n" +
                        "  padding: 30px;\n" +
                        "  text-align: center;\n" +
                        "  font-size: 35px;\n" +
                        "  color: white;\n" +
                        "}\n" +
                        "footer {\n" +
                        "  background-color: #777;\n" +
                        "  padding: 10px;\n" +
                        "  text-align: center;\n" +
                        "  color: white;\n" +
                        "}\n" +
                        "article {\n" +
                        "  float: left;\n" +
                        "  padding: 20px;\n" +
                        "  width: 100%;\n" +
                        "  background-color: #f1f1f1;\n" +
                        "}\n" +
                        "div {margin: 100px 50px 100px;}"
        ).render();
    }
}
