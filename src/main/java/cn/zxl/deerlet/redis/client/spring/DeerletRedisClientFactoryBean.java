/**
 * 
 */
package cn.zxl.deerlet.redis.client.spring;

import org.springframework.beans.factory.FactoryBean;

import cn.zxl.deerlet.redis.client.DeerletRedisClient;
import cn.zxl.deerlet.redis.client.DeerletRedisClientImpl;
import cn.zxl.deerlet.redis.client.config.ConfigurationFactory;
import cn.zxl.deerlet.redis.client.connection.impl.ConnectionFactoryImpl;

/**
 * 支持与spring的无缝集成
 * @author zuoxiaolong
 * @since 2015 2015年3月6日 下午11:43:51
 *
 */
public class DeerletRedisClientFactoryBean implements FactoryBean<DeerletRedisClient> {
	
	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.FactoryBean#getObject()
	 */
	@Override
	public DeerletRedisClient getObject() throws Exception {
		return new DeerletRedisClientImpl(new ConnectionFactoryImpl(ConfigurationFactory.create().loadConfiguration()));
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.FactoryBean#getObjectType()
	 */
	@Override
	public Class<? extends DeerletRedisClient> getObjectType() {
		return DeerletRedisClient.class;
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.FactoryBean#isSingleton()
	 */
	@Override
	public boolean isSingleton() {
		return true;
	}

}
