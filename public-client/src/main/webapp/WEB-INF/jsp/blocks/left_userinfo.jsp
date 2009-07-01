<%@ taglib tagdir="/WEB-INF/tags" prefix="dls" %>
<%-- Blocks (display components)
*********************************
dsp_left_userinfo.cfm

Info:


--%>

<%--
<table width="140" bgcolor="<cfoutput>#request.Design.leftBlock.outer#</cfoutput>">
<tr valign="middle"><td class="leftHead"><img src="<cfoutput>${pageContext.request.contextPath}</cfoutput>/system/icons/userinfo_icon.gif" width="14" height="15" border="0" alt="">
User information</td></tr>
<tr><td bgcolor="<cfoutput>#request.Design.leftBlock.inner#</cfoutput>" class="leftContent">
<cflock
  scope="SESSION"
  type="READONLY"
  timeout="5" throwontimeout="No">
<cfoutput>


Logged in as <b>#Session.UserName#</b><br />
(level #Session.User_Groups# member)<br />
<b>&##149;</b>&nbsp;<a href="#request.page.defaultPage#?fuseaction=users.changepassword&#request.URLToken#"
 onmouseover="window.status='CHANGE PASSWORD: Set a new password for your account.';return true;">Change Password</a><br />
<b>&##149;</b>&nbsp;<a href="#request.page.defaultPage#?fuseaction=users.logout&#request.URLToken#"
 onmouseover="window.status='LOG OUT: Sign out of the library.';return true;">Log Out</a>
</cfoutput>
</cflock>
</td></tr>
</table>

<br />
--%>
