package org.opendls.model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author alexbcoles
 */
public class UIFonts
{
    protected final static String BODY = "BODY";
    protected final static String HEADERS = "HEADERS";
    protected final static String CONTROLS = "CONTROLS";

    private String body;
    private String headers;
    private String controls;

    public UIFonts(Map<String, String> fontMap)
    {
        setAsMap(fontMap);
    }

    public void setAsMap(Map<String, String> fontMap)
    {
        body = fontMap.get(BODY);
        headers = fontMap.get(HEADERS);
        controls = fontMap.get(CONTROLS);
    }

    public Map<String, String> getAsMap()
    {
        Map<String, String> fontMap = new HashMap<String, String>();
        fontMap.put(BODY, body);
        fontMap.put(HEADERS, headers);
        fontMap.put(CONTROLS, controls);
        return fontMap;
    }

    public String getBody()
    {
        return body;
    }

    public String getHeaders()
    {
        return headers;
    }

    public String getControls()
    {
        return controls;
    }

    public void setBody(String body)
    {
        this.body = body;
    }

    public void setHeaders(String headers)
    {
        this.headers = headers;
    }

    public void setControls(String controls)
    {
        this.controls = controls;
    }

}
