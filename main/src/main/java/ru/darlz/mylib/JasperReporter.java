package ru.darlz.mylib;

import net.sf.jasperreports.engine.*;

import java.util.HashMap;

/**
 * User: Vladislav Dolbilov (darl@yandex-team.ru)
 * Date: 24.03.12 10:43
 */
public class JasperReporter {
    public void doReport(String name) throws JRException {
        System.out.println("starting report");
        JasperReport jasperReport = JasperCompileManager
                .compileReport(getClass().getResourceAsStream("/report.xml"));

        final HashMap<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("name", name);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
                parameters, new JREmptyDataSource());

        JasperExportManager.exportReportToPdfFile(jasperPrint, "/Users/darl/hello_report.pdf");
    }
}
