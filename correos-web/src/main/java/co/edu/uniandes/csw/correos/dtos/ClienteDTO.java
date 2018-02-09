/*
MIT License

Copyright (c) 2017 ISIS2603

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package co.edu.uniandes.csw.correos.dtos;

// import co.edu.uniandes.csw.correos.entities.ClienteEntity;

/**
 * ClienteDTO Objeto de transferencia de datos de cliente. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "idCliente": number,
 *      "nombre: string
 *   
 *   }
 * </pre>
 * Por ejemplo una ciudad se representa asi:<br>
 * 
 * <pre>
 * 
 *   {
 *      "id": 91852,
 *      "name: "Pepito Perez"
 *     
 *   }
 *
 * </pre>
 * @author da.leon
 */
public class ClienteDTO
{

    private Long idCliente;
    private String nombre;

    /**
     * Constructor por defecto
     */
    public ClienteDTO
        () {
    }

    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param cliente: Es la entidad que se va a convertir a DTO
     */
   // public ClienteDTO se hace con la persistencia 
   
    

    /**
     * @return El ID del usuario 
     */
    public Long getId() {
        return idCliente;
    }

    /**
     * @param id El nuevo ID
     */
    public void setId(Long id) {
        this.idCliente = id;
    }

    /**
     * @return El nombre del usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param name El nuevo nombre del cliente 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   

    /**
     * Convertir DTO a Entity se hace con la persistencia 
     *
**/  
}
