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

import org.mobicents.protocols.ss7.cap.api.service.sms.EventReportSMSRequest;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxEventReportSMSArgWrapperImpl;
import pl.ovoo.jslee.ss7.wrapper.cap.args.EventReportSMSArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.event.EventReportSMSRequestEventWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxEventReportSMSRequestEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxEventReportSMSRequestEventWrapper extends TxEventWrapper implements EventReportSMSRequestEventWrapper {

    private final EventReportSMSRequest eventReportSMSRequest;

    public TxEventReportSMSRequestEventWrapper(final EventReportSMSRequest eventReportSMSRequest, final ActivityContextInterface aci) {
        super(aci, eventReportSMSRequest);
        this.eventReportSMSRequest = eventReportSMSRequest;
    }

    @Override
    public EventReportSMSArgWrapper getArgument() {        
        final TxEventReportSMSArgWrapperImpl eventReportSMSArgWrapper = new TxEventReportSMSArgWrapperImpl();
        eventReportSMSArgWrapper.setTxEventSpecificInformationBCSM(eventReportSMSRequest.getEventSpecificInformationSMS());
        eventReportSMSArgWrapper.setTxEventTypeSMS(eventReportSMSRequest.getEventTypeSMS());
        return eventReportSMSArgWrapper;
    }
}
