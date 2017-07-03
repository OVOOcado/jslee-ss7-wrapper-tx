/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import org.mobicents.protocols.ss7.cap.api.primitives.BCSMEvent;
import org.mobicents.protocols.ss7.cap.api.service.sms.primitive.SMSEvent;

import pl.ovoo.ss7.wrapper.cap.args.BCSMEventWrapper;
import pl.ovoo.ss7.wrapper.cap.args.RequestReportBCSMEventArgWrapper;
import pl.ovoo.ss7.wrapper.cap.args.SMSEventWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.cap2.TxCap2BCSMEventWrapper;

import java.util.ArrayList;

/**
 * TxRequestReportBCSMEventArgWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxRequestReportBCSMEventArgWrapper implements RequestReportBCSMEventArgWrapper {

    private ArrayList<BCSMEvent> txBcsmEvents;

    @Override
    public void setBcsmEvents(final BCSMEventWrapper[] bcsmEvents) {
        if (bcsmEvents == null || bcsmEvents.length == 0) {
            return;
        }
        final ArrayList<BCSMEvent> bcsmEventsLocal = new ArrayList<BCSMEvent>();
        for (int i = 0; i < bcsmEvents.length; i++) {
            TxBCSMEventWrapper txBCSMEventWrapper = (TxBCSMEventWrapper) bcsmEvents[i];
            bcsmEventsLocal.add(txBCSMEventWrapper.getTxBcsmEvent());

        }
        this.txBcsmEvents = bcsmEventsLocal;
    }

    @Override
    public BCSMEventWrapper[] getBcsmEvents() {
        if (txBcsmEvents == null || txBcsmEvents.isEmpty()) {
            return null;
        } else {
            final BCSMEventWrapper[] bcsmEventWrappers = new BCSMEventWrapper[txBcsmEvents.size()];
            int i = 0;
            for (final BCSMEvent bcsmEvent : txBcsmEvents) {
                bcsmEventWrappers[i] = new TxCap2BCSMEventWrapper(bcsmEvent);
                i++;
            }
            return bcsmEventWrappers;
        }
    }

    public ArrayList<BCSMEvent> getTxBcsmEvents() {
        return txBcsmEvents;
    }

    public void setTxBcsmEvents(final ArrayList<BCSMEvent> txBcsmEvents) {
        this.txBcsmEvents = txBcsmEvents;
    }


}
