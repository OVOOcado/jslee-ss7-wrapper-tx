/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.map.telestax.args;

import java.util.Arrays;

import org.mobicents.protocols.ss7.map.api.primitives.IMSI;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtSSInfo;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.InsertSubscriberDataRequest;
import pl.ovoo.ss7.wrapper.common.args.IMSIAddressWrapper;
import pl.ovoo.ss7.wrapper.common.telestax.TxIMSIAddressWrapper;
import pl.ovoo.ss7.wrapper.map.args.InsertSubscriberDataArg_v1Wrapper;
import pl.ovoo.ss7.wrapper.map.args.MAPSS_InformationWrapper;

/**
 * TxInsertSubscriberDataArg_v1Wrapper
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxInsertSubscriberDataArg_v1Wrapper implements InsertSubscriberDataArg_v1Wrapper {

    private transient MAPSS_InformationWrapper[] mapss_InformationWrappers = null;
    private transient IMSIAddressWrapper imsiAddress = null;

    private final InsertSubscriberDataRequest insertSubscriberDataRequest;
    private ExtSSInfo[] extSSInfos;
    private IMSI imsi;

    public TxInsertSubscriberDataArg_v1Wrapper(InsertSubscriberDataRequest insertSubscriberDataRequest) {
        super();
        this.insertSubscriberDataRequest = insertSubscriberDataRequest;
        if (insertSubscriberDataRequest != null && insertSubscriberDataRequest.getImsi() != null) {
            this.imsi = insertSubscriberDataRequest.getImsi();
        }
        if (insertSubscriberDataRequest != null && insertSubscriberDataRequest.getProvisionedSS() != null) {
            this.extSSInfos = new ExtSSInfo[insertSubscriberDataRequest.getProvisionedSS().size()];
            insertSubscriberDataRequest.getProvisionedSS().toArray(this.extSSInfos);
        }
    }

    @Override
    public void setProvisionedSS(MAPSS_InformationWrapper[] mapss_Informations) {
        if (mapss_Informations == null) {
            this.extSSInfos = null;
            this.mapss_InformationWrappers = null;
        } else {
            this.extSSInfos = new ExtSSInfo[mapss_Informations.length];
            this.mapss_InformationWrappers = new MAPSS_InformationWrapper[mapss_Informations.length];
            for (int i = 0; i < mapss_Informations.length; i++) {
                final TxMAPSS_InformationWrapper txcMapss_Information = (TxMAPSS_InformationWrapper) mapss_Informations[i];
                extSSInfos[i] = txcMapss_Information.getTxExtSSInfo();
                mapss_InformationWrappers[i] = txcMapss_Information;
            }
        }
    }

    @Override
    public void setImsi(IMSIAddressWrapper imsi) {
        if (imsi == null) {
            this.imsi = null;
            this.imsiAddress = null;
        } else {
            final TxIMSIAddressWrapper txIMSIAddressWrapper = (TxIMSIAddressWrapper) imsi;
            this.imsi = txIMSIAddressWrapper.getTxImsi();
            this.imsiAddress = txIMSIAddressWrapper;
        }
    }

    @Override
    public MAPSS_InformationWrapper[] getProvisionedSS() {
        if (this.mapss_InformationWrappers == null && extSSInfos != null) {
            this.mapss_InformationWrappers = new TxMAPSS_InformationWrapper[extSSInfos.length];
            for (int i = 0; i < extSSInfos.length; i++) {
                final MAPSS_InformationWrapper txcMapss_Information = new TxMAPSS_InformationWrapper(extSSInfos[i]);
                this.mapss_InformationWrappers[i] = txcMapss_Information;
            }
        }
        return this.mapss_InformationWrappers;
    }

    @Override
    public IMSIAddressWrapper getImsi() {
        if (this.imsiAddress == null && this.imsi != null) {
            this.imsiAddress = new TxIMSIAddressWrapper(imsi);
        }
        return this.imsiAddress;
    }

    public ExtSSInfo[] getTxProvisionedSS() {
        return extSSInfos;
    }

    public IMSI getTxImsi() {
        return this.imsi;
    }

    @Override
    public String toString() {
        return "TxInsertSubscriberDataArg_v1Wrapper [insertSubscriberDataRequest=" + insertSubscriberDataRequest
                + ", extSSInfos=" + Arrays.toString(extSSInfos) + ", imsi=" + imsi + "]";
    }

}
