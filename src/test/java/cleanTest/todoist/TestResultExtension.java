package cleanTest.todoist;

import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import singletonSession.Session;

public class TestResultExtension implements AfterTestExecutionCallback
{
    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception
    {
        Boolean passed = context.getExecutionException().isEmpty();
        if(!passed){
            attach();
        }
    }

    @Attachment(value = "screenshot",type = "image/png")
    private byte[] attach(){
        //todo EJ1
        // tomar captura de pantalla - adjuntarlo en el reporte
        return ((TakesScreenshot) Session.getInstance().getBrowser()).getScreenshotAs(OutputType.BYTES);
    }

    //METHOD VARIANT
//    @Override
//    public void afterTestExecution(ExtensionContext context) throws Exception
//    {
//        Boolean testResult = context.getExecutionException().isPresent();
//        if (testResult)
//        {
//            attach();
//        }
//        System.out.println(testResult); //false - SUCCESS, true - FAILED
//    }

}
