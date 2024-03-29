package tests;


import manager.HelperStudent;
import models.StudentDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class StudentFormTests extends TestBase implements HelperStudent {

    SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    public void goToPracticeForm() {
        pause(3);
        hideBanner();
        pause(3);
        hideFooter();
        selectPracticeForm();
        hideFooter();

    }

    @Test
    public void studentFormPositiveTest() {
        StudentDTO student = StudentDTO.builder()
                .firstName("Jan")
                .lastName("Itkis")
                .email("tret@gmail.com")
                .gender("Male")
                .mobile("1234567890")
                .dateOfBirth("22 Jun 1999")
                .subjects("Maths,Physics,Arts")
                .hobbies("Reading,Sports")
                .address("Street 1 app.2")
                .state("NCR")
                .city("Delhi")
                .build();
        fillStudentForm(student);
        clickButtonSubmit();

        //Assert.assertTrue(isElementPresent_TitleSubmitForm());
        softAssert.assertTrue(isElementPresent_TitleSubmitForm());

        WebElement elementEmail = driver.findElement(By.xpath("//tbody/tr[2]/td[last()]"));
        WebElement elementPhone = driver.findElement(By.xpath("//tbody/tr[4]/td[last()]"));
        //Assert.assertEquals(elementEmail.getText(), student.getEmail());
        softAssert.assertEquals(elementEmail.getText(), student.getEmail());
        //Assert.assertEquals(elementPhone.getText(), student.getMobile());
        softAssert.assertEquals(elementPhone.getText(), student.getMobile());
        softAssert.assertAll("stop test");
    }

    @Test
    public void studentFormPositiveTest1(){
        
    }

    @Test
    public void studentFormNegativeTest_EmptyLastName(){

    }


    @AfterMethod

    public void afterMethod() {
        if (isElementPresent_TitleSubmitForm())
            clickBtnClose();
        else{
            driver.navigate().refresh();
            pause(3);
            hideBanner();
            pause(3);
            hideFooter();
        }
    }
          
}
