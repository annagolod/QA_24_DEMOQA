package tests;


import manager.HelperStudent;
import models.StudentDTO;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StudentFormTests extends TestBase implements HelperStudent {

    @BeforeClass
    public  void  goToPracticeForm(){
        pause(3);
        hideBanner();
        pause(3);
        hideFooter();
        selectPracticeForm();
        hideFooter();

    }

    @Test
    public void studentFormPositiveTest(){
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
    }

}
