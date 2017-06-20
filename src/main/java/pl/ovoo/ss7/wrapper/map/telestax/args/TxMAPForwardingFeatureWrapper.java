/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.map.telestax.args;

import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtForwFeature;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtSSStatus;
import pl.ovoo.ss7.wrapper.common.args.AddressStringWrapper;
import pl.ovoo.ss7.wrapper.common.telestax.TxISDNAddressStringWrapperImpl;
import pl.ovoo.ss7.wrapper.map.args.MAPForwardingFeatureWrapper;
import pl.ovoo.ss7.wrapper.map.args.MAPForwardingOptionsWrapper;

/**
 * TxMAPForwardingFeatureWrapper
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxMAPForwardingFeatureWrapper implements MAPForwardingFeatureWrapper {

    private transient MAPForwardingOptionsWrapper mapForwardingOptionsWrapper = null;
    private transient AddressStringWrapper addressStringWrapper = null;

    private ExtForwFeature extForwFeature;

    public TxMAPForwardingFeatureWrapper(final ExtForwFeature extForwFeature) {
        this.extForwFeature = extForwFeature;
    }

    @Override
    public MAPForwardingOptionsWrapper getForwardingOptions() {
        if (this.mapForwardingOptionsWrapper == null && this.extForwFeature.getForwardingOptions() != null) {
            mapForwardingOptionsWrapper = new TxMAPForwardingOptionsWrapper(extForwFeature.getForwardingOptions());
        }
        return mapForwardingOptionsWrapper;
    }

    @Override
    public AddressStringWrapper getForwardedToNumber() {
        if (this.addressStringWrapper == null && this.extForwFeature.getForwardedToNumber() != null) {
            this.addressStringWrapper = new TxISDNAddressStringWrapperImpl(extForwFeature.getForwardedToNumber());
        }
        return this.addressStringWrapper;
    }

    @Override
    public byte[] getCFStatus() {
        if (extForwFeature.getSsStatus() != null) {
            ExtSSStatus cfStatus = extForwFeature.getSsStatus();
            return cfStatus.getData();
        }
        return null;
    }

    /*
     * @Override public void setForwardingOptions(MAPForwardingOptionsWrapper
     * forwardingOptions) {
     * extForwFeature.setForwardingOptions(((TxMAPForwardingOptionsWrapper)
     * forwardingOptions).getTxExtForwOptions()); }
     * 
     * @Override public void setForwardedToNumber(AddressStringWrapper
     * forwardedToNumber) {
     * 
     * }
     */

    public ExtForwFeature getTxExtForwFeature() {
        return extForwFeature;
    }

    @Override
    public String toString() {
        return "TxMAPForwardingFeatureWrapper [extForwFeature=" + extForwFeature + "]";
    }

}
