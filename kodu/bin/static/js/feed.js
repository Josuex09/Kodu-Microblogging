$(document).ready(function(){
	//DELETE ALL SHOWS IN LITTLE SNIPPET
	$("pre").each(function(index){
		if($(this).height()<120){
			$(this).parent().parent().find(".show-hide").text("");
		}
	});
	
    $(".show-hide").on("click",function(){
        if($(this).parent().closest("div").parent().closest("div").find("pre").hasClass("opened")){
            $(this).parent().closest("div").parent().closest("div").find("pre").removeClass("opened");
            $(this).parent().closest("div").parent().closest("div").find("pre").addClass("closed");
            $(this).text("Show");
            
        }
        else{
            $(this).parent().closest("div").parent().closest("div").find("pre").removeClass("closed");
            $(this).parent().closest("div").parent().closest("div").find("pre").addClass("opened");
            $(this).text("Hide");
        }
    });
});