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


Source generated by CrudMaker version 1.0.0.201410261249

*/

package co.edu.uniandes.csw.astroDevelopers.tag.logic.ejb;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.*;


import co.edu.uniandes.csw.astroDevelopers.tag.logic.dto.TagDTO;
import co.edu.uniandes.csw.astroDevelopers.tag.logic.api.ITagLogicService;
import co.edu.uniandes.csw.astroDevelopers.tag.persistence.TagPersistence;
import co.edu.uniandes.csw.astroDevelopers.tag.persistence.api.ITagPersistence;
import co.edu.uniandes.csw.astroDevelopers.tag.persistence.entity.TagEntity;
import co.edu.uniandes.csw.astroDevelopers.tag.persistence.converter.TagConverter;
import static co.edu.uniandes.csw.astroDevelopers.util._TestUtil.*;

@RunWith(Arquillian.class)
public class TagLogicServiceTest {

	public static final String DEPLOY = "Prueba";

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
				.addPackage(TagLogicService.class.getPackage())
				.addPackage(ITagLogicService.class.getPackage())
				.addPackage(TagPersistence.class.getPackage())
				.addPackage(TagEntity.class.getPackage())
				.addPackage(ITagPersistence.class.getPackage())
                .addPackage(TagDTO.class.getPackage())
                .addPackage(TagConverter.class.getPackage())
                .addPackage(TagEntity.class.getPackage())
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
	}

	@Inject
	private ITagLogicService tagLogicService;
	
	@Inject
	private ITagPersistence tagPersistence;	

	@Before
	public void configTest() {
		try {
			clearData();
			insertData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void clearData() {
		List<TagDTO> dtos=tagPersistence.getTags();
		for(TagDTO dto:dtos){
			tagPersistence.deleteTag(dto.getId());
		}
	}

	private List<TagDTO> data=new ArrayList<TagDTO>();

	private void insertData() {
		for(int i=0;i<3;i++){
			TagDTO pdto=new TagDTO();
			pdto.setName(generateRandom(String.class));
			pdto=tagPersistence.createTag(pdto);
			data.add(pdto);
		}
	}
	
	@Test
	public void createTagTest(){
		TagDTO ldto=new TagDTO();
		ldto.setName(generateRandom(String.class));
		
		
		TagDTO result=tagLogicService.createTag(ldto);
		
		Assert.assertNotNull(result);
		
		TagDTO pdto=tagPersistence.getTag(result.getId());
		
		Assert.assertEquals(ldto.getName(), pdto.getName());	
	}
	
	@Test
	public void getTagsTest(){
		List<TagDTO> list=tagLogicService.getTags();
		Assert.assertEquals(list.size(), data.size());
        for(TagDTO ldto:list){
        	boolean found=false;
            for(TagDTO pdto:data){
            	if(ldto.getId()==pdto.getId()){
                	found=true;
                }
            }
            Assert.assertTrue(found);
        }
	}
	
	@Test
	public void getTagTest(){
		TagDTO pdto=data.get(0);
		TagDTO ldto=tagLogicService.getTag(pdto.getId());
        Assert.assertNotNull(ldto);
		Assert.assertEquals(pdto.getName(), ldto.getName());
        
	}
	
	@Test
	public void deleteTagTest(){
		TagDTO pdto=data.get(0);
		tagLogicService.deleteTag(pdto.getId());
        TagDTO deleted=tagPersistence.getTag(pdto.getId());
        Assert.assertNull(deleted);
	}
	
	@Test
	public void updateTagTest(){
		TagDTO pdto=data.get(0);
		
		TagDTO ldto=new TagDTO();
		ldto.setId(pdto.getId());
		ldto.setName(generateRandom(String.class));
		
		
		tagLogicService.updateTag(ldto);
		
		
		TagDTO resp=tagPersistence.getTag(pdto.getId());
		
		Assert.assertEquals(ldto.getName(), resp.getName());	
	}
	
	
	
	
}