package com.example.plugins.model.impl;

import com.example.plugins.model.Puja;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Puja in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Puja
 * @generated
 */
public class PujaCacheModel implements CacheModel<Puja>, Externalizable {
    public String uuid;
    public long pujaId;
    public long groupId;
    public long companyId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;
    public double valorPuja;
    public long idSubasta;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(21);

        sb.append("{uuid=");
        sb.append(uuid);
        sb.append(", pujaId=");
        sb.append(pujaId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", userName=");
        sb.append(userName);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append(", valorPuja=");
        sb.append(valorPuja);
        sb.append(", idSubasta=");
        sb.append(idSubasta);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Puja toEntityModel() {
        PujaImpl pujaImpl = new PujaImpl();

        if (uuid == null) {
            pujaImpl.setUuid(StringPool.BLANK);
        } else {
            pujaImpl.setUuid(uuid);
        }

        pujaImpl.setPujaId(pujaId);
        pujaImpl.setGroupId(groupId);
        pujaImpl.setCompanyId(companyId);
        pujaImpl.setUserId(userId);

        if (userName == null) {
            pujaImpl.setUserName(StringPool.BLANK);
        } else {
            pujaImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            pujaImpl.setCreateDate(null);
        } else {
            pujaImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            pujaImpl.setModifiedDate(null);
        } else {
            pujaImpl.setModifiedDate(new Date(modifiedDate));
        }

        pujaImpl.setValorPuja(valorPuja);
        pujaImpl.setIdSubasta(idSubasta);

        pujaImpl.resetOriginalValues();

        return pujaImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        uuid = objectInput.readUTF();
        pujaId = objectInput.readLong();
        groupId = objectInput.readLong();
        companyId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        valorPuja = objectInput.readDouble();
        idSubasta = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (uuid == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(uuid);
        }

        objectOutput.writeLong(pujaId);
        objectOutput.writeLong(groupId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(userId);

        if (userName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(userName);
        }

        objectOutput.writeLong(createDate);
        objectOutput.writeLong(modifiedDate);
        objectOutput.writeDouble(valorPuja);
        objectOutput.writeLong(idSubasta);
    }
}
