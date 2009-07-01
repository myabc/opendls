<%-- imagedisplay.jsp --%>

<script language="JavaScript" type="text/javascript">
function resizeToImgSize() {
 var minW,minH,maxW,maxH,newW,newH;
 minW=150;minH=150;maxW=window.screen.width;maxH=window.screen.height;
 var imgW=document.images.displayedImage.width+30;
 var imgH=document.images.displayedImage.height+30;
 newW=(imgW>minW?imgW:minW);
 newH=(imgH>minH?imgH:minH);
 newW=(newW<maxW?newW:maxW);
 newH=(newH<maxH?newH:maxH);
 window.resizeTo(newW,newH);
}
</script>

<img name="displayedImage"
 src="${imageUri}"
 onload="resizeToImgSize()"
 alt="Displayed Image" />
