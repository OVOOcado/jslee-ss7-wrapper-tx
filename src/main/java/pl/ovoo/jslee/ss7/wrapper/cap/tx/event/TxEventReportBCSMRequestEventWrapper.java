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

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.EventReportBCSMRequest;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxEventReportBCSMArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap1.TxCap1EventReportBCSMArgWrapper;
import pl.ovoo.ss7.wrapper.cap.args.EventReportBCSMArgWrapper;
import pl.ovoo.ss7.wrapper.cap.event.EventReportBCSMRequestEventWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxEventReportBCSMRequestEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxEventReportBCSMRequestEventWrapper extends TxEventWrapper implements EventReportBCSMRequestEventWrapper {

    private final EventReportBCSMRequest ccEventReportBCSMRequestEvent;

    public TxEventReportBCSMRequestEventWrapper(final EventReportBCSMRequest ccEventReportBCSMRequestEvent, final ActivityContextInterface aci) {
        super(aci, ccEventReportBCSMRequestEvent);
        this.ccEventReportBCSMRequestEvent = ccEventReportBCSMRequestEvent;
    }

    @Override
    public EventReportBCSMArgWrapper getArgument() {
        final TxEventReportBCSMArgWrapper eventReportBCSMArgWrapper;
        switch (getTxDialog().getApplicationContext()) {
            case CapV1_gsmSSF_to_gsmSCF:
                eventReportBCSMArgWrapper = new TxCap1EventReportBCSMArgWrapper();
                break;
            case CapV2_assistGsmSSF_to_gsmSCF:
            case CapV2_gsmSRF_to_gsmSCF:
            case CapV2_gsmSSF_to_gsmSCF:
                eventReportBCSMArgWrapper = new TxCap1EventReportBCSMArgWrapper();
                break;
            default:
                eventReportBCSMArgWrapper = new TxCap1EventReportBCSMArgWrapper();
        }
        eventReportBCSMArgWrapper.setTxEventSpecificInformationBCSM(ccEventReportBCSMRequestEvent.getEventSpecificInformationBCSM());
        eventReportBCSMArgWrapper.setTxEventTypeBCSM(ccEventReportBCSMRequestEvent.getEventTypeBCSM());
        eventReportBCSMArgWrapper.setTxLegID(ccEventReportBCSMRequestEvent.getLegID());
        eventReportBCSMArgWrapper.setTxMiscCallInfo(ccEventReportBCSMRequestEvent.getMiscCallInfo());
        return eventReportBCSMArgWrapper;
    }
}
