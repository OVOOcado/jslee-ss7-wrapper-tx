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

import org.mobicents.protocols.ss7.cap.api.isup.CalledPartyNumberCap;
import org.mobicents.protocols.ss7.cap.api.isup.OriginalCalledNumberCap;
import org.mobicents.protocols.ss7.cap.api.isup.RedirectingPartyIDCap;
import org.mobicents.protocols.ss7.inap.api.isup.RedirectionInformationInap;
import pl.ovoo.jslee.ss7.wrapper.cap.args.CalledPartyNumberWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.ConnectArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.OriginalCalledNumberWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.RedirectingPartyNumberWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.RedirectionInformationWrapper;

import java.util.ArrayList;

/**
 * TxConnectArgWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxConnectArgWrapper implements ConnectArgWrapper {

    private transient OriginalCalledNumberWrapper originalCalledPartyID = null;
    private transient CalledPartyNumberWrapper[] destinationRoutingAddress = null;
    private transient RedirectingPartyNumberWrapper redirectingPartyID = null;
    private transient RedirectionInformationWrapper redirectionInformationWrapper = null;

    private OriginalCalledNumberCap txOriginalCalledPartyID;
    private RedirectingPartyIDCap txRedirectingPartyIDCap;
    private RedirectionInformationInap txRedirectionInformationInap;
    private ArrayList<CalledPartyNumberCap> txDestinationRoutingAddress;

    @Override
    public void setOriginalCalledPartyID(final OriginalCalledNumberWrapper originalCalledPartyID) {
        if (originalCalledPartyID == null) {
            this.txOriginalCalledPartyID = null;
            this.originalCalledPartyID = null;
        } else {
            final TxOriginalCalledNumberWrapper txOriginalCalledNumberWrapper = (TxOriginalCalledNumberWrapper) originalCalledPartyID;
            this.txOriginalCalledPartyID = txOriginalCalledNumberWrapper.getTxOriginalCalledNumber();
            this.originalCalledPartyID = txOriginalCalledNumberWrapper;
        }

    }

    @Override
    public OriginalCalledNumberWrapper getOriginalCalledPartyID() {
        if (this.originalCalledPartyID == null && txOriginalCalledPartyID != null) {
            this.originalCalledPartyID = new TxOriginalCalledNumberWrapper(txOriginalCalledPartyID);
        }
        return this.originalCalledPartyID;
    }

    @Override
    public void setRedirectingPartyID(final RedirectingPartyNumberWrapper redirectingPartyID) {
        if (redirectingPartyID == null) {
            this.txRedirectingPartyIDCap = null;
            this.redirectingPartyID = null;
        } else {
            final TxRedirectingPartyNumberWrapper txRedirectingPartyNumberWrapper = (TxRedirectingPartyNumberWrapper) redirectingPartyID;
            this.txRedirectingPartyIDCap = txRedirectingPartyNumberWrapper.getTxRedirectingPartyNumber();
            this.redirectingPartyID = txRedirectingPartyNumberWrapper;
        }
    }

    public RedirectingPartyNumberWrapper getRedirectingPartyID() {
        if (this.redirectingPartyID == null && txRedirectingPartyIDCap != null) {
            this.redirectingPartyID = new TxRedirectingPartyNumberWrapper(txRedirectingPartyIDCap);
        }
        return this.redirectingPartyID;
    }

    @Override
    public void setRedirectionInformation(final RedirectionInformationWrapper redirectionInformation) {
        if (redirectionInformation == null) {
            this.txRedirectionInformationInap = null;
            this.redirectionInformationWrapper = null;
        } else {
            final TxRedirectionInformationWrapper txRedirectionInformationWrapper = (TxRedirectionInformationWrapper) redirectionInformation;
            this.txRedirectionInformationInap = txRedirectionInformationWrapper.getTxRedirectionInformation();
            this.redirectionInformationWrapper = txRedirectionInformationWrapper;
        }
    }

    public RedirectionInformationWrapper getRedirectionInformationWrapper() {
        return this.redirectionInformationWrapper;
    }

    @Override
    public void setDestinationRoutingAddress(final CalledPartyNumberWrapper[] destinationRoutingAddress) {
        if (destinationRoutingAddress == null || destinationRoutingAddress.length == 0) {
            this.txDestinationRoutingAddress = null;
            this.destinationRoutingAddress = null;
        } else {
            this.txDestinationRoutingAddress = new ArrayList<CalledPartyNumberCap>();
            this.destinationRoutingAddress = new CalledPartyNumberWrapper[destinationRoutingAddress.length];
            for (int i = 0; i < destinationRoutingAddress.length; i++) {
                final TxCalledPartyNumberWrapper txCalledPartyNumberWrapper = (TxCalledPartyNumberWrapper) destinationRoutingAddress[i];
                this.txDestinationRoutingAddress.add(txCalledPartyNumberWrapper.getTxCalledPartyNumber());
                this.destinationRoutingAddress[i] = txCalledPartyNumberWrapper;
            }
        }
    }

    @Override
    public CalledPartyNumberWrapper[] getDestinationRoutingAddress() {
        if (this.destinationRoutingAddress == null && txDestinationRoutingAddress != null) {
            final CalledPartyNumberWrapper[] calledPartyNumberWrappers = new CalledPartyNumberWrapper[txDestinationRoutingAddress
                    .size()];
            for (int i = 0; i < txDestinationRoutingAddress.size(); i++) {
                calledPartyNumberWrappers[i] = new TxCalledPartyNumberWrapper(txDestinationRoutingAddress.get(i));
            }
            this.destinationRoutingAddress = calledPartyNumberWrappers;
        }
        return this.destinationRoutingAddress;
    }

    public OriginalCalledNumberCap getTxOriginalCalledPartyID() {
        return txOriginalCalledPartyID;
    }

    public void setTxOriginalCalledPartyID(final OriginalCalledNumberCap txOriginalCalledPartyID) {
        this.originalCalledPartyID = null;
        this.txOriginalCalledPartyID = txOriginalCalledPartyID;
    }

    public RedirectingPartyIDCap getTxRedirectingPartyIDCap() {
        return txRedirectingPartyIDCap;
    }

    public void setTxRedirectingPartyIDCap(final RedirectingPartyIDCap txRedirectingPartyIDCap) {
        this.redirectingPartyID = null;
        this.txRedirectingPartyIDCap = txRedirectingPartyIDCap;
    }

    public RedirectionInformationInap getTxRedirectionInformationInap() {
        return txRedirectionInformationInap;
    }

    public void setTxRedirectionInformationInap(final RedirectionInformationInap txRedirectionInformationInap) {
        this.redirectionInformationWrapper = null;
        this.txRedirectionInformationInap = txRedirectionInformationInap;
    }

    public ArrayList<CalledPartyNumberCap> getTxDestinationRoutingAddress() {
        return txDestinationRoutingAddress;
    }

    public void setTxDestinationRoutingAddress(final ArrayList<CalledPartyNumberCap> txDestinationRoutingAddress) {
        this.destinationRoutingAddress = null;
        this.txDestinationRoutingAddress = txDestinationRoutingAddress;
    }

    @Override
    public String toString() {
        return "TxConnectArgWrapper [txOriginalCalledPartyID=" + txOriginalCalledPartyID + ", txRedirectingPartyIDCap="
                + txRedirectingPartyIDCap + ", txRedirectionInformationInap=" + txRedirectionInformationInap
                + ", txDestinationRoutingAddress=" + txDestinationRoutingAddress + "]";
    }

}
