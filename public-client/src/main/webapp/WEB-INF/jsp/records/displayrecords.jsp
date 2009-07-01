<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<script language="JavaScript" type="text/javascript">
function navThru(pgNum) {
 f=document.DLSDR;
 m=parseInt(f.maxrow.value);
 f.startrow.value=(pgNum*m-m+1);
 f.submit();
}
function navPrev() {
 f=document.DLSDR;
 v=parseInt(f.startrow.value)-parseInt(f.maxrow.value);
 (v>=1) ? f.startrow.value=v : s=f.startrow.value=1;
 f.submit();
}
function navNext() {
 f=document.DLSDR;
 v=parseInt(f.startrow.value)+parseInt(f.maxrow.value);
 (v<=recordCount) ? f.startrow.value=v : 0;
 f.submit();
}
</script>



<%--
<form name="DLSDR"
 method="POST"
 action="#request.page.defaultPage#?#request.URLToken#">

<input type="hidden" name="fuseaction" value="#attributes.fuseaction#" />
<input type="hidden" name="startrow" value="#attributes.startrow#" />
<input type="hidden" name="maxrow" value="#attributes.maxrow#" />
<input type="hidden" name="ord" value="#attributes.ord#" />
<input type="hidden" name="sort" value="#attributes.sort#" />

<input type="hidden" name="lb" value="#attributes.lb#" />

<!--- Fields to send: --->
<cfif variables.isQuickSearch>
 <input type="hidden" name="kw" value="#attributes.kw#" />
 <input type="hidden" name="kwt" value="#attributes.kwt#" />
<cfelse>
 <cfif xLen(attributes.tt)>
 <input type="hidden" name="tt" value="#attributes.tt#" />
 <input type="hidden" name="ttt" value="#attributes.ttt#" />
 </cfif>
 <cfif xLen(attributes.ta)>
 <input type="hidden" name="ta" value="#attributes.ta#" />
 <input type="hidden" name="tat" value="#attributes.tat#" />
 </cfif>
 <cfif xLen(attributes.da)>
 <input type="hidden" name="da" value="#attributes.da#" />
 <input type="hidden" name="dat" value="#attributes.dat#" />
 </cfif>
 <cfif xLen(attributes.sb)>
 <input type="hidden" name="sb" value="#attributes.sb#" />
 <input type="hidden" name="sbt" value="#attributes.sbt#" />
 </cfif>
</cfif>

<!--- Date Criteria --->
<cfif dateCritExists()>
 <cfif xIsDate(attributes.dcb)><input type="hidden" name="dcb" value="#attributes.dcb#" /></cfif>
 <cfif xIsDate(attributes.dca)><input type="hidden" name="dca" value="#attributes.dca#" /></cfif>
 <cfif xIsDate(attributes.dab)><input type="hidden" name="dab" value="#attributes.dab#" /></cfif>
 <cfif xIsDate(attributes.daa)><input type="hidden" name="daa" value="#attributes.daa#" /></cfif>
</cfif>

<!--- Miscellaneous Criteria --->
<cfif miscCritExists()>
 <cfif xLen(attributes.ct)><input type="hidden" name="ct" value="#attributes.ct#" /></cfif>
 <cfif xLen(attributes.cr)><input type="hidden" name="cr" value="#attributes.cr#" /></cfif>
 <cfif isOrgCode(attributes.co)><input type="hidden" name="cr" value="#val(attributes.co)#" /></cfif>
</cfif>



<script language="JavaScript" type="text/javascript">
recordCount=#getRecords.RecordCount#;
</script>
</cfoutput>

--%>


<table width="100%" cellpadding="4" cellspacing="0" border="0">
<tr height="20">
 <td width="50%" bgcolor="#<spring:theme code="colors.controls1background"/>" class="queryInfoNav">
 ## records found. Displaying &nbsp;</td>
 <td width="50%" align="right" bgcolor="#<spring:theme code="colors.controls1background"/>" class="queryInfoNav">&nbsp;#NavThruRecords#</td>
</tr>
</table>


<h1>Search Results</h1>



<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr valign="middle">

<c:forEach var="item" items="${searchResults.hits}" varStatus="itemStatus">

<td width="50%" align="center">


 <table width="250" border="0" cellspacing="1" cellpadding="2">
 <tr valign="top">
  <td><span class="resultNumber">&nbsp;${itemStatus.index+1}.&nbsp;</span></td>
  <td rowspan="2"><a href="${pageContext.request.contextPath}/item.html?id=${item.data.id}"><img src="${thumbPath}/#thumbfile#" border="1" alt="#title#" /></a></td>
 </tr>
 <tr valign="top">
  <td></td>
 </tr>
 <tr valign="top">
  <td></td>
  <td bgcolor="#<spring:theme code="colors.resultscell1a"/>" class="resultFieldData">${item.data.title}</td>
 </tr>
 <cfif variables.displayLibrary>
 <tr valign="top">
  <td></td>
  <td bgcolor="#<spring:theme code="colors.resultscell2a"/>" class="resultFieldData">${item.data.collection.name}</td>
 </tr>
 </cfif>
 <tr valign="top">
  <td></td>
  <td bgcolor="#<spring:theme code="colors.resultscell2a"/>" class="resultFieldData">${item.data.thumbFile.format.type}</td>
 </tr>
 </table>
</td>
<cfif (attributes.startRow mod 2 and not currentRow mod 2)	or (not attributes.startRow mod 2 and currentRow mod 2)>

<%

//if ((i%2 == 0 && show != 5) || (show == 5 && ((start%2 == 0) == (i%2 == 0))))
  //  s.append("  </tr>\n  <tr valign=\"middle\">\n");
%>



</c:forEach>

</table>




<br />




 <c:if test="${! empty searchResults.pages}">

    <BR><BR><BR>

    <c:forEach var="page" items="${searchResults.pages}" varStatus="pagesStatus">

      <c:choose>
        <c:when test="${page.selected}">
          <c:out value="${page.from}" />-<c:out value="${page.to}" />
        </c:when>
        <c:otherwise>
        <a href="?page=${pagesStatus.index}">${pagesStatus.index}</a>
        <%--<a href="?page=${pagesStatus.index}">${page.from} - ${page.to}</a>--%>
          <%--<FORM method="GET">
            <spring:bind path="command.query">
               <INPUT type="hidden" name="query" value="<c:out value="${status.value}"/>" />
            </spring:bind>
            <spring:bind path="command.page">
               <INPUT type="hidden" name="page" value="<c:out value="${pagesStatus.index}"/>" />
            </spring:bind>
            <INPUT type = "submit" value="<c:out value="${page.from}" />-<c:out value="${page.to}" />"/>
          </FORM>--%>
        </c:otherwise>
      </c:choose>

    </c:forEach>


  </c:if>


<table width="100%" cellpadding="4" cellspacing="0" border="0">
<tr height="20">
 <td width="50%" bgcolor="#<spring:theme code="colors.controls1background"/>" class="queryInfoNav">#QueryInfoMessage#&nbsp;</td>
 <td width="50%" align="right" bgcolor="#<spring:theme code="colors.controls1background"/>" class="queryInfoNav">&nbsp;#NavThruRecords#</td>
</tr>
</table>
<table width="100%" cellpadding="4" cellspacing="0" border="0">
 <tr height="20">
  <td colspan="2" bgcolor="#<spring:theme code="colors.controls2background"/>" class="displayOptions">
  <!--- Navigation by page --->

  Page
  <cfif variables.prevPageStart-1 eq 1>
  <a href="javascript:navThru(1);" title="Records: Show first records page"
    onmouseover="displayStatusMsg('Records: Show first records page');return true;"
    onmouseout="displayStatusMsg('');return true;">1</a>
  <cfelseif variables.prevPageStart gt 1>
  <a href="javascript:navThru(1);" title="Records: Skip back to first records page"
    onmouseover="displayStatusMsg('Records: Skip back to first records page');return true;"
    onmouseout="displayStatusMsg('');return true;">1</a>...
  </cfif>

  <cfloop index="x"
   from="#variables.prevPageStart#"
   to="#variables.prevPageEnd#">
   <cfset variables.xMsg = "Records: Show records page #x# of #variables.totalPages#">
   <a href="javascript:navThru(#x#);" title="#variables.xMsg#"
    onmouseover="displayStatusMsg('#variables.xMsg#');return true;"
    onmouseout="displayStatusMsg('');return true;">#x#</a>
  </cfloop>

  <span class="displayOptionsSelected" title="Current Page">#variables.currentPage#</span>

  <cfloop index="x"
   from="#variables.nextPageStart#"
   to="#variables.nextPageEnd#">
   <cfset variables.xMsg = "Records: Show records page #x# of #variables.totalPages#">
   <a href="javascript:navThru(#x#);" title="#variables.xMsg#"
    onmouseover="displayStatusMsg('#variables.xMsg#');return true;"
    onmouseout="displayStatusMsg('');return true;">#x#</a>
  </cfloop>

  <cfif variables.nextPageEnd+1 eq variables.totalPages>
  <a href="javascript:navThru(#variables.totalPages#);" title="Records: Show last records page"
    onmouseover="displayStatusMsg('Records: Show last records page');return true;"
    onmouseout="displayStatusMsg('');return true;">#variables.totalPages#</a>
  <cfelseif variables.nextPageEnd lt variables.totalPages>
  ... <a href="javascript:navThru(#variables.totalPages#);" title="Records: Skip forward to last records page"
    onmouseover="displayStatusMsg('Records: Skip forward to last records page');return true;"
    onmouseout="displayStatusMsg('');return true;">#variables.totalPages#</a>
  </cfif>
  </td>
 </tr>
</table>



Search took ${searchResults.searchTime}>ms

<%--
</form> --%>
