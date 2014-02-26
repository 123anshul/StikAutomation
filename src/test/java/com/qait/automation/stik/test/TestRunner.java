package com.qait.automation.stik.test;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.annotations.Test;

public class TestRunner {
        @Test
        public void Test() {
                List<String> file = new ArrayList<String>();
                file.add("Test_Controller_Config.xml");
                TestNG testNG = new TestNG();
                testNG.setTestSuites(file);
                testNG.setOutputDirectory("./target/test-output");
                testNG.run();
        }
}