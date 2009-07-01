package org.opendls.model;

import org.opendls.model.util.Matrix;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Content
{
    protected final static String LINKS = "LINKS";
    protected final static String SIDEBAR = "SIDEBAR";
    protected final static String WELCOME = "WELCOME";

    // Links 2D Array
    //private String links[][] = new String[2][5];
    private List<List<String>> links;
    // HTML content
    private String sidebar;
    private String welcome;

    public Content(Map<String, Object> contentMap)
    {
        setAsMap(contentMap);
    }

    public void setAsMap(Map<String, Object> contentMap)
    {
        // TODO: add links
        links = (List<List<String>>) contentMap.get(LINKS);
        sidebar = (String) contentMap.get(SIDEBAR);
        welcome = (String) contentMap.get(WELCOME);
    }

    public Map<String, Object> getAsMap()
    {
        Map<String, Object> contentMap = new HashMap<String, Object>();
        contentMap.put(LINKS, links);
        contentMap.put(SIDEBAR, sidebar);
        contentMap.put(WELCOME, welcome);
        return contentMap;
    }

    public List<List<String>> getLinks()
    {
        return links;
    }

    public String getSidebar()
    {
        return sidebar;
    }

    public String getWelcome()
    {
        return welcome;
    }

    public void setLinks(List<List<String>> links)
    {
        this.links = links;
    }

    public void setSidebar(String sidebar)
    {
        this.sidebar = sidebar;
    }

    public void setWelcome(String welcome)
    {
        this.welcome = welcome;
    }
}
