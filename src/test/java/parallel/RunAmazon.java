package parallel;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
(


		
glue = {"parallel"},

features = {"src/test/resources/parallel"},

monochrome=true
		
)

public class RunAmazon extends AbstractTestNGCucumberTests  
{

	
	@DataProvider(parallel=false)
	public Object [][] scenarios()
	{
		return super.scenarios();
		
	}
	
	
}
