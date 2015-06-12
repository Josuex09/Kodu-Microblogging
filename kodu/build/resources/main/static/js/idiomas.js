 $(function){
 	var availableTags = ["Italiano","Español","Portugués","Japonés", "Alemán","Ruso", "Árabe","Francés", "Mandarín", "Inglés"];
	   $( "#idioma" ).autocomplete({
      source: availableTags
    });
  });