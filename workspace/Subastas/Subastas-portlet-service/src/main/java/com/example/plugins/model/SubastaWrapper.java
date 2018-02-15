package com.example.plugins.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Subasta}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Subasta
 * @generated
 */
public class SubastaWrapper implements Subasta, ModelWrapper<Subasta> {
    private Subasta _subasta;

    public SubastaWrapper(Subasta subasta) {
        _subasta = subasta;
    }

    @Override
    public Class<?> getModelClass() {
        return Subasta.class;
    }

    @Override
    public String getModelClassName() {
        return Subasta.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("subastaId", getSubastaId());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("nombreProducto", getNombreProducto());
        attributes.put("descripcion", getDescripcion());
        attributes.put("precioMinimo", getPrecioMinimo());
        attributes.put("fechaFin", getFechaFin());
        attributes.put("pujaMaxima", getPujaMaxima());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String uuid = (String) attributes.get("uuid");

        if (uuid != null) {
            setUuid(uuid);
        }

        Long subastaId = (Long) attributes.get("subastaId");

        if (subastaId != null) {
            setSubastaId(subastaId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String userName = (String) attributes.get("userName");

        if (userName != null) {
            setUserName(userName);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        String nombreProducto = (String) attributes.get("nombreProducto");

        if (nombreProducto != null) {
            setNombreProducto(nombreProducto);
        }

        String descripcion = (String) attributes.get("descripcion");

        if (descripcion != null) {
            setDescripcion(descripcion);
        }

        Double precioMinimo = (Double) attributes.get("precioMinimo");

        if (precioMinimo != null) {
            setPrecioMinimo(precioMinimo);
        }

        Date fechaFin = (Date) attributes.get("fechaFin");

        if (fechaFin != null) {
            setFechaFin(fechaFin);
        }

        Long pujaMaxima = (Long) attributes.get("pujaMaxima");

        if (pujaMaxima != null) {
            setPujaMaxima(pujaMaxima);
        }
    }

    /**
    * Returns the primary key of this subasta.
    *
    * @return the primary key of this subasta
    */
    @Override
    public long getPrimaryKey() {
        return _subasta.getPrimaryKey();
    }

    /**
    * Sets the primary key of this subasta.
    *
    * @param primaryKey the primary key of this subasta
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _subasta.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this subasta.
    *
    * @return the uuid of this subasta
    */
    @Override
    public java.lang.String getUuid() {
        return _subasta.getUuid();
    }

    /**
    * Sets the uuid of this subasta.
    *
    * @param uuid the uuid of this subasta
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _subasta.setUuid(uuid);
    }

    /**
    * Returns the subasta ID of this subasta.
    *
    * @return the subasta ID of this subasta
    */
    @Override
    public long getSubastaId() {
        return _subasta.getSubastaId();
    }

    /**
    * Sets the subasta ID of this subasta.
    *
    * @param subastaId the subasta ID of this subasta
    */
    @Override
    public void setSubastaId(long subastaId) {
        _subasta.setSubastaId(subastaId);
    }

    /**
    * Returns the group ID of this subasta.
    *
    * @return the group ID of this subasta
    */
    @Override
    public long getGroupId() {
        return _subasta.getGroupId();
    }

    /**
    * Sets the group ID of this subasta.
    *
    * @param groupId the group ID of this subasta
    */
    @Override
    public void setGroupId(long groupId) {
        _subasta.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this subasta.
    *
    * @return the company ID of this subasta
    */
    @Override
    public long getCompanyId() {
        return _subasta.getCompanyId();
    }

    /**
    * Sets the company ID of this subasta.
    *
    * @param companyId the company ID of this subasta
    */
    @Override
    public void setCompanyId(long companyId) {
        _subasta.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this subasta.
    *
    * @return the user ID of this subasta
    */
    @Override
    public long getUserId() {
        return _subasta.getUserId();
    }

    /**
    * Sets the user ID of this subasta.
    *
    * @param userId the user ID of this subasta
    */
    @Override
    public void setUserId(long userId) {
        _subasta.setUserId(userId);
    }

    /**
    * Returns the user uuid of this subasta.
    *
    * @return the user uuid of this subasta
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _subasta.getUserUuid();
    }

    /**
    * Sets the user uuid of this subasta.
    *
    * @param userUuid the user uuid of this subasta
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _subasta.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this subasta.
    *
    * @return the user name of this subasta
    */
    @Override
    public java.lang.String getUserName() {
        return _subasta.getUserName();
    }

    /**
    * Sets the user name of this subasta.
    *
    * @param userName the user name of this subasta
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _subasta.setUserName(userName);
    }

    /**
    * Returns the create date of this subasta.
    *
    * @return the create date of this subasta
    */
    @Override
    public java.util.Date getCreateDate() {
        return _subasta.getCreateDate();
    }

    /**
    * Sets the create date of this subasta.
    *
    * @param createDate the create date of this subasta
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _subasta.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this subasta.
    *
    * @return the modified date of this subasta
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _subasta.getModifiedDate();
    }

    /**
    * Sets the modified date of this subasta.
    *
    * @param modifiedDate the modified date of this subasta
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _subasta.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the nombre producto of this subasta.
    *
    * @return the nombre producto of this subasta
    */
    @Override
    public java.lang.String getNombreProducto() {
        return _subasta.getNombreProducto();
    }

    /**
    * Sets the nombre producto of this subasta.
    *
    * @param nombreProducto the nombre producto of this subasta
    */
    @Override
    public void setNombreProducto(java.lang.String nombreProducto) {
        _subasta.setNombreProducto(nombreProducto);
    }

    /**
    * Returns the descripcion of this subasta.
    *
    * @return the descripcion of this subasta
    */
    @Override
    public java.lang.String getDescripcion() {
        return _subasta.getDescripcion();
    }

    /**
    * Sets the descripcion of this subasta.
    *
    * @param descripcion the descripcion of this subasta
    */
    @Override
    public void setDescripcion(java.lang.String descripcion) {
        _subasta.setDescripcion(descripcion);
    }

    /**
    * Returns the precio minimo of this subasta.
    *
    * @return the precio minimo of this subasta
    */
    @Override
    public double getPrecioMinimo() {
        return _subasta.getPrecioMinimo();
    }

    /**
    * Sets the precio minimo of this subasta.
    *
    * @param precioMinimo the precio minimo of this subasta
    */
    @Override
    public void setPrecioMinimo(double precioMinimo) {
        _subasta.setPrecioMinimo(precioMinimo);
    }

    /**
    * Returns the fecha fin of this subasta.
    *
    * @return the fecha fin of this subasta
    */
    @Override
    public java.util.Date getFechaFin() {
        return _subasta.getFechaFin();
    }

    /**
    * Sets the fecha fin of this subasta.
    *
    * @param fechaFin the fecha fin of this subasta
    */
    @Override
    public void setFechaFin(java.util.Date fechaFin) {
        _subasta.setFechaFin(fechaFin);
    }

    /**
    * Returns the puja maxima of this subasta.
    *
    * @return the puja maxima of this subasta
    */
    @Override
    public long getPujaMaxima() {
        return _subasta.getPujaMaxima();
    }

    /**
    * Sets the puja maxima of this subasta.
    *
    * @param pujaMaxima the puja maxima of this subasta
    */
    @Override
    public void setPujaMaxima(long pujaMaxima) {
        _subasta.setPujaMaxima(pujaMaxima);
    }

    @Override
    public boolean isNew() {
        return _subasta.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _subasta.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _subasta.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _subasta.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _subasta.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _subasta.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _subasta.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _subasta.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _subasta.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _subasta.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _subasta.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new SubastaWrapper((Subasta) _subasta.clone());
    }

    @Override
    public int compareTo(com.example.plugins.model.Subasta subasta) {
        return _subasta.compareTo(subasta);
    }

    @Override
    public int hashCode() {
        return _subasta.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.example.plugins.model.Subasta> toCacheModel() {
        return _subasta.toCacheModel();
    }

    @Override
    public com.example.plugins.model.Subasta toEscapedModel() {
        return new SubastaWrapper(_subasta.toEscapedModel());
    }

    @Override
    public com.example.plugins.model.Subasta toUnescapedModel() {
        return new SubastaWrapper(_subasta.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _subasta.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _subasta.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _subasta.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof SubastaWrapper)) {
            return false;
        }

        SubastaWrapper subastaWrapper = (SubastaWrapper) obj;

        if (Validator.equals(_subasta, subastaWrapper._subasta)) {
            return true;
        }

        return false;
    }

    @Override
    public StagedModelType getStagedModelType() {
        return _subasta.getStagedModelType();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Subasta getWrappedSubasta() {
        return _subasta;
    }

    @Override
    public Subasta getWrappedModel() {
        return _subasta;
    }

    @Override
    public void resetOriginalValues() {
        _subasta.resetOriginalValues();
    }
}
