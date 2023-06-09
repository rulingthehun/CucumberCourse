package StepDefinitions;

import Utilities.ExcelUtility;
import Utilities.GWD;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Hooks {

    @Before
    public void before() {
        System.out.println("Scenario is started");
    }

    @After
    public void after(Scenario scenario) {
        System.out.println("Scenario is finished");

        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter tF = DateTimeFormatter.ofPattern("dd_MM_yy_HHmmss");

        // Senaryoların sonuçlarını bir excel formatından yazdırmak istiyorum
        ExcelUtility.writeToExcel("src/test/java/ApachePOI/resource/ScenarioStatus.xlsx",
                scenario, GWD.getThreadBrowserName(), time.format(tF));

        if (scenario.isFailed()) { // Senaryo bittiği zaman
            //            Extend report için diğer durumlarda kaldıralım
            final byte[] screenshot = ((TakesScreenshot) GWD.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot name");

            //TakesScreenshot ts = (TakesScreenshot) GWD.getDriver();
            //File inMemory = ts.getScreenshotAs(OutputType.FILE);
//
            //LocalDateTime time = LocalDateTime.now();
            //DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("dd_MM_yyHHmmss");
            //try {
            //    FileUtils.copyFile(inMemory, new File("screenShots/screenshot_" + time.format(timeFormatter) + ".png"));
            //} catch (IOException e) {
            //    throw new RuntimeException(e);
            //}
        }
        GWD.quitDriver();
    }


}
