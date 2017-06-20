/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.map.telestax.args;

import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;

import pl.ovoo.ss7.wrapper.common.args.ISDNAddressStringWrapper;
import pl.ovoo.ss7.wrapper.common.telestax.TxISDNAddressStringWrapperImpl;
import pl.ovoo.ss7.wrapper.map.args.SendRoutingInfoRequestArgWrapper;

/**
 * TxSendRoutingInfoRequestArgWrapper
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxSendRoutingInfoRequestArgWrapper implements SendRoutingInfoRequestArgWrapper {
    private transient ISDNAddressStringWrapper msisdnWrapper = null;
    private transient ISDNAddressStringWrapper gmscAddressWrapper = null;

    private ISDNAddressString msisdn;
    private ISDNAddressString gmscAddress;

    public TxSendRoutingInfoRequestArgWrapper() {
        super();
    }

    @Override
    public ISDNAddressStringWrapper getMsisdn() {
        if (this.msisdnWrapper == null && this.msisdn != null) {
            this.msisdnWrapper = new TxISDNAddressStringWrapperImpl(msisdn);
        }
        return this.msisdnWrapper;
    }

    public void setMsisdn(ISDNAddressStringWrapper msisdn) {
        if (msisdn == null) {
            this.msisdn = null;
            this.msisdnWrapper = null;
        } else {
            TxISDNAddressStringWrapperImpl txMsisdn = (TxISDNAddressStringWrapperImpl) msisdn;
            this.msisdn = txMsisdn.getTxAddress();
            this.msisdnWrapper = txMsisdn;
        }
    }

    public ISDNAddressString getTxMsisdn() {
        return this.msisdn;
    }

    public void setTxMsisdn(ISDNAddressString msisdn) {
        this.msisdn = msisdn;
        this.msisdnWrapper = null;

    }

    public ISDNAddressString getTxGmscAddress() {
        return this.gmscAddress;
    }

    public void setGmscAddress(ISDNAddressStringWrapper gmscAddress) {
        if (gmscAddress == null) {
            this.gmscAddress = null;
            this.gmscAddressWrapper = null;
        } else {
            TxISDNAddressStringWrapperImpl txGmscAddress = (TxISDNAddressStringWrapperImpl) gmscAddress;
            this.gmscAddress = txGmscAddress.getTxAddress();
            this.gmscAddressWrapper = txGmscAddress;
        }
    }

    @Override
    public ISDNAddressStringWrapper getGmscAddress() {
        if (this.gmscAddressWrapper == null && this.gmscAddress != null) {
            this.gmscAddressWrapper = new TxISDNAddressStringWrapperImpl(gmscAddress);
        }
        return this.gmscAddressWrapper;
    }

    @Override
    public String toString() {
        return "TxSendRoutingInfoRequestArgWrapper [msisdn=" + msisdn + "]";
    }

}
