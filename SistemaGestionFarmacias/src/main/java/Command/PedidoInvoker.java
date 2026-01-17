/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

/**
 *
 * @author sete
 */
public class PedidoInvoker {
    
    private Command ultimo;

    /**
     * Ejecuta el comando indicado y lo almacena como el último comando ejecutado.
     *
     * @param comando Comando a ejecutar.
     */
    public void ejecutar(Command comando) {
        this.ultimo = comando;
        comando.execute();
    }

    /**
     * Deshace el último comando ejecutado, si existe.
     * 
     * Si no hay ningún comando almacenado, simplemente informa de que no hay
     * ninguna operación que deshacer.
     * 
     */
    public void deshacerUltimo() {
        if (ultimo != null) {
            ultimo.cancel();
            ultimo = null;
        } else {
            System.out.println("⚠️ No hay comando para deshacer.");
        }
    }
}
