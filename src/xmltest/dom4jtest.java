package xmltest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author dzx
 * @date 2021/10/5 -15:25
 */
public class dom4jtest {
    @Test
    public void tset1()  {
        SAXReader saxReader = new SAXReader();
        Document document = null;
        try {
//            在Junit测试中，相对路径是从模块名开始算的
            document = saxReader.read("src/xmltest/books.xml");
            System.out.println(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
//    读取books.xml文件生成的Book类
    @Test
    public void test2() throws Exception{
//1.读取xml文件
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/xmltest/books.xml");
//        2.通过document对象获取根元素
        Element rootElement = document.getRootElement();
        System.out.println(rootElement);
//        3.通过根元素获取标签对象
        List<Element> books = rootElement.elements("book");
        for (Element book : books) {
//            asXML()把标签对象转换为字符串
            Element element = book.element("name");
            if(element==null){
                return;
            }
//            getText()：获取标签中的文本内容
            String nameText = element.getText();
//            直接获取指定标签的文本内容
            String priceText = book.elementText("price");
            String authorText = book.elementText("author");
//            获取属性值
            String value = book.attributeValue("sn");
            BigDecimal price = new BigDecimal(priceText);
//            4.根据XML创建Book对象
            System.out.println(new Book(value,nameText, price,authorText));
        }
    }
}
