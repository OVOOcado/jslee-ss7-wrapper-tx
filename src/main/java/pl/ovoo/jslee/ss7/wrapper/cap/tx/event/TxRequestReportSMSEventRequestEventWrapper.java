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

import org.mobicents.protocols.ss7.cap.api.service.sms.RequestReportSMSEventRequest;
import org.mobicents.protocols.ss7.cap.api.service.sms.primitive.SMSEvent;
import pl.ovoo.jslee.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.jslee.ss7.wrapper.cap.args.RequestReportSMSEventArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.SMSEventWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.event.RequestReportSMSEventRequestEventWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxRequestReportSMSEventArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxSMSEventWrapper;

import javax.slee.ActivityContextInterface;


/**
 * TxRequestReportSMSEventRequestEventWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxRequestReportSMSEventRequestEventWrapper extends TxEventWrapper implements RequestReportSMSEventRequestEventWrapper {

    /** The request report sms event request. */
    private final RequestReportSMSEventRequest requestReportSMSEventRequest;

    /**
     * Instantiates a new tx request report sms event request event wrapper.
     *
     * @param requestReportSMSEventRequest the request report sms event request
     * @param aci the aci
     */
    public TxRequestReportSMSEventRequestEventWrapper(final RequestReportSMSEventRequest requestReportSMSEventRequest, final ActivityContextInterface aci) {
        super(aci, requestReportSMSEventRequest);
        this.requestReportSMSEventRequest = requestReportSMSEventRequest;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.event.ArgumentEventWrapper#getArgument()
     */
    @Override
    public RequestReportSMSEventArgWrapper getArgument() throws Ss7WrapperException {
    	if (requestReportSMSEventRequest.getSMSEvents() == null || requestReportSMSEventRequest.getSMSEvents().isEmpty()) {
            return null;
        } else {
            final SMSEventWrapper[] smsEventWrappers = new SMSEventWrapper[requestReportSMSEventRequest.getSMSEvents().size()];
            int i = 0;
            for (final SMSEvent smsEvent : requestReportSMSEventRequest.getSMSEvents()) {
            	smsEventWrappers[i] = new TxSMSEventWrapper(smsEvent);
                i++;
            }
            return new TxRequestReportSMSEventArgWrapper(smsEventWrappers);
        }
    }
}
