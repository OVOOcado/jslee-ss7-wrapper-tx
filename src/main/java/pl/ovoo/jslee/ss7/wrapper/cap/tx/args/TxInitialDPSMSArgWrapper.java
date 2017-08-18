/*
 * JSLEE SS7 Wrapper Tx
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the JSLEE SS7 Wrapper Tx.
 *
 * JSLEE SS7 Wrapper Tx is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * JSLEE SS7 Wrapper Tx is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package pl.ovoo.jslee.ss7.wrapper.cap.tx.args;

import org.mobicents.protocols.ss7.cap.api.primitives.CalledPartyBCDNumber;
import org.mobicents.protocols.ss7.cap.api.primitives.TimeAndTimezone;
import org.mobicents.protocols.ss7.cap.api.service.sms.primitive.SMSAddressString;
import org.mobicents.protocols.ss7.map.api.primitives.IMSI;
import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;
import org.mobicents.protocols.ss7.map.api.service.callhandling.CallReferenceNumber;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.LocationInformation;
import pl.ovoo.jslee.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.jslee.ss7.wrapper.cap.args.CallReferenceNumberWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.CalledPartyBCDNumberWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.EventTypeSMS;
import pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPSMSArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.TimeAndTimezoneWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.args.AddressStringWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.args.IMSIAddressWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.args.ISDNAddressStringWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.tx.TxIMSIAddressWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.tx.TxISDNAddressStringWrapperImpl;
import pl.ovoo.jslee.ss7.wrapper.common.tx.TxSMSAddressStringWrapperImpl;
import pl.ovoo.jslee.ss7.wrapper.map.args.MAPLocationInformationWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxMAPLocationInformationWrapper;


/**
 * The Class TxInitialDPSMSArgWrapper.
 */
public class TxInitialDPSMSArgWrapper implements InitialDPSMSArgWrapper {

    /** The calling party number wrapper. */
    private transient AddressStringWrapper callingPartyNumberWrapper = null;
    
    /** The destination subscriber number wrapper. */
    private transient CalledPartyBCDNumberWrapper destinationSubscriberNumberWrapper = null;
    
    /** The sms reference number wrapper. */
    private transient CallReferenceNumberWrapper smsReferenceNumberWrapper = null;
    
    /** The location information msc wrapper. */
    private transient MAPLocationInformationWrapper locationInformationMSCWrapper = null;
    
    /** The smsc address wrapper. */
    private transient ISDNAddressStringWrapper smscAddressWrapper = null;
    
    /** The msc address wrapper. */
    private transient ISDNAddressStringWrapper mscAddressWrapper = null;
    
    /** The imsi wrapper. */
    private transient IMSIAddressWrapper imsiWrapper = null;
    
    /** The time and timezone wrapper. */
    private transient TimeAndTimezoneWrapper timeAndTimezoneWrapper = null;

    /** The calling party number. */
    private SMSAddressString callingPartyNumber;
    
    /** The destination subscriber number. */
    private CalledPartyBCDNumber destinationSubscriberNumber;
    
    /** The event type sms. */
    private org.mobicents.protocols.ss7.cap.api.service.sms.primitive.EventTypeSMS eventTypeSMS;
    
    /** The sms reference number. */
    private CallReferenceNumber smsReferenceNumber;
    
    /** The location information msc. */
    private LocationInformation locationInformationMSC;
    
    /** The smsc address. */
    private ISDNAddressString smscAddress;
    
    /** The service key. */
    private int serviceKey;
    
    /** The msc address. */
    private ISDNAddressString mscAddress;
    
    /** The imsi. */
    private IMSI imsi;
    
    /** The time and timezone. */
    private TimeAndTimezone timeAndTimezone;

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPSMSArgWrapper#getEventTypeSMS()
     */
    @Override
    public EventTypeSMS getEventTypeSMS() {
        if (eventTypeSMS == null) {
            return null;
        }
        return EventTypeSMS.valueOf(eventTypeSMS.getCode());
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPSMSArgWrapper#hasCallingPartyNumber()
     */
    @Override
    public boolean hasCallingPartyNumber() {
        return callingPartyNumber != null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPSMSArgWrapper#getCallingPartyNumber()
     */
    @Override
    public AddressStringWrapper getCallingPartyNumber() {
        if (this.callingPartyNumberWrapper == null && this.callingPartyNumber != null) {
            this.callingPartyNumberWrapper = new TxSMSAddressStringWrapperImpl(callingPartyNumber);
        }
        return this.callingPartyNumberWrapper;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPSMSArgWrapper#hasDestinationSubscriberNumber()
     */
    @Override
    public boolean hasDestinationSubscriberNumber() {
        return destinationSubscriberNumber != null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPSMSArgWrapper#getDestinationSubscriberNumber()
     */
    @Override
    public CalledPartyBCDNumberWrapper getDestinationSubscriberNumber() {
        if (this.destinationSubscriberNumberWrapper == null && this.destinationSubscriberNumber != null) {
            this.destinationSubscriberNumberWrapper = new TxCalledPartyBCDNumberWrapper(destinationSubscriberNumber);
        }
        return this.destinationSubscriberNumberWrapper;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPSMSArgWrapper#hasSmsReferenceNumber()
     */
    @Override
    public boolean hasSmsReferenceNumber() {
        return (smsReferenceNumber != null);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPSMSArgWrapper#getSmsReferenceNumber()
     */
    @Override
    public CallReferenceNumberWrapper getSmsReferenceNumber() {
        if (this.smsReferenceNumberWrapper == null && this.smsReferenceNumber != null) {
            this.smsReferenceNumberWrapper = new TxCallReferenceNumberWrapper(smsReferenceNumber);
        }
        return this.smsReferenceNumberWrapper;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPSMSArgWrapper#getLocationInformationMSC()
     */
    @Override
    public MAPLocationInformationWrapper getLocationInformationMSC() throws Ss7WrapperException {
        if (this.locationInformationMSCWrapper == null && this.locationInformationMSC != null) {
            this.locationInformationMSCWrapper = new TxMAPLocationInformationWrapper(locationInformationMSC);
        }
        return this.locationInformationMSCWrapper;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPSMSArgWrapper#hasLocationInformationMSC()
     */
    @Override
    public boolean hasLocationInformationMSC() {
        return locationInformationMSC != null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPSMSArgWrapper#hasSMSCAddress()
     */
    @Override
    public boolean hasSMSCAddress() {
        return smscAddress != null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPSMSArgWrapper#getSMSCAddress()
     */
    @Override
    public ISDNAddressStringWrapper getSMSCAddress() {
        if (this.smscAddressWrapper == null && this.smscAddress != null) {
            this.smscAddressWrapper = new TxISDNAddressStringWrapperImpl(smscAddress);
        }
        return this.smscAddressWrapper;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPSMSArgWrapper#getServiceKey()
     */
    @Override
    public int getServiceKey() {
        return serviceKey;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPSMSArgWrapper#hasMSCAddress()
     */
    @Override
    public boolean hasMSCAddress() {
        return mscAddress != null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPSMSArgWrapper#getMSCAddress()
     */
    @Override
    public ISDNAddressStringWrapper getMSCAddress() {
        if (this.mscAddressWrapper == null && this.mscAddress != null) {
            this.mscAddressWrapper = new TxISDNAddressStringWrapperImpl(mscAddress);
        }
        return this.mscAddressWrapper;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPSMSArgWrapper#hasIMSI()
     */
    @Override
    public boolean hasIMSI() {
        return imsi != null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPSMSArgWrapper#getIMSI()
     */
    @Override
    public IMSIAddressWrapper getIMSI() {
        if (this.imsiWrapper == null && this.imsi != null) {
            this.imsiWrapper = new TxIMSIAddressWrapper(imsi);
        }
        return this.imsiWrapper;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPSMSArgWrapper#getTimeAndTimezone()
     */
    @Override
    public TimeAndTimezoneWrapper getTimeAndTimezone() {
        if (this.timeAndTimezoneWrapper == null && this.timeAndTimezone != null) {
            this.timeAndTimezoneWrapper = new TxTimeAndTimezoneWrapper(timeAndTimezone);
        }
        return this.timeAndTimezoneWrapper;
    }

    /**
     * Sets the tx calling party number.
     *
     * @param callingPartyNumber the new tx calling party number
     */
    public void setTxCallingPartyNumber(SMSAddressString callingPartyNumber) {
        this.callingPartyNumber = callingPartyNumber;
        this.callingPartyNumberWrapper = null;
    }

    /**
     * Sets the tx destination subscriber number.
     *
     * @param destinationSubscriberNumber the new tx destination subscriber number
     */
    public void setTxDestinationSubscriberNumber(CalledPartyBCDNumber destinationSubscriberNumber) {
        this.destinationSubscriberNumber = destinationSubscriberNumber;
        this.destinationSubscriberNumberWrapper = null;
    }

    /**
     * Sets the tx event type sms.
     *
     * @param eventTypeSMS the new tx event type sms
     */
    public void setTxEventTypeSMS(org.mobicents.protocols.ss7.cap.api.service.sms.primitive.EventTypeSMS eventTypeSMS) {
        this.eventTypeSMS = eventTypeSMS;
    }

    /**
     * Sets the tx sms reference number.
     *
     * @param smsReferenceNumber the new tx sms reference number
     */
    public void setTxSmsReferenceNumber(CallReferenceNumber smsReferenceNumber) {
        this.smsReferenceNumber = smsReferenceNumber;
        this.smsReferenceNumberWrapper = null;
    }

    /**
     * Sets the tx location information msc.
     *
     * @param locationInformationMSC the new tx location information msc
     */
    public void setTxLocationInformationMSC(LocationInformation locationInformationMSC) {
        this.locationInformationMSC = locationInformationMSC;
        this.locationInformationMSCWrapper = null;
    }

    /**
     * Sets the tx smsc address.
     *
     * @param smscAddress the new tx smsc address
     */
    public void setTxSmscAddress(ISDNAddressString smscAddress) {
        this.smscAddress = smscAddress;
        this.smscAddressWrapper = null;
    }

    /**
     * Sets the tx service key.
     *
     * @param serviceKey the new tx service key
     */
    public void setTxServiceKey(int serviceKey) {
        this.serviceKey = serviceKey;
    }

    /**
     * Sets the tx msc address.
     *
     * @param mscAddress the new tx msc address
     */
    public void setTxMscAddress(ISDNAddressString mscAddress) {
        this.mscAddress = mscAddress;
        this.mscAddressWrapper = null;
    }

    /**
     * Sets the tx imsi.
     *
     * @param imsi the new tx imsi
     */
    public void setTxImsi(IMSI imsi) {
        this.imsi = imsi;
        this.imsiWrapper = null;
    }

    /**
     * Sets the tx time and timezone.
     *
     * @param timeAndTimezone the new tx time and timezone
     */
    public void setTxTimeAndTimezone(TimeAndTimezone timeAndTimezone) {
        this.timeAndTimezone = timeAndTimezone;
        this.timeAndTimezoneWrapper = null;
    }

    /**
     * Gets the tx calling party number.
     *
     * @return the tx calling party number
     */
    public SMSAddressString getTxCallingPartyNumber() {
        return callingPartyNumber;
    }

    /**
     * Gets the tx destination subscriber number.
     *
     * @return the tx destination subscriber number
     */
    public CalledPartyBCDNumber getTxDestinationSubscriberNumber() {
        return destinationSubscriberNumber;
    }

    /**
     * Gets the tx event type sms.
     *
     * @return the tx event type sms
     */
    public org.mobicents.protocols.ss7.cap.api.service.sms.primitive.EventTypeSMS getTxEventTypeSMS() {
        return eventTypeSMS;
    }

    /**
     * Gets the tx location information msc.
     *
     * @return the tx location information msc
     */
    public LocationInformation getTxLocationInformationMSC() {
        return locationInformationMSC;
    }

    /**
     * Gets the tx smsc address.
     *
     * @return the tx smsc address
     */
    public ISDNAddressString getTxSmscAddress() {
        return smscAddress;
    }

    /**
     * Gets the tx msc address.
     *
     * @return the tx msc address
     */
    public ISDNAddressString getTxMscAddress() {
        return mscAddress;
    }

    /**
     * Gets the tx imsi.
     *
     * @return the tx imsi
     */
    public IMSI getTxImsi() {
        return imsi;
    }

    /**
     * Gets the tx time and timezone.
     *
     * @return the tx time and timezone
     */
    public TimeAndTimezone getTxTimeAndTimezone() {
        return timeAndTimezone;
    }

    /**
     * Gets the tx sms reference number.
     *
     * @return the tx sms reference number
     */
    public CallReferenceNumber getTxSmsReferenceNumber() {
        return smsReferenceNumber;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPSMSArgWrapper#setEventTypeSMS(pl.ovoo.jslee.ss7.wrapper.cap.args.EventTypeSMS)
     */
    @Override
    public void setEventTypeSMS(EventTypeSMS eventTypeSMS) {
        this.eventTypeSMS = org.mobicents.protocols.ss7.cap.api.service.sms.primitive.EventTypeSMS
                .getInstance(eventTypeSMS.getValue());
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPSMSArgWrapper#setCallingPartyNumber(pl.ovoo.jslee.ss7.wrapper.common.args.AddressStringWrapper)
     */
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

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPSMSArgWrapper#setDestinationSubscriberNumber(pl.ovoo.jslee.ss7.wrapper.cap.args.CalledPartyBCDNumberWrapper)
     */
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

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPSMSArgWrapper#setSmsReferenceNumber(pl.ovoo.jslee.ss7.wrapper.cap.args.CallReferenceNumberWrapper)
     */
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

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPSMSArgWrapper#setLocationInformationMSC(pl.ovoo.jslee.ss7.wrapper.map.args.MAPLocationInformationWrapper)
     */
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

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPSMSArgWrapper#setMSCAddress(pl.ovoo.jslee.ss7.wrapper.common.args.ISDNAddressStringWrapper)
     */
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

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPSMSArgWrapper#setSMSCAddress(pl.ovoo.jslee.ss7.wrapper.common.args.ISDNAddressStringWrapper)
     */
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

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPSMSArgWrapper#setServiceKey(int)
     */
    @Override
    public void setServiceKey(int serviceKey) {
        this.serviceKey = serviceKey;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPSMSArgWrapper#setIMSI(pl.ovoo.jslee.ss7.wrapper.common.args.IMSIAddressWrapper)
     */
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

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPSMSArgWrapper#setTimeAndTimezone(pl.ovoo.jslee.ss7.wrapper.cap.args.TimeAndTimezoneWrapper)
     */
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

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TxInitialDPSMSArgWrapper [callingPartyNumber=" + callingPartyNumber + ", destinationSubscriberNumber="
                + destinationSubscriberNumber + ", eventTypeSMS=" + eventTypeSMS + ", smsReferenceNumber="
                + smsReferenceNumber + ", locationInformationMSC=" + locationInformationMSC + ", smscAddress="
                + smscAddress + ", serviceKey=" + serviceKey + ", mscAddress=" + mscAddress + ", imsi=" + imsi
                + ", timeAndTimezone=" + timeAndTimezone + "]";
    }

}
