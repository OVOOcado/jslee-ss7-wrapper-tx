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

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.RequestReportBCSMEventRequest;
import pl.ovoo.jslee.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.jslee.ss7.wrapper.cap.args.RequestReportBCSMEventArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.event.RequestReportBCSMEventRequestEventWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxRequestReportBCSMEventArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap1.TxCap1RequestReportBCSMEventArgWrapper;

import javax.slee.ActivityContextInterface;


/**
 * TxRequestReportBCSMEventRequestEventWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxRequestReportBCSMEventRequestEventWrapper extends TxEventWrapper implements RequestReportBCSMEventRequestEventWrapper {

    /** The request report bcsm event request. */
    private final RequestReportBCSMEventRequest requestReportBCSMEventRequest;

    /**
     * Instantiates a new tx request report bcsm event request event wrapper.
     *
     * @param requestReportBCSMEventRequest the request report bcsm event request
     * @param aci the aci
     */
    public TxRequestReportBCSMEventRequestEventWrapper(final RequestReportBCSMEventRequest requestReportBCSMEventRequest, final ActivityContextInterface aci) {
        super(aci, requestReportBCSMEventRequest);
        this.requestReportBCSMEventRequest = requestReportBCSMEventRequest;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.event.ArgumentEventWrapper#getArgument()
     */
    @Override
    public RequestReportBCSMEventArgWrapper getArgument() throws Ss7WrapperException {
        final TxRequestReportBCSMEventArgWrapper requestReportBCSMEventArgWrapper = new TxCap1RequestReportBCSMEventArgWrapper();
        requestReportBCSMEventArgWrapper.setTxBcsmEvents(requestReportBCSMEventRequest.getBCSMEventList());
        return requestReportBCSMEventArgWrapper;
    }
}
