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

package pl.ovoo.jslee.ss7.wrapper.map.tx.args;

import org.mobicents.protocols.ss7.map.api.primitives.IMSI;
import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;
import pl.ovoo.jslee.ss7.wrapper.common.args.IMSIAddressWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.args.ISDNAddressStringWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.tx.TxIMSIAddressWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.tx.TxISDNAddressStringWrapperImpl;
import pl.ovoo.jslee.ss7.wrapper.map.args.SendRoutingInfoForSMResponseWrapper;


/**
 * Created by karolsimka on 07.06.17.
 */
public class TxSendRoutingInfoForSMResponseWrapper implements SendRoutingInfoForSMResponseWrapper {

    /** The imsi address wrapper. */
    private transient IMSIAddressWrapper imsiAddressWrapper = null;
    
    /** The msc address wrapper. */
    private transient ISDNAddressStringWrapper mscAddressWrapper = null;
    //private transient ISDNAddressStringWrapper sgsnAddressWrapper = null;

    /** The imsi. */
    private IMSI imsi;
    
    /** The msc address. */
    private ISDNAddressString mscAddress;
    //private ISDNAddressString sgsnAddress;

    /**
     * Instantiates a new tx send routing info for sm response wrapper.
     */
    public TxSendRoutingInfoForSMResponseWrapper() {
        super();
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.SendRoutingInfoForSMResponseWrapper#getIMSI()
     */
    @Override
    public IMSIAddressWrapper getIMSI() {
        if (this.imsiAddressWrapper == null && this.imsi != null) {
            this.imsiAddressWrapper = new TxIMSIAddressWrapper(imsi);
        }
        return this.imsiAddressWrapper;
    }

    /**
     * Sets the imsi.
     *
     * @param imsi the new imsi
     */
    public void setImsi(IMSIAddressWrapper imsi) {
        if (imsi == null) {
            this.imsi = null;
            this.imsiAddressWrapper = null;
        } else {
            TxIMSIAddressWrapper txImsi = (TxIMSIAddressWrapper) imsi;
            this.imsi = txImsi.getTxImsi();
            this.imsiAddressWrapper = txImsi;
        }
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.SendRoutingInfoForSMResponseWrapper#getMscAddress()
     */
    @Override
    public ISDNAddressStringWrapper getMscAddress() {
        if (this.mscAddressWrapper == null && this.mscAddress != null) {
            this.mscAddressWrapper = new TxISDNAddressStringWrapperImpl(mscAddress);
        }
        return this.mscAddressWrapper;
    }

    /**
     * Sets the msc address.
     *
     * @param mscAddress the new msc address
     */
    public void setMscAddress(ISDNAddressStringWrapper mscAddress) {
        if (mscAddress == null) {
            this.mscAddress = null;
            this.mscAddressWrapper = null;
        } else {
            TxISDNAddressStringWrapperImpl txMscAddress = (TxISDNAddressStringWrapperImpl) mscAddress;
            this.mscAddress = txMscAddress.getTxAddress();
            this.mscAddressWrapper = txMscAddress;
        }
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
     * Sets the tx imsi.
     *
     * @param imsi the new tx imsi
     */
    public void setTxImsi(IMSI imsi) {
        this.imsi = imsi;
        this.imsiAddressWrapper = null;
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
     * Sets the tx msc address.
     *
     * @param mscAddress the new tx msc address
     */
    public void setTxMscAddress(ISDNAddressString mscAddress) {
        this.mscAddress = mscAddress;
        this.mscAddressWrapper = null;
    }
//
//    @Override
//    public ISDNAddressStringWrapper getSgsnAddress() {
//        if (this.sgsnAddressWrapper == null && this.sgsnAddress != null) {
//            this.sgsnAddressWrapper = new TxISDNAddressStringWrapperImpl(sgsnAddress);
//        }
//        return this.sgsnAddressWrapper;
//    }
//
//    public void setSgsnAddress(ISDNAddressStringWrapper sgsnAddress) {
//        if (sgsnAddress == null) {
//            this.sgsnAddress = null;
//            this.sgsnAddressWrapper = null;
//        } else {
//            TxISDNAddressStringWrapperImpl txSgsnAddress = (TxISDNAddressStringWrapperImpl) mscAddress;
//            this.mscAddress = txMscAddress.getTxAddress();
//            this.mscAddressWrapper = txMscAddress;
//        }
//    }
//
//    public ISDNAddressString getTxSgsnAddress() {
//        return mscAddress;
//    }
//
//    public void setTxSgsnAddress(ISDNAddressString mscAddress) {
//        this.mscAddress = mscAddress;
//        this.mscAddressWrapper = null;
//    }

    /* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
    public String toString() {
        return "TxSendRoutingInfoForSMResponseWrapper [imsi=" + imsi + ", mscAddress=" + mscAddress + "]";
    }

}
