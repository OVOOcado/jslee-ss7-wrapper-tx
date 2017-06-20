/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import org.mobicents.protocols.ss7.cap.api.primitives.CalledPartyBCDNumber;
import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;
import pl.ovoo.ss7.wrapper.cap.args.CalledPartyBCDNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.args.ConnectSMSArgWrapper;
import pl.ovoo.ss7.wrapper.common.args.ISDNAddressStringWrapper;
import pl.ovoo.ss7.wrapper.common.telestax.TxISDNAddressStringWrapperImpl;

/**
 * OcRequestReportSMSEventArgWrapperImpl
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxConnectSMSArgWrapper implements ConnectSMSArgWrapper {

    private transient CalledPartyBCDNumberWrapper calledPartyBCDNumberWrapper = null;
    private transient ISDNAddressStringWrapper isdnAddressStringWrapper = null;

    private CalledPartyBCDNumber destinationSubscriberNumber;
    private ISDNAddressString smscAddress;

    public TxConnectSMSArgWrapper(final CalledPartyBCDNumber destinationSubscriberNumber,
            ISDNAddressString smscAddress) {
        this.destinationSubscriberNumber = destinationSubscriberNumber;
        this.smscAddress = smscAddress;

    }

    public TxConnectSMSArgWrapper() {

    }

    public CalledPartyBCDNumber getTxDestinationSubscriberNumber() {
        return destinationSubscriberNumber;
    }

    public ISDNAddressString getTxSmscAddress() {
        return smscAddress;
    }

    public void setTxDestinationSubscriberNumber(CalledPartyBCDNumber destinationSubscriberNumber) {
        this.destinationSubscriberNumber = destinationSubscriberNumber;
        this.calledPartyBCDNumberWrapper = null;

    }

    public void setTxSmscAddress(ISDNAddressString smscAddress) {
        this.smscAddress = smscAddress;
        this.isdnAddressStringWrapper = null;
    }

    @Override
    public void setDestinationSubscriberNumber(final CalledPartyBCDNumberWrapper destinationSubscriberNumber) {
        if (destinationSubscriberNumber == null) {
            this.destinationSubscriberNumber = null;
            this.calledPartyBCDNumberWrapper = null;
        } else {
            this.destinationSubscriberNumber = ((TxCalledPartyBCDNumberWrapper) destinationSubscriberNumber)
                    .getTxCalledPartyBCDNumber();
            this.calledPartyBCDNumberWrapper = (TxCalledPartyBCDNumberWrapper) destinationSubscriberNumber;
        }
    }

    @Override
    public void setSMSCAddress(final ISDNAddressStringWrapper smscAddress) {
        if (smscAddress == null) {
            this.smscAddress = null;
            this.isdnAddressStringWrapper = null;
        } else {
            this.smscAddress = ((TxISDNAddressStringWrapperImpl) smscAddress).getTxAddress();
            this.isdnAddressStringWrapper = (TxISDNAddressStringWrapperImpl) smscAddress;
        }
    }

    @Override
    public CalledPartyBCDNumberWrapper getDestinationSubscriberNumber() {
        if (this.calledPartyBCDNumberWrapper == null && destinationSubscriberNumber != null) {
            this.calledPartyBCDNumberWrapper = new TxCalledPartyBCDNumberWrapper(destinationSubscriberNumber);
        }
        return this.calledPartyBCDNumberWrapper;
    }

    @Override
    public ISDNAddressStringWrapper getSMSCAddress() {
        if (this.isdnAddressStringWrapper == null && this.smscAddress != null) {
            this.isdnAddressStringWrapper = new TxISDNAddressStringWrapperImpl(smscAddress);
        }
        return this.isdnAddressStringWrapper;
    }

    @Override
    public String toString() {
        return "TxConnectSMSArgWrapper [destinationSubscriberNumber=" + destinationSubscriberNumber + ", smscAddress="
                + smscAddress + "]";
    }

}
