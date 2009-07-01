<%@ taglib tagdir="/WEB-INF/tags" prefix="dls" %>
<%-- Blocks (display components)
*********************************
dsp_left_search.jsp

Info:


--%>


<%-- Load the additional Javascript files that are required for this page --%>
<script src="${pageContext.request.contextPath}/app_jscsslib/advsearch.js"
 language="JavaScript" type="text/javascript"></script>


<form action="<cfoutput>#request.page.defaultPage#?#request.URLToken#</cfoutput>"
 method="post"
 onsubmit="return chkSearchForm(this)">

<dls:leftblock title="<img src='app_images/search_icon.gif' width='14' height='14' border='0' alt='search icon' align='absmiddle' /> Search">

<input type="hidden" name="fuseaction" value="records.searchresults" />

<input type="hidden" name="lb" value="#attributes.lb#" />
<input type="hidden" name="tp" value="#attributes.tp#" />
<input type="hidden" name="co" value="#attributes.co#" />

<table>
 <tr><td class="leftContent"><strong>Quick Search:</strong><br />Keywords:</td></tr>
 <tr><td><input type="TEXT" name="kw" size="10" value="#attributes.kw#" class="leftInput" /></td></tr>
 <tr><td class="leftContent"><strong>Specific Search:</strong><br /> &middot; Title:</td></tr>
 <tr><td><input type="TEXT" name="tt" size="10" value="#attributes.tt#" class="leftInput" /></td></tr>
 <tr><td class="leftContent"> &middot; Alternative Title:</td></tr>
 <tr><td><input type="TEXT" name="ta" size="10" value="#attributes.ta#" class="leftInput" /></td></tr>
 <tr><td class="leftContent"> &middot; Subject:</td></tr>
 <tr><td><input type="TEXT" name="sb" size="10" value="#attributes.sb#" class="leftInput" /></td></tr>
 <tr><td class="leftContent"> &middot; Description - Abstract:</td></tr>
 <tr><td><input type="TEXT" name="da" size="10" value="#attributes.da#" class="leftInput" /></td></tr>
 <tr><td class="leftContent">Creator:</td></tr>
 <tr><td><input type="TEXT" name="ct" size="10" value="#attributes.ct#" class="leftInput" /></td></tr>
 <tr><td class="leftContent">Contributor:</td></tr>
 <tr><td><input type="TEXT" name="cr" size="10" value="#attributes.cr#" class="leftInput" /></td></tr>
 <tr><td class="leftContent">Date Created:</td></tr>
 <tr><td>
 <table cellspacing="0" cellpadding="0" border="0">
 <tr><td class="leftContent">b&nbsp;</td>
 <td><input type="TEXT" name="dcb" size="5" value="#dateFormat(attributes.dcb,"mm/dd/yyyy")#" class="leftInput" style="width:50px" /></td>
 <td class="leftContent">a&nbsp;</td>
 <td><input type="TEXT" name="dca" size="5" value="#dateFormat(attributes.dca,"mm/dd/yyyy")#" class="leftInput" style="width:50px" /></td></tr>
 </table>
 </td></tr>
 <tr><td class="leftContent">Date Available:</td></tr>
 <tr><td>
 <table cellspacing="0" cellpadding="0" border="0">
 <tr><td class="leftContent">b&nbsp;</td>
 <td><input type="TEXT" name="dab" size="5" value="#dateFormat(attributes.dab,"mm/dd/yyyy")#" class="leftInput" style="width:50px" /></td>
 <td class="leftContent">a&nbsp;</td>
 <td><input type="TEXT" name="daa" size="5" value="#dateFormat(attributes.daa,"mm/dd/yyyy")#" class="leftInput" style="width:50px" /></td></tr>
 </table>
 </td></tr>
</table>

<div align="right"><input type="submit" value="Go" class="leftSubmit" /></div>

</dls:leftblock>
</form>
