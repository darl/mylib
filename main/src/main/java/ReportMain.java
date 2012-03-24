import net.sf.jasperreports.engine.*;

import java.util.HashMap;

/**
 * User: Vladislav Dolbilov (darl@yandex-team.ru)
 * Date: 24.03.12 9:56
 */
public class ReportMain {
    public static void main(String[] args) throws JRException {
        JasperReport jasperReport = JasperCompileManager
                .compileReport(ReportMain.class.getResourceAsStream("report.xml"));

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
                new HashMap(), new JREmptyDataSource());

        JasperExportManager.exportReportToPdfFile(jasperPrint, "/Users/darl/hello_report.pdf");
    }
}
