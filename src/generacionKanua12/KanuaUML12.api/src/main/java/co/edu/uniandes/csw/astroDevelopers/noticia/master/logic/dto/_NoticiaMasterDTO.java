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

package co.edu.uniandes.csw.astroDevelopers.noticia.master.logic.dto;

import co.edu.uniandes.csw.astroDevelopers.tag.logic.dto.TagDTO;
import co.edu.uniandes.csw.astroDevelopers.noticia.logic.dto.NoticiaDTO;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public abstract class _NoticiaMasterDTO {

 
    protected NoticiaDTO noticiaEntity;
    protected Long id;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public NoticiaDTO getNoticiaEntity() {
        return noticiaEntity;
    }

    public void setNoticiaEntity(NoticiaDTO noticiaEntity) {
        this.noticiaEntity = noticiaEntity;
    }
    
    public List<TagDTO> createtag_noticia;
    public List<TagDTO> updatetag_noticia;
    public List<TagDTO> deletetag_noticia;
    public List<TagDTO> listtag_noticia;	
	
	
	
    public List<TagDTO> getCreatetag_noticia(){ return createtag_noticia; };
    public void setCreatetag_noticia(List<TagDTO> createtag_noticia){ this.createtag_noticia=createtag_noticia; };
    public List<TagDTO> getUpdatetag_noticia(){ return updatetag_noticia; };
    public void setUpdatetag_noticia(List<TagDTO> updatetag_noticia){ this.updatetag_noticia=updatetag_noticia; };
    public List<TagDTO> getDeletetag_noticia(){ return deletetag_noticia; };
    public void setDeletetag_noticia(List<TagDTO> deletetag_noticia){ this.deletetag_noticia=deletetag_noticia; };
    public List<TagDTO> getListtag_noticia(){ return listtag_noticia; };
    public void setListtag_noticia(List<TagDTO> listtag_noticia){ this.listtag_noticia=listtag_noticia; };	
	
	
}

