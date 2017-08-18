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

import org.mobicents.protocols.ss7.cap.api.primitives.TimeAndTimezone;
import pl.ovoo.jslee.ss7.wrapper.cap.args.TimeAndTimezoneWrapper;


/**
 * OcTimeAndTimezoneWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxTimeAndTimezoneWrapper implements TimeAndTimezoneWrapper {

    /** The time and timezone. */
    private final TimeAndTimezone timeAndTimezone;

    /**
     * Instantiates a new tx time and timezone wrapper.
     *
     * @param timeAndTimezone the time and timezone
     */
    public TxTimeAndTimezoneWrapper(final TimeAndTimezone timeAndTimezone) {
        this.timeAndTimezone = timeAndTimezone;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.TimeAndTimezoneWrapper#getYear()
     */
    @Override
    public int getYear() {
        return timeAndTimezone.getYear();
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.TimeAndTimezoneWrapper#getMonth()
     */
    @Override
    public int getMonth() {
        return timeAndTimezone.getMonth();
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.TimeAndTimezoneWrapper#getDay()
     */
    @Override
    public int getDay() {
        return timeAndTimezone.getDay();
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.TimeAndTimezoneWrapper#getHour()
     */
    @Override
    public int getHour() {
        return timeAndTimezone.getHour();
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.TimeAndTimezoneWrapper#getMinute()
     */
    @Override
    public int getMinute() {
        return timeAndTimezone.getMinute();
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.TimeAndTimezoneWrapper#getSecond()
     */
    @Override
    public int getSecond() {
        return timeAndTimezone.getSecond();
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.TimeAndTimezoneWrapper#getTimeZone()
     */
    @Override
    public int getTimeZone() {
        return timeAndTimezone.getTimeZone();
    }

    /**
     * Gets the tx time and timezone.
     *
     * @return the tx time and timezone
     */
    public TimeAndTimezone getTxTimeAndTimezone() {
        return timeAndTimezone;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TxTimeAndTimezoneWrapper [timeAndTimezone=" + timeAndTimezone + "]";
    }

}
