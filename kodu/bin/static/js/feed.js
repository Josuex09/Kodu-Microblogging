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
    
    // show/hide comments
    $(".comment-ref").on("click",function(){
    	if($(this).parent().closest("div").parent().closest("div").find(".comment-list").hasClass("comments-closed")){
    		$(this).parent().closest("div").parent().closest("div").find(".comment-list").removeClass("comments-closed");
    		$(this).parent().closest("div").parent().closest("div").find(".comment-list").addClass("comments-opened");
    	}
    	else{
    		$(this).parent().closest("div").parent().closest("div").find(".comment-list").removeClass("comments-opened");
    		$(this).parent().closest("div").parent().closest("div").find(".comment-list").addClass("comments-closed	");
    	}
    });
    
    $(".shared-count").on("click",function (){
    	$(this).parent().closest("div").find(".shared-users").modal("show");
    });
    
    $(".share-post").on("click",function (){
        $(this).parent().closest("div").find(".share-form").modal("show");
    
    
    });
    
    
});