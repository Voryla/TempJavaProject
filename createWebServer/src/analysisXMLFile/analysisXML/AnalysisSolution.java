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
        //1.��������������
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        //2.�ӷ�����������ȡ������
        SAXParser saxParser = saxParserFactory.newSAXParser();
        //3.��д������Document������
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
        System.out.println("---�ĵ�������ʼ---");
        personList = new ArrayList<Person>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(qName + "--->������ʼ");
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
        //�жϱ�ʾ��Ϊ��
        if (this.qName != null) {
            //�ж����ݲ�Ϊ��
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
        System.out.println(qName + "--->��������");
        //����ʹ��this.qName��Ϊ��ΪnullΪ�˷�ֹcharacter������ֵʧ��
        if (qName.equals("person")) {
            personList.add(person);
        }
        this.qName = null;
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("---�ĵ���������---");
    }
}
