$(document).ready(function(){
    $("#list-followers").hide(); 
    $("#list-follows").hide();
//    $("#list-medals").hide();
    
    
    $("#option-follows").click(function(){
        $("#list-follows").show();
        $("#list-followers").hide();
        $("#list-posts").hide();
//        $("#list-medals").hide();
    });
    
    $("#option-followers").click(function(){
    	$("#list-followers").show();
    	$("#list-follows").hide();
        $("#list-posts").hide();
//        $("#list-medals").hide();
    });
    
    $("#option-posts").click(function(){
    	$("#list-posts").show();
    	$("#list-follows").hide();
        $("#list-followers").hide();
//        $("#list-medals").hide();
   });
//    
//    $("#option-medals").click(function(){
//    	$("#list-medals").show();
//    	$("#list-follows").hide();
//        $("#list-followers").hide();
//        $("#list-posts").hide();
//    });
    
    
})