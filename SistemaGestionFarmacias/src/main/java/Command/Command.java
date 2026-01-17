/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

/**
 *
 * @author sete
 */
public interface Command {
    
    /**
     * Ejecuta la operación encapsulada por el comando.
     */
    void execute();
    
    /**
     * Cancela o deshace la operación realizada por {@link #execute()}, si es posible.
     *
     * En algunas implementaciones puede no hacer nada o no estar soportado.
     * 
     */
    void cancel();
    
}
