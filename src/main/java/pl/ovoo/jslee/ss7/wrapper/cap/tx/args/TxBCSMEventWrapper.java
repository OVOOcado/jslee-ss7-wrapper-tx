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

import org.mobicents.protocols.ss7.cap.api.primitives.BCSMEvent;
import pl.ovoo.jslee.ss7.wrapper.cap.args.BCSMEventWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.EventTypeBCSM;
import pl.ovoo.jslee.ss7.wrapper.cap.args.LegIDWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.MonitorMode;


/**
 * TxBCSMEventWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxBCSMEventWrapper implements BCSMEventWrapper {

    /** The bcsm event. */
    protected final BCSMEvent bcsmEvent;

    /**
     * Instantiates a new tx bcsm event wrapper.
     *
     * @param bcsmEvent the bcsm event
     */
    public TxBCSMEventWrapper(final BCSMEvent bcsmEvent) {
        this.bcsmEvent = bcsmEvent;
    }

    /**
     * Gets the tx bcsm event.
     *
     * @return the tx bcsm event
     */
    public BCSMEvent getTxBcsmEvent() {
        return bcsmEvent;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.BCSMEventWrapper#getEventTypeBCSM()
     */
    @Override
    public EventTypeBCSM getEventTypeBCSM() {
        if (bcsmEvent.getEventTypeBCSM() != null) {
            return EventTypeBCSM.valueOf(bcsmEvent.getEventTypeBCSM().getCode());
        }
        return null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.BCSMEventWrapper#getMonitorMode()
     */
    @Override
    public MonitorMode getMonitorMode() {
        if (bcsmEvent.getMonitorMode() != null) {
            return MonitorMode.valueOf(bcsmEvent.getMonitorMode().getCode());
        }
        return null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.BCSMEventWrapper#hasLegID()
     */
    @Override
    public boolean hasLegID() {
        return bcsmEvent.getLegID() != null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.BCSMEventWrapper#getLegID()
     */
    @Override
    public LegIDWrapper getLegID() {
        if (bcsmEvent.getLegID() != null) {
            return new TxLegIDWrapper(bcsmEvent.getLegID());
        }
        return null;
    }
}
