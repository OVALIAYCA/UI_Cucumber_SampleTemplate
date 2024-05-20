package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class AboutPage extends Base {

    public AboutPage(){
        PageFactory.initElements(driver,this);
    }


}

