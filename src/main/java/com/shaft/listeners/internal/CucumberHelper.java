package com.shaft.listeners.internal;

import com.shaft.driver.DriverFactory;
import com.shaft.gui.internal.image.ImageProcessingActions;
import com.shaft.properties.internal.PropertiesHelper;
import com.shaft.tools.internal.security.GoogleTink;
import com.shaft.tools.io.internal.CheckpointCounter;
import com.shaft.tools.io.internal.ProjectStructureManager;
import com.shaft.tools.io.internal.ReportHelper;
import com.shaft.tools.io.internal.ReportManagerHelper;
import org.testng.Reporter;

public class CucumberHelper {

    public static void shaftSetup() {
        if (Reporter.getCurrentTestResult() == null) {
            // running in native Cucumber mode
            System.setProperty("disableLogging", "true");
            PropertiesHelper.initialize();
            ProjectStructureManager.initialize();
            TestNGListenerHelper.configureJVMProxy();
            GoogleTink.initialize();
            GoogleTink.decrypt();
            System.setProperty("disableLogging", "false");

            ReportManagerHelper.logEngineVersion();
            ImageProcessingActions.loadOpenCV();

            ReportManagerHelper.initializeAllureReportingEnvironment();
            ReportManagerHelper.initializeExtentReportingEnvironment();

            ReportHelper.attachImportantLinks();
            ReportHelper.attachPropertyFiles();

            ReportManagerHelper.setDiscreteLogging(Boolean.parseBoolean(System.getProperty("alwaysLogDiscreetly")));
            ReportManagerHelper.setDebugMode(Boolean.valueOf(System.getProperty("debugMode")));
        }
    }

    public static void shaftTeardown() {
        if (Reporter.getCurrentTestResult() == null) {
            // running in native Cucumber mode
            DriverFactory.closeAllDrivers();

            ReportHelper.attachEngineLog();
            ReportHelper.attachExtentReport();
            ReportHelper.attachCucumberReport();
            CheckpointCounter.attach();
            ReportHelper.attachIssuesLog();

            ReportManagerHelper.setDiscreteLogging(true);
            JiraHelper.reportExecutionStatusToJira();
            GoogleTink.encrypt();
            ReportManagerHelper.generateAllureReportArchive();
            ReportManagerHelper.openAllureReportAfterExecution();
            ReportManagerHelper.logEngineClosure();
        }
    }
}
