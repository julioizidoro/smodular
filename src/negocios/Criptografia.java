/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocios;

import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Acer
 */
public interface Criptografia{

    String encrypt(String value) throws NoSuchAlgorithmException;

}
