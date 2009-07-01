package org.opendls.model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author alexbcoles
 */
public class UIColors
{
    protected final static String BODY_BACKGROUND = "BODYBACKGROUND";
    protected final static String BODY = "BODY";
    protected final static String HEADERS = "HEADERS";
    protected final static String CONTENT_BACKGROUND = "CONTENTBACKGROUND";
    protected final static String TABS_BACKGROUND = "TABSBACKGROUND";
    protected final static String TABS = "TABS";
    protected final static String LEFT_AREA_BACKGROUND = "LEFTAREABACKGROUND";
    protected final static String LEFT_AREA = "LEFTAREA";
    protected final static String LEFT_BOX_HEAD_BACKGROUND = "LEFTBOXHEADBACKGROUND";
    protected final static String LEFT_BOX_HEAD = "LEFTBOXHEAD";
    protected final static String LEFT_BOX_BACKGROUND = "LEFTBOXBACKGROUND";
    protected final static String LEFT_BOX = "LEFTBOX";
    protected final static String A_LINK_BACKGROUND = "ALINKBACKGROUND";
    protected final static String A_LINK = "ALINK";
    protected final static String A_HOVER_BACKGROUND = "AHOVERBACKGROUND";
    protected final static String A_HOVER = "AHOVER";
    protected final static String CONTROLS_1_BACKGROUND = "CONTROLS1BACKGROUND";
    protected final static String CONTROLS_1 = "CONTROLS1";
    protected final static String CONTROLS_2_BACKGROUND = "CONTROLS2BACKGROUND";
    protected final static String CONTROLS_2 = "CONTROLS2";
    protected final static String RESULTS_CELL_1 = "RESULTSCELL1";
    protected final static String RESULTS_CELL_1A = "RESULTSCELL1A";
    protected final static String RESULTS_CELL_2 = "RESULTSCELL2";
    protected final static String RESULTS_CELL_2A = "RESULTSCELL2A";

    private String bodyBackground;
    private String body;
    private String headers;
    private String contentBackground;
    private String tabsBackground;
    private String tabs;
    private String leftAreaBackground;
    private String leftArea;
    private String leftBoxHeadBackground;
    private String leftBoxHead;
    private String leftBoxBackground;
    private String leftBox;
    private String aLinkBackground;
    private String aLink;
    private String aHoverBackground;
    private String aHover;
    private String controls1Background;
    private String controls1;
    private String controls2Background;
    private String controls2;
    private String resultsCell1;
    private String resultsCell1a;
    private String resultsCell2;
    private String resultsCell2a;

    public UIColors(Map<String, String> colorMap)
    {
        setAsMap(colorMap);
    }

    public void setAsMap(Map<String,String> colorMap)
    {
        bodyBackground = colorMap.get(BODY_BACKGROUND);
        body = colorMap.get(BODY);
        headers = colorMap.get(HEADERS);
        contentBackground = colorMap.get(CONTENT_BACKGROUND);
        tabsBackground = colorMap.get(TABS_BACKGROUND);
        tabs = colorMap.get(TABS);
        leftAreaBackground = colorMap.get(LEFT_AREA_BACKGROUND);
        leftArea = colorMap.get(LEFT_AREA);
        leftBoxHeadBackground = colorMap.get(LEFT_BOX_HEAD_BACKGROUND);
        leftBoxHead = colorMap.get(LEFT_BOX_HEAD);
        leftBoxBackground = colorMap.get(LEFT_BOX_BACKGROUND);
        leftBox = colorMap.get(LEFT_BOX);
        aLinkBackground = colorMap.get(A_LINK_BACKGROUND);
        aLink = colorMap.get(A_LINK);
        aHoverBackground = colorMap.get(A_HOVER_BACKGROUND);
        aHover = colorMap.get(A_HOVER);
        controls1Background = colorMap.get(CONTROLS_1_BACKGROUND);
        controls1 = colorMap.get(CONTROLS_1);
        controls2Background = colorMap.get(CONTROLS_2_BACKGROUND);
        controls2 = colorMap.get(CONTROLS_2);
        resultsCell1 = colorMap.get(RESULTS_CELL_1);
        resultsCell1a = colorMap.get(RESULTS_CELL_1A);
        resultsCell2 = colorMap.get(RESULTS_CELL_2);
        resultsCell2a = colorMap.get(RESULTS_CELL_2A);
    }

    public Map<String, String> getAsMap()
    {
        Map<String, String> colorMap = new HashMap<String, String>();
        colorMap.put(BODY_BACKGROUND, bodyBackground);
        colorMap.put(BODY, body);
        colorMap.put(HEADERS, headers);
        colorMap.put(CONTENT_BACKGROUND, contentBackground);
        colorMap.put(TABS_BACKGROUND, tabsBackground);
        colorMap.put(TABS, tabs);
        colorMap.put(LEFT_AREA_BACKGROUND, leftAreaBackground);
        colorMap.put(LEFT_AREA, leftArea);
        colorMap.put(LEFT_BOX_HEAD_BACKGROUND, leftBoxHeadBackground);
        colorMap.put(LEFT_BOX_HEAD, leftBoxHead);
        colorMap.put(LEFT_BOX_BACKGROUND, leftBoxBackground);
        colorMap.put(LEFT_BOX, leftBox);
        colorMap.put(A_LINK_BACKGROUND, aLinkBackground);
        colorMap.put(A_LINK, aLink);
        colorMap.put(A_HOVER_BACKGROUND, aHoverBackground);
        colorMap.put(A_HOVER, aHover);
        colorMap.put(CONTROLS_1_BACKGROUND, controls1Background);
        colorMap.put(CONTROLS_1, controls1);
        colorMap.put(CONTROLS_2_BACKGROUND, controls2Background);
        colorMap.put(CONTROLS_2, controls2);
        colorMap.put(RESULTS_CELL_1, resultsCell1);
        colorMap.put(RESULTS_CELL_1A, resultsCell1a);
        colorMap.put(RESULTS_CELL_2, resultsCell2);
        colorMap.put(RESULTS_CELL_2A, resultsCell2a);
        return colorMap;
    }

    public String getAHover() {
        return aHover;
    }

    public String getAHoverBackground() {
        return aHoverBackground;
    }

    public String getALink() {
        return aLink;
    }

    public String getALinkBackground() {
        return aLinkBackground;
    }

    public String getBody() {
        return body;
    }

    public String getBodyBackground() {
        return bodyBackground;
    }

    public String getContentBackground() {
        return contentBackground;
    }

    public String getControls1() {
        return controls1;
    }

    public String getControls1Background() {
        return controls1Background;
    }

    public String getControls2() {
        return controls2;
    }

    public String getControls2Background() {
        return controls2Background;
    }

    public String getHeaders() {
        return headers;
    }

    public String getLeftArea() {
        return leftArea;
    }

    public String getLeftAreaBackground() {
        return leftAreaBackground;
    }

    public String getLeftBox() {
        return leftBox;
    }

    public String getLeftBoxBackground() {
        return leftBoxBackground;
    }

    public String getLeftBoxHead() {
        return leftBoxHead;
    }

    public String getLeftBoxHeadBackground() {
        return leftBoxHeadBackground;
    }

    public String getResultsCell1() {
        return resultsCell1;
    }

    public String getResultsCell1a() {
        return resultsCell1a;
    }

    public String getResultsCell2() {
        return resultsCell2;
    }

    public String getResultsCell2a() {
        return resultsCell2a;
    }

    public String getTabs() {
        return tabs;
    }

    public String getTabsBackground() {
        return tabsBackground;
    }

    public void setAHover(String aHover) {
        this.aHover = aHover;
    }

    public void setAHoverBackground(String aHoverBackground) {
        this.aHoverBackground = aHoverBackground;
    }

    public void setALink(String aLink) {
        this.aLink = aLink;
    }

    public void setALinkBackground(String aLinkBackground) {
        this.aLinkBackground = aLinkBackground;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setBodyBackground(String bodyBackground) {
        this.bodyBackground = bodyBackground;
    }

    public void setContentBackground(String contentBackground) {
        this.contentBackground = contentBackground;
    }

    public void setControls1(String controls1) {
        this.controls1 = controls1;
    }

    public void setControls1Background(String controls1Background) {
        this.controls1Background = controls1Background;
    }

    public void setControls2(String controls2) {
        this.controls2 = controls2;
    }

    public void setControls2Background(String controls2Background) {
        this.controls2Background = controls2Background;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }

    public void setLeftArea(String leftArea) {
        this.leftArea = leftArea;
    }

    public void setLeftAreaBackground(String leftAreaBackground) {
        this.leftAreaBackground = leftAreaBackground;
    }

    public void setLeftBox(String leftBox) {
        this.leftBox = leftBox;
    }

    public void setLeftBoxBackground(String leftBoxBackground) {
        this.leftBoxBackground = leftBoxBackground;
    }

    public void setLeftBoxHead(String leftBoxHead) {
        this.leftBoxHead = leftBoxHead;
    }

    public void setLeftBoxHeadBackground(String leftBoxHeadBackground) {
        this.leftBoxHeadBackground = leftBoxHeadBackground;
    }

    public void setResultsCell1(String resultsCell1) {
        this.resultsCell1 = resultsCell1;
    }

    public void setResultsCell1a(String resultsCell1a) {
        this.resultsCell1a = resultsCell1a;
    }

    public void setResultsCell2(String resultsCell2) {
        this.resultsCell2 = resultsCell2;
    }

    public void setResultsCell2a(String resultsCell2a) {
        this.resultsCell2a = resultsCell2a;
    }

    public void setTabs(String tabs) {
        this.tabs = tabs;
    }

    public void setTabsBackground(String tabsBackground) {
        this.tabsBackground = tabsBackground;
    }

}
