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

/**
 * TxInvokeTimeoutEventWrapper.java
 *  
 * @author adam.skimina@ovoo.pl
 */
package pl.ovoo.jslee.ss7.wrapper.cap.tx.event;

import javax.slee.ActivityContextInterface;

import org.mobicents.slee.resource.cap.events.InvokeTimeout;

import pl.ovoo.jslee.ss7.wrapper.cap.event.InvokeTimeoutEventWrapper;


/**
 * TxInvokeTimeoutEventWrapper.
 *
 * @author adam.skimina@ovoo.pl
 */
public class TxInvokeTimeoutEventWrapper extends TxEventWrapper implements InvokeTimeoutEventWrapper {

    /** The invoke timeout. */
    private final InvokeTimeout invokeTimeout;

    /**
     * Instantiates a new tx invoke timeout event wrapper.
     *
     * @param invokeTimeout the invoke timeout
     * @param aci the aci
     */
    public TxInvokeTimeoutEventWrapper(final InvokeTimeout invokeTimeout, final ActivityContextInterface aci) {
        super(aci, invokeTimeout.getWrappedEvent());
        this.invokeTimeout = invokeTimeout;
    }

}
