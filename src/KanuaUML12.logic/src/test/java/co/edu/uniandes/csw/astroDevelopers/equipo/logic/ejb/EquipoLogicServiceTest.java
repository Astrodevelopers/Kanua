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

package co.edu.uniandes.csw.astroDevelopers.equipo.logic.ejb;

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


import co.edu.uniandes.csw.astroDevelopers.equipo.logic.dto.EquipoDTO;
import co.edu.uniandes.csw.astroDevelopers.equipo.logic.api.IEquipoLogicService;
import co.edu.uniandes.csw.astroDevelopers.equipo.persistence.EquipoPersistence;
import co.edu.uniandes.csw.astroDevelopers.equipo.persistence.api.IEquipoPersistence;
import co.edu.uniandes.csw.astroDevelopers.equipo.persistence.entity.EquipoEntity;
import co.edu.uniandes.csw.astroDevelopers.equipo.persistence.converter.EquipoConverter;
import static co.edu.uniandes.csw.astroDevelopers.util._TestUtil.*;

@RunWith(Arquillian.class)
public class EquipoLogicServiceTest {

	public static final String DEPLOY = "Prueba";

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
				.addPackage(EquipoLogicService.class.getPackage())
				.addPackage(IEquipoLogicService.class.getPackage())
				.addPackage(EquipoPersistence.class.getPackage())
				.addPackage(EquipoEntity.class.getPackage())
				.addPackage(IEquipoPersistence.class.getPackage())
                .addPackage(EquipoDTO.class.getPackage())
                .addPackage(EquipoConverter.class.getPackage())
                .addPackage(EquipoEntity.class.getPackage())
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
	}

	@Inject
	private IEquipoLogicService equipoLogicService;
	
	@Inject
	private IEquipoPersistence equipoPersistence;	

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
		List<EquipoDTO> dtos=equipoPersistence.getEquipos();
		for(EquipoDTO dto:dtos){
			equipoPersistence.deleteEquipo(dto.getId());
		}
	}

	private List<EquipoDTO> data=new ArrayList<EquipoDTO>();

	private void insertData() {
		for(int i=0;i<3;i++){
			EquipoDTO pdto=new EquipoDTO();
			pdto.setName(generateRandom(String.class));
			pdto.setEmail(generateRandom(String.class));
			pdto=equipoPersistence.createEquipo(pdto);
			data.add(pdto);
		}
	}
	
	@Test
	public void createEquipoTest(){
		EquipoDTO ldto=new EquipoDTO();
		ldto.setName(generateRandom(String.class));
		ldto.setEmail(generateRandom(String.class));
		
		
		EquipoDTO result=equipoLogicService.createEquipo(ldto);
		
		Assert.assertNotNull(result);
		
		EquipoDTO pdto=equipoPersistence.getEquipo(result.getId());
		
		Assert.assertEquals(ldto.getName(), pdto.getName());	
		Assert.assertEquals(ldto.getEmail(), pdto.getEmail());	
	}
	
	@Test
	public void getEquiposTest(){
		List<EquipoDTO> list=equipoLogicService.getEquipos();
		Assert.assertEquals(list.size(), data.size());
        for(EquipoDTO ldto:list){
        	boolean found=false;
            for(EquipoDTO pdto:data){
            	if(ldto.getId()==pdto.getId()){
                	found=true;
                }
            }
            Assert.assertTrue(found);
        }
	}
	
	@Test
	public void getEquipoTest(){
		EquipoDTO pdto=data.get(0);
		EquipoDTO ldto=equipoLogicService.getEquipo(pdto.getId());
        Assert.assertNotNull(ldto);
		Assert.assertEquals(pdto.getName(), ldto.getName());
		Assert.assertEquals(pdto.getEmail(), ldto.getEmail());
        
	}
	
	@Test
	public void deleteEquipoTest(){
		EquipoDTO pdto=data.get(0);
		equipoLogicService.deleteEquipo(pdto.getId());
        EquipoDTO deleted=equipoPersistence.getEquipo(pdto.getId());
        Assert.assertNull(deleted);
	}
	
	@Test
	public void updateEquipoTest(){
		EquipoDTO pdto=data.get(0);
		
		EquipoDTO ldto=new EquipoDTO();
		ldto.setId(pdto.getId());
		ldto.setName(generateRandom(String.class));
		ldto.setEmail(generateRandom(String.class));
		
		
		equipoLogicService.updateEquipo(ldto);
		
		
		EquipoDTO resp=equipoPersistence.getEquipo(pdto.getId());
		
		Assert.assertEquals(ldto.getName(), resp.getName());	
		Assert.assertEquals(ldto.getEmail(), resp.getEmail());	
	}
	
	
	
	
}