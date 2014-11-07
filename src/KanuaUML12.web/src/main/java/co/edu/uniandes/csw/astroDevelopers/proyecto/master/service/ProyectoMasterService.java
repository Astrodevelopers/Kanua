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

package co.edu.uniandes.csw.astroDevelopers.proyecto.master.service;

import co.edu.uniandes.csw.astroDevelopers.proyecto.master.logic.dto.ProyectoMasterDTO;
import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/ProyectoMaster")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProyectoMasterService extends _ProyectoMasterService {


    @GET
    @Path("/buscarProyectosPorTag")
    public String buscarProyectosPorTag(@QueryParam("tag") String tag) {
        return proyectoLogicService.buscarProyectosPorTag(tag);        
    }
    
    @GET
    @Path("/realizarSolicitud")
    public boolean realizarSolicitud(@QueryParam("name") String name, @QueryParam("lname") String lname,
            @QueryParam("email") String email, @QueryParam("link") String link, @QueryParam("rol") String rol, 
            @QueryParam("comment") String comment, @QueryParam("id") String id) {
        return true;
        
        
        //return proyectoLogicService.realizarSolicitud(name, lname, email, link, rol, comment, id);        
    }
    
}
