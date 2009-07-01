<h1>Search Results</h1>


<cfif request.searchFailureReason contains "Syntax Error">

 <h3>Your Search Query could not be completed.</h3>

 <p class="bodyText">Your search criteria contained a Syntax Error. If you
 selected the "BOOLEAN" search option, then it is likely that your
 criteria contained a mal-formed boolean construct.<br />
 Suggestions:
  <ul>
   <li>If you are having troubles forming "BOOLEAN" search queries
   (this option is designed for advanced users), try using the
   "SMART SEARCH" option instead</li>
   <li>Refer to help for more information on constructing "BOOLEAN"
   search queries.</li>
  </ul>
 </p>

<cfelse>

 <%-- Because no records were found --%>
 <h3>No records were found.</h3>

 <p class="bodyText">Suggestions:
  <ul>
   <li>Check the spelling of the words or phrases you entered</li>
   <li>Enter broader search criteria</li>
   <li>Use the quick search to search text in multiple record fields</li>
  </ul>
 </p>

</cfif>
