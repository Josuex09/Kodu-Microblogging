$(document).ready(function(){
    $("#datos-registro").hide();
    $("#registrarse").css("background-color","#c0c0c0");
    $("#iniciar").css("background-color","#fff");
    
    
    $("#iniciar").click(function(){
        $("#iniciar").css("background-color","#fff");
        $("#registrarse").css("background-color","#c0c0c0");
        $("#datos-iniciar").show();
        $("#datos-registro").hide();
    });
    
    $("#registrarse").click(function(){
        $(this).css("background-color","#fff");
        $("#iniciar").css("background-color","#c0c0c0");
        $("#datos-iniciar").hide();
        $("#datos-registro").show();
    });
    
    
    
})