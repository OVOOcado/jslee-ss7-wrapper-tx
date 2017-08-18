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

package pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap2;

import org.mobicents.protocols.ss7.cap.api.primitives.TimeAndTimezone;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxTimeAndTimezoneWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap1.TxCap1InitialDPArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.TimeAndTimezoneWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.cap2.Cap2InitialDPArgWrapper;


/**
 * TxCap2InitialDPArgWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCap2InitialDPArgWrapper extends TxCap1InitialDPArgWrapper implements Cap2InitialDPArgWrapper {

    /** The time and timezone wrapper. */
    private transient TimeAndTimezoneWrapper timeAndTimezoneWrapper = null;

    /** The time and timezone. */
    private TimeAndTimezone timeAndTimezone;

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.cap2.Cap2InitialDPArgWrapper#getTimeAndTimezone()
     */
    @Override
    public TimeAndTimezoneWrapper getTimeAndTimezone() {
        if (this.timeAndTimezoneWrapper == null && this.timeAndTimezone != null) {
            this.timeAndTimezoneWrapper = new TxTimeAndTimezoneWrapper(timeAndTimezone);
        }
        return this.timeAndTimezoneWrapper;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.cap2.Cap2InitialDPArgWrapper#setTimeAndTimezone(pl.ovoo.jslee.ss7.wrapper.cap.args.TimeAndTimezoneWrapper)
     */
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

    /**
     * Gets the tx time and timezone.
     *
     * @return the tx time and timezone
     */
    public TimeAndTimezone getTxTimeAndTimezone() {
        return timeAndTimezone;
    }

    /**
     * Sets the tx time and timezone.
     *
     * @param timeAndTimezone the new tx time and timezone
     */
    public void setTxTimeAndTimezone(final TimeAndTimezone timeAndTimezone) {
        this.timeAndTimezone = timeAndTimezone;
        this.timeAndTimezoneWrapper = null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxInitialDPArgWrapper#toString()
     */
    @Override
    public String toString() {
        return "TxCap2InitialDPArgWrapper [timeAndTimezone=" + timeAndTimezone + "]";
    }

}
