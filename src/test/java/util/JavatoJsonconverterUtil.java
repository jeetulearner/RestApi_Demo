package util;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.College;
import model.Course;
import model.Department;
import model.Student;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;
public class JavatoJsonconverterUtil {
    Student s1, s2, s3;
    Department d1, d2, d3;
    Course c1, c2, c3;
    @Test
    public void test() throws JsonProcessingException {
        c1 = Course.builder().courseId(1).courseName("Java").build();
        c2 = Course.builder().courseId(2).courseName("Python").build();
        c3 = Course.builder().courseId(3).courseName("Automation Testing").build();
        List<Course> ctest1 = Arrays.asList(c1, c2, c3);
        List<Course> ctest2 = Arrays.asList(c1, c2);
        List<Course> ctest3 = Arrays.asList(c1, c3);
        s1 = Student.builder().courseList(ctest1).name("Kundan").address("London").rollNumber(101).build();
        s2 = Student.builder().courseList(ctest2).name("Adnan").address("Pakistan").rollNumber(102).build();
        s3 = Student.builder().courseList(ctest3).name("Claudia").address("US").rollNumber(103).build();
        List<Student> studentList1 = Arrays.asList(s1, s2, s3);
        List<Student> studentList2 = Arrays.asList(s1, s3);
        List<Student> studentList3 = Arrays.asList(s1, s2);
        d1 = Department.builder().departmentName("CS").studentList(studentList1).build();
        d2 = Department.builder().departmentName("IT").studentList(studentList2).build();
        d3 = Department.builder().departmentName("Cyber-security").studentList(studentList3).build();
        List<Department> d = Arrays.asList(d1, d2, d3);
       College c = College.builder().CollegeName("MIT").departmentList(d).build();
       ObjectMapper mapper = new ObjectMapper();
        String s4 = mapper.writeValueAsString(c);
        System.out.println(s4);
        c.setDepartmentList(d);
    }
}
