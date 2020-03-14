package analysisXMLFile.analysisXML;

import org.junit.Test;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnalysisSolution {
    @Test
    public void doSolution() throws SAXException, ParserConfigurationException, IOException {
        //1.创建分析器工厂
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        //2.从分析器工厂获取分析器
        SAXParser saxParser = saxParserFactory.newSAXParser();
        //3.编写并创建Document处理器
        MyXMLHandler myXMLHandler = new MyXMLHandler();
        saxParser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("analysisXMLFile/analysisXML/MyXML.xml"), myXMLHandler);
        for (Person person : myXMLHandler.getPersonList()) {
            System.out.println(person.getName());
            System.out.println(person.getAge());
        }
    }
}

class MyXMLHandler extends DefaultHandler {
    private List<Person> personList;
    private Person person;
    private String qName;

    public List<Person> getPersonList() {
        return personList;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("---文档解析开始---");
        personList = new ArrayList<Person>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(qName + "--->解析开始");
        if (qName != null) {
            this.qName = qName;
            if (qName.equals("person")) {
                person = new Person();
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents = new String(ch, start, length).trim();
        //判断标示不为空
        if (this.qName != null) {
            //判断数据不为空
            if (contents.length() > 0) {
                switch (this.qName) {
                    case "name":
                        person.setName(contents);
                        break;
                    case "age":
                        person.setAge(Integer.valueOf(contents));
                        break;
                }
            }
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println(qName + "--->解析结束");
        //不能使用this.qName因为它为null为了防止character方法赋值失败
        if (qName.equals("person")) {
            personList.add(person);
        }
        this.qName = null;
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("---文档解析结束---");
    }
}
