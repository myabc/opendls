package org.opendls.model;

import java.util.HashMap;
import java.util.Map;

public class UserInterface
{
    protected final static String FONTS = "FONTS";
    protected final static String COLORS = "COLORS";
    protected final static String HTML_HEAD = "HTMLHEAD";
    protected final static String HTML_FOOT = "HTMLFOOT";

    // Fonts
    private UIFonts fonts;
    // Colors
    private UIColors colors;
    // HTML Header and Footers
    private String htmlHead;
    private String htmlFoot;

    public UserInterface(Map<String, Object> uiMap)
    {
        setAsMap(uiMap);
    }

    public void setAsMap(Map<String, Object> uiMap)
    {
        Map<String, String> fontsMap = (Map<String, String>) uiMap.get(FONTS);
        Map<String, String> colorsMap = (Map<String, String>) uiMap.get(COLORS);

        fonts =  (fontsMap != null) ? new UIFonts(fontsMap) : null;
        colors = (colorsMap != null) ? new UIColors(colorsMap) : null;
        htmlHead = (String) uiMap.get(HTML_HEAD);
        htmlFoot = (String) uiMap.get(HTML_FOOT);
    }

    public Map<String, Object> getAsMap()
    {
        Map uiMap = new HashMap<String, Object>();

        if (fonts != null)
        {
            uiMap.put(FONTS, fonts.getAsMap());
        }
        if (colors != null)
        {
            uiMap.put(COLORS, colors.getAsMap());
        }
        uiMap.put(HTML_HEAD, htmlHead);
        uiMap.put(HTML_FOOT, htmlFoot);

        return uiMap;
    }

    public UIFonts getFonts()
    {
        return fonts;
    }

    public UIColors getColors()
    {
        return colors;
    }

    public String getHtmlHead()
    {
        return htmlHead;
    }

    public String getHtmlFoot()
    {
        return htmlFoot;
    }

    public void setFonts(UIFonts fonts)
    {
        this.fonts = fonts;
    }

    public void setColors(UIColors colors)
    {
        this.colors = colors;
    }

    public void setHtmlHead(String htmlHead)
    {
        this.htmlHead = htmlHead;
    }

    public void setHtmlFoot(String htmlFoot)
    {
        this.htmlFoot = htmlFoot;
    }

}
