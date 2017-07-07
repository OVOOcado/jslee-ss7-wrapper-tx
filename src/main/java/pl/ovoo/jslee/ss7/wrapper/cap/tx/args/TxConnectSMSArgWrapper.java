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
import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;
import pl.ovoo.jslee.ss7.wrapper.cap.args.CalledPartyBCDNumberWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.ConnectSMSArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.args.ISDNAddressStringWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.tx.TxISDNAddressStringWrapperImpl;

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
