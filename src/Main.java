import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.xpath.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Main {


    public static void main(String[] args) throws XPathExpressionException, FileNotFoundException {
        XPathFactory factory = XPathFactory.newInstance();
        XPath path = factory.newXPath();
        XPathExpression xPathExpression = path.compile("dictionary");

        File xmlDocument = new File("dictionary.xml");
        InputSource inputSource = new InputSource(new FileInputStream(xmlDocument));
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("dictionary.xml");

        Object result = xPathExpression.evaluate(inputSource, XPathConstants.NODESET);

        NodeList nodeList = (NodeList) result;

        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println("Node name:" + nodeList.item(i).getNodeName());
            System.out.println("Node value:" + nodeList.item(i).getFirstChild().getNodeValue());
        }


    }
}
