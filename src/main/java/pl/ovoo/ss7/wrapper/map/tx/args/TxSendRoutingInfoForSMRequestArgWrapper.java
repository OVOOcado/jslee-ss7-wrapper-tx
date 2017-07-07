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

package pl.ovoo.ss7.wrapper.map.telestax.args;

import org.mobicents.protocols.ss7.map.api.primitives.AddressString;
import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;
import pl.ovoo.ss7.wrapper.common.args.AddressStringWrapper;
import pl.ovoo.ss7.wrapper.common.args.ISDNAddressStringWrapper;
import pl.ovoo.ss7.wrapper.common.telestax.TxAddressStringWrapperImpl;
import pl.ovoo.ss7.wrapper.common.telestax.TxISDNAddressStringWrapperImpl;
import pl.ovoo.ss7.wrapper.map.args.SendRoutingInfoForSMRequestArgWrapper;

/**
 * Created by karolsimka on 07.06.17.
 */
public class TxSendRoutingInfoForSMRequestArgWrapper implements SendRoutingInfoForSMRequestArgWrapper {
    private transient ISDNAddressStringWrapper isdnAddressStringWrapper = null;
    private transient AddressStringWrapper addressStringWrapper = null;

    private ISDNAddressString msisdn;
    private AddressString scAddress;

    public TxSendRoutingInfoForSMRequestArgWrapper() {
        super();
    }

    @Override
    public ISDNAddressStringWrapper getMsisdn() {
        if (this.isdnAddressStringWrapper == null && this.msisdn != null) {
            this.isdnAddressStringWrapper = new TxISDNAddressStringWrapperImpl(msisdn);
        }
        return this.isdnAddressStringWrapper;
    }

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

    public ISDNAddressString getTxMsisdn() {
        return this.msisdn;
    }

    public void setTxMsisdn(ISDNAddressString msisdn) {
        this.msisdn = msisdn;
    }

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
    public AddressStringWrapper getScAddress() {
        if (this.addressStringWrapper == null && this.scAddress != null) {
            this.addressStringWrapper = new TxAddressStringWrapperImpl(scAddress);
        }
        return this.addressStringWrapper;
    }

    public AddressString getTxScAddress() {
        return this.scAddress;
    }

    public void setTxScAddress(AddressString scAddress) {
        this.scAddress = scAddress;
    }

    @Override
    public String toString() {
        return "TxSendRoutingInfoForSMRequestArgWrapper [msisdn=" + msisdn + "]";
    }


}
