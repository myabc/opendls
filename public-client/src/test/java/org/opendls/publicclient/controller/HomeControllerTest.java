package org.opendls.publicclient.controller;

import java.util.List;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

public class HomeControllerTest extends BaseControllerTestCase
{
    private HomeController c;

    public void setHomeController(HomeController c)
    {
        this.c = c;
    }

    public void testHandleRequest() throws Exception
    {
        ModelAndView mav = c.handleRequest(null, null);
        ModelMap m = mav.getModelMap();
        assertNotNull(m.get("collections"));
        assertTrue(((List) m.get("collections")).size() > 0);
    }
}
