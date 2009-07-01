package org.opendls.publicclient.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import org.opendls.model.Item;
import org.opendls.service.ItemService;

public class SearchController implements Controller
{

 private ItemService itemService;

 public void setItemService(ItemService itemService)
 {
  this.itemService = itemService;
 }

 public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
  throws Exception
 {

  List<Item> items = itemService.getItems();

  return new ModelAndView(".views.searchresults", "items", items);
 }

    private Date date(String d) {
        Date result = null;
        int[] tmp = new int[3];
        if (d.indexOf('/') > -1) {
            StringTokenizer tok = new StringTokenizer(d, "/");
            if (tok.countTokens() == 3) {
                try {
                    tmp[0] = Integer.parseInt(tok.nextToken())-1;
                    tmp[1] = Integer.parseInt(tok.nextToken());
                    tmp[2] = Integer.parseInt(tok.nextToken());
                    Calendar cal = Calendar.getInstance();
                    cal.set(Calendar.MONTH, tmp[0]);
                    cal.set(Calendar.DATE, tmp[1]);
                    cal.set(Calendar.YEAR, tmp[2]);
                    result = cal.getTime();
                } catch (Exception ignored) { }
            }
        }
        else if (d.indexOf('-') > -1) {
            StringTokenizer tok = new StringTokenizer(d, "-");
            if (tok.countTokens() == 3) {
                try {
                    tmp[0] = Integer.parseInt(tok.nextToken())-1;
                    tmp[1] = Integer.parseInt(tok.nextToken());
                    tmp[2] = Integer.parseInt(tok.nextToken());
                    Calendar cal = Calendar.getInstance();
                    cal.set(Calendar.MONTH, tmp[0]);
                    cal.set(Calendar.DATE, tmp[1]);
                    cal.set(Calendar.YEAR, tmp[2]);
                    result = cal.getTime();
                } catch (Exception ignored) { }
            }
        }
        return result;
    }


}
