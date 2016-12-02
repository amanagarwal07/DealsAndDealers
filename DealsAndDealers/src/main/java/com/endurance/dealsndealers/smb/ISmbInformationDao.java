package com.endurance.dealsndealers.smb;

/**
 * Created by chaitanya.m on 12/2/16.
 */
public interface ISmbInformationDao
{
    public SmbInformation getSmbInformationById(int id);

    public void insertSmbInformation(SmbInformation smbInformation);

    public void updateSmbInformation(SmbInformation smbInformation);

    public void deleteSmbInformation(SmbInformation smbInformation);

}
