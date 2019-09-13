import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class XML {

    public static File generateXmlFile() {

        ArrayList<String> files = new ArrayList<String>();
        File directory = new File(Main.OUTPUT + Main.themeTitle);
//        File directory = new File("C:\\Users\\Roberto\\IdeaProjects\\PsVitaThemeBuilder\\target\\Themes\\Patata");
        for(File file : directory.listFiles()) {
            files.add(file.getName());
            System.out.println("File: " + file.getName());
        }

        System.out.println("<---------->");

        Document doc = new Document();

        // Root Element
        Element theme = new Element("theme").setAttribute("format-ver", "00.99").setAttribute("package", "0");

        // Sub-Root Elements
        Element homeProperty = new Element("HomeProperty");
        Element infomationBarProperty = new Element("InfomationBarProperty");
        Element infomationProperty = new Element("InfomationProperty");
        Element startScreenProperty = new Element("StartScreenProperty");

        // InfomationBarProperty //TODO



        // InfomationProperty
        infomationProperty.addContent(new Element("m_provider").addContent(new Element("m_default").addContent(Main.themeAuthor)));
        infomationProperty.addContent(new Element("m_contentVer").addContent("1.00"));
        if(files.contains("preview_page.png")) {
            infomationProperty.addContent(new Element("m_homePreviewFilePath").addContent("preview_page.png"));
        }
        if(files.contains("preview_lockscreen.png")) {
            infomationProperty.addContent(new Element("m_startPreviewFilePath").addContent("preview_lockscreen.png"));
        }
        if(files.contains("preview_thumbnail.png")) {
            infomationProperty.addContent(new Element("m_packageImageFilePath").addContent("preview_thumbnail.png"));
        }



        theme.addContent(homeProperty);
        theme.addContent(infomationBarProperty);
        theme.addContent(infomationProperty);
        theme.addContent(startScreenProperty);
        doc.setRootElement(theme);



        //Create the XML

        try {
            XMLOutputter outter=new XMLOutputter();
            outter.setFormat(Format.getPrettyFormat());
            outter.output(doc, System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        outter.output(doc, new FileWriter(new File("myxml.xml")));
        return null;
    }


    public static void main(String[] args) {
        XML.generateXmlFile();
    }

}
