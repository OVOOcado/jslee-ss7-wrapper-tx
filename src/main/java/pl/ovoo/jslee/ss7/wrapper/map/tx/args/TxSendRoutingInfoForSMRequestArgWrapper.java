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

import org.mobicents.protocols.ss7.map.api.primitives.AddressString;
import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;
import pl.ovoo.jslee.ss7.wrapper.common.args.AddressStringWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.args.ISDNAddressStringWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.tx.TxAddressStringWrapperImpl;
import pl.ovoo.jslee.ss7.wrapper.common.tx.TxISDNAddressStringWrapperImpl;
import pl.ovoo.jslee.ss7.wrapper.map.args.SendRoutingInfoForSMRequestArgWrapper;


/**
 * Created by karolsimka on 07.06.17.
 */
public class TxSendRoutingInfoForSMRequestArgWrapper implements SendRoutingInfoForSMRequestArgWrapper {
    
    /** The isdn address string wrapper. */
    private transient ISDNAddressStringWrapper isdnAddressStringWrapper = null;
    
    /** The address string wrapper. */
    private transient AddressStringWrapper addressStringWrapper = null;

    /** The msisdn. */
    private ISDNAddressString msisdn;
    
    /** The sc address. */
    private AddressString scAddress;

    /**
     * Instantiates a new tx send routing info for sm request arg wrapper.
     */
    public TxSendRoutingInfoForSMRequestArgWrapper() {
        super();
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.SendRoutingInfoForSMRequestArgWrapper#getMsisdn()
     */
    @Override
    public ISDNAddressStringWrapper getMsisdn() {
        if (this.isdnAddressStringWrapper == null && this.msisdn != null) {
            this.isdnAddressStringWrapper = new TxISDNAddressStringWrapperImpl(msisdn);
        }
        return this.isdnAddressStringWrapper;
    }

    /**
     * Sets the msisdn.
     *
     * @param msisdn the new msisdn
     */
    public void setMsisdn(ISDNAddressStringWrapper msisdn) {
        if (msisdn == null) {
            this.msisdn = null;
            this.isdnAddressStringWrapper = null;
        }else {
            TxISDNAddressStringWrapperImpl txMsisdn = (TxISDNAddressStringWrapperImpl) msisdn;
            this.msisdn = txMsisdn.getTxAddress();
            this.isdnAddressStringWrapper = txMsisdn;
        }
    }

    /**
     * Gets the tx msisdn.
     *
     * @return the tx msisdn
     */
    public ISDNAddressString getTxMsisdn() {
        return this.msisdn;
    }

    /**
     * Sets the tx msisdn.
     *
     * @param msisdn the new tx msisdn
     */
    public void setTxMsisdn(ISDNAddressString msisdn) {
        this.msisdn = msisdn;
    }

    /**
     * Sets the sc address.
     *
     * @param scAddress the new sc address
     */
    public void setScAddress(AddressStringWrapper scAddress) {
        if (scAddress == null) {
            this.scAddress = null;
            this.addressStringWrapper = null;
        }else {
            TxAddressStringWrapperImpl txScAdddress = (TxAddressStringWrapperImpl) scAddress;
            this.scAddress = txScAdddress.getTxAddress();
            this.addressStringWrapper = txScAdddress;
        }
    }
    
    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.SendRoutingInfoForSMRequestArgWrapper#getScAddress()
     */
    public AddressStringWrapper getScAddress() {
        if (this.addressStringWrapper == null && this.scAddress != null) {
            this.addressStringWrapper = new TxAddressStringWrapperImpl(scAddress);
        }
        return this.addressStringWrapper;
    }

    /**
     * Gets the tx sc address.
     *
     * @return the tx sc address
     */
    public AddressString getTxScAddress() {
        return this.scAddress;
    }

    /**
     * Sets the tx sc address.
     *
     * @param scAddress the new tx sc address
     */
    public void setTxScAddress(AddressString scAddress) {
        this.scAddress = scAddress;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TxSendRoutingInfoForSMRequestArgWrapper [msisdn=" + msisdn + "]";
    }


}
