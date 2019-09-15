import org.jdom.Comment;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class XML {
    public static void generateXmlFile() {
        ArrayList<String> files = new ArrayList<String>();
        int bgCounter = 0;
        File directory = new File(Main.OUTPUT + Main.themeTitle);
//        File directory = new File("C:\\Users\\Roberto\\IdeaProjects\\PsVitaThemeBuilder\\target\\Themes\\Patata");
//        File directory = new File("/home/roberto/IdeaProjects/PsVitaThemeBuilder/target/Themes/ZZZ");
        for (File file : directory.listFiles()) {
            files.add(file.getName());
            if (file.getName().startsWith("bg_")) {
                bgCounter++;
            }
        }
        bgCounter = bgCounter / 2;


        Document doc = new Document();

        // Root Element
        Element theme = new Element("theme").setAttribute("format-ver", "00.99").setAttribute("package", "0");

        // Sub-Root Elements
        Element homeProperty = new Element("HomeProperty");
        Element infomationBarProperty = new Element("InfomationBarProperty");
        Element infomationProperty = new Element("InfomationProperty");
        Element startScreenProperty = new Element("StartScreenProperty");

        // HomeProperty
        Element m_bgParam = new Element("m_bgParam");

        for (int x = 1; x <= bgCounter; x++) {
            if (x != 10) {
                String number = "0" + x;
                m_bgParam.addContent(new Element("BackgroundParam").addContent(new Element("m_imageFilePath").addContent("bg_" + number + ".png")).addContent(new Element("m_thumbnailFilePath").addContent("bg_" + number + "t.png")));
            } else {
                m_bgParam.addContent(new Element("BackgroundParam").addContent(new Element("m_imageFilePath").addContent("bg_10.png")).addContent(new Element("m_thumbnailFilePath").addContent("bg_10t.png")));
            }
        }

        homeProperty.addContent(m_bgParam);

        if (files.contains("BGM.at9")) {
            homeProperty.addContent(new Element("m_bgmFilePath").addContent("BGM.at9"));
        }
        if (files.contains("basepage.png")) {
            homeProperty.addContent(new Element("m_basePageFilePath").addContent("basepage.png"));
        }
        if (files.contains("curpage.png")) {
            homeProperty.addContent(new Element("m_curPageFilePath").addContent("curpage.png"));
        }

            String iconTag = "m_iconFilePath";
        if (files.contains("icon_calendar.png")) {
            homeProperty.addContent(new Element("m_calendar").addContent(new Element(iconTag).addContent("icon_calendar.png")));
        }
        if (files.contains("icon_cma.png")) {
            homeProperty.addContent(new Element("m_hostCollabo").addContent(new Element(iconTag).addContent("icon_cma.png")));
        }
        if (files.contains("icon_friends.png")) {
            homeProperty.addContent(new Element("m_friend").addContent(new Element(iconTag).addContent("icon_friends.png")));
        }
        if (files.contains("icon_mail.png")) {
            homeProperty.addContent(new Element("m_email").addContent(new Element(iconTag).addContent("icon_mail.png")));
        }
        if (files.contains("icon_messages.png")) {
            homeProperty.addContent(new Element("m_message").addContent(new Element(iconTag).addContent("icon_messages.png")));
        }
        if (files.contains("icon_music.png")) {
            homeProperty.addContent(new Element("m_music").addContent(new Element(iconTag).addContent("icon_music.png")));
        }
        if (files.contains("icon_near.png")) {
            homeProperty.addContent(new Element("m_near").addContent(new Element(iconTag).addContent("icon_near.png")));
        }
        if (files.contains("icon_parental.png")) {
            homeProperty.addContent(new Element("m_parental").addContent(new Element(iconTag).addContent("icon_parental.png")));
        }
        if (files.contains("icon_party.png")) {
            homeProperty.addContent(new Element("m_party").addContent(new Element(iconTag).addContent("icon_party.png")));
        }
        if (files.contains("icon_photos.png")) {
            homeProperty.addContent(new Element("m_camera").addContent(new Element(iconTag).addContent("icon_photos.png")));
        }
        if (files.contains("icon_power.png")) {
            homeProperty.addContent(new Element("m_power").addContent(new Element(iconTag).addContent("icon_power.png")));
        }
        if (files.contains("icon_ps3link.png")) {
            homeProperty.addContent(new Element("m_ps3Link").addContent(new Element(iconTag).addContent("icon_ps3link.png")));
        }
        if (files.contains("icon_ps4link.png")) {
            homeProperty.addContent(new Element("m_ps4Link").addContent(new Element(iconTag).addContent("icon_ps4link.png")));
        }
        if (files.contains("icon_settings.png")) {
            homeProperty.addContent(new Element("m_settings").addContent(new Element(iconTag).addContent("icon_settings.png")));
        }
        if (files.contains("icon_trophies.png")) {
            homeProperty.addContent(new Element("m_trophy").addContent(new Element(iconTag).addContent("icon_trophies.png")));
        }
        if (files.contains("icon_videos.png")) {
            homeProperty.addContent(new Element("m_video").addContent(new Element(iconTag).addContent("icon_videos.png")));
        }
        if (files.contains("icon_web.png")) {
            homeProperty.addContent(new Element("m_browser").addContent(new Element(iconTag).addContent("icon_web.png")));
        }


        // InfomationBarProperty
        infomationBarProperty.addContent(new Element("m_barColor").addContent(Misc.miscList[3]));
        infomationBarProperty.addContent(new Element("m_indicatorColor").addContent(Misc.miscList[4]));

        if(files.contains("logo.png")) {
            infomationBarProperty.addContent(new Element("m_noNoticeFilePath").addContent("logo.png"));
        }


        // InfomationProperty
        infomationProperty.addContent(new Element("m_contentVer").addContent("01.00"));
        infomationProperty.addContent(new Element("m_provider").addContent(new Element("m_default").addContent(Main.themeAuthor)));
        if (files.contains("preview_page.png")) {
            infomationProperty.addContent(new Element("m_homePreviewFilePath").addContent("preview_page.png"));
        }
        if (files.contains("preview_lockscreen.png")) {
            infomationProperty.addContent(new Element("m_startPreviewFilePath").addContent("preview_lockscreen.png"));
        }
        if (files.contains("preview_thumbnail.png")) {
            infomationProperty.addContent(new Element("m_packageImageFilePath").addContent("preview_thumbnail.png"));
        }

        String title = Main.themeTitle.replace("/", "");
        Element titleElement = new Element("m_title");
        titleElement.addContent(new Element("m_default").addContent(title));
        Element m_paramTitles = new Element("m_param");
        String[] languages = {
                "m_da",
                "m_de",
                "m_es",
                "m_fi",
                "m_fr",
                "m_it",
                "m_nl",
                "m_no",
                "m_pl",
                "m_pt",
                "m_ru",
                "m_sv"
        };

        for (String language : languages) {
            m_paramTitles.addContent(new Element(language).addContent(title));
        }

        titleElement.addContent(m_paramTitles);
        infomationProperty.addContent(titleElement);


        // StartScreenProperty
        startScreenProperty.addContent(new Element("m_filePath").addContent("start_bg.png"));
        startScreenProperty.addContent(new Element("m_dateColor").addContent(Misc.miscList[5]));
        startScreenProperty.addContent(new Element("m_dateLayout").addContent(Misc.miscList[6]));
        startScreenProperty.addContent(new Element("m_notifyFontColor").addContent(Misc.miscList[7]));
        startScreenProperty.addContent(new Element("m_notifyBgColor").addContent(Misc.miscList[8]));
        startScreenProperty.addContent(new Element("m_notifyBorderColor").addContent(Misc.miscList[9]));


        theme.addContent(homeProperty);
        theme.addContent(infomationBarProperty);
        theme.addContent(infomationProperty);
        theme.addContent(startScreenProperty);
        theme.addContent(new Comment("Created using https://github.com/trampitax/PsVitaThemeBuilder"));
        doc.setRootElement(theme);


        //Create the XML
        try {
            XMLOutputter outter = new XMLOutputter();
            outter.setFormat(Format.getPrettyFormat());
            outter.output(doc, new FileWriter(new File(Main.OUTPUT + Main.themeTitle + "theme.xml")));
//            outter.output(doc, System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
