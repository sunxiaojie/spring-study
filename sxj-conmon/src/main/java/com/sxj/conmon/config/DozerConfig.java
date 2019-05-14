//package com.sxj.conmon.config;
//
//import javax.annotation.Resource;
//
//import org.dozer.Mapper;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import lombok.AllArgsConstructor;
//import lombok.Setter;
///**
// * @author SXJ
// * @Date 2017年8月23日
// */
//@AllArgsConstructor
//@Configuration
//public class DozerConfig {
//
//	@Resource(name="dozerBeanMapperFactory")
//	private Mapper mapper;
//
//	@Bean(name="dozerSysMapper")
//    public DozerFactory getDozerFactory() throws Exception {
//    	DozerFactory factory = new DozerFactory();
//    	factory.setMapper(mapper);
//    	return factory;
//    }
//
//    public class DozerFactory {
//
//    	@Setter
//    	private Mapper mapper;
//
//    	/**
//    	 * 支持映射源对象检测的mapper
//    	 */
//    	private Mapper nullSafeMapper = null;
//
//    	/**
//    	 * 返回可以接收null对象的map
//    	 * @return
//    	 */
//    	public Mapper getMapper(){
//    		if(nullSafeMapper==null){
//    			synchronized (this) {
//    				if(nullSafeMapper == null){
//    					nullSafeMapper=new NullSafeMapper(mapper);
//    				}
//    			}
//    		}
//    		return nullSafeMapper;
//    	}
//    }
//}