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

    public void ejecutar(Command comando) {
        this.ultimo = comando;
        comando.execute();
    }

    public void deshacerUltimo() {
        if (ultimo != null) {
            ultimo.cancel();
            ultimo = null;
        } else {
            System.out.println("⚠️ No hay comando para deshacer.");
        }
    }
}
