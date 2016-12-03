package com.endurance.dealsndealers.smb;

import java.util.List;

/**
 * Created by chaitanya.m on 12/2/16.
 */
public interface ISmbInformationDao
{
    public List<SmbInformation> getSmbs();

    public SmbInformation getSmbInformationById(int id);

    public void insertSmbInformation(SmbInformation smbInformation);

    public void updateSmbInformation(SmbInformation smbInformation);

    public void deleteSmbInformation(SmbInformation smbInformation);

}
