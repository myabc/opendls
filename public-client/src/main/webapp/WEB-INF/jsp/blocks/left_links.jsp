<%@ taglib tagdir="/WEB-INF/tags" prefix="dls" %>
<%-- Blocks (display components)
*********************************
dsp_left_links.cfm

--%>


<dls:leftblock title="Links of Interest">

<table>
<cfloop index="i"
 from="1"
 to="#arrayLen(request.library.content.links[1])#">
<cfif len(request.library.content.links[1][i])>
<tr>
<td><img src="app_images/bullet.gif" width="3" height="3" hspace="2" vspace="6" alt="*" /></td>
<td class="leftContent"><a href="#request.library.content.links[2][i]#"
   title="External Link of Interest"
   onmouseover="displayStatusMsg('Link: #request.library.content.links[1][i]#');return document.returnValue"
   onmouseout="displayStatusMsg('');return document.returnValue">#request.library.content.links[1][i]#</a></td></tr>
</cfif>
</cfloop>
</table>

</dls:leftblock>
