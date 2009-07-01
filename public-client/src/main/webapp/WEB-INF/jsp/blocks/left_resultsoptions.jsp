<%@ taglib tagdir="/WEB-INF/tags" prefix="dls" %>
<%--- Blocks (display components)
*********************************
dsp_left_displayoptions.cfm

Info:
 for use on

--%>


<dls:leftblock title="Display Options">
<form name="displayoptions" onsubmit="document.DLSDR.maxrow.value=document.displayoptions.maxrow.value;document.DLSDR.submit();return false;">
<table>
<tr><td class="leftContent">Records per page</td></tr>
<tr><td>

<dls:selectlist
 fieldName="maxrow"
 styleClass="LeftDrop"
 selectedValue="#attributes.maxrow#"
 displayList="5,10,20,30,40,50,60,80,100"
 valuesList="5,10,20,30,40,50,60,80,100" />

</td></tr>
</table>
<div align="right"><input type="submit" value="Go" class="leftSubmit"></div>
</form>
</dls:leftblock>
