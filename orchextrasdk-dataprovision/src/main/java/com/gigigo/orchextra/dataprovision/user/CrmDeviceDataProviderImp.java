package com.gigigo.orchextra.dataprovision.user;

import com.gigigo.gggjavalib.business.model.BusinessObject;
import com.gigigo.orchextra.dataprovision.config.datasource.TriggersConfigurationDBDataSource;
import com.gigigo.orchextra.domain.dataprovider.CrmDeviceDataProvider;

import java.util.List;

public class CrmDeviceDataProviderImp implements CrmDeviceDataProvider {

    private final TriggersConfigurationDBDataSource triggersConfigurationDBDataSource;

    public CrmDeviceDataProviderImp(TriggersConfigurationDBDataSource triggersConfigurationDBDataSource) {
        this.triggersConfigurationDBDataSource = triggersConfigurationDBDataSource;
    }

    @Override
    public BusinessObject<List<String>> retrieveCrmDeviceTags() {
        return triggersConfigurationDBDataSource.retrieveCrmDeviceTags();
    }

    @Override
    public void saveCrmDeviceUserTags(List<String> deviceTags) {
        triggersConfigurationDBDataSource.saveCrmDeviceUserTags(deviceTags);
    }

    @Override
    public BusinessObject<List<String>> retrieveCrmDeviceBusinessUnits() {
        return triggersConfigurationDBDataSource.retrieveCrmDeviceBusinessUnits();
    }

    @Override
    public void saveCrmDeviceBusinessUnits(List<String> deviceBusinessUnits) {
        triggersConfigurationDBDataSource.saveCrmDeviceBusinessUnits(deviceBusinessUnits);
    }
}
