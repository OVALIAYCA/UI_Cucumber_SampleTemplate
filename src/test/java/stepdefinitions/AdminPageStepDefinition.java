package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.AdminPage;
import pages.Base;
import utilities.PropManager;

import static org.junit.Assert.*;

@Slf4j
public class AdminPageStepDefinition extends Base {

    AdminPage adminPage = new AdminPage();


    @Then("Go to Employee List page")
    public void go_to_employee_list_page() {
        adminPage.employeeListButton.click();
        Assert.assertTrue(adminPage.createNewButton.isDisplayed());

    }

    @And("Click on the Create New button for the new employee")
    public void clickOnTheCreateNewButtonForTheNewEmployee() {
        adminPage.createNewButton.click();
    }

    @Then("Enter the valid {string}, {string}, {string}, {string} information for create a new employee")
    public void enterTheValidInformationForCreateANewEmployee(String name, String salary, String durationWorked, String email) {

        adminPage.employeeName.sendKeys(PropManager.getProperties(env,name));
        hardWait(1000);
        adminPage.salary.sendKeys(PropManager.getProperties(env,salary));
        hardWait(1000);
        adminPage.durationWorked.clear();
        adminPage.durationWorked.sendKeys(PropManager.getProperties(env,durationWorked));
        hardWait(1000);
        Select dropdown = new Select(adminPage.gradeDropDownMenu);
        dropdown.selectByIndex(2);
        hardWait(1000);
        adminPage.email.sendKeys(PropManager.getProperties(env,email));
        hardWait(1000);
        adminPage.createButton.click();
        hardWait(1000);
    }

    @And("Verify the new employee {string} info in Employee List page")
    public void verifyTheNewEmployeeInfoInEmployeeListPage(String name) {

        adminPage.searchBox.sendKeys(PropManager.getProperties(env,name));
        adminPage.searchButton.click();
        hardWait(1000);
        String actualName = adminPage.firstRow.getText();
        assertEquals(PropManager.getProperties(env,name), actualName);
        log.info("Employee name is founded");
    }

    @And("Delete the new employee")
    public void deleteTheNewEmployee() {
        adminPage.deleteButton.click();
        hardWait(1000);
        adminPage.deleteConfirmButton.click();
        hardWait(1000);
    }
    @And("Verify the new employee {string} deleted in Employee List page")
    public void verifyTheNewEmployeeDeletedInEmployeeListPage(String name) {
        adminPage.searchBox.sendKeys(PropManager.getProperties(env,name));
        adminPage.searchButton.click();
        String tableText = adminPage.table.getText();
        assertFalse("The name '" + name + "' was found in the search results!", tableText.contains(name));
        log.info("Employee name is not founded");
    }
}
