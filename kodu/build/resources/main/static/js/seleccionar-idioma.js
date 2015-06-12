$(document).ready(function(){
	$("[data-localize]").localize("leng",{ language: "es", pathPrefix: "../../Idiomas"});
	
	
    $("#seleccionar-idioma").change(function(){
        var idioma = $(this).val();
        if(idioma== "Español"){
            $("[data-localize]").localize("leng",{ language: "es", pathPrefix: "../../Idiomas"});
        }
        else if(idioma=="Ingles"){
            $("[data-localize]").localize("leng",{ language: "en", pathPrefix: "../../Idiomas"});
        }
        else if(idioma=="Portugues"){
            $("[data-localize]").localize("leng",{ language: "pr", pathPrefix: "../../Idiomas"});
        }
    
        
    });
});