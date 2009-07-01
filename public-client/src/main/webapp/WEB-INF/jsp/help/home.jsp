<h1>help center</h1>

<p class="bodyText">
<a href="${pageContext.request.contextPath}/help/using.html">Using the Library</a><br />
<a href="${pageContext.request.contextPath}/help/contactus.html">Contact Us</a><br />
<a href="${pageContext.request.contextPath}/help/reportbugs.html">Report Bugs</a><br />
<a href="${pageContext.request.contextPath}/help/credits.html">Credits</a>
</p>


<h3>About the <cfoutput>#request.library.name#</cfoutput></h3>

 <cfif request.library.id is "none">
 <p class="bodyText">You are using the Digital Library System.</p>
 <cfelse>
 <p class="bodyText">You are using the <cfoutput>#request.library.name#</cfoutput>,
 part of, and powered by the	<strong>Digital Library System</strong>.
 </cfif>

<h3>Copyright</h3>
    TODO: add copyright information

<p>&nbsp;</p>
