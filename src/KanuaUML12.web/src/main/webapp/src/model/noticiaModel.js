/* ========================================================================
 * Copyright 2014 astroDevelopers
 *
 * Licensed under the MIT, The MIT License (MIT)
 * Copyright (c) 2014 astroDevelopers

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 * ========================================================================


Source generated by CrudMaker version 1.0.0.201408112050

*/
define(['model/_noticiaModel'], function() {
    App.Model.NoticiaModel = App.Model._NoticiaModel.extend({

 	validate: function(attrs,options){
             var nom=attrs.imagen.toString();
             var url= nom.search("http:");
            var validationMessage = "";
            if(!attrs.name){
                validationMessage = "El nombre no puede ser vacio. ";
            }  
            if (0>nom.indexOf("http:")||!attrs.imagen)
            {
                validationMessage+="Imagen no valida o vacio. ";
                
            }
            if( !attrs.titulo)
            {
                validationMessage+="Titulo no puede ser vacio. ";
                
            }
            if(!attrs.fecha)
            {
                validationMessage+= "Fecha no definida. ";
                
            }
            if (!attrs.descripcion)
            {
                validationMessage+= "Descripcion no puede ser vacia. ";
            }
            if (!attrs.tema)
            {
                validationMessage+= "El tema no puede ser vacio. ";
            }
            if(validationMessage.length>0){
               return validationMessage;
            }
        }

    });

    App.Model.NoticiaList = App.Model._NoticiaList.extend({
        model: App.Model.NoticiaModel
    });

    return  App.Model.NoticiaModel;

});