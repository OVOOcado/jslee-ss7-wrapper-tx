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

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.CallInformationRequestRequest;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxCallInformationRequestArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap2.TxCap2CallInformationRequestArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.jslee.ss7.wrapper.cap.args.CallInformationRequestArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.event.CallInformationRequestRequestEventWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxCallInformationRequestRequestEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCallInformationRequestRequestEventWrapper extends TxEventWrapper implements CallInformationRequestRequestEventWrapper {

    private final CallInformationRequestRequest callInformationRequestRequest;

    public TxCallInformationRequestRequestEventWrapper(final CallInformationRequestRequest callInformationRequestRequest, final ActivityContextInterface aci) {
        super(aci, callInformationRequestRequest);
        this.callInformationRequestRequest = callInformationRequestRequest;
    }

    @Override
    public CallInformationRequestArgWrapper getArgument() throws Ss7WrapperException {
        final TxCallInformationRequestArgWrapper txCallInformationRequestArgWrapper;
        switch (getTxDialog().getApplicationContext()) {
            case CapV1_gsmSSF_to_gsmSCF:
                txCallInformationRequestArgWrapper = new TxCallInformationRequestArgWrapper();
                break;
            case CapV2_assistGsmSSF_to_gsmSCF:
            case CapV2_gsmSRF_to_gsmSCF:
            case CapV2_gsmSSF_to_gsmSCF:
                txCallInformationRequestArgWrapper = new TxCap2CallInformationRequestArgWrapper();
                break;
            default:
                txCallInformationRequestArgWrapper = new TxCap2CallInformationRequestArgWrapper();
        }
        txCallInformationRequestArgWrapper.setTxRequestedInformationTypes(callInformationRequestRequest.getRequestedInformationTypeList());
        if (txCallInformationRequestArgWrapper instanceof TxCap2CallInformationRequestArgWrapper) {
            ((TxCap2CallInformationRequestArgWrapper) txCallInformationRequestArgWrapper).setTxLegID(callInformationRequestRequest.getLegID());
        }
        return txCallInformationRequestArgWrapper;
    }
}
