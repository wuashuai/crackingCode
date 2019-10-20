package moderate;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import java.io.ByteArrayInputStream;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class XMLEncoding {

    Map<String, Integer> map = new HashMap<String, Integer>(){{
        put("family", 1);
        put("person", 2);
        put("firstName", 3);
        put("lastName", 4);
        put("state", 5);
        put("end", 6);
    }};

    public static void main(String[] args){

        String xml = "<family lastName=\"McDowell\" state=\"CA\">" +
                "<person firstName=\"Gayle\">Some Message</person>" +
                "</family>";
        encode(xml);
    }

    public static String encode(String element){

        Document document = null;

        try {
            document = loadXMLFromString(element);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(document == null) return "";

        document.getFirstChild();

        System.out.print(document.getElementsByTagName("lastName"));

        return "";


    }


    public static Document loadXMLFromString(String xml) throws Exception
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document d = builder.parse(new File(xml));

        return d;
    }



}
