package camt.cbsd.lab05.config;

import camt.cbsd.lab05.dao.CourseDao;
import camt.cbsd.lab05.dao.ProductDao;
import camt.cbsd.lab05.dao.StudentDao;
import camt.cbsd.lab05.entity.Course;
import camt.cbsd.lab05.entity.Product;

import camt.cbsd.lab05.entity.Student;
import camt.cbsd.lab05.entity.security.Authority;
import camt.cbsd.lab05.entity.security.AuthorityName;
import camt.cbsd.lab05.entity.security.User;
import camt.cbsd.lab05.security.repository.*;
import camt.cbsd.lab05.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

@ConfigurationProperties(prefix="server")
@Component
public class DataLoader implements ApplicationRunner{

    UserRepository userSecurityRepository;
    @Autowired
    public void setUserSecurityRepository(UserRepository userSecurityRepository) {
        this.userSecurityRepository = userSecurityRepository;
    }
    AuthorityRepository authorityRepository;

    @Autowired
    public void setAuthorityRepository(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    ProductDao productDao;
    @Autowired
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    String baseUrl;
    String imageUrl;
    String imageBaseUrl;
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    StudentDao studentDao;
    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }


    CourseDao courseDao;
    @Autowired
    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        imageBaseUrl = baseUrl + imageUrl;

        Student student1 = Student.builder().studentId("SE-001").name("Mitsuha").surname("Miyamizu")
                .gpa(2.15).image(imageBaseUrl+"mitsuha.gif").feature(true)
                .penAmount(0).description("The most beloved one").build();
        Student student2 = Student.builder().studentId("SE-002").name("Prayuth").surname("The minister")
                .gpa(3.59).image(imageBaseUrl+"tu.jpg").feature(false)
                .penAmount(15).description("The great man ever!!!!").build();
        Student student3 = Student.builder().studentId("SE-003").name("Jurgen").surname("Kloop")
                .gpa(2.15).image(imageBaseUrl+"Kloop.gif").feature(true)
                .penAmount(2).description("The man for the Kop").build();

        Course course1 = Course.builder().courseId("953331").courseName("CBSD").build();
        Course course2 = Course.builder().courseId("953323").courseName("Software Construction").build();
        Course course3 = Course.builder().courseId("953499").courseName("Software Project").build();

        Product product1 = Product.builder().productId("1").productName("mario1").productPrice(12.0).productQuantity(10)
                .image(imageBaseUrl+"a.jpg").description("good shirt").size("M").color("Red").build();
        Product product2 =  Product.builder().productId("2").productName("mario2").productPrice(12.0).productQuantity(10)
                .image(imageBaseUrl+"b.jpg").description("good shirt").size("M").color("Red").build();
        Product product3 =  Product.builder().productId("3").productName("mario3").productPrice(12.0).productQuantity(10)
                .image(imageBaseUrl+"c.jpg").description("good shirt").size("M").color("Red").build();
        Product product4 =  Product.builder().productId("4").productName("mario4").productPrice(12.0).productQuantity(10)
                .image(imageBaseUrl+"d.jpg").description("good shirt").size("M").color("Red").build();

        productDao.add(product1);
        productDao.add(product2);
        productDao.add(product3);
        productDao.add(product4);
        courseDao.add(course1);
        courseDao.add(course2);
        courseDao.add(course3);
        studentDao.addStudent(student1);
        studentDao.addStudent(student2);
        studentDao.addStudent(student3);

        student1.addCourse(course1);
        student1.addCourse(course2);
        student2.addCourse(course2);
        student2.addCourse(course3);
        student3.addCourse(course1);
        student3.addCourse(course3);

        securitySetup();
        student1.setUser(user1);
        user1.setStudent(student1);
        student2.setUser(user2);
        user2.setStudent(student2);
        student3.setUser(user3);
        user3.setStudent(student3);
    }
    User user1,user2,user3;
    private void securitySetup() {
        user1 = User.builder()
                .username("admin")
                .password("admin")
                .firstname("admin")
                .lastname("admin")
                .email("admin@gmail.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2016, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

         user2 = User.builder()
                .username("seller")
                .password("seller")
                .firstname("seller")
                .lastname("seller")
                .email("seller@gmail.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2016, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
         user3 = User.builder()
                .username("customer")
                .password("customer")
                .firstname("customer")
                .lastname("customer")
                .email("customer@gmail.com")
                .enabled(false)
                .lastPasswordResetDate(Date.from(LocalDate.of(2016, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        Authority auth1 = Authority.builder().name(AuthorityName.ROLE_ADMIN).build();
        Authority auth2 = Authority.builder().name(AuthorityName.ROLE_SELLER).build();
        Authority auth3 = Authority.builder().name(AuthorityName.ROLE_CUSTOMER).build();
        authorityRepository.save(auth1);
        authorityRepository.save(auth2);
        authorityRepository.save(auth3);
        user1.setAuthorities(new ArrayList<>());
        user1.getAuthorities().add(auth1);
        user1.getAuthorities().add(auth2);
        user1.getAuthorities().add(auth3);
        user2.setAuthorities(new ArrayList<>());
        user2.getAuthorities().add(auth2);
        user3.setAuthorities(new ArrayList<>());
        user3.getAuthorities().add(auth3);

        userSecurityRepository.save(user1);
        userSecurityRepository.save(user2);
        userSecurityRepository.save(user3);
    }
}

