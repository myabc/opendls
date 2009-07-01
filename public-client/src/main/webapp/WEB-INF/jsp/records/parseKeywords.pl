#!/usr/bin/perl -w

$currentLetter = "-";
$newLetter = "-";
$searchURL = "default\.cfm\?fuseaction\=records\.searchresults&sb\=";



print("<h1>browse keywords</h1>\n");


print("<a href=\"\#a\">A |</a>"); 
print("<a href=\"\#b\"> B |</a>");
print("<a href=\"\#c\"> C |</a>");
print("<a href=\"\#d\"> D |</a>");   
print("<a href=\"\#e\"> E |</a>");
print("<a href=\"\#f\"> F |</a>");  
print("<a href=\"\#g\"> G |</a>");
print("<a href=\"\#h\"> H |</a>"); 
print("<a href=\"\#i\"> I |</a>");  
print("<a href=\"\#j\"> J |</a>"); 
print("<a href=\"\#k\"> K |</a>");
print("<a href=\"\#l\"> L |</a>");  
print("<a href=\"\#m\"> M |</a>"); 
print("<a href=\"\#n\"> N |</a>"); 
print("<a href=\"\#o\"> O |</a>"); 
print("<a href=\"\#p\"> P |</a>");
print("<a href=\"\#q\"> Q |</a>");
print("<a href=\"\#r\"> R |</a>"); 
print("<a href=\"\#s\"> S |</a>");
print("<a href=\"\#t\"> T |</a>");   
print("<a href=\"\#u\"> U |</a>");
print("<a href=\"\#v\"> V |</a>"); 
print("<a href=\"\#w\"> W |</a>"); 
print("<a href=\"\#x\"> X |</a>"); 
print("<a href=\"\#Y\"> Y |</a>"); 
print("<a href=\"\#Z\"> Z </a><br/>"); 

open(KWF,"keywords.txt");

	#loop through each line in the file
	while(<KWF>){
		
		#figure out if we are on a new letter
		$newLetter = substr($_,0,1);
		
		if($newLetter ne $currentLetter){
			#print an anchor tag here with the newLetter
			print("<br/><a href=\"\#\" name=\"$newLetter\">$newLetter</a>\n<br/>");
			$currentLetter = $newLetter;
			
		}
		
		
		if(!/see/&!/use for/){
			#Just print out link here word is plain jane
			$_ = trim($_);
			print("<li>");
			print("<a href=\"$searchURL$_\">$_</a><br/>");
			print("</li>");
		}
		
		if(/see/&!/also/){
			
			
			
			#split up line on the "see"
			@stringArray3 = split(/see /);
			#split up on ";"
			@stringArray4 = split(/\;/,$stringArray3[1]);
			#find the index of see
			$seeIndex = index($_,"see");
			$seeIndex = $seeIndex + 3;
			# get the term plus the word "see "
			$term = substr($_,0,$seeIndex);
			print("<li>");
			#print term without link
			print("$term ");
				#make the "see terms" links 
				foreach $j (@stringArray4){
					$j = trim($j);
					print("<a href=\"$searchURL$j\">$j</a>\;");
				}
			print("\n<br/>");
			print("</li>");

		}

		if(/see also/){
			#print $_;
			# make each see also term a link
			# delimit with ;
			@stringArray1 = split(/see also/);
			@stringArray2 = split(/\;/,$stringArray1[1]);
			$seeAlsoIndex = index($_,"see also");
			$seeAlsoIndex = $seeAlsoIndex + 8;
			$term = trim(substr($_,0,$seeAlsoIndex -8));
			print("<li>");
			print ("<a href=\"$searchURL$term\">$term</a> see also ");
				foreach $i (@stringArray2) {
					$i = trim($i);
					print ("<a href=\"$searchURL$i\">$i</a>\; ");
				}
			print("\n<br/>");
			print("</li>");
	
		}

		if(/use for/){
			#make term a link
			#print out use for in plain text
			#make the "see term" a link
			$useforIndex = index($_,"use for");
			$useforIndex = $useforIndex + 7;
			$useforTerm = substr($_,$useforIndex,1000);
			$useforTerm = trim($useforTerm);
			$term = substr($_,0,$useforIndex);
			print("<li>");
			print("<a href=\"$searchURL$term\">$term</a> $useforTerm\n<br/>");
			print("</li>");	
		}


	}

close(KWF);


sub trim {
   my($string)=@_;
   for ($string) {
       s/^\s+//;
       s/\s+$//;
   }
   return $string;
}




