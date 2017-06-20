/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import org.mobicents.protocols.ss7.cap.api.primitives.TimeAndTimezone;
import pl.ovoo.ss7.wrapper.cap.args.TimeAndTimezoneWrapper;

/**
 * OcTimeAndTimezoneWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxTimeAndTimezoneWrapper implements TimeAndTimezoneWrapper {

    private final TimeAndTimezone timeAndTimezone;

    public TxTimeAndTimezoneWrapper(final TimeAndTimezone timeAndTimezone) {
        this.timeAndTimezone = timeAndTimezone;
    }

    @Override
    public int getYear() {
        return timeAndTimezone.getYear();
    }

    @Override
    public int getMonth() {
        return timeAndTimezone.getMonth();
    }

    @Override
    public int getDay() {
        return timeAndTimezone.getDay();
    }

    @Override
    public int getHour() {
        return timeAndTimezone.getHour();
    }

    @Override
    public int getMinute() {
        return timeAndTimezone.getMinute();
    }

    @Override
    public int getSecond() {
        return timeAndTimezone.getSecond();
    }

    @Override
    public int getTimeZone() {
        return timeAndTimezone.getTimeZone();
    }

    public TimeAndTimezone getTxTimeAndTimezone() {
        return timeAndTimezone;
    }

    @Override
    public String toString() {
        return "TxTimeAndTimezoneWrapper [timeAndTimezone=" + timeAndTimezone + "]";
    }

}
