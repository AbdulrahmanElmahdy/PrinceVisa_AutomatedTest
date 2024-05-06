package screenshots;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static hooks.Hooks.*;

public class ScreenshotsEvidence {

    public static void screenshotEvidence() throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
        String strDate = sdf.format(cal.getTime());
        String name = scenarioName.concat("-" + methodName + "-").concat(strDate).concat(".png");
        FileUtils.copyFile(srcFile, new File("D:/PrinceVisa/PrinceVisa/test-output/".concat(name)));
        test.addScreenCaptureFromPath("D:/PrinceVisa/PrinceVisa/test-output/".concat(name));
        extent.flush();
    }
}
