package com.sx.weixin.dto; 
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
 
public abstract class BaseDto<ModelT > implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2748910607374187527L;
	protected static    Log log = LogFactory.getLog(BaseDto.class); 
	protected Class<ModelT> modelClazz; 
 
	@SuppressWarnings("unchecked")
	public BaseDto() {  
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();  
        modelClazz = (Class<ModelT>) type.getActualTypeArguments()[0];   
		log = LogFactory.getLog(this.getClass().getSimpleName());
        
    }

	 
	public void buildDto(ModelT modelT) {
		// TODO Auto-generated method stub
		
	}
 
	public ModelT vertModel() {
		// TODO Auto-generated method stub
		return null;
	}
	 
	
	
	 
	
}