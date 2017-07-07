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

import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap2.TxCap2BCSMEventWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.BCSMEventWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.RequestReportBCSMEventArgWrapper;

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
