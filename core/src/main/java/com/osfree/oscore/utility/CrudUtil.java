package com.osfree.oscore.utility;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.stereotype.Service;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

import static org.springframework.beans.PropertyAccessorFactory.forBeanPropertyAccess;

/**
 * @author JunMinon
 * @author osantos
 */
@Service
public class CrudUtil {

    public static Object cloneAll(Object src, Object dest) {
        return cloneAll(src, dest, new String[] { });
    }

    public static Object cloneAll(Object src, Object dest, String[] skipFields) {
        BeanUtils.copyProperties(src, dest, skipFields );
        return dest;
    }

    public static Object cloneSkipNull(Object src, Object dest) {
        return cloneSkipNull(src, dest, new String[] { });
    }

    public static Object cloneSkipNull(Object src, Object dest, String[] skipFields) {
        String[] ignoredProperties = ArrayUtils.addAll( skipFields, getNullPropertyNames( src ) );     
        BeanUtils.copyProperties(src, dest, ignoredProperties );
        return dest;
    }
    
    /**
     * Helper method to get object props with null values
     */
    private static String[] getNullPropertyNames (Object source) {
            
        BeanWrapper srcWrapper = forBeanPropertyAccess(source);
        PropertyDescriptor[] props = srcWrapper.getPropertyDescriptors();

        Set<String> nullProperties = new HashSet<>();
        
        for(PropertyDescriptor prop : props) {
            if( !srcWrapper.isReadableProperty( prop.getName() ) )
            continue;
            Object srcValue = srcWrapper.getPropertyValue(prop.getName());
            if (srcValue == null) 
                    nullProperties.add(prop.getName());
        }
        
        String[] result = new String[nullProperties.size()];
        return nullProperties.toArray(result);
    }

}
