/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import org.mobicents.protocols.ss7.cap.api.primitives.CalledPartyBCDNumber;
import org.mobicents.protocols.ss7.cap.api.primitives.TimeAndTimezone;
import org.mobicents.protocols.ss7.cap.api.service.sms.primitive.SMSAddressString;
import org.mobicents.protocols.ss7.map.api.primitives.IMSI;
import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;
import org.mobicents.protocols.ss7.map.api.service.callhandling.CallReferenceNumber;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.LocationInformation;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.CallReferenceNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.args.CalledPartyBCDNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.args.EventTypeSMS;
import pl.ovoo.ss7.wrapper.cap.args.InitialDPSMSArgWrapper;
import pl.ovoo.ss7.wrapper.cap.args.TimeAndTimezoneWrapper;
import pl.ovoo.ss7.wrapper.common.args.AddressStringWrapper;
import pl.ovoo.ss7.wrapper.common.args.IMSIAddressWrapper;
import pl.ovoo.ss7.wrapper.common.args.ISDNAddressStringWrapper;
import pl.ovoo.ss7.wrapper.common.telestax.TxAddressStringWrapperImpl;
import pl.ovoo.ss7.wrapper.common.telestax.TxIMSIAddressWrapper;
import pl.ovoo.ss7.wrapper.common.telestax.TxISDNAddressStringWrapperImpl;
import pl.ovoo.ss7.wrapper.common.telestax.TxSMSAddressStringWrapperImpl;
import pl.ovoo.ss7.wrapper.map.args.MAPLocationInformationWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxMAPLocationInformationWrapper;

public class TxInitialDPSMSArgWrapper implements InitialDPSMSArgWrapper {

    private transient AddressStringWrapper callingPartyNumberWrapper = null;
    private transient CalledPartyBCDNumberWrapper destinationSubscriberNumberWrapper = null;
    private transient CallReferenceNumberWrapper smsReferenceNumberWrapper = null;
    private transient MAPLocationInformationWrapper locationInformationMSCWrapper = null;
    private transient ISDNAddressStringWrapper smscAddressWrapper = null;
    private transient ISDNAddressStringWrapper mscAddressWrapper = null;
    private transient IMSIAddressWrapper imsiWrapper = null;
    private transient TimeAndTimezoneWrapper timeAndTimezoneWrapper = null;

    private SMSAddressString callingPartyNumber;
    private CalledPartyBCDNumber destinationSubscriberNumber;
    private org.mobicents.protocols.ss7.cap.api.service.sms.primitive.EventTypeSMS eventTypeSMS;
    private CallReferenceNumber smsReferenceNumber;
    private LocationInformation locationInformationMSC;
    private ISDNAddressString smscAddress;
    private int serviceKey;
    private ISDNAddressString mscAddress;
    private IMSI imsi;
    private TimeAndTimezone timeAndTimezone;

    @Override
    public EventTypeSMS getEventTypeSMS() {
        if (eventTypeSMS == null) {
            return null;
        }
        return EventTypeSMS.valueOf(eventTypeSMS.getCode());
    }

    @Override
    public boolean hasCallingPartyNumber() {
        return callingPartyNumber != null;
    }

    @Override
    public AddressStringWrapper getCallingPartyNumber() {
        if (this.callingPartyNumberWrapper == null && this.callingPartyNumber != null) {
            this.callingPartyNumberWrapper = new TxSMSAddressStringWrapperImpl(callingPartyNumber);
        }
        return this.callingPartyNumberWrapper;
    }

    @Override
    public boolean hasDestinationSubscriberNumber() {
        return destinationSubscriberNumber != null;
    }

    @Override
    public CalledPartyBCDNumberWrapper getDestinationSubscriberNumber() {
        if (this.destinationSubscriberNumberWrapper == null && this.destinationSubscriberNumber != null) {
            this.destinationSubscriberNumberWrapper = new TxCalledPartyBCDNumberWrapper(destinationSubscriberNumber);
        }
        return this.destinationSubscriberNumberWrapper;
    }

    @Override
    public boolean hasSmsReferenceNumber() {
        return (smsReferenceNumber != null);
    }

    @Override
    public CallReferenceNumberWrapper getSmsReferenceNumber() {
        if (this.smsReferenceNumberWrapper == null && this.smsReferenceNumber != null) {
            this.smsReferenceNumberWrapper = new TxCallReferenceNumberWrapper(smsReferenceNumber);
        }
        return this.smsReferenceNumberWrapper;
    }

    @Override
    public MAPLocationInformationWrapper getLocationInformationMSC() throws Ss7WrapperException {
        if (this.locationInformationMSCWrapper == null && this.locationInformationMSC != null) {
            this.locationInformationMSCWrapper = new TxMAPLocationInformationWrapper(locationInformationMSC);
        }
        return this.locationInformationMSCWrapper;
    }

    @Override
    public boolean hasLocationInformationMSC() {
        return locationInformationMSC != null;
    }

    @Override
    public boolean hasSMSCAddress() {
        return smscAddress != null;
    }

    @Override
    public ISDNAddressStringWrapper getSMSCAddress() {
        if (this.smscAddressWrapper == null && this.smscAddress != null) {
            this.smscAddressWrapper = new TxISDNAddressStringWrapperImpl(smscAddress);
        }
        return this.smscAddressWrapper;
    }

    @Override
    public int getServiceKey() {
        return serviceKey;
    }

    @Override
    public boolean hasMSCAddress() {
        return mscAddress != null;
    }

    @Override
    public ISDNAddressStringWrapper getMSCAddress() {
        if (this.mscAddressWrapper == null && this.mscAddress != null) {
            this.mscAddressWrapper = new TxISDNAddressStringWrapperImpl(mscAddress);
        }
        return this.mscAddressWrapper;
    }

    @Override
    public boolean hasIMSI() {
        return imsi != null;
    }

    @Override
    public IMSIAddressWrapper getIMSI() {
        if (this.imsiWrapper == null && this.imsi != null) {
            this.imsiWrapper = new TxIMSIAddressWrapper(imsi);
        }
        return this.imsiWrapper;
    }

    @Override
    public TimeAndTimezoneWrapper getTimeAndTimezone() {
        if (this.timeAndTimezoneWrapper == null && this.timeAndTimezone != null) {
            this.timeAndTimezoneWrapper = new TxTimeAndTimezoneWrapper(timeAndTimezone);
        }
        return this.timeAndTimezoneWrapper;
    }

    public void setTxCallingPartyNumber(SMSAddressString callingPartyNumber) {
        this.callingPartyNumber = callingPartyNumber;
        this.callingPartyNumberWrapper = null;
    }

    public void setTxDestinationSubscriberNumber(CalledPartyBCDNumber destinationSubscriberNumber) {
        this.destinationSubscriberNumber = destinationSubscriberNumber;
        this.destinationSubscriberNumberWrapper = null;
    }

    public void setTxEventTypeSMS(org.mobicents.protocols.ss7.cap.api.service.sms.primitive.EventTypeSMS eventTypeSMS) {
        this.eventTypeSMS = eventTypeSMS;
    }

    public void setTxSmsReferenceNumber(CallReferenceNumber smsReferenceNumber) {
        this.smsReferenceNumber = smsReferenceNumber;
        this.smsReferenceNumberWrapper = null;
    }

    public void setTxLocationInformationMSC(LocationInformation locationInformationMSC) {
        this.locationInformationMSC = locationInformationMSC;
        this.locationInformationMSCWrapper = null;
    }

    public void setTxSmscAddress(ISDNAddressString smscAddress) {
        this.smscAddress = smscAddress;
        this.smscAddressWrapper = null;
    }

    public void setTxServiceKey(int serviceKey) {
        this.serviceKey = serviceKey;
    }

    public void setTxMscAddress(ISDNAddressString mscAddress) {
        this.mscAddress = mscAddress;
        this.mscAddressWrapper = null;
    }

    public void setTxImsi(IMSI imsi) {
        this.imsi = imsi;
        this.imsiWrapper = null;
    }

    public void setTxTimeAndTimezone(TimeAndTimezone timeAndTimezone) {
        this.timeAndTimezone = timeAndTimezone;
        this.timeAndTimezoneWrapper = null;
    }

    public SMSAddressString getTxCallingPartyNumber() {
        return callingPartyNumber;
    }

    public CalledPartyBCDNumber getTxDestinationSubscriberNumber() {
        return destinationSubscriberNumber;
    }

    public org.mobicents.protocols.ss7.cap.api.service.sms.primitive.EventTypeSMS getTxEventTypeSMS() {
        return eventTypeSMS;
    }

    public LocationInformation getTxLocationInformationMSC() {
        return locationInformationMSC;
    }

    public ISDNAddressString getTxSmscAddress() {
        return smscAddress;
    }

    public ISDNAddressString getTxMscAddress() {
        return mscAddress;
    }

    public IMSI getTxImsi() {
        return imsi;
    }

    public TimeAndTimezone getTxTimeAndTimezone() {
        return timeAndTimezone;
    }

    public CallReferenceNumber getTxSmsReferenceNumber() {
        return smsReferenceNumber;
    }

    @Override
    public void setEventTypeSMS(EventTypeSMS eventTypeSMS) {
        this.eventTypeSMS = org.mobicents.protocols.ss7.cap.api.service.sms.primitive.EventTypeSMS
                .getInstance(eventTypeSMS.getValue());
    }

    @Override
    public void setCallingPartyNumber(AddressStringWrapper cCallingPartyNumber) {
        if (cCallingPartyNumber == null) {
            this.callingPartyNumber = null;
            this.callingPartyNumberWrapper = null;
        } else {
            final TxSMSAddressStringWrapperImpl txSMSAddressStringWrapperImpl = (TxSMSAddressStringWrapperImpl) cCallingPartyNumber;
            this.callingPartyNumber = txSMSAddressStringWrapperImpl.getTxAddress();
            this.callingPartyNumberWrapper = txSMSAddressStringWrapperImpl;
        }
    }

    @Override
    public void setDestinationSubscriberNumber(CalledPartyBCDNumberWrapper destinationSubscriberNumber) {
        if (destinationSubscriberNumber == null) {
            this.destinationSubscriberNumber = null;
            this.destinationSubscriberNumberWrapper = null;
        } else {
            final TxCalledPartyBCDNumberWrapper txCalledPartyBCDNumberWrapper = (TxCalledPartyBCDNumberWrapper) destinationSubscriberNumber;
            this.destinationSubscriberNumber = txCalledPartyBCDNumberWrapper.getTxCalledPartyBCDNumber();
            this.destinationSubscriberNumberWrapper = txCalledPartyBCDNumberWrapper;
        }
    }

    @Override
    public void setSmsReferenceNumber(CallReferenceNumberWrapper smsReferenceNumber) {
        if (smsReferenceNumber == null) {
            this.smsReferenceNumber = null;
            this.smsReferenceNumberWrapper = null;
        } else {
            final TxCallReferenceNumberWrapper txCallReferenceNumberWrapper = (TxCallReferenceNumberWrapper) smsReferenceNumber;
            this.smsReferenceNumber = txCallReferenceNumberWrapper.getTxCallReferenceNumber();
            this.smsReferenceNumberWrapper = txCallReferenceNumberWrapper;

        }
    }

    @Override
    public void setLocationInformationMSC(MAPLocationInformationWrapper lLocationInformationMSC)
            throws Ss7WrapperException {
        if (lLocationInformationMSC == null) {
            this.locationInformationMSC = null;
            this.locationInformationMSCWrapper = null;
        } else {
            final TxMAPLocationInformationWrapper txMAPLocationInformationWrapper = (TxMAPLocationInformationWrapper) lLocationInformationMSC;
            this.locationInformationMSC = txMAPLocationInformationWrapper.getTxMapLocationInformation();
            this.locationInformationMSCWrapper = txMAPLocationInformationWrapper;
        }
    }

    @Override
    public void setMSCAddress(ISDNAddressStringWrapper mSCAddress) {
        if (mSCAddress == null) {
            this.mscAddress = null;
            this.mscAddressWrapper = null;
        } else {
            final TxISDNAddressStringWrapperImpl txISDNAddressStringWrapperImpl = (TxISDNAddressStringWrapperImpl) mSCAddress;
            this.mscAddress = txISDNAddressStringWrapperImpl.getTxAddress();
            this.mscAddressWrapper = txISDNAddressStringWrapperImpl;
        }
    }

    @Override
    public void setSMSCAddress(ISDNAddressStringWrapper sMSCAddress) {
        if (sMSCAddress == null) {
            this.smscAddress = null;
            this.smscAddressWrapper = null;
        } else {
            final TxISDNAddressStringWrapperImpl txISDNAddressStringWrapperImpl = (TxISDNAddressStringWrapperImpl) sMSCAddress;
            this.smscAddress = txISDNAddressStringWrapperImpl.getTxAddress();
            this.smscAddressWrapper = txISDNAddressStringWrapperImpl;
        }

    }

    @Override
    public void setServiceKey(int serviceKey) {
        this.serviceKey = serviceKey;
    }

    @Override
    public void setIMSI(IMSIAddressWrapper iMSI) {
        if (iMSI == null) {
            this.imsi = null;
            this.imsiWrapper = null;
        } else {
            final TxIMSIAddressWrapper txIMSIAddressWrapper = (TxIMSIAddressWrapper) iMSI;
            this.imsi = txIMSIAddressWrapper.getTxImsi();
            this.imsiWrapper = txIMSIAddressWrapper;
        }
    }

    @Override
    public void setTimeAndTimezone(TimeAndTimezoneWrapper timeAndTimezone) {
        if (timeAndTimezone == null) {
            this.timeAndTimezone = null;
            this.timeAndTimezoneWrapper = null;
        } else {
            final TxTimeAndTimezoneWrapper txTimeAndTimezoneWrapper = (TxTimeAndTimezoneWrapper) timeAndTimezone;
            this.timeAndTimezone = txTimeAndTimezoneWrapper.getTxTimeAndTimezone();
            this.timeAndTimezoneWrapper = txTimeAndTimezoneWrapper;
        }
    }

    @Override
    public String toString() {
        return "TxInitialDPSMSArgWrapper [callingPartyNumber=" + callingPartyNumber + ", destinationSubscriberNumber="
                + destinationSubscriberNumber + ", eventTypeSMS=" + eventTypeSMS + ", smsReferenceNumber="
                + smsReferenceNumber + ", locationInformationMSC=" + locationInformationMSC + ", smscAddress="
                + smscAddress + ", serviceKey=" + serviceKey + ", mscAddress=" + mscAddress + ", imsi=" + imsi
                + ", timeAndTimezone=" + timeAndTimezone + "]";
    }

}
