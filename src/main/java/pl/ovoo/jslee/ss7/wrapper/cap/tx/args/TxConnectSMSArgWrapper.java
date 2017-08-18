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
 * OcRequestReportSMSEventArgWrapperImpl.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxConnectSMSArgWrapper implements ConnectSMSArgWrapper {

    /** The called party bcd number wrapper. */
    private transient CalledPartyBCDNumberWrapper calledPartyBCDNumberWrapper = null;
    
    /** The isdn address string wrapper. */
    private transient ISDNAddressStringWrapper isdnAddressStringWrapper = null;

    /** The destination subscriber number. */
    private CalledPartyBCDNumber destinationSubscriberNumber;
    
    /** The smsc address. */
    private ISDNAddressString smscAddress;

    /**
     * Instantiates a new tx connect sms arg wrapper.
     *
     * @param destinationSubscriberNumber the destination subscriber number
     * @param smscAddress the smsc address
     */
    public TxConnectSMSArgWrapper(final CalledPartyBCDNumber destinationSubscriberNumber,
            ISDNAddressString smscAddress) {
        this.destinationSubscriberNumber = destinationSubscriberNumber;
        this.smscAddress = smscAddress;

    }

    /**
     * Instantiates a new tx connect sms arg wrapper.
     */
    public TxConnectSMSArgWrapper() {

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
     * Gets the tx smsc address.
     *
     * @return the tx smsc address
     */
    public ISDNAddressString getTxSmscAddress() {
        return smscAddress;
    }

    /**
     * Sets the tx destination subscriber number.
     *
     * @param destinationSubscriberNumber the new tx destination subscriber number
     */
    public void setTxDestinationSubscriberNumber(CalledPartyBCDNumber destinationSubscriberNumber) {
        this.destinationSubscriberNumber = destinationSubscriberNumber;
        this.calledPartyBCDNumberWrapper = null;

    }

    /**
     * Sets the tx smsc address.
     *
     * @param smscAddress the new tx smsc address
     */
    public void setTxSmscAddress(ISDNAddressString smscAddress) {
        this.smscAddress = smscAddress;
        this.isdnAddressStringWrapper = null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ConnectSMSArgWrapper#setDestinationSubscriberNumber(pl.ovoo.jslee.ss7.wrapper.cap.args.CalledPartyBCDNumberWrapper)
     */
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

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ConnectSMSArgWrapper#setSMSCAddress(pl.ovoo.jslee.ss7.wrapper.common.args.ISDNAddressStringWrapper)
     */
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

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ConnectSMSArgWrapper#getDestinationSubscriberNumber()
     */
    @Override
    public CalledPartyBCDNumberWrapper getDestinationSubscriberNumber() {
        if (this.calledPartyBCDNumberWrapper == null && destinationSubscriberNumber != null) {
            this.calledPartyBCDNumberWrapper = new TxCalledPartyBCDNumberWrapper(destinationSubscriberNumber);
        }
        return this.calledPartyBCDNumberWrapper;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ConnectSMSArgWrapper#getSMSCAddress()
     */
    @Override
    public ISDNAddressStringWrapper getSMSCAddress() {
        if (this.isdnAddressStringWrapper == null && this.smscAddress != null) {
            this.isdnAddressStringWrapper = new TxISDNAddressStringWrapperImpl(smscAddress);
        }
        return this.isdnAddressStringWrapper;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TxConnectSMSArgWrapper [destinationSubscriberNumber=" + destinationSubscriberNumber + ", smscAddress="
                + smscAddress + "]";
    }

}
