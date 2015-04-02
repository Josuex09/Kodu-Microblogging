$(document).ready(function(){
    $("#camposIniciarSesion").hide();
    $("#iniciar").css("background-color","#e0e1e1");
    
    
    $("#iniciar").click(function(){
        $(this).css("background-color","#f4f7f8");
        $("#registrarse").css("background-color","#e0e1e1");
        $("#camposIniciarSesion").show();
        $("#camposRegistrarse").hide();
    });
    
    $("#registrarse").click(function(){
        $(this).css("background-color","#f4f7f8");
        $("#iniciar").css("background-color","#e0e1e1");
        $("#camposIniciarSesion").hide();
        $("#camposRegistrarse").show();
    });
    
    
    
})