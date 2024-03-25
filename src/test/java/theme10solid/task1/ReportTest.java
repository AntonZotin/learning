package theme10solid.task1;

import org.junit.jupiter.api.Test;
import theme10solid.task1.bad.ReportGenerator;
import theme10solid.task1.good.HtmlReportPresenter;
import theme10solid.task1.good.PdfReportPresenter;
import theme10solid.task1.good.ReportDataPreparer;
import theme10solid.task1.good.ReportPresenter;

class ReportTest {
    @Test
    void test() {
        // bad
        ReportGenerator generator = new ReportGenerator();
        generator.prepareData();
        generator.getHtmlReport();
        generator.getPdfReport();

        // good
        ReportDataPreparer preparer = new ReportDataPreparer();
        preparer.prepareData();
        ReportPresenter presenter = new HtmlReportPresenter();
        presenter.getReport();
        presenter = new PdfReportPresenter();
        presenter.getReport();
    }
}
