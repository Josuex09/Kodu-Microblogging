$(document).ready(function(){
    $("#datos-iniciar").hide();
    $("#registrarse").css("background-color","#e0e1e1");
    $("#iniciar").css("background-color","#fff");
    
    
    $("#iniciar").click(function(){
        $("#iniciar").css("background-color","#e0e1e1");
        $("#registrarse").css("background-color","#fff");
        $("#datos-iniciar").show();
        $("#datos-registro").hide();
    });
    
    $("#registrarse").click(function(){
        $(this).css("background-color","#e0e1e1");
        $("#iniciar").css("background-color","#fff");
        $("#datos-iniciar").hide();
        $("#datos-registro").show();
    });
    
    
    
})