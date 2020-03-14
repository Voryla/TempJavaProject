package analysisXMLFile.analysisWebXMLFile;

import org.junit.Test;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;
import java.util.List;

public class AnalysisWebXMLSoulution {
    @Test
    public void doSolution() throws Exception {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        Handler handler=new Handler();
        saxParser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("analysisXMLFile/analysisWebXMLFile/webXML"),handler);
        System.out.println(handler.getPatterns().size()+""+handler.getServlets().size());
        for (Pattern pattern:handler.getPatterns()){
            System.out.println(pattern.getName());
            System.out.println(pattern.getUrl());
        }
        System.out.println("-------------------------");
        for (Servlet servlet:handler.getServlets()){
            System.out.println(servlet.getName());
            System.out.println(servlet.getClassName());
        }
    }
}

class Handler extends DefaultHandler {
    private List<Pattern> patterns;
    private List<Servlet> servlets;
    private Pattern pattern;
    private Servlet servlet;
    private boolean ispattern = false;
    private String qName;

    public List<Pattern> getPatterns() {
        return patterns;
    }

    public List<Servlet> getServlets() {
        return servlets;
    }

    @Override
    public void startDocument() throws SAXException {
        patterns = new ArrayList<>();
        servlets = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName != null) {
            if (qName.equals("servlet")) {
                servlet = new Servlet();
                ispattern = false;
            } else if (qName.equals("servlet-mapping")) {
                pattern = new Pattern();
                ispattern = true;
            }
            this.qName = qName;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents = new String(ch, start, length).trim();
        if (qName != null) {
            if (contents.length() > 0) {
                if(ispattern){
                    switch (qName){
                        case "servlet-name":
                            pattern.setName(contents);
                            break;
                        case "url-pattern":
                            pattern.addUrl(contents);
                    }
                }else {
                    switch (qName){
                        case "servlet-name":
                            servlet.setName(contents);
                            break;
                        case "servlet-class":
                            servlet.setClassName(contents);
                    }
                }
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName != null) {
            if (qName.equals("servlet")) {
                servlets.add(servlet);
            } else if (qName.equals("servlet-mapping")) {
                patterns.add(pattern);
            }
        }
        this.qName = null;
    }
}
