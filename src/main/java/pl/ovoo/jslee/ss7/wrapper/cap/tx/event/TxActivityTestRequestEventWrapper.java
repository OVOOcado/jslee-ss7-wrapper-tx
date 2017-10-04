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

package pl.ovoo.jslee.ss7.wrapper.cap.tx.event;

import javax.slee.ActivityContextInterface;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.ActivityTestRequest;

import pl.ovoo.jslee.ss7.wrapper.cap.event.ActivitiyTestRequestEventWrapper;

/**
 * TxActivityTestRequestEventWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxActivityTestRequestEventWrapper extends TxEventWrapper implements ActivitiyTestRequestEventWrapper {

    /** The activity test request event. */
    private final ActivityTestRequest activity;

    /**
     * Instantiates a new tx activity test request event wrapper.
     * 
     * @param aci the aci
     * @param activity the activity test request
     */
    public TxActivityTestRequestEventWrapper(ActivityContextInterface aci, ActivityTestRequest activity) {
        super(aci, activity);
        this.activity = activity;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.tx.event.TxActivityTestRequestEventWrapper#getInvokeId()
     */
    public Long getInvokeId() {
        if (activity != null) {
            return activity.getInvokeId();
        } else
            return null;
    }
}
