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

package pl.ovoo.ss7.wrapper.cap.tx.args.cap1;

import org.mobicents.protocols.ss7.cap.api.primitives.CalledPartyBCDNumber;
import org.mobicents.protocols.ss7.map.api.primitives.IMSI;
import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;
import org.mobicents.protocols.ss7.map.api.service.callhandling.CallReferenceNumber;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.LocationInformation;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtBasicServiceCode;
import pl.ovoo.ss7.wrapper.cap.args.CallReferenceNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.args.CalledPartyBCDNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.args.ExtBasicServiceCodeWrapper;
import pl.ovoo.ss7.wrapper.cap.args.cap1.Cap1InitialDPArgWrapper;
import pl.ovoo.ss7.wrapper.cap.tx.args.TxCallReferenceNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.tx.args.TxCalledPartyBCDNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.tx.args.TxExtBasicServiceCodeWrapper;
import pl.ovoo.ss7.wrapper.cap.tx.args.TxInitialDPArgWrapper;
import pl.ovoo.ss7.wrapper.common.args.IMSIAddressWrapper;
import pl.ovoo.ss7.wrapper.common.args.ISDNAddressStringWrapper;
import pl.ovoo.ss7.wrapper.common.tx.TxIMSIAddressWrapper;
import pl.ovoo.ss7.wrapper.common.tx.TxISDNAddressStringWrapperImpl;
import pl.ovoo.ss7.wrapper.map.args.MAPLocationInformationWrapper;
import pl.ovoo.ss7.wrapper.map.tx.args.TxMAPLocationInformationWrapper;

/**
 * OcCap1InitialDPArgWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCap1InitialDPArgWrapper extends TxInitialDPArgWrapper implements Cap1InitialDPArgWrapper {

    private transient CalledPartyBCDNumberWrapper calledPartyBCDNumberWrapper = null;
    private transient CallReferenceNumberWrapper callReferenceNumberWrapper = null;
    private transient ExtBasicServiceCodeWrapper extBasicServiceCodeWrapper = null;
    private transient IMSIAddressWrapper imsiWrapper = null;
    private transient MAPLocationInformationWrapper locationInformationWrapper = null;
    private transient ISDNAddressStringWrapper mscAddressWrapper = null;

    private CalledPartyBCDNumber calledPartyBCDNumber;
    private CallReferenceNumber callReferenceNumber;
    private ExtBasicServiceCode extBasicServiceCode;
    private IMSI imsi;
    private LocationInformation locationInformation;
    private ISDNAddressString mscAddress;

    @Override
    public boolean hasCalledPartyBCDNumber() {
        return calledPartyBCDNumber != null;
    }

    @Override
    public CalledPartyBCDNumberWrapper getCalledPartyBCDNumber() {
        if (this.calledPartyBCDNumberWrapper == null && this.calledPartyBCDNumber != null) {
            this.calledPartyBCDNumberWrapper = new TxCalledPartyBCDNumberWrapper(calledPartyBCDNumber);
        }
        return this.calledPartyBCDNumberWrapper;
    }

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

    @Override
    public boolean hasCallReferenceNumber() {
        return callReferenceNumber != null;
    }

    @Override
    public CallReferenceNumberWrapper getCallReferenceNumber() {
        if (this.callReferenceNumberWrapper == null && this.callReferenceNumber != null) {
            this.callReferenceNumberWrapper = new TxCallReferenceNumberWrapper(callReferenceNumber);
        }
        return this.callReferenceNumberWrapper;
    }

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

    @Override
    public boolean hasExtBasicServiceCode() {
        return extBasicServiceCode != null;
    }

    @Override
    public ExtBasicServiceCodeWrapper getExtBasicServiceCode() {
        if (this.extBasicServiceCodeWrapper == null && extBasicServiceCode != null) {
            this.extBasicServiceCodeWrapper = new TxExtBasicServiceCodeWrapper(extBasicServiceCode);
        }
        return this.extBasicServiceCodeWrapper;
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
    public boolean hasLocationInformation() {
        return locationInformation != null;
    }

    @Override
    public MAPLocationInformationWrapper getLocationInformation() {
        if (this.locationInformationWrapper == null && this.locationInformation != null) {
            this.locationInformationWrapper = new TxMAPLocationInformationWrapper(locationInformation);
        }
        return this.locationInformationWrapper;
    }

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

    @Override
    public boolean hasMscAddress() {
        return mscAddress != null;
    }

    @Override
    public ISDNAddressStringWrapper getMscAddress() {
        if (this.mscAddressWrapper == null && this.mscAddress != null) {
            this.mscAddressWrapper = new TxISDNAddressStringWrapperImpl(mscAddress);
        }
        return this.mscAddressWrapper;
    }

    public CalledPartyBCDNumber getTxCalledPartyBCDNumber() {
        return calledPartyBCDNumber;
    }

    public CallReferenceNumber getTxCallReferenceNumber() {
        return callReferenceNumber;
    }

    public ExtBasicServiceCode getTxExtBasicServiceCode() {
        return extBasicServiceCode;
    }

    public IMSI getTxImsi() {
        return imsi;
    }

    public LocationInformation getTxLocationInformation() {
        return locationInformation;
    }

    public ISDNAddressString getTxMscAddress() {
        return mscAddress;
    }

    public void setTxCalledPartyBCDNumber(final CalledPartyBCDNumber calledPartyBCDNumber) {
        this.calledPartyBCDNumber = calledPartyBCDNumber;
        this.calledPartyBCDNumberWrapper = null;
    }

    public void setTxCallReferenceNumber(final CallReferenceNumber callReferenceNumber) {
        this.callReferenceNumber = callReferenceNumber;
        this.callReferenceNumberWrapper = null;
    }

    public void setTxExtBasicServiceCode(final ExtBasicServiceCode extBasicServiceCode) {
        this.extBasicServiceCode = extBasicServiceCode;
        this.extBasicServiceCodeWrapper = null;
    }

    public void setTxImsi(final IMSI imsi) {
        this.imsi = imsi;
        this.imsiWrapper = null;
    }

    public void setTxLocationInformation(final LocationInformation txLocationInformation) {
        this.locationInformation = txLocationInformation;
        this.locationInformationWrapper = null;
    }

    public void setTxMscAddress(final ISDNAddressString mscAddress) {
        this.mscAddress = mscAddress;
        this.mscAddressWrapper = null;
    }

}
