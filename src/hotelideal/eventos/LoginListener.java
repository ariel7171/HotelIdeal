
package hotelideal.eventos;

import hotelideal.Entidades.EnumColor;


public interface LoginListener {
    
     void onLoginSuccess(int iduser, String username, EnumColor color);
     
     void onMethodExecution();
    
}
