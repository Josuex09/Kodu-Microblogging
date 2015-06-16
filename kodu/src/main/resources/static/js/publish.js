$(document).ready(function(){    

    //limite de caracteres en la descripcion
    $('#descripcion').keyup(function(e) {
        var largo = $(this).val().length;
        var remain = 199-largo;
        $("#descripcionCant").text(remain);
        if(remain ==0) $("#descripcionCant").html("<label style ='color:red'>"+remain+"</label>");
    });
    
        //--------------------------------------
    //limite de lineas en el codigo
    
    $("#codigo").keyup(function(e){
        
    });
    //--------------------------------------
    
    
});
