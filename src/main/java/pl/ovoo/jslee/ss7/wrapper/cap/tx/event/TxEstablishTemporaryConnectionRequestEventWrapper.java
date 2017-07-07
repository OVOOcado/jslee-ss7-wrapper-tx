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

package pl.ovoo.jslee.ss7.wrapper.cap.tx.event;

import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.EstablishTemporaryConnectionRequest;
import pl.ovoo.jslee.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.jslee.ss7.wrapper.cap.args.EstablishTemporaryConnectionArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.event.EstablishTemporaryConnectionRequestEventWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxEstablishTemporaryConnectionArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap2.TxCap2EstablishTemporaryConnectionArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap3.TxCap3EstablishTemporaryConnectionArgWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxEstablishTemporaryConnectionRequestEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxEstablishTemporaryConnectionRequestEventWrapper extends TxEventWrapper implements EstablishTemporaryConnectionRequestEventWrapper {

    private final EstablishTemporaryConnectionRequest establishTemporaryConnectionRequest;

    public TxEstablishTemporaryConnectionRequestEventWrapper(final EstablishTemporaryConnectionRequest establishTemporaryConnectionRequest, final ActivityContextInterface aci) {
        super(aci, establishTemporaryConnectionRequest);
        this.establishTemporaryConnectionRequest = establishTemporaryConnectionRequest;
    }

    @Override
    public EstablishTemporaryConnectionArgWrapper getArgument() throws Ss7WrapperException {
        final TxEstablishTemporaryConnectionArgWrapper establishTemporaryConnectionArgWrapper;
        switch (getTxDialog().getApplicationContext()) {
            case CapV1_gsmSSF_to_gsmSCF:
                establishTemporaryConnectionArgWrapper = new TxEstablishTemporaryConnectionArgWrapper();
                break;
            case CapV2_assistGsmSSF_to_gsmSCF:
            case CapV2_gsmSRF_to_gsmSCF:
            case CapV2_gsmSSF_to_gsmSCF:
                establishTemporaryConnectionArgWrapper = new TxCap2EstablishTemporaryConnectionArgWrapper();
                break;
            default:
                establishTemporaryConnectionArgWrapper = new TxCap3EstablishTemporaryConnectionArgWrapper();
        }
        try {
            if (establishTemporaryConnectionRequest.getAssistingSSPIPRoutingAddress()!= null) {
                    establishTemporaryConnectionArgWrapper.setTxAssistingSSPIPRoutingAddress(establishTemporaryConnectionRequest.getAssistingSSPIPRoutingAddress().getGenericNumber());
            }
            if (establishTemporaryConnectionRequest.getCorrelationID()!= null) {
                establishTemporaryConnectionArgWrapper.setTxAssistingDialogCorrelationID(establishTemporaryConnectionRequest.getCorrelationID().getGenericDigits());
            }
            return establishTemporaryConnectionArgWrapper;

        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }
}
