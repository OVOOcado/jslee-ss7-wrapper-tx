/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args.cap2;

import org.mobicents.protocols.ss7.cap.api.primitives.TimeAndTimezone;
import pl.ovoo.ss7.wrapper.cap.args.TimeAndTimezoneWrapper;
import pl.ovoo.ss7.wrapper.cap.args.cap2.Cap2InitialDPArgWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxTimeAndTimezoneWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.cap1.TxCap1InitialDPArgWrapper;

/**
 * TxCap2InitialDPArgWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCap2InitialDPArgWrapper extends TxCap1InitialDPArgWrapper implements Cap2InitialDPArgWrapper {

    private transient TimeAndTimezoneWrapper timeAndTimezoneWrapper = null;

    private TimeAndTimezone timeAndTimezone;

    @Override
    public TimeAndTimezoneWrapper getTimeAndTimezone() {
        if (this.timeAndTimezoneWrapper == null && this.timeAndTimezone != null) {
            this.timeAndTimezoneWrapper = new TxTimeAndTimezoneWrapper(timeAndTimezone);
        }
        return this.timeAndTimezoneWrapper;
    }

    @Override
    public void setTimeAndTimezone(final TimeAndTimezoneWrapper timeAndTimezone) {
        if (timeAndTimezone == null) {
            this.timeAndTimezone = null;
            this.timeAndTimezoneWrapper = null;
        } else {
            final TxTimeAndTimezoneWrapper txTimeAndTimezoneWrapper = (TxTimeAndTimezoneWrapper) timeAndTimezone;
            this.timeAndTimezone = txTimeAndTimezoneWrapper.getTxTimeAndTimezone();
            this.timeAndTimezoneWrapper = txTimeAndTimezoneWrapper;
        }
    }

    public TimeAndTimezone getTxTimeAndTimezone() {
        return timeAndTimezone;
    }

    public void setTxTimeAndTimezone(final TimeAndTimezone timeAndTimezone) {
        this.timeAndTimezone = timeAndTimezone;
        this.timeAndTimezoneWrapper = null;
    }

    @Override
    public String toString() {
        return "TxCap2InitialDPArgWrapper [timeAndTimezone=" + timeAndTimezone + "]";
    }

}
