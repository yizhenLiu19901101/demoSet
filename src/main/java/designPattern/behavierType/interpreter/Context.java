package designPattern.behavierType.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * 环境角色
 * @author liuyizhen
 *
 */
public class Context {

    private Map<Variable,Boolean> map = new HashMap<Variable,Boolean>();
    
    public void assign(Variable var , boolean value){
        map.put(var, new Boolean(value));
    }
    
    public boolean lookup(Variable var) throws IllegalArgumentException{
        Boolean value = map.get(var);
        if(value == null){
            throw new IllegalArgumentException();
        }
        return value.booleanValue();
    }
}
