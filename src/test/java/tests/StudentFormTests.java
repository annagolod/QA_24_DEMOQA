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
               // .dateOfBirth()
                .build();
        fillStudentForm(student);
    }


}
