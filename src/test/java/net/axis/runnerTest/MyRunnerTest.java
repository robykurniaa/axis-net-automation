package net.axis.runnerTest;

import cucumber.api.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(features={"src//test//java//features"}
        ,glue={"stepdefinations","utility"}
        ,plugin = {"pretty", "html:target/cucumber"}
        , tags ={"@web"}
)
@Test
public class MyRunnerTest {
}
