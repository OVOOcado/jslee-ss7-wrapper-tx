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
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.AssistRequestInstructionsRequest;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.AssistRequestInstructionsArgWrapper;
import pl.ovoo.ss7.wrapper.cap.event.AssistRequestInstructionsRequestEventWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxAssistRequestInstructionsArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap2.TxCap2AssistRequestInstructionsArgWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxAssistRequestInstructionsRequestEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxAssistRequestInstructionsRequestEventWrapper extends TxEventWrapper implements AssistRequestInstructionsRequestEventWrapper {

    private final AssistRequestInstructionsRequest assistRequestInstructionsRequest;

    public TxAssistRequestInstructionsRequestEventWrapper(final AssistRequestInstructionsRequest assistRequestInstructionsRequest, final ActivityContextInterface aci) {
        super(aci, assistRequestInstructionsRequest);
        this.assistRequestInstructionsRequest = assistRequestInstructionsRequest;
    }

    @Override
    public AssistRequestInstructionsArgWrapper getArgument() throws Ss7WrapperException {
        try {
            final TxAssistRequestInstructionsArgWrapper txAssistRequestInstructionsArgWrapper;
            switch (getTxDialog().getApplicationContext()) {
                case CapV1_gsmSSF_to_gsmSCF:
                    txAssistRequestInstructionsArgWrapper = new TxAssistRequestInstructionsArgWrapper();
                    break;
                case CapV2_assistGsmSSF_to_gsmSCF:
                case CapV2_gsmSRF_to_gsmSCF:
                case CapV2_gsmSSF_to_gsmSCF:
                    txAssistRequestInstructionsArgWrapper = new TxCap2AssistRequestInstructionsArgWrapper();
                    break;
                default:
                    txAssistRequestInstructionsArgWrapper = new TxCap2AssistRequestInstructionsArgWrapper();
            }

            if (txAssistRequestInstructionsArgWrapper instanceof TxCap2AssistRequestInstructionsArgWrapper) {
                ((TxCap2AssistRequestInstructionsArgWrapper) txAssistRequestInstructionsArgWrapper).
                        setTxIpsspCapabilities(assistRequestInstructionsRequest.getIPSSPCapabilities());
            }

            if (assistRequestInstructionsRequest.getCorrelationID() != null) {
                txAssistRequestInstructionsArgWrapper.setTxCorrelationID(assistRequestInstructionsRequest.getCorrelationID().getGenericNumber());
            }
            return txAssistRequestInstructionsArgWrapper;
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }

    }
}
