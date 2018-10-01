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

package pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap1;

import org.mobicents.protocols.ss7.cap.api.isup.LocationNumberCap;
import org.mobicents.protocols.ss7.cap.api.primitives.CalledPartyBCDNumber;
import org.mobicents.protocols.ss7.map.api.primitives.IMSI;
import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;
import org.mobicents.protocols.ss7.map.api.service.callhandling.CallReferenceNumber;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.LocationInformation;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberState;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtBasicServiceCode;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxCalledPartyBCDNumberWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxInitialDPArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxLocationNumberWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.CallReferenceNumberWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.CalledPartyBCDNumberWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.ExtBasicServiceCodeWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.LocationNumberWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.cap1.Cap1InitialDPArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxCallReferenceNumberWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxExtBasicServiceCodeWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.args.IMSIAddressWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.args.ISDNAddressStringWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.tx.TxIMSIAddressWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.tx.TxISDNAddressStringWrapperImpl;
import pl.ovoo.jslee.ss7.wrapper.map.args.MAPLocationInformationWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.args.SubscriberStateWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxMAPLocationInformationWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxSubscriberStateWrapper;


/**
 * OcCap1InitialDPArgWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCap1InitialDPArgWrapper extends TxInitialDPArgWrapper implements Cap1InitialDPArgWrapper {

    /** The called party bcd number wrapper. */
    private transient CalledPartyBCDNumberWrapper calledPartyBCDNumberWrapper = null;
    
    /** The call reference number wrapper. */
    private transient CallReferenceNumberWrapper callReferenceNumberWrapper = null;
    
    /** The ext basic service code wrapper. */
    private transient ExtBasicServiceCodeWrapper extBasicServiceCodeWrapper = null;
    
    /** The imsi wrapper. */
    private transient IMSIAddressWrapper imsiWrapper = null;
    
    /** The location information wrapper. */
    private transient MAPLocationInformationWrapper locationInformationWrapper = null;
    
    /** The location number wrapper. */
    private transient LocationNumberWrapper locationNumberWrapper = null;
    
    /** The subscriber state wrapper. */
    private transient SubscriberStateWrapper subscriberStateWrapper = null;
    
    /** The msc address wrapper. */
    private transient ISDNAddressStringWrapper mscAddressWrapper = null;

    /** The called party bcd number. */
    private CalledPartyBCDNumber calledPartyBCDNumber;
    
    /** The call reference number. */
    private CallReferenceNumber callReferenceNumber;
    
    /** The ext basic service code. */
    private ExtBasicServiceCode extBasicServiceCode;
    
    /** The imsi. */
    private IMSI imsi;
    
    /** The location information. */
    private LocationInformation locationInformation;
    
    /** The location number. */
    private LocationNumberCap locationNumber;
    
    /** The msc address. */
    private ISDNAddressString mscAddress;
    
    /** The subscriber state. */
    private SubscriberState subscriberState;

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.cap1.Cap1InitialDPArgWrapper#hasCalledPartyBCDNumber()
     */
    @Override
    public boolean hasCalledPartyBCDNumber() {
        return calledPartyBCDNumber != null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.cap1.Cap1InitialDPArgWrapper#getCalledPartyBCDNumber()
     */
    @Override
    public CalledPartyBCDNumberWrapper getCalledPartyBCDNumber() {
        if (this.calledPartyBCDNumberWrapper == null && this.calledPartyBCDNumber != null) {
            this.calledPartyBCDNumberWrapper = new TxCalledPartyBCDNumberWrapper(calledPartyBCDNumber);
        }
        return this.calledPartyBCDNumberWrapper;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.cap1.Cap1InitialDPArgWrapper#setCalledPartyBCDNumber(pl.ovoo.jslee.ss7.wrapper.cap.args.CalledPartyBCDNumberWrapper)
     */
    @Override
    public void setCalledPartyBCDNumber(final CalledPartyBCDNumberWrapper calledPartyBCDNumber) {
        if (calledPartyBCDNumber == null) {
            this.calledPartyBCDNumber = null;
            this.calledPartyBCDNumberWrapper = null;
        } else {
            final TxCalledPartyBCDNumberWrapper txCalledPartyBCDNumberWrapper = (TxCalledPartyBCDNumberWrapper) calledPartyBCDNumber;
            this.calledPartyBCDNumber = txCalledPartyBCDNumberWrapper.getTxCalledPartyBCDNumber();
            this.calledPartyBCDNumberWrapper = txCalledPartyBCDNumberWrapper;
        }
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.cap1.Cap1InitialDPArgWrapper#hasCallReferenceNumber()
     */
    @Override
    public boolean hasCallReferenceNumber() {
        return callReferenceNumber != null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.cap1.Cap1InitialDPArgWrapper#getCallReferenceNumber()
     */
    @Override
    public CallReferenceNumberWrapper getCallReferenceNumber() {
        if (this.callReferenceNumberWrapper == null && this.callReferenceNumber != null) {
            this.callReferenceNumberWrapper = new TxCallReferenceNumberWrapper(callReferenceNumber);
        }
        return this.callReferenceNumberWrapper;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.cap1.Cap1InitialDPArgWrapper#setCallReferenceNumber(pl.ovoo.jslee.ss7.wrapper.cap.args.CallReferenceNumberWrapper)
     */
    @Override
    public void setCallReferenceNumber(final CallReferenceNumberWrapper callReferenceNumber) {
        if (callReferenceNumber == null) {
            this.callReferenceNumber = null;
            this.callReferenceNumberWrapper = null;
        } else {
            final TxCallReferenceNumberWrapper txCallReferenceNumberWrapper = (TxCallReferenceNumberWrapper) callReferenceNumber;
            this.callReferenceNumber = txCallReferenceNumberWrapper.getTxCallReferenceNumber();
            this.callReferenceNumberWrapper = txCallReferenceNumberWrapper;
        }
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.cap1.Cap1InitialDPArgWrapper#hasExtBasicServiceCode()
     */
    @Override
    public boolean hasExtBasicServiceCode() {
        return extBasicServiceCode != null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.cap1.Cap1InitialDPArgWrapper#getExtBasicServiceCode()
     */
    @Override
    public ExtBasicServiceCodeWrapper getExtBasicServiceCode() {
        if (this.extBasicServiceCodeWrapper == null && extBasicServiceCode != null) {
            this.extBasicServiceCodeWrapper = new TxExtBasicServiceCodeWrapper(extBasicServiceCode);
        }
        return this.extBasicServiceCodeWrapper;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.cap1.Cap1InitialDPArgWrapper#hasIMSI()
     */
    @Override
    public boolean hasIMSI() {
        return imsi != null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.cap1.Cap1InitialDPArgWrapper#getIMSI()
     */
    @Override
    public IMSIAddressWrapper getIMSI() {
        if (this.imsiWrapper == null && this.imsi != null) {
            this.imsiWrapper = new TxIMSIAddressWrapper(imsi);
        }
        return this.imsiWrapper;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.cap1.Cap1InitialDPArgWrapper#hasLocationInformation()
     */
    @Override
    public boolean hasLocationInformation() {
        return locationInformation != null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.cap1.Cap1InitialDPArgWrapper#getLocationInformation()
     */
    @Override
    public MAPLocationInformationWrapper getLocationInformation() {
        if (this.locationInformationWrapper == null && this.locationInformation != null) {
            this.locationInformationWrapper = new TxMAPLocationInformationWrapper(locationInformation);
        }
        return this.locationInformationWrapper;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.cap1.Cap1InitialDPArgWrapper#setLocationInformation(pl.ovoo.jslee.ss7.wrapper.map.args.MAPLocationInformationWrapper)
     */
    @Override
    public void setLocationInformation(final MAPLocationInformationWrapper locationInformation) {
        if (locationInformation == null) {
            this.locationInformation = null;
            this.locationInformationWrapper = null;
        } else {
            final TxMAPLocationInformationWrapper txMAPLocationInformationWrapper = (TxMAPLocationInformationWrapper) locationInformation;
            this.locationInformation = txMAPLocationInformationWrapper.getTxMapLocationInformation();
            this.locationInformationWrapper = txMAPLocationInformationWrapper;
        }
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.cap1.Cap1InitialDPArgWrapper#hasSubscriberState()
     */
    @Override
    public boolean hasSubscriberState() {
        return subscriberState != null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.cap1.Cap1InitialDPArgWrapper#getSubscriberState()
     */
    @Override
    public SubscriberStateWrapper getSubscriberState() {
        if (this.subscriberStateWrapper == null && this.subscriberState != null) {
            this.subscriberStateWrapper = new TxSubscriberStateWrapper(subscriberState);
        }
        return this.subscriberStateWrapper;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.cap1.Cap1InitialDPArgWrapper#setSubscriberState(pl.ovoo.jslee.ss7.wrapper.cap.args.SubscriberStateWrapper)
     */
    @Override
    public void setSubscriberState(final SubscriberStateWrapper subscriberState) {
        if (subscriberState == null) {
            this.subscriberState = null;
            this.subscriberStateWrapper = null;
        } else {
            final TxSubscriberStateWrapper txSubscriberStateWrapper = (TxSubscriberStateWrapper) subscriberState;
            this.subscriberState = txSubscriberStateWrapper.getTxSubscriberState();
            this.subscriberStateWrapper = txSubscriberStateWrapper;
        }
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.cap1.Cap1InitialDPArgWrapper#hasLocationNumber()
     */
    @Override
    public boolean hasLocationNumber() {
        return locationNumber != null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.cap1.Cap1InitialDPArgWrapper#getLocationNumber()
     */
    @Override
    public LocationNumberWrapper getLocationNumber() {
        if (this.locationNumberWrapper == null && this.locationNumber != null) {
            this.locationNumberWrapper = new TxLocationNumberWrapper(locationNumber);
        }
        return this.locationNumberWrapper;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.cap1.Cap1InitialDPArgWrapper#setLocationNumber(pl.ovoo.jslee.ss7.wrapper.map.args.MAPLocationNumberWrapper)
     */
    @Override
    public void setLocationNumber(final LocationNumberWrapper locationNumber) {
        if (locationNumber == null) {
            this.locationNumber = null;
            this.locationNumberWrapper = null;
        } else {
            final TxLocationNumberWrapper txLocationNumberWrapper = (TxLocationNumberWrapper) locationNumber;
            this.locationNumber = txLocationNumberWrapper.getTxLocationNumber();
            this.locationNumberWrapper = txLocationNumberWrapper;
        }
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.cap1.Cap1InitialDPArgWrapper#hasMscAddress()
     */
    @Override
    public boolean hasMscAddress() {
        return mscAddress != null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.cap1.Cap1InitialDPArgWrapper#getMscAddress()
     */
    @Override
    public ISDNAddressStringWrapper getMscAddress() {
        if (this.mscAddressWrapper == null && this.mscAddress != null) {
            this.mscAddressWrapper = new TxISDNAddressStringWrapperImpl(mscAddress);
        }
        return this.mscAddressWrapper;
    }

    /**
     * Gets the tx called party bcd number.
     *
     * @return the tx called party bcd number
     */
    public CalledPartyBCDNumber getTxCalledPartyBCDNumber() {
        return calledPartyBCDNumber;
    }

    /**
     * Gets the tx call reference number.
     *
     * @return the tx call reference number
     */
    public CallReferenceNumber getTxCallReferenceNumber() {
        return callReferenceNumber;
    }

    /**
     * Gets the tx ext basic service code.
     *
     * @return the tx ext basic service code
     */
    public ExtBasicServiceCode getTxExtBasicServiceCode() {
        return extBasicServiceCode;
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
     * Gets the tx location information.
     *
     * @return the tx location information
     */
    public LocationInformation getTxLocationInformation() {
        return locationInformation;
    }

    /**
     * Gets the tx location number.
     *
     * @return the tx location number
     */
    public LocationNumberCap getTxLocationNumber() {
        return locationNumber;
    }

    /**
     * Gets the tx subscriber state.
     *
     * @return the tx subscriber state
     */
    public SubscriberState getTxSubscriberState() {
        return subscriberState;
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
     * Sets the tx called party bcd number.
     *
     * @param calledPartyBCDNumber the new tx called party bcd number
     */
    public void setTxCalledPartyBCDNumber(final CalledPartyBCDNumber calledPartyBCDNumber) {
        this.calledPartyBCDNumber = calledPartyBCDNumber;
        this.calledPartyBCDNumberWrapper = null;
    }

    /**
     * Sets the tx call reference number.
     *
     * @param callReferenceNumber the new tx call reference number
     */
    public void setTxCallReferenceNumber(final CallReferenceNumber callReferenceNumber) {
        this.callReferenceNumber = callReferenceNumber;
        this.callReferenceNumberWrapper = null;
    }

    /**
     * Sets the tx ext basic service code.
     *
     * @param extBasicServiceCode the new tx ext basic service code
     */
    public void setTxExtBasicServiceCode(final ExtBasicServiceCode extBasicServiceCode) {
        this.extBasicServiceCode = extBasicServiceCode;
        this.extBasicServiceCodeWrapper = null;
    }

    /**
     * Sets the tx imsi.
     *
     * @param imsi the new tx imsi
     */
    public void setTxImsi(final IMSI imsi) {
        this.imsi = imsi;
        this.imsiWrapper = null;
    }

    /**
     * Sets the tx location information.
     *
     * @param txLocationInformation the new tx location information
     */
    public void setTxLocationInformation(final LocationInformation txLocationInformation) {
        this.locationInformation = txLocationInformation;
        this.locationInformationWrapper = null;
    }

    /**
     * Sets the tx location number.
     *
     * @param txLocationNumber the new tx location number
     */
    public void setTxLocationNumber(final LocationNumberCap txLocationNumber) {
        this.locationNumber = txLocationNumber;
        this.locationNumberWrapper = null;
    }

    public void setTxSubscriberState(final SubscriberState txSubscriberState) {
        this.subscriberState = txSubscriberState;
        this.subscriberStateWrapper = null;
    }
    
    /**
     * Sets the tx msc address.
     *
     * @param mscAddress the new tx msc address
     */
    public void setTxMscAddress(final ISDNAddressString mscAddress) {
        this.mscAddress = mscAddress;
        this.mscAddressWrapper = null;
    }

}
