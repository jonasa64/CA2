/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JsonMessages;

/**
 *
 * @author Oliver
 */
public interface JSONMessage<T> {
    
    public T toInternal();
}
