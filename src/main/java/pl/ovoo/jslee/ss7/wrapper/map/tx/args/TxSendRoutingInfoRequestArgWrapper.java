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

import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;

import pl.ovoo.jslee.ss7.wrapper.common.args.ISDNAddressStringWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.tx.TxISDNAddressStringWrapperImpl;
import pl.ovoo.jslee.ss7.wrapper.map.args.SendRoutingInfoRequestArgWrapper;


/**
 * TxSendRoutingInfoRequestArgWrapper.
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxSendRoutingInfoRequestArgWrapper implements SendRoutingInfoRequestArgWrapper {
    
    /** The msisdn wrapper. */
    private transient ISDNAddressStringWrapper msisdnWrapper = null;
    
    /** The gmsc address wrapper. */
    private transient ISDNAddressStringWrapper gmscAddressWrapper = null;

    /** The msisdn. */
    private ISDNAddressString msisdn;
    
    /** The gmsc address. */
    private ISDNAddressString gmscAddress;

    /**
     * Instantiates a new tx send routing info request arg wrapper.
     */
    public TxSendRoutingInfoRequestArgWrapper() {
        super();
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.SendRoutingInfoRequestArgWrapper#getMsisdn()
     */
    @Override
    public ISDNAddressStringWrapper getMsisdn() {
        if (this.msisdnWrapper == null && this.msisdn != null) {
            this.msisdnWrapper = new TxISDNAddressStringWrapperImpl(msisdn);
        }
        return this.msisdnWrapper;
    }

    /**
     * Sets the msisdn.
     *
     * @param msisdn the new msisdn
     */
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
        this.msisdnWrapper = null;

    }

    /**
     * Gets the tx gmsc address.
     *
     * @return the tx gmsc address
     */
    public ISDNAddressString getTxGmscAddress() {
        return this.gmscAddress;
    }

    /**
     * Sets the gmsc address.
     *
     * @param gmscAddress the new gmsc address
     */
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

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.SendRoutingInfoRequestArgWrapper#getGmscAddress()
     */
    @Override
    public ISDNAddressStringWrapper getGmscAddress() {
        if (this.gmscAddressWrapper == null && this.gmscAddress != null) {
            this.gmscAddressWrapper = new TxISDNAddressStringWrapperImpl(gmscAddress);
        }
        return this.gmscAddressWrapper;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TxSendRoutingInfoRequestArgWrapper [msisdn=" + msisdn + "]";
    }

}
