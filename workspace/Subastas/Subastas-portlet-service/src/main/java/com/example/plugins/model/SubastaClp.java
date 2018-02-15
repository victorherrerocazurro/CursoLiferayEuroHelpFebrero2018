package com.example.plugins.model;

import com.example.plugins.service.ClpSerializer;
import com.example.plugins.service.SubastaLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class SubastaClp extends BaseModelImpl<Subasta> implements Subasta {
    private String _uuid;
    private long _subastaId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _nombreProducto;
    private String _descripcion;
    private double _precioMinimo;
    private Date _fechaFin;
    private long _pujaMaxima;
    private BaseModel<?> _subastaRemoteModel;
    private Class<?> _clpSerializerClass = com.example.plugins.service.ClpSerializer.class;

    public SubastaClp() {
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
    public long getPrimaryKey() {
        return _subastaId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setSubastaId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _subastaId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public String getUuid() {
        return _uuid;
    }

    @Override
    public void setUuid(String uuid) {
        _uuid = uuid;

        if (_subastaRemoteModel != null) {
            try {
                Class<?> clazz = _subastaRemoteModel.getClass();

                Method method = clazz.getMethod("setUuid", String.class);

                method.invoke(_subastaRemoteModel, uuid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getSubastaId() {
        return _subastaId;
    }

    @Override
    public void setSubastaId(long subastaId) {
        _subastaId = subastaId;

        if (_subastaRemoteModel != null) {
            try {
                Class<?> clazz = _subastaRemoteModel.getClass();

                Method method = clazz.getMethod("setSubastaId", long.class);

                method.invoke(_subastaRemoteModel, subastaId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _groupId = groupId;

        if (_subastaRemoteModel != null) {
            try {
                Class<?> clazz = _subastaRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_subastaRemoteModel, groupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _companyId = companyId;

        if (_subastaRemoteModel != null) {
            try {
                Class<?> clazz = _subastaRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_subastaRemoteModel, companyId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;

        if (_subastaRemoteModel != null) {
            try {
                Class<?> clazz = _subastaRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_subastaRemoteModel, userId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    @Override
    public String getUserName() {
        return _userName;
    }

    @Override
    public void setUserName(String userName) {
        _userName = userName;

        if (_subastaRemoteModel != null) {
            try {
                Class<?> clazz = _subastaRemoteModel.getClass();

                Method method = clazz.getMethod("setUserName", String.class);

                method.invoke(_subastaRemoteModel, userName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;

        if (_subastaRemoteModel != null) {
            try {
                Class<?> clazz = _subastaRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_subastaRemoteModel, createDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getModifiedDate() {
        return _modifiedDate;
    }

    @Override
    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;

        if (_subastaRemoteModel != null) {
            try {
                Class<?> clazz = _subastaRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_subastaRemoteModel, modifiedDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getNombreProducto() {
        return _nombreProducto;
    }

    @Override
    public void setNombreProducto(String nombreProducto) {
        _nombreProducto = nombreProducto;

        if (_subastaRemoteModel != null) {
            try {
                Class<?> clazz = _subastaRemoteModel.getClass();

                Method method = clazz.getMethod("setNombreProducto",
                        String.class);

                method.invoke(_subastaRemoteModel, nombreProducto);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDescripcion() {
        return _descripcion;
    }

    @Override
    public void setDescripcion(String descripcion) {
        _descripcion = descripcion;

        if (_subastaRemoteModel != null) {
            try {
                Class<?> clazz = _subastaRemoteModel.getClass();

                Method method = clazz.getMethod("setDescripcion", String.class);

                method.invoke(_subastaRemoteModel, descripcion);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public double getPrecioMinimo() {
        return _precioMinimo;
    }

    @Override
    public void setPrecioMinimo(double precioMinimo) {
        _precioMinimo = precioMinimo;

        if (_subastaRemoteModel != null) {
            try {
                Class<?> clazz = _subastaRemoteModel.getClass();

                Method method = clazz.getMethod("setPrecioMinimo", double.class);

                method.invoke(_subastaRemoteModel, precioMinimo);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getFechaFin() {
        return _fechaFin;
    }

    @Override
    public void setFechaFin(Date fechaFin) {
        _fechaFin = fechaFin;

        if (_subastaRemoteModel != null) {
            try {
                Class<?> clazz = _subastaRemoteModel.getClass();

                Method method = clazz.getMethod("setFechaFin", Date.class);

                method.invoke(_subastaRemoteModel, fechaFin);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getPujaMaxima() {
        return _pujaMaxima;
    }

    @Override
    public void setPujaMaxima(long pujaMaxima) {
        _pujaMaxima = pujaMaxima;

        if (_subastaRemoteModel != null) {
            try {
                Class<?> clazz = _subastaRemoteModel.getClass();

                Method method = clazz.getMethod("setPujaMaxima", long.class);

                method.invoke(_subastaRemoteModel, pujaMaxima);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public StagedModelType getStagedModelType() {
        return new StagedModelType(PortalUtil.getClassNameId(
                Subasta.class.getName()));
    }

    public BaseModel<?> getSubastaRemoteModel() {
        return _subastaRemoteModel;
    }

    public void setSubastaRemoteModel(BaseModel<?> subastaRemoteModel) {
        _subastaRemoteModel = subastaRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _subastaRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_subastaRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            SubastaLocalServiceUtil.addSubasta(this);
        } else {
            SubastaLocalServiceUtil.updateSubasta(this);
        }
    }

    @Override
    public Subasta toEscapedModel() {
        return (Subasta) ProxyUtil.newProxyInstance(Subasta.class.getClassLoader(),
            new Class[] { Subasta.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        SubastaClp clone = new SubastaClp();

        clone.setUuid(getUuid());
        clone.setSubastaId(getSubastaId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setNombreProducto(getNombreProducto());
        clone.setDescripcion(getDescripcion());
        clone.setPrecioMinimo(getPrecioMinimo());
        clone.setFechaFin(getFechaFin());
        clone.setPujaMaxima(getPujaMaxima());

        return clone;
    }

    @Override
    public int compareTo(Subasta subasta) {
        int value = 0;

        value = getNombreProducto().compareTo(subasta.getNombreProducto());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof SubastaClp)) {
            return false;
        }

        SubastaClp subasta = (SubastaClp) obj;

        long primaryKey = subasta.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(27);

        sb.append("{uuid=");
        sb.append(getUuid());
        sb.append(", subastaId=");
        sb.append(getSubastaId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", userName=");
        sb.append(getUserName());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append(", nombreProducto=");
        sb.append(getNombreProducto());
        sb.append(", descripcion=");
        sb.append(getDescripcion());
        sb.append(", precioMinimo=");
        sb.append(getPrecioMinimo());
        sb.append(", fechaFin=");
        sb.append(getFechaFin());
        sb.append(", pujaMaxima=");
        sb.append(getPujaMaxima());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(43);

        sb.append("<model><model-name>");
        sb.append("com.example.plugins.model.Subasta");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>uuid</column-name><column-value><![CDATA[");
        sb.append(getUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>subastaId</column-name><column-value><![CDATA[");
        sb.append(getSubastaId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userName</column-name><column-value><![CDATA[");
        sb.append(getUserName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
        sb.append(getModifiedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>nombreProducto</column-name><column-value><![CDATA[");
        sb.append(getNombreProducto());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>descripcion</column-name><column-value><![CDATA[");
        sb.append(getDescripcion());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>precioMinimo</column-name><column-value><![CDATA[");
        sb.append(getPrecioMinimo());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>fechaFin</column-name><column-value><![CDATA[");
        sb.append(getFechaFin());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>pujaMaxima</column-name><column-value><![CDATA[");
        sb.append(getPujaMaxima());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
