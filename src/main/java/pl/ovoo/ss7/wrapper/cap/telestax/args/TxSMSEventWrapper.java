/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import org.mobicents.protocols.ss7.cap.api.service.sms.primitive.SMSEvent;
import pl.ovoo.ss7.wrapper.cap.args.EventTypeSMS;
import pl.ovoo.ss7.wrapper.cap.args.MonitorMode;
import pl.ovoo.ss7.wrapper.cap.args.SMSEventWrapper;

/**
 * OcSMSEventWrapperImpl
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxSMSEventWrapper implements SMSEventWrapper {

    private final SMSEvent smsEvent;

    public TxSMSEventWrapper(final SMSEvent smsEvent) {
        this.smsEvent = smsEvent;
    }

    @Override
    public EventTypeSMS getEventTypeSMS() {
        return EventTypeSMS.valueOf(smsEvent.getEventTypeSMS().getCode());
    }

    @Override
    public MonitorMode getMonitorMode() {
        return MonitorMode.valueOf(smsEvent.getMonitorMode().getCode());
    }

    public SMSEvent getSMSEvent() {
        return smsEvent;
    }
}
