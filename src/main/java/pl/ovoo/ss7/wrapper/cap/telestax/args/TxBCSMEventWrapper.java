/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import org.mobicents.protocols.ss7.cap.api.primitives.BCSMEvent;
import pl.ovoo.ss7.wrapper.cap.args.BCSMEventWrapper;
import pl.ovoo.ss7.wrapper.cap.args.EventTypeBCSM;
import pl.ovoo.ss7.wrapper.cap.args.LegIDWrapper;
import pl.ovoo.ss7.wrapper.cap.args.MonitorMode;

/**
 * TxBCSMEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxBCSMEventWrapper implements BCSMEventWrapper {

    protected final BCSMEvent bcsmEvent;

    public TxBCSMEventWrapper(final BCSMEvent bcsmEvent) {
        this.bcsmEvent = bcsmEvent;
    }

    public BCSMEvent getTxBcsmEvent() {
        return bcsmEvent;
    }

    @Override
    public EventTypeBCSM getEventTypeBCSM() {
        if (bcsmEvent.getEventTypeBCSM() != null) {
            return EventTypeBCSM.valueOf(bcsmEvent.getEventTypeBCSM().getCode());
        }
        return null;
    }

    @Override
    public MonitorMode getMonitorMode() {
        if (bcsmEvent.getMonitorMode() != null) {
            return MonitorMode.valueOf(bcsmEvent.getMonitorMode().getCode());
        }
        return null;
    }

    @Override
    public boolean hasLegID() {
        return bcsmEvent.getLegID() != null;
    }

    @Override
    public LegIDWrapper getLegID() {
        if (bcsmEvent.getLegID() != null) {
            return new TxLegIDWrapper(bcsmEvent.getLegID());
        }
        return null;
    }
}
