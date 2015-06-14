$(document).ready(function(){
    $("#datos-registro").hide();
    $("#registrarse").css("background-color","#E9E9E9");
    $("#iniciar").css("background-color","#fff");
    
    
    $("#iniciar").click(function(){
        $("#iniciar").css("background-color","#fff");
        $("#registrarse").css("background-color","#E9E9E9");
        $("#datos-iniciar").show();
        $("#datos-registro").hide();
    });
    
    $("#registrarse").click(function(){
        $(this).css("background-color","#fff");
        $("#iniciar").css("background-color","#E9E9E9");
        $("#datos-iniciar").hide();
        $("#datos-registro").show();
    });
  
})