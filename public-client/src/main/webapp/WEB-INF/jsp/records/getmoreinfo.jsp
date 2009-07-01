<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<h1>Information Request</h1>

<h3>Request more information about this resource</h3>

<form action="/dls/item/moreinfo.html" method="post">


 <input type="HIDDEN" name="referer" value="#cgi.http_referer#" />

 <spring:bind path="command.itemId">
  <input type="HIDDEN" name="itemId" value="${status.value}" />
 </spring:bind>




<p class="bodyText">This information request form is <strong>optional</strong>.
However, we do need an email address to answer your request.</p>

<table>
<tr valign="top">
 <td align="right" class="formLabel">Your name:</td>
 <td class="formLabel">
 <spring:bind path="command.fromName">
  <input type="TEXT" name="fromName" value="${status.value}" class="formTextInput" />
 </spring:bind></td></tr>
<tr valign="top">
 <td align="right" class="formLabel">Your email address:</td>
 <td class="formLabel">
 <spring:bind path="command.fromEmail">
  <input type="TEXT" name="fromEmail" value="${status.value}" class="formTextInput" />
 </spring:bind></td></tr>
<tr valign="top">
 <td align="right" class="formLabel">Additional comments:</td>
 <td class="formLabel">
 <spring:bind path="command.comments"><textarea name="comments"
  rows="8" cols="25" class="formTextInput">Please write any additional comments here
  ${status.value}</textarea>
 </spring:bind></td></tr>
<tr valign="top">
 <td></td>
 <td><input type="SUBMIT" value="Send request" class="formSubmit" /></td></tr>
</table>

</form>

<h3>Important</h3>


<p class="bodyText"><a href="<cfoutput>#cgi.http_referer#</cfoutput>">Return to the previous page</a></p>

<p class="bodyText"></p>
