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

package co.edu.uniandes.csw.astroDevelopers.equipo.master.persistence.entity;

import java.io.Serializable;

/**
 *
 * @author 
 */
public class Equipousuario_equipoEntityId implements Serializable{

    private Long equipoId;
    private Long usuario_equipoId;

    @Override
    public int hashCode() {
        return (int) (equipoId + usuario_equipoId);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Equipousuario_equipoEntityId) {
            Equipousuario_equipoEntityId otherId = (Equipousuario_equipoEntityId) object;
            return (otherId.equipoId.equals(this.equipoId)) && (otherId.usuario_equipoId.equals(this.usuario_equipoId));
        }
        return false;
    }

}
