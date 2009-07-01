<%@ taglib tagdir="/WEB-INF/tags" prefix="dls" %>

<dls:leftblock title="Record Options">
<table>
<tr>
<td><img src="app_images/bullet.gif" width="3" height="3" hspace="2" vspace="6" alt="*" /></td>
<td class="leftContent"><a href="default.cfm?fuseaction=records.getmoreinfo&id=<cfoutput>#getRecord.data_Id#&#request.urlToken#</cfoutput>">Contact us about this resource</a></td></tr>
</table>
</dls:leftblock>
