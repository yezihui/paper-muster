package com.pm.common.exception;

/** 
 * <p> 
 *  
 * </p> 
 *
 * @author yejx 
 * @date 2019/12/5 16:50
 */ 
public interface AbstractBaseExceptionEnum {
    
    /** 
     *  
     * @param 
     * @return 
     * @belong  
     * @author yejx 
     * @date 2019/12/5 16:50
     */ 
    Integer getCode();
    
    /** 
     *  
     * @param
     * @return 
     * @belong  
     * @author yejx 
     * @date 2019/12/5 17:07
     */ 
    String getMessage();
}
