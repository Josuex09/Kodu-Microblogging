$(document).ready(function(){
    $("#change-password").hide();
    $("#delete-profile").hide();
    $("#edit-information").css("background-color","#A6570C");
    $("#password-information").css("background-color","#f58214");
    $("#delete-account").css("background-color","#f58214");
    
    $("#edit-information").click(function(){
        $("#edit-information").css("background-color","#A6570C");
        $("#password-information").css("background-color","#f58214");
        $("#delete-account").css("background-color","#f58214");
        $("#full-information").show();
        $("#change-password").hide();
        $("#delete-profile").hide();
    });
    
    
    
    $("#password-information").click(function(){
        $("#password-information").css("background-color","#A6570C");
        $("#edit-information").css("background-color","#f58214");
        $("#delete-account").css("background-color","#f58214");
        $("#change-password").show();
        $("#full-information").hide();
        $("#delete-profile").hide();
    });
    
    
    
    $("#delete-account").click(function(){
        $("#delete-account").css("background-color","#A6570C");
        $("#password-information").css("background-color","#f58214");
        $("#edit-information").css("background-color","#f58214");
        $("#delete-profile").show();
        $("#change-password").hide();
        $("#full-information").hide();
    });
    
});