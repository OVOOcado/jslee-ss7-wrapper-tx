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

package pl.ovoo.jslee.ss7.wrapper.map.tx.event;

import javax.slee.ActivityContextInterface;

import org.mobicents.slee.resource.map.events.ErrorComponent;
import org.mobicents.slee.resource.map.events.InvokeTimeout;

import pl.ovoo.jslee.ss7.wrapper.map.args.ErrorComponentWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.event.OperationErrorEventWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxErrorComponentWrapper;


/**
 * TxOperationErrorEventWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxOperationErrorEventWrapper extends TxMapEventWrapper implements OperationErrorEventWrapper {
    
    /** The operation error event. */
    private ErrorComponentWrapper operationErrorEvent = null;

    /** The tx operation error event. */
    final ErrorComponent txOperationErrorEvent;
    
    /** The invoke timeout. */
    final InvokeTimeout invokeTimeout;

    /**
     * Instantiates a new tx operation error event wrapper.
     *
     * @param operationErrorEvent the operation error event
     * @param aci the aci
     */
    public TxOperationErrorEventWrapper(final ErrorComponent operationErrorEvent, final ActivityContextInterface aci) {
        super(aci);
        this.txOperationErrorEvent = operationErrorEvent;
        this.invokeTimeout = null;
    }

    /**
     * Instantiates a new tx operation error event wrapper.
     *
     * @param invokeTimeout the invoke timeout
     * @param aci the aci
     */
    public TxOperationErrorEventWrapper(final InvokeTimeout invokeTimeout, final ActivityContextInterface aci) {
        super(aci);
        this.txOperationErrorEvent = null;
        this.invokeTimeout = invokeTimeout;
    }
    
    /**
     * Gets the tx operation error event.
     *
     * @return the tx operation error event
     */
    public ErrorComponent getTxOperationErrorEvent() {
        return txOperationErrorEvent;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.event.MapEventWrapper#getInvokeId()
     */
    @Override
    public long getInvokeId(){
    	return txOperationErrorEvent.getInvokeId();
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.event.OperationErrorEventWrapper#getOperationErrorEvent()
     */
    @Override
    public ErrorComponentWrapper getOperationErrorEvent() {
        if (this.operationErrorEvent == null && txOperationErrorEvent != null){
            this.operationErrorEvent = new TxErrorComponentWrapper(txOperationErrorEvent.getMAPErrorMessage());
        }
        return this.operationErrorEvent;
    }
}
