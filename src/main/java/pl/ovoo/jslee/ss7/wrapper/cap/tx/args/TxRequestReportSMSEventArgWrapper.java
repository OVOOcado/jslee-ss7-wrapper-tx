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

import pl.ovoo.jslee.ss7.wrapper.cap.args.RequestReportSMSEventArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.SMSEventWrapper;


/**
 * OcRequestReportSMSEventArgWrapperImpl.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxRequestReportSMSEventArgWrapper implements RequestReportSMSEventArgWrapper {

    /** The sms event wrappers. */
    private final SMSEventWrapper[] smsEventWrappers;

    /**
     * Instantiates a new tx request report sms event arg wrapper.
     *
     * @param smsEventWrappers the sms event wrappers
     */
    public TxRequestReportSMSEventArgWrapper(final SMSEventWrapper[] smsEventWrappers) {
        this.smsEventWrappers = smsEventWrappers;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.RequestReportSMSEventArgWrapper#getSMSEvents()
     */
    @Override
    public SMSEventWrapper[] getSMSEvents() {
        return smsEventWrappers;
    }

}
