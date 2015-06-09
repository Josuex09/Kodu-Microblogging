    $(function() {
        $("#medallaUno").tooltip();
    });
    $(function() {
        $("#medallaDos").tooltip();
      });

    $(function() {
        $("#medallaTres").tooltip();
      });

$(document).ready(function(){
    $("#ver-incompleto").hide();
    $(".ver-completo").click(function(){
        if($("#lineas-codigo").hasClass("cerrado")){
            $("#lineas-codigo").removeClass("cerrado");
            $("#lineas-codigo").addClass("abierto");
            $("#ver-completo").hide();
            $("#ver-incompleto").show();
        }
        else{
             $("#lineas-codigo").removeClass("abierto");
             $("#lineas-codigo").addClass("cerrado");
             $("#ver-completo").show();
             $("#ver-incompleto").hide();
        }
        
        
    });
    
        $(".comentario-oculto").hide();
    $("#comentarios").click(function(){
        if($("#comentarios-usuarios").hasClass("inactiva")){
            $(".comentario-oculto").show("slow");
            $("#comentarios-usuarios").removeClass("inactiva");
            $("#comentarios-usuarios").addClass("activa");
        return false;
        }
        
        if($("#comentarios-usuarios").hasClass("activa")){
            $(".comentario-oculto").hide("slow");
            $("#comentarios-usuarios").removeClass("activa");
            $("#comentarios-usuarios").addClass("inactiva");
        return false;
        }
        
    });
    
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
    
    $("#boton-publicar").click(function(){
       // $("#todas-publicaciones").hide('scale',{ percent: 0 },200);
        $.when($('#todas-publicaciones').fadeOut("slow"))
                               .done(function() {
            var descripcion= $("#descripcion").val();
            var codigo= $("#codigo").val();
            var pub= $("#todas-publicaciones").html();
            var nueva_pub_info_usuario = "<div id=post class=row><div id=pub class=col-md-2><div id=info-publicacion><img id=usuarioPublica class=img-responsive alt=Responsive image src=imagenes/images.jpg><div><a href=perfilAlguien.html id=nombre-usuario> @Johana</a></div></div></div><div class=col-md-10><div id=publicacion  class='panel panel-default'><div id='publicacion-descripcion' class='panel-heading'><pre>"+descripcion+"</pre></div><div id='publicacion-codigo' class='panel-body'><pre class='prettyprint linenums cerrado'>'"+codigo+"</pre></div></div><div  id=comentarios-compartir><div id=veces-compartida><img id=veces-compartida-icono src=imagenes/retweet.png  class='img-responsive' alt='Responsive image' ><a id=veces-compartida-texto href='#' > 0<label data-localize='vecesCompartido'></label></a></div><div id=comentarios><img id=comentarios-icono src='imagenes/iconoComentario.png'  class='img-responsive' alt='Responsive image'><a id=ver-comentarios href='#' data-localize='Comentarios'></a></div></div><div id='comentarios-usuarios'><div id=comentar><input id=contenido-comentario data-localize='Comentar'> </input><button id=enviar-comentario class='btn btn-default' data-localize='Enviar'></button> </div></div></div></div>";
            $("#todas-publicaciones").html(nueva_pub_info_usuario+pub);
            $("[data-localize]").localize("leng",{ language: "es", pathPrefix: "/Idiomas"});
            prettyPrint();
            $("#todas-publicaciones").fadeIn("slow");
            
        });
        //$("#todas-publicaciones").show("scale",200);
    });
        $("#enviar-comentario").click(function(){
            var comentario= $("#contenido-comentario").val();
            var comentarios_anteriores = $("#comentarios-usuarios").html();
            var nuevo_comentario = comentarios_anteriores+"<div id='comentario-usuario'><div id='imagen-usuario'><img class='img-responsive img-peq' alt='Responsive image' src='imagenes/images.jpg'><a href=''>@Johana</a></div><input type='text' class='form-control' id='nombreUsuario'    value='"+comentario+"' readonly></div>";
            $("#comentarios-usuarios").html(nuevo_comentario);
    });
    
    
    prettyPrint();
    $("#codigo").linedtextarea();
    

});