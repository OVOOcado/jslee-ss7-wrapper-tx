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

package pl.ovoo.ss7.wrapper.map.tx.args;

import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;

import pl.ovoo.ss7.wrapper.common.args.ISDNAddressStringWrapper;
import pl.ovoo.ss7.wrapper.common.tx.TxISDNAddressStringWrapperImpl;
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
