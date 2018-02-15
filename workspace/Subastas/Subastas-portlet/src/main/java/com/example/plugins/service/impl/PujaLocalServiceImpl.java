package com.example.plugins.service.impl;

import com.example.plugins.NoSuchPujaException;
import com.example.plugins.NoSuchSubastaException;
import com.example.plugins.model.Puja;
import com.example.plugins.model.Subasta;
import com.example.plugins.service.base.PujaLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the puja local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.example.plugins.service.PujaLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.example.plugins.service.base.PujaLocalServiceBaseImpl
 * @see com.example.plugins.service.PujaLocalServiceUtil
 */
public class PujaLocalServiceImpl extends PujaLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.example.plugins.service.PujaLocalServiceUtil} to access the puja local service.
     */
	public void pujar(Puja puja) throws NoSuchSubastaException, SystemException, NoSuchPujaException{
		
		Subasta subasta = subastaPersistence.findByPrimaryKey(puja.getIdSubasta());
		
		Puja pujaMaxima = pujaPersistence.findByPrimaryKey(subasta.getPujaMaxima());
		
		if(puja.getValorPuja() > pujaMaxima.getValorPuja()){
			subasta.setPujaMaxima(puja.getPujaId());
			
			subastaPersistence.update(subasta);
			
			pujaPersistence.update(puja);
		}		
	}
}
