package com.example.plugins.service.impl;

import java.util.Date;
import java.util.List;

import com.example.plugins.model.Subasta;
import com.example.plugins.service.base.SubastaLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the subasta local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.example.plugins.service.SubastaLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.example.plugins.service.base.SubastaLocalServiceBaseImpl
 * @see com.example.plugins.service.SubastaLocalServiceUtil
 */
public class SubastaLocalServiceImpl extends SubastaLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.example.plugins.service.SubastaLocalServiceUtil} to access the subasta local service.
     */
	
	public List<Subasta> findSubastasActivasHoy(int start, int end) throws SystemException{
		return subastaPersistence.findByfechaFin(new Date(), start, end);
	}
}
