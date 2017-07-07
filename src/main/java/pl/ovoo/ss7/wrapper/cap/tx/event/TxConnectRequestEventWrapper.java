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

package pl.ovoo.ss7.wrapper.cap.telestax.event;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.ConnectRequest;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.ConnectArgWrapper;
import pl.ovoo.ss7.wrapper.cap.event.ConnectRequestEventWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.cap1.TxCap1ConnectArgWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.cap2.TxCap2ConnectArgWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.cap3.TxCap3ConnectArgWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxConnectRequestEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxConnectRequestEventWrapper extends TxEventWrapper implements ConnectRequestEventWrapper {

    private final ConnectRequest connectRequest;

    public TxConnectRequestEventWrapper(final ConnectRequest connectRequest, final ActivityContextInterface aci) {
        super(aci, connectRequest);
        this.connectRequest = connectRequest;
    }

    @Override
    public ConnectArgWrapper getArgument() throws Ss7WrapperException {
        final TxCap1ConnectArgWrapper connectArgWrapper;
        switch (getTxDialog().getApplicationContext()) {
            case CapV1_gsmSSF_to_gsmSCF:
                connectArgWrapper = new TxCap1ConnectArgWrapper();
                break;
            case CapV2_assistGsmSSF_to_gsmSCF:
            case CapV2_gsmSRF_to_gsmSCF:
            case CapV2_gsmSSF_to_gsmSCF:
                connectArgWrapper = new TxCap2ConnectArgWrapper();
                break;
            default:
                connectArgWrapper = new TxCap3ConnectArgWrapper();
        }
        if (connectRequest.getDestinationRoutingAddress() != null) {
            connectArgWrapper.setTxDestinationRoutingAddress(connectRequest.getDestinationRoutingAddress().getCalledPartyNumber());
        }
        connectArgWrapper.setTxOriginalCalledPartyID(connectRequest.getOriginalCalledPartyID());
        connectArgWrapper.setTxRedirectingPartyIDCap(connectRequest.getRedirectingPartyID());
        connectArgWrapper.setTxRedirectionInformationInap(connectRequest.getRedirectionInformation());

        return connectArgWrapper;
    }
}
