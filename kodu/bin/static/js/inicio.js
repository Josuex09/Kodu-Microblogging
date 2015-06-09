$(document).ready(function(){
    $("#pedir-datos-iniciar").hide();
    $("#registrarse").css("background-color","#fff");
    $("#iniciar").css("background-color","#e0e1e1");
    
    
    $("#iniciar").click(function(){
        $("#iniciar").css("background-color","#fff");
        $("#registrarse").css("background-color","#e0e1e1");
        $("#pedir-datos-iniciar").show();
        $("#pedir-datos-registro").hide();
    });
    
    $("#registrarse").click(function(){
        $(this).css("background-color","#fff");
        $("#iniciar").css("background-color","#e0e1e1");
        $("#pedir-datos-iniciar").hide();
        $("#pedir-datos-registro").show();
    });
    
    
    
})