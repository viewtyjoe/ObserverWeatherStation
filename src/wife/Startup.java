/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wife;

/**
 *
 * @author Instlogin
 */
public class Startup {
    public static void main(String[] args) {
        Wife wife = new Wife();
        
        wife.addSubscriber(new Son());
        wife.addSubscriber(new Husband());
        wife.addSubscriber(new Daughter());
        
        wife.takeOutGarbage();
    }
}
