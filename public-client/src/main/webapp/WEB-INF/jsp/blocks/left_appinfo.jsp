<%@ taglib tagdir="/WEB-INF/tags" prefix="dls" %>

<%--- Blocks (display components)
*********************************
dsp_left_appinfo.cfm

Info:
This block uses an exclusive lock, deleting expired sessions,
and thus will slow down the application. It is recommended
that this is only used on the front page.

--%>

<dls:leftblock title="Library Info">

<!---<cflock
 scope="APPLICATION"
 type="Exclusive"
 timeout="20">
 <!--- Clears out timed out sessions --->
 <cfloop collection="#Application.SessionTracker#" item="aUser">
  <cfset onlineSince = StructFind(Application.SessionTracker, aUser)>
  <cfif not DateCompare (onlineSince+Timeout, Now()) EQ 1>
   <!--- Delete IP from the Session-Tracker --->
   <cfset dummy = StructDelete(Application.SessionTracker, aUser)>
  </cfif>
 </cfloop>
 <!--- /Clears out timed out sessions --->--->

<cfoutput>
<table>

<cfif isDefined("session.library.id")>
<tr>
<td><img src="${pageContext.request.contextPath}/system/icons/appinfo_records.gif" width="20" height="20" border="0" alt="Records"></td>
<td class="leftContent">#countLibRecords.countValue# records currently in this Library</td>
</tr>
</cfif>

<tr>
<td><img src="system/icons/appinfo_records.gif" width="20" height="20" border="0" alt="Records"></td>
<td class="leftContent">#countSysRecords.countValue# records in the Digital Library System</td>
</tr>

<!---
<tr>
<td><img src="system/icons/appinfo_users.gif" width="20" height="20" border="0" alt="Records"></td>
<td class="leftContent">#StructCount(Application.SessionTracker)# users currently online</td>
</tr>
--->
</table>
</cfoutput>

<!---
</cflock>--->
</dls:leftblock>


<br />
