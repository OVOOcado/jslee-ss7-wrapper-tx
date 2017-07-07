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

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.CallInformationReportRequest;
import pl.ovoo.ss7.wrapper.cap.args.CallInformationReportArgWrapper;
import pl.ovoo.ss7.wrapper.cap.event.CallInformationReportRequestEventWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxCallInformationReportArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap2.TxCap2CallInformationReportArgWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxCallInformationReportRequestEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCallInformationReportRequestEventWrapper extends TxEventWrapper implements CallInformationReportRequestEventWrapper {

    private final CallInformationReportRequest callInformationReportRequestEvent;

    public TxCallInformationReportRequestEventWrapper(final CallInformationReportRequest callInformationReportRequestEvent, final ActivityContextInterface aci) {
        super(aci, callInformationReportRequestEvent);
        this.callInformationReportRequestEvent = callInformationReportRequestEvent;
    }

    @Override
    public CallInformationReportArgWrapper getArgument() {
        final TxCallInformationReportArgWrapper txCallInformationReportArgWrapper;
        switch (getTxDialog().getApplicationContext()) {
            case CapV1_gsmSSF_to_gsmSCF:
                txCallInformationReportArgWrapper = new TxCallInformationReportArgWrapper();
                break;
            case CapV2_assistGsmSSF_to_gsmSCF:
            case CapV2_gsmSRF_to_gsmSCF:
            case CapV2_gsmSSF_to_gsmSCF:
                txCallInformationReportArgWrapper = new TxCap2CallInformationReportArgWrapper();
                break;
            default:
                txCallInformationReportArgWrapper = new TxCap2CallInformationReportArgWrapper();
        }

        txCallInformationReportArgWrapper.setTxRequestedInformation(callInformationReportRequestEvent.getRequestedInformationList());
        if (txCallInformationReportArgWrapper instanceof TxCap2CallInformationReportArgWrapper) {
            ((TxCap2CallInformationReportArgWrapper) txCallInformationReportArgWrapper).setTxLegID(callInformationReportRequestEvent.getLegID());
        }
        return txCallInformationReportArgWrapper;
    }
}
