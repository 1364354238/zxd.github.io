import com.ssm.dao.BookMapper;
import com.ssm.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author dzx
 * @data 2021/11/6 -15:21
 */
public class Test1 {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = (BookService) context.getBean("BookServiceImpl");

        bookService.selectBook();
        BookMapper bookMapper = context.getBean(BookMapper.class);
        bookMapper.selectBook().forEach(System.out::println);
    }
}
