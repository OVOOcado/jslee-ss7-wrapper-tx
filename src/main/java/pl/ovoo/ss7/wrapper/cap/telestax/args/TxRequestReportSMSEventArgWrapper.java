/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import pl.ovoo.ss7.wrapper.cap.args.RequestReportSMSEventArgWrapper;
import pl.ovoo.ss7.wrapper.cap.args.SMSEventWrapper;

/**
 * OcRequestReportSMSEventArgWrapperImpl
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxRequestReportSMSEventArgWrapper implements RequestReportSMSEventArgWrapper {

    private final SMSEventWrapper[] smsEventWrappers;

    public TxRequestReportSMSEventArgWrapper(final SMSEventWrapper[] smsEventWrappers) {
        this.smsEventWrappers = smsEventWrappers;
    }

    @Override
    public SMSEventWrapper[] getSMSEvents() {
        return smsEventWrappers;
    }

}
