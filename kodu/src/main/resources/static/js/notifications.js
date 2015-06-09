$(document).ready(function()
{
    $("#notificationLink").click(function(){

        $("#notificationContainer").fadeToggle(300);
        $("#notification_count").fadeOut("slow");
        return false;
    });

    $("#notificationLink2").click(function(){
        $("#notificationContainer2").fadeToggle(300);
        return false;
    });

    //Document Click
    $(document).click(function(){ 
        $("#notificationContainer").hide();
    });
    
    //Popup Click
        $("#notificationContainer").click(function(){
        return false
    });

    $(document).click(function(){ 
        $("#notificationContainer2").hide();
    });
    //Popup Click
        $("#notificationContainer2").click(function(){
        return false
    });

});