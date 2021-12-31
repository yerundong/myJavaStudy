package XML;

import XML.lib.Book;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Base {
    /**
     * @使用Dom4j解析xml文件，生成对象
     */
    @Test
    public void test() throws DocumentException {
        // 1.读取xml文件，获得Document对象，Document代表xml文件
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("JavaBase/src/XML/lib/book.xml");
        // System.out.println(document);

        // 2. 获取根元素对象
        Element rootElement = document.getRootElement();

        // 3. 根据根元素对象获取内部各种信息
        // 获取特定子元素（第一个）
        Element book1 = rootElement.element("book");
        // 获元素的字符串表现形式
        // System.out.println(book1.asXML());

        // 获取所有子元素
        List<Element> books = rootElement.elements();
        List<Book> ls = new ArrayList<>();
        for (Element book : books) {
            // System.out.println(book.asXML());

            // 获取属性值
            Attribute id = book.attribute("id");
            // System.out.println(id.getValue());

            // 获取特定子元素（第一个）
            Element name = book.element("name");
            // System.out.println(name.asXML());

            // 获取元素文本
            // System.out.println(name.getText());

            // 获取特定子元素文本（第一个）
            String idValue = book.attributeValue("id");
            String nameText = book.elementText("name");
            String authorText = book.elementText("author");
            String priceText = book.elementText("price");

            // 4.生成指定对象
            Book bookObj = new Book(Integer.parseInt(idValue), nameText, authorText, Double.parseDouble(priceText));
            ls.add(bookObj);
        }

        System.out.println(ls);
    }
}
